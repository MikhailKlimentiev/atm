package tasks.exceptions;

public class EmptyCollectionException extends Exception {
	public EmptyCollectionException(String message) {
		super(message);
	}

	public EmptyCollectionException(String message, Throwable cause) {
		super(message, cause);
	}

	public void warn() {
		System.err.println("Taxi Station collection is empty");
	}
}
