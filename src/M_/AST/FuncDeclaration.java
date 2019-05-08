package M_.AST;

import M_.Symbol.FuncionSymbol;

import java.util.LinkedList;
import java.util.List;

public class FuncDeclaration extends Declaration{
    public TypeNode returnTypeNode = null;
    public String name = null;
    public List<VariableDeclaration> parameters;
    public BlockStatement body;

    public FuncionSymbol symbol;

    public String toString() {
        return name + "\n";
    }

    public static FuncDeclaration defaultConstructor(String name) {
        FuncDeclaration constructor = new FuncDeclaration();
        constructor.returnTypeNode = new BasicTypeNode("void");
        constructor.name = name;
        constructor.parameters = new LinkedList<>();
        constructor.body = new BlockStatement();
        return constructor;
    }

    @Override public void accept(IAstVisitor visitor) { visitor.visit(this); }
}
