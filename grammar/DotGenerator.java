package grammar;

import java.io.*;

public class DotGenerator {
    private int nodeCount = 0;
    private StringBuilder dotContent;

    public DotGenerator() {
        dotContent = new StringBuilder();
        dotContent.append("digraph AST {\n");
        dotContent.append("  node [shape=box];\n");
    }

    public String addNode(String label) {
        String nodeName = "node" + (++nodeCount);
        dotContent.append(String.format("  %s [label=\"%s\"];\n", 
            nodeName, label.replace("\"", "\\\"")));
        return nodeName;
    }

    public void addEdge(String fromNode, String toNode) {
        dotContent.append(String.format("  %s -> %s;\n", fromNode, toNode));
    }

    public void generateDotFile(String fileName) {
        dotContent.append("}\n");
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.print(dotContent.toString());
        } catch (IOException e) {
            System.err.println("Erro ao gerar arquivo DOT: " + e.getMessage());
        }
    }
}
