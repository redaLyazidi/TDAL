package builder;

public abstract class AbstractBuilder implements StatementBuilder {

	protected StringBuilder statement = new StringBuilder();


	@Override
	public void reset() {
		statement.delete(0, statement.length());
	}

	public StringBuilder getStatement() {
		return statement;
	}

	@Override
	public String toString() {
		return statement.toString();
	}

	@Override
	public void addParagraph(String s) {
		beginParagraph();
		addStatement(s);
		endParagraph();
	}

	@Override
	public void addLineFeed(int nb) {
		if(! (nb > 0)) {
			for (int i =0; i < nb ; i++)
				addLineFeed();
		}
	}

	@Override
	public void setTabulation(int nb) {
		for (int i =0; i < nb ; i++)
			statement.append('\t');
	}
}
