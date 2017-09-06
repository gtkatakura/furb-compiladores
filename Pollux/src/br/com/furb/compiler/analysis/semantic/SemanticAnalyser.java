package br.com.furb.compiler.analysis.semantic;

import br.com.furb.compiler.gals.Constants;
import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.SymbolTable;
import br.com.furb.compiler.semantic.actions.SemanticAction;
import br.com.furb.compiler.semantic.actions.SemanticActionFactory;

public final class SemanticAnalyser implements Constants {

	private final ObjectCode objectCode = new ObjectCode();
	private final SymbolTable symbolTable = new SymbolTable();
	private final SemanticActionFactory semanticActionFactory = new SemanticActionFactory(this.symbolTable);

	public String getObjectCode() {
		return this.objectCode.toString();
	}

	public void execute(int actionId, Token token) throws SemanticError {
		SemanticAction action = this.semanticActionFactory.create(actionId);
		String generatedCode = action.execute(token);
		
		this.objectCode.add(generatedCode);
	}
}
