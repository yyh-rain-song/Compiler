package M_;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class Config {

    public static void init(){
        if(DebugState){
            try {
                //fin = new FileInputStream("D:\\Compiler\\codes\\trial_1\\src\\M_\\program.cpp");
                fin = new FileInputStream("D:\\Compiler\\codes\\trial_1\\testcase\\testcase_309.txt");
                fout = new PrintStream("program.asm");
                printVirtual_IR = true;
                printIRAfterAllocate = true;
                printFrame = true;
                frame_out = new PrintStream("Frame_IR.txt");
            } catch (Exception e){
                System.err.println("In Out error");
            }
        } else{
            fin = System.in;
            fout = System.out;
            frame_out = System.err;
            printFrame = true;
            printVirtual_IR = false;
            printIRAfterAllocate = false;
        }
    }
    public static int REGISTER_WIDTH = 8;

    public enum Allocator{
        Naive, Graph
    }

    public static InputStream fin;
    public static PrintStream fout;
    public static PrintStream frame_out;
    public static boolean DebugState = false;

    public static boolean InlineOptm = true;
    //public static boolean BackupOptm = true;
    public static boolean LocalVauleOpt = true;
    public static boolean UselessInstElim = true;

    public static Allocator allocator = Allocator.Graph;
    public static boolean printAST = false;
    public static boolean printIR = false;
    public static boolean printVirtual_IR = true;
    public static boolean printIRAfterAllocate = true;
    public static boolean printFrame = true;
    public static boolean printASM = true;
    public static int inlineMaxDepth = 2;
    public static int inlineOperationsThreshold = 20;
}
