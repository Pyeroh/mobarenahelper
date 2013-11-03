package model;

import java.util.LinkedHashMap;

import model.enums.EItem;

public class ArenaConfig {

	private String world;
	private boolean enabled;
	private boolean protect;
	private int entry_fee_money;
	private Item entry_fee_item;
	private boolean clear_wave_next;
	private boolean clear_boss_next;
	private boolean clear_wave_boss;
	private boolean lightning;
	private boolean auto_equip_armor;
	private boolean soft_restore;
	private boolean soft_restore_drops;
	private boolean empty_inv_join;
	private boolean empty_inv_spec;
	private boolean hellhounds;
	private boolean pvp_enabled;
	private boolean monster_infight;
	private boolean allow_tp;
	private boolean death_spec;
	private boolean auto_respawn;
	private boolean share_items;
	private int min_players;
	private int max_players;
	private int max_join_distance;
	private int first_wave_delay;
	private int wave_interval;
	private int final_wave;
	private int monster_limit;
	private boolean monster_drop_xp;
	private boolean keep_xp;
	private boolean food_regen;
	private boolean food_level_lock;
	private boolean spout_select;
	private String player_time;
	private boolean auto_ignite_tnt;
	private int auto_start;
	private boolean waves_as_level;
	private boolean timer_as_level;
	private boolean auto_ready;
	private boolean scoreboards;
	private boolean class_chest;
	private boolean isolated_chat;
	private boolean global_end_announce;
	private boolean global_join_announce;
	
	private LinkedHashMap<String, Object> config;
	
	public ArenaConfig(LinkedHashMap<String, Object> config) {
		
		this.config = config;
		load();
		
	}
	
