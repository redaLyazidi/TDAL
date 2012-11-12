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
		
	}

	@Override
	public void visit(Soldier soldier) 
	{
		this.units.put(SoldierType.valueOf(soldier.getClass().getName()),
				this.units.get(soldier.getClass().toString()));
		System.out.println("HERE WE HAVE : " + this.units.get(soldier.getClass().getName()));
	}

	@Override
	public int getCount(SoldierType type)
	{
		return this.units.get(type);
	}

}
