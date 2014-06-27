package model.wave;

import java.util.LinkedHashMap;

import model.*;
import model.enums.*;

/**
 * Une vague d'entrainement ! Ne fais apparaitre qu'un type de monste, avec un seul point de vie, et en très grande
 * quantité.
 *
 * @author denanq
 * @see Wave
 */
public class SwarmW extends Wave {

	private static final long serialVersionUID = 5641390195215691711L;

	private EAmount amount = EAmount.low;

	public SwarmW(String nom) {
		super(nom, ETypeW.Swarm);
		this.getMonstres().add(new Monstre(EMonsters.zombie, 0));
	}

	public EAmount getAmount() {
		return amount;
	}

	public void setAmount(EAmount amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		String ret = super.toString() + "\namount : " + amount.getNom();
		return ret;
	}

	/**
	 * {@link Wave#setWave(String, ECatW, LinkedHashMap)}
	 *
	 * @param nom
	 *            le nom de la vague
	 * @param map
	 *            la map d'informations de la vague
	 * @return la map d'informations de la vague
	 */
	public static SwarmW setWave(String nom, LinkedHashMap<String, Object> map) {
		SwarmW wave = new SwarmW(nom);
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
		if (map.containsKey("amount")) {
			wave.setAmount(EAmount.valueOf(g.getString("amount")));
		}
		wave.getMonstres().set(0, new Monstre(EMonsterAliases.getByName(g.getString("monster")).getMonstre(), 0));

		return wave;
	}

	@Override
	public LinkedHashMap<String, Object> getMap() throws ArenaException {
		LinkedHashMap<String, Object> vague = super.getMap();
		if (this.getAmount() != EAmount.low)
			vague.put("amount", this.getAmount().name());

		return vague;
	}

}
