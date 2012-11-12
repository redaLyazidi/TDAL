package weapon.impl;

import army.VisitorArmy;
import soldier.Soldier;
import weapon.SoldierArmedAbstract;

public class SoldierWithLightsaber extends SoldierArmedAbstract<Lightsaber> {

	public SoldierWithLightsaber(Soldier s) {
		super(s, new Lightsaber());
	}

	public void accept(VisitorArmy visitor)
	{
		visitor.visit(this.soldier);
	}

}
