package soldier;

public interface Soldier {
	public String getName();

	public float getHealthPoints();

	public boolean alive();

	public void heal();

	public boolean parry(float force);

	public float strike();
}
