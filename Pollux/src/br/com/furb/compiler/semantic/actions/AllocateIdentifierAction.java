package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.analysis.semantic.SemanticError;
import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.Identifier;
import br.com.furb.compiler.model.semantic.SymbolTable;

public final class AllocateIdentifierAction extends SemanticAction {
	public AllocateIdentifierAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	@Override
	public String execute(Token token) throws SemanticError {
		Identifier identifier = this.getSymbolTable().getStackIdentifiers().pop();
		this.getSymbolTable().getTypes().push(identifier.getTypeDescription());

		if (!this.getSymbolTable().getIdentifiers().containsKey(identifier.toString())) {
			throw new SemanticError(identifier.toString() + " n�o declarado", token.getPosition());
		}

		if (identifier.isVector()) {
			return "ldelem " + identifier.getTypeDescription() + "\n";
		}
		return "ldloc " + identifier + "\n";
	}

}
