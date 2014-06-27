package model.item;

import model.enums.EItem;

public class CustomItem extends AbstractItem {

	private static final long serialVersionUID = 9214004733748488077L;

	private int id;

	private int meta = 0;

	public CustomItem(int id, int meta, int quantity) {
		super(quantity);
		this.id = id;
		this.meta = meta;
	}

	public CustomItem(int id, int meta) {
		this(id, meta, 1);
	}

	public CustomItem(int id) {
		this(id, 0);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMeta() {
		return meta;
	}

	public void setMeta(int meta) {
		this.meta = meta;
	}

	@Override
	public String getString() {
		StringBuffer item = new StringBuffer(id + "");
		if (meta != 0)
			item.append(":" + meta + ":" + getQuantity());
		else {
			if (getQuantity() != 0)
				item.append(":" + getQuantity());
		}
		item.append(getEnchantements().getString());
		return item.toString();
	}

	@Override
	public EItem getItem() {
		return EItem.custom;
	}

}
