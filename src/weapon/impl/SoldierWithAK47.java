package weapon.impl;

import soldier.Soldier;
import weapon.SoldierArmedAbstract;
import army.VisitorArmy;

public class SoldierWithAK47 extends SoldierArmedAbstract<AK47> {

	public SoldierWithAK47(Soldier s) {
		super(s, new AK47());
	}
	
	public <T> T accept(VisitorArmy<T> visitor)
	{
		return visitor.visit(this);
	}
	
}
