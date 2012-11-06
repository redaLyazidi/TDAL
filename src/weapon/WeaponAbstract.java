package weapon;

abstract class WeaponAbstract implements Weapon {
	protected float defense;
	protected float attack;

	public WeaponAbstract(float defense, float attack) {
		this.defense = defense;
		this.attack = attack;
	}

	public float getParryValue() {
		return defense;
	}

	public float getStrikeValue() {
		return attack;
	}
}
