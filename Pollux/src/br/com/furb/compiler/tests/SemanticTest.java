package br.com.furb.compiler.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.furb.compiler.lexical.impl.gals.LexicalError;
import br.com.furb.compiler.lexical.impl.gals.Lexico;
import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.Semantico;
import br.com.furb.compiler.lexical.impl.gals.Sintatico;
import br.com.furb.compiler.lexical.impl.gals.SyntaticError;

public class SemanticTest {
	
	private String cabecalho() {
		String[] codigoObjeto = new String[] {
			".assembly extern mscorlib {}",
			".assembly codigo_objeto {}",
			".module codigo_objeto.exe",
			".class public _Principal {",
				".method static public void _principal() {",
				 	".entrypoint"
		};
		
		return String.join("\n", codigoObjeto);
	}
	
	private String rodape() {
		String[] codigoObjeto = new String[] {
					"ret",
			 	"}",
		 	"}"
		};
		
		return String.join("\n", codigoObjeto);
	}
	
	private void verificaCodigoGerado(String programaFonte, String codigoObjetoEsperado) throws LexicalError, SyntaticError, SemanticError {
		Lexico lexico = new Lexico();
		Sintatico sintatico = new Sintatico();
		Semantico semantico = new Semantico();

		lexico.setInput(programaFonte);
		sintatico.parse(lexico, semantico);
		
		assertEquals(cabecalho() + "\n" + codigoObjetoEsperado + "\n" + rodape(), semantico.getCodigoObjeto());
	}
	
	private void verificaCodigoGerado(String[] programaFonte, String[] codigoObjetoEsperado) throws LexicalError, SyntaticError, SemanticError {
		verificaCodigoGerado(
			String.join("\n", programaFonte),
			String.join("\n", codigoObjetoEsperado)
		);
	}
	
	@Test
	public void testDeclaraIntSetaValor() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : i_primeiro;",
			"{",
				"i_primeiro <- 0;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (int64 i_primeiro)",
		 	"ldc.i8 0",
		 	"stloc i_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testDeclaraFloatSetaValor() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : f_primeiro;",
			"{",
				"f_primeiro <- 0,0;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (float64 f_primeiro)",
		 	"ldc.r8 0.0",
		 	"stloc f_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testDeclaraStringSetaValor() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : s_primeiro;",
			"{",
				"s_primeiro <- \"Primeiro\";",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (string s_primeiro)",
		 	"ldstr \"Primeiro\"",
		 	"stloc s_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
}
