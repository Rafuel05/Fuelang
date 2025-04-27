package grammar;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CompilerLogger {
    private static final String LOG_FILE = "compiler.log";
    private static PrintWriter logWriter;
    
    static {
        try {
            logWriter = new PrintWriter(new FileWriter(LOG_FILE, true));
        } catch (IOException e) {
            System.err.println("Erro ao criar arquivo de log: " + e.getMessage());
        }
    }

    public static void log(String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String logMessage = String.format("[%s] %s", timestamp, message);
        
        System.out.println(logMessage);
        logWriter.println(logMessage);
        logWriter.flush();
    }

    public static void logToken(String type, String lexeme, int line, int column) {
        log(String.format("Token: <%s, %s, %d, %d>", type, lexeme, line, column));
    }

    public static void logError(String errorType, String message) {
        log("ERRO " + errorType + ": " + message);
    }

    public static void close() {
        if (logWriter != null) {
            logWriter.close();
        }
    }
}
