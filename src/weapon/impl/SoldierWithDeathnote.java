package weapon.impl;

import army.VisitorArmy;
import soldier.Soldier;
import weapon.SoldierArmedAbstract;

public class SoldierWithDeathnote extends SoldierArmedAbstract<Deathnote> {

	public SoldierWithDeathnote(Soldier s) {
		super(s, new Deathnote());
	}

	public <T> T accept(VisitorArmy<T> visitor)
	{
		return visitor.visit(this.soldier);
	}
}