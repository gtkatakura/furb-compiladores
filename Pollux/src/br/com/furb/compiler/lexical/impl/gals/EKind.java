package br.com.furb.compiler.lexical.impl.gals;

import java.util.Arrays;

import br.com.furb.compiler.lexical.IKind;

public enum EKind implements IKind {
	DOLLAR(1, "símbolo especial"),
	VIRGULA(2, "símbolo especial"),
	DOIS_PONTOS(3, "símbolo especial"),
	PONTO_E_VIRGULA(4, "símbolo especial"),
	ABRE_COLCHETES(5, "símbolo especial"),
	FECHA_COLCHETES(6, "símbolo especial"),
	ABRE_PARENTESES(7, "símbolo especial"),
	FECHA_PARENTESES(8, "símbolo especial"),
	ABRE_CHAVES(9, "símbolo especial"),
	FECHA_CHAVES(10, "símbolo especial"),
	MAIS(11, "símbolo especial"),
	MENOS(12, "símbolo especial"),
	ASTERISCO(13, "símbolo especial"),
	BARRA(14, "símbolo especial"),
	ATRIBUIR(15, "símbolo especial"),
	IGUAL(16, "símbolo especial"),
	DIFERENTE(17, "símbolo especial"),
	MENOR(18, "símbolo especial"),
	MENORIGUAL(19, "símbolo especial"),
	MAIOR(20, "símbolo especial"),
	MAIORIGUAL(21, "símbolo especial"),
	PALAVRA_RESERVADA(22, "palavra reservada inválida"),
	IDENTIFICADOR_DE_INT(23, "identificador"),
	IDENTIFICADOR_DE_FLOAT(24, "identificador"),
	IDENTIFICADOR_DE_STRING(25, "identificador"),
	IDENTIFICADOR_DE_BOOL(26, "identificador"),
	CONSTANTE_INT(27, "constante int"),
	CONSTANTE_FLOAT(28, "constante float"),
	CONSTANTE_STRING(29, "constante string"),
	AND(30, "palavra reservada"),
	FALSE(31, "palavra reservada"),
	IF(32, "palavra reservada"),
	IN(33, "palavra reservada"),
	ISFALSEDO(34, "palavra reservada"),
	ISTRUEDO(35, "palavra reservada"),
	MAIN(36, "palavra reservada"),
	MODULE(37, "palavra reservada"),
	NOT(38, "palavra reservada"),
	OR(39, "palavra reservada"),
	OUT(40, "palavra reservada"),
	TRUE(41, "palavra reservada"),
	WHILE(42, "palavra reservada");
	
	private int id;
	private String descricao;
	
	private EKind(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public int getId(){
		return id;
	}

	public String getDescription(){
		return descricao;
	}

	public static EKind getClasseById(int id){
		return Arrays.asList(EKind.values()).stream()
			.filter(classe -> classe.getId() == id)
			.findFirst()
			.get();
	}
	

}