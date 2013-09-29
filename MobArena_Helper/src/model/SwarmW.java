package model;

import java.util.Map;

import model.enums.EAmount;
import model.enums.EMonsterAliases;
import model.enums.ETypeW;

public class SwarmW extends Wave{

	private EAmount amount = EAmount.low;

	public SwarmW(String nom) {
		super(nom, ETypeW.Swarm);
	}

	public EAmount getAmount() {
		return amount;
	}

	public void setAmount(EAmount amount) {
		this.amount = amount;
	}
	
	public String toString() {
		String ret = super.toString()
				+"\namount : "+amount.getNom();
		return ret;
	}

	public static SwarmW setWave(String nom, Map<String, Object> map){
		SwarmW wave = new SwarmW(nom);
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
		if(map.containsKey("amount")){
			wave.setAmount(EAmount.valueOf(g.getString("amount")));
		}
		wave.getMonstres().add(new Monstre(EMonsterAliases.valueOf(g.getString("monster")).getMonstre(),0));

		return wave;
	}

}
