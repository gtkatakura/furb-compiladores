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
ldstr "Exemplo 2: Operacoes relacionais entre dois numeros inteiros"
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
ldstr " = "
call void [mscorlib]System.Console::Write(string)
ldloc i_valor2
call void [mscorlib]System.Console::Write(int64)
ldstr " = "
call void [mscorlib]System.Console::Write(string)
ldloc i_valor1
ldloc i_valor2
ceq
call void [mscorlib]System.Console::Write(bool)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldloc i_valor1
call void [mscorlib]System.Console::Write(int64)
ldstr " != "
call void [mscorlib]System.Console::Write(string)
ldloc i_valor2
call void [mscorlib]System.Console::Write(int64)
ldstr " = "
call void [mscorlib]System.Console::Write(string)
ldloc i_valor1
ldloc i_valor2
ceq
ldc.i4.1
xor
call void [mscorlib]System.Console::Write(bool)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldloc i_valor1
call void [mscorlib]System.Console::Write(int64)
ldstr " > "
call void [mscorlib]System.Console::Write(string)
ldloc i_valor2
call void [mscorlib]System.Console::Write(int64)
ldstr " = "
call void [mscorlib]System.Console::Write(string)
ldloc i_valor1
ldloc i_valor2
cgt
call void [mscorlib]System.Console::Write(bool)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldloc i_valor1
call void [mscorlib]System.Console::Write(int64)
ldstr " >= "
call void [mscorlib]System.Console::Write(string)
ldloc i_valor2
call void [mscorlib]System.Console::Write(int64)
ldstr " = "
call void [mscorlib]System.Console::Write(string)
ldloc i_valor1
ldloc i_valor2
clt
ldc.i4.1
xor
call void [mscorlib]System.Console::Write(bool)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldloc i_valor1
call void [mscorlib]System.Console::Write(int64)
ldstr " < "
call void [mscorlib]System.Console::Write(string)
ldloc i_valor2
call void [mscorlib]System.Console::Write(int64)
ldstr " = "
call void [mscorlib]System.Console::Write(string)
ldloc i_valor1
ldloc i_valor2
clt
call void [mscorlib]System.Console::Write(bool)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldloc i_valor1
call void [mscorlib]System.Console::Write(int64)
ldstr " <= "
call void [mscorlib]System.Console::Write(string)
ldloc i_valor2
call void [mscorlib]System.Console::Write(int64)
ldstr " = "
call void [mscorlib]System.Console::Write(string)
ldloc i_valor1
ldloc i_valor2
cgt
ldc.i4.1
xor
call void [mscorlib]System.Console::Write(bool)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldstr "EXEMPLO 2 EXECUCAO CONCLUIDA COM SUCESSO!"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ret
}
}