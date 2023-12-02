package bridge;

import static bridge.constant.Bridge.BRIDGE_SIZE_ZERO;
import static bridge.constant.Room.ROOM_DOWN;
import static bridge.constant.Room.ROOM_UP;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> rooms = new ArrayList<>();
        while (size != BRIDGE_SIZE_ZERO.getMessage()) {
            rooms.add(generateRoom(rooms));
            size--;
        }
        return rooms;
    }

    private String generateRoom(List<String> rooms) {
        if (generateNumber() == BRIDGE_SIZE_ZERO.getMessage()) {
            return ROOM_UP.getMessage();
        }
        return ROOM_DOWN.getMessage();
    }

    private int generateNumber() {
        return bridgeNumberGenerator.generate();
    }
}
