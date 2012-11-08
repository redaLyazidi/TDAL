package army;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import soldier.ArmedUnitSoldier;

public class ArmyTest {

	private Army army;
	private final static int nb_horseman = 100;
	private final static int nb_infantry = 100;
	
	private final static String[] array_soldierType= {"InfantryMan", "Horseman"};
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		army = new Squadron("Main");
		System.out.println(array_soldierType[0]);
		Army armedsoldier = new ArmedUnitSoldier(array_soldierType[0], array_soldierType[0]+"Ref");
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
		for (int i = 0; i < nb_horseman; i++)
			((Squadron) army).addArmy(new ArmedUnitSoldier("Horseman", String.valueOf(i)));
		//Army armedsoldier = new ArmedUnitSoldier(array_soldierType[0], array_soldierType[0]+"Ref");
		//System.out.println(armedsoldier.getHealthPoints());
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
