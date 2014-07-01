package model.wave;

import java.util.*;

import model.*;
import model.data.*;
import model.enums.*;
import model.exceptions.*;

/**
 * Une vague spéciale, fait apparaitre un seul type de monstre choisi dans une liste.
 *
 * @author Pyeroh
 * @see Wave
 */
public class SpecialW extends Wave {

	private static final long serialVersionUID = 7910557779310023838L;

	public SpecialW(String nom) {
		super(nom, ETypeW.Special);
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
	public static SpecialW setWave(String nom, LinkedHashMap<String, Object> map) throws ArenaException {
		SpecialW wave = new SpecialW(nom);
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

		return wave;
	}

}
