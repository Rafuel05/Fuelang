// Generated from grammar/Fuelang.g4 by ANTLR 4.13.1
package grammar;
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
		TIPO=1, SE=2, ENTAO=3, SENAO=4, ENQUANTO=5, FACA=6, LEIA=7, ESCREVA=8, 
		IGUAL=9, MAIS=10, MENOS=11, MULT=12, DIV=13, OP_E=14, OP_OU=15, OP_NAO=16, 
		OP_IGUAL=17, OP_DIF=18, OP_MENOR=19, OP_MAIOR=20, OP_MENOR_IGUAL=21, OP_MAIOR_IGUAL=22, 
		ABRE_PAR=23, FECHA_PAR=24, ABRE_CHAVE=25, FECHA_CHAVE=26, PONTO_VIRGULA=27, 
		ID=28, NUMERO=29, STRING=30, WS=31, COMENTARIO=32, ErrorChar=33;
	public static final int
		RULE_programa = 0, RULE_declaracoes = 1, RULE_declaracao = 2, RULE_declaracaoVariavel = 3, 
		RULE_comando = 4, RULE_comandoEntrada = 5, RULE_comandoSaida = 6, RULE_atribuicao = 7, 
		RULE_comandoIf = 8, RULE_comandoWhile = 9, RULE_bloco = 10, RULE_expressao = 11, 
		RULE_expressaoAritmetica = 12, RULE_termo = 13, RULE_operadorAritmetico = 14, 
		RULE_operadorTermo = 15, RULE_fator = 16, RULE_expressaoLogica = 17, RULE_termoLogico = 18, 
		RULE_fatorLogico = 19, RULE_comparacao = 20, RULE_operadorComp = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declaracoes", "declaracao", "declaracaoVariavel", "comando", 
			"comandoEntrada", "comandoSaida", "atribuicao", "comandoIf", "comandoWhile", 
			"bloco", "expressao", "expressaoAritmetica", "termo", "operadorAritmetico", 
			"operadorTermo", "fator", "expressaoLogica", "termoLogico", "fatorLogico", 
			"comparacao", "operadorComp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'se'", "'entao'", "'senao'", "'enquanto'", "'faca'", "'leia'", 
			"'escreva'", "'='", "'+'", "'-'", "'*'", "'/'", "'&&'", "'||'", "'!'", 
			"'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'('", "')'", "'{'", "'}'", 
			"';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TIPO", "SE", "ENTAO", "SENAO", "ENQUANTO", "FACA", "LEIA", "ESCREVA", 
			"IGUAL", "MAIS", "MENOS", "MULT", "DIV", "OP_E", "OP_OU", "OP_NAO", "OP_IGUAL", 
			"OP_DIF", "OP_MENOR", "OP_MAIOR", "OP_MENOR_IGUAL", "OP_MAIOR_IGUAL", 
			"ABRE_PAR", "FECHA_PAR", "ABRE_CHAVE", "FECHA_CHAVE", "PONTO_VIRGULA", 
			"ID", "NUMERO", "STRING", "WS", "COMENTARIO", "ErrorChar"
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
	        
	        // Extrair o token esperado da mensagem de erro
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
	public static class ProgramaContext extends ParserRuleContext {
		public DeclaracoesContext declaracoes() {
			return getRuleContext(DeclaracoesContext.class,0);
		}
		public TerminalNode EOF() { return getToken(FuelangParser.EOF, 0); }
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			declaracoes();
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
	public static class DeclaracoesContext extends ParserRuleContext {
		public List<DeclaracaoContext> declaracao() {
			return getRuleContexts(DeclaracaoContext.class);
		}
		public DeclaracaoContext declaracao(int i) {
			return getRuleContext(DeclaracaoContext.class,i);
		}
		public DeclaracoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).enterDeclaracoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).exitDeclaracoes(this);
		}
	}

	public final DeclaracoesContext declaracoes() throws RecognitionException {
		DeclaracoesContext _localctx = new DeclaracoesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaracoes);
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
				declaracao();
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
	public static class DeclaracaoContext extends ParserRuleContext {
		public DeclaracaoVariavelContext declaracaoVariavel() {
			return getRuleContext(DeclaracaoVariavelContext.class,0);
		}
		public ComandoContext comando() {
			return getRuleContext(ComandoContext.class,0);
		}
		public DeclaracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).enterDeclaracao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).exitDeclaracao(this);
		}
	}

	public final DeclaracaoContext declaracao() throws RecognitionException {
		DeclaracaoContext _localctx = new DeclaracaoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracao);
		try {
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TIPO:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				declaracaoVariavel();
				}
				break;
			case SE:
			case ENQUANTO:
			case LEIA:
			case ESCREVA:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				comando();
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
	public static class DeclaracaoVariavelContext extends ParserRuleContext {
		public TerminalNode TIPO() { return getToken(FuelangParser.TIPO, 0); }
		public TerminalNode ID() { return getToken(FuelangParser.ID, 0); }
		public TerminalNode IGUAL() { return getToken(FuelangParser.IGUAL, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode PONTO_VIRGULA() { return getToken(FuelangParser.PONTO_VIRGULA, 0); }
		public DeclaracaoVariavelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracaoVariavel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).enterDeclaracaoVariavel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).exitDeclaracaoVariavel(this);
		}
	}

	public final DeclaracaoVariavelContext declaracaoVariavel() throws RecognitionException {
		DeclaracaoVariavelContext _localctx = new DeclaracaoVariavelContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracaoVariavel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(TIPO);
			setState(58);
			match(ID);
			setState(59);
			match(IGUAL);
			setState(60);
			expressao();
			setState(61);
			match(PONTO_VIRGULA);
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
	public static class ComandoContext extends ParserRuleContext {
		public ComandoEntradaContext comandoEntrada() {
			return getRuleContext(ComandoEntradaContext.class,0);
		}
		public ComandoSaidaContext comandoSaida() {
			return getRuleContext(ComandoSaidaContext.class,0);
		}
		public ComandoIfContext comandoIf() {
			return getRuleContext(ComandoIfContext.class,0);
		}
		public ComandoWhileContext comandoWhile() {
			return getRuleContext(ComandoWhileContext.class,0);
		}
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).enterComando(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).exitComando(this);
		}
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_comando);
		try {
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEIA:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				comandoEntrada();
				}
				break;
			case ESCREVA:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				comandoSaida();
				}
				break;
			case SE:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				comandoIf();
				}
				break;
			case ENQUANTO:
				enterOuterAlt(_localctx, 4);
				{
				setState(66);
				comandoWhile();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(67);
				atribuicao();
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
	public static class ComandoEntradaContext extends ParserRuleContext {
		public TerminalNode LEIA() { return getToken(FuelangParser.LEIA, 0); }
		public TerminalNode ABRE_PAR() { return getToken(FuelangParser.ABRE_PAR, 0); }
		public TerminalNode ID() { return getToken(FuelangParser.ID, 0); }
		public TerminalNode FECHA_PAR() { return getToken(FuelangParser.FECHA_PAR, 0); }
		public TerminalNode PONTO_VIRGULA() { return getToken(FuelangParser.PONTO_VIRGULA, 0); }
		public ComandoEntradaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoEntrada; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).enterComandoEntrada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).exitComandoEntrada(this);
		}
	}

	public final ComandoEntradaContext comandoEntrada() throws RecognitionException {
		ComandoEntradaContext _localctx = new ComandoEntradaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_comandoEntrada);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(LEIA);
			setState(71);
			match(ABRE_PAR);
			setState(72);
			match(ID);
			setState(73);
			match(FECHA_PAR);
			setState(74);
			match(PONTO_VIRGULA);
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
	public static class ComandoSaidaContext extends ParserRuleContext {
		public TerminalNode ESCREVA() { return getToken(FuelangParser.ESCREVA, 0); }
		public TerminalNode ABRE_PAR() { return getToken(FuelangParser.ABRE_PAR, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode FECHA_PAR() { return getToken(FuelangParser.FECHA_PAR, 0); }
		public TerminalNode PONTO_VIRGULA() { return getToken(FuelangParser.PONTO_VIRGULA, 0); }
		public ComandoSaidaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoSaida; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).enterComandoSaida(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).exitComandoSaida(this);
		}
	}

	public final ComandoSaidaContext comandoSaida() throws RecognitionException {
		ComandoSaidaContext _localctx = new ComandoSaidaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_comandoSaida);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(ESCREVA);
			setState(77);
			match(ABRE_PAR);
			setState(78);
			expressao();
			setState(79);
			match(FECHA_PAR);
			setState(80);
			match(PONTO_VIRGULA);
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
	public static class AtribuicaoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(FuelangParser.ID, 0); }
		public TerminalNode IGUAL() { return getToken(FuelangParser.IGUAL, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode PONTO_VIRGULA() { return getToken(FuelangParser.PONTO_VIRGULA, 0); }
		public AtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).enterAtribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).exitAtribuicao(this);
		}
	}

	public final AtribuicaoContext atribuicao() throws RecognitionException {
		AtribuicaoContext _localctx = new AtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_atribuicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(ID);
			setState(83);
			match(IGUAL);
			setState(84);
			expressao();
			setState(85);
			match(PONTO_VIRGULA);
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
	public static class ComandoIfContext extends ParserRuleContext {
		public TerminalNode SE() { return getToken(FuelangParser.SE, 0); }
		public ExpressaoLogicaContext expressaoLogica() {
			return getRuleContext(ExpressaoLogicaContext.class,0);
		}
		public TerminalNode ENTAO() { return getToken(FuelangParser.ENTAO, 0); }
		public List<BlocoContext> bloco() {
			return getRuleContexts(BlocoContext.class);
		}
		public BlocoContext bloco(int i) {
			return getRuleContext(BlocoContext.class,i);
		}
		public TerminalNode SENAO() { return getToken(FuelangParser.SENAO, 0); }
		public ComandoIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).enterComandoIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).exitComandoIf(this);
		}
	}

	public final ComandoIfContext comandoIf() throws RecognitionException {
		ComandoIfContext _localctx = new ComandoIfContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_comandoIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(SE);
			setState(88);
			expressaoLogica();
			setState(89);
			match(ENTAO);
			setState(90);
			bloco();
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SENAO) {
				{
				setState(91);
				match(SENAO);
				setState(92);
				bloco();
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
	public static class ComandoWhileContext extends ParserRuleContext {
		public TerminalNode ENQUANTO() { return getToken(FuelangParser.ENQUANTO, 0); }
		public ExpressaoLogicaContext expressaoLogica() {
			return getRuleContext(ExpressaoLogicaContext.class,0);
		}
		public TerminalNode FACA() { return getToken(FuelangParser.FACA, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ComandoWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandoWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).enterComandoWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).exitComandoWhile(this);
		}
	}

	public final ComandoWhileContext comandoWhile() throws RecognitionException {
		ComandoWhileContext _localctx = new ComandoWhileContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_comandoWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(ENQUANTO);
			setState(96);
			expressaoLogica();
			setState(97);
			match(FACA);
			setState(98);
			bloco();
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
	public static class BlocoContext extends ParserRuleContext {
		public TerminalNode ABRE_CHAVE() { return getToken(FuelangParser.ABRE_CHAVE, 0); }
		public DeclaracoesContext declaracoes() {
			return getRuleContext(DeclaracoesContext.class,0);
		}
		public TerminalNode FECHA_CHAVE() { return getToken(FuelangParser.FECHA_CHAVE, 0); }
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_bloco);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(ABRE_CHAVE);
			setState(101);
			declaracoes();
			setState(102);
			match(FECHA_CHAVE);
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
	public static class ExpressaoContext extends ParserRuleContext {
		public ExpressaoLogicaContext expressaoLogica() {
			return getRuleContext(ExpressaoLogicaContext.class,0);
		}
		public ExpressaoAritmeticaContext expressaoAritmetica() {
			return getRuleContext(ExpressaoAritmeticaContext.class,0);
		}
		public TerminalNode STRING() { return getToken(FuelangParser.STRING, 0); }
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).enterExpressao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).exitExpressao(this);
		}
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expressao);
		try {
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				expressaoLogica();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				expressaoAritmetica();
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
	public static class ExpressaoAritmeticaContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<OperadorAritmeticoContext> operadorAritmetico() {
			return getRuleContexts(OperadorAritmeticoContext.class);
		}
		public OperadorAritmeticoContext operadorAritmetico(int i) {
			return getRuleContext(OperadorAritmeticoContext.class,i);
		}
		public ExpressaoAritmeticaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoAritmetica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).enterExpressaoAritmetica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).exitExpressaoAritmetica(this);
		}
	}

	public final ExpressaoAritmeticaContext expressaoAritmetica() throws RecognitionException {
		ExpressaoAritmeticaContext _localctx = new ExpressaoAritmeticaContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expressaoAritmetica);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			termo();
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MAIS || _la==MENOS) {
				{
				{
				setState(110);
				operadorAritmetico();
				setState(111);
				termo();
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
	public static class TermoContext extends ParserRuleContext {
		public List<FatorContext> fator() {
			return getRuleContexts(FatorContext.class);
		}
		public FatorContext fator(int i) {
			return getRuleContext(FatorContext.class,i);
		}
		public List<OperadorTermoContext> operadorTermo() {
			return getRuleContexts(OperadorTermoContext.class);
		}
		public OperadorTermoContext operadorTermo(int i) {
			return getRuleContext(OperadorTermoContext.class,i);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_termo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			fator();
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT || _la==DIV) {
				{
				{
				setState(119);
				operadorTermo();
				setState(120);
				fator();
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
	public static class OperadorAritmeticoContext extends ParserRuleContext {
		public TerminalNode MAIS() { return getToken(FuelangParser.MAIS, 0); }
		public TerminalNode MENOS() { return getToken(FuelangParser.MENOS, 0); }
		public OperadorAritmeticoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operadorAritmetico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).enterOperadorAritmetico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).exitOperadorAritmetico(this);
		}
	}

	public final OperadorAritmeticoContext operadorAritmetico() throws RecognitionException {
		OperadorAritmeticoContext _localctx = new OperadorAritmeticoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_operadorAritmetico);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_la = _input.LA(1);
			if ( !(_la==MAIS || _la==MENOS) ) {
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
	public static class OperadorTermoContext extends ParserRuleContext {
		public TerminalNode MULT() { return getToken(FuelangParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(FuelangParser.DIV, 0); }
		public OperadorTermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operadorTermo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).enterOperadorTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).exitOperadorTermo(this);
		}
	}

	public final OperadorTermoContext operadorTermo() throws RecognitionException {
		OperadorTermoContext _localctx = new OperadorTermoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_operadorTermo);
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
	public static class FatorContext extends ParserRuleContext {
		public TerminalNode ABRE_PAR() { return getToken(FuelangParser.ABRE_PAR, 0); }
		public ExpressaoAritmeticaContext expressaoAritmetica() {
			return getRuleContext(ExpressaoAritmeticaContext.class,0);
		}
		public TerminalNode FECHA_PAR() { return getToken(FuelangParser.FECHA_PAR, 0); }
		public TerminalNode NUMERO() { return getToken(FuelangParser.NUMERO, 0); }
		public TerminalNode ID() { return getToken(FuelangParser.ID, 0); }
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).exitFator(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_fator);
		try {
			setState(137);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ABRE_PAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				match(ABRE_PAR);
				setState(132);
				expressaoAritmetica();
				setState(133);
				match(FECHA_PAR);
				}
				break;
			case NUMERO:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				match(NUMERO);
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
	public static class ExpressaoLogicaContext extends ParserRuleContext {
		public List<TermoLogicoContext> termoLogico() {
			return getRuleContexts(TermoLogicoContext.class);
		}
		public TermoLogicoContext termoLogico(int i) {
			return getRuleContext(TermoLogicoContext.class,i);
		}
		public List<TerminalNode> OP_OU() { return getTokens(FuelangParser.OP_OU); }
		public TerminalNode OP_OU(int i) {
			return getToken(FuelangParser.OP_OU, i);
		}
		public ExpressaoLogicaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressaoLogica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).enterExpressaoLogica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).exitExpressaoLogica(this);
		}
	}

	public final ExpressaoLogicaContext expressaoLogica() throws RecognitionException {
		ExpressaoLogicaContext _localctx = new ExpressaoLogicaContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expressaoLogica);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			termoLogico();
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_OU) {
				{
				{
				setState(140);
				match(OP_OU);
				setState(141);
				termoLogico();
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
	public static class TermoLogicoContext extends ParserRuleContext {
		public List<FatorLogicoContext> fatorLogico() {
			return getRuleContexts(FatorLogicoContext.class);
		}
		public FatorLogicoContext fatorLogico(int i) {
			return getRuleContext(FatorLogicoContext.class,i);
		}
		public List<TerminalNode> OP_E() { return getTokens(FuelangParser.OP_E); }
		public TerminalNode OP_E(int i) {
			return getToken(FuelangParser.OP_E, i);
		}
		public TermoLogicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termoLogico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).enterTermoLogico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).exitTermoLogico(this);
		}
	}

	public final TermoLogicoContext termoLogico() throws RecognitionException {
		TermoLogicoContext _localctx = new TermoLogicoContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_termoLogico);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			fatorLogico();
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_E) {
				{
				{
				setState(148);
				match(OP_E);
				setState(149);
				fatorLogico();
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
	public static class FatorLogicoContext extends ParserRuleContext {
		public TerminalNode OP_NAO() { return getToken(FuelangParser.OP_NAO, 0); }
		public FatorLogicoContext fatorLogico() {
			return getRuleContext(FatorLogicoContext.class,0);
		}
		public TerminalNode ABRE_PAR() { return getToken(FuelangParser.ABRE_PAR, 0); }
		public ExpressaoLogicaContext expressaoLogica() {
			return getRuleContext(ExpressaoLogicaContext.class,0);
		}
		public TerminalNode FECHA_PAR() { return getToken(FuelangParser.FECHA_PAR, 0); }
		public ComparacaoContext comparacao() {
			return getRuleContext(ComparacaoContext.class,0);
		}
		public FatorLogicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fatorLogico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).enterFatorLogico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).exitFatorLogico(this);
		}
	}

	public final FatorLogicoContext fatorLogico() throws RecognitionException {
		FatorLogicoContext _localctx = new FatorLogicoContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_fatorLogico);
		try {
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				match(OP_NAO);
				setState(156);
				fatorLogico();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				match(ABRE_PAR);
				setState(158);
				expressaoLogica();
				setState(159);
				match(FECHA_PAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(161);
				comparacao();
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
	public static class ComparacaoContext extends ParserRuleContext {
		public List<ExpressaoAritmeticaContext> expressaoAritmetica() {
			return getRuleContexts(ExpressaoAritmeticaContext.class);
		}
		public ExpressaoAritmeticaContext expressaoAritmetica(int i) {
			return getRuleContext(ExpressaoAritmeticaContext.class,i);
		}
		public OperadorCompContext operadorComp() {
			return getRuleContext(OperadorCompContext.class,0);
		}
		public ComparacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).enterComparacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).exitComparacao(this);
		}
	}

	public final ComparacaoContext comparacao() throws RecognitionException {
		ComparacaoContext _localctx = new ComparacaoContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_comparacao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			expressaoAritmetica();
			setState(165);
			operadorComp();
			setState(166);
			expressaoAritmetica();
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
	public static class OperadorCompContext extends ParserRuleContext {
		public TerminalNode OP_IGUAL() { return getToken(FuelangParser.OP_IGUAL, 0); }
		public TerminalNode OP_DIF() { return getToken(FuelangParser.OP_DIF, 0); }
		public TerminalNode OP_MENOR_IGUAL() { return getToken(FuelangParser.OP_MENOR_IGUAL, 0); }
		public TerminalNode OP_MAIOR_IGUAL() { return getToken(FuelangParser.OP_MAIOR_IGUAL, 0); }
		public TerminalNode OP_MENOR() { return getToken(FuelangParser.OP_MENOR, 0); }
		public TerminalNode OP_MAIOR() { return getToken(FuelangParser.OP_MAIOR, 0); }
		public OperadorCompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operadorComp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).enterOperadorComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FuelangListener ) ((FuelangListener)listener).exitOperadorComp(this);
		}
	}

	public final OperadorCompContext operadorComp() throws RecognitionException {
		OperadorCompContext _localctx = new OperadorCompContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_operadorComp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8257536L) != 0)) ) {
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
		"\u0003\u0001\u0000\n\u000b\u0001\u0000\f\r\u0001\u0000\u0011\u0016\u00a5"+
		"\u0000,\u0001\u0000\u0000\u0000\u00022\u0001\u0000\u0000\u0000\u00047"+
		"\u0001\u0000\u0000\u0000\u00069\u0001\u0000\u0000\u0000\bD\u0001\u0000"+
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
		"\t\u0000\u0000<=\u0003\u0016\u000b\u0000=>\u0005\u001b\u0000\u0000>\u0007"+
		"\u0001\u0000\u0000\u0000?E\u0003\n\u0005\u0000@E\u0003\f\u0006\u0000A"+
		"E\u0003\u0010\b\u0000BE\u0003\u0012\t\u0000CE\u0003\u000e\u0007\u0000"+
		"D?\u0001\u0000\u0000\u0000D@\u0001\u0000\u0000\u0000DA\u0001\u0000\u0000"+
		"\u0000DB\u0001\u0000\u0000\u0000DC\u0001\u0000\u0000\u0000E\t\u0001\u0000"+
		"\u0000\u0000FG\u0005\u0007\u0000\u0000GH\u0005\u0017\u0000\u0000HI\u0005"+
		"\u001c\u0000\u0000IJ\u0005\u0018\u0000\u0000JK\u0005\u001b\u0000\u0000"+
		"K\u000b\u0001\u0000\u0000\u0000LM\u0005\b\u0000\u0000MN\u0005\u0017\u0000"+
		"\u0000NO\u0003\u0016\u000b\u0000OP\u0005\u0018\u0000\u0000PQ\u0005\u001b"+
		"\u0000\u0000Q\r\u0001\u0000\u0000\u0000RS\u0005\u001c\u0000\u0000ST\u0005"+
		"\t\u0000\u0000TU\u0003\u0016\u000b\u0000UV\u0005\u001b\u0000\u0000V\u000f"+
		"\u0001\u0000\u0000\u0000WX\u0005\u0002\u0000\u0000XY\u0003\"\u0011\u0000"+
		"YZ\u0005\u0003\u0000\u0000Z]\u0003\u0014\n\u0000[\\\u0005\u0004\u0000"+
		"\u0000\\^\u0003\u0014\n\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000"+
		"\u0000\u0000^\u0011\u0001\u0000\u0000\u0000_`\u0005\u0005\u0000\u0000"+
		"`a\u0003\"\u0011\u0000ab\u0005\u0006\u0000\u0000bc\u0003\u0014\n\u0000"+
		"c\u0013\u0001\u0000\u0000\u0000de\u0005\u0019\u0000\u0000ef\u0003\u0002"+
		"\u0001\u0000fg\u0005\u001a\u0000\u0000g\u0015\u0001\u0000\u0000\u0000"+
		"hl\u0003\"\u0011\u0000il\u0003\u0018\f\u0000jl\u0005\u001e\u0000\u0000"+
		"kh\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000kj\u0001\u0000\u0000"+
		"\u0000l\u0017\u0001\u0000\u0000\u0000ms\u0003\u001a\r\u0000no\u0003\u001c"+
		"\u000e\u0000op\u0003\u001a\r\u0000pr\u0001\u0000\u0000\u0000qn\u0001\u0000"+
		"\u0000\u0000ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001"+
		"\u0000\u0000\u0000t\u0019\u0001\u0000\u0000\u0000us\u0001\u0000\u0000"+
		"\u0000v|\u0003 \u0010\u0000wx\u0003\u001e\u000f\u0000xy\u0003 \u0010\u0000"+
		"y{\u0001\u0000\u0000\u0000zw\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000"+
		"\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\u001b\u0001"+
		"\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000\u007f\u0080\u0007\u0000\u0000"+
		"\u0000\u0080\u001d\u0001\u0000\u0000\u0000\u0081\u0082\u0007\u0001\u0000"+
		"\u0000\u0082\u001f\u0001\u0000\u0000\u0000\u0083\u0084\u0005\u0017\u0000"+
		"\u0000\u0084\u0085\u0003\u0018\f\u0000\u0085\u0086\u0005\u0018\u0000\u0000"+
		"\u0086\u008a\u0001\u0000\u0000\u0000\u0087\u008a\u0005\u001d\u0000\u0000"+
		"\u0088\u008a\u0005\u001c\u0000\u0000\u0089\u0083\u0001\u0000\u0000\u0000"+
		"\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u0088\u0001\u0000\u0000\u0000"+
		"\u008a!\u0001\u0000\u0000\u0000\u008b\u0090\u0003$\u0012\u0000\u008c\u008d"+
		"\u0005\u000f\u0000\u0000\u008d\u008f\u0003$\u0012\u0000\u008e\u008c\u0001"+
		"\u0000\u0000\u0000\u008f\u0092\u0001\u0000\u0000\u0000\u0090\u008e\u0001"+
		"\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091#\u0001\u0000"+
		"\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0093\u0098\u0003&\u0013"+
		"\u0000\u0094\u0095\u0005\u000e\u0000\u0000\u0095\u0097\u0003&\u0013\u0000"+
		"\u0096\u0094\u0001\u0000\u0000\u0000\u0097\u009a\u0001\u0000\u0000\u0000"+
		"\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000"+
		"\u0099%\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009b"+
		"\u009c\u0005\u0010\u0000\u0000\u009c\u00a3\u0003&\u0013\u0000\u009d\u009e"+
		"\u0005\u0017\u0000\u0000\u009e\u009f\u0003\"\u0011\u0000\u009f\u00a0\u0005"+
		"\u0018\u0000\u0000\u00a0\u00a3\u0001\u0000\u0000\u0000\u00a1\u00a3\u0003"+
		"(\u0014\u0000\u00a2\u009b\u0001\u0000\u0000\u0000\u00a2\u009d\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a3\'\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a5\u0003\u0018\f\u0000\u00a5\u00a6\u0003*\u0015\u0000"+
		"\u00a6\u00a7\u0003\u0018\f\u0000\u00a7)\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a9\u0007\u0002\u0000\u0000\u00a9+\u0001\u0000\u0000\u0000\u000b27"+
		"D]ks|\u0089\u0090\u0098\u00a2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}