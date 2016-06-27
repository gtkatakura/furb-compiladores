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
		case "i_":
			return "int64";
		case "f_":
			return "float64";
		case "s_":
			return "string";
		case "b_":
			return "bool";
		default:
			return null;
		}
	}
	
	private String getHungarianConvention() {
		return this.name.substring(0, 2);
	}
}
