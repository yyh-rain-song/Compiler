grammar M_;

start : program_unit*;

program_unit : variable_defination ';'| function_defination | class_defination ;

variable_defination : class_type variable_name ('=' init_expr)?;

init_expr : statement;

malloc : NEW type (('['statement']')*('['empty']')* | '(' ')');

empty : ;

variable_name : ID;

class_type :
    class_type '[' ']'
    | type
    ;

type : INT          #int
    | STRING        #string
    | BOOL          #bool
    | VOID          #void
    | variable_name #others
    ;//which means self-define type

class_defination : CLASS ID '{'((variable_defination ';')|class_function_defination)* '}';//not complete

class_function_defination : class_init_fun | function_defination;

class_init_fun : func_name '(' ')' block;

function_defination : class_type func_name '(' parameters? ')' block;

func_name : ID;

parameters : (parameter) (','parameter)*;

parameter : class_type ID;// not support initial list in function

block : '{' sentence* '}';

sentence : declation | expression;

declation : variable_defination ';';

expression :  BREAK ';' | CONTINUE ';' | expr_statement | if_else | while_stm | for_stm | return_stm | block | emptye;

emptye : ';';

expr_statement : statement ';';

statement : statement op=('++'|'--')        #postfix
            | function_call                 #func_call
            | statement '[' statement ']'   #index
            | statement '.' ID              #class_member
            | statement '.' function_call   #class_func
            | op=('++'|'--') statement      #prefix
            | op=('+'|'-') statement        #pos_neg
            | '~' statement                 #bitnot
            | '!' statement                 #logicalnot
            | malloc                        #new_st
            | statement op=('*'|'/'|'%') statement          #mul
            | statement op=('+'|'-') statement              #add
            | statement op=('<<'|'>>') statement            #bitshift
            | statement op=('<'|'<='|'>'|'>=') statement    #compare
            | statement op=('=='|'!=') statement            #equal
            | statement '&'statement                   #bitand
            | statement '^' statement                  #bitxor
            | statement '|' statement                  #bitor
            | statement op=('&&'|'||')statement             #logical
            | const_                        #constant
            | THIS                          #this_
            | ID                            #variable
            | '(' statement ')'             #blanket
            | statement '=' statement       #assign
            ;


function_call : ID '('
                ( statement?
                | statement(','statement)+)
                ')';

const_ : STRING_CONST #string_const
        | INTEGER  #integer
        | TRUE #true
        | FALSE #false
        | NULL #null
        ;

if_else : IF '('statement')' expression (ELSE expression)?;

while_stm : WHILE '('statement')' expression;

for_stm : FOR '('init? ';' termanite? ';' update?')' expression;

init : statement;
update : statement;
termanite: statement;

return_stm : RETURN (statement)? ';';
//key words
BOOL : 'bool';
INT :  'int';
STRING : 'string';
NULL : 'null';
VOID : 'void';
TRUE : 'true';
FALSE : 'false';
IF : 'if';
ELSE : 'else';
FOR : 'for';
WHILE : 'while';
BREAK : 'break';
CONTINUE : 'continue';
RETURN : 'return';
NEW : 'new';
CLASS : 'class';
THIS : 'this';

fragment
LETTER : [a-zA-Z];
ID : LETTER (LETTER | [0-9] | '_')*;
INTEGER : '0' | [1-9] [0-9]*;
STRING_CONST : '"' (ESC | .)*? '"';
fragment ESC : '\\' [btnr"\\]; // \b \t \n \r \\ \"
WS : [ \t\n\r]+ -> skip;
LINE_COMMENT : '//' .*? '\n' -> skip;
COMMENT : '/*' .*? '*/' -> skip;