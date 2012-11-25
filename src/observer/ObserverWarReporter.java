package observer;

import java.util.Observable;
import java.util.Observer;

import soldier.SoldierAbstract;
import army.impl.Squadron;

public final class ObserverWarReporter implements Observer
{

	private static ObserverWarReporter instance = null;
	
	private ObserverWarReporter()
	{
		
	}
	
	public static ObserverWarReporter getInstance()
	{
		if (ObserverWarReporter.instance == null)
			synchronized(ObserverWarReporter.class)
			{
				if (ObserverWarReporter.instance == null)
					ObserverWarReporter.instance = new ObserverWarReporter();
			}
		
		return ObserverWarReporter.instance;
	}
	
	@Override
	public void update(Observable arg0, Object arg1)
	{
		if (arg0 instanceof Squadron)
		{
			Squadron squadron = (Squadron)arg0;
			System.out.println("Squadron " + squadron.getName() + " has been decimated.");
		}
		else
		{
			SoldierAbstract soldier = (SoldierAbstract)arg0;
			System.out.println("Soldier " + soldier.getName() + " is dead.");
		}
	}
	
}
