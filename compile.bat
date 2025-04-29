@echo off
echo === Compilando gramatica ===
java -cp "lib\antlr-4.13.1-complete.jar" org.antlr.v4.Tool -package grammar grammar\Fuelang.g4
echo === Compilando java ===
javac -cp "lib\antlr-4.13.1-complete.jar" grammar\*.java
echo === Compilacao concluida ===
