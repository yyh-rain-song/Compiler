package M_.AST;

import M_.Symbol.VariableType;

public abstract class Expression extends ASTnode {
    public VariableType type;//maby using as type calculator?
    public boolean modifiable;//I don't know what this do
}
