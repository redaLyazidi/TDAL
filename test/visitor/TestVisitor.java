package visitor;
import java.io.IOException;

import builder.BuilderType;

import soldier.ArmedUnit;
import soldier.SoldierType;
import soldier.impl.ArmedUnitSoldier;
import army.Army;
import army.VisitorArmy;
import army.impl.Squadron;
import army.impl.VisitorArmyCount;
import army.impl.VisitorArmyStatement;


public class TestVisitor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArmedUnit a = new ArmedUnitSoldier(SoldierType.Infantryman.toString(), "ryan");
		VisitorArmy<Void> v = new VisitorArmyStatement();
		a.accept(v);
		System.out.println(((VisitorArmyStatement) v).getReport());
		
		Army b = new ArmedUnitSoldier(SoldierType.Infantryman.toString(), "bryan");
		VisitorArmyStatement v2 = new VisitorArmyStatement();
		a.accept(v2);
		System.out.println(((VisitorArmyStatement) v2).getReport());
		
		
		Army squadron = new Squadron("squadron");
		((Squadron) squadron).addArmy(b);
		v2.init();
		squadron.accept(v2);
		System.out.println(((VisitorArmyStatement) v2).getReport());
		System.out.println(a.accept(new VisitorArmyCount()));
		try {
			v2.save(squadron.getName() + ".txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		VisitorArmyStatement v3 = new VisitorArmyStatement(BuilderType.HTML);
		squadron.accept(v3);
		System.out.println(((VisitorArmyStatement) v3).getReport());
		try {
			((VisitorArmyStatement) v3).save(squadron.getName() + ".html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		v3.init();
		
		
	}

}