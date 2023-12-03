package bridge;

import static bridge.constant.Game.GAME_FAIL;
import static bridge.constant.Game.GAME_QUIT;
import static bridge.constant.Room.ROOM_EMPTY;

import bridge.model.Result;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {

    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;
    private Result gameResult;

    public void run() {
        // TODO: 실제 동작 로직
        ready();
        bridgeGamePlay();
    }

    private void ready() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame();
        gameResult = new Result(GAME_FAIL.getMessage(), 1);
    }

    private void bridgeGamePlay() {
        outputView.printHelloBridgeGame();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridges = bridgeMaker.makeBridge(bridgeSize);

        while (true) {
            String moveResult = inputView.readMoving(bridges);// X 가 리턴되면 결과 출력 후 재시도 여부를 묻는다

            if (moveResult.equals(ROOM_EMPTY.getMessage())) {
                String gameCommand = inputView.readGameCommand();
                if (gameCommand.equals(GAME_QUIT.getMessage())) {
                    outputView.printResult(gameResult); // 최종 게임 결과 출력 후 프로그램 종료
                    break;
                }
                gameResult = bridgeGame.retry(gameResult);// 게임을 다시 시도
            }
            
            if (moveResult.equals(GAME_QUIT.getMessage())) {
                outputView.printResult(gameResult);
                break;
            }
        }
    }
}
