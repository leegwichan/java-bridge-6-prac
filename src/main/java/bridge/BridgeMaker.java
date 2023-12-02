package bridge;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final int UP_NUMBER = 1;
    private static final int DOWN_NUMBER = 0;
    private static final Map<Integer, String> NUMBER_TO_STRING = Map.of(UP_NUMBER, UP, DOWN_NUMBER, DOWN);


    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validate(size);
        return generateBridge(size);
    }

    private void validate(int size) {
        if (isOutOfRange(size)) {
            throw new IllegalArgumentException("다리 길이는 %d 이상 %d 이하이어야 합니다".formatted(MIN_SIZE, MAX_SIZE));
        }
    }

    private boolean isOutOfRange(int size) {
        return size < MIN_SIZE || size > MAX_SIZE;
    }

    private List<String> generateBridge(int size) {
        return IntStream.generate(bridgeNumberGenerator::generate)
                .limit(size)
                .mapToObj(this::toExpression)
                .toList();
    }

    private String toExpression(int number) {
        if (NUMBER_TO_STRING.containsKey(number)) {
            return NUMBER_TO_STRING.get(number);
        }
        throw new IllegalArgumentException("숫자에 해당하는 다리 칸이 없습니다.");
    }
}
