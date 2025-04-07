package GUI5_Person_Animal_Car;

import java.util.*;
import java.util.Random;
import java.util.regex.Pattern;

class VinGenerator {
    private static final String ALLOWED_CHARS = "ABCDEFGHIJKLMNPQRSTUVWXYZ123456789";
    private static final int VIN_LENGTH = 17;
    private static final Random random = new Random();

    public static String generateVin() {
        StringBuilder vin = new StringBuilder();
        for (int i = 0; i < VIN_LENGTH; i++) {
            vin.append(ALLOWED_CHARS.charAt(random.nextInt(ALLOWED_CHARS.length())));
        }
        return vin.toString();
    }
}

class Car1 {
    private final String maker;
    private final String model;
    private final int productionYear;
    private final String vin;
    private static final Set<String> globalVins = new HashSet<>();

    public Car1(String maker, String model, int productionYear) {
        this.maker = maker;
        this.model = model;
        this.productionYear = productionYear;
        this.vin = generateUniqueVin();
    }

    private String generateUniqueVin() {
        String newVin;
        do {
            newVin = VinGenerator.generateVin();
        } while (globalVins.contains(newVin));
        globalVins.add(newVin);
        return newVin;
    }

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public String getVin() {
        return vin;
    }

    @Override
    public String toString() {
        return "Car1{" +
                "maker='" + maker + '\'' +
                ", model='" + model + '\'' +
                ", productionYear=" + productionYear +
                ", vin='" + vin + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car1 Car1 = (Car1) o;
        return vin.equals(Car1.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin);
    }
}

class CarRegister {
    private final String identifier;
    private final Map<String, Car1> registeredCars = new HashMap<>();
    private static final Set<String> usedIdentifiers = new HashSet<>();

    public CarRegister(String identifier) {
        if (!Pattern.matches("^[A-NP-Z]{2,3}$", identifier)) {
            throw new IllegalArgumentException("Identifier must be 2 or 3 uppercase letters excluding 'O'.");
        }
        if (usedIdentifiers.contains(identifier)) {
            throw new IllegalArgumentException("Identifier '" + identifier + "' is not unique.");
        }
        usedIdentifiers.add(identifier);
        this.identifier = identifier;
    }

    public void defineRegistrationNumber(String registrationNumber, Car1 Car1) {
        if (registeredCars.containsKey(registrationNumber)) {
            throw new IllegalArgumentException("Registration number '" + registrationNumber + "' is already in use.");
        }

        String pattern;
        if (identifier.length() == 2) {
            pattern = "^" + Pattern.quote(identifier) + "([A-NP-Z1-9]{5})$";
        } else {
            pattern = "^" + Pattern.quote(identifier) + " ([A-NP-Z1-9]{5})$";
        }

        if (!Pattern.matches(pattern, registrationNumber)) {
            throw new IllegalArgumentException("Invalid registration number format for identifier '" + identifier + "'. Expected format: " + identifier + " YYYYY or " + identifier + " YYYYY (with space for 3-letter identifiers), where Y is a letter or digit excluding 'O' and '0'.");
        }

        registeredCars.put(registrationNumber, Car1);
        System.out.println("Car1 with VIN " + Car1.getVin() + " registered with number: " + registrationNumber);
    }

    public Map<String, Car1> getRegisteredCars() {
        return registeredCars;
    }
}

class Mechanic {
    private String name;
    private List<Car1> repairedCars = new ArrayList<>();
    private Map<Car1, Integer> repairCount = new HashMap<>();

    public Mechanic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void repairCar(Car1 Car1) {
        repairedCars.add(Car1);
        repairCount.put(Car1, repairCount.getOrDefault(Car1, 0) + 1); // exists? -> current value; does not? -> 0
        System.out.println("Mechanic " + name + " repaired Car1 with VIN: " + Car1.getVin());
    }

    public boolean wasRepaired(Car1 Car1) {
        return repairedCars.contains(Car1);
    }

