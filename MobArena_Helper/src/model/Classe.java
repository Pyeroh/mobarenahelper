package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import model.enums.EItem;

public class Classe {

	private String name;
	private ArrayList<EItem> items = new ArrayList<>();
	private ArrayList<EItem> armor = new ArrayList<EItem>();
	private LinkedHashMap<String, Object> permissions = new LinkedHashMap<String, Object>();
	private LinkedHashMap<String, Object> lobby_permissions = new LinkedHashMap<String, Object>();
	private boolean unbreakable_weapons = true;
	private boolean unbreakable_armor = true;
	
	public Classe (String name) {
		this.name = name;
	}
	
	public Classe (String name, ArrayList<EItem> items, ArrayList<EItem> armor) {
		this(name);
		this.items = items;
		this.armor = armor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<EItem> getItems() {
		return items;
	}

	public ArrayList<EItem> getArmor() {
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
	
}
