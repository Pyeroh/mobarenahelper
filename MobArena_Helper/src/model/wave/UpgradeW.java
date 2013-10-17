package model.wave;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import model.ArmorList;
import model.Classe;
import model.GestYaml;
import model.ItemList;
import model.Wave;
import model.enums.ETypeW;

public class UpgradeW extends Wave {

	private ArrayList<UpgradeSet> upgrades = new ArrayList<>();
	private boolean give_all_items = true;
	
	public UpgradeW(String nom) {
		super(nom, ETypeW.Upgrade);
	}

	public ArrayList<UpgradeSet> getUpgrades() {
		return upgrades;
	}

	public boolean isGive_all_items() {
		return give_all_items;
	}

	public void setGive_all_items(boolean give_all_items) {
		this.give_all_items = give_all_items;
	}

	public LinkedHashMap<String, Object> getMap() {

		return null;
	}

	public static UpgradeW setWave(String nom, Map<String, Object> map) {
		UpgradeW wave = new UpgradeW(nom);
		GestYaml g = new GestYaml(map);
		
		if(map.containsKey("frequency")){
			wave.setFrequency(g.getInt("frequency"));
		}
		if(map.containsKey("priority")){
			wave.setPriority(g.getInt("priority"));
		}
		if(map.containsKey("wave")){
			wave.setNumwave(g.getInt("wave"));
		}
		wave.setGive_all_items(g.getBool("give-all-items"));
		LinkedHashMap<String, Object> upgrades_map = g.getMap("upgrades");
		for (Iterator<String> it = upgrades_map.keySet().iterator(); it.hasNext();) {
			String classe = (String) it.next();
			LinkedHashMap<String, Object> upgrade = new LinkedHashMap<String, Object>();
			switch (g.getTag("upgrades."+classe).getClassName()) {
			case "str":
				upgrade.put(classe, g.getString("upgrades."+classe));
				break;
			case "map":
				upgrade.put(classe, g.getMap("upgrades."+classe));
				break;
			default:
				break;
			}
			wave.getUpgrades().add(UpgradeSet.setUpgradeSet(classe, upgrade));
		}
		return wave;
	}

}

class UpgradeSet {
	
	enum UpSetup {
		legacy,
		advanced;
	}

	private UpSetup setup;
	private Classe classe;
	private ItemList items = new ItemList();
	private ArmorList armor = new ArmorList();
	private ArrayList<String> permissions = new ArrayList<String>();
	
	public UpgradeSet(UpSetup setup, Classe classe) {
		this.setup = setup;
		this.classe = classe;
	}
	
	public UpSetup getSetup() {
		return setup;
	}

	public void setSetup(UpSetup setup) {
		this.setup = setup;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public ItemList getItems() {
		return items;
	}

	public ArmorList getArmor() {
		return armor;
	}

	public ArrayList<String> getPermissions() {
		return permissions;
	}
	
	public void setPermissions(ArrayList<String> permissions) {
		this.permissions = permissions;
	}

	public LinkedHashMap<String, Object> getMap() {
		
		return null;
	}
	
	public static UpgradeSet setUpgradeSet(String nom_classe, LinkedHashMap<String, Object> map) {
		GestYaml g = new GestYaml(map);
		UpgradeSet set = null;
		
		String tag = g.getTag(nom_classe).getClassName();
		ArrayList<Classe> classe_list = Classe.classe_list;
		int i = 0;
		while (!classe_list.get(i).getName().equals(nom_classe)) i++;
		
		switch (tag) {
		case "map":
			set = new UpgradeSet(UpSetup.advanced, classe_list.get(i));
			map = g.getMap(nom_classe);
			if(map.containsKey("armor")) {
				set.getArmor().fill(g.getString(nom_classe+".armor"));
			}
			if(map.containsKey("items")) {
				set.getItems().fill(g.getString(nom_classe+".items"));
			}
			if(map.containsKey("permissions")) {
				set.setPermissions(g.getList(nom_classe+".permissions"));
			}
			break;
		case "str":
			set = new UpgradeSet(UpSetup.legacy, classe_list.get(i));
			set.getItems().fill(g.getString(nom_classe));
			break;
		default:
			break;
		}
		
		
		
		return set;
	}
	
}