package army.impl;

import soldier.ArmedUnit;
import soldier.Soldier;
import soldier.impl.Hero;
import soldier.impl.Horseman;
import soldier.impl.Infantryman;
import army.Army;
import army.VisitorArmy;

public class VisitorArmyCount implements VisitorArmy<Integer>
{

	@Override 
	public Integer visit(Army army)
	{
		return army.accept(this);
	}

	@Override
	public Integer visit(Squadron squadron) {
		int count = 0;
		for( Army a: squadron.getRegiment())
			count += a.accept(this);
		return count;
	}
	
	@Override
	public Integer visit(ArmedUnit soldier) 
	{
		return soldier.accept(this);
	}


	public Integer visit(Soldier soldier)
	{
		return 1;
	}

	@Override
	public Integer visit(Horseman horseman) {
		return 1;
	}
	
	
	@Override
	public Integer visit(Infantryman infantryman) {
		return 1;
	}
	
	@Override
	public Integer visit(Hero hero) {
		return 1;
	}

}
