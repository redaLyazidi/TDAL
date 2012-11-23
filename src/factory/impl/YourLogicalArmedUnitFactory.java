package factory.impl;

import soldier.SoldierType;
import weapon.WeaponType;
import factory.AbstractArmedUnitFactory;

public class YourLogicalArmedUnitFactory extends AbstractArmedUnitFactory {
// as you wish
	public YourLogicalArmedUnitFactory(SoldierType infantryman,
			SoldierType mobileUnit, WeaponType offensiveType,
			WeaponType defensiveType) {
		super(infantryman, mobileUnit, offensiveType, defensiveType);
	}

}
