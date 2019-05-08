package M_.IR.Instruction;


import M_.IR.BasicBlock;
import M_.IR.IIRVisitor;
import M_.IR.Operand.Register;
import M_.IR.Operand.StackSlot;
import M_.IR.RegisterSet;

import java.util.HashMap;
import java.util.LinkedList;

public class Return extends IRInstruction {

    public Return(BasicBlock bb) {
        super(bb);
    }

    @Override
    public void renameUseReg(HashMap<Register, Register> renameMap) { }

    @Override
    public void renameDefReg(HashMap<Register, Register> renameMap) { }

    @Override
    public LinkedList<Register> getDefRegs() { return new LinkedList<>(); }

    @Override
    public LinkedList<Register> getUseRegs() {
        LinkedList<Register> regs = new LinkedList<>();
        if(bb.function.hasReturnValue)
            regs.add(RegisterSet.vrax);
        return regs;
    }

    @Override
    public LinkedList<StackSlot> getStackSlots() { return new LinkedList<>(); }

    @Override
    public void accept(IIRVisitor visitor) {
        visitor.visit(this);
    }
}
