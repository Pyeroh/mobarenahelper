package model;

import java.util.LinkedHashMap;

import model.enums.EItem;
import model.item.AbstractItem;
import model.item.Item;

/**
 * Les paramètres de configuration d'une arène.
 * @author Pyeroh
 * @see Arena
 */
public class ArenaConfig {

	private String world = "world";
	private boolean enabled = true;
	private boolean protect = false;
	private float entry_fee_money = 0f;
	private AbstractItem entry_fee_item = null;
	private boolean clear_wave_before_next = false;
	private boolean clear_boss_before_next = false;
	private boolean clear_wave_before_boss = false;
	private boolean lightning = false;
	private boolean auto_equip_armor = false;
	private boolean soft_restore = false;
	private boolean soft_restore_drops = false;
	private boolean require_empty_inv_join = false;
	private boolean require_empty_inv_spec = false;
	private boolean hellhounds = false;
	private boolean pvp_enabled = false;
	private boolean monster_infight = false;
	private boolean allow_teleporting = false;
	private boolean spectate_on_death = false;
	private boolean auto_respawn = false;
	private boolean share_items_in_arena = false;
	private int min_players = 0;
	private int max_players = 0;
	private int max_join_distance = 0;
	private int first_wave_delay = 0;
	private int wave_interval = 0;
	private int final_wave = 0;
	private int monster_limit = 0;
	private boolean monster_exp = false;
	private boolean keep_exp = false;
	private boolean food_regen = false;
	private boolean lock_food_level = false;
	private boolean spout_class_select = false;
	private String player_time_in_arena = "world";
	private boolean auto_ignite_tnt = false;
	private int auto_start_timer = 0;
	private boolean display_waves_as_level = false;
	private boolean display_timer_as_level = false;
	private boolean auto_ready = false;
	private boolean use_scoreboards = false;
	private boolean use_class_chest = false;
	private boolean isolated_chat = false;
	private boolean global_end_announce = false;
	private boolean global_join_announce = false;
	
	private LinkedHashMap<String, Object> config;
	
	/**
	 * Constructeur avec une Map. Instancie les paramètres à la valeur qu'ils ont dans le fichier.
	 * @param config
	 */
	public ArenaConfig(LinkedHashMap<String, Object> config) {
		this.config = config;
		load();
	}
	
	/**
	 * Constructeur par défaut. Instancie tous les paramètres à une valeur par défaut.
	 */
	public ArenaConfig() {
	}

