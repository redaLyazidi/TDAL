package observer;

import java.util.Observable;

import org.junit.Before;
import org.junit.Test;

import soldier.SoldierType;
import soldier.impl.ArmedUnitSoldier;
import army.impl.ObserverSoldierReporter;
import army.impl.Squadron;

public class ObserverTest 
{

	private final int soldierAmount = 10;
	
	private Squadron squadron = null;
		
	private ObserverSoldierReporter observer = null;
	
	@Before
	public void setUp()
	{
		this.squadron = new Squadron("Pg4life");
		this.observer = ObserverSoldierReporter.getInstance();
		
		for (int i = 0; i < this.soldierAmount; i++)
		{
			ArmedUnitSoldier soldier = new ArmedUnitSoldier(SoldierType.Infantryman.toString(), SoldierType.Infantryman.toString() + i);
			
			this.squadron.addArmy(soldier);
			((Observable) soldier.getSoldier()).addObserver(observer);
		}
	}
	
	@Test
	public void report() 
	{
		float halfHealth = this.squadron.getHealthPoints() / 2;
		this.squadron.parry(halfHealth);
		this.squadron.parry(halfHealth);
	}

}
