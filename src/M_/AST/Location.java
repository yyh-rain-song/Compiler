package M_.AST;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class Location {

    private int row;
    private int column;

    public Location(int row, int column) {
        this.row = row;
        this.column = column;
    }
    public Location(Token token) {
        row = token.getLine();
        column = token.getCharPositionInLine();
    }
    public Location(ParserRuleContext ctx) {
        this(ctx.start);
    }
    public Location(ASTnode node) {
        this.row = node.location.row;
        this.column = node.location.column;
    }

    @Override
    public String toString() {
        return "[" + row + "," + column + "]";
    }
}
