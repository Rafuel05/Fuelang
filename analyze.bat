@echo off
setlocal enabledelayedexpansion

REM Verifica argumentos
if [%1]==[] (
    echo Uso: %0 arquivo.fuel [-t^|-g^|-d^|-tac^|-llvm]
    echo.
    echo Opcoes:
    echo   -t    Mostrar tokens
    echo   -g    Mostrar arvore grafica
    echo   -d    Gerar arquivo DOT
    echo   -tac  Gerar codigo TAC
    echo   -llvm Gerar codigo LLVM IR
    echo.
    exit /b 1
)

REM Verifica se arquivo existe
if not exist %1 (
    echo Erro: Arquivo %1 nao encontrado
    exit /b 1
)

REM Limpa arquivos anteriores
del /Q grammar\*.class 2>nul
del /Q grammar\*.interp 2>nul
del /Q grammar\*.tokens 2>nul
del /Q grammar\semantics\*.class 2>nul
del /Q grammar\tac\*.class 2>nul
del /Q grammar\llvm\*.class 2>nul

REM Compila gramática
echo === Compilando gramatica ===
cd grammar
java -jar ..\lib\antlr-4.13.1-complete.jar -visitor -package grammar Fuelang.g4
cd ..

REM Compila todos os arquivos Java
javac -cp "lib/*" ^
    grammar\CompilerLogger.java ^
    grammar\LexicalError.java ^
    grammar\SyntaxError.java ^
    grammar\DotGenerator.java ^
    grammar\semantics\SemanticError.java ^
    grammar\semantics\Type.java ^
    grammar\semantics\VariableInfo.java ^
    grammar\FuelangLexer.java ^
    grammar\FuelangParser.java ^
    grammar\FuelangListener.java ^
    grammar\FuelangBaseListener.java ^
    grammar\FuelangVisitor.java ^
    grammar\FuelangBaseVisitor.java ^
    grammar\semantics\SemanticAnalyzer.java ^
    grammar\tac\TACOperand.java ^
    grammar\tac\TACInstruction.java ^
    grammar\tac\GeradorTAC.java ^
    grammar\llvm\GeradorLLVM.java ^
    grammar\FuelangTokenizer.java

REM Define modo de execução
set modo=%2
if [%2]==[] set modo=all

REM Executa análise
if %modo%==all (
    echo === Tokens e AST ===
    java -cp "lib/*;." grammar.FuelangTokenizer %1
    echo === Visualizador ===
    start javaw -cp "lib/*;." org.antlr.v4.gui.TestRig grammar.Fuelang program -gui %1
    echo === Gerando DOT ===
    java -cp "lib/*;." grammar.FuelangTokenizer %1 -dot
) else if %modo%==-t (
    java -cp "lib/*;." grammar.FuelangTokenizer %1
) else if %modo%==-g (
    start javaw -cp "lib/*;." org.antlr.v4.gui.TestRig grammar.Fuelang program -gui %1
) else if %modo%==-d (
    java -cp "lib/*;." grammar.FuelangTokenizer %1 -dot
) else if %modo%==-tac (
    echo === Gerando codigo TAC ===
    java -cp "lib/*;." grammar.FuelangTokenizer %1 -tac
) else if %modo%==-llvm (
    echo === Gerando codigo LLVM IR ===
    java -cp "lib/*;." grammar.FuelangTokenizer %1 -llvm
)