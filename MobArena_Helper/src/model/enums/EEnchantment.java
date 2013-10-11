package model.enums;

public enum EEnchantment {

	//Armor
	protection(0,4),
	fire_protection(1,0),
	feather_falling(2,0),
	blast_protection(3,0),
	projectile_protection(4,0),
	respiration(5,0),
	aqua_affinity(6,0),
	thorns(7,0),
	
	//Weapons
	sharpness(16,0),
	smite(17,0),
	bane_of_arthropods(18,0),
	knockback(19,0),
	fire_aspect(20,0),
	looting(21,0),
	
	//Tools
	efficiency(32,0),
	silk_touch(33,0),
	unbreaking(34,0),
	fortune(35,0),
	
	//Bow
	power(48,0),
	punch(49,0),
	flame(50,0),
	infinity(51,0),
	;

	private int eid;
	private int lvlmax;

	private EEnchantment(int eid, int lvlmax) {
		this.eid = eid;
		this.lvlmax = lvlmax;
	}

	public int getEid() {
		return eid;
	}

	public String getName() {
		
		return null;
	}

	public int getLvlmax() {
		return lvlmax;
	}

	public static EEnchantment getByName(String name) {

		if (name!=null) {
			EEnchantment[] values = values();
			int i = 0;
			while (i < values.length && !values[i].getName().equalsIgnoreCase(name)) {
				i++;
			}
			if (i < values.length) {
				return values[i];
			} else {
				throw new IllegalArgumentException(
						"No enum constant EEnchantment." + name);
			}
		}
		else {
			throw new NullPointerException("Name is null");
		}

	}

	public static EEnchantment getById(int id) {

		if(id!=0) {
			EEnchantment[] values = values();
			int i = 0;
			while(i < values.length && values[i].getEid()!=id) {
				i++;
			}
			if(i < values.length) {
				return values[i];
			}
			else {
				throw new IllegalArgumentException(
						"No enum constant EEnchantment for id " + id);
			}
		}
		else {
			throw new NullPointerException("EID invalid");
		}

	}

}
