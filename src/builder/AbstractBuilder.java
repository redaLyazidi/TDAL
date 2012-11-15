package builder;

public abstract class AbstractBuilder implements StatementBuilder {

	protected StringBuilder statement = new StringBuilder();
	
	
	@Override
	public void reset() {
		statement.delete(0, statement.length() - 1);
	}

	public StringBuilder getStatement() {
		return statement;
	}
	
	@Override
	public String toString() {
		return statement.toString();
	}

}
