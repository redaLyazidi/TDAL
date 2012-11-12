package weapon.impl;

import soldier.Soldier;
import weapon.SoldierArmedAbstract;
import army.VisitorArmy;

public class SoldierWithSword extends SoldierArmedAbstract<Sword> {

	public SoldierWithSword(Soldier s) {
		super(s, new Sword());
	}
	
	public void accept(VisitorArmy visitor)
	{
		visitor.visit(this);
	}
	
}
