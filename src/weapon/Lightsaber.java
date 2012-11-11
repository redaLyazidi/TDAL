package weapon;

public class Lightsaber extends WeaponAbstract {
	private static final float DEFENSE = 10;
	private static final float ATTACK = 150;
	private static final float RESISTANCE = 10;

	public Lightsaber() {
		super(DEFENSE, ATTACK, RESISTANCE);
	}

	public void fix() {
		resistance = RESISTANCE;
	}
}
