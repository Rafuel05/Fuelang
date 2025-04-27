@echo off
setlocal enabledelayedexpansion

REM Verifica argumentos
if [%1]==[] (
    echo Uso: %0 arquivo.fuel [-t^|-g^|-d]
    echo.
    echo Opcoes:
    echo   -t  Mostrar tokens
    echo   -g  Mostrar arvore grafica
    echo   -d  Gerar arquivo DOT
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

REM Compila gramática
echo === Compilando gramatica ===
java -cp "lib\antlr-4.13.1-complete.jar" org.antlr.v4.Tool -package grammar grammar\Fuelang.g4
javac -cp "lib\antlr-4.13.1-complete.jar" grammar\*.java

REM Define modo de execução
set modo=%2
if [%2]==[] set modo=all

REM Executa análise
if %modo%==all (
    echo === Tokens e AST ===
    java -cp "lib\antlr-4.13.1-complete.jar;." grammar.FuelangTokenizer %1
    echo === Visualizador ===
    start javaw -cp "lib\antlr-4.13.1-complete.jar;." org.antlr.v4.gui.TestRig grammar.Fuelang programa -gui %1
    echo === Gerando DOT ===
    java -cp "lib\antlr-4.13.1-complete.jar;." grammar.FuelangTokenizer %1 -dot
) else if %modo%==-t (
    java -cp "lib\antlr-4.13.1-complete.jar;." grammar.FuelangTokenizer %1
) else if %modo%==-g (
    start javaw -cp "lib\antlr-4.13.1-complete.jar;." org.antlr.v4.gui.TestRig grammar.Fuelang programa -gui %1
) else if %modo%==-d (
    java -cp "lib\antlr-4.13.1-complete.jar;." grammar.FuelangTokenizer %1 -dot
)
