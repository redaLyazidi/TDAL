package army.impl;

import java.util.Observable;
import java.util.Observer;

import soldier.SoldierAbstract;

public class ObserverSoldierReporter implements Observer
{

	private static ObserverSoldierReporter instance = null;
	
	private ObserverSoldierReporter()
	{
		
	}
	
	public static ObserverSoldierReporter getInstance()
	{
		if (ObserverSoldierReporter.instance == null)
			synchronized(ObserverSoldierReporter.class)
			{
				if (ObserverSoldierReporter.instance == null)
					ObserverSoldierReporter.instance = new ObserverSoldierReporter();
			}
		
		return ObserverSoldierReporter.instance;
	}
	
	@Override
	public void update(Observable arg0, Object arg1)
	{
		System.out.println(((SoldierAbstract)arg0).getName() + " is dead.");
	}
	
}
