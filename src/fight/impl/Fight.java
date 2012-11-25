package fight.impl;

import army.Army;

public class Fight 
{

	public static void fight(Army army1, Army army2)
	{
		while (army1.alive() && army2.alive())
		{
			army1.parry(army2.strike());
			army2.parry(army1.strike());
		}
	}
	
}
