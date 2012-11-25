package observer;

import java.util.Observable;

import org.junit.Before;
import org.junit.Test;

import fight.impl.Fight;

import soldier.SoldierType;
import soldier.impl.ArmedUnitSoldier;
import army.impl.Squadron;

public class ObserverTest 
{

	private final int soldierAmount1 = 20;
	private final int soldierAmount2 = 5;
	
	private Squadron squadron1 = null;
	private Squadron squadron2 = null;
		
	private ObserverWarReporter observerWar = null;
	private ObserverDeathCount observerDeath = null;
	
	@Before
	public void setUp()
	{
		this.observerWar = ObserverWarReporter.getInstance();
		this.observerDeath = ObserverDeathCount.getInstance();
		
		this.squadron1 = new Squadron("Pg4life");	
		this.squadron1.addObserver(this.observerWar);
		for (int i = 0; i < this.soldierAmount1; i++)
		{
			ArmedUnitSoldier soldier = new ArmedUnitSoldier(SoldierType.Infantryman.toString(), 
					this.squadron1.getName() + "_" + SoldierType.Infantryman.toString() + "_" + i);
			
			this.squadron1.addArmy(soldier);
						
			Observable observable = ((Observable) soldier.getSoldier()); 
			observable.addObserver(observerWar);
			observable.addObserver(observerDeath);
		}

		this.squadron2 = new Squadron("Noobinator");	
		this.squadron2.addObserver(this.observerWar);
		for (int i = 0; i < this.soldierAmount2; i++)
		{
			ArmedUnitSoldier soldier = new ArmedUnitSoldier(SoldierType.Infantryman.toString(),
					this.squadron2.getName() + "_" + SoldierType.Infantryman.toString() + "_" + i);
			
			this.squadron2.addArmy(soldier);
						
			Observable observable = ((Observable) soldier.getSoldier()); 
			observable.addObserver(observerWar);
			observable.addObserver(observerDeath);
			
			soldier = new ArmedUnitSoldier(SoldierType.Horseman.toString(),
					this.squadron2.getName() + "_" + SoldierType.Horseman.toString() + "_" + i);
			
			this.squadron2.addArmy(soldier);
			
			observable = ((Observable) soldier.getSoldier()); 
			observable.addObserver(observerWar);
			observable.addObserver(observerDeath);
		}
	}
	
	@Test
	public void report() 
	{
		Fight.fight(this.squadron1, this.squadron2);
	}

}
