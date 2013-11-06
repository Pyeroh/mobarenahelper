package model;

import model.enums.EEnchantItem;
import model.enums.EEnchantment;
import model.lists.EnchantList;

/**
 * Un enchantement réel
 * @author Pyeroh
 * @see EEnchantment
 * @see EEnchantItem
 * @see EnchantList
 */
public class Enchantment {

	private EEnchantment enchantement;
	private int lvl;
	
	/**
	 * Instancie un enchantement avec la constante d'enchantement associée et le niveau voulu
	 * @param enchantement
	 * @param lvl
	 */
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
	
	/**
	 * Renvoie le code pour l'enchantement avec son niveau, afin de l'intégrer à la Map qui sera écrite dans le fichier de config.
	 * @return
	 */
	public String getString() {
		return enchantement.getEid()+":"+lvl;
	}
	
	@Override
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
