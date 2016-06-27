package br.com.furb.compiler.semantic;

public class SymbolTable {
	private Identifier identifier;
	
	public void setIdentifier(String identificador) {
		this.identifier = new Identifier(identificador);
	}
	
	public Identifier getIdentifier() {
		return this.identifier;
	}
}
