package factory.impl;

import soldier.ArmedUnit;
import soldier.SoldierType;
import soldier.impl.ArmedUnitSoldier;
import factory.ArmedUnitFactory;
import weapon.WeaponType;

public class MiddleAgeFactory implements ArmedUnitFactory {

	@Override
	public ArmedUnit createInfantryman(String name) {
		return new ArmedUnitSoldier(SoldierType.Infantryman.toString(), name);
	}

	@Override
	public ArmedUnit createInfantrymanWithOffensiveWeapon(String name) {
		ArmedUnit armedUnit = createHorseman(name);
		armedUnit.addEquipment(WeaponType.Sword.toString());
		return armedUnit;
	}

	@Override
	public ArmedUnit createInfantrymanWithDefensiveWeapon(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArmedUnit createInfantrymanWithBothWeapon(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArmedUnit createHorseman(String name) {
		// TODO Auto-generated method stub
		return null;
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
