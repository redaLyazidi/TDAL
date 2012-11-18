package weapon.impl;

import soldier.Soldier;
import weapon.SoldierArmedAbstract;

public class SoldierWithBallisticVest extends SoldierArmedAbstract<BallisticVest> {

	public SoldierWithBallisticVest(Soldier s) {
		super(s, new BallisticVest());
	}

}
