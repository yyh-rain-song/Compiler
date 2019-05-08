package M_.Symbol;

import M_.Config;

/*
* The Basic build-in type in M_.
* name -> the type's name. Such as "int", "string"...
* Symbol -> a variableSymbol
* */
public class PrimitiveType extends VariableType{
    public String name;
    public BaseSymbol symbol;

    public PrimitiveType() {}
    public PrimitiveType(String name, BaseSymbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public boolean match(VariableType other) {
        if(other instanceof PrimitiveType && ((PrimitiveType)other).name.equals(this.name))
            return true;
        else return false;
    }

    @Override
    public int getBytes(){
        return Config.REGISTER_WIDTH;
    }
}
