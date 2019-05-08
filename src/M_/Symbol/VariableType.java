package M_.Symbol;

/*
* Using to record a variable's type
* */
public abstract class VariableType {
    //whether the two type is the same.
    public abstract boolean match(VariableType other);
    public abstract int getBytes();
}
