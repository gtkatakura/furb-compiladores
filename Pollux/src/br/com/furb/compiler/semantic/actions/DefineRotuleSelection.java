package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.TokenImpl;
import br.com.furb.compiler.semantic.SymbolTable;

public class DefineRotuleSelection extends SemanticAction {
	public DefineRotuleSelection(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(TokenImpl token) throws SemanticError {
		String type = this.getSymbolTable().getTypes().pop();
		
		if (type != "bool") {
			throw new SemanticError(
				"Essa instru��o s� pode ser manipulada com express�es booleanas",
				token.getPosition()
			);
		}

		String rotule = this.getSymbolTable().createRotule();

		if (token.getLexeme().equals("isTrueDo")) {
			return "brfalse " + rotule + "\n";
		}
		
		return "brtrue " + rotule + "\n";
	}
}