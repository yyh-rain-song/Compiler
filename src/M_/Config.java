package M_;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class Config {

    public static void init(){
        if(DebugState){
            try {
                fin = new FileInputStream("D:\\Compiler\\codes\\trial_1\\src\\M_\\program.cpp");
                //fin = new FileInputStream("D:\\Compiler\\codes\\trial_1\\testcase\\testcase_46.txt");
                fout = new PrintStream("program.asm");
            } catch (Exception e){
                System.err.println("In Out error");
            }
        } else{
            fin = System.in;
            fout = System.out;
        }
    }
    public static int REGISTER_WIDTH = 8;

    public enum Allocator{
        Naive, Graph
    }

    public static InputStream fin;
    public static PrintStream fout;
    public static boolean DebugState = false;

    public static boolean InlineOptm = true;
    //public static boolean BackupOptm = true;
    public static boolean UselessInstElim = true;

    public static Allocator allocator = Allocator.Graph;
    public static boolean printAST = false;
    public static boolean printIR = true;
    public static boolean printIRAfterAllocate = true;
    public static boolean printASM = true;
    public static int inlineMaxDepth = 2;
    public static int inlineOperationsThreshold = 20;
}
