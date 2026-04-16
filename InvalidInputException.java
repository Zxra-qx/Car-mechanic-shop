package mechanicshop.exceptions;

/**
 * Custom exception used for invalid user input.
 */
public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}
