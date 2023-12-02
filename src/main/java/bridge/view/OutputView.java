package bridge.view;

import bridge.dto.BridgeDto;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String ERROR_FORMAT = "[ERROR] %s%n";

    public void printStartGame() {
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printMap(BridgeDto bridgeDto) {
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    public void printResult(BridgeDto bridgeDto, int count) {
    }

    public void printExceptionMessage(Exception exception) {
        println(ERROR_FORMAT.formatted(exception.getMessage()));
    }

    private void println(String message) {
        System.out.println(message);
    }
}
