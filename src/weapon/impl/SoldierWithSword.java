package weapon.impl;

import soldier.Soldier;
import weapon.SoldierArmedAbstract;

public class SoldierWithSword extends SoldierArmedAbstract<Sword> {

	public SoldierWithSword(Soldier s) {
		super(s, new Sword());
	}
}
