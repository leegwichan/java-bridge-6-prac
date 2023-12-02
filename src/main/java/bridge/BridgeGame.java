package bridge;

import static bridge.constant.Room.ROOM_EMPTY;
import static bridge.constant.Room.ROOM_EXIST;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String currentBridge, String move) {
        // 건널 수 있다면 O
        // 없다면 X 표시
        if (currentBridge.equals(move)) {
            return ROOM_EXIST.getMessage();
        }
        return ROOM_EMPTY.getMessage();
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int retry(int totalTry) {
        // 재시도() 하면 retry 상수 반환
        // 종료() 하면 quit 상수 반환
        // 반환된 문자열은 어떤 출력을 보여줄지로 사용된다.
        // 재시작 할 때 필요한 것은
        // 총 시도한 횟수 1증가
        // 이전에 이동한 칸 초기화
        return totalTry++;
    }
}
