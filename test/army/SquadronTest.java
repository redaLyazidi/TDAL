package army;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import soldier.ArmedUnit;
import soldier.ArmedUnitSoldier;
import soldier.SoldierType;

public class SquadronTest {

	private final static String[] array_soldierType = {"Infantryman", "Horseman", "Hero"};
	private final static String[] names = {"12 monkeys","Raving Rabbids","Norfolk Squadron","Hussards","La 7° compagnie"};

	private final static int nbcannonFodder = 100;
	private final static int twelveMonkeys = 12;
	
	private Squadron monkeys;
	private Squadron rabbids;
	private Squadron norfolk;
	private Squadron compagnie7;
	private Squadron montmirailleArmy;
	private List<ArmedUnit> cannonFodder;
	private List<Army> horsemen;
	
	private Army achille;
	
	private final static Army monkey0 = new ArmedUnitSoldier(SoldierType.Infantryman.toString(), "monkey0");
	private final static Army godefroy = new ArmedUnitSoldier(SoldierType.Horseman.toString(), "MontMiraille");
	private final static float monkeysStrike = twelveMonkeys * monkey0.strike();
	private final static float montmirailleStrike = nbcannonFodder * godefroy.strike();
	private final static float ravingrabbitsStrike = 50 * ( godefroy.strike() + monkey0.strike());
	private final static float logicalfullarmyStrike = monkeysStrike + montmirailleStrike + ravingrabbitsStrike;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}


	@Before
	public void setUp() throws Exception {
		achille = new ArmedUnitSoldier(SoldierType.Hero.toString(), "Achille");
		monkeys = new Squadron(names[0]);
		rabbids = new Squadron(names[1]);
		norfolk = new Squadron(names[2]);
		cannonFodder = new LinkedList<ArmedUnit>();
		montmirailleArmy = new Squadron(names[3]);
		compagnie7 = new Squadron(names[4]);
		
		horsemen = new LinkedList<Army>();
		System.out.println(SoldierType.Infantryman.toString().equals(SoldierType.Infantryman.toString()));
		for (int i = 0; i < nbcannonFodder; i++) 
			cannonFodder.add(new ArmedUnitSoldier(SoldierType.Infantryman.toString(), SoldierType.Infantryman.toString()+String.valueOf(i)));
		for (int i = 1; i <= twelveMonkeys; i++) 
			monkeys.addArmy(new ArmedUnitSoldier(SoldierType.Infantryman.toString(), "monkey"+i));
		for (int i = 0; i < nbcannonFodder; i++) {
			horsemen.add(new ArmedUnitSoldier(SoldierType.Horseman.toString(), "MontMiraille"+i));}
		for (int i = 0; i < nbcannonFodder; i++)
			rabbids.addArmy(new ArmedUnitSoldier(SoldierType.reverseOrdinal(i % 2).toString(), "raving rabbit"+i));
	}


	@Test
	public void testSquadronString() {
		Squadron randomarmy = new Squadron("random");
		assertEquals(randomarmy.getName(), "random");
		assertNotSame(randomarmy.getName(), "Random");
	}

	@Test
	public void testSquadronStringListOfArmy() {
		Squadron randomarmy = new Squadron("random",cannonFodder);
		assertTrue(randomarmy.strike() == cannonFodder.get(0).strike() * nbcannonFodder);
		assertTrue(randomarmy.getHealthPoints() == cannonFodder.get(0).getHealthPoints() * nbcannonFodder);
	}

	@Test
	public void testGetName() {
		assertEquals(names[0],monkeys.getName());
		assertEquals(names[1], rabbids.getName());
		assertEquals(names[2],norfolk.getName());
	}

	@Test
	public void testGetHealthPoints() {
		Squadron random = new Squadron("random");
		assertTrue(random.getHealthPoints() == 0);
		ArmedUnitSoldier ryan = new ArmedUnitSoldier(SoldierType.Infantryman.toString(), "ryan");
		random.addArmy(ryan);
		assertTrue( ryan.getHealthPoints() == random.getHealthPoints());
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
		assertTrue( "OMG they're alive!",norfolk.getHealthPoints() == 0);
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
		
		
		

		assertTrue(compagnie7.strike() == 0);
		
		assertTrue(monkeys.strike() == monkeysStrike);
		
		Army montmirailleArmy = new Squadron("horsemen");
		((Squadron) montmirailleArmy).addAllArmies(horsemen);

		assertTrue(monkeys.strike() == monkeysStrike);
		assertTrue(montmirailleArmy.strike() == montmirailleStrike);
		assertTrue(rabbids.strike() ==  ravingrabbitsStrike);
		
		compagnie7.addAllArmies(horsemen);
		compagnie7.addArmy(monkeys);
		compagnie7.addArmy(rabbids);
		assertTrue(compagnie7.strike() == logicalfullarmyStrike);
		compagnie7.removeAllArmies(horsemen);
		System.out.println("J'ai glissé chef!");
		assertTrue(compagnie7.strike() == logicalfullarmyStrike - montmirailleStrike );
		
		compagnie7.addArmy(montmirailleArmy);
		assertTrue(compagnie7.strike() == logicalfullarmyStrike);
		
		

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
