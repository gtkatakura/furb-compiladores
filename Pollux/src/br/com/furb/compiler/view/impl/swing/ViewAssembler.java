package br.com.furb.compiler.view.impl.swing;

public class ViewAssembler {

	// TODO encapsular em um builder

	public static void main(String[] args) {
		new CompilerView(new ToolBar(), new Editor(), new MessageArea(), new StatusBar());
	}
}
