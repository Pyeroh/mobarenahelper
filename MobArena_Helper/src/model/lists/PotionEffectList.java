package model.lists;

import java.util.ArrayList;

import model.data.PotionEffect;
import model.enums.EPotionEffect;


public class PotionEffectList extends ArrayList<PotionEffect> {

	private static final long serialVersionUID = 8299342195198549800L;

	public void fill(String potions) {
		String[] tabPotions = potions.replace(" ", "").split(",");
		for (String potion : tabPotions) {
			PotionEffect pe = null;
			EPotionEffect potionEffect;
			String[] potionComponent = potion.split(":");
			if (potionComponent[0].matches("\\d+")) {
				potionEffect = EPotionEffect.searchById(Integer.parseInt(potionComponent[0]));
			}
			else {
				potionEffect = EPotionEffect.getByRealName(potionComponent[0]);
			}
			switch (potionComponent.length) {
			case 1:
				pe = new PotionEffect(potionEffect);
				break;
			case 2:
				pe = new PotionEffect(potionEffect, Integer.parseInt(potionComponent[1]));
				break;
			case 3:
				pe = new PotionEffect(potionEffect, Integer.parseInt(potionComponent[1]), Integer.parseInt(potionComponent[2]));
				break;
			}

			add(pe);
		}
	}

	public String getString() {
		StringBuffer sPE = new StringBuffer();
		for (int i = 0; i < this.size(); i++) {
			sPE.append(this.get(i).getString() + ", ");
		}
		int length = sPE.length();
		sPE.delete(length - 2, length);

		return sPE.toString().trim();
	}

	public int indexOfEPE(EPotionEffect ePotionEffect) {
		int index = -1;
		for (int i = 0; i < size(); i++) {
			if (get(i).getPotionEffect() == ePotionEffect) {
				index = i;
			}
		}
		return index;
	}

}
