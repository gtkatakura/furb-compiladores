package br.com.furb.compiler.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Test;

import br.com.furb.compiler.lexical.impl.gals.LexicalError;
import br.com.furb.compiler.lexical.impl.gals.Lexico;
import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.Semantico;
import br.com.furb.compiler.lexical.impl.gals.Sintatico;
import br.com.furb.compiler.lexical.impl.gals.SyntaticError;

public class SemanticTest {
	
	public String verificaMensagemDeErro(String programaFonte) {
		try {
			Lexico lexico = new Lexico();
			Sintatico sintatico = new Sintatico();
			Semantico semantico = new Semantico();

			lexico.setInput(programaFonte);
			sintatico.parse(lexico, semantico);
			return null;
		} catch (SyntaticError | LexicalError | SemanticError error) {
			return error.getMessage();
		}
	}
	
	private void verificaMensagemDeErro(String[] programaFonte, String mensagemDeErroEsperado) {
		String mensagem = verificaMensagemDeErro(String.join("\n", programaFonte));
		assertEquals(mensagemDeErroEsperado, mensagem);
	}
	
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
	
		String codigo = cabecalho() + "\n" + codigoObjetoEsperado + "\n" + rodape();
		assertEquals(codigo, semantico.getObjectCode());
		criarArquivoTest(codigo);
	 }
		 
	private void criarArquivoTest(String codigo) {
		File cd = new File("C:\\temp\\");
		if(!cd.exists()){
			try {
				cd.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		File[] b = cd.listFiles((FilenameFilter) (dir, name) -> name.contains("remove"));
		if(b != null || b.length > 0){
			
			for (File file : cd.listFiles()) {
				file.delete();
			}
		}
		b = cd.listFiles((FilenameFilter) (dir, name) -> name.contains("teste"));
		String name = cd.getAbsolutePath()+"\\teste"+b.length+".txt";
		try {
			PrintWriter writer = new PrintWriter(name);
			String[] cod = codigo.split("\n");
			writer.write(codigo);
			writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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
	public void testDeclaraIntSetaValorPositivado() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : i_primeiro;",
			"{",
				"i_primeiro <- +1;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (int64 i_primeiro)",
		 	"ldc.i8 1",
		 	"stloc i_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testDeclaraIntSetaValorNegativado() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : i_primeiro;",
			"{",
				"i_primeiro <- -1;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (int64 i_primeiro)",
		 	"ldc.i8 1",
		 	"ldc.i8 -1",
		 	"mul",
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
	public void testDeclaraFloatSetaValorNegativado() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : f_primeiro;",
			"{",
				"f_primeiro <- -1,0;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (float64 f_primeiro)",
		 	"ldc.r8 1.0",
		 	"ldc.i8 -1",
		 	"mul",
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
	
	@Test
	public void testEscreveStringSetaValor() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : s_primeiro, s_segundo;",
			"{",
				"s_primeiro <- \"Primeiro\";",
				"s_segundo <- \"Segundo\";",
				"out(s_primeiro, s_segundo);",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (string s_primeiro)",
		 	".locals (string s_segundo)",
		 	"ldstr \"Primeiro\"",
		 	"stloc s_primeiro",
		 	"ldstr \"Segundo\"",
		 	"stloc s_segundo",
		 	"ldloc s_primeiro",
		 	"call void [mscorlib]System.Console::Write(string)",
		 	"ldloc s_segundo",
		 	"call void [mscorlib]System.Console::Write(string)"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testDeclaraBooleanoSetaTrue() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : b_primeiro;",
			"{",
				"b_primeiro <- true;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (bool b_primeiro)",
		 	"ldc.i4.1",
		 	"stloc b_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testDeclaraBooleanoSetaFalse() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : b_primeiro;",
			"{",
				"b_primeiro <- false;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (bool b_primeiro)",
		 	"ldc.i4.0",
		 	"stloc b_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testNegacaoBooleana() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : b_primeiro;",
			"{",
				"b_primeiro <- not false;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (bool b_primeiro)",
		 	"ldc.i4.0",
		 	"ldc.i4.1 xor",
		 	"stloc b_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testSomaConstantes() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : i_primeiro;",
			"{",
				"i_primeiro <- 1 + 2;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (int64 i_primeiro)",
		 	"ldc.i8 1",
		 	"ldc.i8 2",
		 	"add",
		 	"stloc i_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testSomaVariaveis() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : i_primeiro, i_segundo;",
			"{",
				"i_primeiro <- 1;",
				"i_segundo <- i_primeiro + i_primeiro;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
			".locals (int64 i_primeiro)",
			".locals (int64 i_segundo)",
		 	"ldc.i8 1",
		 	"stloc i_primeiro",
		 	"ldloc i_primeiro",
		 	"ldloc i_primeiro",
		 	"add",
		 	"stloc i_segundo"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testSomaIntComFloat() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : f_primeiro;",
			"{",
				"f_primeiro <- 1 + 2,5;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (float64 f_primeiro)",
		 	"ldc.i8 1",
		 	"ldc.r8 2.5",
		 	"add",
		 	"stloc f_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testSubtraiConstantes() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : i_primeiro;",
			"{",
				"i_primeiro <- 1 - 2;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (int64 i_primeiro)",
		 	"ldc.i8 1",
		 	"ldc.i8 2",
		 	"sub",
		 	"stloc i_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testMultiplicaConstantes() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : i_primeiro;",
			"{",
				"i_primeiro <- 1 * 2;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (int64 i_primeiro)",
		 	"ldc.i8 1",
		 	"ldc.i8 2",
		 	"mul",
		 	"stloc i_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testDivideConstantes() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : f_primeiro;",
			"{",
				"f_primeiro <- 1 / 2;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (float64 f_primeiro)",
		 	"ldc.i8 1",
		 	"ldc.i8 2",
		 	"div",
		 	"stloc f_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testDivideTiposDiferentes() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : f_primeiro;",
			"{",
				"f_primeiro <- 1 / 2,5;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (float64 f_primeiro)",
		 	"ldc.i8 1",
		 	"ldc.r8 2.5",
		 	"div",
		 	"stloc f_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testNegativarString() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : i_primeiro;",
			"{",
				"i_primeiro <- -\"Palavra\";",
			"}"
		};
		
		verificaMensagemDeErro(programaFonte, "O Operador Unário (-) só aceita os tipos int e float.");
	}
	
	@Test
	public void testPositivarString() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : i_primeiro;",
			"{",
				"i_primeiro <- +\"Palavra\";",
			"}"
		};
		
		verificaMensagemDeErro(programaFonte, "O Operador Unário (+) só aceita os tipos int e float.");
	}
	
	@Test
	public void testPositivarIdentificadorString() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : s_primeiro, i_primeiro;",
			"{",
				"s_primeiro <- \"Palavra\";",
				"i_primeiro <- +s_primeiro;",
			"}"
		};
		
		verificaMensagemDeErro(programaFonte, "O Operador Unário (+) só aceita os tipos int e float.");
	}
	
	@Test
	public void testPositivarIdentificadorStrin() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : s_primeiro, i_primeiro;",
			"{",
				"s_primeiro <- 1 / \"Palavra\";",
			"}"
		};
		
		verificaMensagemDeErro(programaFonte, "Operadores Binários só aceitam operandos do tipo int e/ou float.");
	}

	@Test
	public void testVariavelIntRecebeFloat() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : i_primeiro;",
			"{",
				"i_primeiro <- 1,5;",
			"}"
		};
		
		verificaMensagemDeErro(programaFonte, "Tipos incompatíveis em comando de atribuição");
	}
	
	@Test
	public void testNegandoNaoBooleano() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : b_primeiro;",
			"{",
				"b_primeiro <- not 1,5;",
			"}"
		};
		
		verificaMensagemDeErro(programaFonte, "Operador Unário (not) só aceita expressões booleanas.");
	}
}
