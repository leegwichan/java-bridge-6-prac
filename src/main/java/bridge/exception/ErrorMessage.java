package bridge.exception;

public enum ErrorMessage {
    INVALID_INPUT("유효하지 않은 입력입니다. 다시 입력해 주세요."),
    INVALID_BRIDGE_SIZE_INPUT("유효하지 않은 다리 길이입니다. 다시 입력해 주세요."),
    INVALID_MOVE_INPUT("유효하지 않은 움직임 입니다. 다시 입력해 주세요."),
    INVALID_GAME_COMMAND_INPUT("유효하지 않은 재시작 명령 입니다. 다시 입력해 주세요.");

    public final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
