package builder;

public interface StatementBuilder {

	public void reset();

	public void setTitle(String s);

	public void beginParagraph(String s);

	public void beginParagraph();

	public void endParagraph();

	public void setTabulation();
	public void setTabulation(int nb);

	public void addLine(String s);

	public void addStatement(String s);
	
	public void addLineFeed(int nb);
	public void addLineFeed();
	
	public void addParagraph(String s);
}
