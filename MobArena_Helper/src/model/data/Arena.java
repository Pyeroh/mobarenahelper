package model.data;

import java.io.Serializable;
import java.util.*;

import model.GestYaml;
import model.enums.ECatW;
import model.enums.ERewardType;
import model.exceptions.ArenaException;
import model.lists.ClassLimitList;
import model.lists.RewardList;

/**
 * Une arène. Contient des vagues uniques, récurrentes, peut accorder des récompenses... Une arène quoi.
 *
 * @author Pyeroh
 * @see ArenaConfig
 */
public class Arena implements Serializable {

	private static final long serialVersionUID = 2943266301926154528L;

	private String nom;

	private ArenaConfig config;

	/**
	 * Les deux types de vagues existant pour une arène : 0 pour recurrent 1 pour single
	 */
	@SuppressWarnings("unchecked")
	private ArrayList<Wave>[] waves = new ArrayList[2];

	private ClassLimitList limits = new ClassLimitList();

	/**
	 * Les deux types de récompense de vague existant pour une arène : 0 pour every 1 pour after
	 */
	private RewardList[] rewards = new RewardList[2];

	private Coordinates coords = null;

	/**
	 * Instancie une arène contenant des vagues, avec les deux catégories de vagues (soit recurrent soit single, voir
	 * enum ECatW). Extrait depuis arena toutes les vagues dans chaque liste de vague par catégorie, et les paramètres
	 * de l'arène.
	 *
	 * @param nom
	 * @param arena
	 * @throws ArenaException
	 */
	public Arena(String nom, LinkedHashMap<String, Object> arena) throws ArenaException {

		this.nom = nom;
		this.waves[0] = new ArrayList<Wave>();
		this.waves[1] = new ArrayList<Wave>();
		GestYaml garena = new GestYaml(arena);
		GestYaml gwaves = garena.getGest("waves");

		loadWaves(gwaves);
		config = new ArenaConfig(garena.getMap("settings"));

		if (garena.containsKey("class-limits")) {
			loadLimits(new GestYaml(garena.getMap("class-limits")));
		}
		this.rewards[0] = new RewardList();
		this.rewards[1] = new RewardList();
		if (garena.containsKey("rewards")) {
			if (garena.containsKey("rewards.waves.every"))
				this.rewards[0].fill(garena.getMap("rewards.waves.every"), ERewardType.every);
			if (garena.containsKey("rewards.waves.after"))
				this.rewards[1].fill(garena.getMap("rewards.waves.after"), ERewardType.after);
		}
		if (garena.containsKey("coords")) {
			try {
				this.coords = new Coordinates(garena.getGest("coords"));
			}
			catch (Exception e) {
				this.coords = null;
			}
		}
		Collections.sort(waves[0]);
		Collections.sort(waves[1]);

	}

	/**
	 * Instance une arène seulement avec son nom, pour que l'utilisateur remplisse les autres données dans
	 * l'application.
	 *
	 * @param nom
	 */
	public Arena(String nom) {
		this.nom = nom;
		this.waves[0] = new ArrayList<Wave>();
		this.waves[1] = new ArrayList<Wave>();
		this.rewards[0] = new RewardList();
		this.rewards[1] = new RewardList();
		this.config = new ArenaConfig();
	}

	private void loadWaves(GestYaml gwaves) throws ArenaException {
		if (gwaves.containsKey("recurrent")) {
			for (Iterator<String> it = gwaves.getMap("recurrent").keySet().iterator(); it.hasNext();) {
				String wave = (String) it.next();
				this.waves[0].add(Wave.setWave(wave, ECatW.recurrent, gwaves.getMap("recurrent." + wave)));
			}
		}
		if (gwaves.containsKey("single")) {
			for (Iterator<String> it = gwaves.getMap("single").keySet().iterator(); it.hasNext();) {
				String wave = (String) it.next();
				this.waves[1].add(Wave.setWave(wave, ECatW.single, gwaves.getMap("single." + wave)));
			}
		}
	}

	private void loadLimits(GestYaml glimits) throws ArenaException {
		ArrayList<Classe> classe_list = Classe.classe_list;
		for (int i = 1; i < classe_list.size(); i++) {
			String classname = classe_list.get(i).getName();
			if (glimits.containsKey(classname))
				limits.add(new ClassLimit(classe_list.get(i), glimits.getInt(classname)));
			else
				limits.add(new ClassLimit(classe_list.get(i), -1));
		}
	}

	/**
	 * Renvoie la liste de vagues correspondant à la catégorie passée en paramètre
	 *
	 * @param type
	 *            le type de vagues attendu
	 * @return les vagues récurrentes si {@link ECatW#recurrent}, uniques si {@link ECatW#single}.
	 */
	public ArrayList<Wave> getWavesType(ECatW type) {
		if (type == ECatW.recurrent)
			return waves[0];
		else
			return waves[1];
	}

	public RewardList getRewardsType(ERewardType type) {
		if (type == ERewardType.every)
			return rewards[0];
		else
			return rewards[1];
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

	public Coordinates getCcoords() {
		return coords;
	}

	public int getClassLimit(Classe classe) {
		ClassLimit cl = limits.get(classe);
		if (cl != null)
			return cl.getLimit();
		else
			return -1;
	}

	public void setClassLimit(Classe classe, int limit) {
		ClassLimit cl = limits.get(classe);
		if (cl != null)
			cl.setLimit(limit);
		else
			limits.add(new ClassLimit(classe, limit));
	}

	protected void addClass(Classe classe) {
		limits.add(new ClassLimit(classe, -1));
	}

	protected void removeClass(Classe classe) {
		limits.remove(limits.get(classe));
	}

	/**
	 * Renvoie la map des informations de l'arène.
	 *
	 * @return
	 * @throws ArenaException
	 */
	public LinkedHashMap<String, Object> getMap() throws ArenaException {
		LinkedHashMap<String, Object> arena = new LinkedHashMap<String, Object>();
		arena.put("settings", config.getMap());

		LinkedHashMap<String, Object> mapwaves = new LinkedHashMap<String, Object>();
		String[] catvague = { "recurrent", "single" };
		for (int i = 0; i < 2; i++) {

			LinkedHashMap<String, Object> wavesbycat = new LinkedHashMap<String, Object>();
			for (int j = 0; j < waves[i].size(); j++) {

				Wave wave = waves[i].get(j);
				wavesbycat.put(wave.getNom().toLowerCase(), wave.getMap());

			}
			if (waves[i].size() != 0) {
				mapwaves.put(catvague[i], wavesbycat);
			}

		}
		if (!mapwaves.isEmpty())
			arena.put("waves", mapwaves);

		LinkedHashMap<String, Object> maprewards = new LinkedHashMap<String, Object>();
		String[] typreward = { "every", "after" };
		for (int i = 0; i < 2; i++) {

			LinkedHashMap<String, Object> rewardsbytyp = new LinkedHashMap<String, Object>();
			for (int j = 0; j < rewards[i].size(); j++) {

				Reward reward = rewards[i].get(j);
				rewardsbytyp.put(reward.getWave_number() + "", reward.getRewards().getString());

			}
			if (rewards[i].size() != 0) {
				maprewards.put(typreward[i], rewardsbytyp);
			}

		}
		if (!maprewards.isEmpty()) {
			LinkedHashMap<String, Object> r1 = new LinkedHashMap<String, Object>();
			r1.put("waves", maprewards);
			arena.put("rewards", r1);
		}
		if (coords != null) {
			arena.put("coords", coords.getMap());
		}
		if (!limits.isEmpty()) {
			arena.put("class-limits", limits.getMap());
		}

		return arena;
	}

}