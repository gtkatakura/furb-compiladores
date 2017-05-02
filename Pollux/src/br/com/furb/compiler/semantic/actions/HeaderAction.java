package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.ObjectCode;
import br.com.furb.compiler.semantic.SymbolTable;

public class HeaderAction extends ActionSemantic {
	public HeaderAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) {
		return new ObjectCode(
			".assembly extern mscorlib {}",
			".assembly codigo_objeto {}",
			".module codigo_objeto.exe",
			".class public _Principal {",
				".method static public void _principal() {",
					".entrypoint"
		).toString();
	}
}
