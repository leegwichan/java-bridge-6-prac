package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.dto.Space;
import java.util.List;
import java.util.Map;

public class Bridge {

    private static final BridgeMaker MAKER = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static final Map<String, Space> STRING_FORMAT_TO_SPACE = Map.of("U", Space.UP, "D", Space.DOWN);

    private final List<Space> spaces;

    Bridge(List<Space> spaces) {
        this.spaces = spaces;
    }

    public static Bridge from(int size) {
        return new Bridge(toSpaces(MAKER.makeBridge(size)));
    }

    private static List<Space> toSpaces(List<String> formats) {
        return formats.stream()
                .map(Bridge::toSpace)
                .toList();
    }

    private static Space toSpace(String format) {
        if (STRING_FORMAT_TO_SPACE.containsKey(format)) {
            return STRING_FORMAT_TO_SPACE.get(format);
        }
        throw new IllegalArgumentException("해당 형식에 해당하는 칸이 없습니다");
    }

    public List<Space> getSpaces() {
        return spaces;
    }
}
