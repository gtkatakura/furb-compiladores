package br.com.furb.compiler.semantic;

import java.util.StringJoiner;

public class ObjectCode {
	private StringJoiner pieceOfCodes = new StringJoiner("\n");
	
	public ObjectCode() {}
	public ObjectCode(String... pieceOfCodes) {
		this.add(pieceOfCodes);
	}
	
	public void add(String pieceOfCode) {
		this.pieceOfCodes.add(pieceOfCode);
	}
	
	public void add(String... pieceOfCodes) {
		for (String pieceOfCode : pieceOfCodes) {
			this.add(pieceOfCode);
		}
	}

	@Override
	public String toString() {
		return this.pieceOfCodes.toString();
	}
}
