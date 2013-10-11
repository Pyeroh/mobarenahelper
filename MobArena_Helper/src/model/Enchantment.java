package model;

import model.enums.EEnchantment;

public class Enchantment {

	private EEnchantment enchantement;
	private int lvl;
	
	public Enchantment(EEnchantment enchantement, int lvl) {
		this.enchantement = enchantement;
		this.lvl = lvl;
	}

	public EEnchantment getEnchantement() {
		return enchantement;
	}

	public void setEnchantement(EEnchantment enchantement) {
		this.enchantement = enchantement;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	
}
