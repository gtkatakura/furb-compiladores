package br.com.furb.compiler.analysis.semantic;

import br.com.furb.compiler.gals.Constants;
import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.SymbolTable;
import br.com.furb.compiler.semantic.actions.SemanticAction;
import br.com.furb.compiler.semantic.actions.SemanticActionFactory;

public final class SemanticAnalyser implements Constants {

	private final StringBuilder objectCode = new StringBuilder();
	private final SymbolTable symbolTable = new SymbolTable();

	public String getObjectCode() {
		return this.objectCode.toString();
	}

	public void execute(int actionId, Token token) throws SemanticError {
		SemanticAction action = SemanticActionFactory.create(actionId, symbolTable);

		if (action != null) {
			String generatedCode = action.execute(token);

			if (generatedCode != null) {
				this.objectCode.append(generatedCode);
			}
		} else {
			System.out.println("Açãoo ainda não implementada: " + actionId);
		}
	}
}
