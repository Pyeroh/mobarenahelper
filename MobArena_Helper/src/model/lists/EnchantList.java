package model.lists;

import java.util.ArrayList;

import model.Enchantment;

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
	
	

}
