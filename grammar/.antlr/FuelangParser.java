// Generated from c:/Users/rafae/Desktop/Fuelang/Fuelang/grammar/Fuelang.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class FuelangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TYPE=1, IF=2, THEN=3, ELSE=4, WHILE=5, DO=6, GET=7, PUT=8, EQUALS=9, NOT_EQUALS=10, 
		LESS=11, GREATER=12, LESS_EQUALS=13, GREATER_EQUALS=14, PLUS=15, MINUS=16, 
		MULT=17, DIV=18, AND=19, OR=20, NOT=21, ASSIGN=22, LPAREN=23, RPAREN=24, 
		LBRACE=25, RBRACE=26, SEMICOLON=27, ID=28, NUMBER=29, STRING=30, WS=31, 
		COMMENT=32, ErrorChar=33;
	public static final int
		RULE_program = 0, RULE_declarations = 1, RULE_declaration = 2, RULE_variableDeclaration = 3, 
		RULE_command = 4, RULE_inputCommand = 5, RULE_outputCommand = 6, RULE_assignment = 7, 
		RULE_ifCommand = 8, RULE_whileCommand = 9, RULE_block = 10, RULE_expression = 11, 
		RULE_arithmeticExpression = 12, RULE_term = 13, RULE_arithmeticOperator = 14, 
		RULE_termOperator = 15, RULE_factor = 16, RULE_logicalExpression = 17, 
		RULE_logicalTerm = 18, RULE_logicalFactor = 19, RULE_comparison = 20, 
		RULE_comparisonOperator = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declarations", "declaration", "variableDeclaration", "command", 
			"inputCommand", "outputCommand", "assignment", "ifCommand", "whileCommand", 
			"block", "expression", "arithmeticExpression", "term", "arithmeticOperator", 
			"termOperator", "factor", "logicalExpression", "logicalTerm", "logicalFactor", 
			"comparison", "comparisonOperator"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'if'", "'then'", "'else'", "'while'", "'do'", "'get'", "'put'", 
			"'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'+'", "'-'", "'*'", "'/'", 
			"'&&'", "'||'", "'!'", "'='", "'('", "')'", "'{'", "'}'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TYPE", "IF", "THEN", "ELSE", "WHILE", "DO", "GET", "PUT", "EQUALS", 
			"NOT_EQUALS", "LESS", "GREATER", "LESS_EQUALS", "GREATER_EQUALS", "PLUS", 
			"MINUS", "MULT", "DIV", "AND", "OR", "NOT", "ASSIGN", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "SEMICOLON", "ID", "NUMBER", "STRING", "WS", "COMMENT", 
			"ErrorChar"
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
	public String getGrammarFileName() { return "Fuelang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    @Override
	    public void notifyErrorListeners(Token offendingToken, String msg, RecognitionException e) {
	        int line = offendingToken.getLine();
	        int column = offendingToken.getCharPositionInLine();
	        String tokenText = offendingToken.getText();
	        
	        String expected = msg.contains("expecting") 
	            ? msg.substring(msg.indexOf("expecting") + 10)
	            : "outro token";
	            
	        throw new SyntaxError(line, column, expected, tokenText);
	    }

	public FuelangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(FuelangParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			declarations();
			setState(45);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationsContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 268435878L) != 0)) {
				{
				{
				setState(47);
				declaration();
				}
				}
				setState(52);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		try {
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				variableDeclaration();
				}
				break;
			case IF:
			case WHILE:
			case GET:
			case PUT:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				command();
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(FuelangParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(FuelangParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(FuelangParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(FuelangParser.SEMICOLON, 0); }
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(TYPE);
			setState(58);
			match(ID);
			setState(59);
			match(ASSIGN);
			setState(60);
			expression();
			setState(61);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CommandContext extends ParserRuleContext {
		public InputCommandContext inputCommand() {
			return getRuleContext(InputCommandContext.class,0);
		}
		public OutputCommandContext outputCommand() {
			return getRuleContext(OutputCommandContext.class,0);
		}
		public IfCommandContext ifCommand() {
			return getRuleContext(IfCommandContext.class,0);
		}
		public WhileCommandContext whileCommand() {
			return getRuleContext(WhileCommandContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_command);
		try {
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GET:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				inputCommand();
				}
				break;
			case PUT:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				outputCommand();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				ifCommand();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(66);
				whileCommand();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(67);
				assignment();
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

	@SuppressWarnings("CheckReturnValue")
	public static class InputCommandContext extends ParserRuleContext {
		public TerminalNode GET() { return getToken(FuelangParser.GET, 0); }
		public TerminalNode LPAREN() { return getToken(FuelangParser.LPAREN, 0); }
		public TerminalNode ID() { return getToken(FuelangParser.ID, 0); }
		public TerminalNode RPAREN() { return getToken(FuelangParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(FuelangParser.SEMICOLON, 0); }
		public InputCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputCommand; }
	}

	public final InputCommandContext inputCommand() throws RecognitionException {
		InputCommandContext _localctx = new InputCommandContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_inputCommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(GET);
			setState(71);
			match(LPAREN);
			setState(72);
			match(ID);
			setState(73);
			match(RPAREN);
			setState(74);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class OutputCommandContext extends ParserRuleContext {
		public TerminalNode PUT() { return getToken(FuelangParser.PUT, 0); }
		public TerminalNode LPAREN() { return getToken(FuelangParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(FuelangParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(FuelangParser.SEMICOLON, 0); }
		public OutputCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputCommand; }
	}

	public final OutputCommandContext outputCommand() throws RecognitionException {
		OutputCommandContext _localctx = new OutputCommandContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_outputCommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(PUT);
			setState(77);
			match(LPAREN);
			setState(78);
			expression();
			setState(79);
			match(RPAREN);
			setState(80);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(FuelangParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(FuelangParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(FuelangParser.SEMICOLON, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(ID);
			setState(83);
			match(ASSIGN);
			setState(84);
			expression();
			setState(85);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfCommandContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(FuelangParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(FuelangParser.THEN, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(FuelangParser.ELSE, 0); }
		public IfCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifCommand; }
	}

	public final IfCommandContext ifCommand() throws RecognitionException {
		IfCommandContext _localctx = new IfCommandContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(IF);
			setState(88);
			expression();
			setState(89);
			match(THEN);
			setState(90);
			block();
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(91);
				match(ELSE);
				setState(92);
				block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhileCommandContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(FuelangParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DO() { return getToken(FuelangParser.DO, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileCommand; }
	}

	public final WhileCommandContext whileCommand() throws RecognitionException {
		WhileCommandContext _localctx = new WhileCommandContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_whileCommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(WHILE);
			setState(96);
			expression();
			setState(97);
			match(DO);
			setState(98);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(FuelangParser.LBRACE, 0); }
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(FuelangParser.RBRACE, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(LBRACE);
			setState(101);
			declarations();
			setState(102);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public TerminalNode STRING() { return getToken(FuelangParser.STRING, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expression);
		try {
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				logicalExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				arithmeticExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				match(STRING);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArithmeticExpressionContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<ArithmeticOperatorContext> arithmeticOperator() {
			return getRuleContexts(ArithmeticOperatorContext.class);
		}
		public ArithmeticOperatorContext arithmeticOperator(int i) {
			return getRuleContext(ArithmeticOperatorContext.class,i);
		}
		public ArithmeticExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticExpression; }
	}

	public final ArithmeticExpressionContext arithmeticExpression() throws RecognitionException {
		ArithmeticExpressionContext _localctx = new ArithmeticExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arithmeticExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			term();
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(110);
				arithmeticOperator();
				setState(111);
				term();
				}
				}
				setState(117);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TermOperatorContext> termOperator() {
			return getRuleContexts(TermOperatorContext.class);
		}
		public TermOperatorContext termOperator(int i) {
			return getRuleContext(TermOperatorContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			factor();
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT || _la==DIV) {
				{
				{
				setState(119);
				termOperator();
				setState(120);
				factor();
				}
				}
				setState(126);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ArithmeticOperatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(FuelangParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(FuelangParser.MINUS, 0); }
		public ArithmeticOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticOperator; }
	}

	public final ArithmeticOperatorContext arithmeticOperator() throws RecognitionException {
		ArithmeticOperatorContext _localctx = new ArithmeticOperatorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_arithmeticOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TermOperatorContext extends ParserRuleContext {
		public TerminalNode MULT() { return getToken(FuelangParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(FuelangParser.DIV, 0); }
		public TermOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termOperator; }
	}

	public final TermOperatorContext termOperator() throws RecognitionException {
		TermOperatorContext _localctx = new TermOperatorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_termOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			_la = _input.LA(1);
			if ( !(_la==MULT || _la==DIV) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(FuelangParser.LPAREN, 0); }
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(FuelangParser.RPAREN, 0); }
		public TerminalNode NUMBER() { return getToken(FuelangParser.NUMBER, 0); }
		public TerminalNode ID() { return getToken(FuelangParser.ID, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_factor);
		try {
			setState(137);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				match(LPAREN);
				setState(132);
				arithmeticExpression();
				setState(133);
				match(RPAREN);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				match(NUMBER);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(136);
				match(ID);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalExpressionContext extends ParserRuleContext {
		public List<LogicalTermContext> logicalTerm() {
			return getRuleContexts(LogicalTermContext.class);
		}
		public LogicalTermContext logicalTerm(int i) {
			return getRuleContext(LogicalTermContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(FuelangParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(FuelangParser.OR, i);
		}
		public LogicalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalExpression; }
	}

	public final LogicalExpressionContext logicalExpression() throws RecognitionException {
		LogicalExpressionContext _localctx = new LogicalExpressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_logicalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			logicalTerm();
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(140);
				match(OR);
				setState(141);
				logicalTerm();
				}
				}
				setState(146);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalTermContext extends ParserRuleContext {
		public List<LogicalFactorContext> logicalFactor() {
			return getRuleContexts(LogicalFactorContext.class);
		}
		public LogicalFactorContext logicalFactor(int i) {
			return getRuleContext(LogicalFactorContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(FuelangParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(FuelangParser.AND, i);
		}
		public LogicalTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalTerm; }
	}

	public final LogicalTermContext logicalTerm() throws RecognitionException {
		LogicalTermContext _localctx = new LogicalTermContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_logicalTerm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			logicalFactor();
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(148);
				match(AND);
				setState(149);
				logicalFactor();
				}
				}
				setState(154);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalFactorContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(FuelangParser.NOT, 0); }
		public LogicalFactorContext logicalFactor() {
			return getRuleContext(LogicalFactorContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(FuelangParser.LPAREN, 0); }
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(FuelangParser.RPAREN, 0); }
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public LogicalFactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalFactor; }
	}

	public final LogicalFactorContext logicalFactor() throws RecognitionException {
		LogicalFactorContext _localctx = new LogicalFactorContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_logicalFactor);
		try {
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				match(NOT);
				setState(156);
				logicalFactor();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				match(LPAREN);
				setState(158);
				logicalExpression();
				setState(159);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(161);
				comparison();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonContext extends ParserRuleContext {
		public List<ArithmeticExpressionContext> arithmeticExpression() {
			return getRuleContexts(ArithmeticExpressionContext.class);
		}
		public ArithmeticExpressionContext arithmeticExpression(int i) {
			return getRuleContext(ArithmeticExpressionContext.class,i);
		}
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_comparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			arithmeticExpression();
			setState(165);
			comparisonOperator();
			setState(166);
			arithmeticExpression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonOperatorContext extends ParserRuleContext {
		public TerminalNode EQUALS() { return getToken(FuelangParser.EQUALS, 0); }
		public TerminalNode NOT_EQUALS() { return getToken(FuelangParser.NOT_EQUALS, 0); }
		public TerminalNode LESS_EQUALS() { return getToken(FuelangParser.LESS_EQUALS, 0); }
		public TerminalNode GREATER_EQUALS() { return getToken(FuelangParser.GREATER_EQUALS, 0); }
		public TerminalNode LESS() { return getToken(FuelangParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(FuelangParser.GREATER, 0); }
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 32256L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\u0004\u0001!\u00ab\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0005\u00011\b\u0001"+
		"\n\u0001\f\u00014\t\u0001\u0001\u0002\u0001\u0002\u0003\u00028\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"E\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b^\b\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000bl\b\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0005\fr\b\f\n\f\f\fu\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0005"+
		"\r{\b\r\n\r\f\r~\t\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003"+
		"\u0010\u008a\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u008f"+
		"\b\u0011\n\u0011\f\u0011\u0092\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0005\u0012\u0097\b\u0012\n\u0012\f\u0012\u009a\t\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u00a3\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0000\u0000\u0016\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*\u0000"+
		"\u0003\u0001\u0000\u000f\u0010\u0001\u0000\u0011\u0012\u0001\u0000\t\u000e"+
		"\u00a5\u0000,\u0001\u0000\u0000\u0000\u00022\u0001\u0000\u0000\u0000\u0004"+
		"7\u0001\u0000\u0000\u0000\u00069\u0001\u0000\u0000\u0000\bD\u0001\u0000"+
		"\u0000\u0000\nF\u0001\u0000\u0000\u0000\fL\u0001\u0000\u0000\u0000\u000e"+
		"R\u0001\u0000\u0000\u0000\u0010W\u0001\u0000\u0000\u0000\u0012_\u0001"+
		"\u0000\u0000\u0000\u0014d\u0001\u0000\u0000\u0000\u0016k\u0001\u0000\u0000"+
		"\u0000\u0018m\u0001\u0000\u0000\u0000\u001av\u0001\u0000\u0000\u0000\u001c"+
		"\u007f\u0001\u0000\u0000\u0000\u001e\u0081\u0001\u0000\u0000\u0000 \u0089"+
		"\u0001\u0000\u0000\u0000\"\u008b\u0001\u0000\u0000\u0000$\u0093\u0001"+
		"\u0000\u0000\u0000&\u00a2\u0001\u0000\u0000\u0000(\u00a4\u0001\u0000\u0000"+
		"\u0000*\u00a8\u0001\u0000\u0000\u0000,-\u0003\u0002\u0001\u0000-.\u0005"+
		"\u0000\u0000\u0001.\u0001\u0001\u0000\u0000\u0000/1\u0003\u0004\u0002"+
		"\u00000/\u0001\u0000\u0000\u000014\u0001\u0000\u0000\u000020\u0001\u0000"+
		"\u0000\u000023\u0001\u0000\u0000\u00003\u0003\u0001\u0000\u0000\u0000"+
		"42\u0001\u0000\u0000\u000058\u0003\u0006\u0003\u000068\u0003\b\u0004\u0000"+
		"75\u0001\u0000\u0000\u000076\u0001\u0000\u0000\u00008\u0005\u0001\u0000"+
		"\u0000\u00009:\u0005\u0001\u0000\u0000:;\u0005\u001c\u0000\u0000;<\u0005"+
		"\u0016\u0000\u0000<=\u0003\u0016\u000b\u0000=>\u0005\u001b\u0000\u0000"+
		">\u0007\u0001\u0000\u0000\u0000?E\u0003\n\u0005\u0000@E\u0003\f\u0006"+
		"\u0000AE\u0003\u0010\b\u0000BE\u0003\u0012\t\u0000CE\u0003\u000e\u0007"+
		"\u0000D?\u0001\u0000\u0000\u0000D@\u0001\u0000\u0000\u0000DA\u0001\u0000"+
		"\u0000\u0000DB\u0001\u0000\u0000\u0000DC\u0001\u0000\u0000\u0000E\t\u0001"+
		"\u0000\u0000\u0000FG\u0005\u0007\u0000\u0000GH\u0005\u0017\u0000\u0000"+
		"HI\u0005\u001c\u0000\u0000IJ\u0005\u0018\u0000\u0000JK\u0005\u001b\u0000"+
		"\u0000K\u000b\u0001\u0000\u0000\u0000LM\u0005\b\u0000\u0000MN\u0005\u0017"+
		"\u0000\u0000NO\u0003\u0016\u000b\u0000OP\u0005\u0018\u0000\u0000PQ\u0005"+
		"\u001b\u0000\u0000Q\r\u0001\u0000\u0000\u0000RS\u0005\u001c\u0000\u0000"+
		"ST\u0005\u0016\u0000\u0000TU\u0003\u0016\u000b\u0000UV\u0005\u001b\u0000"+
		"\u0000V\u000f\u0001\u0000\u0000\u0000WX\u0005\u0002\u0000\u0000XY\u0003"+
		"\u0016\u000b\u0000YZ\u0005\u0003\u0000\u0000Z]\u0003\u0014\n\u0000[\\"+
		"\u0005\u0004\u0000\u0000\\^\u0003\u0014\n\u0000][\u0001\u0000\u0000\u0000"+
		"]^\u0001\u0000\u0000\u0000^\u0011\u0001\u0000\u0000\u0000_`\u0005\u0005"+
		"\u0000\u0000`a\u0003\u0016\u000b\u0000ab\u0005\u0006\u0000\u0000bc\u0003"+
		"\u0014\n\u0000c\u0013\u0001\u0000\u0000\u0000de\u0005\u0019\u0000\u0000"+
		"ef\u0003\u0002\u0001\u0000fg\u0005\u001a\u0000\u0000g\u0015\u0001\u0000"+
		"\u0000\u0000hl\u0003\"\u0011\u0000il\u0003\u0018\f\u0000jl\u0005\u001e"+
		"\u0000\u0000kh\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000kj\u0001"+
		"\u0000\u0000\u0000l\u0017\u0001\u0000\u0000\u0000ms\u0003\u001a\r\u0000"+
		"no\u0003\u001c\u000e\u0000op\u0003\u001a\r\u0000pr\u0001\u0000\u0000\u0000"+
		"qn\u0001\u0000\u0000\u0000ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000"+
		"\u0000st\u0001\u0000\u0000\u0000t\u0019\u0001\u0000\u0000\u0000us\u0001"+
		"\u0000\u0000\u0000v|\u0003 \u0010\u0000wx\u0003\u001e\u000f\u0000xy\u0003"+
		" \u0010\u0000y{\u0001\u0000\u0000\u0000zw\u0001\u0000\u0000\u0000{~\u0001"+
		"\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000"+
		"}\u001b\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0007\u0000\u0000\u0000\u0080\u001d\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0007\u0001\u0000\u0000\u0082\u001f\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u0005\u0017\u0000\u0000\u0084\u0085\u0003\u0018\f\u0000\u0085\u0086\u0005"+
		"\u0018\u0000\u0000\u0086\u008a\u0001\u0000\u0000\u0000\u0087\u008a\u0005"+
		"\u001d\u0000\u0000\u0088\u008a\u0005\u001c\u0000\u0000\u0089\u0083\u0001"+
		"\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u0088\u0001"+
		"\u0000\u0000\u0000\u008a!\u0001\u0000\u0000\u0000\u008b\u0090\u0003$\u0012"+
		"\u0000\u008c\u008d\u0005\u0014\u0000\u0000\u008d\u008f\u0003$\u0012\u0000"+
		"\u008e\u008c\u0001\u0000\u0000\u0000\u008f\u0092\u0001\u0000\u0000\u0000"+
		"\u0090\u008e\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000"+
		"\u0091#\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0093"+
		"\u0098\u0003&\u0013\u0000\u0094\u0095\u0005\u0013\u0000\u0000\u0095\u0097"+
		"\u0003&\u0013\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0097\u009a\u0001"+
		"\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001"+
		"\u0000\u0000\u0000\u0099%\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000"+
		"\u0000\u0000\u009b\u009c\u0005\u0015\u0000\u0000\u009c\u00a3\u0003&\u0013"+
		"\u0000\u009d\u009e\u0005\u0017\u0000\u0000\u009e\u009f\u0003\"\u0011\u0000"+
		"\u009f\u00a0\u0005\u0018\u0000\u0000\u00a0\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a1\u00a3\u0003(\u0014\u0000\u00a2\u009b\u0001\u0000\u0000\u0000\u00a2"+
		"\u009d\u0001\u0000\u0000\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a3"+
		"\'\u0001\u0000\u0000\u0000\u00a4\u00a5\u0003\u0018\f\u0000\u00a5\u00a6"+
		"\u0003*\u0015\u0000\u00a6\u00a7\u0003\u0018\f\u0000\u00a7)\u0001\u0000"+
		"\u0000\u0000\u00a8\u00a9\u0007\u0002\u0000\u0000\u00a9+\u0001\u0000\u0000"+
		"\u0000\u000b27D]ks|\u0089\u0090\u0098\u00a2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}