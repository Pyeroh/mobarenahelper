package view.cells;

import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

public class CellListCaracs extends JPanel {

	private static final long serialVersionUID = 6617466786415092311L;
	protected JLabel lib_desc;

	public CellListCaracs(String desc) {

		setSize(220,30);
		setLayout(null);

		lib_desc = new JLabel(desc);
		lib_desc.setBounds(4, 0, 216, 30);
		lib_desc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lib_desc);


	}
	
	public void setText(String text) {
		lib_desc.setText(text);
	}
	
	public String getText() {
		return lib_desc.getText();
	}
	
	public static Image scaleImage(Image source, JComponent component) {
		int height = component.getHeight();
		int width = component.getWidth();
		return source.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING);
	}
}