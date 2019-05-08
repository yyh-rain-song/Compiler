package M_.AST;

import java.util.LinkedList;
import java.util.List;

public class Program extends ASTnode{
    public List<FuncDeclaration> functions;
    public List<ClassDeclaration> classes;
    public List<VariableDeclaration> globalVariables;
    public List<Declaration> declarations;//keep the origin list

    public Program(){
        this.functions = new LinkedList<>();
        this.classes = new LinkedList<>();
        this.globalVariables = new LinkedList<>();
        this.declarations = new LinkedList<>();
    }
    public void add(Declaration decl){
        if(decl instanceof FuncDeclaration)
            functions.add((FuncDeclaration)(decl));
        else if(decl instanceof  VariableDeclaration)
            globalVariables.add((VariableDeclaration)(decl));
        else classes.add((ClassDeclaration)decl);
        declarations.add(decl);
    }
    @Override public void accept(IAstVisitor visitor) { visitor.visit(this); }

}
