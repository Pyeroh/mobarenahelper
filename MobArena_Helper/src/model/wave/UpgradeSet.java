package model.wave;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import model.ArmorList;
import model.Classe;
import model.GestYaml;
import model.ItemList;

public class UpgradeSet {
	
	public enum UpSetup {
		legacy,
		advanced;
		
		public static String[] namevalues(){

			UpSetup[] values = values();
			String[] namevalues = new String[values.length];
			for (int i=0;i<namevalues.length;i++) {
				String name = values[i].name();
				String first = name.charAt(0)+"";
				namevalues[i] = name.replaceFirst("^[a-z]", first.toUpperCase());
			}
			return namevalues;
		}
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
		//TODO changer ça
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