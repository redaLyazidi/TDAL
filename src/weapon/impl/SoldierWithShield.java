package weapon.impl;

import soldier.Soldier;
import weapon.SoldierArmedAbstract;
import army.VisitorArmy;

public class SoldierWithShield extends SoldierArmedAbstract<Shield> {

	public SoldierWithShield(Soldier s) {
		super(s, new Shield());
	}
	
	public void accept(VisitorArmy visitor)
	{
		visitor.visit(this);
	}
	
}
