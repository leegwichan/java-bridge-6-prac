package bridge;

import java.util.ArrayList;
import java.util.List;

public class MoveHistory {
    private List<String> history;

    private MoveHistory(List<String> history) {
        this.history = history;
    }

    public static MoveHistory from(List<String> input) {
        return new MoveHistory(input);
    }

    public void reset() {
        this.history = new ArrayList<>();
    }

    public int getSize() {
        return history.size();
    }

    public boolean isEqual(int index, String value) {
        return history.get(index).equals(value);
    }

    public void save(String value) {
        history.add(value);
    }
}
