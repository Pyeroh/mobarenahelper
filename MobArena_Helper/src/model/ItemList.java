package model;

import java.util.ArrayList;

import model.enums.EItem;

public class ItemList extends ArrayList<Item> {

	private static final long serialVersionUID = -1822352239305240836L;

	public ItemList() {
		super();
	}

	public ItemList(ArrayList<Item> list) {
		super(list);
	}

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

	/**
	 * Vérifie si l'EItem passé en paramètre a déjà un Item associé dans la liste
	 * @param e
	 * @return {@code true} si l'EItem existe, {@code false} sinon
	 */
	public boolean containsEItem(EItem e) {
		return indexofEItem(e)!=-1;
	}

	public ArrayList<EItem> getEItemList() {
		ArrayList<EItem> eitems = new ArrayList<>();
		for(int i=0;i<size();i++){
			eitems.add(get(i).getItem());
		}
		return eitems;
	}
	
	/**
	 * Renvoie la position d'un EItem dans la liste
	 * @param e
	 * @return l'index de l'objet, -1 sinon
	 */
	public int indexofEItem(EItem e) {
		int index=-1, i=0;
		while(i<size() && get(i).getItem()!=e) {
			i++;
		}
		if(i<this.size()) index = i;
		return index;
	}

	public void sort() {
		int size=this.size();
		triRapide(this,0,size-1);
	}

	private int partition(ItemList list,int deb,int fin) {
		int compt=deb;
		Item pivot=list.get(deb);

		for(int i=deb+1;i<=fin;i++) {
			EItem litem = list.get(i).getItem();
			EItem pivitem = pivot.getItem();
			if ((litem.getId()<pivitem.getId()) || (litem.getId()==pivitem.getId() && litem.getMeta()<pivitem.getMeta())) {
				compt++;
				echanger(list,compt,i);
			}
		}
		echanger(list,deb,compt);
		return compt;
	}

	protected void triRapide(ItemList list,int deb,int fin) {
		if(deb<fin) {
			int positionPivot=partition(list,deb,fin);
			triRapide(list,deb,positionPivot-1);
			triRapide(list,positionPivot+1,fin);
		}
	}
	
	protected void echanger(ItemList list, int deb, int fin) {
		Item temp = list.get(deb);
		list.set(deb,list.get(fin));
		list.set(fin,temp);
	}
}