	private void load() {
		
		GestYaml g = new GestYaml(config);
		
		if(g.containsKey("world")) world = g.getString("world");
		if(g.containsKey("enabled")) enabled = g.getBool("enabled");
		if(g.containsKey("protect")) protect = g.getBool("protect");
		if(g.containsKey("entry-fee")) {
			String[] sItems = g.getString("entry-fee").split(",");
			if(sItems[0].equals("")) {
				entry_fee_money = 0f;
				entry_fee_item = null;
			}
			else if(sItems[0].matches("\\-?\\$\\ ?(0|([1-9](?:\\d{0,2}(?:,\\d{3})+|\\d*))?)(?:\\.\\d{1,2}|)")){
				entry_fee_money = Float.parseFloat(sItems[0].trim().substring(1));
				if(sItems.length>1) {
					if(sItems[1].trim().matches("[a-zA-Z]+:(\\d)+")){
						String[] item = sItems[1].trim().split(":");
						EItem eitem = EItem.valueOf(item[0]);
						int quantity =  item.length>1 ? Integer.parseInt(item[1]) : 1;
						entry_fee_item = new Item(eitem, quantity, null);
					}
				}
			}
		}
		if(g.containsKey("clear-wave-before-next")) clear_wave_before_next = g.getBool("clear-wave-before-next");
		if(g.containsKey("clear-boss-before-next")) clear_boss_before_next = g.getBool("clear-boss-before-next");
		if(g.containsKey("clear-wave-before-boss")) clear_wave_before_boss = g.getBool("clear-wave-before-boss");
		if(g.containsKey("lightning")) lightning = g.getBool("lightning");
		if(g.containsKey("auto-equip-armor")) auto_equip_armor = g.getBool("auto-equip-armor");
		if(g.containsKey("soft-restore")) soft_restore = g.getBool("soft-restore");
		if(g.containsKey("soft-restore-drops")) soft_restore_drops = g.getBool("soft-restore-drops");
		if(g.containsKey("require-empty-inv-join")) require_empty_inv_join = g.getBool("require-empty-inv-join");
		if(g.containsKey("require-empty-inv-spec")) require_empty_inv_spec = g.getBool("require-empty-inv-spec");
		if(g.containsKey("hellhounds")) hellhounds = g.getBool("hellhounds");
		if(g.containsKey("pvp-enabled")) pvp_enabled = g.getBool("pvp-enabled");
		if(g.containsKey("monster-infight")) monster_infight = g.getBool("monster-infight");
		if(g.containsKey("allow-teleporting")) allow_teleporting = g.getBool("allow-teleporting");
		if(g.containsKey("spectate-on-death")) spectate_on_death = g.getBool("spectate-on-death");
		if(g.containsKey("auto-respawn")) auto_respawn = g.getBool("auto-respawn");
		if(g.containsKey("share-items-in-arena")) share_items_in_arena = g.getBool("share-items-in-arena");
		if(g.containsKey("min-players")) min_players = g.getInt("min-players");
		if(g.containsKey("max-players")) max_players = g.getInt("max-players");
		if(g.containsKey("max-join-distance")) max_join_distance = g.getInt("max-join-distance");
		if(g.containsKey("first-wave-delay")) first_wave_delay = g.getInt("first-wave-delay");
		if(g.containsKey("wave-interval")) wave_interval = g.getInt("wave-interval");
		if(g.containsKey("final-wave")) final_wave = g.getInt("final-wave");
		if(g.containsKey("monster-limit")) monster_limit = g.getInt("monster-limit");
		if(g.containsKey("monster-exp")) monster_exp = g.getBool("monster-exp");
		if(g.containsKey("keep-exp")) keep_exp = g.getBool("keep-exp");
		if(g.containsKey("food-regen")) food_regen = g.getBool("food-regen");
		if(g.containsKey("lock-food-level")) lock_food_level = g.getBool("lock-food-level");
		if(g.containsKey("spout-class-select")) spout_class_select = g.getBool("spout-class-select");
		if(g.containsKey("player-time-in-arena")) player_time_in_arena = g.getString("player-time-in-arena");
		if(g.containsKey("auto-ignite-tnt")) auto_ignite_tnt = g.getBool("auto-ignite-tnt");
		if(g.containsKey("auto-start-timer")) auto_start_timer = g.getInt("auto-start-timer");
		if(g.containsKey("display-waves-as-level")) display_waves_as_level = g.getBool("display-waves-as-level");
		if(g.containsKey("display-timer-as-level")) display_timer_as_level = g.getBool("display-timer-as-level");
		if(g.containsKey("auto-ready")) auto_ready = g.getBool("auto-ready");
		if(g.containsKey("use-scoreboards")) use_scoreboards = g.getBool("use-scoreboards");
		if(g.containsKey("use-class-chests")) use_class_chest = g.getBool("use-class-chests");
		if(g.containsKey("isolated-chat")) isolated_chat = g.getBool("isolated-chat");
		if(g.containsKey("global-end-announce")) global_end_announce = g.getBool("global-end-announce");
		if(g.containsKey("global-join-announce")) global_join_announce = g.getBool("global-join-announce");
		
	}
	
