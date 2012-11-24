package builder.impl;

import builder.AbstractBuilder;

public class BuilderString extends AbstractBuilder {

	@Override
	public void setTitle(String s) {
		addLine(s);
	}

	@Override
	public void beginParagraph(String s) {
		addLineFeed();
		statement.append(s);
	}

	@Override
	public void beginParagraph() {
		addLineFeed();
	}

	public void endParagraph() {
		addLineFeed();
	}

	@Override
	public void setTabulation() {
		statement.append('\t');
	}
	
	@Override
	public void addLine(String s) {
		statement.append(s);
		addLineFeed();
	}

	@Override
	public void addStatement(String s) {
		statement.append(s);
	}

	@Override
	public void addLineFeed() {
		statement.append('\n');
	}

}
