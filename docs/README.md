> 다리 건너기 핵심: 다리를 생성해 플레이어가 이동할 수 있어야 한다.

## 기능 목록

- [] 다리 건너기 게임 기능 시작 - BridgeGameController#run()
    - [] 다리 건너기 게임 준비 - BridgeGameController#ready()
- [] 다리를 생성 - BridgeMaker#makeBridge()
    - [] 무작위 값을 사용해 건널 수 있는 칸 생성 - BridgeMaker#generateRoom()
    - [] 무작위 값을 생성 - BridgeMaker#generateNumber()
- [] 플레이어가 이동 - BridgeGame#move()
- [] 플레이어 게임 재시작 - BridgeGame#retry()
- [] 다리 길이를 입력 - InputView#readBridgeSize()
    - [] 다리 길이 검증 - InputView#validateBridgeSize()
- [] 이동할 칸 입력 - InputView#readMoving()
    - [] 이동할 칸 검증 - InputView#validateMove()
- [] 게임 재시작 명령 입력 - InputView#readGameCommand()
    - [] 재시작 명령 검증 - InputView#validateGameCommand()

## 테스트 기능 목록

- [] 입력 받은 다리 길이만큼 칸 생성을 확인 - BridgeMakerTest#createRoomToBridgeLength()
- [] 입력 받은 다리 길이가 3부터 20 사이의 숫자 아닐 경우 예외 발생 - InputViewTest#createBridgeSizeBetweenThreeToTwenty()
- [] 입력 받은 이동할 칸이 U(위 칸)와 D(아래 칸)가 아닐 경우 예외 발생 - InputViewTest#createMoveToUOrD()
- [] 입력 받은 게임 R(재시작)과 Q(종료)가 아닐 경우 예외 발생 - InputViewTest#createGameCommandToROrQ()