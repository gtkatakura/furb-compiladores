package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.analysis.semantic.SemanticError;
import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.SymbolTable;
import br.com.furb.compiler.model.semantic.Type;
import static br.com.furb.compiler.model.semantic.Type.*;

public final class UnaryNegationOperatorAction extends SemanticAction {
	
	public UnaryNegationOperatorAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) throws SemanticError {
		Type type = this.getSymbolTable().getTypes().lastElement();
		
		if (type != FLOAT && type != INT) {
			throw new SemanticError(
				"Operador '-' s� pode ser aplicado sobre operandos de tipo 'int' e 'float'",
				token.getPosition()
			);
		}
		
		return (
			"ldc.i8 -1\n" +
			"mul\n"
		);
	}
}
