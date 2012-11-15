package weapon.impl;

import soldier.Soldier;
import weapon.SoldierArmedAbstract;
import army.VisitorArmy;

public class SoldierWithSword extends SoldierArmedAbstract<Sword> {

	public SoldierWithSword(Soldier s) {
		super(s, new Sword());
	}
	
	public <T> T accept(VisitorArmy<T> visitor)
	{
		return visitor.visit(this);
	}
	
}
