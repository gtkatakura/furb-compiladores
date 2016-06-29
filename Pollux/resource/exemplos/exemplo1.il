.assembly extern mscorlib {}
.assembly codigo_objeto {}
.module codigo_objeto.exe
.class public _Principal {
.method static public void _principal() {
.entrypoint
.locals (int64 i_valor1)
.locals (int64 i_valor2)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldstr "Exemplo 1: Operações aritmeticas entre dois numeros inteiros"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldstr "Informe um valor inteiro :"
call void [mscorlib]System.Console::Write(string)
call string [mscorlib]System.Console::ReadLine()
call int64 [mscorlib]System.Int64::Parse(string)
stloc i_valor1
ldstr "Informe outro valor inteiro :"
call void [mscorlib]System.Console::Write(string)
call string [mscorlib]System.Console::ReadLine()
call int64 [mscorlib]System.Int64::Parse(string)
stloc i_valor2
ldloc i_valor1
call void [mscorlib]System.Console::Write(int64)
ldstr " + "
call void [mscorlib]System.Console::Write(string)
ldloc i_valor2
call void [mscorlib]System.Console::Write(int64)
ldstr " = "
call void [mscorlib]System.Console::Write(string)
ldloc i_valor1
ldloc i_valor2
add
call void [mscorlib]System.Console::Write(int64)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldloc i_valor1
call void [mscorlib]System.Console::Write(int64)
ldstr " - "
call void [mscorlib]System.Console::Write(string)
ldloc i_valor2
call void [mscorlib]System.Console::Write(int64)
ldstr " = "
call void [mscorlib]System.Console::Write(string)
ldloc i_valor1
ldloc i_valor2
sub
call void [mscorlib]System.Console::Write(int64)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldloc i_valor1
call void [mscorlib]System.Console::Write(int64)
ldstr " * "
call void [mscorlib]System.Console::Write(string)
ldloc i_valor2
call void [mscorlib]System.Console::Write(int64)
ldstr " = "
call void [mscorlib]System.Console::Write(string)
ldloc i_valor1
ldloc i_valor2
mul
call void [mscorlib]System.Console::Write(int64)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldloc i_valor2
ldc.i8 0
ceq
brtrue R0
ldloc i_valor1
call void [mscorlib]System.Console::Write(int64)
ldstr " / "
call void [mscorlib]System.Console::Write(string)
ldloc i_valor2
call void [mscorlib]System.Console::Write(int64)
ldstr " = "
call void [mscorlib]System.Console::Write(string)
ldloc i_valor1
ldloc i_valor2
div
call void [mscorlib]System.Console::Write(float64)
br R1
R0:
ldstr "Divisor zero, desconsiderado"
call void [mscorlib]System.Console::Write(string)
R1:
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldstr "EXEMPLO 1 EXECUCAO CONCLUIDA COM SUCESSO!"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ret
}
}