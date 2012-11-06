package soldier;

abstract class SoldierAbstract implements SoldierChecked {
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

	public boolean parry(float force) {
		healthPoints = (getHealthPoints() > force) ? getHealthPoints() - force
				: 0;
		return healthPoints > 0;
	}

	public float strike() {
		return alive() ? force : 0;
	}

	public int countWeaponOccurrences(Class<?> className) {
		return 0; 
		// XXX seems useless: 
		// this.getClass().equals(className) ? 1 : 0;
	}
}
