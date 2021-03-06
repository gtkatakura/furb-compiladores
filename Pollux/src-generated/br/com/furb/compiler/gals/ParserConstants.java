package br.com.furb.compiler.gals;

public interface ParserConstants
{
    int START_SYMBOL = 43;

    int FIRST_NON_TERMINAL    = 43;
    int FIRST_SEMANTIC_ACTION = 80;

    int[][] PARSER_TABLE =
    {
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1 },
        { -1, -1,  1, -1, -1, -1, -1, -1,  2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  3,  3,  3,  3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1,  4, -1,  5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  6,  6,  6,  6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 12, -1, 12, 11, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  7,  8,  9, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 21, 21, 21, 21, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 22, 22, 22, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 25, -1, -1, 26, -1, -1, 25, -1, -1, -1, -1, -1, -1, 25, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 27, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 28, 28, 28, 28, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 29, -1, -1, -1, -1, -1, 30, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 31, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 32, -1, -1, -1, 32, 32, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 32, 32, 32, 32, 32, 32, 32, -1, 32, -1, -1, -1, -1, -1, -1, 32, -1, -1, 32, -1 },
        { -1, 33, -1, -1, -1, -1, -1, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 35, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, 37, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, 39, 39, 39, -1, -1, -1, -1, -1, 39, 39, 38, -1, -1, -1, -1, -1, 39, -1, 39 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, 41, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 41, 41, 41, 41, -1, -1, -1, -1, -1, 41, 41, -1, 40, -1, -1, -1, -1, 41, -1, 41 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 42 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 44, 43, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 18, 18, 18, 18, -1, -1, -1, -1, -1, 19, 16, -1, -1, -1, -1, -1, -1, 17, -1, 20 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 13, 13, 13, 13, -1, -1, -1, -1, -1, 13, 13, -1, -1, -1, -1, -1, -1, 13, -1, 13 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 14, 14, 14, 14, -1, -1, -1, -1, -1, 14, 14, -1, -1, -1, -1, -1, -1, 14, -1, 14 },
        { -1, -1, -1, -1, -1, -1, 45, -1, -1, -1, 45, 45, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 45, 45, 45, 45, 45, 45, 45, -1, 45, -1, -1, -1, -1, -1, -1, 45, -1, -1, 45, -1 },
        { -1, 48, -1, 48, -1, 48, -1, 48, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 46, -1, -1, -1, -1, -1, -1, -1, -1, 47, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 49, -1, -1, -1, 49, 49, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 49, 49, 49, 49, 49, 49, 49, -1, 51, -1, -1, -1, -1, -1, -1, 52, -1, -1, 50, -1 },
        { -1, -1, -1, -1, -1, -1, 53, -1, -1, -1, 53, 53, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 53, 53, 53, 53, 53, 53, 53, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 55, -1, 55, -1, 55, -1, 55, -1, -1, -1, -1, -1, -1, -1, 54, 54, 54, 54, 54, 54, -1, -1, -1, -1, -1, -1, -1, -1, 55, -1, -1, -1, -1, -1, -1, -1, -1, 55, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 62, 62, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, 62, 62, 62, 62, 62, 62, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 65, -1, 65, -1, 65, -1, 65, -1, -1, 63, 64, -1, -1, -1, 65, 65, 65, 65, 65, 65, -1, -1, -1, -1, -1, -1, -1, -1, 65, -1, -1, -1, -1, -1, -1, -1, -1, 65, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 66, -1, -1, -1, 66, 66, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 66, 66, 66, 66, 66, 66, 66, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 69, -1, 69, -1, 69, -1, 69, -1, -1, 69, 69, 67, 68, -1, 69, 69, 69, 69, 69, 69, -1, -1, -1, -1, -1, -1, -1, -1, 69, -1, -1, -1, -1, -1, -1, -1, -1, 69, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 74, -1, -1, -1, 75, 76, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 70, 70, 70, 70, 71, 72, 73, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 23, -1, 23, 24, 23, -1, 23, -1, -1, 23, 23, 23, 23, -1, 23, 23, 23, 23, 23, 23, -1, -1, -1, -1, -1, -1, -1, -1, 23, -1, -1, -1, -1, -1, -1, -1, -1, 23, -1, -1, -1 }
    };

    int[][] PRODUCTIONS = 
    {
        {  92,  36,  37,  44,   9,  66,  10,  93 },
        {   3,  45,   4 },
        {   0 },
        {  47,  46 },
        {   2,  45 },
        {   0 },
        {  49, 101,  48, 102 },
        {  23 },
        {  24 },
        {  25 },
        {  26 },
        {   5,  27, 106,   6 },
        {   0 },
        {  65,  67 },
        {  66 },
        {   0 },
        {  53 },
        {  56 },
        {  50 },
        {  59 },
        {  63 },
        {  51,  15,  68, 105,   4 },
        {  49, 101,  52 },
        {   0 },
        { 107,   5,  68,   6 },
        {   0 },
        { 107,   5,  68,   6 },
        {  33,   7,  54,   8,   4 },
        {  51, 103,  55 },
        {   2,  54 },
        {   0 },
        {  40,   7,  57,   8,   4 },
        {  68,  91,  58 },
        {   2,  57 },
        {   0 },
        {  32,   7,  68,   8,  60 },
        {  34, 108,   3,   9,  66,  10,  62, 109 },
        {  35, 108,   3,   9,  66,  10,  61, 109 },
        {  34, 110,   3,   9,  66,  10 },
        {   0 },
        {  35, 110,   3,   9,  66,  10 },
        {   0 },
        { 111,  42,   7,  68,   8,  64 },
        {  35, 112,   3,   9,  66, 113,  10 },
        {  34, 112,   3,   9,  66, 113,  10 },
        {  70,  69 },
        {  30,  70,  94,  69 },
        {  39,  70,  95,  69 },
        {   0 },
        {  71 },
        {  41,  96 },
        {  31,  97 },
        {  38,  70,  98 },
        {  74,  72 },
        {  73,  90,  74,  89 },
        {   0 },
        {  16 },
        {  17 },
        {  18 },
        {  19 },
        {  20 },
        {  21 },
        {  76,  75 },
        {  11,  76,  81,  75 },
        {  12,  76,  82,  75 },
        {   0 },
        {  78,  77 },
        {  13,  78,  83,  77 },
        {  14,  78,  84,  77 },
        {   0 },
        {  49, 101,  79, 104 },
        {  27,  85 },
        {  28,  86 },
        {  29,  99 },
        {   7,  68,   8 },
        {  11,  78,  87 },
        {  12,  78,  88 }
    };
    
    String[] PARSER_ERROR =
        {
            "",
            "esperado fim de programa", // "Era esperado fim de programa",
            "esperado ,", // "Era esperado \",\"",
            "esperado :", // "Era esperado \":\"",
            "esperado ;", // "Era esperado \";\"",
            "esperado [", // "Era esperado \"[\"",
            "esperado ]", // "Era esperado \"]\"",
            "esperado (", // "Era esperado \"(\"",
            "esperado )", // "Era esperado \")\"",
            "esperado {", // "Era esperado \"{\"",
            "esperado }", // "Era esperado \"}\"",
            "esperado +", // "Era esperado \"+\"",
            "esperado -", // "Era esperado \"-\"",
            "esperado *", // "Era esperado \"*\"",
            "esperado /", // "Era esperado \"/\"",
            "esperado <-", // "Era esperado \"<-\"",
            "esperado =", // "Era esperado \"=\"",
            "esperado !=", // "Era esperado \"!=\"",
            "esperado <", // "Era esperado \"<\"",
            "esperado <=", // "Era esperado \"<=\"",
            "esperado >", // "Era esperado \">\"",
            "esperado >=", // "Era esperado \">=\"",
            "esperado palavra reservada", // "Era esperado palavra_reservada",
            "esperado identificador", // "Era esperado identificador_de_int",
            "esperado identificador", // "Era esperado identificador_de_float",
            "esperado identificador", // "Era esperado identificador_de_string",
            "esperado identificador", // "Era esperado identificador_de_bool",
            "esperado constante int", // "Era esperado constante_int",
            "esperado constante float", // "Era esperado constante_float",
            "esperado constante string", // "Era esperado constante_string",
            "esperado and", // "Era esperado and",
            "esperado false", // "Era esperado false",
            "esperado if", // "Era esperado if",
            "esperado in", // "Era esperado in",
            "esperado isFalseDo", // "Era esperado isFalseDo",
            "esperado isTrueDo", // "Era esperado isTrueDo",
            "esperado main", // "Era esperado main",
            "esperado module", // "Era esperado module",
            "esperado not", // "Era esperado not",
            "esperado or", // "Era esperado or",
            "esperado out", // "Era esperado out",
            "esperado true", // "Era esperado true",
            "esperado while", // "Era esperado while",
            "esperado main", // "<programa> inv�lido",
            "esperado : {", // "<variaveis> inv�lido",
            "esperado identificador", // "<lista_de_variaveis> inv�lido",
            "esperado , ;", // "<lista_de_variaveis2> inv�lido",
            "esperado identificador", // "<identificador> inv�lido",
            "esperado , ; [", //"<identificador2> inv�lido",
            "esperado identificador", // "<tipos_de_identificador> inv�lido",
            "esperado identificador", // "<atribuicao> inv�lido",
            "esperado identificador", // "<identificador_para_expressao> inv�lido",
            "esperado , [ ) <-", // "<identificador_para_expressao2> inv�lido",
            "esperado in ", // "<entrada_de_dados> inv�lido",
            "esperado identificador", // "<lista_de_identificadores> inv�lido",
            "esperado , )", // "<lista_de_identificadores2> inv�lido",
            "esperado out", // "<saida_de_dados> inv�lido",
            "esperada express�o", // "<lista_de_expressoes> inv�lido",
            "esperado , )", // "<lista_de_expressoes2> inv�lido",
            "esperado if", // "<comando_de_selecao> inv�lido",
            "esperado isFalseDo isTrueDo", // "<comando_de_selecao2> inv�lido",
            "esperado } comando isFalseDo", // "<fluxo_false_do> inv�lido",
            "esperado } comando isTrueDo", // "<fluxo_true_do> inv�lido",
            "esperado while", // "<comando_de_repeticao> inv�lido",
            "esperado isFalseDo isTrueDo", // "<comando_de_repeticao2> inv�lido",
            "esperado comando", // "<comando> inv�lido",
            "esperado comando", // "<lista_de_comandos> inv�lido",
            "esperado } comando", // "<lista_de_comandos2> inv�lido",
            "esperada express�o", // "<expressao> inv�lido",
            "esperada express�o", // "<expressao2> inv�lido",
            "esperada express�o", // "<elemento> inv�lido",
            "esperada express�o", // "<relacional> inv�lido",
            "esperada express�o", // "<relacional2> inv�lido",
            "esperada express�o", // "<operador_relacional> inv�lido",
            "esperada express�o", // "<aritmetica> inv�lido",
            "esperada express�o", // "<aritmetica2> inv�lido",
            "esperada express�o", // "<termo> inv�lido",
            "esperada express�o", // "<termo2> inv�lido",
            "esperada express�o", // "<fator> inv�lido",
            "esperada , ; [ ] ) operador bin�rio (aritm�tico, l�gico, relacional)" // "<vetor_uso> inv�lido"
        };
}
