package br.com.furb.compiler.semantic;

import java.lang.reflect.InvocationTargetException;

public enum EActionSemantics {
	Number5(5, AllocateInt.class),
	Number6(6, AllocateFloat.class),
	Number12(12, HeaderCode.class),
	Number13(13, FooterCode.class),
	Number19(19, AllocateString.class);
	
	private int action;
	private ActionSemantic actionSemantic;
	
	public int getAction() {
		return this.action;
	}
	
	public ActionSemantic getActionSemantic() {
		return this.actionSemantic;
	}
	
	EActionSemantics(int action, Class<? extends ActionSemantic> classe) {
		try {
			this.action = action;
			this.actionSemantic = classe.getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
}
