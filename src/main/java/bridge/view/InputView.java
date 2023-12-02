package bridge.view;

import bridge.exception.ErrorMessage;
import bridge.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_POSITION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RESET_OR_QUIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        print(INPUT_BRIDGE_SIZE);
        String input = read();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new InputException(ErrorMessage.WRONG_BRIDGE_SIZE);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        print(INPUT_MOVE_POSITION);
        String input = read();
        validateMoveInput(input);

        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        print(INPUT_RESET_OR_QUIT);
        String input = read();
        validateGameCommand(input);

        return input;
    }

    private static String read() {
        return Console.readLine().trim();
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static void validateMoveInput(String input) {
        if (input.equals("U") || input.equals("D")) {
            return;
        }
        throw new InputException(ErrorMessage.WRONG_MOVE_INPUT);
    }

    private static void validateGameCommand(String input) {
        if (input.equals("R") || input.equals("Q")) {
            return;
        }
        throw new InputException(ErrorMessage.WRONG_COMMAND_INPUT);
    }
}
