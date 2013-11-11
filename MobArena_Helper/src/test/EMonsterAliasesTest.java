package test;

import static org.junit.Assert.*;
import static model.enums.EMonsterAliases.*;

import org.junit.Test;

public class EMonsterAliasesTest {

	@Test
	public void testGetPlural() {
		assertEquals(giants, giant.getPlural());
		assertEquals(exploding_sheep, exploding_sheep.getPlural());
	}

}
