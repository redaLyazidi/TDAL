package army.impl;

import soldier.ArmedUnit;
import soldier.SoldierType;
import army.Army;
import army.VisitorArmy;

public class VisitorArmyCount implements VisitorArmy<Integer> {

	private SoldierType soldierType;
	
	
	public VisitorArmyCount() {
		this(null);
	}
	
	public VisitorArmyCount(SoldierType soldierType) {
		super();
		this.soldierType = soldierType;
	}

	@Override
	public Integer visit(Squadron squadron) {
		int count = 0;
		for( Army a: squadron.getRegiment())
			count += a.accept(this);
		return count;
	}

	
	public SoldierType getSoldierType() {
		return soldierType;
	}
	
	public void setSoldierType (SoldierType soldierType) {
		this.soldierType = soldierType;
	}
	

	@Override
	public Integer visit(ArmedUnit soldier) {
		if (soldierType == null || soldier.getSoldierType().equals(soldierType.toString()))
			return 1;
		return 0;
	}

}
