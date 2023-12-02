package controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.MoveHistory;
import bridge.dto.ResultDto;
import bridge.exception.InputException;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class GameController {
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    public void run() {
        int bridgeSize = wrapByLoop(InputView::readBridgeSize);
        BridgeGame bridgeGame = new BridgeGame(initBridge(bridgeSize), MoveHistory.from(new ArrayList<>()));
        ResultDto resultDto = null;

        resultDto = playGame(bridgeGame, resultDto);
        if (resultDto == null) {
            resultDto = new ResultDto(bridgeGame.getGameResult(), SUCCESS, bridgeGame.getTrialCount());
        }

        OutputView.printResult(resultDto);
    }

    // @todo: refactor
    private ResultDto playGame(BridgeGame bridgeGame, ResultDto resultDto) {
        while (!bridgeGame.isEnd()) {
            String movePosition = wrapByLoop(InputView::readMoving);
            boolean isMove = bridgeGame.move(movePosition);
            String gameResult = bridgeGame.getGameResult();
            OutputView.printMap(gameResult);

            if (!isMove) {
                String command = wrapByLoop(InputView::readGameCommand);
                boolean shouldRetry = bridgeGame.retry(command);

                if (!shouldRetry) {
                    resultDto = new ResultDto(gameResult, FAIL, bridgeGame.getTrialCount());
                    break;
                }
            }
        }
        return resultDto;
    }

    private List<String> initBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private <T> T wrapByLoop(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (InputException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
