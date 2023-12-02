package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String RETRY = "R";
    private static final String SAME = "O";
    private static final String DIFFERENT = "X";

    private final List<String> bridge;
    private int round;
    private UserInputs userInputs;
    private int trialCount;

    public BridgeGame(List<String> bridge, UserInputs userInputs) {
        this.bridge = bridge;
        this.round = 0;
        this.trialCount = 1;
        this.userInputs = userInputs;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String input) {
        if (input.equals(RETRY)) {
            userInputs.reset();
            increaseTrialCount();
            return true;
        }

        return false;
    }

    public String getGameResult() {

        StringBuilder topRow = new StringBuilder("[  ]");
        StringBuilder bottomRow = new StringBuilder("[  ]");

        for (int i = 0; i < userInputs.getSize(); i++) {
            //윗 라인
            if (userInputs.isEqual(i, "U")) {
                int topOffset = topRow.toString().length() - 2;
                topRow.insert(topOffset, getValueByPosition(i));

                int bottomOffset = bottomRow.toString().length() - 2;
                bottomRow.insert(bottomOffset, getGapByPosition(i));
                continue;
            }

            //아랫 라인
            int bottomOffset = bottomRow.toString().length() - 2;
            bottomRow.insert(bottomOffset, getValueByPosition(i));

            int topOffset = topRow.toString().length() - 2;
            topRow.insert(topOffset, getGapByPosition(i));
        }

        return topRow.append("\n").append(bottomRow).toString();
    }

    public int getTrialCount() {
        return trialCount;
    }

    private void increaseTrialCount() {
        trialCount++;
    }

    private String compareInputWithBridge(int index) {
        if (userInputs.isEqual(index, bridge.get(index))) {
            return SAME;
        }

        return DIFFERENT;
    }

    private String getValueByPosition(int position) {
        String value = compareInputWithBridge(position);
        if (position == 0) {
            return value;
        }
        return String.format(" | %s", value);
    }

    private String getGapByPosition(int position) {
        if (position == 0) {
            return " ";
        }
        return " |  ";
    }
}
