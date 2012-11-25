package observer;

import java.util.Observable;
import java.util.Observer;

public final class ObserverDeathCount implements Observer
{

	private static ObserverDeathCount instance = null;
	
	private int deathCount = 0;
	
	private ObserverDeathCount()
	{
		
	}
	
	public static ObserverDeathCount getInstance()
	{
		if (ObserverDeathCount.instance == null)
			synchronized(ObserverDeathCount.class)
			{
				if (ObserverDeathCount.instance == null)
					ObserverDeathCount.instance = new ObserverDeathCount();
			}
		
		return ObserverDeathCount.instance;
	}
	
	@Override
	public void update(Observable arg0, Object arg1)
	{
		this.deathCount++;
		if (this.deathCount > 1)
			System.out.println(this.deathCount + " soldiers have been killed since the beginning of the war.");
		else
			System.out.println(this.deathCount + " soldier has been killed since the beginning of the war.");
	}

}
