package br.com.furb.compiler.view.impl.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

import br.com.furb.compiler.view.IToolBar;
import br.com.furb.compiler.view.Tool;

/**
 * Representa a barra de ferramentas do compilador
 * 
 * @author alesson.bernardo
 */
public class ToolBar implements IToolBar {

	private final Map<Tool, JButton> tools = new EnumMap<>(Tool.class);

	JButton createButton(Container parent, Tool tool) {
		final JButton button = new JButton();
		parent.add(button, tool.layout());
		return button;
	}

	@Override
	public Component build() {
		final JPanel pnlTools = new JPanel();
		pnlTools.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pnlTools.setLayout(createContainerLayout());

		Arrays.asList(Tool.values()).forEach(tool -> tools.put(tool, createButton(pnlTools, tool)));

		return pnlTools;
	}

	public void addAction(KeyStroke keyStroke, Tool tool, Action action) {
		JButton button = tools.get(tool);
		button.setAction(action);
		mapAction(keyStroke, action, button);
	}

	private void mapAction(KeyStroke keyStroke, Action action, JButton button) {
		Object actionName = action.getValue(Action.NAME);
		button.getActionMap().put(actionName, action);
		button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, actionName);
	}

	private static GridBagLayout createContainerLayout() {
		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[] { 144, 0 };
		layout.rowHeights = new int[] { 55, 55, 55, 55, 55, 55, 55, 55, 55, 55, 100 };
		layout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		layout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		return layout;
	}
}
