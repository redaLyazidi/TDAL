package army;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import builder.BuilderType;

import soldier.ArmedUnit;
import soldier.SoldierType;
import soldier.impl.ArmedUnitSoldier;
import weapon.WeaponType;
import army.impl.Squadron;
import army.impl.VisitorArmyCount;
import army.impl.VisitorArmyStatement;

public class SquadronTest {

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

	private VisitorArmyCount visitorArmyCount = new VisitorArmyCount();

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
		montmirailleArmy.addAllArmies(horsemen);
		
		assertTrue(montmirailleArmy.accept(new VisitorArmyCount()) == nbcannonFodder);
		float fullHealth = montmirailleArmy.getHealthPoints();
		float force = 100;
		assertTrue(godefroy.parry(force) == montmirailleArmy.parry(force));
		godefroy.heal();
		assertTrue(montmirailleArmy.getHealthPoints() + force == fullHealth);
		for (Army a : horsemen) 
			assertTrue( a.getHealthPoints() == godefroy.getHealthPoints() - force/nbcannonFodder);
	}

	@Test
	public void testStrike() {
		assertTrue(compagnie7.strike() == 0);
		assertTrue(monkeys.strike() == monkeysStrike);

		Army montmirailleArmy = new Squadron("horsemen");
		assertTrue(montmirailleArmy.accept(visitorArmyCount) == 0);
		
		((Squadron) montmirailleArmy).addAllArmies(horsemen);

		assertTrue(montmirailleArmy.accept(visitorArmyCount) == nbcannonFodder);
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
		int compagnie7VisitResult = compagnie7.accept(visitorArmyCount);
		int sumOfothers = montmirailleArmy.accept(visitorArmyCount) + monkeys.accept(visitorArmyCount)
				+ rabbids.accept(visitorArmyCount);
		assertTrue(compagnie7VisitResult == sumOfothers);
	}

	@Test
	public void testAddEquipment() {
		Squadron random = new Squadron("random");
		random.addEquipment(WeaponType.Sword.toString());
		assertTrue(random.strike() == 0);

		montmirailleArmy.addAllArmies(horsemen);
		montmirailleArmy.addEquipment(WeaponType.Lightsaber.toString());
		ArmedUnitSoldier jediknight = new ArmedUnitSoldier(SoldierType.Horseman.toString(), "Obi-Wan");
		jediknight.addEquipment(WeaponType.Lightsaber.toString());

		assertTrue(montmirailleArmy.strike() == jediknight.strike() * nbcannonFodder);
	}



	@Test
	public void testAddAllArmies() {
		Squadron random = new Squadron("random");
		random.addAllArmies(cannonFodder);
		Army cannonFodderWrapper = new Squadron("HumainShield", cannonFodder);
		assertTrue( random.strike() == cannonFodderWrapper.strike());
		assertTrue(random.getHealthPoints() == cannonFodderWrapper.getHealthPoints());
		cannonFodderWrapper.parry(cannonFodderWrapper.getHealthPoints()/2);
		random.parry(cannonFodderWrapper.getHealthPoints()/2);
		assertTrue(random.getHealthPoints() == cannonFodderWrapper.getHealthPoints());
	}

	@Test
	public void testRemoveAllArmies() {
		float compagnie7Strike = compagnie7.strike();
		float compagnie7HealthPoints = compagnie7.getHealthPoints();
		compagnie7.removeAllArmies(horsemen);
		assertTrue(compagnie7.strike() + montmirailleArmy.strike() == compagnie7Strike);
		assertTrue(compagnie7.getHealthPoints() + montmirailleArmy.getHealthPoints() == compagnie7HealthPoints);
	}

	@Test
	public void testAccept() {
		VisitorArmyCount v = new VisitorArmyCount(SoldierType.Infantryman);
		assertTrue( monkeys.accept(v) == twelveMonkeys);
		v.setSoldierType(SoldierType.Horseman);
		assertTrue( monkeys.accept(v) == 0);
		
		Army montmirailleArmy = new Squadron("horsemen");
		rabbids.addEquipment(WeaponType.Deathnote.toString()); //it's safe with those guys
		((Squadron) montmirailleArmy).addAllArmies(horsemen);
		
		montmirailleArmy.addEquipment(WeaponType.Sword.toString());
		montmirailleArmy.addEquipment(WeaponType.Shield.toString());
		
		monkeys.addEquipment(WeaponType.AK47.toString());
		monkeys.addEquipment(WeaponType.BallisticVest.toString());
		
		
		
		compagnie7.addArmy(monkeys);
		compagnie7.addArmy(rabbids);
		compagnie7.addArmy(montmirailleArmy);
		
		VisitorArmyStatement visitorArmyStatement = new VisitorArmyStatement();
		compagnie7.accept(visitorArmyStatement);
		try {
			visitorArmyStatement.save(compagnie7.getName());
		} catch (IOException e) {
			System.out.println("No such a file");
			e.printStackTrace();
		}
		
		visitorArmyStatement.init();
		visitorArmyStatement.setStatement(BuilderType.HTML);
		compagnie7.accept(visitorArmyStatement);
		
		try {
			visitorArmyStatement.save(compagnie7.getName());
		} catch (IOException e) {
			System.out.println("No such a file");
			e.printStackTrace();
		}
	}

}
