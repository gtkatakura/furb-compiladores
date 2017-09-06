package br.com.furb.compiler.semantic;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.furb.compiler.model.semantic.SymbolTable;
import br.com.furb.compiler.semantic.actions.SemanticAction;
import br.com.furb.compiler.semantic.actions.SemanticActionFactory;

public class SemanticActionFactoryTest {
	@Test
	public void testActionIdInvalid() {
		SemanticAction action = new SemanticActionFactory(new SymbolTable()).create(-1);
		assertNotNull(action);
	}
}
