package br.com.furb.compiler.analysis.lexical;

public class LexicalError extends AnalysisError {

	private static final long serialVersionUID = 1L;

	private String lexeme;

	public LexicalError(String msg, int position) {
		super(msg, position);
	}

	public LexicalError(String msg, int position, String lexeme) {
		this(msg, position);
		this.lexeme = lexeme;
	}

	@Override
	public String getMessage() {
		if (lexeme != null) {
			return this.lexeme + " " + super.getMessage();
		}
		return super.getMessage();
	}
}
