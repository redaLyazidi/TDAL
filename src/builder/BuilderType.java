package builder;

import builder.impl.BuilderString;
import builder.impl.HtmlBuilder;

public enum BuilderType {

	String ,HTML;
	
	
	public StatementBuilder getBuilder() {
		if(this == null)
			return new BuilderString();
		
		switch (this) {
		case String:
			return new BuilderString();
		
		case HTML:
			return new HtmlBuilder();
		

		default:
			return new BuilderString(); 
		}
	}
}
