package bridge;

import static bridge.constant.Game.GAME_FAIL;
import static bridge.constant.Room.ROOM_EMPTY;
import static bridge.constant.Room.ROOM_EXIST;

import bridge.model.Result;

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
        // 반복이 아니라 현재 이동한 다리의 위치와 비교 해야 한다.
        // 그러기 위해서는 플레이어가 얼마나 이동했는지 알아야한다.
        // 이동 카운트를 하자!

        if (currentBridge.equals(move)) { // 건널 수 있다면 O
            return ROOM_EXIST.getMessage();
        }
        return ROOM_EMPTY.getMessage(); // 없다면 X 표시
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Result retry(Result gameResult) {
        // 재시도() 하면 retry 상수 반환
        // 종료() 하면 quit 상수 반환
        // 반환된 문자열은 어떤 출력을 보여줄지로 사용된다.
        // 재시작 할 때 필요한 것은
        // 총 시도한 횟수 1증가
        // 이전에 이동한 칸 초기화
        int totalTry = gameResult.getTotalTry();
        gameResult = new Result(GAME_FAIL.getMessage(), totalTry + 1);

        return gameResult;
    }
}
