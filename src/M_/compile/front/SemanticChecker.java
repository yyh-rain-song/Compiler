package M_.compile.front;

import M_.AST.*;
import M_.Symbol.*;
import M_.compile.ErrorRecorder;

public class SemanticChecker implements IAstVisitor {
    private GlobalSymbolTable ST;
    private ErrorRecorder errorRecorder;
    private FuncionSymbol curFunction;
    private int loop;

    public SemanticChecker(GlobalSymbolTable st, ErrorRecorder recorder)
    {
        this.ST = st;
        this.errorRecorder = recorder;
        this.loop = 0;
    }

    @Override
    public void visit(Program node){
        if(node.globalVariables != null)
            for(VariableDeclaration var: node.globalVariables)
                var.accept(this);
        if(node.functions != null)
            for(FuncDeclaration fun: node.functions)
                fun.accept(this);
        if(node.classes != null)
            for(ClassDeclaration cc: node.classes)
                cc.accept(this);
        //find main function
        FuncionSymbol Main = ST.getFunctionSymbol("main");
        if(Main == null)
            errorRecorder.addRecord(node.location, "main function not found");
        else if(Main.returnType instanceof PrimitiveType && ((PrimitiveType) Main.returnType).name.equals("int"))
        {
            if(Main.parameterNames != null && Main.parameterNames.size() > 0)
                errorRecorder.addRecord(Main.location, "we dont't support main function with any parameter");
        }
        else
            errorRecorder.addRecord(Main.location, "main function must return int");
    }
    @Override
    public void visit(Declaration node){
        assert false;
    }
    @Override
    public void visit(FuncDeclaration node){
        curFunction = node.symbol;
        for(Statement st: node.body.statements)
            st.accept(this);
    }
    @Override
    public void visit(ClassDeclaration node){
        if(node.methods != null)
            for(FuncDeclaration fun: node.methods)
                fun.accept(this);
        if(node.constructor != null)
        {
            node.constructor.accept(this);
            if(!node.constructor.name.equals(node.name))
                errorRecorder.addRecord(node.constructor.location, "constructor must have same name with class");
        }
    }
    @Override
    public void visit(VariableDeclaration node){
        if(node.init != null && !node.symbol.type.match(node.init.type))
            errorRecorder.addRecord(node.init.location, "initStatement expression type miss match with the variable");
    }
    @Override
    public void visit(TypeNode node){ }
    @Override
    public void visit(ArrayTypeNode node){ }
    @Override
    public void visit(BasicTypeNode node){ }
    @Override
    public void visit(ClassTypeNode node){ }
    @Override
    public void visit(Statement node){ assert false; }
    @Override
    public void visit(EmptyStatement node){ }
    @Override
    public void visit(ForStatement node){
        if(node.initStatement != null)
            node.initStatement.accept(this);
        if(node.condition != null) {
            node.condition.accept(this);
            checkBool(node.condition);
        }
        if(node.updateStatement != null)
            node.updateStatement.accept(this);
        ++loop;
        node.body.accept(this);
        --loop;

    }
    private void checkBool(Expression e){
        if(e.type instanceof PrimitiveType && ((PrimitiveType) e.type).name.equals("bool"))
            return;
        else
            errorRecorder.addRecord(e.location, "condition must be bool");
    }
    @Override
    public void visit(WhileStatement node){
        node.condition.accept(this);
        checkBool(node.condition);
        ++loop;
        node.body.accept(this);
        --loop;
    }
    @Override
    public void visit(IfStatement node){
        node.condition.accept(this);
        checkBool(node.condition);
        node.ifStatement.accept(this);
        if(node.elseStatement != null)
            node.elseStatement.accept(this);
    }
    @Override
    public void visit(ContinueStatement node){
        if(loop == 0)
            errorRecorder.addRecord(node.location, "not in a loop");
    }
    @Override
    public void visit(BreakStatement node){
        if(loop == 0)
            errorRecorder.addRecord(node.location, "not in a loop");
    }
    @Override
    public void visit(ReturnStatement node){
        VariableType requireType = curFunction.returnType;
        PrimitiveType Void = new PrimitiveType("void", ST.getBaseSymbol("void"));
        if(requireType == null && node.retExpression == null)
            return;
        if(requireType.match(Void) && node.retExpression != null)
            errorRecorder.addRecord(node.location, "void return can not have any expression");
        VariableType returnType;
        if(node.retExpression == null)
            returnType = Void;
        else
            returnType = node.retExpression.type;
        if(!returnType.match(requireType))
            errorRecorder.addRecord(node.location, "return type doesn't match the required one");
    }
    @Override
    public void visit(BlockStatement node){
        for(Statement stm: node.statements)
            stm.accept(this);
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
        node.modifiable = !node.name.equals("this");
    }
    @Override
    public void visit(ConstExpression node){
        node.modifiable = false;
    }
    @Override
    public void visit(ArrayExpression node){
        node.address.accept(this);
        node.index.accept(this);
        node.modifiable = true;
    }
    @Override
    public void visit(FuncCallExpression node){
        int parameters = node.functionSymbol.parameterTypes != null ?
                node.functionSymbol.parameterTypes.size(): 0;
        int inClass = (node.functionSymbol.parameterNames != null && node.functionSymbol.parameterNames.size() > 0 &&
                            node.functionSymbol.parameterNames.get(0).equals("this"))? 1:0;
        int argumentSize = (node.arguments != null) ? node.arguments.size() : 0;
        if(argumentSize + inClass != parameters)
            errorRecorder.addRecord(node.location, "the number of argument miss match the required");
        else{
            if(node.arguments != null)
                for(int i = 0; i < node.arguments.size(); i++)
                {
                    node.arguments.get(i).accept(this);
                    if(!node.arguments.get(i).type.match(node.functionSymbol.parameterTypes.get(i+inClass)))
                        errorRecorder.addRecord(node.arguments.get(i).location, "the type miss match the required one");
                }
        }
        node.modifiable = false;
    }
    @Override
    public void visit(NewExpression node){
        for(Expression e: node.exprDimensions)
            e.accept(this);
        node.modifiable = true;
    }
    @Override
    public void visit(MemberExpression node){
        node.object.accept(this);
        if(node.object.type instanceof ArrayType)
            node.modifiable = false;
        else
        {
            if(node.methodCall != null)
            {
                node.methodCall.accept(this);
                node.modifiable = node.methodCall.modifiable;
            }
            else node.modifiable = true;
        }
    }
    private boolean isStringType(VariableType type){
        return type instanceof ClassType && ((ClassType) type).name.equals("string");
    }
    private boolean isIntType(VariableType type){
        return type instanceof PrimitiveType && ((PrimitiveType) type).name.equals("int");
    }
    private boolean isBoolType(VariableType type){
        return type instanceof PrimitiveType && ((PrimitiveType) type).name.equals("bool");
    }
    @Override
    public void visit(OpExpression node){
        node.expression.accept(this);
        boolean isInt = isIntType(node.expression.type);
        boolean isBool = isBoolType(node.expression.type);
        switch (node.op)
        {
            case " ++" : case " --":
                if(!node.expression.modifiable)
                    errorRecorder.addRecord(node.location, "this expression is not modifiable");
                if(!isInt)
                    errorRecorder.addRecord(node.location, "invalid operation on this type");
                node.modifiable = false;
                break;
            case "++ ": case "-- ":
                if(!node.expression.modifiable)
                    errorRecorder.addRecord(node.location, "this expression is not modifiable");
                if(!isInt)
                    errorRecorder.addRecord(node.location, "invalid operation on this type");
                node.modifiable = true;
                break;
            case "!":
                if(!isBool)
                    errorRecorder.addRecord(node.location, "invalid operation on this type");
                node.modifiable = false;
                break;
            case "~":
                if(!isInt)
                    errorRecorder.addRecord(node.location, "invalid operation on this type");
                node.modifiable = false;
                break;
            default:
                assert false;
        }
    }
    @Override
    public void visit(BinaryExpression node){
        node.lhs.accept(this);
        node.rhs.accept(this);
        if(node.lhs.type == null)
            System.err.println("lhs null");
        else if(node.rhs.type == null)
            System.err.println("rhs null");
        if(!node.lhs.type.match(node.rhs.type))
            errorRecorder.addRecord(node.location, "type miss match for binary operand");
        else
        {
            boolean isInt = isIntType(node.lhs.type);
            boolean isBool = isBoolType(node.lhs.type);
            boolean isString = isStringType(node.lhs.type);
            switch (node.op)
            {
                case "*": case "/" : case "%" : case "&": case "|": case "<<" : case ">>": case "`": case "-":
                    if(!isInt)
                        errorRecorder.addRecord(node.location, "can not do that with other type except int");
                    break;
                case "<=": case ">=": case "<": case ">": case "+":
                    if(!isInt && !isString)
                        errorRecorder.addRecord(node.location, "type miss match with the operand");
                    break;
                case "||": case "&&":
                    if(!isBool)
                        errorRecorder.addRecord(node.location, "type miss match with the operand");
                    break;
                case "==": case "!=":
                    break;
                default:
                    assert false;
            }
        }
        node.modifiable = false;
    }
    @Override
    public void visit(ConditionalExpression node){
        node.condition.accept(this);
        checkBool(node.condition);
        node.exprTrue.accept(this);
        node.exprFalse.accept(this);
        if(!node.exprFalse.type.match(node.exprTrue.type))
            errorRecorder.addRecord(node.exprTrue.location, "expression type miss match");
        node.modifiable = false;
    }
    @Override
    public void visit(AssignExpression node){
        node.lhs.accept(this);
        node.rhs.accept(this);
        if(!node.lhs.type.match(node.rhs.type))
            errorRecorder.addRecord(node.lhs.location, "type conflict in assign expression");
        if(!node.lhs.modifiable)
            errorRecorder.addRecord(node.location, "lhs value must be modifiable");
        node.modifiable = false;
    }
}
