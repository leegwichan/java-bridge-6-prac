package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.exception.ErrorMessage;
import bridge.exception.InputException;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final int MIN_VALUE = 3;
    private static final int MAX_VALUE = 20;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateSize(size);
        ArrayList<String> bridge = new ArrayList<>();
        while (size > 0) {
            String position = parseNumber(bridgeNumberGenerator.generate());
            bridge.add(position);
            size--;
        }

        return bridge;
    }

    private void validateSize(int size) {
        if (size < MIN_VALUE || size > MAX_VALUE) {
            throw new InputException(ErrorMessage.WRONG_BRIDGE_SIZE);
        }
    }

    private String parseNumber(int positionNumber) {
        if (positionNumber == 0) {
            return DOWN;
        }

        return UP;
    }

}
