package br.com.furb.compiler.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SourceUtils {

	public static void save(File file, String content) throws IOException {
		try {
			if (!file.exists()) {
				file.getParentFile().mkdirs();
				file.createNewFile();
			}

			try (FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos)) {
				content = content.replaceAll("\n", "\r\n");
				fos.write(content.getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException("Check the file name again! ("+file.getName()+")", e);
		}
	}

	public static String read(File file) {
		if (file == null || !file.exists()) {
			throw new IllegalArgumentException("You should be a nice guy and give me a valid file!");
		}

		StringBuilder sb = new StringBuilder();
		byte[] bucket = new byte[4096];
		int index;
		try (FileInputStream fis = new FileInputStream(file); BufferedInputStream bis = new BufferedInputStream(fis)) {
			while ((index = bis.read(bucket)) > 0) {
				sb.append(new String(bucket, 0, index));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString().replaceAll("\r\n", "\n");
	}
}
