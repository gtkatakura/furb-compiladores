package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public class HeaderCode extends ActionSemantic {
	public HeaderCode(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) {
		return (
			".assembly extern mscorlib {}\n" +
			".assembly codigo_objeto {}\n" +
			".module codigo_objeto.exe\n" +
			".class public _Principal {\n" +
				".method static public void _principal() {\n" +
					".entrypoint\n"
		);
	}
}
