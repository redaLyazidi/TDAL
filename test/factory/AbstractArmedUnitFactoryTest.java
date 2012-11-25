package factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import soldier.ArmedUnit;
import soldier.Soldier;
import soldier.SoldierType;
import soldier.impl.ArmedUnitSoldier;
import soldier.impl.Infantryman;
import soldier.impl.Sith;
import weapon.WeaponType;
import weapon.impl.SoldierWithLightsaber;
import weapon.impl.SoldierWithShield;
import weapon.impl.SoldierWithSword;
import factory.impl.MiddleAgeFactory;
import factory.impl.ScienceFictionFactory;

public class AbstractArmedUnitFactoryTest {

	
	private AbstractArmedUnitFactory middleAgeFactory = new MiddleAgeFactory();
	private AbstractArmedUnitFactory scienceFictionFactory = new ScienceFictionFactory();
	
	private ArmedUnit ma;
	private ArmedUnit sf;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateInfantryman() {
		ma = middleAgeFactory.createInfantryman("foobar");
		sf = scienceFictionFactory.createInfantryman("barfoo");
		assertEquals(ma.getName(), "foobar");
		assertEquals(sf.getName(), "barfoo");
		assertTrue(ma.getSoldier() instanceof Infantryman);
		assertTrue(sf.getSoldier() instanceof Sith);
	}

	@Test
	public void testCreateInfantrymanWithOffensiveWeapon() {
		ma = middleAgeFactory.createInfantrymanWithOffensiveWeapon("foobar");
		sf = scienceFictionFactory.createInfantrymanWithOffensiveWeapon("barfoo");
		testSoldierType();
		
		testOffensiveEquipment(ma.getSoldier(),sf.getSoldier());
	}

	@Test
	public void testCreateInfantrymanWithDefensiveWeapon() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateInfantrymanWithBothWeapon() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateMobileUnit() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateMobileUnitWithOffensiveWeapon() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateMobileUnitWithDefensiveWeapon() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateMobileUnitWithBothWeapon() {
		fail("Not yet implemented");
	}

	private void testSoldierType() {
		assertEquals(ma.getSoldierType(), SoldierType.Infantryman.toString());
		assertEquals(sf.getSoldierType(), SoldierType.Sith.toString());
	}
	
	private void testOffensiveEquipment(Soldier mas, Soldier sfs) {
		assertTrue(((ArmedUnitSoldier) ma).getEquipmentsLabel().contains(WeaponType.Sword.toString()));
		assertTrue(((ArmedUnitSoldier) sf).getEquipmentsLabel().contains(WeaponType.Lightsaber.toString()));
		assertTrue(mas instanceof SoldierWithSword);
		assertTrue(sfs instanceof SoldierWithLightsaber);
	}

	private void testDefensiveEquipment(Soldier mas, Soldier sfs) {
		assertTrue(((ArmedUnitSoldier) ma).getEquipmentsLabel().contains(WeaponType.Shield.toString()));
		assertTrue(((ArmedUnitSoldier) sf).getEquipmentsLabel().contains(WeaponType.Force.toString()));
		assertTrue(mas instanceof SoldierWithShield);
		assertTrue(sfs instanceof SoldierWithForce);
	}
}
