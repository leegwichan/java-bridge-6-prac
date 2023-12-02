package bridge.view;

import static bridge.constant.Game.GAME_INPUT_BRIDGE;
import static bridge.constant.Game.GAME_INPUT_GAME_COMMAND;
import static bridge.constant.Game.GAME_INPUT_MOVE;
import static bridge.exception.ExceptionHandler.invalidGameCommand;
import static bridge.exception.ExceptionHandler.invalidMove;
import static bridge.exception.ExceptionHandler.invalidNumber;

import bridge.BridgeGame;
import bridge.constant.Game;
import bridge.constant.Room;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            while (true) {
                System.out.println(GAME_INPUT_BRIDGE.getMessage());
                String bridgeSize = Console.readLine();

                validateBridgeSize(bridgeSize);
                return Integer.parseInt(bridgeSize);
            }

        } catch (IllegalArgumentException e) {
            e.getMessage();
        }

        return 0;
    }

    public void validateBridgeSize(String bridgeSize) {
        if (!bridgeSize.matches("^(?:[3-9]|1\\d|20)$")) {
            invalidNumber();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(List<String> bridges) {
        BridgeGame bridgeGame = new BridgeGame();
        int size = bridges.size();
        int moveCount = 0;

        try {
            while (size != 0) {

                System.out.println(GAME_INPUT_MOVE.getMessage());
                String move = Console.readLine();
                validateMove(move);

                String currentBridge = bridges.get(moveCount);
                System.out.println("현재 다리:" + currentBridge);

                // 검증이 완료된 이동을 반복해야한다.
                // 다리를 끝까지 건너거나, 재시도 문구에서 종료를 입력할 때까지
                // 현재 이동한 다리의 위치와 비교 해야 한다.
                // 갈수 있다면 O 리턴, 없다면 X를 리턴
                // X 가 리턴되면 결과 출력 후 재시도 여부를 묻는다

                String moveResult = bridgeGame.move(currentBridge, move);

                if (!moveResult.equals(Room.ROOM_EXIST.getMessage())) {
                    moveCount = 0;
                    return Room.ROOM_EMPTY.getMessage();
                }
                System.out.println("size: " + size);
                size--;
                moveCount++;
            }
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }

        return Room.ROOM_EMPTY.getMessage();
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
        try {
            while (true) {
                System.out.println(GAME_INPUT_GAME_COMMAND.getMessage());
                String gameCommand = Console.readLine();
                validateGameCommand(gameCommand);

                if (gameCommand.equals(Game.GAME_RETRY.getMessage())) {
                    return Game.GAME_RETRY.getMessage();
                }
                return Game.GAME_QUIT.getMessage();
            }
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }

        return Game.GAME_QUIT.getMessage();
    }

    public void validateGameCommand(String gameCommand) {
        if (!gameCommand.matches("[RQ]")) {
            invalidGameCommand();
        }
    }
}
