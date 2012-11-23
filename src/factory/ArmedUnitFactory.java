package factory;

import soldier.ArmedUnit;

public interface ArmedUnitFactory {

	public ArmedUnit createInfantryman(String name);
	
	public ArmedUnit createInfantrymanWithOffensiveWeapon(String name);
	
	public ArmedUnit createInfantrymanWithDefensiveWeapon(String name);
	
	public ArmedUnit createInfantrymanWithBothWeapon(String name);
	
	
	public ArmedUnit createMobileUnit(String name);
	
	public ArmedUnit createMobileUnitWithOffensiveWeapon(String name);
	
	public ArmedUnit createMobileUnitWithDefensiveWeapon(String name);
	
	public ArmedUnit createMobileUnitWithBothWeapon(String name);
}
