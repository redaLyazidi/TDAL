package factory.impl;

import soldier.SoldierType;
import weapon.WeaponType;
import factory.AbstractArmedUnitFactory;

public class MiddleAgeFactory extends AbstractArmedUnitFactory {

	public MiddleAgeFactory() {
		super(SoldierType.Infantryman, SoldierType.Horseman,
				WeaponType.Sword, WeaponType.Shield);
	}
}
