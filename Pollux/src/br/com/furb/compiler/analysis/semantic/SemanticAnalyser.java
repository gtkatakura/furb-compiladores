package br.com.furb.compiler.analysis.semantic;

import br.com.furb.compiler.gals.Constants;
import br.com.furb.compiler.lexical.TokenImpl;
import br.com.furb.compiler.semantic.SymbolTable;
import br.com.furb.compiler.semantic.actions.SemanticAction;
import br.com.furb.compiler.semantic.actions.ActionSemanticFactory;

public final class SemanticAnalyser implements Constants {

	private StringBuilder objectCode = new StringBuilder();
	private SymbolTable symbolTable = new SymbolTable();

	public String getObjectCode() {
		return this.objectCode.toString();
	}

	public void executeAction(int action, TokenImpl token) throws SemanticError {
		SemanticAction actionSemantic = ActionSemanticFactory.create(action, symbolTable);

		if (actionSemantic != null) {
			String generatedCode = actionSemantic.execute(token);

			if (generatedCode != null) {
				this.objectCode.append(generatedCode);
			}
		} else {
			System.out.println("A��o ainda n�o implementada: " + action);
		}
	}
}
