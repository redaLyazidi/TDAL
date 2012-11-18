package army.impl;

import soldier.ArmedUnit;
import army.Army;
import army.VisitorArmy;

public class VisitorArmyCount implements VisitorArmy<Integer> {

	@Override
	public Integer visit(Squadron squadron) {
		int count = 0;
		for( Army a: squadron.getRegiment())
			count += a.accept(this);
		return count;
	}

	@Override
	public Integer visit(ArmedUnit soldier) {
		return 1;
	}
}
