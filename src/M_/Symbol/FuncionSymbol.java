package M_.Symbol;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import M_.AST.Location;

public class FuncionSymbol {
    public String name;
    public Location location;
    public VariableType returnType;
    public List<VariableType> parameterTypes;
    public List<String> parameterNames;
    public SymbolTable functionSymbolTable;

    public HashSet<VariableSymbol> usedGlobalVariables;
    public boolean isGlobalFunction;
    public boolean withSideEffect;
    public HashSet<FuncionSymbol> calleeSet;

    private HashSet<FuncionSymbol> visited;

    public FuncionSymbol() {
        this.parameterTypes = new LinkedList<>();
        this.parameterNames = new LinkedList<>();
        this.usedGlobalVariables = new HashSet<>();
        this.calleeSet = new HashSet<>();
        this.visited = new HashSet<>();
    }

    private boolean isPrimitiveType(VariableType vt){
        return vt instanceof PrimitiveType;
    }

    private void dfsSideEffect(FuncionSymbol fs){
        if(withSideEffect) return;
        if(visited.contains(fs)) return;
        visited.add(fs);
        for(FuncionSymbol f: fs.calleeSet){
            if(f.withSideEffect){
                withSideEffect = true;
                break;
            }
        }
    }
    public void finish(){
        for(VariableType vt: parameterTypes){
            if(!isPrimitiveType(vt))
                withSideEffect = true;
        }
        visited.clear();
        dfsSideEffect(this);
    }
}

