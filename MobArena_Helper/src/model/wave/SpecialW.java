package model.wave;

import java.util.*;

import model.*;
import model.enums.*;

/**
 * Une vague spéciale, fait apparaitre un seul type de monstre choisi dans une liste. 
 * @author Pyeroh
 * @see Wave
 */
public class SpecialW extends Wave {

	public SpecialW(String nom) {
		super(nom, ETypeW.Special);
	}

	/**
	 * {@link Wave#setWave(String, ECatW, LinkedHashMap)}
	 * @param nom le nom de la vague
	 * @param map la map d'informations de la vague
	 * @return la map d'informations de la vague
	 */
	public static SpecialW setWave(String nom, LinkedHashMap<String, Object> map){
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
	
	@Override
	public LinkedHashMap<String, Object> getMap() {
		return super.getMap();
	}

}
