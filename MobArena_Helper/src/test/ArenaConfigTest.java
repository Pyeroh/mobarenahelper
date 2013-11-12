package test;

import static org.junit.Assert.*;
import model.ArenaConfig;
import model.GestYaml;

import org.junit.*;

public class ArenaConfigTest {

	private static GestYaml g;
	private ArenaConfig ac;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		g = new GestYaml(UpgradeSetTest.class.getResourceAsStream("/gui/config.yml"));
	}
	
	@Before
	public void setUp() throws Exception {
		ac = new ArenaConfig(g.getMap("arenas.default.settings"));
	}
	
	@After
	public void tearDown() throws Exception {
		ac = null;
	}

	@Test
	public void testArenaConfigLinkedHashMapOfStringObject() {
		assertNotNull(ac);
		assertEquals(g.getString("arenas.default.settings.entry-fee"), "$"+ac.getEntry_fee_money());
	}
	
	@Test
	public void testGetMap() {
		assertNotNull(ac.getMap());
	}

}
