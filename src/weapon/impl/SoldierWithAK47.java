package weapon.impl;

import soldier.Soldier;
import weapon.SoldierArmed;

public class SoldierWithAK47 extends SoldierArmed<AK47> {

	public SoldierWithAK47(Soldier s) {
		super(s, new AK47());
	}
}
