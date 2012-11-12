package weapon.impl;

import soldier.Soldier;
import weapon.SoldierArmedAbstract;
import army.ArmyVisitor;

public class SoldierWithSword extends SoldierArmedAbstract<Sword> {

	public SoldierWithSword(Soldier s) {
		super(s, new Sword());
	}
	
	public void accept(ArmyVisitor visitor)
	{
		visitor.visit(this);
	}
	
}
