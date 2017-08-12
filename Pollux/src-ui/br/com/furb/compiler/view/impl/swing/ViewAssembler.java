package br.com.furb.compiler.view.impl.swing;

public class ViewAssembler {

	// TODO encapsular em um builder

	public static void main(String[] args) {
		new CompilerView(new SwingToolBar(), new SwingEditor(), new SwingMessageArea(), new SwingStatusBar());
	}
}
