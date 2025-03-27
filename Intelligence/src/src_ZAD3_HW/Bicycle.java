package src_ZAD3_HW;
import java.util.Objects;

public class Bicycle extends Vehicle implements Turnable, Comparable<Bicycle> {
    private int wheelSize;
//    String color;
    private int currentDirection;

    public Bicycle(String make, String model, int productionYear, int wheelSize) {
        super(make, model, productionYear);
        this.wheelSize = wheelSize;
        this.currentDirection = 0;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    @Override
    public void start() {
        System.out.println("Bicycle is ready to go!");
    }

    @Override
    public void stop() {
        System.out.println("Bicycle stopped.");
    }

    @Override
    public String getStatusDescription() {
        return "Bicycle is stationary.";
    }

    @Override
    public int getDirection() {
        return currentDirection;
    }

    @Override
    public void turnLeft() {
        currentDirection = (currentDirection - 90 + 360) % 360;
    } // with % 360 we can get percentage: 90 % 360 = 0,25; 180 % 360 = 0,5 ...

    @Override
    public void turnLeft(int degrees) {
        currentDirection = (currentDirection - degrees + 360) % 360;
    }

    @Override
    public void turnRight() {
        currentDirection = (currentDirection + 90) % 360;
    }

    @Override
    public void turnRight(int degrees) {
        currentDirection = (currentDirection + degrees) % 360;
    }

    @Override
    public void headTowards(String direction) throws IllegalArgumentException {
        switch (direction.toLowerCase()) {
            case "north":
                currentDirection = 0;
                break;
            case "east":
                currentDirection = 90;
                break;
            case "south":
                currentDirection = 180;
                break;
            case "west":
                currentDirection = 270;
                break;
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }
    }

    @Override
    public int compareTo(Bicycle other) {
        return Integer.compare(this.wheelSize, other.wheelSize);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bicycle bicycle = (Bicycle) o;
        return wheelSize == bicycle.wheelSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wheelSize);
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "make='" + getMake() + '\'' +
                ", model='" + getModel() + '\'' +
                ", productionYear=" + getProductionYear() +
                ", wheelSize=" + wheelSize +
                ", currentDirection=" + currentDirection +
                '}';
    }
}
