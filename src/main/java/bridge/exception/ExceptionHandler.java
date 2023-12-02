package bridge.exception;

import static bridge.constant.Exception.EXCEPTION_INVALID_GAME_COMMAND;
import static bridge.constant.Exception.EXCEPTION_INVALID_MOVE;
import static bridge.constant.Exception.EXCEPTION_INVALID_NUMBER;

public final class ExceptionHandler {

    public static void invalidNumber() {
        throw new IllegalArgumentException(EXCEPTION_INVALID_NUMBER.getMessage());
    }

    public static void invalidMove() {
        throw new IllegalArgumentException(EXCEPTION_INVALID_MOVE.getMessage());
    }

    public static void invalidGameCommand() {
        throw new IllegalArgumentException(EXCEPTION_INVALID_GAME_COMMAND.getMessage());
    }
}
