package mechanicshop.exceptions;

/**
 * Thrown when a record is not found in the system.
 */
public class RecordNotFoundException extends Exception {
    public RecordNotFoundException(String message) {
        super(message);
    }
}
