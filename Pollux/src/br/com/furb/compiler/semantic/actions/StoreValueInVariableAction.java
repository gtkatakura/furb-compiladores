package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.TokenImpl;
import br.com.furb.compiler.semantic.Identifier;
import br.com.furb.compiler.semantic.SymbolTable;

public class StoreValueInVariableAction extends SemanticAction {
	public StoreValueInVariableAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	@Override
	public String execute(TokenImpl token) throws SemanticError {
		Identifier identifier = this.getSymbolTable().getStackIdentifiers().pop();
		String type = this.getSymbolTable().getTypes().pop();

		if (!this.getSymbolTable().getIdentifiers().containsKey(identifier.toString())) {
			throw new SemanticError(identifier.toString() + " n�o declarado", token.getPosition());
		}

		if (identifier.getTypeDescription() != type) {
			throw new SemanticError("Tipos incompat�veis em comando de atribui��o", token.getPosition());
		}

		if (identifier.isVector()) {
			return "stelem " + identifier.getTypeDescription() + "\n";
		}

		return "stloc " + identifier + "\n";
	}
}
