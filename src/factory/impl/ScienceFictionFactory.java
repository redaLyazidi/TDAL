package factory.impl;

import soldier.SoldierType;
import weapon.WeaponType;
import factory.AbstractArmedUnitFactory;

public class ScienceFictionFactory extends AbstractArmedUnitFactory {

		public ScienceFictionFactory() {
			super(SoldierType.Sith, SoldierType.SithOnOverBoard,
					WeaponType.Lightsaber, WeaponType.Force);
		}
}
