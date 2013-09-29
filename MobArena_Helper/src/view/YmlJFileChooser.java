package view;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

class ExtensionFileFilter extends FileFilter {
	private String description;

	private String extensions[];

	public ExtensionFileFilter(String description, String extension) {
		this(description, new String[] { extension });
	}

	public ExtensionFileFilter(String description, String extensions[]) {
		if (description == null) {
			this.description = extensions[0] + "{ " + extensions.length + "} ";
		} else {
			this.description = description;
		}
		this.extensions = (String[]) extensions.clone();
		toLower(this.extensions);
	}

	private void toLower(String array[]) {
		for (int i = 0, n = array.length; i < n; i++) {
			array[i] = array[i].toLowerCase();
		}
	}

	public String getDescription() {
		return description;
	}

	public boolean accept(File file) {
		if (file.isDirectory()) {
			return true;
		} else {
			String path = file.getAbsolutePath().toLowerCase();
			for (int i = 0, n = extensions.length; i < n; i++) {
				String extension = extensions[i];
				if ((path.endsWith(extension) && (path.charAt(path.length() - extension.length() - 1)) == '.')) {
					return true;
				}
			}
		}
		return false;
	}
}

public class YmlJFileChooser extends JFileChooser {

	private static final long serialVersionUID = -6764091355692633545L;

	public YmlJFileChooser() {
		super(".");
		FileFilter jpegFilter = new ExtensionFileFilter(null, new String[] { "YML" });

		removeChoosableFileFilter(getFileFilter());
		addChoosableFileFilter(jpegFilter);
	}
	
	public YmlJFileChooser(String dir) {
		super(dir);
		FileFilter jpegFilter = new ExtensionFileFilter(null, new String[] { "YML" });

		removeChoosableFileFilter(getFileFilter());
		addChoosableFileFilter(jpegFilter);
	}

}