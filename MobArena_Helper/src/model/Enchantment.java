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
	
	public String getString() {
		return enchantement.getEid()+":"+lvl;
	}
	
	public String toString() {
		String sLvl;
		switch (this.lvl) {
		case 1:
			sLvl = "I";
			break;
		case 2:
			sLvl = "II";
			break;
		case 3:
			sLvl = "III";
			break;
		case 4:
			sLvl = "IV";
			break;
		case 5:
			sLvl = "V";
			break;
		default:
			sLvl = "";
			break;
		}
		return enchantement.getName()+" "+sLvl;
	}
	
}
