package army;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import soldier.ArmedUnit;
import soldier.ArmedUnitSoldier;

public class SquadronTest {

	private final static String[] array_soldierType = {"InfantryMan", "Horseman", "Hero"};
	private final static String[] names = {"12 monkeys","Raving Rabbids","Norfolk Squadron"};

	private final static int nbcannonFodder = 100;

	private Squadron monkeys;
	private Squadron rabbids;
	private Squadron norfolk;

	private List<ArmedUnit> cannonFodder;

	private Army achille;



	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		achille = new ArmedUnitSoldier(array_soldierType[2], "Achille");
		monkeys = new Squadron(names[0]);
		rabbids = new Squadron(names[1]);
		norfolk = new Squadron(names[2]);
		cannonFodder = new LinkedList<ArmedUnit>();
		for (int i = 0; i < nbcannonFodder; i++) {
			cannonFodder.add(new ArmedUnitSoldier(array_soldierType[0], array_soldierType[0]+String.valueOf(i)));
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSquadronString() {
		fail("Not yet implemented");
	}

	@Test
	public void testSquadronStringListOfArmy() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetName() {
		assertEquals(names[0],monkeys.getName());
		assertEquals(names[1], rabbids.getName());
		assertEquals(names[2],norfolk.getName());
	}

	@Test
	public void testGetHealthPoints() {
		fail("Not yet implemented");
	}

	@Test
	public void testAlive() {
		assertFalse(norfolk.alive());
		norfolk.addAllArmies(cannonFodder);
		assertTrue(norfolk.alive());
		while (norfolk.alive()) {
			assertTrue(norfolk.alive());
			norfolk.parry(norfolk.strike());
		}
		assertFalse(norfolk.alive());
	}

	private void hardtraining(Squadron s) {
		while(s.alive())
			s.parry(s.strike());
	}

	@Test
	public void testHeal() { // add and remove also tested
		norfolk.addAllArmies(cannonFodder);
		float healthbefore = norfolk.getHealthPoints();
		norfolk.addArmy(achille);
		norfolk.parry(healthbefore);
		assertTrue(norfolk.alive());
		norfolk.heal();
		assertTrue(norfolk.getHealthPoints() == healthbefore + achille.getHealthPoints());

		assertTrue(norfolk.removeArmy(achille));
		assertTrue(norfolk.getHealthPoints() == healthbefore);
		norfolk.parry(healthbefore); //they're all dead
		assertTrue( norfolk.getHealthPoints() == 0);
		norfolk.heal();
		assertTrue( "OMG they're alive",norfolk.getHealthPoints() == 0);
	}

	@Test
	public void testInfuse_life() {
		norfolk.addAllArmies(cannonFodder);
		float healthbefore = norfolk.getHealthPoints();
		assertTrue(norfolk.alive());
		norfolk.parry(healthbefore);
		assertFalse(norfolk.alive());
		norfolk.infuse_life();
		assertTrue(norfolk.getHealthPoints() == healthbefore);
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



	@Test
	public void testAddAllArmies() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveAllArmies() {
		fail("Not yet implemented");
	}

}
