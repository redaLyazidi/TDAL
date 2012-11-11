package weapon;

public class BallisticVest extends WeaponAbstract {

	private static final float DEFENSE = 30;
	private static final float ATTACK = 0;
	private static final float RESISTANCE = 1;

	public BallisticVest() {
		super(DEFENSE, ATTACK, RESISTANCE);
	}

	public void fix() {
		resistance = RESISTANCE;
	}

}
