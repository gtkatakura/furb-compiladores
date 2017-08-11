package br.com.furb.compiler.semantic.actions;

import static java.util.Arrays.asList;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import br.com.furb.compiler.semantic.SymbolTable;

public enum SemanticActions {
	
	Number1(1, AdditionOperatorAction.class),
	Number2(2, SubtractionOperatorAction.class),
	Number3(3, MultiplicationOperatorAction.class),
	Number4(4, DivisionOperatorAction.class),
	Number5(5, AllocateIntAction.class),
	Number6(6, AllocateFloatAction.class),
	Number7(7, UnaryPlusOperatorAction.class),
	Number8(8, UnaryNegationOperatorAction.class),
	Number9(9, RelationalOperatorAction.class),
	Number10(10, PushRelationalOperatorAction.class),
	Number11(11, OutAction.class),
	Number12(12, HeaderAction.class),
	Number13(13, FooterAction.class),
	Number14(14, LogicalAndOperatorAction.class),
	Number15(15, LogicalOrOperatorAction.class),
	Number16(16, AllocateTrueAction.class),
	Number17(17, AllocateFalseAction.class),
	Number18(18, LogicalNegationOperatorAction.class),
	Number19(19, AllocateStringAction.class),
	Number21(21, PushIdentifierAction.class),
	Number22(22, DeclareVariableAction.class),
	Number23(23, InAction.class),
	Number24(24, AllocateIdentifierAction.class),
	Number25(25, StoreValueInVariableAction.class),
	Number27(27, VectorAccessAction.class),
	Number26(26, AllocateVectorSizeAction.class),
	Number28(28, DefineRotuleSelection.class),
	Number29(29, EndSelectionAction.class),
	Number30(30, EndBlockSelectionAction.class),
	Number31(31, AllocateRotuleAction.class),
	Number32(32, DefineRotuleSelection.class),
	Number33(33, EndBlockRepetitionAction.class);
	
	private final int action;
	private Class<? extends SemanticAction> classe;

	public int getAction() {
		return this.action;
	}

	public SemanticAction build(SymbolTable symbolTable) {
		try {
			return this.classe.getConstructor(SymbolTable.class).newInstance(symbolTable);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}

	SemanticActions(int action, Class<? extends SemanticAction> clazz) {
		this.action = action;
		this.classe = clazz;
	}

	public static Optional<SemanticActions> find(int action) {
		return asList(values()).stream().filter(record -> record.getAction() == action).findAny();
	}
}
