package M_.AST;

import M_.Symbol.FuncionSymbol;

import java.util.List;

public class FuncCallExpression extends Expression{
    public String functionName;
    public List<Expression> arguments;
    public FuncionSymbol functionSymbol;
    @Override
    public void accept(IAstVisitor visitor){visitor.visit(this);}
}
