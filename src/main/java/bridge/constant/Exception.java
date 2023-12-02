package bridge.constant;

public enum Exception {
    EXCEPTION_ERROR_TEMPLATE("[ERROR] "),
    EXCEPTION_INVALID_TEMPLATE("유효한 값이 아닙니다."),
    EXCEPTION_INVALID_NUMBER(EXCEPTION_ERROR_TEMPLATE.message + "다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    EXCEPTION_INVALID_MOVE(EXCEPTION_ERROR_TEMPLATE.message + EXCEPTION_INVALID_TEMPLATE.message),
    EXCEPTION_INVALID_GAME_COMMAND(EXCEPTION_ERROR_TEMPLATE.message + EXCEPTION_INVALID_TEMPLATE.message);

    private String message;


    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
