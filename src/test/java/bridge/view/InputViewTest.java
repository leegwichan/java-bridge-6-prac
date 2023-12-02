package bridge.view;

import static bridge.constant.Exception.EXCEPTION_INVALID_GAME_COMMAND;
import static bridge.constant.Exception.EXCEPTION_INVALID_MOVE;
import static bridge.constant.Exception.EXCEPTION_INVALID_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @DisplayName("입력 받은 다리 길이가 3부터 20 사이의 숫자 아닐 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "21", "a", "bb", "pppp"})
    void createBridgeSizeBetweenThreeToTwenty(String badgeSize) {
        assertThatThrownBy(() -> inputView.validateBridgeSize(badgeSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_INVALID_NUMBER.getMessage());
    }

    @DisplayName("입력 받은 이동할 칸이 U(위 칸)와 D(아래 칸)가 아닐 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"A", "a", "Z", "z", "123", "한글사랑"})
    void createMoveToUOrD(String move) {
        assertThatThrownBy(() -> inputView.validateMove(move))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_INVALID_MOVE.getMessage());
    }

    @DisplayName("입력 받은 게임 R(재시작)과 Q(종료)가 아닐 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"A", "a", "Z", "z", "123", "한글사랑"})
    void createGameCommandToROrQ(String gameCommand) {
        assertThatThrownBy(() -> inputView.validateGameCommand(gameCommand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_INVALID_GAME_COMMAND.getMessage());
    }
}