> 다리 건너기 핵심: 다리를 생성해 플레이어가 이동할 수 있어야 한다.

## 기능 목록

- [] 다리 건너기 게임 기능 시작 - BridgeGameController#run()
    - [] 다리 건너기 게임 준비 - BridgeGameController#ready()
- [] 다리를 생성 - BridgeMaker#makeBridge()
    - [] 무작위 값을 사용해 건널 수 있는 칸 생성 - BridgeMaker#generateRoom()
    - [] 무작위 값을 생성 - BridgeMaker#generateNumber()
- [] 플레이어가 이동 - BridgeGame#move()
- [] 플레이어 게임 재시작 - BridgeGame#retry()

## 테스트 기능 목록

- [] 입력 받은 다리 길이만큼 칸 생성을 확인 - BridgeMakerTest#createRoomToBridgeLength()