package bridge.domain;

public class Player {
    private int position;

    public Player() {
        position = 0;
    }

    public boolean tryMove(Bridge bridge, String location) {
        position++;
        return bridge.canPlayerMove(position, location);
    }
}
