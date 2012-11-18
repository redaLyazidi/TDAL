package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import soldier.ArmedUnit;
import soldier.impl.ArmedUnitSoldier;
import soldier.impl.UnknownSoldierTypeException;

public class TestUnitSoldier {
	ArmedUnit sf, sc;

	@Before
	public void setUp() throws Exception {
		sf = new ArmedUnitSoldier("Infantryman", "Gogol");
		sc = new ArmedUnitSoldier("Horseman", "Sanchez");
	}

	@Test(expected = UnknownSoldierTypeException.class)
	public void combat() {
		int i;
		for (i = 0; sf.parry(sc.strike()); i++) {
			;
		}
		assertEquals("Unexpected death of squad " + sf.getName(), i, 4);
		sf.infuse_life();
 		sf.addEquipment("Shield");
		for (i = 0; sf.parry(sc.strike()); i++) {
			;
		}
		assertEquals("Unexpected death of  " + sf.getName() + " with shield", i, 9);
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
