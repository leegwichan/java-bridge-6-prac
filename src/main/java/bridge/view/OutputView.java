package bridge.view;

import static bridge.constant.Game.GAME_HELLO_BRIDGE;
import static bridge.constant.Game.GAME_RESULT;
import static bridge.constant.Game.GAME_TOTAL_TRY;
import static bridge.constant.Game.GAME_WHETHER_SUCCESS;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private StringBuilder printResult;

    public void printHelloBridgeGame() {
        System.out.println(GAME_HELLO_BRIDGE.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        printResult = new StringBuilder();

        printResult
                .append("{여기에 현재까지 이동한 다리 상태 출력}")
                .append("\n");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        printResult = new StringBuilder();

        printResult
                .append(GAME_RESULT.getMessage())
                .append("\n")
                .append("{여기에 다리 건너기 결과 출력}")
                .append("\n")
                .append(GAME_WHETHER_SUCCESS.getMessage())
                .append("{여기에 게임 성공 여부 값 출력}")
                .append("\n")
                .append(GAME_TOTAL_TRY.getMessage())
                .append("{여기에 총 시도한 횟수 값 출력}");
    }
}
