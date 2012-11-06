package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import soldier.*;
import weapon.*;

public class TestUnitSoldier {
	SoldierChecked si, sc, si_sh, si_sw, si_multiple;

	@Before
	public void setUp() throws Exception {
		si = new InfantryMan("Gogol");
		sc = new Horseman("Sanchez");
	}

	@Test
	public void combat() {
		int i;
		for (i = 0; si.parry(sc.strike()); i++) {
			System.out.println("health of " + si.getName() +  " : " + si.getHealthPoints());
		}
		assertEquals("Unexpected death of soldier " + si.getName(), i, 4);

		si.heal();  //resurrection
		si_sh = new SoldierWithShield(si);
		for (i = 0; si_sh.parry(sc.strike()); i++) {
			System.out.println("health of " + si_sh.getName() + " : " +  si_sh.getHealthPoints());
		}; 
		assertEquals("Unexpected death of  " + si_sh.getName() + " with shield", i, 9);

		si_sh.heal(); //resurrection
		si_sw = new SoldierWithSword(si_sh);
		for (i = 0; si_sw.parry(sc.strike()); i++) {
			System.out.println("health of " + si_sw.getName() + " : " +  si_sw.getHealthPoints());	
		}
		assertEquals("Unexpected death of " + si_sw.getName() + " with shield and sword", i, 11);

		si.heal();
		for (i = 0; sc.parry(si_sw.strike()); i++) { 	
			System.out.println("health of " + sc.getName() + " : " +  sc.getHealthPoints());
		}
		assertEquals("Unexpected death of " + sc.getName(), i, 3);		
	}

	// Tests for rules of decoration
	@Test(expected = BreakingRuleException.class)
	public void tooManyDecorations1() {
		si_multiple = new SoldierWithShield(new SoldierWithShield(si));
	}
	
	@Test(expected = BreakingRuleException.class)
	public void tooManyDecorations2() {
		si_multiple = new SoldierWithSword(new SoldierWithSword(si));
	}

	@Test 
	public void notTooManyDecorations1() {
		si_multiple = new SoldierWithShield(new SoldierWithSword(si));
		assert(true);
	}
	
	@Test 
	public void notTooManyDecorations2() {
		si_multiple = new SoldierWithSword(new SoldierWithShield(si));
		assert(true);
	}
	
	
}

