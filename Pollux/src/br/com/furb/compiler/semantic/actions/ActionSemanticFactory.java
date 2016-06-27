package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.semantic.SymbolTable;

public class ActionSemanticFactory {
	public static ActionSemantic create(int action, SymbolTable symbolTable) {
		EActionSemantics record = EActionSemantics.find(action);

		if (record == null) {
			return null;
		}
		
		return record.buildActionSemantic(symbolTable);
	}
}
