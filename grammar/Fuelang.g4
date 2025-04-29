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
        
        String expected = msg.contains("expecting") 
            ? msg.substring(msg.indexOf("expecting") + 10)
            : "outro token";
            
        throw new SyntaxError(line, column, expected, tokenText);
    }
}

// Program structure
program: declarations EOF;

// Declarations
declarations: declaration*;

declaration
    : variableDeclaration
    | command
    ;

// Types and variables
variableDeclaration: TYPE ID ASSIGN expression SEMICOLON;
TYPE: 'integer' | 'text';

// Commands
command
    : inputCommand
    | outputCommand
    | ifCommand
    | whileCommand
    | assignment
    ;

inputCommand: GET LPAREN ID RPAREN SEMICOLON;
outputCommand: PUT LPAREN expression RPAREN SEMICOLON;
assignment: ID ASSIGN expression SEMICOLON;

// Control structures
ifCommand
    : IF expression THEN block
      (ELSE block)?
    ;

whileCommand
    : WHILE expression DO block
    ;

block: LBRACE declarations RBRACE;

// Expressions
expression
    : logicalExpression
    | arithmeticExpression
    | STRING
    ;

arithmeticExpression
    : term (arithmeticOperator term)*
    ;

term
    : factor (termOperator factor)*
    ;

arithmeticOperator: PLUS | MINUS;
termOperator: MULT | DIV;

factor
    : LPAREN arithmeticExpression RPAREN
    | NUMBER
    | ID
    ;

logicalExpression
    : logicalTerm (OR logicalTerm)*
    ;

logicalTerm
    : logicalFactor (AND logicalFactor)*
    ;

logicalFactor
    : NOT logicalFactor
    | LPAREN logicalExpression RPAREN
    | comparison
    ;

comparison
    : arithmeticExpression comparisonOperator arithmeticExpression
    ;

comparisonOperator
    : EQUALS
    | NOT_EQUALS
    | LESS_EQUALS
    | GREATER_EQUALS
    | LESS
    | GREATER
    ;

// Keywords
IF: 'if';
THEN: 'then';
ELSE: 'else';
WHILE: 'while';
DO: 'do';
GET: 'get';
PUT: 'put';

// Operators
EQUALS: '==';
NOT_EQUALS: '!=';
LESS: '<';
GREATER: '>';
LESS_EQUALS: '<=';
GREATER_EQUALS: '>=';
PLUS: '+';
MINUS: '-';
MULT: '*';
DIV: '/';
AND: '&&';
OR: '||';
NOT: '!';
ASSIGN: '=';

// Delimiters
LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
SEMICOLON: ';';

// Literals
ID: [a-zA-Z][a-zA-Z0-9_]*;
NUMBER: [0-9]+('.'[0-9]+)?;
STRING: '"' (~["\r\n])* '"';

// Skip whitespace and comments
WS: [ \t\r\n]+ -> skip;
COMMENT: '//' ~[\r\n]* -> skip;

// Lexical error handling
ErrorChar: . {reportLexicalError();};