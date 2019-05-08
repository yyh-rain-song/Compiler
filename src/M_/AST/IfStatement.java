package M_.AST;

public class IfStatement extends Statement{
    public Expression condition = null;
    public Statement ifStatement = null;
    public Statement elseStatement = null;
    @Override public void accept(IAstVisitor visitor) { visitor.visit(this); }
}
