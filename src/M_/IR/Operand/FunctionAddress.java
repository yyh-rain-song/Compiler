package M_.IR.Operand;


import M_.IR.Function;
import M_.IR.IIRVisitor;

public class FunctionAddress extends Constant{
    public Function function;

    public FunctionAddress(Function function) {
        this.function = function;
    }

    @Override
    public void accept(IIRVisitor visitor) {
        visitor.visit(this);
    }
}
