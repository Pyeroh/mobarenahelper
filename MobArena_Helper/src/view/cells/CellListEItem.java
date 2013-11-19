package view.cells;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.enums.EItem;

public class CellListEItem extends CellListCaracs{

	private static final long serialVersionUID = -489871563289609199L;
	private JLabel image = new JLabel();
	private EItem eitem;
	
	public CellListEItem(EItem eitem) {
		super(eitem.getGuiName());
		this.eitem = eitem;
		
		lib_desc.setBounds(44, 0, 256, 30);

		image.setBounds(3, 3, 24, 24);
		image.setIcon(new ImageIcon(CellListWave.scaleImage(this.eitem.getImage(), image)));
		add(image);
		
		setSize(300,30);
	}
	
	public EItem getEItem() {
		return eitem;
	}
	
}
