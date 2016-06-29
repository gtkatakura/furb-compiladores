.assembly extern mscorlib {}
.assembly codigo_objeto {}
.module codigo_objeto.exe
.class public _Principal {
.method static public void _principal() {
.entrypoint
.locals (int64 i_valor1)
.locals (float64 f_valor2)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldstr "Exemplo 4: Teste com multiplos comandos de seleção"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldc.i4.1
brfalse R0
ldstr "Entrou no fluxo isTrueDo com constante true"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
R0:
ldc.i4.0
brfalse R1
ldstr "Entrou no fluxo isTrueDo com constante true ?"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
br R2
R1:
ldstr "Entrou no fluxo isFalseDo com constante false (else)"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
R2:
ldc.i4.0
brtrue R3
ldstr "Entrou no fluxo isFalseDo com constante false"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
R3:
ldc.i4.1
brtrue R4
ldstr "Entrou no fluxo isFalseDo com constante true ?"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
br R5
R4:
ldstr "Entrou no fluxo isTrueDo com constante true (else)"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
R5:
ldc.i4.1
brfalse R6
ldstr "Entrou no fluxo isTrueDo 1"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldc.i4.1
brfalse R7
ldstr "Entrou no fluxo isTrueDo 1-1"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldc.i4.1
brfalse R8
ldstr "Entrou no fluxo isTrueDo 1-1-1"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldc.i4.0
brfalse R9
ldstr "Entrou no fluxo isTrueDo 1-1-1?"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
br R10
R9:
ldstr "Entrou no fluxo isFalseDo 1-1-1-1"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
R10:
R8:
R7:
br R11
R6:
ldstr "Entrou no fluxo isFalseDo?"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
R11:
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldstr "EXEMPLO 4 EXECUCAO CONCLUIDA COM SUCESSO!"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ret
}
}