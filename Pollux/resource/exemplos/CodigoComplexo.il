.assembly extern mscorlib {}
.assembly codigo_objeto {}
.module codigo_objeto.exe
.class public _Principal {
.method static public void _principal() {
.entrypoint
.locals (int64 i_var1)
.locals (int64 i_var2)
.locals (bool b_var1)
.locals (string s_msg)
.locals (float64 f_var1)
.locals (int64 i_sum)
.locals (int64 i_qtd)
.locals (bool b_parar)
ldc.i8 0
stloc i_sum
ldc.i8 0
stloc i_qtd
call string [mscorlib]System.Console::ReadLine()
call int64 [mscorlib]System.Int64::Parse(string)
stloc i_var1
call string [mscorlib]System.Console::ReadLine()
call int64 [mscorlib]System.Int64::Parse(string)
stloc i_var2
ldc.i4.0
stloc b_var1
ldc.i4.0
stloc b_parar
ldstr "Mensagem padrao"
stloc s_msg
ldloc i_var1
ldloc i_var2
div
stloc f_var1
R0:
ldloc i_var1
ldc.i8 2
mul
ldloc i_var2
cgt
ldloc b_parar
ldc.i4.1
xor
and
brfalse R1
ldloc i_qtd
ldc.i8 100
cgt
brfalse R2
ldc.i4.1
stloc b_parar
R2:
ldstr "valor da variavel i_sum eh "
call void [mscorlib]System.Console::Write(string)
ldloc i_sum
call void [mscorlib]System.Console::Write(int64)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldstr "valor da variavel i_qtd eh "
call void [mscorlib]System.Console::Write(string)
ldloc i_qtd
call void [mscorlib]System.Console::Write(int64)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldstr "valor da variavel i_var1 eh  "
call void [mscorlib]System.Console::Write(string)
ldloc i_var1
call void [mscorlib]System.Console::Write(int64)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldstr "valor da variavel i_var2 eh "
call void [mscorlib]System.Console::Write(string)
ldloc i_var2
call void [mscorlib]System.Console::Write(int64)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldstr "valor da variavel b_var1 eh "
call void [mscorlib]System.Console::Write(string)
ldloc b_var1
call void [mscorlib]System.Console::Write(bool)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldstr "valor da variavel s_msg eh '"
call void [mscorlib]System.Console::Write(string)
ldloc s_msg
call void [mscorlib]System.Console::Write(string)
ldstr "'"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldloc b_var1
brfalse R3
ldstr "Entrou no IF do B_VAR1"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldstr "A variavel i_var1 tem o valor: "
call void [mscorlib]System.Console::Write(string)
ldloc i_var1
call void [mscorlib]System.Console::Write(int64)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldstr "A variavel i_var2 tem o valor: "
call void [mscorlib]System.Console::Write(string)
ldloc i_var2
call void [mscorlib]System.Console::Write(int64)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldstr "A mehdia entre i_var1 e i_var2 eh "
call void [mscorlib]System.Console::Write(string)
ldloc i_var1
ldloc i_var2
add
ldc.i8 2
div
call void [mscorlib]System.Console::Write(float64)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldstr "O total atual eh de "
call void [mscorlib]System.Console::Write(string)
ldloc i_sum
call void [mscorlib]System.Console::Write(int64)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldloc i_var1
ldc.i8 5
mul
ldloc i_var2
ldc.i8 4
mul
cgt
brfalse R4
ldloc i_var1
call void [mscorlib]System.Console::Write(int64)
ldstr " * 5 ("
call void [mscorlib]System.Console::Write(string)
ldloc i_var1
ldc.i8 5
mul
call void [mscorlib]System.Console::Write(int64)
ldstr ") eh maior que "
call void [mscorlib]System.Console::Write(string)
ldloc i_var2
call void [mscorlib]System.Console::Write(int64)
ldstr " * 4 ("
call void [mscorlib]System.Console::Write(string)
ldloc i_var2
ldc.i8 4
mul
call void [mscorlib]System.Console::Write(int64)
ldstr ")"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldstr "Alterado B_VAR1 para FALSO"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldc.i4.0
stloc b_var1
ldstr "ENTROU NO ISTRUEDO DA CONDICAO INTERNA"
stloc s_msg
br R5
R4:
ldloc i_var1
call void [mscorlib]System.Console::Write(int64)
ldstr " * 5 ("
call void [mscorlib]System.Console::Write(string)
ldloc i_var1
ldc.i8 5
mul
call void [mscorlib]System.Console::Write(int64)
ldstr ") nao eh maior que "
call void [mscorlib]System.Console::Write(string)
ldloc i_var2
call void [mscorlib]System.Console::Write(int64)
ldstr " * 4 ("
call void [mscorlib]System.Console::Write(string)
ldloc i_var2
ldc.i8 4
mul
call void [mscorlib]System.Console::Write(int64)
ldstr ")"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldstr "Alterado B_VAR1 para TRUE"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldc.i4.1
stloc b_var1
ldstr "ENTROU NO ISFALSEDO DA CONDICAO INTERNA"
stloc s_msg
ldloc i_var2
ldc.i8 2
add
stloc i_var2
R5:
ldloc i_qtd
ldc.i8 1
add
stloc i_qtd
br R6
R3:
ldc.i4.1
stloc b_var1
ldstr "Entrou no ELSE do B_VAR1"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldloc i_qtd
ldc.i8 2
add
stloc i_qtd
ldloc i_var2
ldc.i8 1
add
stloc i_var2
R6:
ldloc i_sum
ldloc i_var1
add
stloc i_sum
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
br R0
R1:
ldstr " O total final eh de "
call void [mscorlib]System.Console::Write(string)
ldloc i_sum
call void [mscorlib]System.Console::Write(int64)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ldstr " O mehdia final eh de "
call void [mscorlib]System.Console::Write(string)
ldloc i_sum
ldloc i_qtd
div
call void [mscorlib]System.Console::Write(float64)
ldstr "\r\n"
call void [mscorlib]System.Console::Write(string)
ret
}
}