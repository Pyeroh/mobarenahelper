package model.wave;

import java.util.*;

import model.*;
import model.data.*;
import model.enums.*;
import model.exceptions.*;

/**
 * Une vague par défaut, spawn de monstres choisis parmi une liste aléatoirement, et croissance du nombre de monstres à
 * chaque vague.
 *
 * @author Pyeroh
 * @see Wave
 */
public class DefaultW extends Wave {

	private static final long serialVersionUID = -2610262930009396418L;

	private EGrowth growth = EGrowth.old;

	private boolean fixed = false;

	public DefaultW(String nom) {
		super(nom, ETypeW.Default);
	}

	public DefaultW(ECatW category) {
		super("New_Wave", ETypeW.Default);
		setCategory(category);
	}

	public EGrowth getGrowth() {
		return growth;
	}

	public void setGrowth(EGrowth growth) {
		this.growth = growth;
	}

	public boolean isFixed() {
		return fixed;
	}

	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}

	@Override
	public String toString() {
		String ret = super.toString() + "\ngrowth : " + growth.getNom() + "\nfixed : " + fixed;
		return ret;
	}

	@Override
	public LinkedHashMap<String, Object> getMap() throws ArenaException {
		LinkedHashMap<String, Object> vague = super.getMap();
		if (this.getGrowth() != EGrowth.old)
			vague.put("growth", this.getGrowth().name());
		if (this.isFixed())
			vague.put("fixed", this.isFixed());

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
	public static DefaultW setWave(String nom, LinkedHashMap<String, Object> map) throws ArenaException {
		DefaultW wave = new DefaultW(nom);
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
		if (map.containsKey("growth")) {
			try {
				wave.setGrowth(EGrowth.valueOf(g.getString("growth")));
			}
			catch (IllegalArgumentException e) {
				throw new ArenaException("No growth value : " + g.getString("growth"));
			}
		}
		if (map.containsKey("fixed")) {
			wave.setFixed(g.getBool("fixed"));
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
