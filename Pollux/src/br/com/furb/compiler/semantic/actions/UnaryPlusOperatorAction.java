package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.analysis.semantic.SemanticError;
import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.SymbolTable;

public class UnaryPlusOperatorAction extends SemanticAction {
	public UnaryPlusOperatorAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) throws SemanticError {
		String type = this.getSymbolTable().getTypes().lastElement();
		
		if (type != "float64" && type != "int64") {
			throw new SemanticError(
				"Operador '+' s� pode ser aplicado sobre operandos de tipo 'int' e 'float'",
				token.getPosition()
			);
		}
		
		return null;
	}
}
