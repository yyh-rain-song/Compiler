package M_.AST;

public class ArrayExpression extends Expression{
    public Expression address;
    public Expression index;

    @Override
    public void accept(IAstVisitor visitor){visitor.visit(this);}
}
