package observer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import soldier.SoldierType;
import soldier.impl.ArmedUnitSoldier;
import army.impl.ObserverArmyReport;
import army.impl.Squadron;

public class ObserverTest 
{

	private final int soldierAmount = 10;
	
	private Squadron squadron = null;
		
	private ObserverArmyReport observer = null;
	
	@Before
	public void setUp()
	{
		this.squadron = new Squadron("Pg4life");
		for (int i = 0; i < this.soldierAmount; i++)
			this.squadron.addArmy(new ArmedUnitSoldier(SoldierType.Infantryman.toString(), 
					SoldierType.Infantryman.toString() + i));
		this.observer = new ObserverArmyReport();
		this.squadron.addObserver(observer);
	}
	
	@Test
	public void report() 
	{
		float halfHealth = this.squadron.getHealthPoints() / 2;
		this.squadron.parry(halfHealth);
		this.squadron.parry(halfHealth);
	}

}
