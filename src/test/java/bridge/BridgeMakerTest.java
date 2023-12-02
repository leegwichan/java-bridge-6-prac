package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.BridgeMaker;
import bridge.exception.ErrorMessage;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {
    @DisplayName("사이즈가 3 ~ 20 값이 아니면 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 22, 100})
    void makeBridgeFailTest(int size) {
        // given
        BridgeMaker bridgeMaker = new BridgeMaker(() -> 0);

        // when, then
        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.WRONG_BRIDGE_SIZE);
    }

    @DisplayName("값이 주어지면 다리를 생성해야 한다.")
    @ParameterizedTest
    @MethodSource("makeExampleOfMakeBridge")
    void makeBridgeSuccessTest(BridgeDto bridgeDto) {
        // given
        int size = bridgeDto.size();
        BridgeMaker bridgeMaker = bridgeDto.bridgeMaker();
        List<String> expected = bridgeDto.expected();

        // when
        List<String> bridge = bridgeMaker.makeBridge(size);

        // then
        assertThat(bridge).isEqualTo(expected);
    }

    static Stream<BridgeDto> makeExampleOfMakeBridge() {
        return Stream.of(
                new BridgeDto(3, new BridgeMaker(() -> 1), List.of("U", "U", "U")),
                new BridgeDto(6, new BridgeMaker(() -> 0), List.of("D", "D", "D", "D", "D", "D")),
                new BridgeDto(10, new BridgeMaker(() -> 0), List.of("D", "D", "D", "D", "D", "D", "D", "D", "D", "D")),
                new BridgeDto(5, new BridgeMaker(() -> 1), List.of("U", "U", "U", "U", "U"))
        );
    }
}

record BridgeDto(int size, BridgeMaker bridgeMaker, List<String> expected) {
}