package weapon.impl;

import weapon.WeaponAbstract;


public class AK47 extends WeaponAbstract {

	private static final float DEFENSE = 1;
	private static final float ATTACK = 100;
	private static final float RESISTANCE = 100;

	public AK47() {
		super(DEFENSE, ATTACK, RESISTANCE);
	}

	public void fix() {
		resistance = RESISTANCE;
	}
	

}
