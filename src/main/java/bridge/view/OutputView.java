package bridge.view;

import static java.util.stream.Collectors.joining;

import bridge.dto.BridgeDto;
import bridge.dto.Space;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String BRIDGE_PREFIX = "[ ";
    private static final String BRIDGE_DELIMITER = " | ";
    private static final String BRIDGE_SUFFIX = " ]";
    private static final String CORRECT = "O";
    private static final String WRONG = "X";
    private static final String NOTHING = " ";


    private static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    private static final String GAME_RESULT_TITLE = "최종 게임 결과";
    private static final String GAME_RESULT_SUCCESS_FORMAT = "게임 성공 여부: %s";
    private static final Map<Boolean, String> BOOLEAN_TO_FORMAT
            = Map.of(Boolean.TRUE, "성공", Boolean.FALSE, "실패");
    private static final String GAME_RESULT_TRY_FORMAT = "총 시도한 횟수: %d";
    private static final String ERROR_FORMAT = "[ERROR] %s%n";

    public void printStartGame() {
        println(START_GAME);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printMap(BridgeDto bridgeDto) {
        println(makeBridgeLine(bridgeDto, Space.UP));
        println(makeBridgeLine(bridgeDto, Space.DOWN));
    }

    private String makeBridgeLine(BridgeDto bridgeDto, Space space) {
        return IntStream.range(0, bridgeDto.trace().size())
                .mapToObj(index -> findBridgeBlock(bridgeDto, space, index))
                .collect(joining(BRIDGE_DELIMITER, BRIDGE_PREFIX, BRIDGE_SUFFIX));
    }

    private String findBridgeBlock(BridgeDto bridgeDto, Space space, int index) {
        if (bridgeDto.trace().get(index) != space) {
            return NOTHING;
        }
        if (bridgeDto.bridge().get(index) == space) {
            return CORRECT;
        }
        return WRONG;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    public void printResult(BridgeDto bridgeDto, int count) {
        println(GAME_RESULT_TITLE);
        printMap(bridgeDto);
        printBlankLine();
        println(GAME_RESULT_SUCCESS_FORMAT.formatted(toSuccessString(bridgeDto)));
        println(GAME_RESULT_TRY_FORMAT.formatted(count));
    }

    private String toSuccessString(BridgeDto bridgeDto) {
        return BOOLEAN_TO_FORMAT.get(bridgeDto.isSuccess());
    }

    public void printExceptionMessage(Exception exception) {
        println(ERROR_FORMAT.formatted(exception.getMessage()));
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void printBlankLine() {
        System.out.println();
    }
}
