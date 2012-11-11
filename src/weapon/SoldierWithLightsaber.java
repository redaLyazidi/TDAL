package weapon;

import soldier.Soldier;

public class SoldierWithLightsaber extends SoldierArmed<Lightsaber> {

	public SoldierWithLightsaber(Soldier s) {
		super(s, new Lightsaber());
	}

}
