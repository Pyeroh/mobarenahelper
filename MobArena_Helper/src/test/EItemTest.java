package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import static model.enums.EItem.*;
import model.enums.*;

import org.junit.*;

public class EItemTest {

	private static EItem[] values;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		values = values();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		values = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetName() {
		for(int i=0;i<values.length;i++) {
			String real = values[i].name();
			String name = real.replaceFirst("^l_", "light_").replaceFirst("^p_", "potion_of_").replaceFirst("^s_p_", "splash_potion_of_").replaceFirst("_ext", "_extended").replace('_', ' ').trim();
			String first = ""+name.charAt(0);
			name = name.replaceFirst("^[a-z]", first.toUpperCase());
			assertEquals(values[i].getGuiName(), name);
		}
	}

	@Test
	public void testToString() {
		for(int i=0;i<values.length;i++) {
			EItem e = values[i];
			String tostring = e.name()+"("+e.getId()+","+e.getMeta()+","+e.getRealName()+","+e.getCategory()+")";
			assertEquals(e.toString(), tostring);
		}
	}

	@Test
	public void testGetByCategory() {
		EItemCat[] cats = EItemCat.values();
		for (int j = 1; j < cats.length; j++) {
			ArrayList<EItem> items = new ArrayList<EItem>();
			for (int i = 0; i < values.length; i++) {
				EItem item = values[i];
				if (item.getCategory() == cats[j]) {
					items.add(item);
				}
			}
			assertEquals(items, getByCategory(cats[j]));
		}
	}

	@Test
	public void testSearchByStringInt() {
		assertEquals(ink_sack, searchBy("ink_sack", 0));
		assertNull(searchBy("ink_sack", 16));
		assertNull(searchBy(null, 0));
		assertNull(searchBy("inksack", -1));

	}

	@Test
	public void testSearchByIntInt() {
		assertEquals(ink_sack, searchBy(351, 0));
		assertEquals(l_green_dye, searchBy(351, 10));
		assertNull(searchBy(0, 0));
		assertNull(searchBy(2000, 0));
	}

	@Test
	public void testSearchByString() {
		assertTrue(searchBy("").size()!=0);
		assertTrue(searchBy("wool").size()!=0);
		assertTrue(searchBy(null).size()==0);
		assertTrue(searchBy("bachibouzouk").size()==0);
	}

}
