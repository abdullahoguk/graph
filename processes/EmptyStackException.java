package processes;

public class EmptyStackException extends RuntimeException {  
	private static final long serialVersionUID = 6575473314411100188L;

	public EmptyStackException(String err) {
	    super(err);
	  }
	}
