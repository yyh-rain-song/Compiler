package M_.AST;

import M_.Symbol.VariableSymbol;
import org.antlr.v4.runtime.Token;

//Variables name
public class Identifier extends Expression {
    public String name;
    public VariableSymbol symbol;

    //construct Identifier from a token, like "ID" in g4
    public Identifier(Token token) {
        this.name = token.getText();
        this.location = new Location(token);
    }

    @Override
    public void accept(IAstVisitor visitor) { visitor.visit(this); }
}
