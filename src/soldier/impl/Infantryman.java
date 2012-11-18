package soldier.impl;

import soldier.SoldierAbstract;

public class Infantryman extends SoldierAbstract {
	private static final int FORCE = 15;
	private static final int HEALTHPOINTS = 100;

	public Infantryman(String nom) {
		super(nom, HEALTHPOINTS, FORCE);
	}

	public void infuse_life() { // XXX resurrection allowed
		healthPoints = HEALTHPOINTS;
	}
	
	public void heal() {
		heal_inter(HEALTHPOINTS);
	}
	
}