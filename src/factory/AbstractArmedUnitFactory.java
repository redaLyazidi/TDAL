package factory;

import soldier.ArmedUnit;
import soldier.SoldierType;
import soldier.impl.ArmedUnitSoldier;
import weapon.WeaponType;

public abstract class AbstractArmedUnitFactory implements ArmedUnitFactory {

	
	protected ArmedUnit createArmedUnit(String name, SoldierType soldierType) {
		return new ArmedUnitSoldier(soldierType.toString(), name);
	}

	protected ArmedUnit createArmedUnitWithEquipment(String name, SoldierType soldierType, WeaponType weaponType) {
		ArmedUnit armedUnit = new ArmedUnitSoldier(soldierType.toString(), name);
		addEquipment(armedUnit, weaponType);
		return armedUnit;
	}
	
	protected void addEquipment(ArmedUnit armedUnit,WeaponType weaponType) {
		if (weaponType != null) 
			armedUnit.addEquipment(weaponType.toString());
	}

}
