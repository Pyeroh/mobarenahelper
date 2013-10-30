package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Classe {

	private LinkedHashMap<String, Object> classe;

	private String name;
	private ItemList items = new ItemList();
	private ArmorList armor = new ArmorList();
	private int dog_number;
	private int horse;
	private LinkedHashMap<String, Object> permissions = new LinkedHashMap<String, Object>();
	private LinkedHashMap<String, Object> lobby_permissions = new LinkedHashMap<String, Object>();
	private boolean unbreakable_weapons = true;
	private boolean unbreakable_armor = true;
	
	public static ArrayList<Classe> classe_list = new ArrayList<Classe>(){
		private static final long serialVersionUID = -5427655124441902011L;
		public void clear() {
			super.clear();
			this.add(new Classe("all"));
		}
	};

	public Classe (String name, LinkedHashMap<String, Object> classe) {
		classe_list.add(this);
		
		this.name = name;
		this.classe = classe;
		load();
	}
	
	private Classe(String name) {
		this.name = name;
	}
	
	private void load() {
		GestYaml g = new GestYaml(classe);

		String[] sItems = g.getString("items").split(",");
		//TODO trouver nombre de chiens et de chevaux
		for(int i=0;i<sItems.length;i++) {
			
		}
		
		
		items.fill(g.getString("items"));
		armor.fill(g.getString("armor"));

		this.permissions = g.getMap("permissions");
		this.lobby_permissions = g.getMap("lobby-permissions");
		this.unbreakable_armor = g.getString("unbreakable-armor")==null ? true : g.getBool("unbreakable-armor");
		this.unbreakable_weapons = g.getString("unbreakable-weapons")==null ? true : g.getBool("unbreakable-weapons");

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ItemList getItems() {
		return items;
	}

	public ArmorList getArmor() {
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

	public LinkedHashMap<String, Object> getMap() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();

		//Items
		map.put("items", items.getMap());

		//Armor
		map.put("armor", armor.getMap());

		if(permissions!=null) map.put("permissions", permissions);
		if(lobby_permissions!=null) map.put("lobby-permissions", lobby_permissions);
		if(!unbreakable_armor) map.put("unbreakable-armor", unbreakable_armor);
		if(!unbreakable_weapons) map.put("unbreakable-weapons", unbreakable_weapons);

		return map;
	}
	
	public static Classe getByName(String name) {
		int i=0;
		while(!classe_list.get(i).getName().equals(name) && i<classe_list.size()){
			i++;
		}
		if(i==classe_list.size()){
			throw new IllegalArgumentException("Invalid Classe name : "+name);
		}
		else {
			return classe_list.get(i);
		}
	}

}
