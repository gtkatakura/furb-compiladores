package br.com.furb.compiler.lexical.impl.gals;

public class LexicalError extends AnalysisError
{
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
    		return "Erro na linha " + this.getPosition() + " - " + this.lexeme + " " + super.getMessage();
    	}
    	
		return "Erro na linha " + this.getPosition() + " - " + super.getMessage();
    }
}