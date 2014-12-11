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

	public ArrayList<EPotionEffect> getEPEList() {
		ArrayList<EPotionEffect> list = new ArrayList<EPotionEffect>();
		for (PotionEffect potionEffect : this) {
			list.add(potionEffect.getPotionEffect());
		}
		return list;
	}

	/**
	 * Permet de trier la liste
	 */
	public void sort() {
		int size = this.size();
		triRapide(this, 0, size - 1);
	}

	private int partition(PotionEffectList list, int deb, int fin) {
		int compt = deb;
		PotionEffect pivot = list.get(deb);

		for (int i = deb + 1; i <= fin; i++) {
			EPotionEffect litem = list.get(i).getPotionEffect();
			EPotionEffect pivitem = pivot.getPotionEffect();
			if ((litem.getId() < pivitem.getId())) {
				compt++;
				echanger(list, compt, i);
			}
		}
		echanger(list, deb, compt);
		return compt;
	}

	protected void triRapide(PotionEffectList list, int deb, int fin) {
		if (deb < fin) {
			int positionPivot = partition(list, deb, fin);
			triRapide(list, deb, positionPivot - 1);
			triRapide(list, positionPivot + 1, fin);
		}
	}

	protected void echanger(PotionEffectList list, int deb, int fin) {
		PotionEffect temp = list.get(deb);
		list.set(deb, list.get(fin));
		list.set(fin, temp);
	}

}
