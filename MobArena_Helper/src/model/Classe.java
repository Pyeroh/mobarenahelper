package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import model.enums.EItem;

public class Classe {

	private LinkedHashMap<String, Object> classe;

	private String name;
	private ArrayList<Item> items = new ArrayList<>();
	private ArrayList<Armor> armor = new ArrayList<>();
	private LinkedHashMap<String, Object> permissions = new LinkedHashMap<String, Object>();
	private LinkedHashMap<String, Object> lobby_permissions = new LinkedHashMap<String, Object>();
	private boolean unbreakable_weapons = true;
	private boolean unbreakable_armor = true;

	public Classe (String name, LinkedHashMap<String, Object> classe) {
		this.name = name;
		this.classe = classe;
		load();
	}

	@SuppressWarnings("unchecked")
	private void load() {
		GestYaml g = new GestYaml(classe);

		String[] tab_cat = {"armor", "items"};

		for (int j = 0; j < tab_cat.length; j++) {
			ArrayList<Item> alItems = (ArrayList<Item>) (tab_cat[j].equals("armor") ? armor : items);

			String[] sItem = g.getString(tab_cat[j]).replace('\'', ' ')
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

				switch (j) {
				case 0:
					if (tab_item[0].matches("(\\d)+")) {
						alItems.add(new Armor(EItem.searchBy(
								Integer.parseInt(tab_item[0]), data),enchantments));
					} else {
						alItems.add(new Armor(EItem.searchBy(tab_item[0], data),enchantments));
					}
					break;
				case 1:
					if (tab_item[0].matches("(\\d)+")) {
						alItems.add(new Item(EItem.searchBy(
								Integer.parseInt(tab_item[0]), data), quantity,
								enchantments));
					} else {
						alItems.add(new Item(EItem.searchBy(tab_item[0], data),
								quantity, enchantments));
					}
					break;
				default:
					break;
				}

			}
		}

		this.permissions = g.getMap("permissions");
		this.lobby_permissions = g.getMap("lobby-permissions");
		this.unbreakable_armor = g.getBool("unbreakable_armor");
		this.unbreakable_weapons = g.getBool("unbreakable-weapons");

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

	public ArrayList<Armor> getArmor() {
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
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();

		//Items
		if(items.size()==1){
			map.put("items", "'"+items.get(0).getMap()+"'");
		}
		else {
			StringBuffer sItems = new StringBuffer();
			for(int i=0;i<items.size();i++) {
				sItems.append(items.get(i).getMap()+", ");
			}
			int length = sItems.length();
			sItems.delete(length-2, length);
			map.put("items", sItems.toString());
		}

		//Armor
		if(armor.size()==1){
			map.put("armor", "'"+armor.get(0).getMap()+"'");
		}
		else {
			StringBuffer sArmor = new StringBuffer();
			for(int i=0;i<armor.size();i++) {
				sArmor.append(armor.get(i).getMap()+",");
			}
			int length = sArmor.length();
			sArmor.delete(length-1, length);
			map.put("armor", sArmor.toString());
		}

		if(permissions!=null) map.put("permissions", permissions);
		if(lobby_permissions!=null) map.put("lobby-permissions", lobby_permissions);
		if(!unbreakable_armor) map.put("unbreakable-armor", unbreakable_armor);
		if(!unbreakable_weapons) map.put("unbreakable-weapons", unbreakable_weapons);

		return map;
	}

}
