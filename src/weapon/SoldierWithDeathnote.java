package weapon;

import soldier.Soldier;

public class SoldierWithDeathnote extends SoldierArmed<Deathnote> {

	public SoldierWithDeathnote(Soldier s) {
		super(s, new Deathnote());
	}
}