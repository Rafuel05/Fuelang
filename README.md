# Fuelang

Fuelang é uma linguagem de programação simples e intuitiva desenvolvida para fins educacionais para a materia de Compiladores. Ela oferece suporte a operações básicas, estruturas de controle e entrada/saída de dados.

## Características

### Tipos de Dados
- `inteiro`: Números inteiros e decimais
- `texto`: Strings delimitadas por aspas duplas

### Operadores

#### Aritméticos
- `+` : Adição
- `-` : Subtração
- `*` : Multiplicação
- `/` : Divisão

#### Lógicos
- `&&` : AND lógico
- `||` : OR lógico
- `!` : NOT lógico
- `==` : Igualdade
- `!=` : Diferença
- `<` : Menor que
- `>` : Maior que
- `<=` : Menor ou igual
- `>=` : Maior ou igual

### Estruturas de Controle

#### Condicional
```
se <condição> entao {
    // código
} senao {
    // código
}
```

#### Repetição
```
enquanto <condição> faca {
    // código
}
```

### Entrada e Saída
- `leia(variavel)`: Lê um valor do usuário
- `escreva(expressao)`: Exibe um valor na tela

### Declaração de Variáveis
```
inteiro numero = 42;
texto mensagem = "Olá, mundo!";
```

## Exemplos

### Exemplo 1: Triângulo de Pascal
```
inteiro n = 0;
escreva("Digite o número de linhas: ");
leia(n);

se n <= 0 entao {
    escreva("Erro: número deve ser maior que zero!");
} senao {
    inteiro linha = 1;
    enquanto linha <= n faca {
        inteiro coluna = 1;
        enquanto coluna <= linha faca {
            coluna = coluna + 1;
        }
        linha = linha + 1;
    }
}
```

## Como Usar

### Requisitos
- Java JDK 8 ou superior
- ANTLR 4.13.1

### Estrutura de Diretórios
```
Fuelang/
├── grammar/                 # Arquivos da gramática e analisadores
├── lib/                     # Bibliotecas (ANTLR)
├── test/
│   └── examples/           # Exemplos de programas .fuel
├── analyze.bat             # Script principal
├── visualize_tree.bat      # Visualizador de AST
└── run_tokenizer.bat       # Analisador léxico
```

### Executando um Programa

1. **Análise Completa**
   ```batch
   analyze.bat caminho/do/arquivo.fuel
   ```
   Este comando realiza:
   - Análise léxica (tokens)
   - Análise sintática (AST)
   - Geração do arquivo DOT para visualização
   - Exibição da árvore no visualizador gráfico

2. **Apenas Tokens**
   ```batch
   analyze.bat caminho/do/arquivo.fuel -t
   ```
   Mostra apenas os tokens gerados pelo analisador léxico.

3. **Apenas Visualizador**
   ```batch
   analyze.bat caminho/do/arquivo.fuel -g
   ```
   Abre apenas o visualizador gráfico da AST.

4. **Apenas DOT**
   ```batch
   analyze.bat caminho/do/arquivo.fuel -d
   ```
   Gera apenas o arquivo DOT da AST.

### Tratamento de Erros

1. **Erros Léxicos**
   ```
   ERRO LÉXICO [Linha X, Coluna Y]: Símbolo 'Z' inválido
   ```

2. **Erros Sintáticos**
   ```
   ERRO SINTÁTICO [Linha X, Coluna Y]: Esperado 'Z', encontrado 'W'
   ```

## Desenvolvimento

O projeto usa ANTLR4 para geração do analisador léxico e sintático. A gramática está definida em `grammar/Fuelang.g4`.

### Regenerando os Analisadores
```batch
java -cp "lib\antlr-4.13.1-complete.jar" org.antlr.v4.Tool -package grammar grammar\Fuelang.g4
javac -cp "lib\antlr-4.13.1-complete.jar" grammar\*.java
```


## Autores

- Rafael Melchior de Oliveira
- Arthur Octavio de Oliveira Confessor

