package weapon;

import soldier.Soldier;

public class SoldierWithAK47 extends SoldierArmed<AK47> {

	public SoldierWithAK47(Soldier s) {
		super(s, new AK47());
	}
}
