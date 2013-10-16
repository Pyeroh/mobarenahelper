package model.wave;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import model.ArmorList;
import model.Classe;
import model.ItemList;
import model.Wave;
import model.enums.ETypeW;

public class UpgradeW extends Wave {

	private ArrayList<UpgradeSet> upgrades;
	
	public UpgradeW(String nom) {
		super(nom, ETypeW.Upgrade);
	}

	public LinkedHashMap<String, Object> getMap() {

		return null;
	}

	public static SupplyW setWave(String nom, LinkedHashMap<String, Object> map) {

		return null;
	}

}

class UpgradeSet {
	
	private UpSetup setup;
	private Classe classe;
	private ItemList items;
	private ArmorList armor;
	
	public UpgradeSet(UpSetup setup, Classe classe) {
		this.setup = setup;
		this.classe = classe;
	}
	
	public static UpgradeSet setUpgradeSet(LinkedHashMap<String, Object> map) {
		
		
		return null;
	}
	
}

enum UpSetup {
	legacy,
	advanced;
}