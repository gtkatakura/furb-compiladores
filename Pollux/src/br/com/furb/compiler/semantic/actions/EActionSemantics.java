package br.com.furb.compiler.semantic.actions;

import java.lang.reflect.InvocationTargetException;

import br.com.furb.compiler.semantic.SymbolTable;

public enum EActionSemantics {
	Number5(5, AllocateInt.class),
	Number6(6, AllocateFloat.class),
	Number12(12, HeaderCode.class),
	Number13(13, FooterCode.class),
	Number19(19, AllocateString.class),
	Number21(21, AllocateIdentifier.class),
	Number22(22, DeclareVariable.class),
	Number25(25, StoreValueInVariable.class);
	
	private int action;
	private Class<? extends ActionSemantic> classe;
	
	public int getAction() {
		return this.action;
	}
	
	public ActionSemantic buildActionSemantic(SymbolTable symbolTable) {
		try {
			return this.classe.getConstructor(SymbolTable.class).newInstance(symbolTable);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	EActionSemantics(int action, Class<? extends ActionSemantic> classe) {
		this.action = action;
		this.classe = classe;
	}
	
	// TODO: Refatorar para ser de forma dinâmica
	public static EActionSemantics find(int action) {
		switch (action) {
		case 5:
			return EActionSemantics.Number5;
		case 6:
			return EActionSemantics.Number6;
		case 12:
			return EActionSemantics.Number12;
		case 13:
			return EActionSemantics.Number13;
		case 19:
			return EActionSemantics.Number19;
		case 21:
			return EActionSemantics.Number21;
		case 22:
			return EActionSemantics.Number22;
		case 25:
			return EActionSemantics.Number25;
		default:
			return null;
		}
	}
}
