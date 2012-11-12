package weapon.impl;

import army.VisitorArmy;
import soldier.Soldier;
import weapon.SoldierArmedAbstract;

public class SoldierWithDeathnote extends SoldierArmedAbstract<Deathnote> {

	public SoldierWithDeathnote(Soldier s) {
		super(s, new Deathnote());
	}

	public void accept(VisitorArmy visitor)
	{
		visitor.visit(this.soldier);
	}
}