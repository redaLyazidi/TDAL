package army.impl;

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

public class VisitorArmyStatementString implements VisitorArmy<Void> {

	private final static String title = "Army:";


	private StatementBuilder statement;
	private int nbtab;

	public VisitorArmyStatementString() {
		this(BuilderType.String); 
	}

	public VisitorArmyStatementString(String buildertype) {
		try {
			statement = BuilderType.valueOf(buildertype).getBuilder();
			statement.setTitle(title);
			nbtab = 0;
		}catch (IllegalArgumentException iae) {
			throw new UnknownBuilderType("Unknown builder type " + iae.toString());
		}
	}

	public VisitorArmyStatementString(BuilderType buildertype) {
		statement = buildertype.getBuilder();
		statement.setTitle(title);
		nbtab = 0;
	}


	public void reset() {
		statement.reset();
		nbtab = 0;
	}

	private void setTab() {
		for (int i = 0; i < nbtab ; i++)
			statement.setTabulation();
	}

	public StatementBuilder getStatement() {
		return statement;
	}


	@Override
	public Void visit(Army army) {
		System.out.println(army);
		return army.accept(this);
	}

	@Override
	public Void visit(Squadron squadron) {
		int parenttab = nbtab;
		nbtab ++;
		statement.beginParagraph();
		setTab();
		statement.addStatement("squadron:");
		statement.beginParagraph();
		nbtab ++;
		setTab();
		statement.addStatement("name:" + squadron.getName());
		statement.addStatement("regiment:");
		statement.beginParagraph();
		for( Army a: squadron.getRegiment())
			a.accept(this);
		nbtab = parenttab;
		return null;
	}

	@Override
	public Void visit(ArmedUnit soldier) {
		nbtab++;
		statement.setTabulation();
		statement.addStatement("ArmedUnit:");
		nbtab++;
		statement.beginParagraph();
		setTab();
		statement.addStatement("name:" + soldier.getName());
		statement.endParagraph();
		setTab();
		statement.addStatement("weapons: ");
		List<String> equipments = ((ArmedUnitSoldier)soldier).getEquipmentsLabel();
		statement.addStatement(equipments.toString());
		statement.endParagraph();
		soldier.accept(this);
		nbtab--;
		return null;
	}

	@Override
	public Void visit(Soldier soldier) {
		System.out.println("coucou soldier");
		nbtab--;
		return null;
	}

	@Override
	public Void visit(Horseman horseman) {
		setTab();
		statement.addStatement("type: " +horseman.getClass().getSimpleName());
		nbtab--;
		return null;
	}

	@Override
	public Void visit(Infantryman infantryman) {
		setTab();
		statement.addStatement("type: " +infantryman.getClass().getSimpleName());
		nbtab--;
		return null;
	}

	@Override
	public Void visit(Hero hero) {
		setTab();
		statement.addStatement("type: " +hero.getClass().getSimpleName());
		nbtab --;
		return null;
	}

	
	public String getReport() {
		return statement.toString();
	}



}
