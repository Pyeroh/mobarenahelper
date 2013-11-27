package view.cells;

import model.item.*;

public class CellListItem extends CellListEItem {

	private static final long serialVersionUID = 5471797674503281211L;
	private AbstractItem item;
	
	public CellListItem(AbstractItem item) {
		super(item.getItem());
		this.item = item;
		
		if(this.item instanceof Item) lib_desc.setText(this.item.getItem().getGuiName() + (item.getQuantity()!=1 ? " x"+item.getQuantity() : ""));
		else {
			CustomItem ci = (CustomItem) this.item;
			lib_desc.setText(ci.getId() + ":" + ci.getMeta() + (ci.getQuantity()!=1 ? " x"+ci.getQuantity() : ""));
		}
	}
	
	public AbstractItem getItem() {
		return item;
	}

}
