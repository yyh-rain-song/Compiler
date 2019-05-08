package M_.compile.front;

import M_.Symbol.*;

import java.io.PrintStream;

public class STPrinter {
    StringBuilder stringBuilder;
    String curIndent;
    String incIndent;

    public STPrinter(GlobalSymbolTable GST)
    {
        this.stringBuilder = new StringBuilder();
        this.curIndent = "";
        this.incIndent = "  ";
        print(GST);
    }

    public String toString(){
        return stringBuilder.toString();
    }

    public void printTo(PrintStream out){
        out.println(toString());
    }

    private void indent(){ curIndent = curIndent + incIndent; }
    private void unindent() {curIndent = curIndent.substring(0, curIndent.length() - incIndent.length());}
    private void appendCurrentLine(String s){
        stringBuilder.append(s);
    }
    private void appendNewLine(String s){
        if(stringBuilder.length() == 0)
            stringBuilder.append(curIndent + s);
        else stringBuilder.append("\n" + curIndent + s);
    }

    private String trans(PrimitiveType type){return type.name;}
    private String trans(ArrayType type){return trans(type.baseType) + "[]";}
    private String trans(ClassType type) {return type.name;}
    private String trans(VariableType type){
        if(type instanceof PrimitiveType)
            return trans((PrimitiveType)type);
        else if(type instanceof ArrayType)
            return trans((ArrayType) type);
        else if(type instanceof ClassType)
            return trans((ClassType) type);
        else{
            assert false;
            return null;
        }
    }

    private void print(GlobalSymbolTable ST){
        appendNewLine("classes:");
        indent();
        for(ClassSymbol cc: ST.classes.values()){
            if(cc.name.equals("string") || cc.name.equals("null"))
                continue;
            print(cc);
        }
        unindent();
        appendNewLine("Global Variables: ");
        indent();
        for(VariableSymbol vv: ST.variables.values())
            print(vv);
        unindent();
        appendNewLine("Functions: ");
        indent();
        for(FuncionSymbol ff: ST.functions.values()){
            if(ff.name.equals("print") || ff.name.equals("println") || ff.name.equals("getString")
                || ff.name.equals("getInt") || ff.name.equals("toString"))
                continue;
            print(ff);
        }
        unindent();
    }
    private void print(SymbolTable st){
        if(st == null)
            appendNewLine("null");
        else
        {
            if(st.variables.size() + st.functions.size() + st.children.size() == 0)
                appendNewLine("empty");
            else
            {
                if(st.variables.size() > 0)
                {
                    appendNewLine("Variables: ");
                    indent();
                    for(VariableSymbol vv: st.variables.values())
                        print(vv);
                    unindent();
                }
                if(st.functions.size() > 0)
                {
                    appendNewLine("Functions: ");
                    indent();
                    for(FuncionSymbol ff: st.functions.values())
                        print(ff);
                    unindent();
                }
                for(SymbolTable C: st.children)
                {
                    appendNewLine("Block: ");
                    indent();
                    print(C);
                    unindent();
                }
            }
        }
    }

    private void print(BaseSymbol symbol)
    {
        appendNewLine(symbol.name);
    }
    private void print(ClassSymbol symbol){
        appendNewLine(symbol.name + "(class)");
        indent();
        appendNewLine("Members: ");
        indent();
        print(symbol.classSymbolTable);
        unindent();
        unindent();
    }

    private void print(FuncionSymbol ff){
        appendNewLine(ff.name + "(function)");
        indent();
        appendNewLine("Parameters: ");
        indent();
        for(int i = 0; i < ff.parameterNames.size(); i++)
        {
            appendNewLine(ff.parameterNames.get(i));
            appendCurrentLine("("+trans(ff.parameterTypes.get(i))+")");
        }
        unindent();
        appendNewLine("Block");
        indent();
        print(ff.functionSymbolTable);
        unindent();
    }

    private void print(VariableSymbol vs){
        appendNewLine(vs.name);
        appendCurrentLine("("+trans(vs.type)+")");
    }
}
