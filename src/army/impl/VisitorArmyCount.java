package army.impl;

import java.util.HashMap;
import java.util.Map;

import soldier.Soldier;
import soldier.SoldierType;
import army.Army;
import army.VisitorArmy;

public class VisitorArmyCount implements VisitorArmy
{

	protected Map<SoldierType, Integer> units = null;
	
	public VisitorArmyCount()
	{
		this.units = new HashMap<SoldierType, Integer>();
	}
	
	@Override
	public void visit(Army squadron)
	{
		squadron.accept(this);
	}

	@Override
	public void visit(Soldier soldier) 
	{
		for (SoldierType type : SoldierType.values())
			if (soldier.getClass().getName().equals(type))
				this.units.put(SoldierType.valueOf(soldier.getClass().getName()),
						this.units.get(soldier.getClass().toString()) + 1);
	}

	@Override
	public int getCount(SoldierType type)
	{
		if (this.units.containsKey(type))
			return this.units.get(type);
		return 0;
	}

}
