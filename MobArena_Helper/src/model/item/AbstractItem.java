package model.item;

import java.io.Serializable;

import model.enums.EItem;
import model.lists.EnchantList;

public abstract class AbstractItem implements Serializable {

	private static final long serialVersionUID = 3711368328915325045L;

	private int quantity = 1;

	private EnchantList enchantements = new EnchantList();

	public AbstractItem(int quantity) {
		this.quantity = quantity;
	}

	public AbstractItem() {
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public EnchantList getEnchantements() {
		return enchantements;
	}

	public abstract String getString();

	public abstract EItem getItem();

}
