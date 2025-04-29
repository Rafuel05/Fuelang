grammar Fuelang;
options {
    language=Java;
}

@lexer::members {
    private void reportLexicalError() {
        throw new LexicalError(getLine(), getCharPositionInLine(), getText());
    }
}

@parser::members {
    @Override
    public void notifyErrorListeners(Token offendingToken, String msg, RecognitionException e) {
        int line = offendingToken.getLine();
        int column = offendingToken.getCharPositionInLine();
        String tokenText = offendingToken.getText();
        
        // Extrair o token esperado da mensagem de erro
        String expected = msg.contains("expecting") 
            ? msg.substring(msg.indexOf("expecting") + 10)
            : "outro token";
            
        throw new SyntaxError(line, column, expected, tokenText);
    }
}


// Programa é uma sequência de declarações
programa: declaracoes EOF;

// Declarações
declaracoes: declaracao*;

declaracao
    : declaracaoVariavel
    | comando
    ;

// Tipos e variáveis
declaracaoVariavel: TIPO ID IGUAL expressao PONTO_VIRGULA;
TIPO: 'inteiro' | 'texto';

// Comandos
comando
    : comandoEntrada
    | comandoSaida
    | comandoIf
    | comandoWhile
    | atribuicao
    ;

comandoEntrada: LEIA ABRE_PAR ID FECHA_PAR PONTO_VIRGULA;
comandoSaida: ESCREVA ABRE_PAR expressao FECHA_PAR PONTO_VIRGULA;
atribuicao: ID IGUAL expressao PONTO_VIRGULA;

// Estruturas de controle
comandoIf
    : SE expressaoLogica ENTAO bloco
      (SENAO bloco)?
    ;

comandoWhile
    : ENQUANTO expressaoLogica FACA bloco
    ;

bloco: ABRE_CHAVE declaracoes FECHA_CHAVE;

// Expressões
expressao
    : expressaoLogica
    | expressaoAritmetica
    | STRING
    ;

expressaoAritmetica
    : termo (operadorAritmetico termo)*
    ;

termo
    : fator (operadorTermo fator)*
    ;

operadorAritmetico: MAIS | MENOS;
operadorTermo: MULT | DIV;

fator
    : ABRE_PAR expressaoAritmetica FECHA_PAR
    | NUMERO
    | ID
    ;

expressaoLogica
    : termoLogico (OP_OU termoLogico)*
    ;

termoLogico
    : fatorLogico (OP_E fatorLogico)*
    ;

fatorLogico
    : OP_NAO fatorLogico
    | ABRE_PAR expressaoLogica FECHA_PAR
    | comparacao
    ;

comparacao
    : expressaoAritmetica operadorComp expressaoAritmetica
    ;

operadorComp
    : OP_IGUAL
    | OP_DIF
    | OP_MENOR_IGUAL
    | OP_MAIOR_IGUAL
    | OP_MENOR
    | OP_MAIOR
    ;

// Tokens
SE: 'se';
ENTAO: 'entao';
SENAO: 'senao';
ENQUANTO: 'enquanto';
FACA: 'faca';
LEIA: 'leia';
ESCREVA: 'escreva';

IGUAL: '=';
MAIS: '+';
MENOS: '-';
MULT: '*';
DIV: '/';
OP_E: '&&';
OP_OU: '||';
OP_NAO: '!';
OP_IGUAL: '==';
OP_DIF: '!=';
OP_MENOR: '<';
OP_MAIOR: '>';
OP_MENOR_IGUAL: '<=';
OP_MAIOR_IGUAL: '>=';

ABRE_PAR: '(';
FECHA_PAR: ')';
ABRE_CHAVE: '{';
FECHA_CHAVE: '}';
PONTO_VIRGULA: ';';

ID: [a-zA-Z][a-zA-Z0-9_]*;
NUMERO: [0-9]+('.'[0-9]+)?;
STRING: '"' (~["\r\n])* '"';

// Ignorar espaços em branco e comentários
WS: [ \t\r\n]+ -> skip;
COMENTARIO: '//' ~[\r\n]* -> skip;

// Tratamento de erros léxicos
ErrorChar: . {reportLexicalError();};

