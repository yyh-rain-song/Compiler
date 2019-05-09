package M_.compile.front;

import M_.AST.*;
import M_.Parser.*;
import M_.compile.ErrorRecorder;

import java.util.LinkedList;
import java.util.List;

public class ASTBuilder extends M_BaseVisitor<Object> {
    public Program program;
    public ErrorRecorder errorRecorder;

    public ASTBuilder(ErrorRecorder recorder){
        this.program = new Program();
        this.program.location = new Location(0,0);
        this.errorRecorder = recorder;
    }

    @Override
    public Object visitStart(M_Parser.StartContext ctx)
    {
        for(M_Parser.Program_unitContext decl:ctx.program_unit()){
            program.add(visitProgram_unit(decl));
        }
        return null;
    }
    @Override public Declaration visitProgram_unit(M_Parser.Program_unitContext ctx)
    {
        if(ctx.class_defination() != null)
            return visitClass_defination(ctx.class_defination());
        else if(ctx.variable_defination() != null)
            return visitVariable_defination(ctx.variable_defination());
        else return visitFunction_defination(ctx.function_defination());
    }
    @Override public VariableDeclaration visitVariable_defination(M_Parser.Variable_definationContext ctx)
    {
        TypeNode type = visitClass_type(ctx.class_type());
        String name = visitVariable_name(ctx.variable_name());
        Expression init = null;
        if(ctx.init_expr() != null)
            init = visitInit_expr(ctx.init_expr());
        VariableDeclaration vd =  new VariableDeclaration(type, name, init);
        vd.location = new Location(ctx.start);
        return vd;
    }

    @Override public Expression visitInit_expr(M_Parser.Init_exprContext ctx)
    {
        return (Expression) ctx.statement().accept(this);
    }

    @Override public String visitVariable_name(M_Parser.Variable_nameContext ctx)
    {
        return ctx.getText();
    }
    @Override public NewExpression visitMalloc(M_Parser.MallocContext ctx)
    {
        NewExpression exp = new NewExpression();
        exp.typeNode = (TypeNode)ctx.type().accept(this);
        exp.exprDimensions = new LinkedList<>();
        if(ctx.empty() != null)
            exp.restDimension = ctx.empty().size();
        else exp.restDimension = 0;
        if(ctx.statement() != null){
            for(M_Parser.StatementContext stm: ctx.statement())
                exp.exprDimensions.add((Expression)stm.accept(this));
        }
        exp.location = new Location(ctx.start);
        return exp;
    }

    @Override public TypeNode visitClass_type(M_Parser.Class_typeContext ctx)
    {
        if(ctx.class_type() != null)//this is an array
        {
            TypeNode last = visitClass_type(ctx.class_type());
            ArrayTypeNode this_ = new ArrayTypeNode();
            if(last instanceof BasicTypeNode || last instanceof ClassTypeNode)
            {
                this_.baseType = last;
                this_.dimension = 1;
            }
            else{
                this_.baseType = ((ArrayTypeNode)last).baseType;
                this_.dimension = ((ArrayTypeNode)last).dimension + 1;
            }
            this_.location = new Location(ctx.start);
            return this_;
        }
        else return (TypeNode) ctx.type().accept(this);
    }

    @Override public BasicTypeNode visitInt(M_Parser.IntContext ctx)
    {
        return new BasicTypeNode("int");
    }

    @Override public ClassTypeNode visitString(M_Parser.StringContext ctx)
    {
        return new ClassTypeNode("string");
    }

    @Override public BasicTypeNode visitBool(M_Parser.BoolContext ctx)
    {
        return new BasicTypeNode("bool");
    }
    @Override public BasicTypeNode visitVoid(M_Parser.VoidContext ctx)
    {
        return new BasicTypeNode("void");
    }
    @Override public ClassTypeNode visitOthers(M_Parser.OthersContext ctx)
    {
        return new ClassTypeNode(ctx.getText());
    }

