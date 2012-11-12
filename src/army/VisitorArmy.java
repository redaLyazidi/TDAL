package army;

import soldier.Soldier;
import soldier.SoldierType;

public interface VisitorArmy
{
	public void visit(Army squadron);
	public void visit(Soldier soldier);
	
	public int getCount(SoldierType type);
}
