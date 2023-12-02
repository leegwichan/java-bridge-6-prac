package bridge.view;

import bridge.dto.GameCommand;
import bridge.dto.Space;
import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final Map<String, Space> FORMAT_TO_SPACE = Map.of(UP, Space.UP, DOWN, Space.DOWN);
    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private static final Map<String, GameCommand> FORMAT_TO_COMMAND
            = Map.of(RETRY, GameCommand.RETRY, QUIT, GameCommand.QUIT);
    private static final String BLANK = System.lineSeparator();

    private static final String INPUT_BRIDGE_REQUEST = "다리의 길이를 입력해주세요.";
    private static final String INPUT_SPACE_REQUEST
            = "이동할 칸을 선택해주세요. (위: %s, 아래: %s)".formatted(UP, DOWN);
    private static final String INPUT_COMMAND_REQUEST
            = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        printTitle(INPUT_BRIDGE_REQUEST);
        return readInt();
    }

    private int readInt() {
        try {
            return tryParsingToInt(read());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다");
        }
    }

    private int tryParsingToInt(String inputMessage) {
        return Integer.parseInt(inputMessage);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Space readMoving() {
        printTitle(INPUT_SPACE_REQUEST);
        return readSpace();
    }

    private Space readSpace() {
        String message = read().trim();

        if (FORMAT_TO_SPACE.containsKey(message)) {
            return FORMAT_TO_SPACE.get(message);
        }
        throw new IllegalArgumentException("이동할 칸은 %s 또는 %s만 입력해야 합니다".formatted(UP, DOWN));
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        printTitle(INPUT_COMMAND_REQUEST);
        return readCommand();
    }

    private GameCommand readCommand() {
        String message = read().trim();

        if (FORMAT_TO_COMMAND.containsKey(message)) {
            return FORMAT_TO_COMMAND.get(message);
        }
        throw new IllegalArgumentException("재시도 여부는 %s 또는 %s만 입력해야 합니다".formatted(RETRY, QUIT));
    }

    private void printTitle(String title) {
        System.out.println(BLANK + title);
    }

    private String read() {
        return Console.readLine();
    }
}
