package weapon.impl;

import soldier.Soldier;
import weapon.SoldierArmedAbstract;

public class SoldierWithForce extends SoldierArmedAbstract<Shield> {

	public SoldierWithForce(Soldier s) {
		super(s, new Shield());	
	}
}
