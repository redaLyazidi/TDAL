package weapon.impl;

import army.VisitorArmy;
import soldier.Soldier;
import weapon.SoldierArmedAbstract;

public class SoldierWithLightsaber extends SoldierArmedAbstract<Lightsaber> {

	public SoldierWithLightsaber(Soldier s) {
		super(s, new Lightsaber());
	}

	public <T> T accept(VisitorArmy<T> visitor)
	{
		return visitor.visit(this.soldier);
	}

}
