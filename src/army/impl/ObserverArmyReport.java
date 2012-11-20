package army.impl;

import java.util.Observable;
import java.util.Observer;

public class ObserverArmyReport implements Observer
{

	@Override
	public void update(Observable arg0, Object arg1)
	{
		System.out.println("Army " + ((Squadron)arg0).getName() + " is " + arg1 + ".");
	}
	
}
