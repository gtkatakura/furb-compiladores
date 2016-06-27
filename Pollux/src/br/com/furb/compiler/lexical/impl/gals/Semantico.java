package br.com.furb.compiler.lexical.impl.gals;

public class Semantico implements Constants
{
	private StringBuilder codigoObjeto = new StringBuilder();
	private String identificador = null;
	
	public String getCodigoObjeto() {
		return this.codigoObjeto.toString();
	}

	public void executeAction(int action, Token token) throws SemanticError
    {
		switch (action) {
		case 5:
			this.codigoObjeto.append("ldc.i8 " + token.getLexeme() + "\n");
			break;
		case 6:
			this.codigoObjeto.append("ldc.r8 " + token.getLexeme().replace(",", ".") + "\n");
			break;
		case 12:
			this.codigoObjeto.append(".assembly extern mscorlib {}\n");
			this.codigoObjeto.append(".assembly codigo_objeto {}\n");
			this.codigoObjeto.append(".module codigo_objeto.exe\n");
			this.codigoObjeto.append(".class public _Principal {\n");
			this.codigoObjeto.append(".method static public void _principal() {\n");
			this.codigoObjeto.append(".entrypoint\n");
			break;
		case 13:
			this.codigoObjeto.append("ret\n");
			this.codigoObjeto.append("}\n");
			this.codigoObjeto.append("}");
			break;
		case 19:
			this.codigoObjeto.append("ldstr " + token.getLexeme() + "\n");
			break;
		case 21:
			this.identificador = token.getLexeme();
			break;
		case 23:
			String tipo = null;
			
			if (this.identificador.startsWith("i_")) {
				tipo = "int64";
			} else if (this.identificador.startsWith("f_")) {
				tipo = "float64";
			} else if (this.identificador.startsWith("s_")) {
				tipo = "string";
			}

			this.codigoObjeto.append(".locals (" + tipo + " " + this.identificador + ")\n");
			this.identificador = null;
			break;
		case 25:
			this.codigoObjeto.append("stloc " + this.identificador + "\n");
			break;
		}
    }
}
