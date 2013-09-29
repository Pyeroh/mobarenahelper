package model;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import model.enums.EMonsterAliases;
import model.enums.ETypeW;

public class SpecialW extends Wave {

	public SpecialW(String nom) {
		super(nom, ETypeW.Special);
	}

	public static SpecialW setWave(String nom, Map<String, Object> map){
		SpecialW wave = new SpecialW(nom);
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

		return wave;
	}

}
