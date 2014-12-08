package model;

import java.io.*;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;

public class ConfigFile extends File {

	private static final long serialVersionUID = 1L;

	private List<String> fileLines;

	public ConfigFile(File parent, String child) throws IOException {
		super(parent, child);
		loadFileLines();
	}

	public ConfigFile(String parent, String child) throws IOException {
		super(parent, child);
		loadFileLines();
	}

	public ConfigFile(String pathname) throws IOException {
		super(pathname);
		loadFileLines();
	}

	public ConfigFile(URI uri) throws IOException {
		super(uri);
		loadFileLines();
	}

	@Override
	public String toString() {
		return super.toString();
	}

	private void loadFileLines() throws IOException {
		fileLines = Files.readAllLines(this.toPath(), Charset.forName("ASCII"));
	}

	public List<String> getLines() {
		return Collections.unmodifiableList(fileLines);
	}

	public int findLine(String line) {
		int i = 0;
		if (fileLines.isEmpty()) {
			return 0;
		}

		String regex = String.format( ".*%s(?!\\w).*", line);

		while (!fileLines.get(i).matches(regex) && i < fileLines.size() - 1) {
			i++;
		}

		if (fileLines.get(i).contains(line)) {
			return i + 1;
		}
		else {
			return 0;
		}

	}

}
