package br.com.furb.compiler.lexical.impl.gals;

import br.com.furb.compiler.semantic.SymbolTable;
import br.com.furb.compiler.semantic.actions.ActionSemantic;
import br.com.furb.compiler.semantic.actions.ActionSemanticFactory;
import br.com.furb.compiler.semantic.actions.EActionSemantics;

public class Semantico implements Constants
{
	private StringBuilder codigoObjeto = new StringBuilder();
	private SymbolTable symbolTable = new SymbolTable();
	
	public String getCodigoObjeto() {
		return this.codigoObjeto.toString();
	}

	public void executeAction(int action, Token token) throws SemanticError
    {
		ActionSemantic actionSemantic = ActionSemanticFactory.create(action, symbolTable);
		
		if (actionSemantic != null) {
			String codigoGerado = actionSemantic.execute(token);

			if (codigoGerado != null) {
				this.codigoObjeto.append(codigoGerado);
			}
		} else {
			System.out.println("Ação ainda não implementada: " + action);
		}
    }
}
