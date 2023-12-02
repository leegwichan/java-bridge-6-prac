package bridge.view;

import bridge.dto.GameCommand;
import bridge.dto.Space;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INPUT_BRIDGE_REQUEST = "다리의 길이를 입력해주세요.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        println(INPUT_BRIDGE_REQUEST);
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
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        return null;
    }

    private void println(String message) {
        System.out.println(message);
    }

    private String read() {
        return Console.readLine();
    }
}
