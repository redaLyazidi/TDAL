package soldier;

import util.ALObservable;


public abstract class SoldierAbstract extends ALObservable implements Soldier {
	protected String name;
	protected float healthPoints;
	protected float force;

	public SoldierAbstract(String nom, float healthPoints, float force) {
		this.name = nom;
		this.healthPoints = healthPoints;
		this.force = force;
	}

	public String getName() {
		return name;
	}

	public float getHealthPoints() {
		return healthPoints;
	}

	public boolean alive() {
		return getHealthPoints() > 0;
	}

	public boolean parry(float force) { // default: no parry effect
		healthPoints = (getHealthPoints() > force) ? getHealthPoints() - force
				: 0;
		
		if (this.healthPoints <= 0)
			this.notifyObservers();
		
		return healthPoints > 0;
	}

	public float strike() {
		return alive() ? force : 0;
	}

	//ADDED
	protected void heal_inter(float healthPoints) {
		if( alive())
			this.healthPoints = healthPoints;
	}

	@Override
	public String getSoldierType() {
		return getClass().getSimpleName();
	}

}

