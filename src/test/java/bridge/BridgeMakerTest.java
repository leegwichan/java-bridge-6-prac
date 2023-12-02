package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeMakerTest {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final BridgeNumberGenerator ONLY_DOWN_NUMBER_GENERATOR = () -> 0;

    @Nested
    @DisplayName("다리 길이 검증 테스트")
    class ValidationTest {

        @DisplayName("다리 길이가 3 이상 20 이하가 아닌 경우, 예외를 던진다")
        @ParameterizedTest(name = "다리 길이 : {0}")
        @CsvSource({"2", "21"})
        void makeBridgeTest_whenSizeOutOfRange_throwException(int size) {
            BridgeMaker maker = new BridgeMaker(ONLY_DOWN_NUMBER_GENERATOR);

            assertThatThrownBy(() -> maker.makeBridge(size))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("다리 길이는 3 이상 20 이하이어야 합니다");
        }
    }

    @Nested
    @DisplayName("다리 생성 테스트")
    class MakingBridgeTest {

        @DisplayName("다리 길이에 해당하는 다리를 생성할 수 있다")
        @ParameterizedTest(name = "다리 길이 : {0}")
        @CsvSource({"3", "10", "20"})
        void makeBridgeTest_sizeTest(int size) {
            BridgeMaker maker = new BridgeMaker(ONLY_DOWN_NUMBER_GENERATOR);

            List<String> bridge = maker.makeBridge(size);

            assertThat(bridge).hasSize(size);
        }

        @DisplayName("BridgeNumberGenerator에서 받은 숫자에 따라 위/아래를 표기한다.")
        @ParameterizedTest(name = "숫자 : {0}, 위/아래 표기 : {1}")
        @CsvSource({"0, D", "1, U"})
        void makeBridgeTest_numberToStringTest(int number, String format) {
            BridgeMaker maker = new BridgeMaker(() -> number);
            int size = 3;
            List<String> expected = List.of(format, format, format);

            List<String> actual = maker.makeBridge(size);

            assertThat(actual).isEqualTo(expected);
        }
    }
}