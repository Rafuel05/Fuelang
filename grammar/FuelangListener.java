// Generated from grammar/Fuelang.g4 by ANTLR 4.13.1
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FuelangParser}.
 */
public interface FuelangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FuelangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(FuelangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(FuelangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterDeclarations(FuelangParser.DeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitDeclarations(FuelangParser.DeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(FuelangParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(FuelangParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(FuelangParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(FuelangParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(FuelangParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(FuelangParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#inputCommand}.
	 * @param ctx the parse tree
	 */
	void enterInputCommand(FuelangParser.InputCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#inputCommand}.
	 * @param ctx the parse tree
	 */
	void exitInputCommand(FuelangParser.InputCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#outputCommand}.
	 * @param ctx the parse tree
	 */
	void enterOutputCommand(FuelangParser.OutputCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#outputCommand}.
	 * @param ctx the parse tree
	 */
	void exitOutputCommand(FuelangParser.OutputCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(FuelangParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(FuelangParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#ifCommand}.
	 * @param ctx the parse tree
	 */
	void enterIfCommand(FuelangParser.IfCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#ifCommand}.
	 * @param ctx the parse tree
	 */
	void exitIfCommand(FuelangParser.IfCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#whileCommand}.
	 * @param ctx the parse tree
	 */
	void enterWhileCommand(FuelangParser.WhileCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#whileCommand}.
	 * @param ctx the parse tree
	 */
	void exitWhileCommand(FuelangParser.WhileCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(FuelangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(FuelangParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(FuelangParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(FuelangParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpression(FuelangParser.ArithmeticExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpression(FuelangParser.ArithmeticExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(FuelangParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(FuelangParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#arithmeticOperator}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticOperator(FuelangParser.ArithmeticOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#arithmeticOperator}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticOperator(FuelangParser.ArithmeticOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#termOperator}.
	 * @param ctx the parse tree
	 */
	void enterTermOperator(FuelangParser.TermOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#termOperator}.
	 * @param ctx the parse tree
	 */
	void exitTermOperator(FuelangParser.TermOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(FuelangParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(FuelangParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpression(FuelangParser.LogicalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpression(FuelangParser.LogicalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#logicalTerm}.
	 * @param ctx the parse tree
	 */
	void enterLogicalTerm(FuelangParser.LogicalTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#logicalTerm}.
	 * @param ctx the parse tree
	 */
	void exitLogicalTerm(FuelangParser.LogicalTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#logicalFactor}.
	 * @param ctx the parse tree
	 */
	void enterLogicalFactor(FuelangParser.LogicalFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#logicalFactor}.
	 * @param ctx the parse tree
	 */
	void exitLogicalFactor(FuelangParser.LogicalFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(FuelangParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(FuelangParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link FuelangParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(FuelangParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuelangParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(FuelangParser.ComparisonOperatorContext ctx);
}