package M_.AST;

public class DeclarationStm extends Statement{
    public VariableDeclaration declaration = null;
    @Override public void accept(IAstVisitor visitor) { visitor.visit(this); }
}
