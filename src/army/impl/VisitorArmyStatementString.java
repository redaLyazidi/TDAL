package army.impl;

import soldier.ArmedUnit;
import soldier.Soldier;
import soldier.impl.Hero;
import soldier.impl.Horseman;
import soldier.impl.Infantryman;
import army.Army;
import army.VisitorArmy;
import builder.BuilderType;
import builder.StatementBuilder;
import builder.UnknownBuilderType;

public class VisitorArmyStatementString implements VisitorArmy<Void> {

	private final static String title = "Army:";
	
	private StatementBuilder statement;

	public VisitorArmyStatementString() {
		this(BuilderType.String);
	}

	public VisitorArmyStatementString(String buildertype) {
		statement = BuilderType.valueOf(buildertype).getBuilder();
		statement.setTitle(title);
	}

	public VisitorArmyStatementString(BuilderType buildertype) {
		try {
			statement = buildertype.getBuilder();
			statement.setTitle(title);
		} catch (IllegalArgumentException iae) {
			throw new UnknownBuilderType("Unknown builder type " + iae.toString());
		}
	}

	public void reset() {
		statement.reset();
	}


	public StatementBuilder getStatement() {
		return statement;
	}


	@Override
	public Void visit(Army army) {
		return army.accept(this);
	}

	@Override
	public Void visit(Squadron squadron) {
		statement.addStatement("squadron");
		return null;
	}
	
	@Override
	public Void visit(ArmedUnit soldier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(Soldier soldier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(Horseman horseman) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(Infantryman infantryman) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(Hero hero) {
		// TODO Auto-generated method stub
		return null;
	}




}
