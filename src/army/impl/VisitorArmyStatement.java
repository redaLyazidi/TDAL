package army.impl;

import java.util.ArrayList;
import java.util.List;

import soldier.ArmedUnit;
import soldier.Soldier;
import soldier.impl.ArmedUnitSoldier;
import soldier.impl.Hero;
import soldier.impl.Horseman;
import soldier.impl.Infantryman;
import army.Army;
import army.VisitorArmy;
import builder.BuilderType;
import builder.StatementBuilder;
import builder.UnknownBuilderType;

public class VisitorArmyStatement implements VisitorArmy<Void> {

	private final static String title = "Army:";


	private StatementBuilder statement;
	private int nbtab;

	public VisitorArmyStatement() {
		this(BuilderType.String); 
	}

	public VisitorArmyStatement(String buildertype) {
		try {
			statement = BuilderType.valueOf(buildertype).getBuilder();
			statement.setTitle(title);
			nbtab = 0;
		}catch (IllegalArgumentException iae) {
			throw new UnknownBuilderType("Unknown builder type " + iae.toString());
		}
	}

	public VisitorArmyStatement(BuilderType buildertype) {
		statement = buildertype.getBuilder();
		statement.setTitle(title);
		nbtab = 0;
	}


	public void reset() {
		statement.reset();
		nbtab = 0;
	}

	public void init() {
		reset();
		statement.setTitle(title);
	}


	public StatementBuilder getStatement() {
		return statement;
	}


	@Override
	public Void visit(Squadron squadron) {
		int parenttab = nbtab;
		nbtab ++;
		//		statement.addLineFeed();
		addStatementAtthecurrentPosition("squadron:");
		statement.addLineFeed();
		nbtab ++;
		addStatementAtthecurrentPosition("name: " + squadron.getName());
		statement.addLineFeed();
		addStatementAtthecurrentPosition("regiment: ");
		statement.addLineFeed();
		for( Army a: squadron.getRegiment()) {
			System.out.println(a.getName());
			a.accept(this);
		}
		nbtab = parenttab;
		return null;
	}

	@Override
	public Void visit(ArmedUnit soldier) {
		nbtab++;
		addStatementAtthecurrentPosition("ArmedUnit:");
		nbtab++;

		statement.addLineFeed();
		addStatementAtthecurrentPosition("name: " + soldier.getName());

		statement.addLineFeed();
		addStatementAtthecurrentPosition("weapons: ");

		List<String> equipments = ((ArmedUnitSoldier)soldier).getEquipmentsLabel();
		statement.addStatement(equipments.toString());
		soldier.accept(this);
		nbtab--;
		return null;
	}

	@Override
	public Void visit(Soldier soldier) {
		nbtab--;
		return null;
	}

	@Override
	public Void visit(Horseman horseman) {
		statement.setTabulation(nbtab);
		statement.addStatement("type: " +horseman.getClass().getSimpleName());
		nbtab--;
		return null;
	}

	@Override
	public Void visit(Infantryman infantryman) {
		statement.setTabulation(nbtab);
		statement.addStatement("type: " +infantryman.getClass().getSimpleName());
		nbtab--;
		return null;
	}

	@Override
	public Void visit(Hero hero) {
		statement.setTabulation(nbtab);
		statement.addStatement("type: " +hero.getClass().getSimpleName());
		nbtab --;
		return null;
	}


	public String getReport() {
		return statement.toString();
	}


	private void addStatementAtthecurrentPosition(String s) {
		statement.setTabulation(nbtab);
		statement.addStatement(s);
	}

}