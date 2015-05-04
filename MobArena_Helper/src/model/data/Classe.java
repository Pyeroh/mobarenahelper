package model.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import model.GestYaml;
import model.enums.EItem;
import model.exceptions.ArenaException;
import model.lists.ArmorList;
import model.lists.ItemList;

/**
 * Une classe jouable en arène.
 *
 * @author Pyeroh
 */
public class Classe implements Serializable {

	private static final long serialVersionUID = 8302046355832205620L;

	private LinkedHashMap<String, Object> classe;

	private String name;

	private ItemList items = new ItemList();

	private ArmorList armor = new ArmorList();

	private int dog_number = 0;

	private int horse = 0;

	private ArrayList<String> permissions = new ArrayList<String>();

	private ArrayList<String> lobby_permissions = new ArrayList<String>();

	private boolean unbreakable_weapons = true;

	private boolean unbreakable_armor = true;

	// TODO récupération et écriture du prix (format : $<price>)
	private float price = 0f;

	/**
	 * La liste des classes actuellement en configuration
	 */
	public static ArrayList<Classe> classe_list = new ArrayList<Classe>() {

		private static final long serialVersionUID = -5427655124441902011L;

		public void clear() {
			super.clear();
			new Classe("all");
		}
	};

	/**
	 * Instancie une classe avec son nom et la Map de ses informations, puis charge ces informations.
	 *
	 * @param name
	 *            le nom de la classe
	 * @param classe
	 *            la Map en question
	 * @throws ArenaException
	 */
	public Classe(String name, LinkedHashMap<String, Object> classe) throws ArenaException {
		classe_list.add(this);

		this.name = name;
		this.classe = classe;
		load();
	}

	/**
	 * Instance une classe seulement avec son nom, pour que l'utilisateur complète les autres informations.
	 *
	 * @param name
	 *            le nom de la classe
	 */
	public Classe(String name) {
		classe_list.add(this);

		this.name = name;
	}

	private void load() throws ArenaException {
		GestYaml g = new GestYaml(classe);

		items.fill(g.getString("items"));
		armor.fill(g.getString("armor"));

		int dog_index = items.indexofEItem(EItem.bone);
		if (dog_index != -1) {
			dog_number = items.get(dog_index).getQuantity();
			items.remove(dog_index);
		}
		int horse_index = items.indexofEItem(EItem.hay_block);
		if (horse_index != -1) {
			horse = items.get(horse_index).getQuantity();
			items.remove(horse_index);
		}

		this.permissions = g.getList("permissions");
		this.lobby_permissions = g.getList("lobby-permissions");
		this.unbreakable_armor = g.getBool("unbreakable-armor", true);
		this.unbreakable_weapons = g.getBool("unbreakable-weapons", true);

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

	public void setItems(ItemList items) {
		this.items = items;
	}

	public ArmorList getArmor() {
		return armor;
	}

	public void setArmor(ArmorList armor) {
		this.armor = armor;
	}

	public int getDog_number() {
		return dog_number;
	}

	public void setDog_number(int dog_number) {
		this.dog_number = dog_number;
	}

	public int getHorse() {
		return horse;
	}

	public void setHorse(int horse) {
		this.horse = horse;
	}

	public ArrayList<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(ArrayList<String> permissions) {
		this.permissions = permissions;
	}

	public ArrayList<String> getLobby_permissions() {
		return lobby_permissions;
	}

	public void setLobby_permissions(ArrayList<String> lobby_permissions) {
		this.lobby_permissions = lobby_permissions;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return name + "\n" + armor.toString() + "\n" + items.toString() + "\n";
	}

	/**
	 * Renvoie la Map des informations de la classe
	 *
	 * @return
	 */
	public LinkedHashMap<String, Object> getMap() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();

		// Items
		StringBuffer sItems = new StringBuffer(items.getString());
		if (dog_number != 0) {
			sItems.append(", " + EItem.bone.getRealName());
			if (dog_number != 1)
				sItems.append(":" + dog_number);
		}
		if (horse != 0) {
			sItems.append(", " + EItem.hay_block.getRealName());
			if (horse != 1)
				sItems.append(":" + horse);
		}
		map.put("items", sItems.toString().trim());

		// Armor
		map.put("armor", armor.getString().trim());

		if (permissions != null) {
			if (permissions.size() != 0)
				map.put("permissions", permissions);
		}
		if (lobby_permissions != null) {
			if (lobby_permissions.size() != 0)
				map.put("lobby-permissions", lobby_permissions);
		}
		if (!unbreakable_armor)
			map.put("unbreakable-armor", unbreakable_armor);
		if (!unbreakable_weapons)
			map.put("unbreakable-weapons", unbreakable_weapons);

		return map;
	}

	/**
	 * Renvoie la classe correspondant au nom passé en paramètre, sans importance sur la casse.
	 *
	 * @param name
	 *            le nom de la classe
	 * @return la classe correspondant au nom passé en paramètre.
	 * @throws IllegalArgumentException
	 *             si la classe associée au nom passé en paramètre n'existe pas
	 */
	public static Classe getByName(String name) {
		int i = 0;
		while (!classe_list.get(i).getName().equalsIgnoreCase(name) && i < classe_list.size()) {
			i++;
		}
		if (i == classe_list.size()) {
			throw new IllegalArgumentException("Invalid Classe name : " + name);
		}
		else {
			return classe_list.get(i);
		}
	}

}
