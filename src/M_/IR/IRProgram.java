package M_.IR;

import M_.IR.Operand.StaticData;

import java.util.LinkedList;

public class IRProgram {
    public LinkedList<Function> functions;
    public LinkedList<StaticData> staticData;

    public IRProgram() {
        functions = new LinkedList<>();
        staticData = new LinkedList<>();
    }

    public void accept(IIRVisitor visitor) {
        visitor.visit(this);
    }
}
