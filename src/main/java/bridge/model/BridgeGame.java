package bridge.model;

import bridge.dto.Space;
import java.util.Objects;

public class BridgeGame {

    private final Bridge bridge;
    private Trace trace;

    private BridgeGame(Bridge bridge, Trace trace) {
        this.bridge = Objects.requireNonNull(bridge);
        this.trace = Objects.requireNonNull(trace);
    }

    public static BridgeGame from(int size) {
        Bridge bridge = Bridge.from(size);
        Trace trace = new Trace(size);
        return new BridgeGame(bridge, trace);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Space space) {
        validateState();
        trace.add(space);
    }

    private void validateState() {
        if (trace.isReachedEnd(bridge) || isReachWrongRoute()) {
            throw new IllegalStateException("더 이상 다리를 건널 수 없습니다");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {
        trace = new Trace(bridge.size());
    }

    public boolean isReachWrongRoute() {
        return !trace.isCorrectRouteAt(bridge);
    }
}
