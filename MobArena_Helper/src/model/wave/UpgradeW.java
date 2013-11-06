package model.wave;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

import model.Classe;
import model.GestYaml;
import model.Wave;
import model.enums.ETypeW;

/**
 * Une vague d'amélioration des objets et des équipements. Donne de nouveaux objets, équipements, améliore ceux qui existent déjà (s'ils sont similaires, une épée en diamant pour remplacer une
 * épée en fer, ou un enchantement...) et même de nouvelles permissions.
 * @author Pyeroh
 * @see Wave
 */
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

	@Override
	public LinkedHashMap<String, Object> getMap() {
		LinkedHashMap<String, Object> map = super.getMap();
		
		LinkedHashMap<String, Object> upset_map = new LinkedHashMap<String, Object>();
		for(int i=0;i<upgrades.size();i++) {
			
			UpgradeSet upset = upgrades.get(i);
			String upclasse = upset.getClasse().getName();
			Object upmap = upset.getMap();
			if(upmap!=null) {
					upset_map.put(upclasse, upmap);
			}
			
		}
		
		if(!upset_map.isEmpty()) map.put("upgrades", upset_map);
		if(give_all_items) map.put("give-all-items", give_all_items);
		
		return map;
	}
	
	/**
	 * Trie la liste des upgrades de la vague par rapport à l'ordre de celle des classes
	 * @return vrai si l'ordre a été changé, faux sinon
	 */
	public boolean sortUpgrades() {
		
		ArrayList<UpgradeSet> next_upgrades = new ArrayList<UpgradeSet>();
		ArrayList<Classe> classe_list = Classe.classe_list;
		
		for(int i=0;i<classe_list.size();i++) {
			UpgradeSet upset = findUpgradeSet(classe_list.get(i));
			if(upset!=null) {
				next_upgrades.add(upset);
			}
		}
		
		boolean changed = false;
		for(int i=0;i<next_upgrades.size();i++){
			if(next_upgrades.get(i)!=upgrades.get(i)) changed = true;
		}
		
		upgrades = next_upgrades;
		
		return changed;
	}
	
	/**
	 * Trouve un upgradeSet correspondant à la classe passée en paramètre.
	 * @param classe la classe recherchée
	 * @return l'upgradeSet correspondant, ou {@code null}
	 * @see Classe
	 */
	public UpgradeSet findUpgradeSet(Classe classe) {
		int i=0;
		while(i<upgrades.size()) {
			if(upgrades.get(i).getClasse()==classe) break;
			i++;
		}
		if(i==upgrades.size()) return null;
		else return upgrades.get(i);
	}

	/**
	 * Instancie une vague et remplis complètement ses informations grâce à la Map.
	 * @param nom le nom de la vague
	 * @param category la catégorie à laquelle elle appartient
	 * @param map la map d'informations de la vague
	 * @return la vague, avec ses informations remplies
	 */
	public static UpgradeW setWave(String nom, LinkedHashMap<String, Object> map) {
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