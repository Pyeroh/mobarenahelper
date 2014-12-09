package model.data;

import java.io.Serializable;
import java.util.*;

import model.GestYaml;
import model.enums.*;
import model.exceptions.ArenaException;
import model.lists.MonsterList;
import model.wave.*;

/**
 * Classe abstraite servant à décrire une vague de manière générale.
 *
 * @author Pyeroh
 */
public abstract class Wave implements Comparable<Wave>, Serializable {

	private static final long serialVersionUID = 4101521237477701343L;

	private String nom;

	private ECatW category;

	private ETypeW type;

	private int numwave = 1;

	private int priority = 1;

	private int frequency = 1;

	private float amount_multiplier = 1.0f;

	private float health_multiplier = 1.0f;

	private ArrayList<Position> spawnpoints = new ArrayList<Position>();

	private MonsterList monstres = new MonsterList();

	public Wave(String nom, ETypeW type) {
		this.type = type;
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ECatW getCategory() {
		return category;
	}

	public void setCategory(ECatW category) {
		this.category = category;
	}

	public ETypeW getType() {
		return type;
	}

	public void setType(ETypeW type) {
		this.type = type;
	}

	public int getNumwave() {
		return numwave;
	}

	public void setNumwave(int numwave) {
		this.numwave = numwave;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public MonsterList getMonstres() {
		return monstres;
	}

	public void setMonstres(MonsterList monstres) {
		this.monstres = monstres;
	}

	public float getAmount_multiplier() {
		return amount_multiplier;
	}

	public void setAmount_multiplier(float amount_multiplier) {
		if (amount_multiplier >= 0.1f) {
			this.amount_multiplier = amount_multiplier;
		}
	}

	public float getHealth_multiplier() {
		return health_multiplier;
	}

	public void setHealth_multiplier(float health_multiplier) {
		if (health_multiplier >= 0.1f) {
			this.health_multiplier = health_multiplier;
		}
	}

	public ArrayList<Position> getSpawnpoints() {
		return spawnpoints;
	}

	public void setSpawnpoints(ArrayList<Position> spawnpoints) {
		this.spawnpoints = spawnpoints;
	}

	/**
	 * Change le type de la vague et la reconstruit, avec les informations basiques d'une vague
	 *
	 * @return la nouvelle vague
	 */
	public DefaultW getDefaultW() {
		return (DefaultW) getWave(new DefaultW(nom));
	}

	/**
	 * Change le type de la vague et la reconstruit, avec les informations basiques d'une vague
	 *
	 * @return la nouvelle vague
	 */
	public SpecialW getSpecialW() {
		return (SpecialW) getWave(new SpecialW(nom));
	}

	/**
	 * Change le type de la vague et la reconstruit, avec les informations basiques d'une vague
	 *
	 * @return la nouvelle vague
	 */
	public SwarmW getSwarmW() {
		return (SwarmW) getWave(new SwarmW(nom));
	}

	/**
	 * Change le type de la vague et la reconstruit, avec les informations basiques d'une vague
	 *
	 * @return la nouvelle vague
	 */
	public BossW getBossW() {
		return (BossW) getWave(new BossW(nom));
	}

	/**
	 * Change le type de la vague et la reconstruit, avec les informations basiques d'une vague
	 *
	 * @return la nouvelle vague
	 */
	public SupplyW getSupplyW() {
		return (SupplyW) getWave(new SupplyW(nom));
	}

	/**
	 * Change le type de la vague et la reconstruit, avec les informations basiques d'une vague
	 *
	 * @return la nouvelle vague
	 */
	public UpgradeW getUpgradeW() {
		return (UpgradeW) getWave(new UpgradeW(nom));
	}

	private Wave getWave(Wave wave) {
		wave.setCategory(category);
		wave.setNumwave(numwave);
		wave.setPriority(priority);
		wave.setFrequency(frequency);
		// wave.setMonstres(new MonsterList());

		return wave;
	}

	/**
	 * Compare une vague à une autre par son numéro de vague ou sa priorité. Si la vague en paramètre a une numéro de
	 * vague supérieur, égal, ou inférieur à celui de la vague à laquelle on compare, la méthode renverra respectivement
	 * -1, 0, ou 1.
	 *
	 * @param wave
	 *            une autre vague de monstres
	 */
	@Override
	public int compareTo(Wave wave) {
		int wint, tint;
		if (this.category == ECatW.recurrent) {
			wint = wave.getPriority();
			tint = this.priority;
		}
		else {
			wint = wave.getNumwave();
			tint = this.numwave;
		}

		if (wint > tint)
			return -1;
		else if (wint == tint)
			return 0;
		else
			return 1;

	}

	@Override
	public String toString() {
		String ret = "Classe : " + getClass() + "\nname : " + nom + "\ncategory : " + category.name() + "\ntype : " + type.name() + "\nwave : "
				+ numwave + "\npriority : " + priority + "\nfrequency : " + frequency + "\nmonstres : " + monstres.toString();
		return ret;
	}

	/**
	 * Renvoie la "map" des informations relatives à la vague
	 *
	 * @return une Map contenant les clés pour les informations de la vague
	 * @throws ArenaException
	 */
	public LinkedHashMap<String, Object> getMap() throws ArenaException {
		LinkedHashMap<String, Object> vague = new LinkedHashMap<>();

		vague.put("type", type.name().toLowerCase());
		if (health_multiplier != 1.0f || amount_multiplier != 1.0f) {
			vague.put("health-multiplier", health_multiplier);
			vague.put("amount-multiplier", amount_multiplier);
		}

		if (category == ECatW.recurrent) {
			vague.put("priority", priority);
			vague.put("frequency", frequency);
			if (numwave != 0 && numwave != 1)
				vague.put("wave", numwave);
		}
		else {
			vague.put("wave", numwave);
		}

		if (!spawnpoints.isEmpty()) {
			Collections.sort(spawnpoints);

			StringBuffer sp = new StringBuffer();
			for (Position position : spawnpoints) {
				sp.append(position.getName());
				sp.append("; ");
			}
			sp.replace(sp.length() - 2, sp.length(), "");
			vague.put("spawnpoints", sp.toString());
		}

		if (this instanceof BossW || this instanceof SwarmW) {
			Monstre monster = monstres.get(0);
			vague.put("monster", monster.getMonstre().name());
		}
		else if (!monstres.isEmpty()) {
			LinkedHashMap<String, Object> mapmonstres = new LinkedHashMap<>();
			if (monstres.size() == 1) {
				Monstre mmonster = monstres.get(0);
				mapmonstres.put(mmonster.getMonstre().name(), mmonster.getProbability());
			}
			else {
				for (int i = 0; i < monstres.size(); i++) {
					Monstre monster = monstres.get(i);
					int probability = monster.getProbability();
					if (probability == 0 || probability > 1)
						mapmonstres.put(EMonsterAliases.valueOf(monster.getMonstre().name()).getPlural().name(), probability);
					else
						mapmonstres.put(monster.getMonstre().name(), monster.getProbability());
				}
			}
			vague.put("monsters", mapmonstres);
		}
		// else vague.put("monsters", null);

		return vague;
	}

	/**
	 * Instancie une vague et remplis complètement ses informations grâce à la Map.
	 *
	 * @param nom
	 *            le nom de la vague
	 * @param category
	 *            la catégorie à laquelle elle appartient
	 * @param map
	 *            la map d'informations de la vague
	 * @return la vague, avec ses informations remplies
	 * @throws ArenaException
	 */
	public static Wave setWave(String nom, ECatW category, LinkedHashMap<String, Object> map) throws ArenaException {
		Wave wave = null;
		GestYaml g = new GestYaml(map);
		StringBuffer type = new StringBuffer(map.get("type").toString());
		type.replace(0, 1, type.substring(0, 1).toUpperCase());
		ETypeW enumType;
		try {
			enumType = ETypeW.valueOf(type.toString());
		}
		catch (IllegalArgumentException e) {
			throw new ArenaException("No type named : " + type.toString().toLowerCase());
		}
		switch (enumType) {
		case Default:
			wave = DefaultW.setWave(nom, map);
			break;
		case Special:
			wave = SpecialW.setWave(nom, map);
			break;
		case Swarm:
			wave = SwarmW.setWave(nom, map);
			break;
		case Boss:
			wave = BossW.setWave(nom, map);
			break;
		case Supply:
			wave = SupplyW.setWave(nom, map);
			break;
		case Upgrade:
			wave = UpgradeW.setWave(nom, map);
			break;
		}

		wave.setCategory(category);
		wave.setAmount_multiplier(g.containsKey("amount-multiplier") ? g.getFloat("amount-multiplier") : wave.getAmount_multiplier());
		wave.setHealth_multiplier(g.containsKey("health-multiplier") ? g.getFloat("health-multiplier") : wave.getHealth_multiplier());
		if (g.containsKey("spawnpoints")) {
			String[] spawns = g.getString("spawnpoints").split(";");
			for (String string : spawns) {
				wave.getSpawnpoints().add(new Position(string.trim() + "0,0"));
			}
			Collections.sort(wave.getSpawnpoints());
		}
		return wave;
	}

}
