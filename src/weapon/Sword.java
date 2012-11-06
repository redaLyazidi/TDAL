package weapon;

public class Sword extends WeaponAbstract {
	private static final float DEFENSE = 1;
	private static final float ATTACK = 15;

	public Sword() {
		super(DEFENSE, ATTACK);
	}
}
