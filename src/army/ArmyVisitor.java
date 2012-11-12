package army;

import army.impl.Squadron;
import soldier.impl.ArmedUnitSoldier;
import soldier.impl.Hero;
import soldier.impl.Horseman;
import soldier.impl.Infantryman;
import weapon.impl.SoldierWithShield;
import weapon.impl.SoldierWithSword;

public interface ArmyVisitor
{
	public void visit(Squadron squadron);
	public void visit(ArmedUnitSoldier soldier);
	public void visit(Hero hero);
	public void visit(Horseman horseman);
	public void visit(Infantryman infantryman);
	public void visit(SoldierWithShield soldier);
	public void visit(SoldierWithSword soldier);
}
