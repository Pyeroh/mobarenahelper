package view.cells;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

import model.Wave;

public class CellListWave extends CellListCaracs {

	private static final long serialVersionUID = 8335183130273094701L;
	
	private JLabel image;
	private Wave wave;

	public CellListWave(Wave wave) {
		super(wave.getNom());
		this.wave = wave;

		image = new JLabel();
		image.setBounds(3, 3, 48, 24);
		image.setIcon(new ImageIcon(scaleImage(wave.getType().getImage(), image)));
		
		lib_desc.setBounds(61, 3, 181, 24);

		add(image);

	}

	public static Image scaleImage(Image source, JComponent component) {
		int height = component.getHeight();
		int width = component.getWidth();
		return source.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING);
	}

	public Wave getWave() {
		return wave;
	}

	public void setWave(Wave wave) {
		this.wave = wave;
		image.setIcon(new ImageIcon(scaleImage(wave.getType().getImage(), image)));
		lib_desc.setText(wave.getNom());
		repaint();
	}

}