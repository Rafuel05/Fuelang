package grammar.semantics;

import grammar.*;
import org.antlr.v4.runtime.Token;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SemanticAnalyzer extends FuelangBaseVisitor<Type> {
    private final Stack<Map<String, VariableInfo>> symbolTable;
    private final CompilerLogger logger;

    public SemanticAnalyzer(CompilerLogger logger) {
        this.symbolTable = new Stack<>();
        this.logger = logger;
        // Inicializa escopo global
        symbolTable.push(new HashMap<>());
    }

    private void log(String message) {
        logger.log("[SEMÂNTICA] " + message);
    }

    @Override
    public Type visitProgram(FuelangParser.ProgramContext ctx) {
        log("Iniciando análise semântica do programa");
        return visit(ctx.declarations());
    }

    @Override
public Type visitVariableDeclaration(FuelangParser.VariableDeclarationContext ctx) {
    String varName = ctx.ID().getText();
    Token idToken = ctx.ID().getSymbol();

    // Verifica declaração duplicada
    if (symbolTable.peek().containsKey(varName)) {
        VariableInfo existing = symbolTable.peek().get(varName);
        throw new SemanticError(
            idToken.getLine(),
            idToken.getCharPositionInLine(),
            String.format("Variável '%s' já foi declarada na linha %d", 
                varName, existing.getDeclarationLine())
        );
    }

    // Obtém e verifica o tipo
    Type declaredType = Type.fromString(ctx.TYPE().getText());
    Type expressionType = visit(ctx.expression());

    // Verifica compatibilidade de tipos
    if (!declaredType.equals(expressionType)) {
        throw new SemanticError(
            ctx.expression().getStart().getLine(),
            ctx.expression().getStart().getCharPositionInLine(),
            String.format("Tipo incompatível: não é possível atribuir valor do tipo %s a uma variável do tipo %s",
                expressionType, declaredType)
        );
    }

    // Adiciona à tabela de símbolos
    symbolTable.peek().put(varName, 
        new VariableInfo(declaredType, idToken.getLine(), idToken.getCharPositionInLine()));
    
    return declaredType;
}

    @Override
public Type visitAssignment(FuelangParser.AssignmentContext ctx) {
    String varName = ctx.ID().getText();
    Token idToken = ctx.ID().getSymbol();
    
    // Procura a variável em todos os escopos
    VariableInfo varInfo = findVariable(varName);
    if (varInfo == null) {
        throw new SemanticError(
            idToken.getLine(),
            idToken.getCharPositionInLine(),
            "Variável '" + varName + "' não foi declarada"
        );
    }

    // Verifica o tipo da expressão sendo atribuída
    Type exprType = visit(ctx.expression());
    if (!varInfo.getType().equals(exprType)) {
        throw new SemanticError(
            idToken.getLine(),
            idToken.getCharPositionInLine(),
            String.format("Tipo incompatível: não é possível atribuir valor do tipo %s a uma variável do tipo %s",
                exprType, varInfo.getType())
        );
    }

    varInfo.setInitialized(true);
    return varInfo.getType();
}

   @Override
public Type visitTerm(FuelangParser.TermContext ctx) {
    Type leftType = visit(ctx.factor(0));
    
    for (int i = 1; i < ctx.factor().size(); i++) {
        Type rightType = visit(ctx.factor(i));
        if (!leftType.equals(Type.INTEGER) || !rightType.equals(Type.INTEGER)) {
            throw new SemanticError(
                ctx.getStart().getLine(),
                ctx.getStart().getCharPositionInLine(),
                "Operações aritméticas requerem operandos inteiros"
            );
        }
    }
    
    return Type.INTEGER;
}

    @Override
public Type visitFactor(FuelangParser.FactorContext ctx) {
    if (ctx.ID() != null) {
        String varName = ctx.ID().getText();
        VariableInfo varInfo = findVariable(varName);
        if (varInfo == null) {
            throw new SemanticError(
                ctx.getStart().getLine(),
                ctx.getStart().getCharPositionInLine(),
                "Variável '" + varName + "' não foi declarada"
            );
        }
        return varInfo.getType();
    } else if (ctx.NUMBER() != null) {
        return Type.INTEGER;
    } else if (ctx.arithmeticExpression() != null) {
        return visit(ctx.arithmeticExpression());
    }
    throw new SemanticError(
        ctx.getStart().getLine(),
        ctx.getStart().getCharPositionInLine(),
        "Fator inválido"
    );
}

    @Override
    public Type visitLogicalExpression(FuelangParser.LogicalExpressionContext ctx) {
        log("Verificando expressão lógica");
        visitChildren(ctx);
        return Type.BOOLEAN;
    }

    @Override
    public Type visitComparison(FuelangParser.ComparisonContext ctx) {
        Type left = visit(ctx.arithmeticExpression(0));
        Type right = visit(ctx.arithmeticExpression(1));
        
        if (!left.equals(right)) {
            throw new SemanticError(
                ctx.getStart().getLine(),
                ctx.getStart().getCharPositionInLine(),
                String.format("Tipos incompatíveis na comparação: %s e %s", left, right)
            );
        }
        
        return Type.BOOLEAN;
    }

    @Override
    public Type visitBlock(FuelangParser.BlockContext ctx) {
        log("Entrando em novo escopo");
        symbolTable.push(new HashMap<>());
        Type result = visit(ctx.declarations());
        symbolTable.pop();
        log("Saindo do escopo");
        return result;
    }

    // Método auxiliar para buscar variáveis em todos os escopos
    private VariableInfo findVariable(String name) {
        for (int i = symbolTable.size() - 1; i >= 0; i--) {
            VariableInfo info = symbolTable.get(i).get(name);
            if (info != null) {
                return info;
            }
        }
        return null;
    }
   @Override
public Type visitExpression(FuelangParser.ExpressionContext ctx) {
    if (ctx.STRING() != null) {
        // Se for uma string literal (entre aspas)
        return Type.TEXT;
    } else if (ctx.arithmeticExpression() != null) {
        return visit(ctx.arithmeticExpression());
    } else if (ctx.logicalExpression() != null) {
        return visit(ctx.logicalExpression());
    }
    throw new SemanticError(
        ctx.getStart().getLine(),
        ctx.getStart().getCharPositionInLine(),
        "Expressão inválida"
    );
}

@Override
public Type visitArithmeticExpression(FuelangParser.ArithmeticExpressionContext ctx) {
    Type type = visit(ctx.term(0));
    
    for (int i = 1; i < ctx.term().size(); i++) {
        Type termType = visit(ctx.term(i));
        if (!type.equals(Type.INTEGER) || !termType.equals(Type.INTEGER)) {
            throw new SemanticError(
                ctx.getStart().getLine(),
                ctx.getStart().getCharPositionInLine(),
                "Operações aritméticas requerem operandos inteiros"
            );
        }
    }
    
    return Type.INTEGER;
}


}
