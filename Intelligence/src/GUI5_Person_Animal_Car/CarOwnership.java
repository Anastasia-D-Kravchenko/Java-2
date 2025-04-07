package GUI5_Person_Animal_Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return firstName.equals(person.firstName) && lastName.equals(person.lastName);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }
}

class Car {
    private String registrationNumber;
    private String brand;

    public Car(String registrationNumber, String brand) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return brand + " " + registrationNumber;
    }
}

public class CarOwnership {
    public static void main(String[] args) {
        Person kowalski = new Person("Jan", "Kowalski");
        Person nowak = new Person("Adam", "Nowak");
        Person krawczyk = new Person("Bartosz", "Krawczyk");
        Person heniek = new Person("Manager", "Heniek");

        Car skoda1 = new Car("WA00001", "Skoda");
        Car skoda2 = new Car("SC36010", "Skoda");
        Car mazda1 = new Car("WA01234", "Mazda");
        Car mazda2 = new Car("DW01ASD", "Mazda");
        Car bmw = new Car("WA12690", "BMW");
        Car volvo = new Car("KR60606", "Volvo");

        HashMap<Person, List<Car>> carMap = new HashMap<>();
        carMap.computeIfAbsent(kowalski, k -> new ArrayList<>()).add(skoda1);
        carMap.computeIfAbsent(kowalski, k -> new ArrayList<>()).add(bmw);
        carMap.computeIfAbsent(nowak, k -> new ArrayList<>()).add(mazda2);
        carMap.computeIfAbsent(krawczyk, k -> new ArrayList<>()).add(volvo);
        carMap.computeIfAbsent(krawczyk, k -> new ArrayList<>()).add(mazda1);
        carMap.computeIfAbsent(krawczyk, k -> new ArrayList<>()).add(skoda2);
        carMap.putIfAbsent(heniek, new ArrayList<>());

        System.out.println("/*");
        System.out.println("*");
        System.out.println("* Jan Kowalski -> SKODA WA00001 BMW WA12690");
        System.out.println("* Adam Nowak -> MAZDA DW01ASD");
        System.out.println("* Bartosz Krawczyk -> VOLVO KR60606 MAZDA WA01234 SKODA SC36010");
        System.out.println("* Manager Heniek -> [No cars]");
        System.out.println("* Cars with registration numbers starting with WA:");
        System.out.println("* SKODA WA00001 BMW WA12690 MAZDA WA01234");
        System.out.println("*/");

        for (Map.Entry<Person, List<Car>> entry : carMap.entrySet()) {
            Person owner = entry.getKey();
            List<Car> cars = entry.getValue();
            System.out.print(owner + " -> ");
            if (!cars.isEmpty()) {
                for (int i = 0; i < cars.size(); i++) {
                    System.out.print(cars.get(i));
                    if (i < cars.size() - 1) {
                        System.out.print(" ");
                    }
                }
            } else {
                System.out.print("[No cars]");
            }
            System.out.println();
            System.out.println(owner + " owns " + cars.size() + " vehicles");
        }

        System.out.println(carMap.get(nowak).get(0)); // MAZDA DW01ASD

        System.out.println("Cars with registration numbers starting with WA:");
        for (List<Car> cars : carMap.values()) {
            for (Car car : cars) {
                if (car.getRegistrationNumber().startsWith("WA")) {
                    System.out.print(car + " ");
                }
            }
        }
        System.out.println();
    }
}
