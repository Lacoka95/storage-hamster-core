package hu.storagehamster.www.Exception;

public class ShelfOutOfCapacityException extends RuntimeException {

	public ShelfOutOfCapacityException(String message) {
		super(message);
	}
}
