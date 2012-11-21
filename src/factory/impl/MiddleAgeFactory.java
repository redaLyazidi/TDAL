package factory.impl;

import soldier.ArmedUnit;
import soldier.SoldierType;
import weapon.WeaponType;
import factory.AbstractArmedUnitFactory;

public class MiddleAgeFactory extends AbstractArmedUnitFactory {

	private final static SoldierType infantryman = SoldierType.Infantryman;
	private final static SoldierType horseman = SoldierType.Horseman;
	
	@Override
	public ArmedUnit createInfantryman(String name) {
		return super.createArmedUnit(name, infantryman);
	}

	@Override
	public ArmedUnit createInfantrymanWithOffensiveWeapon(String name) {
		return createArmedUnitWithEquipment(name, infantryman, WeaponType.Sword);
	}

	@Override
	public ArmedUnit createInfantrymanWithDefensiveWeapon(String name) {
		return createArmedUnitWithEquipment(name, infantryman, WeaponType.Shield);
	}

	@Override
	public ArmedUnit createInfantrymanWithBothWeapon(String name) {
		ArmedUnit armedUnit = createInfantrymanWithOffensiveWeapon(name);
		addEquipment(armedUnit, WeaponType.Shield);
		return armedUnit;
	}

	@Override
	public ArmedUnit createHorseman(String name) {
		return super.createArmedUnit(name, horseman);
	}

	@Override
	public ArmedUnit createHorsemanWithOffensiveWeapon(String name) {
		return createArmedUnitWithEquipment(name, horseman, WeaponType.Sword);
	}

	@Override
	public ArmedUnit createHorsemanWithDefensiveWeapon(String name) {
		return createArmedUnitWithEquipment(name, horseman, WeaponType.Shield);
	}

	@Override
	public ArmedUnit createHorsemanWithBothWeapon(String name) {
		ArmedUnit armedUnit = createHorsemanWithOffensiveWeapon(name);
		addEquipment(armedUnit, WeaponType.Shield);
		return armedUnit;
	}



}
