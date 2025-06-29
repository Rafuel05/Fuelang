package grammar.tac;

import grammar.FuelangBaseVisitor;
import grammar.FuelangParser;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeradorTAC extends FuelangBaseVisitor<TACOperand> {
    private List<TACInstruction> instrucoes;
    private int contadorTemp;
    private int contadorRotulo;
    private Map<String, TACOperand> variaveis;
    

    public GeradorTAC() {
        this.instrucoes = new ArrayList<>();
        this.contadorTemp = 0;
        this.contadorRotulo = 0;
        this.variaveis = new HashMap<>();
    }

    // Cria uma nova variável temporária
    private TACOperand novoTemp() {
        return new TACOperand("_t" + contadorTemp++, TACOperand.TipoOperando.TEMPORARIO);
    }

    // Cria um novo rótulo
    private TACOperand novoRotulo() {
        return new TACOperand("L" + contadorRotulo++, TACOperand.TipoOperando.ROTULO);
    }

    // Cria um operando literal
    private TACOperand novoLiteral(String valor) {
        return new TACOperand(valor, TACOperand.TipoOperando.LITERAL);
    }

    // Obtém ou cria um operando variável
    private TACOperand getVariavel(String nome) {
        return variaveis.computeIfAbsent(nome, 
            k -> new TACOperand(k, TACOperand.TipoOperando.VARIAVEL));
    }

    // Adiciona uma instrução à lista
    private void emitir(TACInstruction instrucao) {
        instrucoes.add(instrucao);
    }

    public List<TACInstruction> getInstrucoes() {
        return instrucoes;
    }

    @Override
    public TACOperand visitProgram(FuelangParser.ProgramContext ctx) {
        return visitDeclarations(ctx.declarations());
    }

    @Override
    public TACOperand visitDeclarations(FuelangParser.DeclarationsContext ctx) {
        for (FuelangParser.DeclarationContext decl : ctx.declaration()) {
            visit(decl);
        }
        return null;
    }

    @Override
    public TACOperand visitVariableDeclaration(FuelangParser.VariableDeclarationContext ctx) {
        String nomeVar = ctx.ID().getText();
        TACOperand var = getVariavel(nomeVar);
        
        if (ctx.expression() != null) {
            TACOperand valor = visit(ctx.expression());
            emitir(new TACInstruction(TACInstruction.Operador.ATRIB, var, valor, null));
        }
        
        return var;
    }

    @Override
    public TACOperand visitAssignment(FuelangParser.AssignmentContext ctx) {
        String nomeVar = ctx.ID().getText();
        TACOperand var = getVariavel(nomeVar);
        TACOperand valor = visit(ctx.expression());
        emitir(new TACInstruction(TACInstruction.Operador.ATRIB, var, valor, null));
        return var;
    }

    @Override
    public TACOperand visitExpression(FuelangParser.ExpressionContext ctx) {
        if (ctx.logicalExpression() != null) {
            return visit(ctx.logicalExpression());
        } else if (ctx.arithmeticExpression() != null) {
            return visit(ctx.arithmeticExpression());
        } else if (ctx.STRING() != null) {
            return novoLiteral(ctx.STRING().getText());
        }
        return null;
    }

    @Override
    public TACOperand visitArithmeticExpression(FuelangParser.ArithmeticExpressionContext ctx) {
        TACOperand resultado = visit(ctx.term(0));
        
        for (int i = 0; i < ctx.arithmeticOperator().size(); i++) {
            TACOperand direita = visit(ctx.term(i + 1));
            TACOperand temp = novoTemp();
            
            TACInstruction.Operador op;
            String operador = ctx.arithmeticOperator(i).getText();
            switch (operador) {
                case "+": op = TACInstruction.Operador.SOMA; break;
                case "-": op = TACInstruction.Operador.SUB; break;
                default:
                    System.out.println("Operador aritmético não suportado: " + operador);
                    throw new RuntimeException("Operador não suportado");
            }
            
            emitir(new TACInstruction(op, temp, resultado, direita));
            resultado = temp;
        }
        
        return resultado;
    }

    @Override
    public TACOperand visitTerm(FuelangParser.TermContext ctx) {
        TACOperand resultado = visit(ctx.factor(0));
        
        for (int i = 0; i < ctx.termOperator().size(); i++) {
            TACOperand direita = visit(ctx.factor(i + 1));
            TACOperand temp = novoTemp();
            
            TACInstruction.Operador op;
            String operador = ctx.termOperator(i).getText();
            switch (operador) {
                case "*": op = TACInstruction.Operador.MULT; break;
                case "/": op = TACInstruction.Operador.DIV; break;
                default:
                    System.out.println("Operador de termo não suportado: " + operador);
                    throw new RuntimeException("Operador não suportado");
            }
            
            emitir(new TACInstruction(op, temp, resultado, direita));
            resultado = temp;
        }
        
        return resultado;
    }

    @Override
    public TACOperand visitFactor(FuelangParser.FactorContext ctx) {
        if (ctx.ID() != null) {
            return getVariavel(ctx.ID().getText());
        } else if (ctx.NUMBER() != null) {
            return novoLiteral(ctx.NUMBER().getText());
        } else if (ctx.arithmeticExpression() != null) {
            return visit(ctx.arithmeticExpression());
        }
        
        System.out.println("Tipo de fator não suportado");
        throw new RuntimeException("Fator não suportado");
    }

    @Override
    public TACOperand visitIfCommand(FuelangParser.IfCommandContext ctx) {
        TACOperand condicao = visit(ctx.expression());
        TACOperand rotuloFalso = novoRotulo();
        TACOperand rotuloFim = novoRotulo();
        
        emitir(new TACInstruction(TACInstruction.Operador.SE_FALSO, null, condicao, rotuloFalso));
        
        visit(ctx.block(0));
        
        emitir(new TACInstruction(TACInstruction.Operador.DESVIAR, null, rotuloFim, null));
        emitir(new TACInstruction(TACInstruction.Operador.ROTULO, null, rotuloFalso, null));
        
        if (ctx.block().size() > 1) {
            visit(ctx.block(1));
        }
        
        emitir(new TACInstruction(TACInstruction.Operador.ROTULO, null, rotuloFim, null));
        return null;
    }

    @Override
    public TACOperand visitWhileCommand(FuelangParser.WhileCommandContext ctx) {
        TACOperand rotuloInicio = novoRotulo();
        TACOperand rotuloFim = novoRotulo();
        
        emitir(new TACInstruction(TACInstruction.Operador.ROTULO, null, rotuloInicio, null));
        
        TACOperand condicao = visit(ctx.expression());
        emitir(new TACInstruction(TACInstruction.Operador.SE_FALSO, null, condicao, rotuloFim));
        
        visit(ctx.block());
        
        emitir(new TACInstruction(TACInstruction.Operador.DESVIAR, null, rotuloInicio, null));
        emitir(new TACInstruction(TACInstruction.Operador.ROTULO, null, rotuloFim, null));
        return null;
    }

    @Override
    public TACOperand visitOutputCommand(FuelangParser.OutputCommandContext ctx) {
        TACOperand valor = visit(ctx.expression());
        emitir(new TACInstruction(TACInstruction.Operador.IMPRIMIR, null, valor, null));
        return null;
    }

    @Override
    public TACOperand visitInputCommand(FuelangParser.InputCommandContext ctx) {
        TACOperand var = getVariavel(ctx.ID().getText());
        emitir(new TACInstruction(TACInstruction.Operador.LER, var, null, null));
        return var;
    }

    @Override
    public TACOperand visitComparison(FuelangParser.ComparisonContext ctx) {
        TACOperand esquerda = visit(ctx.arithmeticExpression(0));
        TACOperand direita = visit(ctx.arithmeticExpression(1));
        TACOperand resultado = novoTemp();
        
        TACInstruction.Operador op;
        switch (ctx.comparisonOperator().getText()) {
            case "<": op = TACInstruction.Operador.MENOR; break;
            case ">": op = TACInstruction.Operador.MAIOR; break;
            case "==": op = TACInstruction.Operador.IGUAL; break;
            case "!=": op = TACInstruction.Operador.DIFERENTE; break;
            case "<=": op = TACInstruction.Operador.MENOR_IGUAL; break;
            case ">=": op = TACInstruction.Operador.MAIOR_IGUAL; break;
            default:
                System.out.println("Operador de comparação não suportado: " + ctx.comparisonOperator().getText());
                throw new RuntimeException("Operador não suportado");
        }
        
        emitir(new TACInstruction(op, resultado, esquerda, direita));
        return resultado;
    }

    @Override
    public TACOperand visitLogicalExpression(FuelangParser.LogicalExpressionContext ctx) {
        TACOperand resultado = visit(ctx.logicalTerm(0));
        
        for (int i = 1; i < ctx.logicalTerm().size(); i++) {
            TACOperand direita = visit(ctx.logicalTerm(i));
            TACOperand temp = novoTemp();
            emitir(new TACInstruction(TACInstruction.Operador.OR, temp, resultado, direita));
            resultado = temp;
        }
        
        return resultado;
    }

    @Override
    public TACOperand visitLogicalTerm(FuelangParser.LogicalTermContext ctx) {
        TACOperand resultado = visit(ctx.logicalFactor(0));
        
        for (int i = 1; i < ctx.logicalFactor().size(); i++) {
            TACOperand direita = visit(ctx.logicalFactor(i));
            TACOperand temp = novoTemp();
            emitir(new TACInstruction(TACInstruction.Operador.AND, temp, resultado, direita));
            resultado = temp;
        }
        
        return resultado;
    }

    @Override
    public TACOperand visitLogicalFactor(FuelangParser.LogicalFactorContext ctx) {
        if (ctx.NOT() != null) {
            TACOperand operando = visit(ctx.logicalFactor());
            TACOperand resultado = novoTemp();
            emitir(new TACInstruction(TACInstruction.Operador.NOT, resultado, operando, null));
            return resultado;
        } else if (ctx.logicalExpression() != null) {
            return visit(ctx.logicalExpression());
        } else if (ctx.comparison() != null) {
            return visit(ctx.comparison());
        }
        
        System.out.println("Tipo de fator lógico não suportado");
        throw new RuntimeException("Fator lógico não suportado");
    }

    public void salvarCodigoTAC(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            writer.println("# Código Intermediário (TAC) gerado para " + nomeArquivo);
            writer.println("# Formato: operador resultado, arg1, arg2");
            writer.println();
            
            for (int i = 0; i < instrucoes.size(); i++) {
                writer.printf("%3d: %s%n", i, instrucoes.get(i).toString());
            }
            
            System.out.println("Código TAC gerado com sucesso em: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o código TAC: " + e.getMessage());
            throw new RuntimeException("Erro ao salvar o código TAC", e);
        }
    }
}