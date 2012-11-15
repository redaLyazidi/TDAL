package soldier.impl;

import army.VisitorArmy;
import soldier.SoldierAbstract;

public class Horseman extends SoldierAbstract {
	private static final int FORCE = 20;
	private static final int HEALTHPOINTS = 120;

	public Horseman(String name) {
		super(name, HEALTHPOINTS, FORCE);
	}

	public void infuse_life() { // XXX resurrection allowed
		healthPoints = HEALTHPOINTS;
	}

	public void heal() {
		heal_inter(HEALTHPOINTS);
	}

	public <T> T accept(VisitorArmy<T> visitor)
	{
		return visitor.visit(this);
	}
	
}