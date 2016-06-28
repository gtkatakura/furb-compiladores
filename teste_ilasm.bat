@echo off
set tmp=C:\Temp
set ext1=.txt
set ext2=.exe
set ilasm="C:\Windows\Microsoft.NET\Framework\v2.0.50727\ilasm.exe"

pushd %tmp%

for %%f in (*.il) do (
		echo.
		echo.
		echo Iniciado %%f
		echo.
		type %%f
		echo.
		%ilasm% %%f /OUTPUT=%%f%ext2%
		echo.
		echo Gerado %%f%ext2%
		echo.
		echo Executando %%f%ext2%
		echo.
		%%f%ext2%
		echo.
		echo Finalizado execucao %%f%ext2%
		echo.
		echo Criado e Testado %%f%ext2%
		echo.
)
pause