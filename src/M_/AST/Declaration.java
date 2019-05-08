package M_.AST;

public class Declaration extends ASTnode{
    @Override
    public void accept(IAstVisitor visitor){
        visitor.visit(this);
    }
}
