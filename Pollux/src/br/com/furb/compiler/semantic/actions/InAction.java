package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.Identifier;
import br.com.furb.compiler.semantic.SymbolTable;
import br.com.furb.compiler.semantic.Type;

public class InAction extends ActionSemantic {

	private static final String READ_FUNCTION_SIGNATURE = "call string [mscorlib]System.Console::ReadLine()\n";
	
	private static final String PARSE_FUNCTION_SIGNATURE = "call %s [mscorlib]System.%s::Parse(string)\n";

	public InAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	@Override
	public String execute(Token token) throws SemanticError {
		StringBuilder code = new StringBuilder(READ_FUNCTION_SIGNATURE);

		Identifier inputId = new Identifier(token.getLexeme());
		
		if (!this.getSymbolTable().getIdentifiers().containsKey(inputId.toString())) {
			throw new SemanticError(
				inputId.toString() + " não declarado",
				token.getPosition()
			);
		}

		Type idType = inputId.getType();
		if (idType != Type.STRING) {
			code.append(buildParseFunctionCallFor(idType));
		}
		code.append("stloc ").append(inputId).append("\n");

		return code.toString();
	}

	private String buildParseFunctionCallFor(Type type) {
		return String.format(PARSE_FUNCTION_SIGNATURE, type.getDescription(), type.getCorrespondingClass());
	}
}