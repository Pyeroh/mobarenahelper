package model;

import java.util.ArrayList;

import model.enums.EItem;

public class ArmorList extends ItemList {

	private static final long serialVersionUID = -6274717578188692826L;

	public ArmorList() {
		super();
	}

	public ArmorList(ArrayList<Item> list) {
		super(list);
	}

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
			sArmor.append(((Armor)(this.get(0))).getMap(false));
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
	
	public void sort() {
		int size=this.size();
		triRapide(this,0,size-1);
	}

	private int partition(ArmorList list,int deb,int fin) {
		int compt=deb;
		Item pivot=list.get(deb);

		for(int i=deb+1;i<=fin;i++) {
			float lid = (list.get(i).getItem().getId()-298)/4f;
			float pivid = (pivot.getItem().getId()-298)/4f;
			
			lid = lid - (int)lid;
			pivid = pivid - (int)pivid;
			if (lid<pivid) {
				compt++;
				echanger(list,compt,i);
			}
		}
		echanger(list,deb,compt);
		return compt;
	}
	
	protected void triRapide(ArmorList list,int deb,int fin) {
		if(deb<fin) {
			int positionPivot=partition(list,deb,fin);
			triRapide(list,deb,positionPivot-1);
			triRapide(list,positionPivot+1,fin);
		}
	}

}