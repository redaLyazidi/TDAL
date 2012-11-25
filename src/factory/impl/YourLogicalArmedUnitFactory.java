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
	

	public void setInfantryman(SoldierType infantryman) {
		this.infantryman = infantryman;
	}
	
	public void setInfantryman(String infantryman) {
		setInfantryman(SoldierType.valueOf(infantryman));
	}

	public void setMobileUnit(SoldierType mobileUnit) {
		this.mobileUnit = mobileUnit;
	}

	public void setMobileUnit(String mobileUnit) {
		setMobileUnit(SoldierType.valueOf(mobileUnit));
	}
	
	public void setOffensiveType(WeaponType offensiveType) {
		this.offensiveType = offensiveType;
	}

	public void setOffensiveType(String offensiveType) {
		setOffensiveType(WeaponType.valueOf(offensiveType));
	}
	
	public void setDefensiveType(WeaponType defensiveType) {
		this.defensiveType = defensiveType;
	}
	
	public void setDefensiveType(String defensiveType) {
		setDefensiveType(WeaponType.valueOf(defensiveType));
	}
}