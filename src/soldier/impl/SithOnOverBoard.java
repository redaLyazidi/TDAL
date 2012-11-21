package soldier.impl;

import soldier.SoldierAbstract;

public class SithOnOverBoard extends SoldierAbstract{
	
	private static final int FORCE = 170;
	private static final int HEALTHPOINTS = 480;

	public SithOnOverBoard(String nom) {
		super(nom, HEALTHPOINTS, FORCE);
	}

	public void infuse_life() { // XXX resurrection allowed
		healthPoints = HEALTHPOINTS;
	}
	
	public void heal() {
		heal_inter(HEALTHPOINTS);
	}
}
