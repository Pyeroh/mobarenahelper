package view.cells;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.Item;

public class CellListItem extends CellListCaracs {

	private static final long serialVersionUID = 5471797674503281211L;
	private JLabel image = new JLabel();
	private Item item;
	
	public CellListItem(Item item) {
		this.item = item;
		
		setSize(240, 36);
		setLayout(null);
		
		lib_desc.setBounds(44, 2, 186, 32);
		lib_desc.setText(this.item.getItem().getName());

		image.setBackground(Color.BLACK);
		image.setIcon(new ImageIcon(this.item.getItem().getImage()));
		
		image.setBounds(2, 2, 32, 32);
		add(image);
	}

}
