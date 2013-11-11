package test;

import static model.enums.EEnchantItem.*;
import static model.enums.EItem.*;
import static org.junit.Assert.*;
import model.enums.EEnchantment;

import org.junit.Test;

public class EEnchantItemTest {

	private EEnchantment[] evalues = EEnchantment.values();

	@Test
	public void testGetByEnchant() {
		for(int i=0;i<evalues.length;i++) {
			assertTrue(getByEnchant(evalues[i]).size()!=0);
		}
	}

	@Test
	public void testGetByItem() {
		assertTrue(getByItem(diamond_axe).size()!=0);
		assertTrue(getByItem(diamond).size()==0);
	}

}
