package model.wave;

import java.util.*;

import model.*;
import model.enums.*;
import model.lists.ItemList;

/**
 * Une vague de réapprovisionnement. Fais apparaitre un monstre par joueur, choisi parmi une liste, et chaque monstre drop un objet choisi dans la liste des drops à sa mort.
 * @author Pyeroh
 * @see Wave
 */
public class SupplyW extends Wave {

	private ItemList drops = new ItemList();

	public SupplyW(String nom) {
		super(nom, ETypeW.Supply);
	}

	public ItemList getDrops() {
		return drops;
	}

	public void setDrops(ItemList drops) {
		this.drops = drops;		
	}

	@Override
	public LinkedHashMap<String, Object> getMap() {
		LinkedHashMap<String, Object> vague = super.getMap();

		if(drops.size()==1){
			vague.put("drops", "'"+drops.get(0).getString()+"'");
		}
		else {
			StringBuffer sItems = new StringBuffer();
			for(int i=0;i<drops.size();i++) {
				sItems.append(drops.get(i).getString()+", ");
			}
			int length = sItems.length();
			sItems.delete(length-2, length);
			vague.put("drops", sItems.toString());
		}


		return vague;
	}

	/**
	 * {@link Wave#setWave(String, ECatW, LinkedHashMap)}
	 * @param nom le nom de la vague
	 * @param map la map d'informations de la vague
	 * @return la map d'informations de la vague
	 */
	public static SupplyW setWave(String nom, LinkedHashMap<String, Object> map) {
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