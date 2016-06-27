package br.com.furb.compiler.semantic;

public class Identifier {
	private String name;
	
	public Identifier(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name;
	}
	
	public String getType() {
		switch (this.getHungarianConvention()) {
		case 'i':
			return "int64";
		case 'f':
			return "float64";
		case 's':
			return "string";
		case 'b':
			return "bool";
		default:
			return null;
		}
	}
	
	private char getHungarianConvention() {
		return this.name.toCharArray()[0];
	}
}
