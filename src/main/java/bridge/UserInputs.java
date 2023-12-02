package bridge;

import java.util.ArrayList;
import java.util.List;

public class UserInputs {
    private List<String> userInputs;

    private UserInputs(List<String> userInputs) {
        this.userInputs = userInputs;
    }

    public static UserInputs from(List<String> input) {
        return new UserInputs(input);
    }

    public void reset() {
        this.userInputs = new ArrayList<>();
    }

    public int getSize() {
        return userInputs.size();
    }

    public boolean isEqual(int index, String value) {
        return userInputs.get(index).equals(value);
    }
}
