package bridge.constant;

public enum Game {
    GAME_RETRY("R"),
    GAME_QUIT("Q"),
    GAME_SUCCESS("성공"),
    GAME_FAIL("실패"),
    GAME_RESULT("최종 게임 결과"),
    GAME_WHETHER_SUCCESS("게임 성공 여부: "),
    GAME_TOTAL_TRY("총 시도한 횟수: "),
    GAME_HELLO_BRIDGE("다리 건너기 게임을 시작합니다."),
    GAME_INPUT_BRIDGE("다리의 길이를 입력해주세요."),
    GAME_INPUT_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    GAME_INPUT_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private String message;

    Game(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
