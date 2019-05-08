package M_.Symbol;

import M_.Config;

public class ArrayType extends VariableType{
    public VariableType baseType;

    public ArrayType() {}
    public ArrayType(VariableType baseType) {
        this.baseType = baseType;
    }

    @Override
    public boolean match(VariableType other) {
        if(other instanceof ClassType && ((ClassType) other).name.equals("null"))//null array
            return true;
        else if(other instanceof ArrayType)
            return baseType.match(((ArrayType) other).baseType);
        else
            return false;
    }

    @Override
    public int getBytes() {
        return Config.REGISTER_WIDTH;
    }
}
