package grammar;

public class SyntaxError extends RuntimeException {
    public SyntaxError(int line, int column, String expected, String found) {
        super(String.format("ERRO SINTÁTICO [Linha %d, Coluna %d]: Esperado '%s', encontrado '%s'",
                line, column, expected, found));
    }
}