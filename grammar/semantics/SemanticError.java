package grammar.semantics;

public class SemanticError extends RuntimeException {
    private final int line;
    private final int column;

    public SemanticError(int line, int column, String message) {
        super(String.format("[ERRO SEMÂNTICO] Linha %d, Coluna %d: %s", line, column, message));
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }
}