package grammar.semantics;

public class VariableInfo {
    private final Type type;
    private boolean initialized;
    private final int declarationLine;
    private final int declarationColumn;

    public VariableInfo(Type type, int line, int column) {
        this.type = type;
        this.initialized = false;
        this.declarationLine = line;
        this.declarationColumn = column;
    }

    public Type getType() {
        return type;
    }

    public boolean isInitialized() {
        return initialized;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }

    public int getDeclarationLine() {
        return declarationLine;
    }

    public int getDeclarationColumn() {
        return declarationColumn;
    }
}
