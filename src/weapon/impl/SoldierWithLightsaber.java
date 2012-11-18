package weapon.impl;

import soldier.Soldier;
import weapon.SoldierArmedAbstract;

public class SoldierWithLightsaber extends SoldierArmedAbstract<Lightsaber> {

	public SoldierWithLightsaber(Soldier s) {
		super(s, new Lightsaber());
	}
}
