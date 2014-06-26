package model.item;

import model.enums.EItem;

public class Money extends AbstractItem {

	private float money = 0f;

	public Money(float money) {
		super();
		this.money = money;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	@Override
	public String getString() {
		String m = "$";
		if (money == (int) money)
			m += (int) money;
		else
			m += money;

		return m;
	}

	@Override
	public EItem getItem() {
		return EItem.money;
	}

	@Override
	public String toString() {
		return getString();
	}

}
