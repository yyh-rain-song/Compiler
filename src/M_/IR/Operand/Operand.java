package M_.IR.Operand;


import M_.IR.IIRVisitor;

public abstract class Operand {
    public abstract void accept(IIRVisitor visitor);
}
