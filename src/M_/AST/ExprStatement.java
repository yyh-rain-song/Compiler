package M_.AST;

public class ExprStatement extends Statement{
    public Expression expression = null;
    @Override public void accept(IAstVisitor visitor) { visitor.visit(this); }
}
