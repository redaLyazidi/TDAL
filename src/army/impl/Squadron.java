package army.impl;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import army.Army;
import army.VisitorArmy;

public class Squadron implements Army {

	private List<Army> regiment;
	private String name;


	public Squadron(String name) {
		this(name, new LinkedList<Army>());
	}

	@SuppressWarnings("unchecked")
	public Squadron(String name, List<? extends Army> regiment) {
		this.regiment = (List<Army>) regiment;
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
			parry =  a.parry(force / regiment.size()) || parry;
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
	
	public void addArmy(Army army) { //Impossible to add itself
		if(!equals(army))	
			regiment.add(army);
	}

	public void addAllArmies(Collection<? extends Army> listArmy) {
		for (Army a : listArmy)
			addArmy(a);
	}
	
	public boolean removeArmy(Army army) {
		return regiment.remove(army);
	}
	
	public void removeAllArmies(Collection<? extends Army> armies) {
		regiment.removeAll(armies);
	}
	
	public List<Army> getRegiment() {
		return regiment;
	}

	public <T> T accept(VisitorArmy<T> visitor)
	{
		return visitor.visit(this);
	}

}
