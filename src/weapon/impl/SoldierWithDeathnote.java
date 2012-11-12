package weapon.impl;

import soldier.Soldier;
import weapon.SoldierArmed;

public class SoldierWithDeathnote extends SoldierArmed<Deathnote> {

	public SoldierWithDeathnote(Soldier s) {
		super(s, new Deathnote());
	}
}