package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Arenas;
import model.GestYaml;
import model.enums.ECatW;
import model.wave.UpgradeSet;
import model.wave.UpgradeW;

import org.junit.*;

public class UpgradeSetTest {

	private static GestYaml g;
	private static Arenas a;
	private ArrayList<UpgradeSet> upset1, upset2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		g = new GestYaml(UpgradeSetTest.class.getResourceAsStream("/gui/config.yml"));
		a = new Arenas(g.getMap("arenas"), g.getMap("global-settings"), g.getMap("classes"));
	}

	@Before
	public void setUp() throws Exception {
		upset1 = ((UpgradeW) a.getALarenas().get(0).getWavesType(ECatW.recurrent).get(3)).getUpgrades();
		upset2 = ((UpgradeW) a.getALarenas().get(0).getWavesType(ECatW.single).get(3)).getUpgrades();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetMap() {
		assertEquals(g.dump("arenas.default.waves.recurrent.upgrade1.upgrades.all"), upset1.get(0).getMap());
		assertNotEquals(g.dump("arenas.default.waves.recurrent.upgrade1.upgrades.all"), upset1.get(1).getMap());
		assertEquals(g.getMap("arenas.default.waves.single.upgrade2.upgrades.Knight"), upset2.get(1).getMap());
		assertNull(g.getMap("arenas.default.waves.single.upgrade2.upgrades.Knightt"));
		assertEquals(g.dump("arenas.default.waves.single.upgrade2.upgrades.Tank.items"), upset2.get(2).getMap());
	}

	@Test
	public void testSetUpgradeSet() {
		assertEquals(g.getMap("arenas.default.waves.single.upgrade2.upgrades.Knight"), UpgradeSet.setUpgradeSet("Knight", g.getMap("arenas.default.waves.single.upgrade2.upgrades")).getMap());
	}

}
