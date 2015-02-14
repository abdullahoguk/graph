package processes;

public class EmptyQueueException extends RuntimeException { 
	private static final long serialVersionUID = -6507286977726654170L;

	public EmptyQueueException(String err) {
	    super(err);
	  }
	}
