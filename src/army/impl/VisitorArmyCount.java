package army.impl;

import soldier.ArmedUnit;
import soldier.SoldierType;
import army.Army;
import army.VisitorArmy;

public class VisitorArmyCount implements VisitorArmy<Integer> {

	private final SoldierType soldierType;
	
	
	public VisitorArmyCount() {
		super();
		this.soldierType = null;
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

	

	@Override
	public Integer visit(ArmedUnit soldier) {
		if (soldierType == null || soldier.getSoldierType().equals(soldierType.toString()))
			return 1;
		return 0;
	}

}
