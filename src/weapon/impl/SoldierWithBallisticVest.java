package weapon.impl;

import soldier.Soldier;
import weapon.SoldierArmedAbstract;
import army.VisitorArmy;

public class SoldierWithBallisticVest extends SoldierArmedAbstract<BallisticVest> {

	public SoldierWithBallisticVest(Soldier s) {
		super(s, new BallisticVest());
	}
	
	public <T> T accept(VisitorArmy<T> visitor)
	{
		return visitor.visit(this);
	}
	
}
