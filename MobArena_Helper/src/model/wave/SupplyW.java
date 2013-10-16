package model.wave;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import model.GestYaml;
import model.ItemList;
import model.Monstre;
import model.Wave;
import model.enums.EMonsterAliases;
import model.enums.ETypeW;

public class SupplyW extends Wave {

	private ItemList drops = new ItemList();

	public SupplyW(String nom) {
		super(nom, ETypeW.Supply);
	}

	public ItemList getDrops() {
		return drops;
	}

	public LinkedHashMap<String, Object> getMap() {
		LinkedHashMap<String, Object> vague = super.getMap();

		if(drops.size()==1){
			vague.put("drops", "'"+drops.get(0).getMap()+"'");
		}
		else {
			StringBuffer sItems = new StringBuffer();
			for(int i=0;i<drops.size();i++) {
				sItems.append(drops.get(i).getMap()+", ");
			}
			int length = sItems.length();
			sItems.delete(length-2, length);
			vague.put("drops", sItems.toString());
		}


		return vague;
	}

	public static SupplyW setWave(String nom, Map<String, Object> map) {
		SupplyW wave = new SupplyW(nom);
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
		if(map.containsKey("monsters")){
			Set<String> monsters = g.getMap("monsters").keySet();
			for (Iterator<String> it = monsters.iterator(); it.hasNext();) {
				String monstre = (String) it.next();
				wave.getMonstres().add(new Monstre(EMonsterAliases.valueOf(monstre).getMonstre(), g.getInt("monsters."+monstre)));
			}
		}
		if(map.containsKey("drops")){
			wave.getDrops().fill(g.getString("drops"));
		}
		return wave;
	}

}