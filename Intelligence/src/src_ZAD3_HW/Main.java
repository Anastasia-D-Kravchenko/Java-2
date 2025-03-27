package src_ZAD3_HW;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//
//        Vehicle car = new Car("BMW", "M3", 2024);
//        car.flex();
//
//        Car sameCarAsAbove = (Car) car;
//        sameCarAsAbove.horn(); // ~print
//        sameCarAsAbove.horn("booo"); // oh no! OoO
//
//
//        /* TODO - stwórz po 2 obiekty każdej z klas i przetstuj ich działanie */
//
//        Car secondCar = new Car("Cupra", "Leon", 2023);
//        secondCar.start();
//        secondCar.driveForward(10);
//
//        Car thirdCar = new Car("Peugeot", "308", 2022);
//        thirdCar.start();
//        thirdCar.driveBackward(100);
//
//        System.out.println("Comparing cars by kilometers driven: " + secondCar.compareTo(thirdCar)); // small modification
//
//        Bicycle bicycle1 = new Bicycle("Romet", "One", 2021, 28);
//
////        mine
//        System.out.println("Bicycle 1 initial direction: " + bicycle1.getDirection());
//        bicycle1.turnLeft(); // -90
//        System.out.println("Bicycle 1 after turnLeft(): " + bicycle1.getDirection());
//        bicycle1.turnLeft(10);
//        System.out.println("Bicycle 1 after turnLeft(10): " + bicycle1.getDirection());
//        bicycle1.turnRight(450);
//        System.out.println("Bicycle 1 after turnRight(450): " + bicycle1.getDirection());
//        bicycle1.turnRight();
//        System.out.println("Bicycle 1 after turnRight(): " + bicycle1.getDirection());
//        System.out.println("Bicycle 1 final direction: " + bicycle1.getDirection());
//
//        Bicycle bicycle2 = new Bicycle("Kross", "Two", 2022, 26);
//        System.out.println("\nBicycle 2 initial direction: " + bicycle2.getDirection());
//        bicycle2.headTowards("West");
//        System.out.println("Bicycle 2 after headTowards(\"West\"): " + bicycle2.getDirection());
//
//        System.out.println("\nTesting Bicycle Comparison:");
//        System.out.println("Bicycle 1: " + bicycle1);
//        System.out.println("Bicycle 2: " + bicycle2);
//        System.out.println("Comparing bicycle1 and bicycle2: " + bicycle1.compareTo(bicycle2));
//
//        Bicycle bicycle3 = new Bicycle("Giant", "Escape", 2023, 28);
//        System.out.println("Bicycle 3: " + bicycle3);
//        System.out.println("Comparing bicycle1 and bicycle3: " + bicycle1.compareTo(bicycle3));
//    }
//}





//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//
//        Vehicle car = new Car("BMW", "M3", 2024, 60);
//        car.flex();
//        System.out.println(car.getStatusDescription());
//
//        Car sameCarAsAbove = (Car) car;
//        sameCarAsAbove.horn();
//        sameCarAsAbove.horn("booo");
//
//        /* TODO - stwórz po 2 obiekty każdej z klas i przetstuj ich działanie */
//
//        Car secondCar = new Car("Cupra", "Leon", 2023, 50);
//        secondCar.start();
//        try {
//            secondCar.driveForward(10);
//        } catch (RuntimeException e) {
//            System.out.println("Caught exception: " + e.getMessage());
//        }
//        System.out.println(secondCar.getStatusDescription());
//
//        Car thirdCar = new Car("Peugeot", "308", 2022, 45);
//        thirdCar.start();
//        try {
//            thirdCar.driveBackward(100);
//        } catch (RuntimeException e) {
//            System.out.println("Caught exception: " + e.getMessage());
//        }
//        System.out.println(thirdCar.getStatusDescription());
//
//        System.out.println("Comparing cars by kilometers driven: " + secondCar.compareTo(thirdCar));
//
//        System.out.println("\nTesting Refuelable Interface:");
//
//        System.out.println("Testing Car 1:");
//        System.out.println("Initial fuel level of Car 1: " + sameCarAsAbove.getFuelLevel());
//        sameCarAsAbove.refuel(30);
//        System.out.println("Fuel level of Car 1 after refueling: " + sameCarAsAbove.getFuelLevel());
//        try {
//            sameCarAsAbove.driveForward(50);
//        } catch (RuntimeException e) {
//            System.out.println("Caught exception: " + e.getMessage());
//        }
//        System.out.println("Fuel level of Car 1 after driving: " + sameCarAsAbove.getFuelLevel());
//        sameCarAsAbove.refuel(100);
//        System.out.println("Fuel level of Car 1 after trying to overfill: " + sameCarAsAbove.getFuelLevel());
//
//        System.out.println("\nTesting Car 2:");
//        System.out.println("Initial fuel level of Car 2: " + secondCar.getFuelLevel());
//        secondCar.refuel(20);
//        System.out.println("Fuel level of Car 2 after refueling: " + secondCar.getFuelLevel());
//        secondCar.driveForward(100);
//        System.out.println("Fuel level of Car 2 after driving: " + secondCar.getFuelLevel());
//        secondCar.driveForward();
//        System.out.println("Fuel level of Car 2 after driving more: " + secondCar.getFuelLevel());
//        secondCar.driveForward();
//    }
//}




import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Car("BMW", "M3", 2015, 60),
                new Bicycle("Romet", "One", 2023, 28),
                new Car("Audi", "A4", 2018, 55),
                new Bicycle("Kross", "Level", 2010, 26),
                new Car("Mercedes", "C-Class", 2015, 50)
        };

        VehicleOperation displayInfo = vehicle -> System.out.println("Vehicle Info: " + vehicle);

        VehicleOperation checkOld = vehicle -> {
            int currentYear = LocalDate.now().getYear();
            if (currentYear - vehicle.getProductionYear() > 10) {
                System.out.println(vehicle.getModel() + " is older than 10 years.");
            } else {
                System.out.println(vehicle.getModel() + " is not older than 10 years.");
            }
        };

        VehicleOperation convertToUpper = vehicle -> {
            String oldMake = vehicle.getMake();
            String oldModel = vehicle.getModel();
            System.out.println("Uppercase Make: " + oldMake.toUpperCase());
            System.out.println("Uppercase Model: " + oldModel.toUpperCase());
        };

        VehicleOperation restartEngine = vehicle -> {
            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                car.stop();
                System.out.println("Engine of " + car.getModel() + " stopped.");
                car.start();
                System.out.println("Engine of " + car.getModel() + " started.");
            } else {
                System.out.println("Cannot restart engine of a " + vehicle.getClass().getSimpleName());
            }
        };

        VehicleOperation[] operations = {displayInfo, checkOld, convertToUpper, restartEngine};

        System.out.println("--- Applying Vehicle Operations ---");
        for (Vehicle vehicle : vehicles) {
            System.out.println("\nProcessing vehicle: " + vehicle.getModel());
            for (VehicleOperation operation : operations) {
                operation.apply(vehicle);
            }
        }

        System.out.println("\n--- Sorting Vehicles ---");
        Arrays.sort(vehicles, (v1, v2) -> {
            if (v1.getModel().equalsIgnoreCase(v2.getModel())) {
                return Integer.compare(v1.getProductionYear(), v2.getProductionYear());
            } else {
                return v1.getModel().compareToIgnoreCase(v2.getModel());
            }
        });

        System.out.println("Sorted Vehicles:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}