package bridge.controller;

import bridge.dto.BridgeDto;
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
            bridgeGame.retry();
            playGame();
        } while (!bridgeGame.isReachEndCorrectly() && inputView.readGameCommand().isRetry());

        outputView.printResult(BridgeDto.from(bridgeGame), count);
    }

    private BridgeGame readBridgeGame() {
        int size = inputView.readBridgeSize();
        return BridgeGame.from(size);
    }

    private <T> T readRepeatedlyUntilNoException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return readRepeatedlyUntilNoException(supplier);
        }
    }

    private void playGame() {

        while (bridgeGame.isMoved()) {
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(BridgeDto.from(bridgeGame));
        }
    }
}
