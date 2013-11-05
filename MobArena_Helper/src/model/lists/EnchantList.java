package model.lists;

import java.util.ArrayList;

import model.Enchantment;
import model.enums.EEnchantment;

public class EnchantList extends ArrayList<Enchantment> {

	private static final long serialVersionUID = -8007639127841701265L;
	
	@Override
	public boolean contains(Object o) {
		Enchantment e = (Enchantment) o;
		int i = 0;
		while(i<size() && get(i).getEnchantement()!=e.getEnchantement()) i++;
		if(i==size()) return false;
		return true;
	}
	
	public void fill(String[] enchantments) {
		for (String enchant : enchantments) {
			String[] e_caracs = enchant.split(":");
			int id = Integer.parseInt(e_caracs[0]);
			int lvl = Integer.parseInt(e_caracs[1]);
			this.add(new Enchantment(
					EEnchantment.getById(id), lvl));
		}
	}
	
	public int indexofEEnchantment(EEnchantment e) {
		int index=-1, i=0;
		while(i<size() && get(i).getEnchantement()!=e) {
			i++;
		}
		if(i<this.size()) index = i;
		return index;
	}
	
	public ArrayList<EEnchantment> getEEnchantmentList() {
		ArrayList<EEnchantment> eenchantment = new ArrayList<>();
		for(int i=0;i<size();i++){
			eenchantment.add(get(i).getEnchantement());
		}
		return eenchantment;
	}

}
