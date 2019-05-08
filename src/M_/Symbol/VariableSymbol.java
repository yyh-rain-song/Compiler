package M_.Symbol;

import M_.AST.Location;
import M_.IR.Operand.VirtualRegister;

/*
* Use for variables,like:  "int a; self_design_class example; string b;" etc
* "name" -> variable's ID
* type -> the type of this variable (divided as classType, BasicType, ArrayType)
* */
public class VariableSymbol {
    public String name;
    public VariableType type;
    public Location location;

    public VirtualRegister virtualRegister;
    public boolean isClassField;
    public boolean isGlobalVariable;

    public VariableSymbol() {}
    public VariableSymbol(String name, VariableType type, Location location, boolean isClass, boolean isGlobal) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.isClassField = isClass;
        this.isGlobalVariable = isGlobal;
    }
}
