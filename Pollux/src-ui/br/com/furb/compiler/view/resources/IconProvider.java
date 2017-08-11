package br.com.furb.compiler.view.resources;

import java.net.URL;

import javax.swing.ImageIcon;

public enum IconProvider {

	NEW_FILE("newFile.png"), //
	OPEN_FILE("openFile.png"), //
	SAVE_FILE("saveFile.png"), //
	COPY("copy.png"), //
	PASTE("paste.png"), //
	CUT("cut.png"), //
	COMPILE("compile.png"), //
	GENERATE_CODE("generateCode.png"), //
	TEAM("team.png");
	private ImageIcon icon;

	IconProvider(String path) {
		URL resource = IconProvider.class.getClassLoader().getResource("icon/" + path);
		icon = new ImageIcon(resource.getPath());
	}

	public ImageIcon get() {
		return icon;
	}
}
