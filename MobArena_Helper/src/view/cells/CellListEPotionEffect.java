package view.cells;

import javax.swing.*;

import model.enums.EPotionEffect;

public class CellListEPotionEffect extends CellListCaracs {

	private static final long serialVersionUID = 1231494018220127785L;

	private JLabel image = new JLabel();

	private EPotionEffect potionEffect;

	public CellListEPotionEffect(EPotionEffect potionEffect) {
		super(potionEffect.getGuiName());
		this.potionEffect = potionEffect;

		lib_desc.setBounds(44, 0, 256, 30);

		image.setBounds(3, 3, 24, 24);
		image.setIcon(new ImageIcon(scaleImage(this.potionEffect.getImage(), image)));
		add(image);

		setSize(300, 30);
	}

	public EPotionEffect getPotionEffect() {
		return potionEffect;
	}

}
