package model.wave;

import java.util.*;

import model.*;
import model.data.*;
import model.enums.*;
import model.exceptions.*;
import model.lists.ItemList;

/**
 * Une vague de réapprovisionnement. Fais apparaitre un monstre par joueur, choisi parmi une liste, et chaque monstre
 * drop un objet choisi dans la liste des drops à sa mort.
 *
 * @author Pyeroh
 * @see Wave
 */
public class SupplyW extends Wave {

	private static final long serialVersionUID = -7585145359331387943L;

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
	public LinkedHashMap<String, Object> getMap() throws ArenaException {
		LinkedHashMap<String, Object> vague = super.getMap();

		if (vague.get("monsters") == null) {
			if (!vague.containsKey("monster")) {
				throw new ArenaException("A supply wave must have monsters to spawn !");
			}
			else
				vague.put("monsters", vague.remove("monster"));
		}

		StringBuffer sItems = new StringBuffer();
		for (int i = 0; i < drops.size(); i++) {
			sItems.append(drops.get(i).getString() + ", ");
		}
		int length = sItems.length();
		sItems.delete(length - 2, length);
		vague.put("drops", sItems.toString());

		return vague;
	}

	/**
	 * {@link Wave#setWave(String, ECatW, LinkedHashMap)}
	 *
	 * @param nom
	 *            le nom de la vague
	 * @param map
	 *            la map d'informations de la vague
	 * @return la map d'informations de la vague
	 * @throws ArenaException
	 */
	public static SupplyW setWave(String nom, LinkedHashMap<String, Object> map) throws ArenaException {
		SupplyW wave = new SupplyW(nom);
		GestYaml g = new GestYaml(map);
		if (map.containsKey("frequency")) {
			wave.setFrequency(g.getInt("frequency"));
		}
		if (map.containsKey("priority")) {
			wave.setPriority(g.getInt("priority"));
		}
		if (map.containsKey("wave")) {
			wave.setNumwave(g.getInt("wave"));
		}
		if (map.containsKey("monsters")) {
			Set<String> monsters = g.getMap("monsters").keySet();
			for (Iterator<String> it = monsters.iterator(); it.hasNext();) {
				String monstre = (String) it.next();
				try {
					wave.getMonstres().add(new Monstre(EMonsterAliases.getByName(monstre).getMonstre(), g.getInt("monsters." + monstre)));
				}
				catch (IllegalArgumentException e) {
					throw new MonsterException(monstre);
				}
			}
		}
		if (map.containsKey("drops")) {
			wave.getDrops().fill(g.getString("drops"));
		}
		return wave;
	}

}