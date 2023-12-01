# 다리 건너기

위 아래 둘 중 하나의 칸만 건널수 있는 다리를 끝까지 건너가는 게임입니다.

# 기능 목록

### 게임 초기화 및 시작
    - [ ] 게임 시작 문구 출력
    - [ ] 다리 길이 입력받기
    - [ ] 다리 생성

### 사용자 입력 처리
    - [ ] 이동할 칸 입력받기 (U/D)
    - [ ] 게임 재시작/종료 입력받기 (R/Q)
    - [ ] 입력 값 검증 및 예외 처리

### 게임 로직 처리
    - [ ] 플레이어의 이동 처리
    - [ ] 이동 결과 확인 및 표시
    - [ ] 다리 건너기 성공 또는 실패 판단
    - [ ] 게임 종료 시 최종 결과 및 시도 횟수 출력

### 예외 상황 처리
    - [ ] 올바르지 않은 다리 길이 입력 시 예외 처리
    - [ ] 올바르지 않은 이동 입력 시 예외 처리
    - [ ] 올바르지 않은 재시작/종료 입력 시 예외 처리


# 클래스 목록

```text
├── Application.java
├── domain
│   ├── Bridge.java (다리 상태 관리, List<String> 포함)
│   ├── BridgeMaker.java (다리 생성기)
│   ├── Player.java (플레이어 동작 관리)
│   └── BridgeGame.java (게임 진행 상태 및 규칙 관리)
├── view
│   ├── InputView.java (사용자 입력 처리)
│   └── OutputView.java (게임 상태 및 결과 출력)
├── exception
│   ├── ErrorMessage.java (에러 메세지)
│   └── GameException.java (사용자 정의 예외)
├── util
│   ├── BridgeNumberGenerator.java (숫자 생성 인터페이스)
│   └── BridgeRandomNumberGenerator.java (랜덤 숫자 생성)
└── controller
    └── GameController.java (게임 진행 제어, 사용자 입력 관리)
```

### Domain

- [ ] BridgeGame
  - 시도 횟수 저장
  - bridge와 player를 보고 게임 상태 업데이트
  - 게임 상태를 기반으로 게임 종료 판단
- [ ] Bridge
  - List<Tile> 저장
  - 생성 시 다리 길이를 받아서 Tile 리스트 생성
  - 다리 길이 유효성 검증 (3 ~ 20)
  - 현재까지 진행한 다리 모양 반환
- [ ] Tile
  - 건널수 있는 위치 저장 (위, 아래)
  - 생성 시 무작위로 위, 아래 중 건널수 있는 칸 생성
  - 칸 이동 시도하고 결과 반환하는 boolean 메소드
