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

	/**
	 * @return the sum of healthPoints of each member of the Army
	 */
	@Override
	public float getHealthPoints() {
		float healthPoints = 0;
		for (Army a : regiment)
			healthPoints += a.getHealthPoints();
		return healthPoints;
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
		for (Army a : regiment)
			a.heal();
	}
	
	@Override
	public void infuse_life() {
		for (Army a : regiment)
			a.infuse_life();
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

	/**
	 * @param String weaponType
	 * addEquipment to each element of the Army
	 * the final result depends on the implementation
	 * of Army which are sheet
	 */
	@Override
	public void addEquipment(String weaponType) {
		for (Army a : regiment)
			a.addEquipment(weaponType);
	}

	public void addArmy(Army army) {
		regiment.add(army);
	}

	public void addAllArmies(List<Army> listArmy) {
		regiment.addAll(listArmy);
	}
	
}
