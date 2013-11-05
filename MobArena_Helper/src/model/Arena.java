package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;

import model.enums.ECatW;

public class Arena {
	private String nom;
	private ArenaConfig config;
	/**
	 * Les deux types de vagues existant pour une arène :
	 * 0 pour recurrent
	 * 1 pour single
	 */
	@SuppressWarnings("unchecked")
	private ArrayList<Wave>[] waves = new ArrayList[2];

	private LinkedHashMap<String, Object> rewards;
	private LinkedHashMap<String, Object> classlimits;
	private LinkedHashMap<String, Object> coords;

	/**
	 * Instancie une arène contenant des vagues, avec les deux catégories de vagues
	 * (soit recurrent soit single, voir enum ECatW). Extrait depuis arena toutes les
	 * vagues dans chaque liste de vague par catégorie, et les paramètres de l'arène.
	 * @param nom
	 * @param arena
	 */
	public Arena(String nom, LinkedHashMap<String,Object> arena){
		
		this.nom = nom;
		this.waves[0] = new ArrayList<Wave>();
		this.waves[1] = new ArrayList<Wave>();
		GestYaml garena = new GestYaml(arena);
		GestYaml gwaves = new GestYaml(garena.getMap("waves"));
		
		loadWaves(gwaves);
		config = new ArenaConfig(garena.getMap("settings"));
		
		this.rewards = garena.getMap("rewards");
		this.classlimits = garena.getMap("class-limits");
		this.coords = garena.getMap("coords");
		
		Collections.sort(waves[0]);
		Collections.sort(waves[1]);
		
	}
	
	/**
	 * Instance une arène seulement avec son nom, pour que l'utilisateur remplisse les
	 * autres données dans l'application.
	 * @param nom
	 */
	public Arena(String nom) {
		this.nom = nom;
		this.waves[0] = new ArrayList<Wave>();
		this.waves[1] = new ArrayList<Wave>();
		this.config = new ArenaConfig();
	}

	private void loadWaves(GestYaml gwaves) {
		for (Iterator<String> it = gwaves.getMap("recurrent").keySet().iterator(); it.hasNext();) {
			String wave = (String) it.next();
			this.waves[0].add(Wave.setWave(wave,ECatW.recurrent,gwaves.getMap("recurrent." + wave)));
		}
		for (Iterator<String> it = gwaves.getMap("single").keySet().iterator(); it.hasNext();) {
			String wave = (String) it.next();
			this.waves[1].add(Wave.setWave(wave,ECatW.single,gwaves.getMap("single." + wave)));
		}
	}

	public ArrayList<Wave> getWavesType(ECatW type){
		if(type.equals(ECatW.recurrent)){
			return waves[0];
		}
		else{
			return waves[1];
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArenaConfig getConfig() {
		return config;
	}

	public void setConfig(ArenaConfig config) {
		this.config = config;
	}

	public LinkedHashMap<String, Object> getMap() {
		LinkedHashMap<String, Object> arena = new LinkedHashMap<>();
		arena.put("settings", config.getMap());
		
		LinkedHashMap<String, Object> mapwaves = new LinkedHashMap<>();
		String[] catvague = {"recurrent", "single"};
		for(int i=0;i<2;i++){

			LinkedHashMap<String, Object> wavesbycat = new LinkedHashMap<>();
			for(int j=0;j<waves[i].size();j++){

				Wave wave = waves[i].get(j);
				wavesbycat.put(wave.getNom(), wave.getMap());

			}
			mapwaves.put(catvague[i], wavesbycat);

		}

		arena.put("waves", mapwaves);
		if(rewards!=null) arena.put("rewards", rewards);
		if (classlimits!=null) arena.put("class-limits", classlimits);
		if(coords!=null) arena.put("coords", coords);
		
		return arena;
	}
}