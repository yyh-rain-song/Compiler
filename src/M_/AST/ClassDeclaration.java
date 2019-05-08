package M_.AST;

import M_.Symbol.ClassSymbol;

import java.util.List;

public class ClassDeclaration extends Declaration{
    public String name = null;
    public List<VariableDeclaration> member;
    public List<FuncDeclaration> methods;
    public FuncDeclaration constructor;

    public ClassSymbol symbol;

    public String toString() {
        return name + "\n";
    }

    @Override public void accept(IAstVisitor visitor) { visitor.visit(this); }

}
