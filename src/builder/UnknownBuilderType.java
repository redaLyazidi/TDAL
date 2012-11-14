package builder;

public class UnknownBuilderType extends RuntimeException {

	
	private static final long serialVersionUID = -5759108184751110055L;

	public UnknownBuilderType() {
		super();
	}

	public UnknownBuilderType(String arg0) {
		super(arg0);
	}

	public UnknownBuilderType(Throwable arg0) {
		super(arg0);
	}

	public UnknownBuilderType(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	
}
