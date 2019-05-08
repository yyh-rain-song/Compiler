package M_.compile.front;

import M_.AST.*;
import M_.Symbol.*;
import M_.compile.ErrorRecorder;

import java.util.HashMap;

/*
* Remember that we have a symbol lhs empty in AST node when building the AST? (In FuncDelc, ClassDecl, VarDecl)
* Now it's time to fill them.
* Resolve AST node into a symbol & add them into symbol tables with hierarchy
* (of course complete type checking in the methods)
* So what's symbol?
* Symbol stores all information about a declaration.(For example, class name, methods, fields etc)
* The global ST stays at the top layer.
* To find something inside (for example, a class member), we should: 1.find symbol from global ST; 2.get its local ST
* Sounds wonderful, rhs? Then let's start!------(by exhausted yyh)
* */
public class STBuilder implements IAstVisitor {
    public ErrorRecorder errorRecorder;
    public GlobalSymbolTable globalSymbolTable;
    public SymbolTable currentST;

    public FuncionSymbol curFunction;
    public HashMap<SymbolTable, ClassSymbol> ST_Class;
    private String name;

    public STBuilder(ErrorRecorder er){
        errorRecorder = er;
        globalSymbolTable = new GlobalSymbolTable();
        currentST = globalSymbolTable;
        this.ST_Class = new HashMap<>();
    }
    private void enter(SymbolTable st){
        currentST = st;
    }
    private void leave(){
        currentST = currentST.parent;
        assert (currentST != null);
    }
    //find in global ST
    //TypeNode->VariableType
    private VariableType resolveVariableType(TypeNode node){
        if(node instanceof BasicTypeNode)
        {
            String Name = ((BasicTypeNode) node).name;
            BaseSymbol symbol = globalSymbolTable.getBaseSymbol(Name);//the basic type has already been add into global ST
            if(symbol != null)
                return new PrimitiveType(symbol.name, symbol);
            else return null;
        }
        else if(node instanceof ClassTypeNode)
        {
            ClassSymbol symbol = globalSymbolTable.getClassSymbol(((ClassTypeNode) node).className);
            if(symbol != null)
                return new ClassType(symbol.name, symbol);
            else return null;
        }
        else if(node instanceof ArrayTypeNode)
        {
            ArrayTypeNode old = (ArrayTypeNode)node;
            VariableType base;
            if(old.dimension == 1)
            {
                base = resolveVariableType(old.baseType);
                if(old.baseType instanceof BasicTypeNode && ((BasicTypeNode) old.baseType).name.equals("void"))
                    errorRecorder.addRecord(old.location, "can not create an array with type void");
            }
            else{
                ArrayTypeNode new_ = new ArrayTypeNode();
                new_.baseType = old.baseType;
                new_.dimension = old.dimension - 1;
                base = resolveVariableType(new_);
            }
            if(base != null)
                return new ArrayType(base);
            else return null;
        }
        else
        {
            assert false;
            return null;
        }
    }
    //find variable symbol in a specific ST
    private VariableSymbol resolveVariableSymbol(String name, SymbolTable ST){
        VariableSymbol symbol = ST.getVariableSymbol(name);
        if(symbol != null)
            return symbol;
        else{
            if(ST.parent != null)
                return resolveVariableSymbol(name, ST.parent);
            else return null;
        }
    }

    private VariableSymbol resolveVariableSymbol(String name){
        return resolveVariableSymbol(name, currentST);
    }

    //find function symbol in a specific ST
    private FuncionSymbol resolveFuncSymbol(String name, SymbolTable ST){
        FuncionSymbol symbol = ST.getFunctionSymbol(name);
        if(symbol != null)
            return symbol;
        else{
            if(ST.parent != null)
                return resolveFuncSymbol(name, ST.parent);
            else return null;
        }
    }

    private FuncionSymbol resolveFuncSymbol(String name){
        this.name = name;
        return resolveFuncSymbol(name, currentST);
    }

