package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.Identifier;
import br.com.furb.compiler.semantic.SymbolTable;
import br.com.furb.compiler.semantic.Type;

public class AllocateVectorSizeAction extends ActionSemantic {

	private static final String VECTOR_DECLARATION = "newarr [mscorlib] Sytem.%s";

	public AllocateVectorSizeAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	@Override
	public String execute(Token token) throws SemanticError {
		Identifier identifier = this.getSymbolTable().getStackIdentifiers().peek();

		return "ldc.i8 " + token.getLexeme() + "\n" + //
				buildNewArrayFunctionCallFor(identifier.getType()) + "\n";
	}

	public String buildNewArrayFunctionCallFor(Type type) {
		return String.format(VECTOR_DECLARATION, type.getCorrespondingClass());
	}
}
