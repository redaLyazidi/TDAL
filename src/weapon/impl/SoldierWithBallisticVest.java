package weapon.impl;

import soldier.Soldier;
import weapon.SoldierArmedAbstract;
import army.VisitorArmy;

public class SoldierWithBallisticVest extends SoldierArmedAbstract<BallisticVest> {

	public SoldierWithBallisticVest(Soldier s) {
		super(s, new BallisticVest());
	}
	
	public void accept(VisitorArmy visitor)
	{
		visitor.visit(this.soldier);
	}
	
}
