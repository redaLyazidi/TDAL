package weapon;

import army.VisitorArmy;
import soldier.Soldier;

public abstract class SoldierArmedAbstract<W extends Weapon> implements Soldier {
	protected Soldier soldier;
	protected W weapon;
	private static final float WEARINESS_COEF = 0; // XXX temporarily inhibited

	public SoldierArmedAbstract(Soldier s, W a) {
		soldier = s;
		weapon = a;
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

	public void infuse_life() {
		soldier.infuse_life();
	}
	
	public void fixWeapon() {
		weapon.fix();
	}

	public boolean parry(float force) {
		float effectiveForce = force - weapon.getParryValue();
		if (effectiveForce <= 1)
			effectiveForce = 1;
		// Effective force is at least 1 (weariness effect)
		weapon.damageCompute(WEARINESS_COEF);
		return soldier.parry(effectiveForce);
	}

	public float strike() {
		float force = soldier.strike() + weapon.getStrikeValue();
		weapon.damageCompute(WEARINESS_COEF);
		return force;
	}
	
	protected float averageStats() {
		return (soldier.getHealthPoints() + soldier.strike()) / 2; 
	}
	
	@SuppressWarnings("unchecked")
	public int soldiercmp(Soldier s) {
		float statS = ((SoldierArmedAbstract<W>) s).averageStats();
		float statThis = this.averageStats();
		if(statThis > statS)
			return 1;
		else if (statThis == statS) {
			return 0;
		}
		else 
			return -1;
	}
	
	@Override
	public String getSoldierType() {
		return soldier.getSoldierType();
	}
	
}
