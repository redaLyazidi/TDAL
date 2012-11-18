package weapon.impl;

import soldier.Soldier;
import weapon.SoldierArmedAbstract;

public class SoldierWithAK47 extends SoldierArmedAbstract<AK47> {

	public SoldierWithAK47(Soldier s) {
		super(s, new AK47());
	}	
}
