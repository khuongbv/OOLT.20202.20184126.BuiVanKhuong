package hust.soict.hedspi.exception;

public class CreateOrderException extends Exception{
	private static final long serialVersionUID = 1L;

	public CreateOrderException(String message) {
		super(message);
	}
	
	public CreateOrderException(String message, Throwable cause) {
		super(message, cause);
	}
}
