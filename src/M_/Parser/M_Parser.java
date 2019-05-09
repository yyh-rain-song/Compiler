// Generated from D:/Compiler/codes/trial_1/src/M_\M_.g4 by ANTLR 4.7.2
package M_.Parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class M_Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, BOOL=33, INT=34, STRING=35, NULL=36, VOID=37, TRUE=38, FALSE=39, 
		IF=40, ELSE=41, FOR=42, WHILE=43, BREAK=44, CONTINUE=45, RETURN=46, NEW=47, 
		CLASS=48, THIS=49, ID=50, INTEGER=51, STRING_CONST=52, WS=53, LINE_COMMENT=54, 
		COMMENT=55;
	public static final int
		RULE_start = 0, RULE_program_unit = 1, RULE_variable_defination = 2, RULE_init_expr = 3, 
		RULE_malloc = 4, RULE_empty = 5, RULE_variable_name = 6, RULE_class_type = 7, 
		RULE_type = 8, RULE_class_defination = 9, RULE_class_function_defination = 10, 
		RULE_class_init_fun = 11, RULE_function_defination = 12, RULE_func_name = 13, 
		RULE_parameters = 14, RULE_parameter = 15, RULE_block = 16, RULE_sentence = 17, 
		RULE_declation = 18, RULE_expression = 19, RULE_emptye = 20, RULE_expr_statement = 21, 
		RULE_statement = 22, RULE_function_call = 23, RULE_const_ = 24, RULE_if_else = 25, 
		RULE_while_stm = 26, RULE_for_stm = 27, RULE_init = 28, RULE_update = 29, 
		RULE_termanite = 30, RULE_return_stm = 31;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "program_unit", "variable_defination", "init_expr", "malloc", 
			"empty", "variable_name", "class_type", "type", "class_defination", "class_function_defination", 
			"class_init_fun", "function_defination", "func_name", "parameters", "parameter", 
			"block", "sentence", "declation", "expression", "emptye", "expr_statement", 
			"statement", "function_call", "const_", "if_else", "while_stm", "for_stm", 
			"init", "update", "termanite", "return_stm"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'='", "'['", "']'", "'('", "')'", "'{'", "'}'", "','", 
			"'++'", "'--'", "'.'", "'+'", "'-'", "'~'", "'!'", "'*'", "'/'", "'%'", 
			"'<<'", "'>>'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&'", 
			"'^'", "'|'", "'&&'", "'||'", "'bool'", "'int'", "'string'", "'null'", 
			"'void'", "'true'", "'false'", "'if'", "'else'", "'for'", "'while'", 
			"'break'", "'continue'", "'return'", "'new'", "'class'", "'this'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "BOOL", "INT", 
			"STRING", "NULL", "VOID", "TRUE", "FALSE", "IF", "ELSE", "FOR", "WHILE", 
			"BREAK", "CONTINUE", "RETURN", "NEW", "CLASS", "THIS", "ID", "INTEGER", 
			"STRING_CONST", "WS", "LINE_COMMENT", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "M_.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public M_Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public List<Program_unitContext> program_unit() {
			return getRuleContexts(Program_unitContext.class);
		}
		public Program_unitContext program_unit(int i) {
			return getRuleContext(Program_unitContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << VOID) | (1L << CLASS) | (1L << ID))) != 0)) {
				{
				{
				setState(64);
				program_unit();
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Program_unitContext extends ParserRuleContext {
		public Variable_definationContext variable_defination() {
			return getRuleContext(Variable_definationContext.class,0);
		}
		public Function_definationContext function_defination() {
			return getRuleContext(Function_definationContext.class,0);
		}
		public Class_definationContext class_defination() {
			return getRuleContext(Class_definationContext.class,0);
		}
		public Program_unitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program_unit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitProgram_unit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Program_unitContext program_unit() throws RecognitionException {
		Program_unitContext _localctx = new Program_unitContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program_unit);
		try {
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				variable_defination();
				setState(71);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				function_defination();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				class_defination();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Variable_definationContext extends ParserRuleContext {
		public Class_typeContext class_type() {
			return getRuleContext(Class_typeContext.class,0);
		}
		public Variable_nameContext variable_name() {
			return getRuleContext(Variable_nameContext.class,0);
		}
		public Init_exprContext init_expr() {
			return getRuleContext(Init_exprContext.class,0);
		}
		public Variable_definationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_defination; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitVariable_defination(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_definationContext variable_defination() throws RecognitionException {
		Variable_definationContext _localctx = new Variable_definationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variable_defination);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			class_type(0);
			setState(78);
			variable_name();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(79);
				match(T__1);
				setState(80);
				init_expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Init_exprContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Init_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitInit_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Init_exprContext init_expr() throws RecognitionException {
		Init_exprContext _localctx = new Init_exprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_init_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			statement(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MallocContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(M_Parser.NEW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<EmptyContext> empty() {
			return getRuleContexts(EmptyContext.class);
		}
		public EmptyContext empty(int i) {
			return getRuleContext(EmptyContext.class,i);
		}
		public MallocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_malloc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitMalloc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MallocContext malloc() throws RecognitionException {
		MallocContext _localctx = new MallocContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_malloc);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(NEW);
			setState(86);
			type();
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(93);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(87);
						match(T__2);
						setState(88);
						statement(0);
						setState(89);
						match(T__3);
						}
						} 
					}
					setState(95);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(102);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(96);
						match(T__2);
						setState(97);
						empty();
						setState(98);
						match(T__3);
						}
						} 
					}
					setState(104);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				}
				break;
			case 2:
				{
				setState(105);
				match(T__4);
				setState(106);
				match(T__5);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmptyContext extends ParserRuleContext {
		public EmptyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_empty; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitEmpty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyContext empty() throws RecognitionException {
		EmptyContext _localctx = new EmptyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_empty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Variable_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(M_Parser.ID, 0); }
		public Variable_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitVariable_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_nameContext variable_name() throws RecognitionException {
		Variable_nameContext _localctx = new Variable_nameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variable_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_typeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Class_typeContext class_type() {
			return getRuleContext(Class_typeContext.class,0);
		}
		public Class_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitClass_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_typeContext class_type() throws RecognitionException {
		return class_type(0);
	}

	private Class_typeContext class_type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Class_typeContext _localctx = new Class_typeContext(_ctx, _parentState);
		Class_typeContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_class_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(114);
			type();
			}
			_ctx.stop = _input.LT(-1);
			setState(121);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Class_typeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_class_type);
					setState(116);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(117);
					match(T__2);
					setState(118);
					match(T__3);
					}
					} 
				}
				setState(123);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VoidContext extends TypeContext {
		public TerminalNode VOID() { return getToken(M_Parser.VOID, 0); }
		public VoidContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitVoid(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContext extends TypeContext {
		public TerminalNode STRING() { return getToken(M_Parser.STRING, 0); }
		public StringContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolContext extends TypeContext {
		public TerminalNode BOOL() { return getToken(M_Parser.BOOL, 0); }
		public BoolContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends TypeContext {
		public TerminalNode INT() { return getToken(M_Parser.INT, 0); }
		public IntContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OthersContext extends TypeContext {
		public Variable_nameContext variable_name() {
			return getRuleContext(Variable_nameContext.class,0);
		}
		public OthersContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitOthers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type);
		try {
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				match(INT);
				}
				break;
			case STRING:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				match(STRING);
				}
				break;
			case BOOL:
				_localctx = new BoolContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(126);
				match(BOOL);
				}
				break;
			case VOID:
				_localctx = new VoidContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(127);
				match(VOID);
				}
				break;
			case ID:
				_localctx = new OthersContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(128);
				variable_name();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_definationContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(M_Parser.CLASS, 0); }
		public TerminalNode ID() { return getToken(M_Parser.ID, 0); }
		public List<Class_function_definationContext> class_function_defination() {
			return getRuleContexts(Class_function_definationContext.class);
		}
		public Class_function_definationContext class_function_defination(int i) {
			return getRuleContext(Class_function_definationContext.class,i);
		}
		public List<Variable_definationContext> variable_defination() {
			return getRuleContexts(Variable_definationContext.class);
		}
		public Variable_definationContext variable_defination(int i) {
			return getRuleContext(Variable_definationContext.class,i);
		}
		public Class_definationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_defination; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitClass_defination(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_definationContext class_defination() throws RecognitionException {
		Class_definationContext _localctx = new Class_definationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_class_defination);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(CLASS);
			setState(132);
			match(ID);
			setState(133);
			match(T__6);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << VOID) | (1L << ID))) != 0)) {
				{
				setState(138);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					{
					setState(134);
					variable_defination();
					setState(135);
					match(T__0);
					}
					}
					break;
				case 2:
					{
					setState(137);
					class_function_defination();
					}
					break;
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(143);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_function_definationContext extends ParserRuleContext {
		public Class_init_funContext class_init_fun() {
			return getRuleContext(Class_init_funContext.class,0);
		}
		public Function_definationContext function_defination() {
			return getRuleContext(Function_definationContext.class,0);
		}
		public Class_function_definationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_function_defination; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitClass_function_defination(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_function_definationContext class_function_defination() throws RecognitionException {
		Class_function_definationContext _localctx = new Class_function_definationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_class_function_defination);
		try {
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				class_init_fun();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				function_defination();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_init_funContext extends ParserRuleContext {
		public Func_nameContext func_name() {
			return getRuleContext(Func_nameContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Class_init_funContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_init_fun; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitClass_init_fun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_init_funContext class_init_fun() throws RecognitionException {
		Class_init_funContext _localctx = new Class_init_funContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_class_init_fun);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			func_name();
			setState(150);
			match(T__4);
			setState(151);
			match(T__5);
			setState(152);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Function_definationContext extends ParserRuleContext {
		public Class_typeContext class_type() {
			return getRuleContext(Class_typeContext.class,0);
		}
		public Func_nameContext func_name() {
			return getRuleContext(Func_nameContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public Function_definationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_defination; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitFunction_defination(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_definationContext function_defination() throws RecognitionException {
		Function_definationContext _localctx = new Function_definationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_function_defination);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			class_type(0);
			setState(155);
			func_name();
			setState(156);
			match(T__4);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << VOID) | (1L << ID))) != 0)) {
				{
				setState(157);
				parameters();
				}
			}

			setState(160);
			match(T__5);
			setState(161);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(M_Parser.ID, 0); }
		public Func_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitFunc_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_nameContext func_name() throws RecognitionException {
		Func_nameContext _localctx = new Func_nameContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_func_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(165);
			parameter();
			}
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(166);
				match(T__8);
				setState(167);
				parameter();
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public Class_typeContext class_type() {
			return getRuleContext(Class_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(M_Parser.ID, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			class_type(0);
			setState(174);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(T__6);
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << T__6) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << NULL) | (1L << VOID) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CONTINUE) | (1L << RETURN) | (1L << NEW) | (1L << THIS) | (1L << ID) | (1L << INTEGER) | (1L << STRING_CONST))) != 0)) {
				{
				{
				setState(177);
				sentence();
				}
				}
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(183);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenceContext extends ParserRuleContext {
		public DeclationContext declation() {
			return getRuleContext(DeclationContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitSentence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_sentence);
		try {
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(185);
				declation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclationContext extends ParserRuleContext {
		public Variable_definationContext variable_defination() {
			return getRuleContext(Variable_definationContext.class,0);
		}
		public DeclationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitDeclation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclationContext declation() throws RecognitionException {
		DeclationContext _localctx = new DeclationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_declation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			variable_defination();
			setState(190);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode BREAK() { return getToken(M_Parser.BREAK, 0); }
		public TerminalNode CONTINUE() { return getToken(M_Parser.CONTINUE, 0); }
		public Expr_statementContext expr_statement() {
			return getRuleContext(Expr_statementContext.class,0);
		}
		public If_elseContext if_else() {
			return getRuleContext(If_elseContext.class,0);
		}
		public While_stmContext while_stm() {
			return getRuleContext(While_stmContext.class,0);
		}
		public For_stmContext for_stm() {
			return getRuleContext(For_stmContext.class,0);
		}
		public Return_stmContext return_stm() {
			return getRuleContext(Return_stmContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public EmptyeContext emptye() {
			return getRuleContext(EmptyeContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expression);
		try {
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BREAK:
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				match(BREAK);
				setState(193);
				match(T__0);
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				match(CONTINUE);
				setState(195);
				match(T__0);
				}
				break;
			case T__4:
			case T__9:
			case T__10:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case NULL:
			case TRUE:
			case FALSE:
			case NEW:
			case THIS:
			case ID:
			case INTEGER:
			case STRING_CONST:
				enterOuterAlt(_localctx, 3);
				{
				setState(196);
				expr_statement();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 4);
				{
				setState(197);
				if_else();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 5);
				{
				setState(198);
				while_stm();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 6);
				{
				setState(199);
				for_stm();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 7);
				{
				setState(200);
				return_stm();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 8);
				{
				setState(201);
				block();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 9);
				{
				setState(202);
				emptye();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmptyeContext extends ParserRuleContext {
		public EmptyeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptye; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitEmptye(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyeContext emptye() throws RecognitionException {
		EmptyeContext _localctx = new EmptyeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_emptye);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_statementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Expr_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitExpr_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_statementContext expr_statement() throws RecognitionException {
		Expr_statementContext _localctx = new Expr_statementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expr_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			statement(0);
			setState(208);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Pos_negContext extends StatementContext {
		public Token op;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Pos_negContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitPos_neg(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddContext extends StatementContext {
		public Token op;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public AddContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalnotContext extends StatementContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public LogicalnotContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitLogicalnot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompareContext extends StatementContext {
		public Token op;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public CompareContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitCompare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstantContext extends StatementContext {
		public Const_Context const_() {
			return getRuleContext(Const_Context.class,0);
		}
		public ConstantContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulContext extends StatementContext {
		public Token op;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MulContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitMul(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixContext extends StatementContext {
		public Token op;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public PrefixContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitPrefix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitorContext extends StatementContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BitorContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitBitor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Class_funcContext extends StatementContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Class_funcContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitClass_func(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IndexContext extends StatementContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IndexContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitIndex(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitshiftContext extends StatementContext {
		public Token op;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BitshiftContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitBitshift(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Func_callContext extends StatementContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Func_callContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitFunc_call(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalContext extends StatementContext {
		public Token op;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public LogicalContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitLogical(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualContext extends StatementContext {
		public Token op;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public EqualContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class This_Context extends StatementContext {
		public TerminalNode THIS() { return getToken(M_Parser.THIS, 0); }
		public This_Context(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitThis_(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitandContext extends StatementContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BitandContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitBitand(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitxorContext extends StatementContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BitxorContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitBitxor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableContext extends StatementContext {
		public TerminalNode ID() { return getToken(M_Parser.ID, 0); }
		public VariableContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Class_memberContext extends StatementContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode ID() { return getToken(M_Parser.ID, 0); }
		public Class_memberContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitClass_member(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class New_stContext extends StatementContext {
		public MallocContext malloc() {
			return getRuleContext(MallocContext.class,0);
		}
		public New_stContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitNew_st(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlanketContext extends StatementContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BlanketContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitBlanket(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PostfixContext extends StatementContext {
		public Token op;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public PostfixContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitPostfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitnotContext extends StatementContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BitnotContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitBitnot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends StatementContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public AssignContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		return statement(0);
	}

	private StatementContext statement(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatementContext _localctx = new StatementContext(_ctx, _parentState);
		StatementContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_statement, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new Func_callContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(211);
				function_call();
				}
				break;
			case 2:
				{
				_localctx = new PrefixContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212);
				((PrefixContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__9 || _la==T__10) ) {
					((PrefixContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(213);
				statement(19);
				}
				break;
			case 3:
				{
				_localctx = new Pos_negContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214);
				((Pos_negContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__13) ) {
					((Pos_negContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(215);
				statement(18);
				}
				break;
			case 4:
				{
				_localctx = new BitnotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216);
				match(T__14);
				setState(217);
				statement(17);
				}
				break;
			case 5:
				{
				_localctx = new LogicalnotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(218);
				match(T__15);
				setState(219);
				statement(16);
				}
				break;
			case 6:
				{
				_localctx = new New_stContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(220);
				malloc();
				}
				break;
			case 7:
				{
				_localctx = new ConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(221);
				const_();
				}
				break;
			case 8:
				{
				_localctx = new This_Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(222);
				match(THIS);
				}
				break;
			case 9:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(223);
				match(ID);
				}
				break;
			case 10:
				{
				_localctx = new BlanketContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(224);
				match(T__4);
				setState(225);
				statement(0);
				setState(226);
				match(T__5);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(275);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(273);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new MulContext(new StatementContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_statement);
						setState(230);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(231);
						((MulContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << T__18))) != 0)) ) {
							((MulContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(232);
						statement(15);
						}
						break;
					case 2:
						{
						_localctx = new AddContext(new StatementContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_statement);
						setState(233);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(234);
						((AddContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__12 || _la==T__13) ) {
							((AddContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(235);
						statement(14);
						}
						break;
					case 3:
						{
						_localctx = new BitshiftContext(new StatementContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_statement);
						setState(236);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(237);
						((BitshiftContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__20) ) {
							((BitshiftContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(238);
						statement(13);
						}
						break;
					case 4:
						{
						_localctx = new CompareContext(new StatementContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_statement);
						setState(239);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(240);
						((CompareContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24))) != 0)) ) {
							((CompareContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(241);
						statement(12);
						}
						break;
					case 5:
						{
						_localctx = new EqualContext(new StatementContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_statement);
						setState(242);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(243);
						((EqualContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__25 || _la==T__26) ) {
							((EqualContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(244);
						statement(11);
						}
						break;
					case 6:
						{
						_localctx = new BitandContext(new StatementContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_statement);
						setState(245);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(246);
						match(T__27);
						setState(247);
						statement(10);
						}
						break;
					case 7:
						{
						_localctx = new BitxorContext(new StatementContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_statement);
						setState(248);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(249);
						match(T__28);
						setState(250);
						statement(9);
						}
						break;
					case 8:
						{
						_localctx = new BitorContext(new StatementContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_statement);
						setState(251);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(252);
						match(T__29);
						setState(253);
						statement(8);
						}
						break;
					case 9:
						{
						_localctx = new LogicalContext(new StatementContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_statement);
						setState(254);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(255);
						((LogicalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__30 || _la==T__31) ) {
							((LogicalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(256);
						statement(7);
						}
						break;
					case 10:
						{
						_localctx = new AssignContext(new StatementContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_statement);
						setState(257);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(258);
						match(T__1);
						setState(259);
						statement(2);
						}
						break;
					case 11:
						{
						_localctx = new PostfixContext(new StatementContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_statement);
						setState(260);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(261);
						((PostfixContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__9 || _la==T__10) ) {
							((PostfixContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					case 12:
						{
						_localctx = new IndexContext(new StatementContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_statement);
						setState(262);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(263);
						match(T__2);
						setState(264);
						statement(0);
						setState(265);
						match(T__3);
						}
						break;
					case 13:
						{
						_localctx = new Class_memberContext(new StatementContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_statement);
						setState(267);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(268);
						match(T__11);
						setState(269);
						match(ID);
						}
						break;
					case 14:
						{
						_localctx = new Class_funcContext(new StatementContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_statement);
						setState(270);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(271);
						match(T__11);
						setState(272);
						function_call();
						}
						break;
					}
					} 
				}
				setState(277);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Function_callContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(M_Parser.ID, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(ID);
			setState(279);
			match(T__4);
			setState(290);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NEW) | (1L << THIS) | (1L << ID) | (1L << INTEGER) | (1L << STRING_CONST))) != 0)) {
					{
					setState(280);
					statement(0);
					}
				}

				}
				break;
			case 2:
				{
				setState(283);
				statement(0);
				setState(286); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(284);
					match(T__8);
					setState(285);
					statement(0);
					}
					}
					setState(288); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__8 );
				}
				break;
			}
			setState(292);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Const_Context extends ParserRuleContext {
		public Const_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_; }
	 
		public Const_Context() { }
		public void copyFrom(Const_Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NullContext extends Const_Context {
		public TerminalNode NULL() { return getToken(M_Parser.NULL, 0); }
		public NullContext(Const_Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitNull(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueContext extends Const_Context {
		public TerminalNode TRUE() { return getToken(M_Parser.TRUE, 0); }
		public TrueContext(Const_Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseContext extends Const_Context {
		public TerminalNode FALSE() { return getToken(M_Parser.FALSE, 0); }
		public FalseContext(Const_Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerContext extends Const_Context {
		public TerminalNode INTEGER() { return getToken(M_Parser.INTEGER, 0); }
		public IntegerContext(Const_Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class String_constContext extends Const_Context {
		public TerminalNode STRING_CONST() { return getToken(M_Parser.STRING_CONST, 0); }
		public String_constContext(Const_Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitString_const(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Const_Context const_() throws RecognitionException {
		Const_Context _localctx = new Const_Context(_ctx, getState());
		enterRule(_localctx, 48, RULE_const_);
		try {
			setState(299);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_CONST:
				_localctx = new String_constContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(294);
				match(STRING_CONST);
				}
				break;
			case INTEGER:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(295);
				match(INTEGER);
				}
				break;
			case TRUE:
				_localctx = new TrueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(296);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new FalseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(297);
				match(FALSE);
				}
				break;
			case NULL:
				_localctx = new NullContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(298);
				match(NULL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_elseContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(M_Parser.IF, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(M_Parser.ELSE, 0); }
		public If_elseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_else; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitIf_else(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_elseContext if_else() throws RecognitionException {
		If_elseContext _localctx = new If_elseContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_if_else);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(IF);
			setState(302);
			match(T__4);
			setState(303);
			statement(0);
			setState(304);
			match(T__5);
			setState(305);
			expression();
			setState(308);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(306);
				match(ELSE);
				setState(307);
				expression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_stmContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(M_Parser.WHILE, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public While_stmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitWhile_stm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_stmContext while_stm() throws RecognitionException {
		While_stmContext _localctx = new While_stmContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_while_stm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			match(WHILE);
			setState(311);
			match(T__4);
			setState(312);
			statement(0);
			setState(313);
			match(T__5);
			setState(314);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class For_stmContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(M_Parser.FOR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public TermaniteContext termanite() {
			return getRuleContext(TermaniteContext.class,0);
		}
		public UpdateContext update() {
			return getRuleContext(UpdateContext.class,0);
		}
		public For_stmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitFor_stm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_stmContext for_stm() throws RecognitionException {
		For_stmContext _localctx = new For_stmContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_for_stm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			match(FOR);
			setState(317);
			match(T__4);
			setState(319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NEW) | (1L << THIS) | (1L << ID) | (1L << INTEGER) | (1L << STRING_CONST))) != 0)) {
				{
				setState(318);
				init();
				}
			}

			setState(321);
			match(T__0);
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NEW) | (1L << THIS) | (1L << ID) | (1L << INTEGER) | (1L << STRING_CONST))) != 0)) {
				{
				setState(322);
				termanite();
				}
			}

			setState(325);
			match(T__0);
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NEW) | (1L << THIS) | (1L << ID) | (1L << INTEGER) | (1L << STRING_CONST))) != 0)) {
				{
				setState(326);
				update();
				}
			}

			setState(329);
			match(T__5);
			setState(330);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			statement(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UpdateContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public UpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitUpdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdateContext update() throws RecognitionException {
		UpdateContext _localctx = new UpdateContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_update);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			statement(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermaniteContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TermaniteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termanite; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitTermanite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermaniteContext termanite() throws RecognitionException {
		TermaniteContext _localctx = new TermaniteContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_termanite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			statement(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_stmContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(M_Parser.RETURN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Return_stmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof M_Visitor ) return ((M_Visitor<? extends T>)visitor).visitReturn_stm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_stmContext return_stm() throws RecognitionException {
		Return_stmContext _localctx = new Return_stmContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_return_stm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			match(RETURN);
			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NEW) | (1L << THIS) | (1L << ID) | (1L << INTEGER) | (1L << STRING_CONST))) != 0)) {
				{
				setState(339);
				statement(0);
				}
			}

			setState(342);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return class_type_sempred((Class_typeContext)_localctx, predIndex);
		case 22:
			return statement_sempred((StatementContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean class_type_sempred(Class_typeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean statement_sempred(StatementContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 8);
		case 8:
			return precpred(_ctx, 7);
		case 9:
			return precpred(_ctx, 6);
		case 10:
			return precpred(_ctx, 1);
		case 11:
			return precpred(_ctx, 24);
		case 12:
			return precpred(_ctx, 22);
		case 13:
			return precpred(_ctx, 21);
		case 14:
			return precpred(_ctx, 20);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\39\u015b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\7\2D\n\2\f\2\16\2G\13\2\3\3\3\3\3\3\3\3\3\3\5\3N\n\3\3\4\3\4\3"+
		"\4\3\4\5\4T\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6^\n\6\f\6\16\6a\13"+
		"\6\3\6\3\6\3\6\3\6\7\6g\n\6\f\6\16\6j\13\6\3\6\3\6\5\6n\n\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\7\tz\n\t\f\t\16\t}\13\t\3\n\3\n\3\n\3\n"+
		"\3\n\5\n\u0084\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u008d\n\13"+
		"\f\13\16\13\u0090\13\13\3\13\3\13\3\f\3\f\5\f\u0096\n\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\5\16\u00a1\n\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\20\3\20\3\20\7\20\u00ab\n\20\f\20\16\20\u00ae\13\20\3\21\3\21\3\21\3"+
		"\22\3\22\7\22\u00b5\n\22\f\22\16\22\u00b8\13\22\3\22\3\22\3\23\3\23\5"+
		"\23\u00be\n\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\5\25\u00ce\n\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\5\30\u00e7\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\7\30\u0114\n\30\f\30\16\30\u0117\13\30\3\31"+
		"\3\31\3\31\5\31\u011c\n\31\3\31\3\31\3\31\6\31\u0121\n\31\r\31\16\31\u0122"+
		"\5\31\u0125\n\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\5\32\u012e\n\32\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0137\n\33\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\5\35\u0142\n\35\3\35\3\35\5\35\u0146\n\35\3"+
		"\35\3\35\5\35\u014a\n\35\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3"+
		"!\5!\u0157\n!\3!\3!\3!\2\4\20.\"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@\2\t\3\2\f\r\3\2\17\20\3\2\23\25\3\2\26\27\3"+
		"\2\30\33\3\2\34\35\3\2!\"\2\u0178\2E\3\2\2\2\4M\3\2\2\2\6O\3\2\2\2\bU"+
		"\3\2\2\2\nW\3\2\2\2\fo\3\2\2\2\16q\3\2\2\2\20s\3\2\2\2\22\u0083\3\2\2"+
		"\2\24\u0085\3\2\2\2\26\u0095\3\2\2\2\30\u0097\3\2\2\2\32\u009c\3\2\2\2"+
		"\34\u00a5\3\2\2\2\36\u00a7\3\2\2\2 \u00af\3\2\2\2\"\u00b2\3\2\2\2$\u00bd"+
		"\3\2\2\2&\u00bf\3\2\2\2(\u00cd\3\2\2\2*\u00cf\3\2\2\2,\u00d1\3\2\2\2."+
		"\u00e6\3\2\2\2\60\u0118\3\2\2\2\62\u012d\3\2\2\2\64\u012f\3\2\2\2\66\u0138"+
		"\3\2\2\28\u013e\3\2\2\2:\u014e\3\2\2\2<\u0150\3\2\2\2>\u0152\3\2\2\2@"+
		"\u0154\3\2\2\2BD\5\4\3\2CB\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\3\3"+
		"\2\2\2GE\3\2\2\2HI\5\6\4\2IJ\7\3\2\2JN\3\2\2\2KN\5\32\16\2LN\5\24\13\2"+
		"MH\3\2\2\2MK\3\2\2\2ML\3\2\2\2N\5\3\2\2\2OP\5\20\t\2PS\5\16\b\2QR\7\4"+
		"\2\2RT\5\b\5\2SQ\3\2\2\2ST\3\2\2\2T\7\3\2\2\2UV\5.\30\2V\t\3\2\2\2WX\7"+
		"\61\2\2Xm\5\22\n\2YZ\7\5\2\2Z[\5.\30\2[\\\7\6\2\2\\^\3\2\2\2]Y\3\2\2\2"+
		"^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`h\3\2\2\2a_\3\2\2\2bc\7\5\2\2cd\5\f\7\2"+
		"de\7\6\2\2eg\3\2\2\2fb\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2in\3\2\2\2"+
		"jh\3\2\2\2kl\7\7\2\2ln\7\b\2\2m_\3\2\2\2mk\3\2\2\2n\13\3\2\2\2op\3\2\2"+
		"\2p\r\3\2\2\2qr\7\64\2\2r\17\3\2\2\2st\b\t\1\2tu\5\22\n\2u{\3\2\2\2vw"+
		"\f\4\2\2wx\7\5\2\2xz\7\6\2\2yv\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|"+
		"\21\3\2\2\2}{\3\2\2\2~\u0084\7$\2\2\177\u0084\7%\2\2\u0080\u0084\7#\2"+
		"\2\u0081\u0084\7\'\2\2\u0082\u0084\5\16\b\2\u0083~\3\2\2\2\u0083\177\3"+
		"\2\2\2\u0083\u0080\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0082\3\2\2\2\u0084"+
		"\23\3\2\2\2\u0085\u0086\7\62\2\2\u0086\u0087\7\64\2\2\u0087\u008e\7\t"+
		"\2\2\u0088\u0089\5\6\4\2\u0089\u008a\7\3\2\2\u008a\u008d\3\2\2\2\u008b"+
		"\u008d\5\26\f\2\u008c\u0088\3\2\2\2\u008c\u008b\3\2\2\2\u008d\u0090\3"+
		"\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0091\u0092\7\n\2\2\u0092\25\3\2\2\2\u0093\u0096\5\30\r"+
		"\2\u0094\u0096\5\32\16\2\u0095\u0093\3\2\2\2\u0095\u0094\3\2\2\2\u0096"+
		"\27\3\2\2\2\u0097\u0098\5\34\17\2\u0098\u0099\7\7\2\2\u0099\u009a\7\b"+
		"\2\2\u009a\u009b\5\"\22\2\u009b\31\3\2\2\2\u009c\u009d\5\20\t\2\u009d"+
		"\u009e\5\34\17\2\u009e\u00a0\7\7\2\2\u009f\u00a1\5\36\20\2\u00a0\u009f"+
		"\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\7\b\2\2\u00a3"+
		"\u00a4\5\"\22\2\u00a4\33\3\2\2\2\u00a5\u00a6\7\64\2\2\u00a6\35\3\2\2\2"+
		"\u00a7\u00ac\5 \21\2\u00a8\u00a9\7\13\2\2\u00a9\u00ab\5 \21\2\u00aa\u00a8"+
		"\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\37\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b0\5\20\t\2\u00b0\u00b1\7\64"+
		"\2\2\u00b1!\3\2\2\2\u00b2\u00b6\7\t\2\2\u00b3\u00b5\5$\23\2\u00b4\u00b3"+
		"\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\u00b9\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\7\n\2\2\u00ba#\3\2\2\2"+
		"\u00bb\u00be\5&\24\2\u00bc\u00be\5(\25\2\u00bd\u00bb\3\2\2\2\u00bd\u00bc"+
		"\3\2\2\2\u00be%\3\2\2\2\u00bf\u00c0\5\6\4\2\u00c0\u00c1\7\3\2\2\u00c1"+
		"\'\3\2\2\2\u00c2\u00c3\7.\2\2\u00c3\u00ce\7\3\2\2\u00c4\u00c5\7/\2\2\u00c5"+
		"\u00ce\7\3\2\2\u00c6\u00ce\5,\27\2\u00c7\u00ce\5\64\33\2\u00c8\u00ce\5"+
		"\66\34\2\u00c9\u00ce\58\35\2\u00ca\u00ce\5@!\2\u00cb\u00ce\5\"\22\2\u00cc"+
		"\u00ce\5*\26\2\u00cd\u00c2\3\2\2\2\u00cd\u00c4\3\2\2\2\u00cd\u00c6\3\2"+
		"\2\2\u00cd\u00c7\3\2\2\2\u00cd\u00c8\3\2\2\2\u00cd\u00c9\3\2\2\2\u00cd"+
		"\u00ca\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce)\3\2\2\2"+
		"\u00cf\u00d0\7\3\2\2\u00d0+\3\2\2\2\u00d1\u00d2\5.\30\2\u00d2\u00d3\7"+
		"\3\2\2\u00d3-\3\2\2\2\u00d4\u00d5\b\30\1\2\u00d5\u00e7\5\60\31\2\u00d6"+
		"\u00d7\t\2\2\2\u00d7\u00e7\5.\30\25\u00d8\u00d9\t\3\2\2\u00d9\u00e7\5"+
		".\30\24\u00da\u00db\7\21\2\2\u00db\u00e7\5.\30\23\u00dc\u00dd\7\22\2\2"+
		"\u00dd\u00e7\5.\30\22\u00de\u00e7\5\n\6\2\u00df\u00e7\5\62\32\2\u00e0"+
		"\u00e7\7\63\2\2\u00e1\u00e7\7\64\2\2\u00e2\u00e3\7\7\2\2\u00e3\u00e4\5"+
		".\30\2\u00e4\u00e5\7\b\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00d4\3\2\2\2\u00e6"+
		"\u00d6\3\2\2\2\u00e6\u00d8\3\2\2\2\u00e6\u00da\3\2\2\2\u00e6\u00dc\3\2"+
		"\2\2\u00e6\u00de\3\2\2\2\u00e6\u00df\3\2\2\2\u00e6\u00e0\3\2\2\2\u00e6"+
		"\u00e1\3\2\2\2\u00e6\u00e2\3\2\2\2\u00e7\u0115\3\2\2\2\u00e8\u00e9\f\20"+
		"\2\2\u00e9\u00ea\t\4\2\2\u00ea\u0114\5.\30\21\u00eb\u00ec\f\17\2\2\u00ec"+
		"\u00ed\t\3\2\2\u00ed\u0114\5.\30\20\u00ee\u00ef\f\16\2\2\u00ef\u00f0\t"+
		"\5\2\2\u00f0\u0114\5.\30\17\u00f1\u00f2\f\r\2\2\u00f2\u00f3\t\6\2\2\u00f3"+
		"\u0114\5.\30\16\u00f4\u00f5\f\f\2\2\u00f5\u00f6\t\7\2\2\u00f6\u0114\5"+
		".\30\r\u00f7\u00f8\f\13\2\2\u00f8\u00f9\7\36\2\2\u00f9\u0114\5.\30\f\u00fa"+
		"\u00fb\f\n\2\2\u00fb\u00fc\7\37\2\2\u00fc\u0114\5.\30\13\u00fd\u00fe\f"+
		"\t\2\2\u00fe\u00ff\7 \2\2\u00ff\u0114\5.\30\n\u0100\u0101\f\b\2\2\u0101"+
		"\u0102\t\b\2\2\u0102\u0114\5.\30\t\u0103\u0104\f\3\2\2\u0104\u0105\7\4"+
		"\2\2\u0105\u0114\5.\30\4\u0106\u0107\f\32\2\2\u0107\u0114\t\2\2\2\u0108"+
		"\u0109\f\30\2\2\u0109\u010a\7\5\2\2\u010a\u010b\5.\30\2\u010b\u010c\7"+
		"\6\2\2\u010c\u0114\3\2\2\2\u010d\u010e\f\27\2\2\u010e\u010f\7\16\2\2\u010f"+
		"\u0114\7\64\2\2\u0110\u0111\f\26\2\2\u0111\u0112\7\16\2\2\u0112\u0114"+
		"\5\60\31\2\u0113\u00e8\3\2\2\2\u0113\u00eb\3\2\2\2\u0113\u00ee\3\2\2\2"+
		"\u0113\u00f1\3\2\2\2\u0113\u00f4\3\2\2\2\u0113\u00f7\3\2\2\2\u0113\u00fa"+
		"\3\2\2\2\u0113\u00fd\3\2\2\2\u0113\u0100\3\2\2\2\u0113\u0103\3\2\2\2\u0113"+
		"\u0106\3\2\2\2\u0113\u0108\3\2\2\2\u0113\u010d\3\2\2\2\u0113\u0110\3\2"+
		"\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116"+
		"/\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u0119\7\64\2\2\u0119\u0124\7\7\2\2"+
		"\u011a\u011c\5.\30\2\u011b\u011a\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u0125"+
		"\3\2\2\2\u011d\u0120\5.\30\2\u011e\u011f\7\13\2\2\u011f\u0121\5.\30\2"+
		"\u0120\u011e\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123"+
		"\3\2\2\2\u0123\u0125\3\2\2\2\u0124\u011b\3\2\2\2\u0124\u011d\3\2\2\2\u0125"+
		"\u0126\3\2\2\2\u0126\u0127\7\b\2\2\u0127\61\3\2\2\2\u0128\u012e\7\66\2"+
		"\2\u0129\u012e\7\65\2\2\u012a\u012e\7(\2\2\u012b\u012e\7)\2\2\u012c\u012e"+
		"\7&\2\2\u012d\u0128\3\2\2\2\u012d\u0129\3\2\2\2\u012d\u012a\3\2\2\2\u012d"+
		"\u012b\3\2\2\2\u012d\u012c\3\2\2\2\u012e\63\3\2\2\2\u012f\u0130\7*\2\2"+
		"\u0130\u0131\7\7\2\2\u0131\u0132\5.\30\2\u0132\u0133\7\b\2\2\u0133\u0136"+
		"\5(\25\2\u0134\u0135\7+\2\2\u0135\u0137\5(\25\2\u0136\u0134\3\2\2\2\u0136"+
		"\u0137\3\2\2\2\u0137\65\3\2\2\2\u0138\u0139\7-\2\2\u0139\u013a\7\7\2\2"+
		"\u013a\u013b\5.\30\2\u013b\u013c\7\b\2\2\u013c\u013d\5(\25\2\u013d\67"+
		"\3\2\2\2\u013e\u013f\7,\2\2\u013f\u0141\7\7\2\2\u0140\u0142\5:\36\2\u0141"+
		"\u0140\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0145\7\3"+
		"\2\2\u0144\u0146\5> \2\u0145\u0144\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0147"+
		"\3\2\2\2\u0147\u0149\7\3\2\2\u0148\u014a\5<\37\2\u0149\u0148\3\2\2\2\u0149"+
		"\u014a\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014c\7\b\2\2\u014c\u014d\5("+
		"\25\2\u014d9\3\2\2\2\u014e\u014f\5.\30\2\u014f;\3\2\2\2\u0150\u0151\5"+
		".\30\2\u0151=\3\2\2\2\u0152\u0153\5.\30\2\u0153?\3\2\2\2\u0154\u0156\7"+
		"\60\2\2\u0155\u0157\5.\30\2\u0156\u0155\3\2\2\2\u0156\u0157\3\2\2\2\u0157"+
		"\u0158\3\2\2\2\u0158\u0159\7\3\2\2\u0159A\3\2\2\2\36EMS_hm{\u0083\u008c"+
		"\u008e\u0095\u00a0\u00ac\u00b6\u00bd\u00cd\u00e6\u0113\u0115\u011b\u0122"+
		"\u0124\u012d\u0136\u0141\u0145\u0149\u0156";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}