package view.cells;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.Item;

public class CellListItem extends CellListCaracs {

	private static final long serialVersionUID = 5471797674503281211L;
	private JLabel image = new JLabel();
	private Item item;
	
	public CellListItem(Item item) {
		this.item = item;
		
		lib_desc.setBounds(44, 0, 186, 30);
		lib_desc.setText(this.item.getItem().getName());

		image.setBounds(3, 3, 24, 24);
		image.setIcon(new ImageIcon(CellListWave.scaleImage(this.item.getItem().getImage(), image)));
		add(image);
	}

}
