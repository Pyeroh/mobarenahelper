package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import model.enums.EItem;

public class Classe {

	private LinkedHashMap<String, Object> classe;
	
	private String name;
	private ArrayList<Item> items = new ArrayList<>();
	private ArrayList<Item> armor = new ArrayList<>();
	private LinkedHashMap<String, Object> permissions = new LinkedHashMap<String, Object>();
	private LinkedHashMap<String, Object> lobby_permissions = new LinkedHashMap<String, Object>();
	private boolean unbreakable_weapons = true;
	private boolean unbreakable_armor = true;
	
	public Classe (String name, LinkedHashMap<String, Object> classe) {
		this.name = name;
		this.classe = classe;
		load();
	}
	
	private void load() {
		GestYaml g = new GestYaml(classe);
		//TODO Ajouter la gestion des éléments uniques, des différentes possibilités (nombre, chaine)
		
		//Gestion des items
		String[] sItems = g.getString("items").replace('\'', ' ').split("[,]");
		for(int i=0;i<sItems.length;i++) {
			String[] tab_item = sItems[i].trim().split("[:]");
			int data = 0;
			int quantity = 1;
			switch (tab_item.length) {
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
			if(tab_item[0].matches("(\\d)+")){
				System.out.println("item Nombre");
			}
			items.add(new Item(EItem.searchBy(tab_item[0], data),quantity,null));
		}
		
		//Gestion des pièces d'armure
		String[] sArmor = g.getString("armor").replace('\'', ' ').split("[,]");
		for(int i=0;i<sArmor.length;i++) {
			String[] tab_armor = sArmor[i].trim().split("[:]");
			int data = 0;
			int quantity = 1;
			switch (tab_armor.length) {
			case 2:
				quantity = Integer.parseInt(tab_armor[1]);
				break;
			case 3:
				data = Integer.parseInt(tab_armor[1]);
				quantity = Integer.parseInt(tab_armor[2]);
				break;
			default:
				break;
			}
			if(tab_armor[0].matches("(\\d)+")){
				System.out.println("armor Nombre");
			}
			armor.add(new Item(EItem.searchBy(Integer.parseInt(tab_armor[0]), data),quantity,null));
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public ArrayList<Item> getArmor() {
		return armor;
	}

	public LinkedHashMap<String, Object> getPermissions() {
		return permissions;
	}

	public LinkedHashMap<String, Object> getLobby_permissions() {
		return lobby_permissions;
	}

	public boolean isUnbreakable_weapons() {
		return unbreakable_weapons;
	}

	public void setUnbreakable_weapons(boolean unbreakable_weapons) {
		this.unbreakable_weapons = unbreakable_weapons;
	}

	public boolean isUnbreakable_armor() {
		return unbreakable_armor;
	}

	public void setUnbreakable_armor(boolean unbreakable_armor) {
		this.unbreakable_armor = unbreakable_armor;
	}
	
	public String toString() {
		return name+"\n"+armor.toString()+"\n"+items.toString()+"\n";
	}

	protected LinkedHashMap<String, Object> getMap() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
