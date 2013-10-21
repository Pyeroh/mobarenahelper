package view.cells;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.enums.EItem;

public class CellListEItem extends CellListCaracs{

	private static final long serialVersionUID = -489871563289609199L;
	private JLabel image = new JLabel();
	private EItem item;
	
	public CellListEItem(EItem item) {
		this.item = item;
		
		lib_desc.setBounds(44, 0, 256, 30);
		lib_desc.setText(this.item.getName());

		image.setBounds(3, 3, 24, 24);
		image.setIcon(new ImageIcon(CellListWave.scaleImage(this.item.getImage(), image)));
		add(image);
		
		setSize(300,30);
	}
	
}
