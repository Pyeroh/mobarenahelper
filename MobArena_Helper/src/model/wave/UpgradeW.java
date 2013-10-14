package model.wave;

import java.util.LinkedHashMap;
import java.util.Map;

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
