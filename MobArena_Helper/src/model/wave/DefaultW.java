package model.wave;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import model.GestYaml;
import model.Monstre;
import model.Wave;
import model.enums.ECatW;
import model.enums.EGrowth;
import model.enums.EMonsterAliases;
import model.enums.ETypeW;

/**
 * Une vague par d�faut, spawn de monstres choisis parmi une liste al�atoirement, et croissance du nombre de monstres � chaque vague.
 * @author Pyeroh
 * @see Wave
 */
public class DefaultW extends Wave{

	private EGrowth growth = EGrowth.old;
	private boolean fixed = false;

	public DefaultW(String nom) {
		super(nom, ETypeW.Default);
	}
	
	public DefaultW(ECatW category) {
		super("New Wave", ETypeW.Default);
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
		String ret = super.toString()
				+"\ngrowth : "+growth.getNom()
				+"\nfixed : "+fixed;
		return ret;
	}

	@Override
	public LinkedHashMap<String, Object> getMap() {
		LinkedHashMap<String, Object> vague = super.getMap();
		if(this.getGrowth()!=EGrowth.old) vague.put("growth", this.getGrowth().name());
		if(this.isFixed())vague.put("fixed", this.isFixed());
		
		return vague;
	}

	/**
	 * {@link Wave#setWave(String, ECatW, LinkedHashMap)}
	 * @param nom le nom de la vague
	 * @param map la map d'informations de la vague
	 * @return la map d'informations de la vague
	 */
	public static DefaultW setWave(String nom, LinkedHashMap<String, Object> map){
		DefaultW wave = new DefaultW(nom);
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
		if(map.containsKey("growth")){
			wave.setGrowth(EGrowth.valueOf(g.getString("growth")));
		}
		if(map.containsKey("fixed")){
			wave.setFixed(g.getBool("fixed"));
		}
		if(map.containsKey("monsters")){
			Set<String> monsters = g.getMap("monsters").keySet();
			for (Iterator<String> it = monsters.iterator(); it.hasNext();) {
				String monstre = (String) it.next();
				wave.getMonstres().add(new Monstre(EMonsterAliases.valueOf(monstre).getMonstre(), g.getInt("monsters."+monstre)));
			}
		}

		return wave;
	}

}
