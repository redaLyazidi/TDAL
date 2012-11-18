package weapon.impl;

import soldier.Soldier;
import weapon.SoldierArmedAbstract;

public class SoldierWithShield extends SoldierArmedAbstract<Shield> {

	public SoldierWithShield(Soldier s) {
		super(s, new Shield());	
	}
}
