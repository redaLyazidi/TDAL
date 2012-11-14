package builder;

public class BuilderString implements StatementBuilder {
	private String _statement = "";

	public void reset() {
		_statement = "";
	}

	public void setTitle(String s) {
		_statement += s + "\n";
	}

	public void beginParagraph(String s) {
		_statement += "\n" + s;
	}

	public void beginParagraph() {
		_statement += "\n";
	}

	public void endParagraph() {
		_statement += "\n";
	}

	public void setTabulation() {
		_statement += "\t";
	}

	public void addLine(String s) {
		_statement += s + "\n";
	}

	public void addStatement(String s) {
		_statement += s;
	}

	public String getStatement() {
		return _statement;
	}

}
