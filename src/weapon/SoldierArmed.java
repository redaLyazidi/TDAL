package weapon;

import soldier.SoldierChecked;

public abstract class SoldierArmed<W extends Weapon> implements SoldierChecked {
	protected SoldierChecked soldier;
	protected W weapon;
	private static final int sameClassCountMax = 1;

	SoldierArmed(SoldierChecked s, W a) throws BreakingRuleException {
		soldier = s;
		weapon = a;
		// check the number of soldiers of the same kind
		// in the decoration sequence:
		if (soldier.countWeaponOccurrences(this.getClass()) >= sameClassCountMax)
			throw new BreakingRuleException("too many occurrences");
	}

	public String getName() {
		return soldier.getName();
	}

	public float getHealthPoints() {
		return soldier.getHealthPoints();
	}

	public boolean alive() {
		return soldier.alive();
	}

	public void heal() {
		soldier.heal();
	}

	public boolean parry(float force) {
		float effectiveForce = force - weapon.getParryValue();
		return soldier.parry(effectiveForce);
	}

	public float strike() {
		float force = soldier.strike() + weapon.getStrikeValue();
		return force;
	}

	public int countWeaponOccurrences(Class<?> className) {
		int sameClassesCount = soldier.countWeaponOccurrences(className);
		return this.getClass().equals(className) ? 
				sameClassesCount + 1 : sameClassesCount;
	}
}
