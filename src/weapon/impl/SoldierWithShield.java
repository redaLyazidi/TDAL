package weapon.impl;

import soldier.Soldier;
import weapon.SoldierArmedAbstract;
import army.ArmyVisitor;

public class SoldierWithShield extends SoldierArmedAbstract<Shield> {

	public SoldierWithShield(Soldier s) {
		super(s, new Shield());
	}
	
	public void accept(ArmyVisitor visitor)
	{
		visitor.visit(this);
	}
	
}