    @Override public ClassDeclaration visitClass_defination(M_Parser.Class_definationContext ctx)
    {
        String classname = ctx.ID().getText();
        List<VariableDeclaration> memlist = new LinkedList<>();
        List<FuncDeclaration> methods = new LinkedList<>();
        FuncDeclaration generator = null;
        for(M_Parser.Variable_definationContext var: ctx.variable_defination())
        {
            memlist.add(visitVariable_defination(var));
        }
        for(M_Parser.Class_function_definationContext classfun: ctx.class_function_defination())
        {
            FuncDeclaration f;
            if(classfun.class_init_fun() != null) //this is a construct function
            {
                f = visitClass_init_fun(classfun.class_init_fun());
                if(generator == null)
                    generator = f;
                else System.out.println("already have a constructor!");//TODO: add into error reporter
            }
            else{
                f = visitFunction_defination(classfun.function_defination());
                methods.add(f);
            }
        }
        ClassDeclaration aclass = new ClassDeclaration();
        aclass.constructor = generator;
        aclass.member = memlist;
        aclass.methods = methods;
        aclass.name = classname;
        aclass.location = new Location(ctx.CLASS().getSymbol());
        return aclass;
    }

    @Override public FuncDeclaration visitClass_init_fun(M_Parser.Class_init_funContext ctx)
    {
        String funcname = ctx.func_name().getText();
        List<VariableDeclaration> paramaters = null;
        BlockStatement body = (BlockStatement) ctx.block().accept(this);
        FuncDeclaration f = new FuncDeclaration();
        f.name = funcname;
        f.body = body;
        f.parameters = paramaters;
        f.returnTypeNode = null;
        f.location = new Location(ctx.start);
        return f;
    }

    @Override public FuncDeclaration visitFunction_defination(M_Parser.Function_definationContext ctx)
    {
        String funcname = ctx.func_name().getText();
        List<VariableDeclaration> paramaters = null;
        BlockStatement body = (BlockStatement) ctx.block().accept(this);
        FuncDeclaration f = new FuncDeclaration();
        if(ctx.parameters() != null)
            paramaters = visitParameters(ctx.parameters());
        f.name = funcname;
        f.body = body;
        f.parameters = paramaters;
        f.returnTypeNode = visitClass_type(ctx.class_type());
        f.location = new Location(ctx.start);
        return f;
    }

    @Override public List<VariableDeclaration> visitParameters(M_Parser.ParametersContext ctx)
    {
        List<VariableDeclaration> list = new LinkedList<>();
        for(M_Parser.ParameterContext param: ctx.parameter())
            list.add(visitParameter(param));
        return list;
    }

    @Override public VariableDeclaration visitParameter(M_Parser.ParameterContext ctx)
    {
        TypeNode type = visitClass_type(ctx.class_type());
        String varname = ctx.ID().getText();
        VariableDeclaration decl = new VariableDeclaration(type, varname, null);
        decl.location = new Location(ctx.start);
        return decl;
    }

    @Override public BlockStatement visitBlock(M_Parser.BlockContext ctx)
    {
        List<Statement> list = new LinkedList<>();
        for(M_Parser.SentenceContext sent:ctx.sentence())
            list.add(visitSentence(sent));
        BlockStatement blk = new BlockStatement();
        blk.statements = list;
        blk.location = new Location(ctx.start);
        return blk;
    }

    @Override public Statement visitSentence(M_Parser.SentenceContext ctx)
    {
        if(ctx.declation() != null)
            return visitDeclation(ctx.declation());
        else if(ctx.expression() != null)
            return (Statement)ctx.expression().accept(this);
        else{
            System.out.println("[BUG!] null error occur in visitSentence!");
            assert false;
            return null;
        }
    }

    @Override public DeclarationStm visitDeclation(M_Parser.DeclationContext ctx)
    {
        DeclarationStm decl = new DeclarationStm();
        decl.declaration = visitVariable_defination(ctx.variable_defination());
        decl.location = new Location(ctx.start);
        return decl;
    }

