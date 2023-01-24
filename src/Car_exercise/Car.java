package Car_exercise;

public class Car {

    private String brand;
    private String color;
    private Tire[] tires;
    private boolean tireBurst;

    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
        this.tires = new Tire[4];
        this.tireBurst = false;
        makeTires();
    }

    public void makeTires() {
        int randTearRate = (int) Math.floor(Math.random() * (25) + 5);
        String[] position = {"N/S [FRONT]", "O/F [FRONT]", "N/S [REAR]", "O/F [REAR]"};
        for (int i = 0; i < this.tires.length; i++) {
            this.tires[i] = new Tire(randTearRate, position[i]);
        }
    }

    public String getBrand() {
        return this.brand;
    }

    public String getColor() {
        return this.color;
    }

    public Tire[] getTires() {
        return tires;
    }

    public void move(int distance) {
        while (!isTireBurst()) {
            for (int i = 0; i < distance; i++) {
                int randomizedTire = (int) Math.floor(Math.random() * (3) + 0);
                this.tires[randomizedTire].reduceIntegrity(this.tires[randomizedTire].getTearRate());
                System.out.println("vrum vrum Vrummm!!!");
                if (checkTire(randomizedTire)) break;
            }
        }
    }

    private boolean checkTire(int randomizedTire) {
        if (this.tires[randomizedTire].getIntegrity() < 0) {
            this.tireBurst = true;
            this.radioPlay();
            return true;
        }
        return false;
    }

    public void getNewTire() {
        for (int i = 0; i < this.tires.length; i++) {
            if (checkTire(i)) {
                this.tires[i].addIntegrity(200);
                System.out.println("Integrity of 200 has been added to " + this.tires[i].getPosition());
            }
        }
    }
    
    public void radioPlay() {
        System.out.println("Booom boom boom!!");
    }

    public boolean isTireBurst() {
        return tireBurst;
    }
}




