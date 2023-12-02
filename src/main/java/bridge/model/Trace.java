package bridge.model;

import bridge.dto.Space;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Trace {

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    private final List<Space> spaces = new ArrayList<>();
    private final int maxSize;

    public Trace(int maxSize) {
        validate(maxSize);
        this.maxSize = maxSize;
    }

    private void validate(int maxSize) {
        if (isOutOfRange(maxSize)) {
            String exceptionMessage = "다리 건넌 정보는 %d 이상 %d 이하이어야 합니다.".formatted(MIN_SIZE, MAX_SIZE);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private boolean isOutOfRange(int maxSize) {
        return MIN_SIZE < maxSize && MAX_SIZE > maxSize;
    }

    public void add(Space space) {
        validateAddingMoreSpaces();
        spaces.add(space);
    }

    private void validateAddingMoreSpaces() {
        if (isSpacesFull()) {
            throw new IllegalStateException("다리 건넌 정보를 더 이상 추가할 수 없습니다");
        }
    }

    public boolean isCorrectRouteAt(Bridge bridge) {
        return IntStream.range(0, spaces.size())
                .allMatch(index -> bridge.isCorrectSpace(index, spaces.get(index)));
    }

    public boolean isReachedEndCorrectly(Bridge bridge) {
        return isSizeEqualTo(bridge.size()) && isCorrectRouteAt(bridge);
    }

    private boolean isSizeEqualTo(int size) {
        return size == spaces.size();
    }

    private boolean isSpacesFull() {
        return spaces.size() >= maxSize;
    }
}
