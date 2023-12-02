package bridge;

import static org.junit.jupiter.api.Assertions.assertTrue;

import bridge.constant.Room;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    @DisplayName("입력 받은 다리 길이만큼 칸 생성을 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void createRoomToBridgeLength(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        List<String> bridges = bridgeMaker.makeBridge(bridgeSize);
        List<String> rooms = Stream.of(Room.values())
                .map(Room::getMessage)
                .toList();
        List<String> intersection = new ArrayList<>(rooms); // 교집합 리스트
        intersection.retainAll(bridges); // 교집합 찾기

        assertTrue(!intersection.isEmpty()); // 하나라도 포함됨
    }
}