    @Override public Statement visitExpression(M_Parser.ExpressionContext ctx)
    {
        if(ctx.BREAK() != null)
        {
            Statement stm = new BreakStatement();
            stm.location = new Location(ctx.start);
            return stm;
        }
        else if(ctx.CONTINUE() != null) {
            Statement stm = new ContinueStatement();
            stm.location = new Location(ctx.start);
            return stm;
        }
        else if(ctx.expr_statement() != null)
            return visitExpr_statement(ctx.expr_statement());
        else if(ctx.if_else() != null)
            return visitIf_else(ctx.if_else());
        else if(ctx.while_stm() != null)
            return visitWhile_stm(ctx.while_stm());
        else if(ctx.for_stm() != null)
            return visitFor_stm(ctx.for_stm());
        else if(ctx.return_stm() != null)
            return visitReturn_stm(ctx.return_stm());
        else if(ctx.block() != null)
            return visitBlock(ctx.block());
        else if(ctx.emptye() != null)
            return new EmptyStatement();
        else{
            System.out.println("[BUG!] null occur in visit expression");
            assert false;
            return null;
        }
    }

    @Override public Expression visitPos_neg(M_Parser.Pos_negContext ctx)
    {
        OpExpression exp = new OpExpression();
        exp.op = ctx.op.getText();
        exp.expression = (Expression)ctx.statement().accept(this);
        exp.location = new Location(ctx.start);
        return exp;
    }

    @Override public BinaryExpression visitAdd(M_Parser.AddContext ctx)
    {
        Expression left = (Expression) ctx.statement(0).accept(this);
        Expression right = (Expression) ctx.statement(1).accept(this);
        String op = ctx.op.getText();
        BinaryExpression e = new BinaryExpression();
        e.lhs = left;
        e.rhs = right;
        e.op = op;
        e.location = new Location(ctx.start);
        return e;
    }

    @Override public OpExpression visitLogicalnot(M_Parser.LogicalnotContext ctx)
    {
        OpExpression exp = new OpExpression();
        exp.op = "!";
        exp.expression = (Expression)ctx.statement().accept(this);
        exp.location = new Location(ctx.start);
        return exp;
    }

    @Override public BinaryExpression visitCompare(M_Parser.CompareContext ctx)
    {
        Expression left = (Expression) ctx.statement(0).accept(this);
        Expression right = (Expression) ctx.statement(1).accept(this);
        String op = ctx.op.getText();
        BinaryExpression e = new BinaryExpression();
        e.lhs = left;
        e.rhs = right;
        e.op = op;
        e.location = new Location(ctx.start);
        return e;
    }

    @Override public ConstExpression visitConstant(M_Parser.ConstantContext ctx)
    {
        return (ConstExpression)ctx.const_().accept(this);
    }

    @Override public BinaryExpression visitMul(M_Parser.MulContext ctx)
    {
        Expression left = (Expression) ctx.statement(0).accept(this);
        Expression right = (Expression) ctx.statement(1).accept(this);
        String op = ctx.op.getText();
        BinaryExpression e = new BinaryExpression();
        e.lhs = left;
        e.rhs = right;
        e.op = op;
        e.location = new Location(ctx.start);
        return e;
    }

    @Override public OpExpression visitPrefix(M_Parser.PrefixContext ctx)
    {
        OpExpression exp = new OpExpression();
        exp.expression = (Expression)ctx.statement().accept(this);
        exp.op = ctx.op.getText() + " ";
        exp.location = new Location(ctx.start);
        return exp;
    }

    @Override public MemberExpression visitClass_func(M_Parser.Class_funcContext ctx)
    {
        MemberExpression memcall = new MemberExpression();
        memcall.object = (Expression)ctx.statement().accept(this);
        memcall.methodCall = visitFunction_call(ctx.function_call());
        memcall.fieldAccess = null;
        memcall.location = new Location(ctx.start);
        return memcall;
    }

    @Override public ArrayExpression visitIndex(M_Parser.IndexContext ctx)
    {
        ArrayExpression idx = new ArrayExpression();
        idx.location = new Location(ctx.start);
        idx.address = (Expression)ctx.statement(0).accept(this);
        if(idx.address instanceof NewExpression && ctx.statement(0).stop.getText().equals("]"))
            errorRecorder.addRecord(idx.location, "can not use array in new expression like that");
        idx.index = (Expression)ctx.statement(1).accept(this);
        return idx;
    }