	/**
	 * Renvoie la Map des informations de la configuration de l'arène.
	 * @return
	 */
	public LinkedHashMap<String,Object> getMap() {

		LinkedHashMap<String,Object> map = new LinkedHashMap<>();
		
		map.put("world", world);
		map.put("enabled", enabled);
		map.put("protect", protect);
		
		String fee = "  ";
		if(entry_fee_money!=0f) fee += "$"+entry_fee_money+", ";
		if(entry_fee_item!=null) fee += entry_fee_item.getString()+", ";
		
		map.put("entry-fee", fee.substring(0, fee.length()-2));
		map.put("clear-wave-before-next", clear_wave_before_next);
		map.put("clear-boss-before-next", clear_boss_before_next);
		map.put("clear-wave-before-boss", clear_wave_before_boss);
		map.put("lightning", lightning);
		map.put("auto-equip-armor", auto_equip_armor);
		map.put("soft-restore", soft_restore);
		map.put("soft-restore-drops", soft_restore_drops);
		map.put("require-empty-inv-join", require_empty_inv_join);
		map.put("require-empty-inv-spec", require_empty_inv_spec);
		map.put("hellhounds", hellhounds);
		map.put("pvp-enabled", pvp_enabled);
		map.put("monster-infight", monster_infight);
		map.put("allow-teleporting", allow_teleporting);
		map.put("spectate-on-death", spectate_on_death);
		map.put("auto-respawn", auto_respawn);
		map.put("share-items-in-arena", share_items_in_arena);
		map.put("min-players", min_players);
		map.put("max-players", max_players);
		map.put("max-join-distance", max_join_distance);
		map.put("first-wave-delay", first_wave_delay);
		map.put("wave-interval", wave_interval);
		map.put("final-wave", final_wave);
		map.put("monster-limit", monster_limit);
		map.put("monster-exp", monster_exp);
		map.put("keep-exp", keep_exp);
		map.put("food-regen", food_regen);
		map.put("lock-food-level", lock_food_level);
		map.put("spout-class-select", spout_class_select);
		map.put("player-time-in-arena", player_time_in_arena);
		map.put("auto-ignite-tnt", auto_ignite_tnt);
		map.put("auto-start-timer", auto_start_timer);
		map.put("display-waves-as-level", display_waves_as_level);
		map.put("display-timer-as-level", display_timer_as_level);
		map.put("auto-ready", auto_ready);
		map.put("use-scoreboards", use_scoreboards);
		map.put("use-class-chests", use_class_chest);
		map.put("isolated-chat", isolated_chat);
		map.put("global-end-announce", global_end_announce);
		map.put("global-join-announce", global_join_announce);
		
		return map;
	}

	public String getWorld() {return world;}

	public void setWorld(String world) {this.world = world;}

	public boolean getEnabled() {return enabled;}

	public void setEnabled(boolean enabled) {this.enabled = enabled;}

	public boolean getProtect() {return protect;}

	public void setProtect(boolean protect) {this.protect = protect;}

	public boolean getLightning() {return lightning;}

	public void setLightning(boolean lightning) {this.lightning = lightning;}

	public float getEntry_fee_money() {return entry_fee_money;}

	public void setEntry_fee_money(float entry_fee_money) {this.entry_fee_money = entry_fee_money;}

	public AbstractItem getEntry_fee_item() {return entry_fee_item;}

	public void setEntry_fee_item(AbstractItem entry_fee_item) {this.entry_fee_item = entry_fee_item;}

	public boolean getClear_wave_next() {return clear_wave_before_next;}

	public void setClear_wave_next(boolean clear_wave_next) {this.clear_wave_before_next = clear_wave_next;}

	public boolean getClear_boss_next() {return clear_boss_before_next;}

	public void setClear_boss_next(boolean clear_boss_next) {this.clear_boss_before_next = clear_boss_next;}

	public boolean getClear_wave_boss() {return clear_wave_before_boss;}

	public void setClear_wave_boss(boolean clear_wave_boss) {this.clear_wave_before_boss = clear_wave_boss;}

	public boolean getAuto_equip_armor() {return auto_equip_armor;}

	public void setAuto_equip_armor(boolean auto_equip_armor) {this.auto_equip_armor = auto_equip_armor;}

	public boolean getSoft_restore() {return soft_restore;}

	public void setSoft_restore(boolean soft_restore) {this.soft_restore = soft_restore;}

	public boolean getSoft_restore_drops() {return soft_restore_drops;}

	public void setSoft_restore_drops(boolean soft_restore_drops) {this.soft_restore_drops = soft_restore_drops;}

	public boolean getEmpty_inv_join() {return require_empty_inv_join;}

	public void setEmpty_inv_join(boolean empty_inv_join) {this.require_empty_inv_join = empty_inv_join;}

	public boolean getEmpty_inv_spec() {return require_empty_inv_spec;}

	public void setEmpty_inv_spec(boolean empty_inv_spec) {this.require_empty_inv_spec = empty_inv_spec;}

	public boolean getHellhounds() {return hellhounds;}

	public void setHellhounds(boolean hellhounds) {this.hellhounds = hellhounds;}

	public boolean getPvp_enabled() {return pvp_enabled;}

	public void setPvp_enabled(boolean pvp_enabled) {this.pvp_enabled = pvp_enabled;}

	public boolean getMonster_infight() {return monster_infight;}

