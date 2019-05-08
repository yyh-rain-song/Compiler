package M_.compile.front;

import M_.AST.Location;
import M_.compile.ErrorRecorder;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class SyntaxErrorListener extends BaseErrorListener {
    private ErrorRecorder recorder;

    public SyntaxErrorListener(ErrorRecorder recorder){this.recorder = recorder;}
    @Override
    public void syntaxError(Recognizer<?,?> rec, Object ofSymbol, int line, int row, String msg, RecognitionException e)
    {
        recorder.addRecord(new Location(line,row), msg);
    }
}
