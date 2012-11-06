package soldier;

public interface Soldier {
	public String getName();

	public float getHealthPoints();

	public boolean alive();

	public void heal();
	
	// return false if dead, true otherwise:
	public boolean parry(float force); 

	public float strike();	
}
