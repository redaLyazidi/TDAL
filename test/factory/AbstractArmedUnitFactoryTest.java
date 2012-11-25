package factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import soldier.ArmedUnit;
import soldier.Soldier;
import soldier.SoldierType;
import soldier.impl.ArmedUnitSoldier;
import soldier.impl.Horseman;
import soldier.impl.Infantryman;
import soldier.impl.Sith;
import soldier.impl.SithOnOverBoard;
import weapon.SoldierArmedAbstract;
import weapon.WeaponAbstract;
import weapon.WeaponType;
import weapon.impl.SoldierWithForce;
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
		testInfantryType();
		testOffensiveEquipment(ma.getSoldier(),sf.getSoldier());
	}

	@Test
	public void testCreateInfantrymanWithDefensiveWeapon() {
		ma = middleAgeFactory.createInfantrymanWithDefensiveWeapon("foobar");
		sf = scienceFictionFactory.createInfantrymanWithDefensiveWeapon("barfoo");
		testInfantryType();
		testDefensiveEquipment(ma.getSoldier(), sf.getSoldier());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testCreateInfantrymanWithBothWeapon() {
		ma = middleAgeFactory.createInfantrymanWithBothWeapon("foobar");
		sf = scienceFictionFactory.createInfantrymanWithBothWeapon("barfoo");
		testInfantryType();

		testDefensiveEquipment(ma.getSoldier(),sf.getSoldier());
		testOffensiveEquipment(((SoldierArmedAbstract<WeaponAbstract>) ma.getSoldier()).getSoldier(),
				((SoldierArmedAbstract<WeaponAbstract>) sf.getSoldier()).getSoldier());
	}

	@Test
	public void testCreateMobileUnit() {
		ma = middleAgeFactory.createMobileUnit("foobar");
		sf = scienceFictionFactory.createMobileUnit("barfoo");
		assertEquals(ma.getName(), "foobar");
		assertEquals(sf.getName(), "barfoo");
		assertTrue(ma.getSoldier() instanceof Horseman);
		assertTrue(sf.getSoldier() instanceof SithOnOverBoard);
	}

	@Test
	public void testCreateMobileUnitWithOffensiveWeapon() {
		ma = middleAgeFactory.createMobileUnitWithOffensiveWeapon("foobar");
		sf = scienceFictionFactory.createMobileUnitWithOffensiveWeapon("barfoo");
		testMobileUnitType();
		testOffensiveEquipment(ma.getSoldier(),sf.getSoldier());
	}

	@Test
	public void testCreateMobileUnitWithDefensiveWeapon() {
		ma = middleAgeFactory.createMobileUnitWithDefensiveWeapon("foobar");
		sf = scienceFictionFactory.createMobileUnitWithDefensiveWeapon("barfoo");
		testDefensiveEquipment(ma.getSoldier(), sf.getSoldier());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testCreateMobileUnitWithBothWeapon() {
		ma = middleAgeFactory.createMobileUnitWithBothWeapon("foobar");
		sf = scienceFictionFactory.createMobileUnitWithBothWeapon("barfoo");
		testMobileUnitType();

		testDefensiveEquipment(ma.getSoldier(),sf.getSoldier());
		testOffensiveEquipment(((SoldierArmedAbstract<WeaponAbstract>) ma.getSoldier()).getSoldier(),
				((SoldierArmedAbstract<WeaponAbstract>) sf.getSoldier()).getSoldier());
	}

	private void testInfantryType() {
		assertEquals(ma.getSoldierType(), SoldierType.Infantryman.toString());
		assertEquals(sf.getSoldierType(), SoldierType.Sith.toString());
	}

	private void testMobileUnitType() {
		assertEquals(ma.getSoldierType(), SoldierType.Horseman.toString());
		assertEquals(sf.getSoldierType(), SoldierType.SithOnOverBoard.toString());
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
