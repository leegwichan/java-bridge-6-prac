package bridge.constant;

public enum Room {
    ROOM_UP("U"),
    ROOM_DOWN("D");

    private String message;

    Room(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
