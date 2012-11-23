package factory.impl;

import soldier.SoldierType;
import weapon.WeaponType;
import factory.AbstractArmedUnitFactory;

public class PresentArmedunitFactory extends AbstractArmedUnitFactory {

	public PresentArmedunitFactory() {
		super(infantryman, mobileUnit, offensiveType, defensiveType);
	}

}
