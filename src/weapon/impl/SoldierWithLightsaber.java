package weapon.impl;

import soldier.Soldier;
import weapon.SoldierArmed;

public class SoldierWithLightsaber extends SoldierArmed<Lightsaber> {

	public SoldierWithLightsaber(Soldier s) {
		super(s, new Lightsaber());
	}

}
