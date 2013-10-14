package model.wave;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import model.Wave;
import model.enums.EItem;
import model.enums.ETypeW;

public class SupplyW extends Wave {

	private ArrayList<EItem> drops = new ArrayList<>();
	
	public SupplyW(String nom) {
		super(nom, ETypeW.Supply);
	}
	
	public ArrayList<EItem> getDrops() {
		return drops;
	}
	
	protected LinkedHashMap<String, Object> getMap() {
		
		return null;
	}
	
	public static SupplyW setWave(String nom, Map<String, Object> map) {
		
		return null;
	}

}