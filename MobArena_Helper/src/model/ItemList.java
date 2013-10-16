package model;

import java.util.ArrayList;

import model.enums.EItem;

public class ItemList extends ArrayList<Item> {

	private static final long serialVersionUID = -1822352239305240836L;

	public void fill(String items) {

		String[] sItem = items.replace('\'', ' ')
				.split(",");
		for (int i = 0; i < sItem.length; i++) {
			//SE : sans espace --> test d'enchantement
			String sItemSE[] = sItem[i].trim().split(" ");

			String[] tab_item = sItemSE[0].split(":");
			int data = 0;
			int quantity = 1;
			switch (tab_item.length) {
			case 1:
				break;
			case 2:
				quantity = Integer.parseInt(tab_item[1]);
				break;
			case 3:
				data = Integer.parseInt(tab_item[1]);
				quantity = Integer.parseInt(tab_item[2]);
				break;
			default:
				break;
			}

			String[] enchantments = null;
			if (sItemSE.length == 2) {
				enchantments = sItemSE[1].split(";");
			}

			if (tab_item[0].matches("(\\d)+")) {
				this.add(new Item(EItem.searchBy(
						Integer.parseInt(tab_item[0]), data), quantity,
						enchantments));
			} else {
				this.add(new Item(EItem.searchBy(tab_item[0], data),
						quantity, enchantments));
			}

		}
	}

	public String getMap() {
		StringBuffer sItems = new StringBuffer();
		if(this.size()==1){
			String item = this.get(0).getMap();
			if(item.matches("(\\d)+")) sItems.append("'"+item+"'");
			else sItems.append(item);
		}
		else {
			for(int i=0;i<this.size();i++) {
				sItems.append(this.get(i).getMap()+", ");
			}
			int length = sItems.length();
			sItems.delete(length-2, length);
		}
		
		return sItems.toString();
	}
}