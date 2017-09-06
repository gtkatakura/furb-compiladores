package br.com.furb.compiler.analysis.semantic;

public class ObjectCode {
	private final StringBuilder piecesOfCode = new StringBuilder();
	
	public ObjectCode() {}
	
	public void add(String pieceOfCode) {
		if (pieceOfCode != null) {
			this.piecesOfCode.append(pieceOfCode);
		}
	}
	
	@Override
	public String toString() {
		return this.piecesOfCode.toString();
	}
}
