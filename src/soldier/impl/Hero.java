package soldier.impl;

import soldier.SoldierAbstract;
import army.VisitorArmy;

public class Hero extends SoldierAbstract {

	private static final int FORCE = 120;
	private static final int HEALTHPOINTS = 1200;

	public Hero(String name) {
		super(name, HEALTHPOINTS, FORCE);
	}

	public void infuse_life() { // XXX resurrection allowed
		healthPoints = HEALTHPOINTS;
	}

	public void heal() {
		heal_inter(HEALTHPOINTS);
	}
	
	@Override
	public boolean parry(float force) {
		return super.parry(force);
	}
	
	public <T> T accept(VisitorArmy<T> visitor)
	{
		return visitor.visit(this);
	}
	
}
