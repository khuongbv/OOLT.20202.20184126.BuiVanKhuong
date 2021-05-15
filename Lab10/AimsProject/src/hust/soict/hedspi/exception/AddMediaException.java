package hust.soict.hedspi.exception;

public class AddMediaException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public AddMediaException(String message) {
		super(message);
	}
	
	public AddMediaException(String message, Throwable cause) {
		super(message, cause);
	}
}
