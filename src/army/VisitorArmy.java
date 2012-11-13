package army;

import soldier.ArmedUnit;
import soldier.Soldier;
import soldier.impl.Hero;
import soldier.impl.Horseman;
import soldier.impl.Infantryman;
import army.impl.Squadron;

public interface VisitorArmy<T>
{
	public T visit(Army squadron);
	public T visit(ArmedUnit soldier);
	public T visit(Squadron squadron);
	public T visit(Soldier soldier);
	public T visit(Horseman horseman);
	public T visit(Infantryman infantryman);
	public T visit(Hero hero);
	
}
