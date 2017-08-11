package br.com.furb.compiler.view;

import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;

import br.com.furb.compiler.view.resources.IconProvider;

/**
 * Defini��o das a��es dispon�veis
 */
public enum EditorTool {

	NEW_FILE(0, "novo [ctrl-n]", IconProvider.NEW_FILE), //
	OPEN_FILE(1, "abrir [ctrl-o]", IconProvider.OPEN_FILE), //
	SAVE_FILE(2, "salvar [ctrl-s]", IconProvider.SAVE_FILE), //
	COPY(3, "copiar [ctrl-c]", IconProvider.COPY), //
	PASTE(4, "colar [ctrl-v]", IconProvider.PASTE), //
	CUT(5, "recortar [ctrl-x]", IconProvider.CUT), //
	COMPILE(6, "compilar [F8]", IconProvider.COMPILE), //
	GENERATE_CODE(7, "gerar c�digo [F9]", IconProvider.GENERATE_CODE), //
	TEAM(8, "equipe [F1]", IconProvider.TEAM);

	private int id;

	public final String caption;

	public final ImageIcon icon;

	EditorTool(int id, String caption, IconProvider iconProvider) {
		this.id = id;
		this.caption = caption;
		this.icon = iconProvider.get();
	}

	public GridBagConstraints layout() {
		return createLayoutConstraints(GridBagConstraints.BOTH, 0, id);
	}

	private static GridBagConstraints createLayoutConstraints(int fill, int gridx, int gridy) {
		final GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = fill;
		constraints.gridx = gridx;
		constraints.gridy = gridy;
		return constraints;
	}
}