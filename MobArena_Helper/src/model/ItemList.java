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
			sItems.append("'"+this.get(0).getMap()+"'");
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

class ArmorList extends ArrayList<Armor> {

	private static final long serialVersionUID = -6274717578188692826L;

	public void fill(String armor) {

		String[] sArmor = armor.replace('\'', ' ')
				.split(",");
		for (int i = 0; i < sArmor.length; i++) {
			//SE : sans espace --> test d'enchantement
			String sArmorSE[] = sArmor[i].trim().split(" ");

			String[] tab_item = sArmorSE[0].split(":");
			int data = 0;
			switch (tab_item.length) {
			case 1:case 2:
				break;
			case 3:
				data = Integer.parseInt(tab_item[1]);
				break;
			default:
				break;
			}

			String[] enchantments = null;
			if (sArmorSE.length == 2) {
				enchantments = sArmorSE[1].split(";");
			}

			if (tab_item[0].matches("(\\d)+")) {
				this.add(new Armor(EItem.searchBy(
						Integer.parseInt(tab_item[0]), data), enchantments));
			} else {
				this.add(new Armor(EItem.searchBy(tab_item[0], data), enchantments));
			}

		}
	}

	public String getMap() {
		StringBuffer sArmor = new StringBuffer();
		if(this.size()==1){
			sArmor.append("'"+this.get(0).getMap()+"'");
		}
		else {
			for(int i=0;i<this.size();i++) {
				sArmor.append(this.get(i).getMap()+",");
			}
			int length = sArmor.length();
			sArmor.delete(length-1, length);
		}
		
		return sArmor.toString();
	}

}
