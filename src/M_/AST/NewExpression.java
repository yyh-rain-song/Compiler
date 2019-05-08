package M_.AST;

import java.util.List;

public class NewExpression extends Expression{
    public TypeNode typeNode;
    public List<Expression> exprDimensions;
    public int restDimension;

    @Override
    public void accept(IAstVisitor visitor){visitor.visit(this);}
}
