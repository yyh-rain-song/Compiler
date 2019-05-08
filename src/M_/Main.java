package M_;

import M_.AST.Program;
import M_.IR.*;
import M_.Parser.M_Lexer;
import M_.Parser.M_Parser;
import M_.Symbol.GlobalSymbolTable;
import M_.compile.ErrorRecorder;
import M_.compile.back.*;
import M_.compile.front.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import static java.lang.System.exit;

public class Main {

    private static void Compile (InputStream is)throws IOException
    {
        //InputStream is = System.in;
        ANTLRInputStream ais = new ANTLRInputStream(is);
        M_Lexer mstarLexer = new M_Lexer(ais);
        CommonTokenStream tokens = new CommonTokenStream(mstarLexer);
        M_Parser parser = new M_Parser(tokens);

        ErrorRecorder errorRecorder = new ErrorRecorder();
        parser.removeErrorListeners();
        SyntaxErrorListener syntaxErrorListener = new SyntaxErrorListener(errorRecorder);
        parser.addErrorListener(syntaxErrorListener);

        ParseTree parseTree = parser.start();

        if(errorRecorder.hasError()) {
            errorRecorder.printTo(System.err);
            exit(1);
        }

        ASTBuilder astBuilder = new ASTBuilder(errorRecorder);
        astBuilder.visit(parseTree);

        if(errorRecorder.hasError()){
            errorRecorder.printTo(System.err);
            exit(1);
        }

        Program program = astBuilder.program;

        if(Config.printAST) {
            ASTPrinter printer = new ASTPrinter();
            program.accept(printer);
            printer.printTo(System.out);
        }

        STBuilder stBuilder = new STBuilder(errorRecorder);
        program.accept(stBuilder);

        if(errorRecorder.hasError()){
            errorRecorder.printTo(System.err);
            exit(1);
        }
        GlobalSymbolTable GST = stBuilder.globalSymbolTable;

        SemanticChecker semantic = new SemanticChecker(GST, errorRecorder);
        program.accept(semantic);

        if(errorRecorder.hasError()){
            errorRecorder.printTo(System.err);
            exit(1);
        }
        System.err.println("Semantic check complete");
        RegisterSet.init();
        IRBuilder irBuilder = new IRBuilder(GST);
        program.accept(irBuilder);

        IRProgram iRprogram = irBuilder.irProgram;
        if(Config.printIR){
            IRPrinter irPrinter = new IRPrinter();
            iRprogram.accept(irPrinter);
            irPrinter.printTo(System.err);
        }
        System.err.println("ir built!");

        IRCorrector corrector = new IRCorrector();
        iRprogram.accept(corrector);
        if(Config.printIR)
        {
            IRPrinter printer = new IRPrinter();
            iRprogram.accept(printer);
            printer.printTo(new PrintStream("Virtual_IR.txt"));
        }
    //register allocate
        switch (Config.allocator){
            case Naive:
                NaiveAllocator allocator = new NaiveAllocator(iRprogram);
                allocator.run();
                break;
            case Graph:
                SimpleGraphAllocator allocate = new SimpleGraphAllocator(iRprogram);
                allocate.run();
                break;
        }
        if(Config.printIRAfterAllocate){
            System.err.println("-------------------IR after allocate --------");
            IRPrinter irPrinter = new IRPrinter();
            irPrinter.visit(iRprogram);
            irPrinter.printTo(new PrintStream("Physical_IR.txt"));
        }

        StackFrameBuilder stackBuilder = new StackFrameBuilder(iRprogram);
        stackBuilder.run();

        if(Config.printASM){
            System.err.println("---------------after frame builder-----------------------");
            IRPrinter irPrinter = new IRPrinter();
            irPrinter.showNasm = true;
            irPrinter.visit(iRprogram);
            irPrinter.printTo(new PrintStream("Frame_IR.txt"));
        }

        if(Config.printASM){
            IRPrinter irPrinter = new IRPrinter();
            irPrinter.showNasm = true;
            irPrinter.showHeader = true;
            irPrinter.visit(iRprogram);
            irPrinter.printTo(Config.fout);
        }
    }
    public static void main(String[] args) throws IOException {
        Config.DebugState = false ;
        Config.init();
        Compile(Config.fin);

        exit(0);
    }
}
