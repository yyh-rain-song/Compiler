package M_.AST;

public class ForStatement extends Statement{
   public Expression initStatement = null;
   public Expression updateStatement = null;
   public Expression condition = null;
   public Statement body = null;
    @Override public void accept(IAstVisitor visitor) { visitor.visit(this); }
}