    //put a new class into global ST (the local class ST hasn't been built yet)
    private void registerClass(ClassDeclaration classDeclaration){
        if(globalSymbolTable.getClassSymbol(classDeclaration.name) != null)
        {
            errorRecorder.addRecord(classDeclaration.location, "the class has been defined");
            return;
        }
        if(globalSymbolTable.getFunctionSymbol(classDeclaration.name) != null)
        {
            errorRecorder.addRecord(classDeclaration.location, "the class name conflict with a function name.");
            return;
        }
        ClassSymbol symbol = new ClassSymbol();
        symbol.name = classDeclaration.name;
        symbol.location = classDeclaration.location;
        symbol.classSymbolTable = new SymbolTable(globalSymbolTable);//the parent is global ST
        classDeclaration.symbol = symbol;
        ST_Class.put(symbol.classSymbolTable, symbol);
        globalSymbolTable.putClassSymbol(symbol.name, symbol);
    }
    //put class functions into class ST
    private void registerClassFunctions(ClassDeclaration classDeclaration){
        ClassSymbol symbol = globalSymbolTable.getClassSymbol(classDeclaration.name);
        enter(symbol.classSymbolTable);
        if(classDeclaration.constructor != null)
            registerFunction(classDeclaration.constructor, symbol);
        if(classDeclaration.methods != null)
            for(FuncDeclaration ff: classDeclaration.methods)
                registerFunction(ff, symbol);
        leave();
    }
    //put member into class ST
    private void defineClassFields(ClassDeclaration classDeclaration){
        ClassSymbol symbol = globalSymbolTable.getClassSymbol(classDeclaration.name);
        enter(symbol.classSymbolTable);
        if(classDeclaration.member != null)
            for(VariableDeclaration d: classDeclaration.member)
                defineVariable(d);
        leave();
    }

    private void defineClassFunctions(ClassDeclaration classDeclaration){
        ClassSymbol symbol = globalSymbolTable.getClassSymbol(classDeclaration.name);
        enter(symbol.classSymbolTable);
        if(classDeclaration.constructor != null)
            defineFunction(classDeclaration.constructor, symbol);
        if(classDeclaration.methods != null)
            for(FuncDeclaration d: classDeclaration.methods)
                defineFunction(d, symbol);
        leave();
    }

    //add function to ST
    private void registerFunction(FuncDeclaration function, ClassSymbol symbol) {
        if(currentST.getFunctionSymbol(function.name) != null)
        {
            errorRecorder.addRecord(function.location, "the function has been defined");
            return;
        }
        if(symbol == null && globalSymbolTable.getClassSymbol(function.name) != null)
        {
            errorRecorder.addRecord(function.location, "the function conflicts with the name of a class");
            return;
        }
        FuncionSymbol funcionSymbol = new FuncionSymbol();
        funcionSymbol.name = (symbol == null ? "" : symbol.name + ".") + function.name;
        funcionSymbol.location = function.location;
        funcionSymbol.isGlobalFunction = (symbol == null);
        if(function.returnTypeNode != null)
            funcionSymbol.returnType = resolveVariableType(function.returnTypeNode);
        if(funcionSymbol.returnType == null && function.returnTypeNode != null)
            errorRecorder.addRecord(function.location, "can not resolve type");
        funcionSymbol.functionSymbolTable = null;
        if(symbol != null){
            funcionSymbol.parameterNames.add("this");
            funcionSymbol.parameterTypes.add(new ClassType(symbol.name, symbol));
        }
        if(function.parameters != null)
        {
            for(VariableDeclaration d: function.parameters){
                funcionSymbol.parameterNames.add(d.name);
                VariableType type = resolveVariableType(d.typeNode);
                if(type == null)
                    errorRecorder.addRecord(d.location, "can not resolve the type of parameter");
                funcionSymbol.parameterTypes.add(type);
            }
        }
        function.symbol = funcionSymbol;
        currentST.putFunctionSymbol(function.name, funcionSymbol);
    }
    private void defineVariable(VariableDeclaration var){
        VariableType type = resolveVariableType(var.typeNode);
        if(var.init != null)
            var.init.accept(this);
        if(type != null)
        {
            if(currentST.getVariableSymbol(var.name) != null)
                errorRecorder.addRecord(var.location, "the variable has been defined");
            else
            {
                if(type instanceof PrimitiveType && ((PrimitiveType) type).name.equals("void"))
                    errorRecorder.addRecord(var.location, "can not define a void type");
                else if(type instanceof ClassType && ((ClassType) type).name.equals("null"))
                    errorRecorder.addRecord(var.location, "can not define a null type");

                boolean isClassField = ST_Class.containsKey(currentST);
                boolean isGlobalVariable = currentST == globalSymbolTable;
                var.symbol = new VariableSymbol(var.name, type, var.location, isClassField, isGlobalVariable);
                currentST.putVariableSymbol(var.name, var.symbol);
                if(isGlobalVariable && var.init != null)
                    globalSymbolTable.globalInitUsedVariables.add(var.symbol);
            }
        }
        else errorRecorder.addRecord(var.typeNode.location, "can not resolve type");
    }

