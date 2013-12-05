package test;

import static org.junit.Assert.*;
import model.GestYaml;

import org.junit.BeforeClass;
import org.junit.Test;

public class GestYamlTest {

	private static GestYaml g;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		GestYaml.S_gestionnaire = new GestYaml(GestYamlTest.class.getResourceAsStream("/gui/config.yml"));
		g = GestYaml.S_gestionnaire;
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBool() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMap() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTagString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTag() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGest() {
		fail("Not yet implemented");
	}

	@Test
	public void testDump() {
		fail("Not yet implemented");
	}

	@Test
	public void testDumpString() {
		fail("Not yet implemented");
	}

	@Test
	public void testDumpAsFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testContainsKey() {
		assertTrue(g.containsKey("classes.Knight"));
	}

}
