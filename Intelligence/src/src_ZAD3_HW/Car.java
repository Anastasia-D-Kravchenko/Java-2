package src_ZAD3_HW;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Car extends Vehicle implements Drivable, Comparable, Refuelable {
    private boolean isEngineRunning = false;
    private int kilometersDriven = 0;
    private int fuelCapacity;
    private int fuelLevel;

    public Car(String make, String model, int productionYear, int fuelCapacity) {
        super(make, model, productionYear);
        this.fuelCapacity = fuelCapacity;
        this.fuelLevel = 0;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    @Override
    public void refuel(int liters) {
        if (liters <= 0) {
            System.out.println("Cannot refuel with a non-positive amount.");
            return;
        }
        int newFuelLevel = fuelLevel + liters;
        if (newFuelLevel > fuelCapacity) {
            fuelLevel = fuelCapacity;
            System.out.println("Refueled to full capacity.");
        } else {
            fuelLevel = newFuelLevel;
            System.out.println("Refueled with " + liters + " liters. Current fuel level: " + fuelLevel);
        }
    }

    @Override
    public int getFuelLevel() {
        return fuelLevel;
    }

    @Override
    public void start() {
        isEngineRunning = true;
    }

    @Override
    public void stop() {
        if (isEngineRunning) {
            isEngineRunning = false;
        } else {
            System.out.println("There's nothing to stop!");
        }
    }

    @Override
    public String getStatusDescription() {
        return "Engine is " + (isEngineRunning ? "" : "NOT") + " running. Fuel level: " + fuelLevel + "/" + fuelCapacity;
    }

    @Override
    public void flex(){
        System.out.printf("This is my car from " + this.getProductionYear() + "  and it's the best.\n");
    }

    public void horn() {
        System.out.println("TrąbTrąb");
    }

    public void horn(String sound) {
        System.out.println(sound.toUpperCase());
    }

    @Override
    public void driveForward() {
        if(isEngineRunning && fuelLevel > 0) {
            kilometersDriven++;
            fuelLevel--;
        } else if (!isEngineRunning) {
            throw new RuntimeException("Engine is not running!");
        } else {
            throw new RuntimeException("Out of fuel!");
        }
    }

    @Override
    public void driveForward(int withSpeed) {
        if(withSpeed > MAX_SPEED) {
            throw new IllegalArgumentException("Przekroczono maksymalna predkosc!");
        } else {
            if(isEngineRunning && fuelLevel > 0) {
                kilometersDriven += withSpeed;
                fuelLevel -= (int) (withSpeed * 0.1);
            } else if (!isEngineRunning) {
                throw new RuntimeException("Engine is not running!");
            } else {
                throw new RuntimeException("Out of fuel!");
            }
        }
    }

    @Override
    public void driveBackward() {
        if(isEngineRunning && fuelLevel > 0) {
            kilometersDriven--;
            fuelLevel--;
        } else if (!isEngineRunning) {
            throw new RuntimeException("Engine is not running!");
        } else {
            throw new RuntimeException("Out of fuel!");
        }
    }

    @Override
    public void driveBackward(int withSpeed){
        if(withSpeed > MAX_SPEED) {
            throw new IllegalArgumentException("Przekroczono maksymalna predkosc!");
        } else {
            if(isEngineRunning && fuelLevel > 0) {
                kilometersDriven -= withSpeed;
                fuelLevel -= (int) (withSpeed * 0.1);
            } else if (!isEngineRunning) {
                throw new RuntimeException("Engine is not running!");
            } else {
                throw new RuntimeException("Out of fuel!");
            }
        }
    }

    // https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html
    @Override
    public int compareTo(Object o) {
        Car anotherCar = (Car) o;
        return this.kilometersDriven - anotherCar.kilometersDriven;

        /* Same effect as:
        if (this.kilometersDriven < anotherCar.kilometersDriven) {
            return -1; // this object is smaller than comparing object
        } else if  (this.kilometersDriven > anotherCar.kilometersDriven) {
            return 1; // this object is bigger than comparing object
        } else {
            return 0; // objects are the same (in order)
        }
         */
    }
    @Override
    public String toString() {
        return "Car{" +
                "make='" + getMake() + '\'' +
                ", model='" + getModel() + '\'' +
                ", productionYear=" + getProductionYear() +
                ", isEngineRunning=" + isEngineRunning +
                ", kilometersDriven=" + kilometersDriven +
                ", fuelCapacity=" + fuelCapacity +
                ", fuelLevel=" + fuelLevel +
                '}';
    }
}
