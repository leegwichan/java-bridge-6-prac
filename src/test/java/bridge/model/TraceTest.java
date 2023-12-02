package bridge.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TraceTest {

    @DisplayName("객체 생성 테스트")
    @Nested
    class CreationTest {

        @DisplayName("다리 건넌 정보의 최대 크기는 3 이상 20 이하이어야 한다")
        @ParameterizedTest(name = "최대 크기 : {0}")
        @CsvSource({"2", "21"})
        void creationTest_whenMaxSizeOutOfRange_ThrowException(int maxSize) {
            assertThatThrownBy(() -> new Trace(maxSize))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("다리 건넌 정보는 3 이상 20 이하이어야 합니다");
        }
    }

    // TODO : 이외 public method에 대한 테스트 케이스 추가
}
