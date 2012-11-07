package army;

import java.util.LinkedList;
import java.util.List;

public class Squadron implements Army {

	private List<Army> regiment;
	private String name;

	
	public Squadron(String name) {
		this(name, new LinkedList<Army>());
	}
	
	public Squadron(String name, List<Army> regiment) {
		this.regiment = regiment;
		this.name = name;
	}
	
	/**
	 * @return name
	 * of the unit
	 */
	@Override
	public String getName() { //if all soldiers are ONE so they have ONE name
		return name;
	}

	@Override
	public float getHealthPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Test if the Squadron is alive
	 * @return false if there no Army alive
	 * true if there at least one
	 */
	@Override
	public boolean alive() {
		boolean alive = false;
		for(Army a : regiment){
			alive = alive || a.alive();
		}
		return alive;
	}

	@Override
	public void heal() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean parry(float force) {
		boolean parry = false;
		for(Army a : regiment){
			parry = parry || a.parry(force);
		}
		return parry;
	}

	@Override
	public float strike() {
		float strike =0;
		for(Army a : regiment){
			strike += a.strike();
		}
		return strike;
	}

	@Override
	public void addEquipment(String weaponType) {
		// TODO Auto-generated method stub

	}

}
