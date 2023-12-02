package bridge.constant;

public enum Bridge {
    BRIDGE_SIZE_ZERO(0);

    private int message;

    Bridge(int message) {
        this.message = message;
    }

    public int getMessage() {
        return message;
    }
}
