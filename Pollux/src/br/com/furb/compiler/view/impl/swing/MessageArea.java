package br.com.furb.compiler.view.impl.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import br.com.furb.compiler.view.IMessageArea;

public class MessageArea implements IMessageArea {

	private JTextArea messageArea;

	public Component build() {
		final JPanel pnlMessageArea = new JPanel();
		pnlMessageArea.setPreferredSize(new Dimension(750, 110));

		pnlMessageArea.setLayout(new BorderLayout(0, 0));

		pnlMessageArea.add(createScrollableMessageArea(), BorderLayout.CENTER);
		return pnlMessageArea;
	}

	private JScrollPane createScrollableMessageArea() {
		messageArea = new JTextArea();
		messageArea.setEditable(false);

		return new JScrollPane(messageArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	}

	@Override
	public void update(String message) {
		messageArea.setText(message);
	}

	@Override
	public void clean() {
		update("");
	}
}
