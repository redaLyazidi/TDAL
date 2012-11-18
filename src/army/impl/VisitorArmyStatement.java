package army.impl;

import java.util.List;

import soldier.ArmedUnit;
import soldier.impl.ArmedUnitSoldier;
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
		addStatementAtthecurrentPosition("squadron:");
		statement.addLineFeed();
		nbtab ++;
		addStatementAtthecurrentPosition("name: " + squadron.getName());
		statement.addLineFeed();
		addStatementAtthecurrentPosition("regiment: ");
		statement.addLineFeed();
		for( Army a: squadron.getRegiment()) {
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

		addnewLineStatementAtthecurrentPosition("name: " + soldier.getName());
		
		addnewLineStatementAtthecurrentPosition("type: " + soldier.getSoldierType());

		statement.addLineFeed();
		addStatementAtthecurrentPosition("weapons: ");

		List<String> equipments = ((ArmedUnitSoldier)soldier).getEquipmentsLabel();
		statement.addStatement(equipments.toString());
		nbtab--;
		return null;
	}


	public String getReport() {
		return statement.toString();
	}


	private void addnewLineStatementAtthecurrentPosition(String s) {
		statement.addLineFeed();
		addStatementAtthecurrentPosition(s);
	}
	
	private void addStatementAtthecurrentPosition(String s) {
		statement.setTabulation(nbtab);
		statement.addStatement(s);
	}

}