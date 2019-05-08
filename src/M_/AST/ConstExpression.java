package M_.AST;

/*
* Dealing with input constant like "2333", "this is a string", "TRUE" etc.
* */

import M_.Parser.M_Parser;
import org.antlr.v4.runtime.Token;

public class ConstExpression extends Expression{
    public String typeName;
    public String value;

    //construct a ConstExpression from a token
    public ConstExpression(Token token) {
        if(token != null)
            value = token.getText();
        else
            System.out.println("a null token occur!");//TODO: add in error reporter

        switch (token.getType()) {
            case M_Parser.TRUE:
            case M_Parser.FALSE: typeName = "bool"; break;
            case M_Parser.INTEGER: typeName = "int"; break;
            case M_Parser.NULL: typeName = "null"; break;
            case M_Parser.STRING_CONST: typeName = "string"; escape(); break;
            default: System.out.println("There's some logical bugs in my code!");
        }
    }

    //dealing with "\\" "\n" "\t" "\"" "\b" "\r"
    private void escape() {
        StringBuilder stringBuilder = new StringBuilder();
        int length = value.length();
        for(int i = 0; i < length; i++) {
            char c = value.charAt(i);
            if(c == '\\') {
                char nx = value.charAt(i + 1);
                switch(nx) {
                    case '\\':
                        stringBuilder.append('\\');
                        break;
                    case 'n':
                        stringBuilder.append('\n');
                        break;
                    case 't':
                        stringBuilder.append('\t');
                        break;
                    case 'b':
                        stringBuilder.append('\b');
                        break;
                    case 'r':
                        stringBuilder.append('\r');
                        break;
                    case '"':
                        stringBuilder.append('\"');
                        break;
                    default:
                        stringBuilder.append(nx);
                }
                i++;
            } else {
                stringBuilder.append(c);
            }
        }
        value = stringBuilder.toString();
    }
    @Override
    public void accept(IAstVisitor visitor){visitor.visit(this);}
}
