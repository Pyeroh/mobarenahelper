package model.wave;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import model.GestYaml;
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
		//TODO changer ça
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