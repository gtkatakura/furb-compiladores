package br.com.furb.compiler.analysis.semantic;

import br.com.furb.compiler.gals.Constants;
import br.com.furb.compiler.lexical.TokenImpl;
import br.com.furb.compiler.semantic.SymbolTable;
import br.com.furb.compiler.semantic.actions.SemanticAction;
import br.com.furb.compiler.semantic.actions.SemanticActionFactory;

public final class SemanticAnalyser implements Constants {

	private StringBuilder objectCode = new StringBuilder();
	private SymbolTable symbolTable = new SymbolTable();

	public String getObjectCode() {
		return this.objectCode.toString();
	}

	public void execute(int actionId, TokenImpl token) throws SemanticError {
		SemanticAction action = SemanticActionFactory.create(actionId, symbolTable);

		if (action != null) {
			String generatedCode = action.execute(token);

			if (generatedCode != null) {
				this.objectCode.append(generatedCode);
			}
		} else {
			System.out.println("A��o ainda n�o implementada: " + actionId);
		}
	}
}
