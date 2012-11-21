package soldier.impl;

import soldier.SoldierAbstract;

public class Sith extends SoldierAbstract {
	//because when "LightSaber" is said lot of people think "Jedi".
	private static final int FORCE = 150;
	private static final int HEALTHPOINTS = 500;

	public Sith(String nom) {
		super(nom, HEALTHPOINTS, FORCE);
	}

	public void infuse_life() { // XXX resurrection allowed
		healthPoints = HEALTHPOINTS;
	}
	
	public void heal() {
		heal_inter(HEALTHPOINTS);
	}
}
