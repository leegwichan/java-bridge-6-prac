package bridge.model;

public class Result {
    private String suceessOrFail;
    private int totalTry;

    public Result(String suceessOrFail, int totalTry) {
        this.suceessOrFail = suceessOrFail;
        this.totalTry = totalTry;
    }

    public int getTotalTry() {
        return totalTry;
    }

    public String getSuceessOrFail() {
        return suceessOrFail;
    }
}
