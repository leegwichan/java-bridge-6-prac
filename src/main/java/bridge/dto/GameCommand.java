package bridge.dto;

public enum GameCommand {

    RETRY, QUIT;

    public boolean isRetry() {
        return this == RETRY;
    }
}
