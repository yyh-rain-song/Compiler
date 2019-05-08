package M_.AST;

public abstract class ASTnode {
    public Location location = null;
    public abstract void accept(IAstVisitor visitor);
}