	private void load() {
		
		GestYaml g = new GestYaml(config);
		
		if(g.containsKey("world")) world = g.getString("world");
		if(g.containsKey("enabled")) enabled = g.getBool("enabled");
		if(g.containsKey("protect")) protect = g.getBool("protect");
		if(g.containsKey("entry-fee")) {
			String[] sItems = g.getString("entry-fee").split(",");
			if(sItems[0].equals("")) {
				entry_fee_money = 0;
				entry_fee_item = null;
			}
			else if(sItems[0].matches("\\$(\\d)+")){
				entry_fee_money = Integer.parseInt(sItems[0].trim().substring(1));
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
		if(g.containsKey("clear-wave-before-next")) clear_wave_next = g.getBool("clear-wave-before-next");
		if(g.containsKey("clear-boss-before-next")) clear_boss_next = g.getBool("clear-boss-before-next");
		if(g.containsKey("clear-wave-before-boss")) clear_wave_boss = g.getBool("clear-wave-before-boss");
		if(g.containsKey("lightning")) lightning = g.getBool("lightning");
		if(g.containsKey("auto-equip-armor")) auto_equip_armor = g.getBool("auto-equip-armor");
		if(g.containsKey("soft-restore")) soft_restore = g.getBool("soft-restore");
		if(g.containsKey("soft-restore-drops")) soft_restore_drops = g.getBool("soft-restore-drops");
		if(g.containsKey("require-empty-inv-join")) empty_inv_join = g.getBool("require-empty-inv-join");
		if(g.containsKey("require-empty-inv-spec")) empty_inv_spec = g.getBool("require-empty-inv-spec");
		if(g.containsKey("hellhounds")) hellhounds = g.getBool("hellhounds");
		if(g.containsKey("pvp-enabled")) pvp_enabled = g.getBool("pvp-enabled");
		if(g.containsKey("monster-infight")) monster_infight = g.getBool("monster-infight");
		if(g.containsKey("allow-teleporting")) allow_tp = g.getBool("allow-teleporting");
		if(g.containsKey("spectate-on-death")) death_spec = g.getBool("spectate-on-death");
		if(g.containsKey("auto-respawn")) auto_respawn = g.getBool("auto-respawn");
		if(g.containsKey("share-items-in-arena")) share_items = g.getBool("share-items-in-arena");
		if(g.containsKey("min-players")) min_players = g.getInt("min-players");
		if(g.containsKey("max-players")) max_players = g.getInt("max-players");
		if(g.containsKey("max-join-distance")) max_join_distance = g.getInt("max-join-distance");
		if(g.containsKey("first-wave-delay")) first_wave_delay = g.getInt("first-wave-delay");
		if(g.containsKey("wave-interval")) wave_interval = g.getInt("wave-interval");
		if(g.containsKey("final-wave")) final_wave = g.getInt("final-wave");
		if(g.containsKey("monster-limit")) monster_limit = g.getInt("monster-limit");
		if(g.containsKey("monster-exp")) monster_drop_xp = g.getBool("monster-exp");
		if(g.containsKey("keep-exp")) keep_xp = g.getBool("keep-exp");
		if(g.containsKey("food-regen")) food_regen = g.getBool("food-regen");
		if(g.containsKey("lock-food-level")) food_level_lock = g.getBool("lock-food-level");
		if(g.containsKey("spout-class-select")) spout_select = g.getBool("spout-class-select");
		if(g.containsKey("player-time-in-arena")) player_time = g.getString("player-time-in-arena");
		if(g.containsKey("auto-ignite-tnt")) auto_ignite_tnt = g.getBool("auto-ignite-tnt");
		if(g.containsKey("auto-start-timer")) auto_start = g.getInt("auto-start-timer");
		if(g.containsKey("display-waves-as-level")) waves_as_level = g.getBool("display-waves-as-level");
		if(g.containsKey("display-timer-as-level")) timer_as_level = g.getBool("display-timer-as-level");
		if(g.containsKey("auto-ready")) auto_ready = g.getBool("auto-ready");
		if(g.containsKey("use-scoreboards")) scoreboards = g.getBool("use-scoreboards");
		if(g.containsKey("use-class-chests")) class_chest = g.getBool("use-class-chests");
		if(g.containsKey("isolated-chat")) isolated_chat = g.getBool("isolated-chat");
		if(g.containsKey("global-end-announce")) global_end_announce = g.getBool("global-end-announce");
		if(g.containsKey("global-join-announce")) global_join_announce = g.getBool("global-join-announce");
		
	}
	
	public LinkedHashMap<String,Object> getMap() {
		//TODO à faire
		
		return null;
	}

	public String getWorld() {return world;}

	public void setWorld(String world) {this.world = world;}

	public boolean isEnabled() {return enabled;}

	public void setEnabled(boolean enabled) {this.enabled = enabled;}

	public boolean isProtect() {return protect;}

	public void setProtect(boolean protect) {this.protect = protect;}

	public boolean isLightning() {return lightning;}

	public void setLightning(boolean lightning) {this.lightning = lightning;}

	public int getEntry_fee_money() {return entry_fee_money;}

	public void setEntry_fee_money(int entry_fee_money) {this.entry_fee_money = entry_fee_money;}

	public Item getEntry_fee_item() {return entry_fee_item;}

	public void setEntry_fee_item(Item entry_fee_item) {this.entry_fee_item = entry_fee_item;}

	public boolean isClear_wave_next() {return clear_wave_next;}

	public void setClear_wave_next(boolean clear_wave_next) {this.clear_wave_next = clear_wave_next;}

	public boolean isClear_boss_next() {return clear_boss_next;}

	public void setClear_boss_next(boolean clear_boss_next) {this.clear_boss_next = clear_boss_next;}

	public boolean isClear_wave_boss() {return clear_wave_boss;}

	public void setClear_wave_boss(boolean clear_wave_boss) {this.clear_wave_boss = clear_wave_boss;}

	public boolean isAuto_equip_armor() {return auto_equip_armor;}

	public void setAuto_equip_armor(boolean auto_equip_armor) {this.auto_equip_armor = auto_equip_armor;}

	public boolean isSoft_restore() {return soft_restore;}

	public void setSoft_restore(boolean soft_restore) {this.soft_restore = soft_restore;}

	public boolean isSoft_restore_drops() {return soft_restore_drops;}

	public void setSoft_restore_drops(boolean soft_restore_drops) {this.soft_restore_drops = soft_restore_drops;}

	public boolean isEmpty_inv_join() {return empty_inv_join;}

	public void setEmpty_inv_join(boolean empty_inv_join) {this.empty_inv_join = empty_inv_join;}

	public boolean isEmpty_inv_spec() {return empty_inv_spec;}

	public void setEmpty_inv_spec(boolean empty_inv_spec) {this.empty_inv_spec = empty_inv_spec;}

	public boolean isHellhounds() {return hellhounds;}

	public void setHellhounds(boolean hellhounds) {this.hellhounds = hellhounds;}

	public boolean isPvp_enabled() {return pvp_enabled;}

	public void setPvp_enabled(boolean pvp_enabled) {this.pvp_enabled = pvp_enabled;}

	public boolean isMonster_infight() {return monster_infight;}

	public void setMonster_infight(boolean monster_infight) {this.monster_infight = monster_infight;}

	public boolean isAllow_tp() {return allow_tp;}

	public void setAllow_tp(boolean allow_tp) {this.allow_tp = allow_tp;}

	public boolean isDeath_spec() {return death_spec;}

	public void setDeath_spec(boolean death_spec) {this.death_spec = death_spec;}

	public boolean isAuto_respawn() {return auto_respawn;}

	public void setAuto_respawn(boolean auto_respawn) {this.auto_respawn = auto_respawn;}

	public boolean isShare_items() {return share_items;}

	public void setShare_items(boolean share_items) {this.share_items = share_items;}

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

	public boolean isMonster_drop_xp() {return monster_drop_xp;}

	public void setMonster_drop_xp(boolean monster_drop_xp) {this.monster_drop_xp = monster_drop_xp;}

	public boolean isKeep_xp() {return keep_xp;}

	public void setKeep_xp(boolean keep_xp) {this.keep_xp = keep_xp;}

	public boolean isFood_regen() {return food_regen;}

	public void setFood_regen(boolean food_regen) {this.food_regen = food_regen;}

	public boolean isFood_level_lock() {return food_level_lock;}

	public void setFood_level_lock(boolean food_level_lock) {this.food_level_lock = food_level_lock;}

	public boolean isSpout_select() {return spout_select;}

	public void setSpout_select(boolean spout_select) {this.spout_select = spout_select;}

	public String getPlayer_time() {return player_time;}

	public void setPlayer_time(String player_time) {this.player_time = player_time;}

	public boolean isAuto_ignite_tnt() {return auto_ignite_tnt;}

	public void setAuto_ignite_tnt(boolean auto_ignite_tnt) {this.auto_ignite_tnt = auto_ignite_tnt;}

	public int getAuto_start() {return auto_start;}

	public void setAuto_start(int auto_start) {this.auto_start = auto_start;}

	public boolean isClass_chest() {return class_chest;}

	public void setClass_chest(boolean class_chest) {this.class_chest = class_chest;}

	public boolean isWaves_as_level() {return waves_as_level;}

	public void setWaves_as_level(boolean waves_as_level) {this.waves_as_level = waves_as_level;}

	public boolean isTimer_as_level() {return timer_as_level;}

	public void setTimer_as_level(boolean timer_as_level) {this.timer_as_level = timer_as_level;}

	public boolean isAuto_ready() {return auto_ready;}

	public void setAuto_ready(boolean auto_ready) {this.auto_ready = auto_ready;}

	public boolean isScoreboards() {return scoreboards;}

	public void setScoreboards(boolean scoreboards) {this.scoreboards = scoreboards;}

	public boolean isIsolated_chat() {return isolated_chat;}

	public void setIsolated_chat(boolean isolated_chat) {this.isolated_chat = isolated_chat;}

	public boolean isGlobal_end_announce() {return global_end_announce;}

	public void setGlobal_end_announce(boolean global_end_announce) {this.global_end_announce = global_end_announce;}

	public boolean isGlobal_join_announce() {return global_join_announce;}

	public void setGlobal_join_announce(boolean global_join_announce) {this.global_join_announce = global_join_announce;}
	
}
