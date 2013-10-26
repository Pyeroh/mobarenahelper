package model.wave;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import model.GestYaml;
import model.ItemList;
import model.Monstre;
import model.Wave;
import model.enums.EAbilities;
import model.enums.EHealth;
import model.enums.EMonsterAliases;
import model.enums.ETypeW;

public class BossW extends Wave{

	private String bossname = "";
	private EHealth health = EHealth.medium;
	private boolean ability_announce = true;
	private int ability_interval = 3;
	private ArrayList<EAbilities> abilities = new ArrayList<EAbilities>(){
		private static final long serialVersionUID = -4152334175348950909L;
		public String toString() {
			StringBuffer buffer = new StringBuffer();
			for(int i=0;i<this.size();i++){
				buffer.append(this.get(i).toString()+", ");
			}
			String ret = buffer.substring(0, buffer.length()-2);
			return ret;
		}
	};
	private ItemList reward = new ItemList();

	public BossW(String nom) {
		super(nom, ETypeW.Boss);
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
		String ret = super.toString()
				+"\nbossname : "+bossname
				+"\nhealth : "+health.getNom()
				+"\nability_announce : "+ability_announce
				+"\nability_interval : "+ability_interval
				+"\nabilities : "+abilities.toString();

		return ret;
	}

	public static BossW setWave(String nom, Map<String, Object> map){
		BossW wave = new BossW(nom);
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
		if(map.containsKey("name")){
			wave.setBossName(g.getString("name"));
		}
		if(map.containsKey("health")){
			wave.setHealth(EHealth.valueOf(g.getString("health")));
		}
		if(map.containsKey("ability-interval")){
			wave.setAbility_interval(g.getInt("ability-interval"));
		}
		if(map.containsKey("ability-announce")){
			wave.setAbility_announce(g.getBool("ability-announce"));
		}
		if(map.containsKey("abilities")){
			String[] abi = g.getString("abilities").split("[,]");
			for (int i=0;i<abi.length;i++) {
				wave.abilities.add(EAbilities.valueOf(abi[i].replace('-', '_').trim()));
			}
		}
		wave.getMonstres().add(new Monstre(EMonsterAliases.valueOf(g.getString("monster")).getMonstre(),0));
		if(map.containsKey("reward")){
			wave.getReward().fill(g.getString("reward"));
		}

		return wave;
	}

	public LinkedHashMap<String, Object> getMap() {
		LinkedHashMap<String, Object> vague = super.getMap();

		if(!this.getBossName().equals(""))vague.put("name", this.getBossName());
		if(this.getHealth()!=EHealth.medium)vague.put("health", this.getHealth().name());
		vague.put("abilities", this.getAbilities().toString());
		if(!this.isAbility_announce())vague.put("ability-announce", this.isAbility_announce());
		if(this.getAbility_interval()!=3)vague.put("ability-interval", this.getAbility_interval());
		if(reward.size()!=0)vague.put("reward", reward.getMap());

		return vague;
	}

	public void setReward(ItemList reward) {
		this.reward = reward;
	}

}
