package br.com.furb.compiler.lexical.impl.gals;

import br.com.furb.compiler.semantic.ObjectCode;
import br.com.furb.compiler.semantic.SymbolTable;
import br.com.furb.compiler.semantic.actions.ActionSemantic;
import br.com.furb.compiler.semantic.actions.ActionSemanticFactory;

public class Semantico implements Constants {
	private ObjectCode objectCode = new ObjectCode();
	private SymbolTable symbolTable = new SymbolTable();

	public String getObjectCode() {
		return this.objectCode.toString();
	}

	public void executeAction(int action, Token token) throws SemanticError {
		ActionSemantic actionSemantic = ActionSemanticFactory.create(action, symbolTable);

		if (actionSemantic != null) {
			String generatedCode = actionSemantic.execute(token);

			if (generatedCode != null) {
				this.objectCode.add(generatedCode);
			}
		} else {
			System.out.println("A��o ainda n�o implementada: " + action);
		}
	}
}
