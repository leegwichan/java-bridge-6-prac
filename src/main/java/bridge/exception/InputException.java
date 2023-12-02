package bridge.exception;

public class InputException extends IllegalArgumentException {
    private static final String prefix = "[ERROR] ";

    public InputException(String message) {
        super(prefix + message);
    }
}
