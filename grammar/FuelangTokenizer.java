package grammar;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class FuelangTokenizer {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Uso: java FuelangTokenizer <arquivo.fuel> [-dot]");
            System.exit(1);
        }

        try {
            // Carregar o arquivo fonte
            CharStream input = CharStreams.fromFileName(args[0]);
            
            // Criar o lexer
            FuelangLexer lexer = new FuelangLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            
            // Criar o parser
            FuelangParser parser = new FuelangParser(tokens);
            ParserRuleContext tree = parser.programa();

            // Mostrar tokens se não for modo DOT
            if (args.length == 1 || !args[1].equals("-dot")) {
                System.out.println("=== Árvore Sintática ===");
                System.out.println(tree.toStringTree(parser));
                
                System.out.println("\n=== Tokens ===");
                tokens.fill();
                for (Token token : tokens.getTokens()) {
                    if (token.getType() != Token.EOF) {
                        System.out.printf("<%s, %s, %d, %d>\n",
                            lexer.getVocabulary().getSymbolicName(token.getType()),
                            token.getText().replace("\n", "\\n"),
                            token.getLine(),
                            token.getCharPositionInLine()
                        );
                    }
                }
            }
            
            // Gerar arquivo DOT se solicitado
            if (args.length > 1 && args[1].equals("-dot")) {
                DotGenerator dot = new DotGenerator();
                generateDOT(tree, parser, dot);
                dot.generateDotFile("ast.dot");
                System.out.println("Arquivo AST gerado: ast.dot");
            }
            
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
        } catch (LexicalError e) {
            System.err.println(e.getMessage());
        }
    }

    private static void generateDOT(ParseTree tree, FuelangParser parser, DotGenerator dot) {
        if (tree instanceof ParserRuleContext) {
            ParserRuleContext ctx = (ParserRuleContext) tree;
            String rootNode = dot.addNode(parser.getRuleNames()[ctx.getRuleIndex()]);
            
            for (int i = 0; i < tree.getChildCount(); i++) {
                ParseTree child = tree.getChild(i);
                if (child instanceof TerminalNode) {
                    String childNode = dot.addNode(child.getText());
                    dot.addEdge(rootNode, childNode);
                } else if (child instanceof ParserRuleContext) {
                    ParserRuleContext childCtx = (ParserRuleContext) child;
                    String childNode = dot.addNode(parser.getRuleNames()[childCtx.getRuleIndex()]);
                    dot.addEdge(rootNode, childNode);
                    generateDOT(child, parser, dot);
                }
            }
        }
    }
}