    @Override public BinaryExpression visitBitshift(M_Parser.BitshiftContext ctx)
    {
        Expression left = (Expression) ctx.statement(0).accept(this);
        Expression right = (Expression) ctx.statement(1).accept(this);
        String op = ctx.op.getText();
        BinaryExpression e = new BinaryExpression();
        e.lhs = left;
        e.rhs = right;
        e.op = op;
        e.location = new Location(ctx.start);
        return e;
    }

    @Override public FuncCallExpression visitFunc_call(M_Parser.Func_callContext ctx)
    {
        return visitFunction_call(ctx.function_call());
    }

    @Override public BinaryExpression visitLogical(M_Parser.LogicalContext ctx)
    {
        Expression left = (Expression) ctx.statement(0).accept(this);
        Expression right = (Expression) ctx.statement(1).accept(this);
        String op = ctx.op.getText();
        BinaryExpression e = new BinaryExpression();
        e.lhs = left;
        e.rhs = right;
        e.op = op;
        e.location = new Location(ctx.start);
        return e;
    }

    @Override public BinaryExpression visitEqual(M_Parser.EqualContext ctx)
    {
        Expression left = (Expression) ctx.statement(0).accept(this);
        Expression right = (Expression) ctx.statement(1).accept(this);
        String op = ctx.op.getText();
        BinaryExpression e = new BinaryExpression();
        e.lhs = left;
        e.rhs = right;
        e.op = op;
        e.location = new Location(ctx.start);
        return e;
    }

    @Override public Identifier visitThis_(M_Parser.This_Context ctx)
    {
        return new Identifier(ctx.THIS().getSymbol());
    }

    @Override public Identifier visitVariable(M_Parser.VariableContext ctx)
    {
        return new Identifier(ctx.ID().getSymbol());
    }
    @Override public BinaryExpression visitBitor(M_Parser.BitorContext ctx)
    {
        Expression left = (Expression) ctx.statement(0).accept(this);
        Expression right = (Expression) ctx.statement(1).accept(this);
        String op = "|";
        BinaryExpression e = new BinaryExpression();
        e.lhs = left;
        e.rhs = right;
        e.op = op;
        e.location = new Location(ctx.start);
        return e;
    }
    @Override public BinaryExpression visitBitand(M_Parser.BitandContext ctx)
    {
        Expression left = (Expression) ctx.statement(0).accept(this);
        Expression right = (Expression) ctx.statement(1).accept(this);
        String op = "&";
        BinaryExpression e = new BinaryExpression();
        e.lhs = left;
        e.rhs = right;
        e.op = op;
        e.location = new Location(ctx.start);
        return e;
    }
    @Override public BinaryExpression visitBitxor(M_Parser.BitxorContext ctx)
    {
        Expression left = (Expression) ctx.statement(0).accept(this);
        Expression right = (Expression) ctx.statement(1).accept(this);
        String op = "^";
        BinaryExpression e = new BinaryExpression();
        e.lhs = left;
        e.rhs = right;
        e.op = op;
        e.location = new Location(ctx.start);
        return e;
    }

    @Override public MemberExpression visitClass_member(M_Parser.Class_memberContext ctx)
    {
        MemberExpression memcall = new MemberExpression();
        memcall.object = (Expression)ctx.statement().accept(this);
        memcall.fieldAccess = new Identifier(ctx.ID().getSymbol());
        memcall.methodCall = null;
        memcall.location = new Location(ctx.start);
        return memcall;
    }

    @Override public NewExpression visitNew_st(M_Parser.New_stContext ctx)
    {
        return visitMalloc(ctx.malloc());
    }

    @Override public Expression visitBlanket(M_Parser.BlanketContext ctx)
    {
        return (Expression)ctx.statement().accept(this);
    }

    @Override public OpExpression visitPostfix(M_Parser.PostfixContext ctx)
    {
        OpExpression exp = new OpExpression();
        exp.expression = (Expression)ctx.statement().accept(this);
        exp.op = " " + ctx.op.getText();
        exp.location = new Location(ctx.start);
        return exp;
    }

