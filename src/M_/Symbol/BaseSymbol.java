package M_.Symbol;

import M_.AST.Location;

public class BaseSymbol extends TypeSymbol {
    public String name;     //  symbol name and primitive type name is the same
    public Location locataion;

    public BaseSymbol() { }
    public BaseSymbol(String name) {
        this.name = name;
        this.locataion = new Location(0, 0);
    }
}
