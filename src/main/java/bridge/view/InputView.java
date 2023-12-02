package bridge.view;

import static bridge.exception.ExceptionHandler.invalidGameCommand;
import static bridge.exception.ExceptionHandler.invalidMove;
import static bridge.exception.ExceptionHandler.invalidNumber;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();

        validateBridgeSize(bridgeSize);

        return Integer.parseInt(bridgeSize);
    }

    public void validateBridgeSize(String bridgeSize) {
        if (!bridgeSize.matches("^(?:[3-9]|1\\d|20)$")) {
            invalidNumber();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = Console.readLine();
        validateMove(move);

        return move;
    }

    public void validateMove(String move) {
        if (!move.matches("[UD]")) {
            invalidMove();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = Console.readLine();
        validateGameCommand(gameCommand);

        return gameCommand;
    }

    public void validateGameCommand(String gameCommand) {
        if (!gameCommand.matches("[RU]")) {
            invalidGameCommand();
        }
    }
}
