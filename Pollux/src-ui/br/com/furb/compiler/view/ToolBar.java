package br.com.furb.compiler.view;

import javax.swing.Action;
import javax.swing.KeyStroke;

public interface ToolBar extends BuildableComponent {

	void addAction(KeyStroke keyStroke, EditorTool tool, Action action);

}
