package builder.impl;
import java.io.IOException;

import builder.AbstractBuilder;

public class HtmlBuilder extends AbstractBuilder {

	private final static int nbspacesForTabulation = 4; //common value

	@Override
	public void setTitle(String s) {
		statement.append("<h1>" + s + "</h1>\n");
	}

	@Override
	public void beginParagraph(String s) {
		beginParagraph();
		statement.append(s);

	}

	@Override
	public void beginParagraph() {
		statement.append("<p> ");
	}

	@Override
	public void endParagraph() {
		statement.append("</p>\n");
	}

	@Override
	public void setTabulation() {
		for (int i = 0; i < nbspacesForTabulation; i++)
			statement.append(" &nbsp ");
	}

	@Override
	public void addLine(String s) {
		addStatement(s);
		statement.append(" <br>\n");
	}

	@Override
	public void addStatement(String s) {
		statement.append(s);
	}

	@Override
	public void addLineFeed() {
		statement.append("<br/>\n");
	}

	@Override
	public void writeToFileNIOWay2(String file) throws IOException {
		super.writeToFileNIOWay2("ArmyReport/HTML/" + file);
	}

}
