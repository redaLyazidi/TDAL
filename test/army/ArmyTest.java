package army;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArmyTest {

	private Army army;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		army = new Squadron("Main");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetName() {
		assertEquals(army.getName(), "Main");
		assertNotSame(army.getName(), "main");
	}

	@Test
	public void testGetHealthPoints() {
		fail("Not yet implemented");
	}

	@Test
	public void testAlive() {
		fail("Not yet implemented");
	}

	@Test
	public void testHeal() {
		fail("Not yet implemented");
	}

	@Test
	public void testParry() {
		fail("Not yet implemented");
	}

	@Test
	public void testStrike() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddEquipment() {
		fail("Not yet implemented");
	}

}
