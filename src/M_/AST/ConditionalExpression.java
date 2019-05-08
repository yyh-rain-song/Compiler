package M_.AST;

public class ConditionalExpression extends Expression{
    public Expression condition;
    public Expression exprTrue;
    public Expression exprFalse;

    @Override public void accept(IAstVisitor visitor) { visitor.visit(this); }
}
