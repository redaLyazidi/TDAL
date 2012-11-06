package weapon;

import soldier.SoldierChecked;

public class SoldierWithShield extends SoldierArmed<Shield> {

	public SoldierWithShield(SoldierChecked s) {
		super(s, new Shield());
	}

}
