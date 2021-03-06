package army.impl;

import java.io.File;
import java.io.IOException;
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
		addStatementAtTheCurrentPosition("squadron:");
		nbtab ++;
		addNewLineStatementAtTheCurrentPosition("name: " + squadron.getName());
		addNewLineStatementAtTheCurrentPosition("regiment: ");
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
		addStatementAtTheCurrentPosition("ArmedUnit:");
		nbtab++;

		addNewLineStatementAtTheCurrentPosition("name: " + soldier.getName());
		
		addNewLineStatementAtTheCurrentPosition("type: " + soldier.getSoldierType());

		addNewLineStatementAtTheCurrentPosition("weapons: ");
		List<String> equipments = ((ArmedUnitSoldier)soldier).getEquipmentsLabel();
		statement.addStatement(equipments.toString());
		nbtab--;
		return null;
	}


	public String getReport() {
		return statement.toString();
	}


	public void save(String file) throws IOException {
		statement.writeToFileNIOWay2(file);
	}
	
	public void setStatement(BuilderType buildertype) {
		statement = buildertype.getBuilder();
	}

	public void save(File file) throws IOException {
		statement.writeToFileNIOWay2(file);

	}
	
	
	private void addNewLineStatementAtTheCurrentPosition(String s) {
		statement.addLineFeed();
		addStatementAtTheCurrentPosition(s);
	}
	
	private void addStatementAtTheCurrentPosition(String s) {
		statement.setTabulation(nbtab);
		statement.addStatement(s);
	}

}