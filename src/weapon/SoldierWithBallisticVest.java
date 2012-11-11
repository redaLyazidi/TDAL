package weapon;

import soldier.Soldier;

public class SoldierWithBallisticVest extends SoldierArmed<BallisticVest> {

	public SoldierWithBallisticVest(Soldier s) {
		super(s, new BallisticVest());
	}
}
