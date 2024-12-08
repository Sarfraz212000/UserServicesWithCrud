package in.saffu.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super("Resource not found on the Server");
	}

	public UserNotFoundException(String message) {
		super(message);
	}

}
