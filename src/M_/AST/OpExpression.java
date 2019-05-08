package M_.AST;

public class OpExpression extends Expression {
    public String op;
    public Expression expression;

    @Override public void accept(IAstVisitor visitor) { visitor.visit(this); }

}
