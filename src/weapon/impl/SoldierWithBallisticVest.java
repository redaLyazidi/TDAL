package weapon.impl;

import soldier.Soldier;
import weapon.SoldierArmed;

public class SoldierWithBallisticVest extends SoldierArmed<BallisticVest> {

	public SoldierWithBallisticVest(Soldier s) {
		super(s, new BallisticVest());
	}
}
