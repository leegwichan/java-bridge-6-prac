package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.dto.Space;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeTest {

    private static final Space UP = Space.UP;
    private static final Space DOWN = Space.DOWN;

    @DisplayName("다리 위치 확인 기능 테스트")
    @Nested
    class CorrectSpaceTest {

        @DisplayName("가리키는 인덱스가 다리 크기보다 클 경우, 예외를 던진다")
        @ParameterizedTest
        @CsvSource({"-1", "4"})
        void isCorrectTest_whenOutOfRange_throwException(int index) {
            Bridge bridgeSizeThree = new Bridge(List.of(UP, UP, DOWN));

            assertThatThrownBy(() -> bridgeSizeThree.isCorrectSpace(index, UP))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("다리의 범위를 벗어났습니다");
        }

        @DisplayName("해당 칸의 해당위치가 맞는지 판단할 수 있다")
        @Test
        void isCorrectTest_whenTrue() {
            Bridge bridge = new Bridge(List.of(UP, UP, DOWN));

            boolean actual = bridge.isCorrectSpace(2, DOWN);

            assertThat(actual).isTrue();
        }

        @DisplayName("해당 칸의 해당위치가 틀린지 판단할 수 있다")
        @Test
        void isCorrectTest_whenFalse() {
            Bridge bridge = new Bridge(List.of(UP, UP, DOWN));

            boolean actual = bridge.isCorrectSpace(2, UP);

            assertThat(actual).isFalse();
        }
    }

    @DisplayName("다리의 크기를 알 수 있다")
    @Test
    void sizeTest() {
        Bridge bridgeSizeThree = new Bridge(List.of(UP, UP, DOWN));

        int actual = bridgeSizeThree.size();

        assertThat(actual).isEqualTo(3);
    }
}
