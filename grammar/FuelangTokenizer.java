package grammar;

import grammar.semantics.*;
import grammar.tac.GeradorTAC;
import grammar.llvm.GeradorLLVM;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class FuelangTokenizer {
    public static void main(String[] args) {
        try {
            if (args.length < 1) {
                System.out.println("Uso: java grammar.FuelangTokenizer <arquivo.fuel> [-dot|-tac|-llvm]");
                System.exit(1);
            }

            // Criar logger para mensagens do compilador
            CompilerLogger logger = new CompilerLogger();
            
            // Carregar o arquivo fonte
            CharStream input = CharStreams.fromFileName(args[0]);
            
            // Criar o lexer
            FuelangLexer lexer = new FuelangLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            
            // Criar o parser e configurar tratamento de erros
            FuelangParser parser = new FuelangParser(tokens);
            parser.removeErrorListeners(); // Remove o listener padrão
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer,
                                      Object offendingSymbol,
                                      int line,
                                      int charPositionInLine,
                                      String msg,
                                      RecognitionException e) {
                    Token offendingToken = (Token) offendingSymbol;
                    String expected = msg.contains("expecting") 
                        ? msg.substring(msg.indexOf("expecting") + 10)
                        : "outro token";
                    
                    throw new SyntaxError(line, 
                                        charPositionInLine, 
                                        expected, 
                                        offendingToken.getText());
                }
            });

            try {
                // Tentar fazer o parse
                FuelangParser.ProgramContext tree = parser.program();

                // Análise semântica
                try {
                    System.out.println("Iniciando análise semântica...");
                    SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer(logger);
                    semanticAnalyzer.visit(tree);
                    System.out.println("Análise semântica concluída com sucesso!");
                } catch (SemanticError e) {
                    System.err.println(e.getMessage());
                    System.exit(1);
                }

                // Gerar código TAC se solicitado
                if (args.length > 1 && (args[1].equals("-tac") || args[1].equals("-llvm"))) {
                    System.out.println("Iniciando geração de código TAC...");
                    GeradorTAC geradorTAC = new GeradorTAC();
                    geradorTAC.visit(tree);
                    
                    // Gerar arquivo .tac com o mesmo nome do arquivo fonte
                    String arquivoTAC = args[0].replaceAll("\\.fuel$", ".tac");
                    geradorTAC.salvarCodigoTAC(arquivoTAC);
                    System.out.println("Código TAC gerado com sucesso em: " + arquivoTAC);
                    
                    // Gerar código LLVM se solicitado
                    if (args[1].equals("-llvm")) {
                        System.out.println("Iniciando geração de código LLVM IR...");
                        GeradorLLVM geradorLLVM = new GeradorLLVM();
                        geradorLLVM.gerarLLVM(geradorTAC.getInstrucoes());
                        
                        // Gerar arquivo .ll com o mesmo nome do arquivo fonte
                        String arquivoLLVM = args[0].replaceAll("\\.fuel$", ".ll");
                        geradorLLVM.salvarCodigoLLVM(arquivoLLVM);
                        System.out.println("Código LLVM IR gerado com sucesso em: " + arquivoLLVM);
                    }
                }

                // Mostrar tokens se não for modo DOT, TAC ou LLVM
                if (args.length == 1 || (!args[1].equals("-dot") && !args[1].equals("-tac") && !args[1].equals("-llvm"))) {
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
                    System.out.println("Gerando arquivo DOT...");
                    DotGenerator dotGen = new DotGenerator();
                    generateDotFromTree(tree, parser, dotGen);
                    
                    String dotFile = args[0].replaceAll("\\.fuel$", ".dot");
                    dotGen.generateDotFile(dotFile);
                    System.out.println("Arquivo DOT gerado: " + dotFile);
                }

            } catch (SyntaxError e) {
                System.err.println(e.getMessage());
                System.exit(1);
            } catch (LexicalError e) {
                System.err.println(e.getMessage());
                System.exit(1);
            }

        } catch (Exception e) {
            System.err.println("Erro fatal: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    private static String generateDotFromTree(ParseTree tree, Parser parser, DotGenerator dotGen) {
        if (tree instanceof TerminalNode) {
            return dotGen.addNode(tree.getText());
        } else {
            RuleContext ruleContext = (RuleContext) tree;
            String ruleName = parser.getRuleNames()[ruleContext.getRuleIndex()];
            String parentNode = dotGen.addNode(ruleName);
            
            for (int i = 0; i < tree.getChildCount(); i++) {
                String childNode = generateDotFromTree(tree.getChild(i), parser, dotGen);
                dotGen.addEdge(parentNode, childNode);
            }
            
            return parentNode;
        }
    }
}