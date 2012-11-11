package weapon;

public class Deathnote extends WeaponAbstract {
	private static final float DEFENSE = 0;
	private static final float ATTACK = Float.MAX_VALUE;
	private static final float RESISTANCE = 0;

	public Deathnote() {
		super(DEFENSE, ATTACK, RESISTANCE);
	}

	public void fix() {
		resistance = RESISTANCE;
	}

}
