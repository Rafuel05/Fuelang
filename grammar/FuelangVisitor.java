// Generated from Fuelang.g4 by ANTLR 4.13.1
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FuelangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FuelangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FuelangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(FuelangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link FuelangParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarations(FuelangParser.DeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FuelangParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(FuelangParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FuelangParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(FuelangParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FuelangParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(FuelangParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link FuelangParser#inputCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputCommand(FuelangParser.InputCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link FuelangParser#outputCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutputCommand(FuelangParser.OutputCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link FuelangParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(FuelangParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link FuelangParser#ifCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfCommand(FuelangParser.IfCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link FuelangParser#whileCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileCommand(FuelangParser.WhileCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link FuelangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(FuelangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link FuelangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(FuelangParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FuelangParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExpression(FuelangParser.ArithmeticExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FuelangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(FuelangParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link FuelangParser#arithmeticOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticOperator(FuelangParser.ArithmeticOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link FuelangParser#termOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermOperator(FuelangParser.TermOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link FuelangParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(FuelangParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link FuelangParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpression(FuelangParser.LogicalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FuelangParser#logicalTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalTerm(FuelangParser.LogicalTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link FuelangParser#logicalFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalFactor(FuelangParser.LogicalFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link FuelangParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(FuelangParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link FuelangParser#comparisonOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOperator(FuelangParser.ComparisonOperatorContext ctx);
}