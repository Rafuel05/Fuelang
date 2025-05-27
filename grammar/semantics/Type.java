package grammar.semantics;

public enum Type {
    INTEGER,
    TEXT,
    BOOLEAN;

    public static Type fromString(String typeStr) {
        return switch (typeStr.toLowerCase()) {
            case "integer" -> INTEGER;
            case "text" -> TEXT;
            default -> throw new SemanticError(-1, -1, "Tipo desconhecido: " + typeStr);
        };
    }

    @Override
    public String toString() {
        return switch (this) {
            case INTEGER -> "integer";
            case TEXT -> "text";
            case BOOLEAN -> "boolean";
        };
    }
}