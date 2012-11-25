package util;

import java.util.Observable;

public class ALObservable extends Observable
{

	@Override
	public void notifyObservers()
	{
		this.setChanged();
		super.notifyObservers();
	}
	
	@Override
	public void notifyObservers(Object arg0)
	{
		this.setChanged();
		super.notifyObservers(arg0);
	}
	
}
