package br.com.furb.compiler.view.impl.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import br.com.furb.compiler.view.Editor;

/**
 *
 * @see NumberedBorder implementa��o de terceiros de uma borda numerada
 *      utilizada em conjunto com a �rea de edi��o.
 * 
 * @author alesson.bernardo
 *
 */
public class SwingEditor implements Editor {

	private JTextArea editorArea;

	@Override
	public Component build() {
		JPanel pnlEditor = new JPanel();
		pnlEditor.setMinimumSize(new Dimension(750, 450));

		BorderLayout borderLayout = new BorderLayout(0, 0);
		pnlEditor.setLayout(borderLayout);

		pnlEditor.add(buildScrollableEditor());
		return pnlEditor;
	}

	private JScrollPane buildScrollableEditor() {
		editorArea = new JTextArea();

		editorArea.setBorder(new NumberedBorder());
		editorArea.setVisible(true);

		return new JScrollPane(editorArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	}

	@Override
	public void clean() {
		update("");
	}

	@Override
	public void update(String content) {
		editorArea.setText(content);
	}

	@Override
	public String getContent() {
		return editorArea.getText();
	}

	@Override
	public String getSelectedContent() {
		return editorArea.getSelectedText();
	}

	@Override
	public void paste(String content) {
		editorArea.insert(content, editorArea.getCaretPosition());
	}

	@Override
	public int getSelectionStart() {
		return editorArea.getSelectionStart();
	}

	@Override
	public void addKeyListener(KeyListener listener) {
		editorArea.addKeyListener(listener);
	}
}
