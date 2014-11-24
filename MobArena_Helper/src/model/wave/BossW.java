package model.wave;

import java.util.*;

import model.*;
import model.data.*;
import model.enums.*;
import model.exceptions.*;
import model.lists.ItemList;

/**
 * Une vague de boss
 *
 * @author Pyeroh
 * @see Wave
 */
public class BossW extends Wave {

	private static final long serialVersionUID = 5128463064091852941L;

	private String bossname = "";

	private EHealth health = EHealth.medium;

	private boolean ability_announce = true;

	private int ability_interval = 3;

	private ArrayList<EAbilities> abilities = new ArrayList<EAbilities>() {

		private static final long serialVersionUID = -4152334175348950909L;

		public String toString() {
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < this.size(); i++) {
				buffer.append(this.get(i).toString() + ", ");
			}
			String ret = "";
			if (this.size() > 0) {
				ret = buffer.substring(0, buffer.length() - 2);
			}
			return ret;
		}
	};

	private ItemList reward = new ItemList();

	public BossW(String nom) {
		super(nom, ETypeW.Boss);
		this.getMonstres().add(new Monstre(EMonsters.zombie, 0));
	}

	public String getBossName() {
		return bossname;
	}

	public void setBossName(String name) {
		this.bossname = name;
	}

	public EHealth getHealth() {
		return health;
	}

	public void setHealth(EHealth health) {
		this.health = health;
	}

	public boolean isAbility_announce() {
		return ability_announce;
	}

	public void setAbility_announce(boolean ability_announce) {
		this.ability_announce = ability_announce;
	}

	public int getAbility_interval() {
		return ability_interval;
	}

	public void setAbility_interval(int ability_interval) {
		this.ability_interval = ability_interval;
	}

	public ArrayList<EAbilities> getAbilities() {
		return abilities;
	}

	public ItemList getReward() {
		return reward;
	}

	public String toString() {
		String ret = super.toString() + "\nbossname : " + bossname + "\nhealth : " + health.getNom() + "\nability_announce : " + ability_announce
				+ "\nability_interval : " + ability_interval + "\nabilities : " + abilities.toString();

		return ret;
	}

	public static BossW setWave(String nom, LinkedHashMap<String, Object> map) throws ArenaException {
		BossW wave = new BossW(nom);
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
		if (map.containsKey("name")) {
			wave.setBossName(g.getString("name"));
		}
		if (map.containsKey("health")) {
			try {
				wave.setHealth(EHealth.valueOf(g.getString("health")));
			}
			catch (IllegalArgumentException e) {
				throw new ArenaException("No health value : " + g.getString("health"));
			}
		}
		if (map.containsKey("ability-interval")) {
			wave.setAbility_interval(g.getInt("ability-interval"));
		}
		if (map.containsKey("ability-announce")) {
			wave.setAbility_announce(g.getBool("ability-announce"));
		}
		if (map.containsKey("abilities")) {
			String[] abi = g.getString("abilities").split("[,]");
			for (int i = 0; i < abi.length; i++) {
				String formatedAbility = abi[i].replace('-', '_').trim();
				try {
					wave.abilities.add(EAbilities.valueOf(formatedAbility));
				}
				catch (IllegalArgumentException e) {
					throw new ArenaException("No ability named : " + abi[i].trim());
				}
			}
		}
		try {
			wave.getMonstres().add(new Monstre(EMonsterAliases.getByName(g.getString("monster")).getMonstre(), 1));
		}
		catch (IllegalArgumentException e) {
			throw new MonsterException(g.getString("monster"));
		}
		if (map.containsKey("reward")) {
			wave.getReward().fill(g.getString("reward"));
		}

		return wave;
	}

	public LinkedHashMap<String, Object> getMap() throws ArenaException {
		LinkedHashMap<String, Object> vague = super.getMap();

		if (!this.getBossName().equals(""))
			vague.put("name", this.getBossName());
		if (this.getHealth() != EHealth.medium)
			vague.put("health", this.getHealth().name());
		vague.put("abilities", this.getAbilities().toString());
		if (!this.isAbility_announce())
			vague.put("ability-announce", this.isAbility_announce());
		if (this.getAbility_interval() != 3)
			vague.put("ability-interval", this.getAbility_interval());
		if (reward.size() != 0)
			vague.put("reward", reward.getString());

		return vague;
	}

	public void setReward(ItemList reward) {
		this.reward = reward;
	}

}
