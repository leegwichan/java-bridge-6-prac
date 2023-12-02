package bridge.controller;

import bridge.dto.BridgeDto;
import bridge.dto.GameCommand;
import bridge.dto.Space;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.function.Supplier;

public class BridgeController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private BridgeGame bridgeGame;

    public void run() {
        bridgeGame = readRepeatedlyUntilNoException(this::readBridgeGame);
        int count = 0;

        do {
            count++;
            playGame();
        } while (isRetryGame());

        outputView.printResult(BridgeDto.from(bridgeGame), count);
    }

    private BridgeGame readBridgeGame() {
        int size = inputView.readBridgeSize();
        return BridgeGame.from(size);
    }

    private void playGame() {
        bridgeGame.retry();
        while (bridgeGame.isMoved()) {
            Space space = readRepeatedlyUntilNoException(inputView::readMoving);
            bridgeGame.move(space);
            outputView.printMap(BridgeDto.from(bridgeGame));
        }
    }

    private boolean isRetryGame() {
        if (bridgeGame.isReachEndCorrectly()) {
            return false;
        }

        GameCommand command = readRepeatedlyUntilNoException(inputView::readGameCommand);
        return command.isRetry();
    }

    private <T> T readRepeatedlyUntilNoException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return readRepeatedlyUntilNoException(supplier);
        }
    }
}
