package bridge.exception;

public class InputException extends IllegalArgumentException {
    private static final String PREFIX = "[ERROR] ";

    public InputException(String message) {
        super(PREFIX + message);
    }
}
