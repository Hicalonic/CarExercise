package Car_exercise;

public class Tire {
    private int integrity;
    private int tearRate;
    private String position;

    public Tire(int tearRate, String position) {
        this.integrity = 200;
        this.tearRate = tearRate;
        this.position = position;

    }

    public int getIntegrity() {
        return integrity;
    }

    public String getPosition() {
        return position;
    }

    public void reduceIntegrity(int integrity) {
        this.integrity -= integrity;
    }

    public void addIntegrity(int integrity) {
        this.integrity += integrity;
    }

    public int getTearRate() {
        return tearRate;
    }
}
