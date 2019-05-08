package M_.Symbol;

import M_.AST.Location;

public class ClassSymbol extends TypeSymbol {
    public String name;     //  symbol name and class name are the same
    public Location location;
    public SymbolTable classSymbolTable;
}