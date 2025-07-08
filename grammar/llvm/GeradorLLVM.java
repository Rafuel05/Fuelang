package grammar.llvm;

import grammar.tac.TACInstruction;
import grammar.tac.TACOperand;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class GeradorLLVM {
    private StringBuilder codigo;
    private StringBuilder stringsGlobais;
    private Map<String, String> tiposVariaveis;
    private Map<String, String> mapeamentoOperandos;
    private Map<String, String> mapeamentoStrings;
    private int contadorLabel;
    private int contadorRegistrador;
    private int contadorString;
    private Set<String> labelsUsados;
    private Set<String> labelsDefinidos;
    private String ultimaInstrucao = "";
    
    public GeradorLLVM() {
        this.codigo = new StringBuilder();
        this.stringsGlobais = new StringBuilder();
        this.tiposVariaveis = new HashMap<>();
        this.mapeamentoOperandos = new HashMap<>();
        this.mapeamentoStrings = new HashMap<>();
        this.contadorLabel = 0;
        this.contadorRegistrador = 0;
        this.contadorString = 0;
        this.labelsUsados = new HashSet<>();
        this.labelsDefinidos = new HashSet<>();
        inicializarCodigo();
    }
    
    private void inicializarCodigo() {
        // Cabeçalho do arquivo LLVM IR
        codigo.append("; Código LLVM IR gerado pelo compilador Fuelang\n");
        codigo.append("; Target: x86_64\n\n");
        
        // Declarações de funções externas para I/O
        codigo.append("declare i32 @printf(i8*, ...)\n");
        codigo.append("declare i32 @scanf(i8*, ...)\n");
        codigo.append("declare i8* @malloc(i64)\n\n");
        
        // Strings globais para I/O
        codigo.append("@.str_int = private unnamed_addr constant [4 x i8] c\"%d\\0A\\00\", align 1\n");
        codigo.append("@.str_float = private unnamed_addr constant [4 x i8] c\"%f\\0A\\00\", align 1\n");
        codigo.append("@.str_read_int = private unnamed_addr constant [3 x i8] c\"%d\\00\", align 1\n");
        codigo.append("@.str_read_float = private unnamed_addr constant [3 x i8] c\"%f\\00\", align 1\n");
    }
    
    public void gerarLLVM(List<TACInstruction> instrucoesTAC) {
        // Primeira passada: processar strings literais
        processarStringsLiterais(instrucoesTAC);
        
        // Adicionar strings globais ao código
        codigo.append(stringsGlobais.toString()).append("\n");
        
        // Função main
        codigo.append("define i32 @main() {\n");
        codigo.append("entry:\n");
        
        // Segunda passada: declarar todas as variáveis
        declararVariaveis(instrucoesTAC);
        
        // Análise de labels (terceira passada)
        analisarLabels(instrucoesTAC);
        
        // Quarta passada: gerar código
        for (int i = 0; i < instrucoesTAC.size(); i++) {
            TACInstruction instrucao = instrucoesTAC.get(i);
            traduzirInstrucao(instrucao, i, instrucoesTAC);
        }
        
        // Se a última instrução não foi um branch, adiciona um
        if (!ultimaInstrucao.contains("br ")) {
            codigo.append("  br label %end_program\n");
        }
        
        // Adicionar label de fim
        codigo.append("\nend_program:\n");
        
        // Finalizar função main
        codigo.append("  ret i32 0\n");
        codigo.append("}\n");
    }
    
    private void analisarLabels(List<TACInstruction> instrucoes) {
        // Identificar todos os labels definidos
        for (TACInstruction instrucao : instrucoes) {
            if (instrucao.getOperador() == TACInstruction.Operador.ROTULO) {
                String label = instrucao.getArg1().getNome();
                labelsDefinidos.add(label);
                System.out.println("Label definido: " + label);
            }
        }
        
        // Identificar todos os labels usados
        for (TACInstruction instrucao : instrucoes) {
            if (instrucao.getOperador() == TACInstruction.Operador.DESVIAR) {
                String label = instrucao.getArg1().getNome();
                labelsUsados.add(label);
                System.out.println("Label usado em DESVIAR: " + label);
            } else if (instrucao.getOperador() == TACInstruction.Operador.SE_FALSO) {
                String label = instrucao.getArg2().getNome();
                labelsUsados.add(label);
                System.out.println("Label usado em SE_FALSO: " + label);
            }
        }
        
        // Debug: mostrar labels não usados
        for (String label : labelsDefinidos) {
            if (!labelsUsados.contains(label)) {
                System.out.println("AVISO: Label não usado: " + label);
            }
        }
    }
    
    private void processarStringsLiterais(List<TACInstruction> instrucoes) {
        for (TACInstruction instrucao : instrucoes) {
            processarStringLiteral(instrucao.getArg1());
            processarStringLiteral(instrucao.getArg2());
        }
    }
    
    private void processarStringLiteral(TACOperand operando) {
        if (operando == null || operando.getTipo() != TACOperand.TipoOperando.LITERAL) {
            return;
        }
        
        String valor = operando.getNome();
        // Verifica se é uma string literal (entre aspas)
        if (valor.startsWith("\"") && valor.endsWith("\"")) {
            if (!mapeamentoStrings.containsKey(valor)) {
                String nomeGlobal = "@.str_" + contadorString++;
                String conteudo = valor.substring(1, valor.length() - 1); // Remove aspas
                
                // Converte para bytes UTF-8 e processa para LLVM
                String conteudoLLVM = converterParaLLVM(conteudo);
                
                // Calcula o tamanho em bytes da string processada
                int tamanho = contarBytesLLVM(conteudoLLVM);
                
                // Cria a declaração da string global
                String declaracao = nomeGlobal + " = private unnamed_addr constant [" + 
                                  tamanho + " x i8] c\"" + conteudoLLVM + "\", align 1\n";
                
                stringsGlobais.append(declaracao);
                mapeamentoStrings.put(valor, nomeGlobal + ":" + tamanho);
            }
        }
    }
    
    private String converterParaLLVM(String conteudo) {
        StringBuilder resultado = new StringBuilder();
        
        for (int i = 0; i < conteudo.length(); i++) {
            char c = conteudo.charAt(i);
            
            // Handle escape sequences first
            if (c == '\\' && i + 1 < conteudo.length()) {
                char nextChar = conteudo.charAt(i + 1);
                switch (nextChar) {
                    case 'n':
                        resultado.append("\\0A"); // Newline
                        i++; // Skip next character
                        break;
                    case 't':
                        resultado.append("\\09"); // Tab
                        i++; // Skip next character
                        break;
                    case 'r':
                        resultado.append("\\0D"); // Carriage return
                        i++; // Skip next character
                        break;
                    case '\\':
                        resultado.append("\\\\"); // Backslash
                        i++; // Skip next character
                        break;
                    case '"':
                        resultado.append("\\22"); // Quote
                        i++; // Skip next character
                        break;
                    default:
                        // Not a recognized escape sequence, treat as literal
                        resultado.append(String.format("\\%02X", (int) c));
                        break;
                }
            } else if (c >= 32 && c <= 126 && c != 34 && c != 92) {
                // Printable ASCII characters, except " and \
                resultado.append(c);
            } else {
                // Special characters or non-ASCII - use hexadecimal escape
                resultado.append(String.format("\\%02X", (int) c));
            }
        }
        
        // Add null terminator
        resultado.append("\\00");
        
        return resultado.toString();
    }
    
    private int contarBytesLLVM(String conteudoLLVM) {
        int bytes = 0;
        int i = 0;
        
        while (i < conteudoLLVM.length()) {
            if (conteudoLLVM.charAt(i) == '\\' && i + 1 < conteudoLLVM.length()) {
                char next = conteudoLLVM.charAt(i + 1);
                if (Character.isDigit(next) || (next >= 'A' && next <= 'F')) {
                    // Escape hexadecimal \XX
                    i += 3; // pula \XX
                    bytes++;
                } else if (next == '\\') {
                    // Escape \\
                    i += 2;
                    bytes++;
                } else {
                    // Outros escapes
                    i += 2;
                    bytes++;
                }
            } else {
                i++;
                bytes++;
            }
        }
        
        return bytes;
    }
    
    private void declararVariaveis(List<TACInstruction> instrucoes) {
        for (TACInstruction instrucao : instrucoes) {
            declararOperando(instrucao.getResultado());
            declararOperando(instrucao.getArg1());
            declararOperando(instrucao.getArg2());
        }
    }
    
    private void declararOperando(TACOperand operando) {
        if (operando == null) return;
        
        String nome = operando.getNome();
        if (operando.getTipo() == TACOperand.TipoOperando.VARIAVEL && 
            !mapeamentoOperandos.containsKey(nome)) {
            
            String registrador = "%" + nome;
            mapeamentoOperandos.put(nome, registrador);
            tiposVariaveis.put(nome, "i32"); // Assumindo inteiros por padrão
            codigo.append("  ").append(registrador).append(" = alloca i32, align 4\n");
        }
    }
    
    private void traduzirInstrucao(TACInstruction instrucao, int indice, List<TACInstruction> instrucoes) {
        switch (instrucao.getOperador()) {
            case ATRIB:
                traduzirAtribuicao(instrucao);
                break;
            case SOMA:
                traduzirOperacaoAritmetica(instrucao, "add");
                break;
            case SUB:
                traduzirOperacaoAritmetica(instrucao, "sub");
                break;
            case MULT:
                traduzirOperacaoAritmetica(instrucao, "mul");
                break;
            case DIV:
                traduzirOperacaoAritmetica(instrucao, "sdiv");
                break;
            case MENOR:
                traduzirComparacao(instrucao, "slt");
                break;
            case MAIOR:
                traduzirComparacao(instrucao, "sgt");
                break;
            case IGUAL:
                traduzirComparacao(instrucao, "eq");
                break;
            case DIFERENTE:
                traduzirComparacao(instrucao, "ne");
                break;
            case MENOR_IGUAL:
                traduzirComparacao(instrucao, "sle");
                break;
            case MAIOR_IGUAL:
                traduzirComparacao(instrucao, "sge");
                break;
            case AND:
                traduzirOperacaoLogica(instrucao, "and");
                break;
            case OR:
                traduzirOperacaoLogica(instrucao, "or");
                break;
            case NOT:
                traduzirNegacao(instrucao);
                break;
            case ROTULO:
                traduzirRotulo(instrucao, indice, instrucoes);
                break;
            case DESVIAR:
                traduzirDesvio(instrucao);
                break;
            case SE_FALSO:
                traduzirDesvioCondicional(instrucao);
                break;
            case IMPRIMIR:
                traduzirImpressao(instrucao);
                break;
            case LER:
                traduzirLeitura(instrucao);
                break;
        }
    }
    
    private void traduzirAtribuicao(TACInstruction instrucao) {
        String destino = obterOperando(instrucao.getResultado());
        String valor = carregarOperando(instrucao.getArg1());
        
        String instrucaoLLVM = "  store i32 " + valor + ", i32* " + destino + ", align 4\n";
        codigo.append(instrucaoLLVM);
        ultimaInstrucao = instrucaoLLVM;
    }
    
    private void traduzirOperacaoAritmetica(TACInstruction instrucao, String operacao) {
        String arg1 = carregarOperando(instrucao.getArg1());
        String arg2 = carregarOperando(instrucao.getArg2());
        String resultado = obterRegistradorTemp(instrucao.getResultado());
        
        String instrucaoLLVM = "  " + resultado + " = " + operacao + " i32 " + arg1 + ", " + arg2 + "\n";
        codigo.append(instrucaoLLVM);
        ultimaInstrucao = instrucaoLLVM;
    }
    
    private void traduzirComparacao(TACInstruction instrucao, String condicao) {
        String arg1 = carregarOperando(instrucao.getArg1());
        String arg2 = carregarOperando(instrucao.getArg2());
        String resultado = obterRegistradorTemp(instrucao.getResultado());
        String regTemp = novoRegistrador();
        
        codigo.append("  ").append(regTemp).append(" = icmp ").append(condicao)
              .append(" i32 ").append(arg1).append(", ").append(arg2).append("\n");
        String instrucaoLLVM = "  " + resultado + " = zext i1 " + regTemp + " to i32\n";
        codigo.append(instrucaoLLVM);
        ultimaInstrucao = instrucaoLLVM;
    }
    
    private void traduzirOperacaoLogica(TACInstruction instrucao, String operacao) {
        String arg1 = carregarOperando(instrucao.getArg1());
        String arg2 = carregarOperando(instrucao.getArg2());
        String resultado = obterRegistradorTemp(instrucao.getResultado());
        
        String instrucaoLLVM = "  " + resultado + " = " + operacao + " i32 " + arg1 + ", " + arg2 + "\n";
        codigo.append(instrucaoLLVM);
        ultimaInstrucao = instrucaoLLVM;
    }
    
    private void traduzirNegacao(TACInstruction instrucao) {
        String arg = carregarOperando(instrucao.getArg1());
        String resultado = obterRegistradorTemp(instrucao.getResultado());
        String regTemp = novoRegistrador();
        
        codigo.append("  ").append(regTemp).append(" = icmp eq i32 ").append(arg)
              .append(", 0\n");
        String instrucaoLLVM = "  " + resultado + " = zext i1 " + regTemp + " to i32\n";
        codigo.append(instrucaoLLVM);
        ultimaInstrucao = instrucaoLLVM;
    }
    
    private void traduzirRotulo(TACInstruction instrucao, int indice, List<TACInstruction> instrucoes) {
        String label = instrucao.getArg1().getNome();
        
        // Only add a branch before the label if the previous instruction wasn't already a branch
        // and we're not at the beginning of the function
        if (!ultimaInstrucao.contains("br ") && !ultimaInstrucao.isEmpty()) {
            // Always fall through to the next instruction by adding a branch to this label
            codigo.append("  br label %").append(label).append("\n");
        }
        
        codigo.append(label).append(":\n");
        ultimaInstrucao = ""; // Reset for new block
        
        // Check if the next instruction is also a label
        // If so, we need to add a branch to it to avoid consecutive labels
        if (indice + 1 < instrucoes.size()) {
            TACInstruction nextInstr = instrucoes.get(indice + 1);
            if (nextInstr.getOperador() == TACInstruction.Operador.ROTULO) {
                // Next instruction is also a label, add a branch to it
                String nextLabel = nextInstr.getArg1().getNome();
                codigo.append("  br label %").append(nextLabel).append("\n");
                ultimaInstrucao = "  br label %" + nextLabel + "\n";
            }
        }
    }
    
    // Helper method to determine if a label represents dead code
    private boolean isDeadCodeLabel(String label, int indice, List<TACInstruction> instrucoes) {
        // Check if this label is the target of any branches or conditional jumps
        for (TACInstruction inst : instrucoes) {
            if (inst.getOperador() == TACInstruction.Operador.DESVIAR && 
                inst.getArg1().getNome().equals(label)) {
                return false; // Label is used by a branch
            }
            if (inst.getOperador() == TACInstruction.Operador.SE_FALSO && 
                inst.getArg2().getNome().equals(label)) {
                return false; // Label is used by a conditional branch
            }
        }
        
        // If we reach here, the label might be dead code
        // But let's be conservative and only consider it dead if it's at the very end
        // with no following instructions
        for (int i = indice + 1; i < instrucoes.size(); i++) {
            TACInstruction proxima = instrucoes.get(i);
            if (proxima.getOperador() != TACInstruction.Operador.ROTULO) {
                return false; // There are non-label instructions following
            }
        }
        
        return true; // Only labels follow, so this might be dead code
    }
    
    private void traduzirDesvio(TACInstruction instrucao) {
        String label = instrucao.getArg1().getNome();
        String instrucaoLLVM = "  br label %" + label + "\n";
        codigo.append(instrucaoLLVM);
        ultimaInstrucao = instrucaoLLVM;
    }
    
    private void traduzirDesvioCondicional(TACInstruction instrucao) {
        String condicao = carregarOperando(instrucao.getArg1());
        String labelFalso = instrucao.getArg2().getNome();
        String regTemp = novoRegistrador();
        String labelContinua = "continue" + contadorLabel++;
        
        codigo.append("  ").append(regTemp).append(" = icmp eq i32 ").append(condicao)
              .append(", 0\n");
        String branchLLVM = "  br i1 " + regTemp + ", label %" + labelFalso + ", label %" + labelContinua + "\n";
        codigo.append(branchLLVM);
        codigo.append("\n").append(labelContinua).append(":\n");
        ultimaInstrucao = "";
    }
    
    private void traduzirImpressao(TACInstruction instrucao) {
        TACOperand operando = instrucao.getArg1();
        String regTemp = novoRegistrador();
        
        String instrucaoLLVM;
        if (operando.getTipo() == TACOperand.TipoOperando.LITERAL && 
            operando.getNome().startsWith("\"") && operando.getNome().endsWith("\"")) {
            // É uma string literal
            String info = mapeamentoStrings.get(operando.getNome());
            String[] partes = info.split(":");
            String nomeGlobal = partes[0];
            int tamanho = Integer.parseInt(partes[1]);
            
            instrucaoLLVM = "  " + regTemp + " = call i32 (i8*, ...) @printf(" +
                  "i8* getelementptr inbounds ([" + tamanho + " x i8], [" +
                  tamanho + " x i8]* " + nomeGlobal + ", i64 0, i64 0))\n";
        } else {
            // É um número
            String valor = carregarOperando(operando);
            instrucaoLLVM = "  " + regTemp + " = call i32 (i8*, ...) @printf(" +
                  "i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str_int, i64 0, i64 0), " +
                  "i32 " + valor + ")\n";
        }
        codigo.append(instrucaoLLVM);
        ultimaInstrucao = instrucaoLLVM;
    }
    
    private void traduzirLeitura(TACInstruction instrucao) {
        String variavel = obterOperando(instrucao.getResultado());
        String regTemp = novoRegistrador();
        
        String instrucaoLLVM = "  " + regTemp + " = call i32 (i8*, ...) @scanf(" +
              "i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str_read_int, i64 0, i64 0), " +
              "i32* " + variavel + ")\n";
        codigo.append(instrucaoLLVM);
        ultimaInstrucao = instrucaoLLVM;
    }
    
    private String obterOperando(TACOperand operando) {
        if (operando == null) return null;
        
        switch (operando.getTipo()) {
            case VARIAVEL:
                return mapeamentoOperandos.get(operando.getNome());
            case TEMPORARIO:
                return obterRegistradorTemp(operando);
            case LITERAL:
                return operando.getNome();
            case ROTULO:
                return "%" + operando.getNome();
            default:
                return operando.getNome();
        }
    }
    
    private String carregarOperando(TACOperand operando) {
        if (operando == null) return null;
        
        switch (operando.getTipo()) {
            case VARIAVEL:
                String var = mapeamentoOperandos.get(operando.getNome());
                String regTemp = novoRegistrador();
                codigo.append("  ").append(regTemp).append(" = load i32, i32* ")
                      .append(var).append(", align 4\n");
                return regTemp;
            case TEMPORARIO:
                return obterRegistradorTemp(operando);
            case LITERAL:
                // Verifica se é string literal (não deveria ser carregada como i32)
                if (operando.getNome().startsWith("\"") && operando.getNome().endsWith("\"")) {
                    throw new RuntimeException("Tentativa de carregar string literal como inteiro: " + operando.getNome());
                }
                return operando.getNome();
            default:
                return operando.getNome();
        }
    }
    
    private String obterRegistradorTemp(TACOperand operando) {
        String nome = operando.getNome();
        if (!mapeamentoOperandos.containsKey(nome)) {
            mapeamentoOperandos.put(nome, novoRegistrador());
        }
        return mapeamentoOperandos.get(nome);
    }
    
    private String novoRegistrador() {
        return "%r" + contadorRegistrador++;
    }
    
    public void salvarCodigoLLVM(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            writer.print(codigo.toString());
            System.out.println("Código LLVM IR gerado com sucesso em: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o código LLVM: " + e.getMessage());
            throw new RuntimeException("Erro ao salvar o código LLVM", e);
        }
    }
    
    public String getCodigo() {
        return codigo.toString();
    }
}