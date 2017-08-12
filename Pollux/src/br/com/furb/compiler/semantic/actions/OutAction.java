package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.analysis.semantic.SemanticError;
import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.SymbolTable;

public final class OutAction extends SemanticAction {
	
	public OutAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) throws SemanticError {
		String type = this.getSymbolTable().getTypes().pop();
		return "call void [mscorlib]System.Console::Write(" + type + ")\n";
	}
}
