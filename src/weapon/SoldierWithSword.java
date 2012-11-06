package weapon;

import soldier.SoldierChecked;

public class SoldierWithSword extends SoldierArmed<Sword> {

	public SoldierWithSword(SoldierChecked s) {
		super(s, new Sword());
	}
	
}
