package factory;

import soldier.ArmedUnit;

public interface ArmedUnitFactory {

	public ArmedUnit createInfantryman(String name);
	
	public ArmedUnit createInfantrymanWithOffensiveWeapon(String name);
	
	public ArmedUnit createInfantrymanWithDefensiveWeapon(String name);
	
	public ArmedUnit createInfantrymanWithBothWeapon(String name);
	
	
	public ArmedUnit createHorseman(String name);
	
	public ArmedUnit createHorsemanWithOffensiveWeapon(String name);
	
	public ArmedUnit createHorsemanWithDefensiveWeapon(String name);
	
	public ArmedUnit createHorsemanWithBothWeapon(String name);
}
