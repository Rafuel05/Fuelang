package grammar.tac;

public class TACOperand {
    private String nome;
    private TipoOperando tipo;

    public enum TipoOperando {
        VARIAVEL,    // Variáveis do programa
        TEMPORARIO,  // Temporários gerados pelo compilador (_t0, _t1, etc)
        ROTULO,      // Rótulos para desvios (L0, L1, etc)
        LITERAL      // Valores literais (números, strings)
    }

    public TACOperand(String nome, TipoOperando tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public TipoOperando getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return nome;
    }
}
