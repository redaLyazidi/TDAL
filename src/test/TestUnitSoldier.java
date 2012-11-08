package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import soldier.ArmedUnit;
import soldier.ArmedUnitSoldier;
import soldier.UnknownSoldierTypeException;

public class TestUnitSoldier {
	ArmedUnit sf, sc;

	@Before
	public void setUp() throws Exception {
		sf = new ArmedUnitSoldier("InfantryMan", "Gogol");
		sc = new ArmedUnitSoldier("Horseman", "Sanchez");
	}

	@Test(expected = UnknownSoldierTypeException.class)
	public void combat() {
		int i;
		for (i = 0; sf.parry(sc.strike()); i++) {
			;
		}
		assertEquals("Unexpected death of squad " + sf.getName(), i, 4);
		System.out.println("avant le 1° infuse_life");
		sf.infuse_life();
		System.out.println("apres le 1° infuse_life");
 		sf.addEquipment("Shield");
		for (i = 0; sf.parry(sc.strike()); i++) {
			;
		}
		assertEquals("Unexpected death of  " + sf.getName() + " with shield", i, 9);
		System.out.println("avant le 2° infuse_life");
		sf.infuse_life();
		sf.addEquipment("Sword");
		for (i = 0; sf.parry(sc.strike()); i++) {
			;
		}
		assertEquals("Unexpected death of " + sf.getName() + " with shield and sword", i, 11);
 		 
        sf.infuse_life();
		for (i = 0; sc.parry(sf.strike()); i++) {
			;
		}
		assertEquals("Unexpected death of " + sc.getName(), i, 3);
 
 		new ArmedUnitSoldier("Poilu", "Gogol"); //exception raised : unknown soldier type
	}
}
