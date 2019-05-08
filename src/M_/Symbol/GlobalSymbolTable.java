package M_.Symbol;

import M_.AST.Location;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
/*
 * Global Symbol Table contains:
 * Basic type: int, bool void
 * Build-in type: string. And four build-in functions about string in manue.
 *      NULL as a build-in class
 * Build-in functions (totally five according manue)
 * 
 * Supported methods:
 *  Add and search a class symbol using name (build-in or self-design)
 *  Add and search a function (build-in or self-design) (extended)
 *  Search a type using name (only build-in type, int, bool, void)
 */

public class GlobalSymbolTable extends SymbolTable{
    public Map<String,ClassSymbol> classes;
    public Map<String,BaseSymbol> BasicType;
    public HashSet<VariableSymbol> globalInitUsedVariables;

    public GlobalSymbolTable(){
        super(null);
        classes = new Hashtable<>();
        BasicType = new Hashtable<>();
        globalInitUsedVariables = new HashSet<>();
        DefaultConstruct();
    }

    public BaseSymbol getBaseSymbol(String name){
        return BasicType.get(name);
    }

    public ClassSymbol getClassSymbol(String name){
        return classes.get(name);
    }

    public void putClassSymbol(String name, ClassSymbol symbol){
        classes.put(name, symbol);
    }

    private VariableType voidType(){
        return new PrimitiveType("void", BasicType.get("void"));
    }

    private VariableType intType(){
        return new PrimitiveType("int", BasicType.get("int"));
    }

    private VariableType stringType(){
        return new ClassType("string", classes.get("string"));
    }

    private FuncionSymbol stringLength(){
        FuncionSymbol ff = new FuncionSymbol();
        ff.name = "string.length";
        ff.returnType = intType();
        ff.location = new Location(0,0);
        ff.parameterNames.add("this");
        ff.parameterTypes.add(stringType());
        ff.isGlobalFunction = true;
        return ff;
    }

    private FuncionSymbol stringSubstring(){
        FuncionSymbol ff = new FuncionSymbol();
        ff.name = "string.substring";
        ff.returnType = stringType();
        ff.location = new Location(0,0);
        ff.parameterNames.add("this");
        ff.parameterTypes.add(stringType());
        ff.parameterNames.add("lhs");
        ff.parameterTypes.add(intType());
        ff.parameterNames.add("rhs");
        ff.parameterTypes.add(intType());
        ff.isGlobalFunction = true;
        return ff;
    }

    private FuncionSymbol stringParseInt(){
        FuncionSymbol ff = new FuncionSymbol();
        ff.name = "string.parseInt";
        ff.returnType = intType();
        ff.location = new Location(0,0);
        ff.parameterNames.add("this");
        ff.parameterTypes.add(stringType());
        ff.isGlobalFunction = true;
        return ff;
    }

    private FuncionSymbol stringOrd(){
        FuncionSymbol ff = new FuncionSymbol();
        ff.name = "string.ord";
        ff.returnType = intType();
        ff.location = new Location(0,0);
        ff.parameterNames.add("this");
        ff.parameterTypes.add(stringType());
        ff.parameterNames.add("pos");
        ff.parameterTypes.add(intType());
        ff.isGlobalFunction = true;
        return ff;
    }

    private FuncionSymbol globalPrint(){
        FuncionSymbol ff = new FuncionSymbol();
        ff.name = "print";
        ff.returnType = voidType();
        ff.location = new Location(0,0);
        ff.parameterNames.add("str");
        ff.parameterTypes.add(stringType());
        ff.isGlobalFunction = true;
        return ff;
    }

    private FuncionSymbol globalPrintln(){
        FuncionSymbol ff = new FuncionSymbol();
        ff.name = "println";
        ff.returnType = voidType();
        ff.location = new Location(0,0);
        ff.parameterNames.add("str");
        ff.parameterTypes.add(stringType());
        ff.isGlobalFunction = true;
        return ff;
    }

    private FuncionSymbol globalGetString(){
        FuncionSymbol ff = new FuncionSymbol();
        ff.name = "getString";
        ff.returnType = stringType();
        ff.location = new Location(0,0);
        ff.isGlobalFunction = true;
        return ff;
    }

    private FuncionSymbol globalGetInt(){
        FuncionSymbol ff = new FuncionSymbol();
        ff.name = "getInt";
        ff.returnType = intType();
        ff.location = new Location(0,0);
        ff.isGlobalFunction = true;
        return ff;
    }

    private FuncionSymbol globalToString(){
        FuncionSymbol ff = new FuncionSymbol();
        ff.name = "toString";
        ff.returnType = stringType();
        ff.location = new Location(0,0);
        ff.parameterNames.add("i");
        ff.parameterTypes.add(intType());
        ff.isGlobalFunction = true;
        return ff;
    }

    private void addDefaultBasicType(){
        BasicType.put("void", new BaseSymbol("void"));
        BasicType.put("int", new BaseSymbol("int"));
        BasicType.put("bool", new BaseSymbol("bool"));
    }

    private void addNullClass(){
        ClassSymbol NULL = new ClassSymbol();
        NULL.name = "null";
        NULL.location = new Location(0,0);
        NULL.classSymbolTable = new SymbolTable(this);
        putClassSymbol("null", NULL);
    }

    private void addStringClass(){
        ClassSymbol STRING = new ClassSymbol();
        STRING.name = "string";
        STRING.location = new Location(0,0);
        classes.put("string", STRING);
        SymbolTable ST = new SymbolTable(this);
        ST.putFunctionSymbol("length", stringLength());
        ST.putFunctionSymbol("substring", stringSubstring());
        ST.putFunctionSymbol("parseInt", stringParseInt());
        ST.putFunctionSymbol("ord", stringOrd());
        STRING.classSymbolTable = ST;
    }

    private void addBuildinFunc(){
        putFunctionSymbol("print", globalPrint());
        putFunctionSymbol("println", globalPrintln());
        putFunctionSymbol("getString", globalGetString());
        putFunctionSymbol("getInt", globalGetInt());
        putFunctionSymbol("toString", globalToString());
    }

    private void DefaultConstruct(){
        addDefaultBasicType();
        addNullClass();
        addStringClass();
        addBuildinFunc();
    }
}