	public void setMonster_infight(boolean monster_infight) {this.monster_infight = monster_infight;}

	public boolean getAllow_tp() {return allow_teleporting;}

	public void setAllow_tp(boolean allow_tp) {this.allow_teleporting = allow_tp;}

	public boolean getDeath_spec() {return spectate_on_death;}

	public void setDeath_spec(boolean death_spec) {this.spectate_on_death = death_spec;}

	public boolean getAuto_respawn() {return auto_respawn;}

	public void setAuto_respawn(boolean auto_respawn) {this.auto_respawn = auto_respawn;}

	public boolean getShare_items() {return share_items_in_arena;}

	public void setShare_items(boolean share_items) {this.share_items_in_arena = share_items;}

	public int getMin_players() {return min_players;}

	public void setMin_players(int min_players) {this.min_players = min_players;}

	public int getMax_players() {return max_players;}

	public void setMax_players(int max_players) {this.max_players = max_players;}

	public int getMax_join_distance() {return max_join_distance;}

	public void setMax_join_distance(int max_join_distance) {this.max_join_distance = max_join_distance;}

	public int getFirst_wave_delay() {return first_wave_delay;}

	public void setFirst_wave_delay(int first_wave_delay) {this.first_wave_delay = first_wave_delay;}

	public int getWave_interval() {return wave_interval;}

	public void setWave_interval(int wave_interval) {this.wave_interval = wave_interval;}

	public int getFinal_wave() {return final_wave;}

	public void setFinal_wave(int final_wave) {this.final_wave = final_wave;}

	public int getMonster_limit() {return monster_limit;}

	public void setMonster_limit(int monster_limit) {this.monster_limit = monster_limit;}

	public boolean getMonster_drop_xp() {return monster_exp;}

	public void setMonster_drop_xp(boolean monster_drop_xp) {this.monster_exp = monster_drop_xp;}

	public boolean getKeep_xp() {return keep_exp;}

	public void setKeep_xp(boolean keep_xp) {this.keep_exp = keep_xp;}

	public boolean getFood_regen() {return food_regen;}

	public void setFood_regen(boolean food_regen) {this.food_regen = food_regen;}

	public boolean getFood_level_lock() {return lock_food_level;}

	public void setFood_level_lock(boolean food_level_lock) {this.lock_food_level = food_level_lock;}

	public boolean getSpout_select() {return spout_class_select;}

	public void setSpout_select(boolean spout_select) {this.spout_class_select = spout_select;}

	public String getPlayer_time() {return player_time_in_arena;}

	public void setPlayer_time(String player_time) {this.player_time_in_arena = player_time;}

	public boolean getAuto_ignite_tnt() {return auto_ignite_tnt;}

	public void setAuto_ignite_tnt(boolean auto_ignite_tnt) {this.auto_ignite_tnt = auto_ignite_tnt;}

	public int getAuto_start() {return auto_start_timer;}

	public void setAuto_start(int auto_start) {this.auto_start_timer = auto_start;}

	public boolean getClass_chest() {return use_class_chest;}

	public void setClass_chest(boolean class_chest) {this.use_class_chest = class_chest;}

	public boolean getWaves_as_level() {return display_waves_as_level;}

	public void setWaves_as_level(boolean waves_as_level) {this.display_waves_as_level = waves_as_level;}

	public boolean getTimer_as_level() {return display_timer_as_level;}

	public void setTimer_as_level(boolean timer_as_level) {this.display_timer_as_level = timer_as_level;}

	public boolean getAuto_ready() {return auto_ready;}

	public void setAuto_ready(boolean auto_ready) {this.auto_ready = auto_ready;}

	public boolean getScoreboards() {return use_scoreboards;}

	public void setScoreboards(boolean scoreboards) {this.use_scoreboards = scoreboards;}

	public boolean getIsolated_chat() {return isolated_chat;}

	public void setIsolated_chat(boolean isolated_chat) {this.isolated_chat = isolated_chat;}

	public boolean getGlobal_end_announce() {return global_end_announce;}

	public void setGlobal_end_announce(boolean global_end_announce) {this.global_end_announce = global_end_announce;}

	public boolean getGlobal_join_announce() {return global_join_announce;}

	public void setGlobal_join_announce(boolean global_join_announce) {this.global_join_announce = global_join_announce;}
	
}
