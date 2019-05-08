package M_.Symbol;

import M_.Config;
import org.antlr.v4.misc.OrderedHashMap;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
* This class organized a symbol table in a tree format.
* Supports variable and function add and search.
* */
public class SymbolTable {
    public Map<String,VariableSymbol> variables;
    public Map<String, FuncionSymbol> functions;
    public SymbolTable parent;
    public List<SymbolTable> children;

    public Map<String, Integer> offsets;
    private Integer currentOffset;

    public SymbolTable(SymbolTable parent) {
        this.variables = new LinkedHashMap<>();
        this.functions = new LinkedHashMap<>();
        this.parent = parent;
        this.children = new LinkedList<>();
        this.offsets = new OrderedHashMap<>();
        this.currentOffset = 0;
    }
    public VariableSymbol getVariableSymbol(String name) {
        return variables.get(name);
    }
    public void putVariableSymbol(String name, VariableSymbol variableSymbol) {
        variables.put(name, variableSymbol);
        offsets.put(name, currentOffset);
        currentOffset += Config.REGISTER_WIDTH;
    }
    public FuncionSymbol getFunctionSymbol(String name) { return functions.get(name); }
    public void putFunctionSymbol(String name, FuncionSymbol symbol) {
        functions.put(name, symbol);
    }
    public int getVariableOffset(String name){
        return offsets.get(name);
    }
}
