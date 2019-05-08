package M_.compile;

import M_.AST.Location;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class ErrorRecorder {
    private List<String> errors;
    public static final String ANSI_RED = "\u001B[31m";//can change the color of output. Wonderful!
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public ErrorRecorder(){
        errors = new LinkedList<>();
    }

    public void addRecord(Location location, String msg){
        StackTraceElement[] stacks = new Throwable().getStackTrace();
        errors.add(ANSI_CYAN + stacks[1].getClassName() + "." + stacks[1].getLineNumber() +
                    ANSI_PURPLE + ":" + ANSI_BLUE + location + ":" + ANSI_RED + msg + ANSI_RESET);
    }

    public boolean hasError(){return !errors.isEmpty();}

    public void printTo(PrintStream out){
        out.print(toString());
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(String ss:errors){
            builder.append(ss + "\n");
        }
        return builder.toString();
    }
}
