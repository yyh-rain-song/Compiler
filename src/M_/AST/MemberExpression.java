package M_.AST;

public class MemberExpression extends Expression{
    public Expression object;
    public Identifier fieldAccess;
    public FuncCallExpression methodCall;
    @Override public void accept(IAstVisitor visitor) { visitor.visit(this); }
}
