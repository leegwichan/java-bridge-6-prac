package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.MoveHistory;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    @DisplayName("")
    @Test
    void BridgeGameTest() {
        // given
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D", "D"),
                MoveHistory.from(List.of("U", "D", "D", "D")));

        // when
        String gameResult = bridgeGame.getGameResult();

        // then
        Assertions.assertThat(gameResult).contains("[ O |   |   |   ]\n[   | O | O | O ]");
    }
}