    //add parameters inside the function table
    private void defineFunction(FuncDeclaration ff, ClassSymbol symbol){
        FuncionSymbol funcionSymbol = currentST.getFunctionSymbol(ff.name);
        curFunction = funcionSymbol;

        funcionSymbol.functionSymbolTable = new SymbolTable(currentST);
        enter(funcionSymbol.functionSymbolTable);
        if(symbol != null)
            defineVariable(new VariableDeclaration(new ClassTypeNode(symbol.name), "this", null));
        if(ff.parameters != null)
            for(VariableDeclaration var: ff.parameters)
                defineVariable(var);
        for(Statement s: ff.body.statements)
            s.accept(this);
        leave();

        curFunction = null;
        funcionSymbol.finish();
    }

    @Override
    public void visit(Program node){
        if(node.classes != null)
        {
            for(ClassDeclaration cc: node.classes) {
                registerClass(cc);
            }
        }
        if(node.functions != null)
        {
            for(FuncDeclaration ff: node.functions)
                registerFunction(ff, null);
        }
        if(errorRecorder.hasError()) return;

        if(node.classes != null)
            for(ClassDeclaration cc: node.classes) {
                defineClassFields(cc);
                registerClassFunctions(cc);
            }
        if(node.declarations != null)
        {
            for(Declaration d: node.declarations)
            {
                 if(d instanceof VariableDeclaration)
                     defineVariable((VariableDeclaration)d);
                 if(d instanceof ClassDeclaration)
                     defineClassFunctions((ClassDeclaration)d);
                 if(d instanceof FuncDeclaration)
                     defineFunction((FuncDeclaration)d, null);
            }
        }
    }

    @Override
    public void visit(Declaration node){
        assert false;
    }
    @Override
    public void visit(FuncDeclaration node){ }
    @Override
    public void visit(ClassDeclaration node){ }
    @Override
    public void visit(VariableDeclaration node){ defineVariable(node);}

