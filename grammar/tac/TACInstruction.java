package grammar.tac;

public class TACInstruction {
    private Operador operador;
    private TACOperand resultado;
    private TACOperand arg1;
    private TACOperand arg2;

    public enum Operador {
    SOMA, SUB, MULT, DIV,    // Operações aritméticas
    ATRIB,                   // Atribuição
    ROTULO,                  // Definição de rótulo
    SE_FALSO, DESVIAR,      // Controle de fluxo
    MENOR, MAIOR, IGUAL,     // Comparações
    DIFERENTE, MENOR_IGUAL, 
    MAIOR_IGUAL,
    AND, OR, NOT,           // Operações lógicas
    IMPRIMIR,               // Operações de E/S
    LER
}

    public TACInstruction(Operador operador, TACOperand resultado, TACOperand arg1, TACOperand arg2) {
        this.operador = operador;
        this.resultado = resultado;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    // Construtor para operações unárias (como DESVIAR, IMPRIMIR)
    public TACInstruction(Operador operador, TACOperand arg1) {
        this(operador, null, arg1, null);
    }

    // Getters
    public Operador getOperador() { return operador; }
    public TACOperand getResultado() { return resultado; }
    public TACOperand getArg1() { return arg1; }
    public TACOperand getArg2() { return arg2; }

    @Override
    public String toString() {
        switch (operador) {
            case ROTULO:
                return arg1 + ":";
            case DESVIAR:
                return "desviar " + arg1;
            case SE_FALSO:
                return "se_falso " + arg1 + " desviar " + arg2;
            case IMPRIMIR:
                return "imprimir " + arg1;
            case LER:
                return "ler " + resultado;
            case ATRIB:
                return resultado + " = " + arg1;
            default:
                if (arg2 != null) {
                    return resultado + " = " + arg1 + " " + getOperadorSimbolo() + " " + arg2;
                } else {
                    return resultado + " = " + getOperadorSimbolo() + " " + arg1;
                }
        }
    }

    private String getOperadorSimbolo() {
        switch (operador) {
            case SOMA: return "+";
            case SUB: return "-";
            case MULT: return "*";
            case DIV: return "/";
            case MENOR: return "<";
            case MAIOR: return ">";
            case IGUAL: return "==";
            case DIFERENTE: return "!=";
            case MENOR_IGUAL: return "<=";
            case MAIOR_IGUAL: return ">=";
            default: return operador.toString();
        }
    }
}
