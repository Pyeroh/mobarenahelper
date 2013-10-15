package model.wave;

import java.util.LinkedHashMap;
import java.util.Map;

import model.ArmorList;
import model.Classe;
import model.ItemList;
import model.Wave;
import model.enums.ETypeW;

public class UpgradeW extends Wave {

	
	
	public UpgradeW(String nom) {
		super(nom, ETypeW.Upgrade);
	}

	public LinkedHashMap<String, Object> getMap() {

		return null;
	}

	public static SupplyW setWave(String nom, Map<String, Object> map) {

		return null;
	}

}

class UpgradeSet {
	
	private UpSetup setup;
	private Classe classe;
	private ItemList items;
	private ArmorList armor;
	
}

enum UpSetup {
	legacy,
	advanced;
}