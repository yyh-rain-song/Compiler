package M_.compile.front;

import M_.AST.*;

import java.io.PrintStream;

public class ASTPrinter implements IAstVisitor {
    private StringBuilder stringBuilder;
    private String curIndent;
    private String incIndent;

    public ASTPrinter(){
        stringBuilder = new StringBuilder();
        curIndent = "";
        incIndent = "";
    }

    public String toString(){
        return stringBuilder.toString();
    }
    public void printTo(PrintStream out){
        out.println(toString());
    }
    private void indent(){
        curIndent = curIndent + incIndent;
    }
    private void unindent(){
        curIndent = curIndent.substring(0, curIndent.length() - incIndent.length());
    }
    private void appendCurrentLine(String s){
        stringBuilder.append(s);
    }
    private void appendNewLine(String s){
        if(stringBuilder.length() != 0)
            stringBuilder.append("\n");
        stringBuilder.append(curIndent);
        stringBuilder.append(s);
    }
    @Override
    public void visit(Program node){
        appendNewLine("Functions:");
        indent();
        for(FuncDeclaration f:node.functions)
            visit(f);
        unindent();
        appendNewLine("Classes:");
        indent();
        if(node.classes != null)
        {
            for(ClassDeclaration c: node.classes)
                visit(c);
        }
        unindent();
        appendNewLine("Global Variables: ");
        indent();
        if(node.globalVariables != null)
        {
            for(VariableDeclaration v: node.globalVariables)
            {
                appendNewLine("");
                visit(v);
            }
        }
        unindent();
    }
    @Override
    public void visit(Declaration node){assert false;}
    @Override
    public void visit(FuncDeclaration node){
        appendNewLine("function: "+ node.name);
        if(node.returnTypeNode != null)
        {
            appendNewLine("return type: ");
            node.returnTypeNode.accept(this);
        }
        appendNewLine("parameters");
        if(node.parameters != null){
            for(VariableDeclaration vd: node.parameters){
                visit(vd);
                appendCurrentLine(",");
            }
        }
        appendNewLine("body");
        indent();
        visit(node.body);
        unindent();
    }
    @Override
    public void visit(ClassDeclaration node){
        appendNewLine("class: "+ node.name);
        appendNewLine("constructor: ");
        indent();
        if(node.constructor != null)
            visit(node.constructor);
        unindent();
        appendNewLine("fields:");
        indent();
        if(node.member != null)
        {
            for(VariableDeclaration vd: node.member){
                appendNewLine("");
                visit(vd);
            }
        }
        unindent();
        appendNewLine("methods:");
        indent();
        if(node.methods != null)
        {
            for(FuncDeclaration fd: node.methods)
                visit(fd);
        }
        unindent();
    }
    @Override
    public void visit(VariableDeclaration node){
        if(node.typeNode != null){
            node.typeNode.accept(this);
            appendCurrentLine(" ");
        }
        appendCurrentLine(node.name);
        if(node.init != null){
            appendCurrentLine(" = ");
            node.init.accept(this);
        }
    }
    @Override
    public void visit(TypeNode node){

    }
    @Override
    public void visit(ArrayTypeNode node){
        visit(node.baseType);
        for(int i = 0; i < node.dimension; i++)
            appendCurrentLine("[]");
    }
    @Override
    public void visit(BasicTypeNode node){
        appendCurrentLine(node.name);
    }
    @Override
    public void visit(ClassTypeNode node){
        appendCurrentLine(node.className);
    }
    @Override
    public void visit(Statement node){
        assert false;
    }
    @Override
    public void visit(EmptyStatement node){ }
    @Override
    public void visit(ForStatement node){
        appendNewLine("for: ");
        indent();
        appendNewLine("initStatement statement:");
        indent();
        if(node.initStatement != null)
            node.initStatement.accept(this);
        unindent();
        appendNewLine("condition: ");
        if(node.condition != null)
            node.condition.accept(this);
        appendNewLine("updateStatement statement: ");
        indent();
        if(node.updateStatement != null)
            node.updateStatement.accept(this);
        unindent();
        appendNewLine("body");
        indent();
        node.body.accept(this);
        unindent();
        unindent();
    }
    @Override
    public void visit(WhileStatement node){
        appendNewLine("while: ");
        indent();
        appendNewLine("condition: ");
        node.condition.accept(this);
        appendNewLine("body: ");
        indent();
        visit(node.body);
        unindent();
        unindent();
    }
    @Override
    public void visit(IfStatement node){
        appendNewLine("if: ");
        indent();
        appendNewLine("condition: ");
        node.condition.accept(this);
        appendNewLine("then: ");
        indent();
        visit(node.ifStatement);
        unindent();
        if(node.elseStatement != null){
            appendNewLine("else: ");
            indent();
            visit(node.elseStatement);
            unindent();
        }
        unindent();
    }
    @Override
    public void visit(ContinueStatement node){
        appendNewLine("continue");
    }
    @Override
    public void visit(BreakStatement node){
        appendNewLine("break");
    }
    @Override
    public void visit(ReturnStatement node){
        appendNewLine("return ");
        if(node.retExpression != null)
            node.retExpression.accept(this);
    }
    @Override
    public void visit(BlockStatement node){
        appendNewLine("enter{");
        indent();
        if(node.statements != null)
        {
            for(Statement s: node.statements)
                s.accept(this);
        }
        unindent();
        appendNewLine("}exit");
    }
    @Override
    public void visit(DeclarationStm node){
        appendNewLine("");
        node.declaration.accept(this);
    }
    @Override
    public void visit(ExprStatement node){
        appendNewLine("");
        node.expression.accept(this);
    }
    @Override
    public void visit(Expression node){
        assert false;
    }
    @Override
    public void visit(Identifier node){
        appendCurrentLine(node.name);
    }
    @Override
    public void visit(ConstExpression node){
        appendCurrentLine(node.value);
    }
    @Override
    public void visit(ArrayExpression node){
        node.address.accept(this);
        appendCurrentLine("[");
        node.index.accept(this);
        appendCurrentLine("]");
    }
    @Override
    public void visit(FuncCallExpression node){
        appendCurrentLine(node.functionName);
        appendCurrentLine(" (");
        if(node.arguments != null)
        {
            for(Expression e: node.arguments){
                e.accept(this);
                appendCurrentLine(",");
            }
        }
        appendCurrentLine(")");
    }
    @Override
    public void visit(NewExpression node){
        appendCurrentLine("new ");
        node.typeNode.accept(this);
        if(node.exprDimensions != null)
        {
            for(Expression e: node.exprDimensions){
                appendCurrentLine("[");
                e.accept(this);
                appendCurrentLine("]");
            }
        }
        for(int i = 0; i < node.restDimension; i++)
            appendCurrentLine("[]");
    }
    @Override
    public void visit(MemberExpression node){
        node.object.accept(this);
        appendCurrentLine(".");
        if(node.fieldAccess != null)
            visit(node.fieldAccess);
        else if(node.methodCall != null)
            visit(node.methodCall);
        else{
            System.out.println("[BUG!] null occur in visit MemberExpression");
            assert false;
        }
    }
    @Override
    public void visit(OpExpression node){
        if(node.op.contains(" ")){
            if(node.op.charAt(0) == ' '){
                appendCurrentLine("(");
                node.expression.accept(this);
                appendCurrentLine(")");
                appendCurrentLine(node.op.substring(1,2));
            }
            else{
                appendCurrentLine(node.op.substring(0,1));
                appendCurrentLine("(");
                node.expression.accept(this);
                appendCurrentLine(")");
            }
        }
        else{
            appendCurrentLine(node.op);
            appendCurrentLine("(");
            node.expression.accept(this);
            appendCurrentLine(")");
        }
    }
    @Override
    public void visit(BinaryExpression node){
        appendCurrentLine("(");
        node.lhs.accept(this);
        appendCurrentLine(")");
        appendCurrentLine(node.op);
        appendCurrentLine("(");
        node.rhs.accept(this);
        appendCurrentLine(")");
    }
    @Override
    public void visit(ConditionalExpression node){
        appendCurrentLine("(");
        node.condition.accept(this);
        appendCurrentLine(")");
        appendCurrentLine("?");
        appendCurrentLine("(");
        node.exprTrue.accept(this);
        appendCurrentLine(")");
        appendCurrentLine(":");
        appendCurrentLine("(");
        node.exprFalse.accept(this);
        appendCurrentLine(")");
    }
    @Override
    public void visit(AssignExpression node){
        node.lhs.accept(this);
        appendCurrentLine(" = ");
        appendCurrentLine("(");
        node.rhs.accept(this);
        appendCurrentLine(")");
    }

}
