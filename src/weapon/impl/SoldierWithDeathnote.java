package weapon.impl;

import soldier.Soldier;
import weapon.SoldierArmedAbstract;

public class SoldierWithDeathnote extends SoldierArmedAbstract<Deathnote> {

	public SoldierWithDeathnote(Soldier s) {
		super(s, new Deathnote());
	}
}