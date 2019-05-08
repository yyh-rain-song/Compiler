package M_.IR.Operand;


import M_.IR.Function;
import M_.IR.IIRVisitor;

public class StackSlot extends Memory {
    public Function function;
    public String hint;

    public StackSlot(String hint) {
        this.hint = hint;
    }
    public void accept(IIRVisitor visitor) {
        visitor.visit(this);
    }
}
