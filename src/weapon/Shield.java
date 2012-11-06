package weapon;

public class Shield extends WeaponAbstract {
	private static final float DEFENSE = 10;
	private static final float ATTACK = 3;

	public Shield() {
		super(DEFENSE, ATTACK);
	}
}