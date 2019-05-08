package M_.IR;


import M_.IR.Instruction.CJump;
import M_.IR.Instruction.IRInstruction;
import M_.IR.Instruction.Jump;
import M_.IR.Instruction.Return;

import java.util.LinkedList;

public class BasicBlock {
    public String hint;
    public Function function;
    public IRInstruction head;
    public IRInstruction tail;

    public LinkedList<BasicBlock> frontiers = null;
    public LinkedList<BasicBlock> successors = null;

    private static int globalBlockId = 0;
    public int blockId;

    public BasicBlock(Function function, String hint) {
        this.function = function;
        this.hint = hint;
        this.frontiers = new LinkedList<>();
        this.successors = new LinkedList<>();
        function.basicblocks.add(this);
        blockId = globalBlockId++;
    }

    public boolean isEnded() {
        return tail instanceof Return || tail instanceof Jump || tail instanceof CJump;
    }

    public void prepend(IRInstruction inst) {
        head.prepend(inst);
    }
    public void append(IRInstruction inst) {
        if(tail instanceof CJump || tail instanceof Jump || tail instanceof Return)
            return;
        if (head == null) {
            inst.prev = inst.next = null;
            head = tail = inst;
        } else {
            tail.append(inst);
        }
    }

    public void accept(IIRVisitor visitor) {
        visitor.visit(this);
    }
}