    public int repairsCount(Car1 Car1) {
        return repairCount.getOrDefault(Car1, 0);
    }

    @Override
    public String toString() {
        return "Mechanic{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class Task3 {
    public static void main(String[] args) {
        Car1 car1 = new Car1("Toyota", "Camry", 2020);
        Car1 car2 = new Car1("Honda", "Civic", 2021);
        Car1 car3 = new Car1("Ford", "Focus", 2019);
        Car1 car4 = new Car1("BMW", "X5", 2022);

        System.out.println("Created cars:");
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
        System.out.println(car4);
        System.out.println();

        CarRegister registerWA = null;
        CarRegister registerKR = null;
        CarRegister registerGD = null;

        try {
            registerWA = new CarRegister("WA");
            registerKR = new CarRegister("KRK");
            registerGD = new CarRegister("GD");
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating CarRegister: " + e.getMessage());
            return;
        }

        if (registerWA != null) {
            registerWA.defineRegistrationNumber("WA12345", car1);
            registerWA.defineRegistrationNumber("WA6789P", car4);
            try {
                registerWA.defineRegistrationNumber("WA12345", new Car1("Test", "Test", 2023));
            } catch (IllegalArgumentException e) {
                System.err.println("Error registering Car1: " + e.getMessage());
            }
            try {
                registerWA.defineRegistrationNumber("WAO123", car3);
            } catch (IllegalArgumentException e) {
                System.err.println("Error registering Car1: " + e.getMessage());
            }
        }

        if (registerKR != null) {
            registerKR.defineRegistrationNumber("KRK ABCDE", car2);
            try {
                registerKR.defineRegistrationNumber("KRK1234", new Car1("Test2", "Test2", 2024));
            } catch (IllegalArgumentException e) {
                System.err.println("Error registering Car1: " + e.getMessage());
            }
        }

        System.out.println("\nRegistered cars in WA register:");
        if (registerWA != null) {
            registerWA.getRegisteredCars().forEach((reg, Car1) -> System.out.println(reg + " -> " + Car1.getVin()));
        }

        System.out.println("\nRegistered cars in KRK register:");
        if (registerKR != null) {
            registerKR.getRegisteredCars().forEach((reg, Car1) -> System.out.println(reg + " -> " + Car1.getVin()));
        }
        System.out.println();

        Mechanic mechanicJan = new Mechanic("Jan Kowalski");
        Mechanic mechanicPiotr = new Mechanic("Piotr Nowak");

        System.out.println("Created mechanics:");
        System.out.println(mechanicJan);
        System.out.println(mechanicPiotr);
        System.out.println();

        mechanicJan.repairCar(car1);
        mechanicJan.repairCar(car1);
        mechanicPiotr.repairCar(car2);
        mechanicJan.repairCar(car4);
        mechanicPiotr.repairCar(car1);

        System.out.println("\nRepair history:");
        System.out.println(mechanicJan.getName() + " repaired " + mechanicJan.repairsCount(car1) + " times Car1 with VIN: " + car1.getVin());
        System.out.println(mechanicJan.getName() + " repaired " + mechanicJan.repairsCount(car4) + " times Car1 with VIN: " + car4.getVin());
        System.out.println(mechanicPiotr.getName() + " repaired " + mechanicPiotr.repairsCount(car2) + " times Car1 with VIN: " + car2.getVin());
        System.out.println(mechanicPiotr.getName() + " repaired " + mechanicPiotr.repairsCount(car1) + " times Car1 with VIN: " + car1.getVin());

        System.out.println("\nCheck if cars were repaired:");
        System.out.println("Was Car1 with VIN " + car1.getVin() + " repaired by " + mechanicJan.getName() + "? " + mechanicJan.wasRepaired(car1));
        System.out.println("Was Car1 with VIN " + car3.getVin() + " repaired by " + mechanicJan.getName() + "? " + mechanicJan.wasRepaired(car3));
    }
}
