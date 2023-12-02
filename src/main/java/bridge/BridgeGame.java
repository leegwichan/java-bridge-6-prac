package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String RETRY = "R";

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

    public int getTrialCount() {
        return trialCount;
    }

    private void increaseTrialCount() {
        trialCount++;
    }
}
