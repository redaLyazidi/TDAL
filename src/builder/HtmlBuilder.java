package builder;
import java.io.*;

public class HtmlBuilder implements StatementBuilder {
	private String _statement = "";
	
	private final static int nbspacesForTabulation = 4; //common value
	
	public void reset() {
		_statement = "";
	}

	public void setTitle(String s) {
		_statement += "<h1>" + s + "</h1>";
	}

	public void beginParagraph(String s) {
		_statement += "<p>" + s;
	}

	public void beginParagraph() {
		_statement += "<p>";
	}

	public void endParagraph() {
		_statement += "</p>";
	}

	public void setTabulation() {
		for (int i = 0; i < nbspacesForTabulation; i++)
			_statement += "&nbsp";
	}

	public void addLine(String s) {
		_statement += s + "<br>\n";
	}

	public void addStatement(String s) {
		_statement += s;
	}

	public String getHtmlStatement() {
		return _statement;
	}

	public void printHtmlStatement(FileOutputStream out) {		  
		PrintStream p = new PrintStream(out);
		p.println(_statement);
		p.close();	
	}

}
