package br.com.furb.compiler.model.semantic;

public class CorrespondingClass {
	private String source;
	
	public CorrespondingClass(String source) {
		this.source = source;
	}
	
	@Override
	public String toString() {
		return capitalize(this.source) + lowerCharsFrom(1, this.source);
	}

	private String capitalize(String value) {
		return String.valueOf(value.charAt(0)).toUpperCase();
	}

	private String lowerCharsFrom(int index, String value) {
		return value.substring(index).toLowerCase();
	}
}
