package model;

import java.util.LinkedHashMap;
import java.util.Map;

import model.enums.EAmount;
import model.enums.ECatW;
import model.enums.EGrowth;
import model.enums.EHealth;
import model.enums.ETypeW;

public abstract class Wave implements Comparable<Wave> {

	private String nom;
	private ECatW category;
	private ETypeW type;
	private int numwave = 1;
	private int priority = 1;
	private int frequency = 1;
	private MonsterList monstres = new MonsterList();

	public Wave(String nom, ETypeW type){
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
	
	public DefaultW getDefaultW() {
		return (DefaultW) getWave(new DefaultW(nom));
	}
	
	public SpecialW getSpecialW() {
		return (SpecialW) getWave(new SpecialW(nom));
	}
	
	public SwarmW getSwarmW() {
		return (SwarmW) getWave(new SwarmW(nom));
	}
	
	public BossW getBossW() {
		return (BossW) getWave(new BossW(nom));
	}
	
	private Wave getWave(Wave wave) {
		wave.setCategory(category);
		wave.setNumwave(numwave);
		wave.setPriority(priority);
		wave.setFrequency(frequency);
		wave.setMonstres(new MonsterList());
		
		return wave;
	}

	/**
	 * Compare une vague à une autre par son numéro de vague ou sa priorité. Si la vague en 
	 * paramètre a une numéro de vague supérieur, égal, ou inférieur à celui de la vague à 
	 * laquelle on compare, la méthode renverra respectivement -1, 0, ou 1.
	 * @param wave une autre vague de monstres
	 */
	public int compareTo(Wave wave) {
		int wint,tint;
		if (this.category==ECatW.recurrent) {
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

	public String toString() {
		String ret = "Classe : "+getClass()
				+"\nname : "+nom
				+"\ncategory : "+category.getNom()
				+"\ntype : "+type.getNom()
				+"\nwave : "+numwave
				+"\npriority : "+priority
				+"\nfrequency : "+frequency
				+"\nmonstres : "+monstres.toString();
		return ret;
	}

	protected LinkedHashMap<String, Object> getMap() {
		LinkedHashMap<String, Object> vague = new LinkedHashMap<>();
		if(this instanceof OtherW) {
			vague = (LinkedHashMap<String, Object>) ((OtherW) this).getDefvague();
		}
		else {
			vague.put("type", type.getNom());

			if(category==ECatW.recurrent){
				vague.put("priority", priority);
				vague.put("frequency", frequency);
				if(numwave!=0)vague.put("wave", numwave);
			}
			else {
				vague.put("wave", numwave);
			}

			if(monstres.size()==1) vague.put("monster", monstres.get(0).getMonstre().name());
			else {
				LinkedHashMap<String, Object> mapmonstres = new LinkedHashMap<>();
				for (int i=0;i<monstres.size();i++) {
					Monstre monster = monstres.get(i);
					mapmonstres.put(monster.getMonstre().name(), monster.getProbability());
				}
				vague.put("monsters", mapmonstres);
			}

			if(this instanceof DefaultW) {
				DefaultW wave = (DefaultW) this;
				if(wave.getGrowth()!=EGrowth.old) vague.put("growth", wave.getGrowth().name());
				if(wave.isFixed())vague.put("fixed", wave.isFixed());
			}
			else if(this instanceof SwarmW) {
				SwarmW wave = (SwarmW) this;
				if(wave.getAmount()==EAmount.low)vague.put("amount", wave.getAmount().getName());
			}
			else if(this instanceof BossW) {
				BossW wave = (BossW) this;
				if(!wave.getBossName().equals(""))vague.put("name", wave.getBossName());
				if(wave.getHealth()!=EHealth.medium)vague.put("health", wave.getHealth().name());
				vague.put("abilities", wave.getAbilities().toString());
				if(!wave.isAbility_announce())vague.put("ability-announce", wave.isAbility_announce());
				if(wave.getAbility_interval()!=3)vague.put("ability-interval", wave.getAbility_interval());
			}
		}

		//System.out.println(toString());
		//System.out.println();
		return vague;
	}

	public static Wave setWave(String nom, ECatW category, Map<String, Object> map){
		Wave wave;
		StringBuffer type = new StringBuffer(map.get("type").toString());
		type.replace(0, 1, type.substring(0, 1).toUpperCase());
		switch (ETypeW.valueOf(type.toString())) {
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
		default:
			wave = new OtherW(nom, map, ETypeW.valueOf(type.toString()));
			System.out.println("Les vagues Upgrade et Supply ne sont pas encore gérées !");
			break;
		}

		wave.setCategory(category);

		return wave;
	}

}
