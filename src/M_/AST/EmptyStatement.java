package M_.AST;

public class EmptyStatement extends Statement{
    @Override
    public void accept(IAstVisitor visitor){visitor.visit(this);}
}
