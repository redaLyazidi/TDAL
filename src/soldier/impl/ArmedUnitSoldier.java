package soldier.impl;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import soldier.ArmedUnit;
import soldier.Soldier;
import soldier.SoldierAbstract;
import weapon.SoldierArmedAbstract;
import army.ArmyVisitor;

public class ArmedUnitSoldier implements ArmedUnit {
	protected Soldier soldier;
	protected List<String> equipments = new ArrayList<String>();


	// External general constructor of the hierarchy of basic soldiers whose
	// classes inherit from SoldierAbstract:
	@SuppressWarnings("unchecked")
	public ArmedUnitSoldier(String soldierType, String soldierName) {
		try {
			// ensures that the initial soldier is an undecorated one
			Class<? extends SoldierAbstract> c;
			c = (Class<? extends SoldierAbstract>) Class.forName("soldier."
					+ soldierType);

			Constructor<? extends SoldierAbstract>[] make;
			make = (Constructor<? extends SoldierAbstract>[]) c
					.getConstructors();

			Object[] argc = { soldierName };
			soldier = make[0].newInstance(argc);
		} catch (Exception e) {
			throw new UnknownSoldierTypeException("Unknown soldier type"
					+ e.toString());
		}
	}

	public void addEquipment(String equipmentType) {
		if (alive()) { // XXX "else's" not treated
			if (equipments.contains(equipmentType)) {
				return; // decoration not applied
			} else {
				try { // assumption : it exists SoldierWithWeapon associated to
					// each Weapon
					Class<?> c = Class.forName("weapon.SoldierWith"
							+ equipmentType);
					Constructor<?>[] cons = c.getConstructors();
					Object[] argc = { soldier };
					soldier = (SoldierArmedAbstract<?>) cons[0].newInstance(argc); // decoration
					// applied
					equipments.add(equipmentType);
				} catch (Exception e) {
					throw new RuntimeException("Unknown equipment type "
							+ e.toString());
				}
			}
		}
	}

	public String getName() {
		return soldier.getName();
	}

	public float getHealthPoints() {
		return soldier.getHealthPoints();
	}

	public boolean alive() {
		return soldier.alive();
	}

	public void heal() {
		soldier.heal();
	}

	public void infuse_life() {
		soldier.infuse_life();
	}
	public float strike() {
		return soldier.strike();
	}

	public boolean parry(float force) {
		return soldier.parry(force);
	}
	
	public void accept(ArmyVisitor visitor)
	{
		visitor.visit(this);
	}

}
