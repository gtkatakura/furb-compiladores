package br.com.furb.compiler.semantic;

import static br.com.furb.compiler.semantic.Type.BOOLEAN;
import static br.com.furb.compiler.semantic.Type.FLOAT;
import static br.com.furb.compiler.semantic.Type.INT;
import static br.com.furb.compiler.semantic.Type.STRING;

public final class Identifier {

	private final String name;
	private Integer size;

	public Identifier(String name) {
		this.name = name;
	}

	public Type getType() {
		switch (this.getHungarianConvention()) {
		case 'i':
			return INT;
		case 'f':
			return FLOAT;
		case 's':
			return STRING;
		case 'b':
			return BOOLEAN;
		default:
			return null;
		}
	}

	public String getTypeDescription() {
		Type type = getType();
		return type == null ? null : type.getDescription();
	}

	private char getHungarianConvention() {
		return this.name.toCharArray()[0];
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getSize() {
		return size;
	}

	public boolean isVector() {
		return getSize() != null;
	}

	public String toString() {
		return this.name;
	}
}
