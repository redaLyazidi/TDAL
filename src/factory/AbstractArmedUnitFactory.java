package factory;

import soldier.ArmedUnit;
import soldier.SoldierType;
import soldier.impl.ArmedUnitSoldier;
import weapon.WeaponType;

public abstract class AbstractArmedUnitFactory implements ArmedUnitFactory {

	protected SoldierType infantryman;
	protected SoldierType mobileUnit;
	
	protected WeaponType offensiveType;
	protected WeaponType defensiveType;
	
	public AbstractArmedUnitFactory(SoldierType infantryman,
			SoldierType mobileUnit, WeaponType offensiveType,
			WeaponType defensiveType) {
		super();
		this.infantryman = infantryman;
		this.mobileUnit = mobileUnit;
		this.offensiveType = offensiveType;
		this.defensiveType = defensiveType;
	}

	public SoldierType getInfantryman() {
		return infantryman;
	}

	public SoldierType getMobileUnit() {
		return mobileUnit;
	}

	public WeaponType getOffensiveType() {
		return offensiveType;
	}

	public WeaponType getDefensiveType() {
		return defensiveType;
	}
	
	@Override
	public ArmedUnit createInfantryman(String name) {
		return createArmedUnit(name, infantryman);
	}

	@Override
	public ArmedUnit createInfantrymanWithOffensiveWeapon(String name) {
		return createArmedUnitWithEquipment(name, infantryman, offensiveType);
	}

	@Override
	public ArmedUnit createInfantrymanWithDefensiveWeapon(String name) {
		return createArmedUnitWithEquipment(name, infantryman, defensiveType);
	}


	@Override
	public ArmedUnit createInfantrymanWithBothWeapon(String name) {
		ArmedUnit armedUnit = createInfantrymanWithOffensiveWeapon(name);
		addEquipment(armedUnit,defensiveType);
		return armedUnit;
	}

	@Override
	public ArmedUnit createMobileUnit(String name) {
		return new ArmedUnitSoldier(mobileUnit.toString(), name);
	}

	@Override
	public ArmedUnit createMobileUnitWithOffensiveWeapon(String name) {
		return createArmedUnitWithEquipment(name, mobileUnit, offensiveType);
	}

	@Override
	public ArmedUnit createMobileUnitWithDefensiveWeapon(String name) {
		return createArmedUnitWithEquipment(name, mobileUnit, defensiveType);
	}

	@Override
	public ArmedUnit createMobileUnitWithBothWeapon(String name) {
		ArmedUnit armedUnit = createMobileUnitWithOffensiveWeapon(name);
		addEquipment(armedUnit, defensiveType);
		return armedUnit;
	}

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