    @Override public OpExpression visitBitnot(M_Parser.BitnotContext ctx)
    {
        OpExpression exp = new OpExpression();
        exp.op = "~";
        exp.expression = (Expression)ctx.statement().accept(this);
        exp.location = new Location(ctx.start);
        return exp;
    }

    @Override public AssignExpression visitAssign(M_Parser.AssignContext ctx)
    {
        AssignExpression exp = new AssignExpression();
        exp.lhs = (Expression)ctx.statement(0).accept(this);
        exp.rhs = (Expression)ctx.statement(1).accept(this);
        exp.location = new Location(ctx.start);
        return exp;
    }

    @Override public FuncCallExpression visitFunction_call(M_Parser.Function_callContext ctx)
    {
        FuncCallExpression exp = new FuncCallExpression();
        exp.functionName = ctx.ID().getText();
        exp.arguments = new LinkedList<>();
        for(M_Parser.StatementContext stm:ctx.statement())
        {
            exp.arguments.add((Expression)stm.accept(this));
        }
        exp.location = new Location(ctx.start);
        return exp;
    }

    @Override public ConstExpression visitString_const(M_Parser.String_constContext ctx)
    {
        return new ConstExpression(ctx.STRING_CONST().getSymbol());
    }

    @Override public ConstExpression visitInteger(M_Parser.IntegerContext ctx)
    {
        return new ConstExpression(ctx.INTEGER().getSymbol());
    }

    @Override public ConstExpression visitTrue(M_Parser.TrueContext ctx)
    {
        return new ConstExpression(ctx.TRUE().getSymbol());
    }

    @Override public ConstExpression visitFalse(M_Parser.FalseContext ctx)
    {
        return new ConstExpression(ctx.FALSE().getSymbol());
    }

    @Override public ConstExpression visitNull(M_Parser.NullContext ctx)
    {
        return new ConstExpression(ctx.NULL().getSymbol());
    }

    @Override public ExprStatement visitExpr_statement(M_Parser.Expr_statementContext ctx)
    {
        ExprStatement stm = new ExprStatement();
        stm.expression = (Expression)ctx.statement().accept(this);
        stm.location = new Location(ctx.start);
        return stm;
    }

    @Override public IfStatement visitIf_else(M_Parser.If_elseContext ctx)
    {
        IfStatement stm = new IfStatement();
        stm.condition = (Expression)ctx.statement().accept(this);
        stm.ifStatement = (Statement) ctx.expression(0).accept(this);
        if(ctx.expression(1) != null)
            stm.elseStatement = (Statement) ctx.expression(1).accept(this);
        else stm.elseStatement = null;
        stm.location = new Location(ctx.start);
        return stm;
    }

    @Override public WhileStatement visitWhile_stm(M_Parser.While_stmContext ctx)
    {
        WhileStatement stm = new WhileStatement();
        stm.condition = (Expression)ctx.statement().accept(this);
        stm.body = (Statement) ctx.expression().accept(this);
        stm.location = new Location(ctx.start);
        return stm;
    }

    @Override public ForStatement visitFor_stm(M_Parser.For_stmContext ctx)
    {
        ForStatement stm = new ForStatement();
        if(ctx.init() != null)
            stm.initStatement = (Expression)ctx.init().statement().accept(this);
        if(ctx.termanite() != null)
            stm.condition = (Expression)ctx.termanite().statement().accept(this);
        if(ctx.update() != null)
            stm.updateStatement = (Expression)ctx.update().statement().accept(this);
        stm.body = (Statement) ctx.expression().accept(this);
        stm.location = new Location(ctx.start);
        return stm;
    }

    @Override public ReturnStatement visitReturn_stm(M_Parser.Return_stmContext ctx)
    {
        ReturnStatement stm = new ReturnStatement();
        if(ctx.statement() != null)
            stm.retExpression = (Expression)ctx.statement().accept(this);
        stm.location = new Location(ctx.start);
        return stm;
    }
}
