package grammar;

public class LexicalError extends RuntimeException {
    private int line;
    private int column;
    private String symbol;

    public LexicalError(int line, int column, String symbol) {
        super(String.format("ERRO LÉXICO [Linha %d, Coluna %d]: Símbolo '%s' inválido", 
            line, column, symbol));
        this.line = line;
        this.column = column;
        this.symbol = symbol;
    }
}
