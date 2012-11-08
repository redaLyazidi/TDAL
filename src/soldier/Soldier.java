package soldier;

public interface Soldier {
	public String getName();

	public float getHealthPoints();

	public boolean alive();

	public void heal();

	public void infuse_life();
	
	public boolean parry(float force);

	public float strike();
}
