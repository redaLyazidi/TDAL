package army;

public interface Army {
	public String getName();

	public float getHealthPoints();

	public boolean alive();

	public void heal();

	public boolean parry(float force);

	public float strike();

	// the only new method compared to Soldier
	public void addEquipment(String weaponType); 
}