    @Override
    public void visit(TypeNode node){ }
    @Override
    public void visit(ArrayTypeNode node){ }
    @Override
    public void visit(BasicTypeNode node){ }
    @Override
    public void visit(ClassTypeNode node){ }
    @Override
    public void visit(Statement node){
        assert false;
    }
    @Override
    public void visit(EmptyStatement node){ }
    @Override
    public void visit(ForStatement node){
        if(node.initStatement != null) node.initStatement.accept(this);
        if(node.updateStatement != null) node.updateStatement.accept(this);
        if(node.condition != null) node.condition.accept(this);
        node.body.accept(this);
    }
    @Override
    public void visit(WhileStatement node){
        node.condition.accept(this);
        node.body.accept(this);
    }
    @Override
    public void visit(IfStatement node){
        node.condition.accept(this);
        node.ifStatement.accept(this);
        if(node.elseStatement != null)
            node.elseStatement.accept(this);
    }
    @Override
    public void visit(ContinueStatement node){ }
    @Override
    public void visit(BreakStatement node){ }
    @Override
    public void visit(ReturnStatement node){
        if(node.retExpression != null)
            node.retExpression.accept(this);
    }
    @Override
    public void visit(BlockStatement node){
        SymbolTable st = new SymbolTable(currentST);//a block statement means a new ST
        enter(st);
        for(Statement ss: node.statements)
            ss.accept(this);
        leave();
    }
    @Override
    public void visit(DeclarationStm node){
        node.declaration.accept(this);
    }
    @Override
    public void visit(ExprStatement node){
        node.expression.accept(this);
    }
    @Override
    public void visit(Expression node){
        assert false;
    }
    @Override
    public void visit(Identifier node){
        VariableSymbol symbol = resolveVariableSymbol(node.name);
        if(symbol == null)
        {
            errorRecorder.addRecord(node.location, "can not resolve variable '" + node.name + "'");
            node.type = null;
            return;
        }
        node.symbol = symbol;
        node.type = symbol.type;
        if(symbol.isGlobalVariable){
            if(curFunction == null)
                globalSymbolTable.globalInitUsedVariables.add(symbol);
            else{
                curFunction.usedGlobalVariables.add(symbol);
                curFunction.withSideEffect = true;
            }
        }
    }
    @Override
    public void visit(ConstExpression node){
        switch (node.typeName){
            case "int":
                node.type = new PrimitiveType("int", globalSymbolTable.getBaseSymbol("int"));
                break;
            case "null":
                node.type = new ClassType("null", globalSymbolTable.getClassSymbol("null"));
                break;
            case "bool":
                node.type = new PrimitiveType("bool", globalSymbolTable.getBaseSymbol("bool"));
                break;
            case "string":
                node.type = new ClassType("string", globalSymbolTable.getClassSymbol("string"));
                break;
            default:
                    assert false;
        }
    }
    @Override
    public void visit(ArrayExpression node){
        node.address.accept(this);
        node.index.accept(this);
        if(node.address.type instanceof ArrayType)
            node.type = ((ArrayType) node.address.type).baseType;
        else{
            node.type = null;
            errorRecorder.addRecord(node.location, "array index expression with an no-array object");
        }
    }
    @Override
    public void visit(FuncCallExpression node){
        FuncionSymbol symbol = resolveFuncSymbol(node.functionName);
        if(symbol == null)
        {
            errorRecorder.addRecord(node.location, "can not resolve function '" + node.functionName + "'");
            return;
        }
        if(node.arguments != null)
            for(Expression e: node.arguments)
                e.accept(this);
        node.type = symbol.returnType;
        node.functionSymbol = symbol;
        if(curFunction != null)
            curFunction.calleeSet.add(symbol);
    }
    @Override
    public void visit(NewExpression node){
        if(node.exprDimensions != null)
            for(Expression e: node.exprDimensions)
                e.accept(this);
        int dimension = node.exprDimensions.size() + node.restDimension;
        node.type = resolveVariableType(node.typeNode);
        if(node.type == null)
        {
            errorRecorder.addRecord(node.typeNode.location, "can not resolve the type");
            node.type = null;
            return;
        }
        if(dimension == 0 && node.typeNode instanceof BasicTypeNode
                && ((BasicTypeNode) node.typeNode).name.equals("void"))
            errorRecorder.addRecord(node.location, "can not new a void");
        for(int i = 0; i < dimension; i++)
            node.type = new ArrayType(node.type);
    }
    @Override
    public void visit(MemberExpression node){
        node.object.accept(this);
        if(node.object.type instanceof PrimitiveType)
        {
            errorRecorder.addRecord(node.object.location, "the expression is not a class instance");
            node.type = null;
            return;
        }
        if(node.object.type instanceof ArrayType){
            if(node.methodCall == null || !node.methodCall.functionName.equals("size"))
            {
                errorRecorder.addRecord(node.location, "array type can only call size");
                node.type = null;
            }
            else
                node.type = new PrimitiveType("int", globalSymbolTable.getBaseSymbol("int"));
        }
        else
        {
            ClassType classType = (ClassType)node.object.type;
            if(node.fieldAccess != null)
            {
                node.fieldAccess.symbol = resolveVariableSymbol(node.fieldAccess.name, classType.symbol.classSymbolTable);
                if(node.fieldAccess.symbol == null)
                {
                    errorRecorder.addRecord(node.fieldAccess.location, "class '" + classType.name
                    + "' doesn't have field '" + node.fieldAccess.name + "'");
                    node.type = null;
                    return;
                }
                node.fieldAccess.type = node.fieldAccess.symbol.type;
                node.type = node.fieldAccess.type;
            }
            else
            {
                node.methodCall.functionSymbol = resolveFuncSymbol(node.methodCall.functionName, classType.symbol.classSymbolTable);
                if(node.methodCall.functionSymbol == null)
                {
                    errorRecorder.addRecord(node.methodCall.location, "class '" + classType.name
                            + "' doesn't have method '" + node.methodCall.functionName + "'");
                    node.type = null;
                    return;
                }
                node.methodCall.type = node.methodCall.functionSymbol.returnType;
                node.type = node.methodCall.type;
                for(Expression e: node.methodCall.arguments)
                    e.accept(this);
            }
        }
    }
    @Override
    public void visit(OpExpression node){
        node.expression.accept(this);
        node.type = node.expression.type;
    }
    private boolean isRelationOp(String op){
        switch (op){
            case "==": case "!=": case "<": case ">": case "<=": case ">=":
                return true;
            default:
                return false;
        }
    }
    @Override
    public void visit(BinaryExpression node){
        node.lhs.accept(this);
        node.rhs.accept(this);
        if(isRelationOp(node.op))
            node.type = new PrimitiveType("bool", globalSymbolTable.getBaseSymbol("bool"));
        else
            node.type = node.lhs.type;
    }
    @Override
    public void visit(ConditionalExpression node){
        node.condition.accept(this);
        node.exprTrue.accept(this);
        node.exprFalse.accept(this);
        node.type = node.exprTrue.type;
    }
    @Override
    public void visit(AssignExpression node){
        node.lhs.accept(this);
        node.rhs.accept(this);
        node.type = node.lhs.type;
    }
}
