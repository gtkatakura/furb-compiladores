package br.com.furb.compiler.view.impl.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.furb.compiler.view.IStatusBar;

public class StatusBar implements IStatusBar {

	private static final String EDITOR_NOT_MODIFIED = "N�o modificado";
	private static final String MODIFIED = "Modificado ";

	private JLabel lblStatus;

	@Override
	public Component build() {
		final JPanel pnlStatus = new JPanel();
		pnlStatus.setLayout(new BorderLayout(0, 0));
		pnlStatus.setPreferredSize(new Dimension(900, 25));

		lblStatus = new JLabel(EDITOR_NOT_MODIFIED);
		pnlStatus.add(lblStatus);
		return pnlStatus;
	}

	@Override
	public void notModified(String file) {
		lblStatus.setText(EDITOR_NOT_MODIFIED + pathDescription(file));
	}

	@Override
	public void modified(String file) {
		lblStatus.setText(MODIFIED + pathDescription(file));
	}

	private String pathDescription(String file) {
		return file != null ? " - Arquivo: " + file : "";
	}
}
