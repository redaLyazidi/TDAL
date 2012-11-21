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
		ArmedUnit armedUnit = createHorseman(name);
		armedUnit.addEquipment(WeaponType.Sword.toString());
		return armedUnit;
	}

	@Override
	public ArmedUnit createInfantrymanWithDefensiveWeapon(String name) {
		ArmedUnit armedUnit = createInfantryman(name);
		armedUnit.addEquipment(WeaponType.Shield.toString());
		return armedUnit;
	}

	@Override
	public ArmedUnit createInfantrymanWithBothWeapon(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArmedUnit createHorseman(String name) {
		return super.createArmedUnit(name, horseman);
	}

	@Override
	public ArmedUnit createHorsemanWithOffensiveWeapon(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArmedUnit createHorsemanWithDefensiveWeapon(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArmedUnit createHorsemanWithBothWeapon(String name) {
		// TODO Auto-generated method stub
		return null;
	}



}
