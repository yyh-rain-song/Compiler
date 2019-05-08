package M_.IR.Operand;


import M_.IR.IIRVisitor;

public class Immediate extends Constant {
    public int value;

    public Immediate(int value) {
        this.value = value;
    }

    @Override
    public void accept(IIRVisitor visitor) {
        visitor.visit(this);
    }
}
