package M_.IR.Instruction;

import M_.IR.BasicBlock;
import M_.IR.IIRVisitor;
import M_.IR.Operand.Memory;
import M_.IR.Operand.Register;
import M_.IR.Operand.StackSlot;

import java.util.HashMap;
import java.util.LinkedList;

public class Lea extends IRInstruction {
    public Register dest;
    public Memory src;

    public Lea(BasicBlock bb, Register dest, Memory src) {
        super(bb);
        this.dest = dest;
        this.src = src;
    }
    @Override
    public LinkedList<Register> getUseRegs() {
        LinkedList<Register> regs = new LinkedList<>();
        regs.addAll(src.getUseRegs());
        regs.add(dest);
        return regs;
    }

    @Override
    public LinkedList<StackSlot> getStackSlots() {
        return defaultGetStackSlots(src);
    }

    @Override
    public LinkedList<Register> getDefRegs() {
        LinkedList<Register> regs = new LinkedList<>();
        regs.add(dest);
        return regs;
    }
    @Override
    public void renameUseReg(HashMap<Register, Register> renameMap) {
        src = src.copy();
        src.renameUseReg(renameMap);
    }

    @Override
    public void renameDefReg(HashMap<Register, Register> renameMap) {
        if(renameMap.containsKey(dest))
            dest = renameMap.get(dest);
    }

    @Override
    public void accept(IIRVisitor visitor) {
        visitor.visit(this);
    }
}
