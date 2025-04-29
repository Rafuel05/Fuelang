# Fuelang

Fuelang é uma linguagem de programação simples e intuitiva desenvolvida para fins educacionais para a materia de Compiladores. Ela oferece suporte a operações básicas, estruturas de controle e entrada/saída de dados.

## Características

### Tipos de Dados
- `integer`: Números inteiros e decimais
- `text`: Strings delimitadas por aspas duplas

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
if <condição> then {
    // código
} else {
    // código
}
```

#### Repetição
```
while <condição> do {
    // código
}
```

### Entrada e Saída
- `get(variavel)`: Lê um valor do usuário
- `put(expressao)`: Exibe um valor na tela

### Declaração de Variáveis
```
integer numero = 42;
text mensagem = "Olá, mundo!";
```

## Exemplos

### Exemplo 1: Triângulo de Pascal
```
integer n = 0;
put("Digite o número de linhas: ");
get(n);

if n <= 0 then {
    put("Erro: número deve ser maior que zero!");
} else {
    integer linha = 1;
    while linha <= n do {
        integer coluna = 1;
        while coluna <= linha do {
            put("*");
            coluna = coluna + 1;
        }
        put("\n");
        linha = linha + 1;
    }
}
```
### Exemplo 2: Classificação de triangulos
```
integer a = 0;
integer b = 0;
integer c = 0;

put("Digite os três lados do triângulo:");
get(a);
get(b);
get(c);

if (a <= 0) || (b <= 0) || (c <= 0) then {
    put("Erro: os lados devem ser positivos!");
} else {
    if (a + b <= c) || (b + c <= a) || (a + c <= b) then {
        put("Não forma um triângulo!");
    } else {
        if (a == b) && (b == c) then {
            put("Triângulo Equilátero");
        } else {
            if (a == b) || (b == c) || (a == c) then {
                put("Triângulo Isósceles");
            } else {
                put("Triângulo Escaleno");
            }
        }
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
- Arthur Octavio Oliveira Confessor

