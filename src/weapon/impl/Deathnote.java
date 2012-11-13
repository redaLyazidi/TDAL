package weapon.impl;

import weapon.WeaponAbstract;

public class Deathnote extends WeaponAbstract {
	private static final float DEFENSE = 0;
	private static final float ATTACK = Float.MAX_VALUE;
	private static final float RESISTANCE = 0;

	public Deathnote() {
		super(DEFENSE, ATTACK, RESISTANCE);
	}

	@Override
	public float getStrikeValue() {
		return attack;
	}
	public void fix() {
		resistance = RESISTANCE;
	}

}
