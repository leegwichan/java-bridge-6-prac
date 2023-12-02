package bridge.constant;

public enum Game {
    GAME_RETRY("retry"),
    GAME_QUIT("quit");

    private String message;

    Game(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
