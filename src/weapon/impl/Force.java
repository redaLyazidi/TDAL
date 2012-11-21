package weapon.impl;

import weapon.WeaponAbstract;

public class Force extends WeaponAbstract {
	private static final float DEFENSE = 100;
	private static final float ATTACK = 90; //The best form of defense is attack
	private static final float RESISTANCE = 100;

	public Force() {
		super(DEFENSE, ATTACK, RESISTANCE);
	}

	public void fix() {
		resistance = RESISTANCE;
	}

}
