package M_.AST;

public class BasicTypeNode extends TypeNode{
    public String name;

    public BasicTypeNode() { }
    public BasicTypeNode(String name) { this.name = name; }


    @Override public void accept(IAstVisitor visitor) { visitor.visit(this); }
}
