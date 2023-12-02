package bridge.dto;

import bridge.model.BridgeGame;
import java.util.List;

public record BridgeDto(List<Space> bridge, List<Space> trace, boolean isSuccess) {

    public static BridgeDto from(BridgeGame bridgeGame) {
        return new BridgeDto(bridgeGame.getBridge(), bridgeGame.getTrace(), bridgeGame.isReachEndCorrectly());
    }
}
