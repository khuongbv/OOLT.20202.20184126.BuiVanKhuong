package hust.soict.hedspi.exception;

public class LuckyItemException extends Exception{
	private static final long serialVersionUID = 1L;

	public LuckyItemException(String message) {
		super(message);
	}
	
	public LuckyItemException(String message, Throwable cause) {
		super(message, cause);
	}
}
