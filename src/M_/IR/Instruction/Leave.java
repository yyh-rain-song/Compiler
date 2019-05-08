package M_.IR.Instruction;

import M_.IR.BasicBlock;
import M_.IR.IIRVisitor;
import M_.IR.Operand.Register;
import M_.IR.Operand.StackSlot;

import java.util.HashMap;
import java.util.LinkedList;

public class Leave extends IRInstruction{

    public Leave(BasicBlock bb) {
        super(bb);
    }
    @Override
    public void renameUseReg(HashMap<Register, Register> renameMap) { }

    @Override
    public void renameDefReg(HashMap<Register, Register> renameMap) { }

    @Override
    public LinkedList<Register> getDefRegs() { return new LinkedList<>(); }

    @Override
    public LinkedList<Register> getUseRegs() { return new LinkedList<>(); }

    @Override
    public LinkedList<StackSlot> getStackSlots() { return new LinkedList<>(); }

    @Override
    public void accept(IIRVisitor visitor) {
        visitor.visit(this);
    }
}
