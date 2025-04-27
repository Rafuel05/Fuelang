// Generated from grammar/Fuelang.g4 by ANTLR 4.13.1
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FuelangParser}.
 */
public interface FuelangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FuelangParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(FuelangParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(FuelangParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes(FuelangParser.DeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes(FuelangParser.DeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao(FuelangParser.DeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao(FuelangParser.DeclaracaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#declaracaoVariavel}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracaoVariavel(FuelangParser.DeclaracaoVariavelContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#declaracaoVariavel}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracaoVariavel(FuelangParser.DeclaracaoVariavelContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterComando(FuelangParser.ComandoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitComando(FuelangParser.ComandoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#comandoEntrada}.
	 * @param ctx the parse tree
	 */
	void enterComandoEntrada(FuelangParser.ComandoEntradaContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#comandoEntrada}.
	 * @param ctx the parse tree
	 */
	void exitComandoEntrada(FuelangParser.ComandoEntradaContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#comandoSaida}.
	 * @param ctx the parse tree
	 */
	void enterComandoSaida(FuelangParser.ComandoSaidaContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#comandoSaida}.
	 * @param ctx the parse tree
	 */
	void exitComandoSaida(FuelangParser.ComandoSaidaContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterAtribuicao(FuelangParser.AtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitAtribuicao(FuelangParser.AtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#comandoIf}.
	 * @param ctx the parse tree
	 */
	void enterComandoIf(FuelangParser.ComandoIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#comandoIf}.
	 * @param ctx the parse tree
	 */
	void exitComandoIf(FuelangParser.ComandoIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#comandoWhile}.
	 * @param ctx the parse tree
	 */
	void enterComandoWhile(FuelangParser.ComandoWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#comandoWhile}.
	 * @param ctx the parse tree
	 */
	void exitComandoWhile(FuelangParser.ComandoWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(FuelangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(FuelangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(FuelangParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(FuelangParser.ExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#expressaoAritmetica}.
	 * @param ctx the parse tree
	 */
	void enterExpressaoAritmetica(FuelangParser.ExpressaoAritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#expressaoAritmetica}.
	 * @param ctx the parse tree
	 */
	void exitExpressaoAritmetica(FuelangParser.ExpressaoAritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(FuelangParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(FuelangParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#operadorAritmetico}.
	 * @param ctx the parse tree
	 */
	void enterOperadorAritmetico(FuelangParser.OperadorAritmeticoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#operadorAritmetico}.
	 * @param ctx the parse tree
	 */
	void exitOperadorAritmetico(FuelangParser.OperadorAritmeticoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#operadorTermo}.
	 * @param ctx the parse tree
	 */
	void enterOperadorTermo(FuelangParser.OperadorTermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#operadorTermo}.
	 * @param ctx the parse tree
	 */
	void exitOperadorTermo(FuelangParser.OperadorTermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(FuelangParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(FuelangParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#expressaoLogica}.
	 * @param ctx the parse tree
	 */
	void enterExpressaoLogica(FuelangParser.ExpressaoLogicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#expressaoLogica}.
	 * @param ctx the parse tree
	 */
	void exitExpressaoLogica(FuelangParser.ExpressaoLogicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#termoLogico}.
	 * @param ctx the parse tree
	 */
	void enterTermoLogico(FuelangParser.TermoLogicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#termoLogico}.
	 * @param ctx the parse tree
	 */
	void exitTermoLogico(FuelangParser.TermoLogicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#fatorLogico}.
	 * @param ctx the parse tree
	 */
	void enterFatorLogico(FuelangParser.FatorLogicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#fatorLogico}.
	 * @param ctx the parse tree
	 */
	void exitFatorLogico(FuelangParser.FatorLogicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#comparacao}.
	 * @param ctx the parse tree
	 */
	void enterComparacao(FuelangParser.ComparacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#comparacao}.
	 * @param ctx the parse tree
	 */
	void exitComparacao(FuelangParser.ComparacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#operadorComp}.
	 * @param ctx the parse tree
	 */
	void enterOperadorComp(FuelangParser.OperadorCompContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#operadorComp}.
	 * @param ctx the parse tree
	 */
	void exitOperadorComp(FuelangParser.OperadorCompContext ctx);
}