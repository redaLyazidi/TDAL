package army;

import soldier.ArmedUnit;
import army.impl.Squadron;

public interface VisitorArmy<T>
{
	public T visit(Squadron squadron);
	public T visit(ArmedUnit soldier);
	
}
