### **Project README: Multi-Threading Performance Analysis**

This project explores the empirical differences between **Sequential Execution** and **Concurrent Multi-threading** in Java by benchmarking the time taken to process numbers up to one million.

#### **🛠 Project Components**

* **Sequential Logic (`toMillion.java`)**: A standard iterative loop that prints numbers 0 to 1,000,000 in a single thread across three independent trials.
* **Concurrent Logic (`MultiThread.java`)**: Splits the workload into two specialized threads—`EvenNumber` and `OddNumber`—which run simultaneously using the `start()` and `join()` methods.
* **Thread Implementation**:
* **EvenNumber**: Processes even values (0, 2, 4...) and outputs to the standard error stream (`System.err`).
* **OddNumber**: Processes odd values (1, 3, 5...) and outputs to the standard output stream (`System.out`).



---

### **Project README: Zoo Management System (Generics & Abstraction)**

This project demonstrates advanced **Object-Oriented Programming (OOP)** concepts, specifically focusing on **Generic Types**, **Enums**, and **Abstract Classes** to model a zoo environment.

#### **🛠 Project Components**

* **Domain Modeling**: Uses an abstract base `AAnimal` class with a nested `Group` Enum (MAMMAL, BIRD, AMPHIBIAN, INSECT) to categorize species.
* **Generics (`Enclosure<T>`)**: Implements a generic enclosure system that can be restricted to specific animal types (e.g., `Enclosure<Lion>`) or remain heterogeneous.
* **Role-Based Logic**: Features a `Worker` class with specialized behaviors for `feedAnimal()` and `cleanAnimal()`, demonstrating how actors interact with domain objects.

---

### **Project README: Car & Mechanic Management System**

A system focused on **Unique Data Generation (VINs)** and **Relational Mapping** between vehicle owners, mechanics, and repair histories.

#### **🛠 Project Components**

* **VIN Generator**: Implements a custom utility to generate unique 17-character Vehicle Identification Numbers using a specific pool of allowed alphanumeric characters.
* **Repair Tracking**: The `Mechanic` class tracks repair frequency per car using a `Map<Car1, Integer>`, allowing the system to report exactly how many times a specific VIN has been serviced by a specific mechanic.
* **Ownership Mapping**: Uses a `HashMap<Person, List<Car>>` to associate owners with multiple vehicles and filter results by registration number patterns (e.g., matching "WA" prefixes).

---

### **Project README: Vehicle Operations Framework**

A modular framework for vehicle behavior using **Interfaces**, **Functional Interfaces**, and **Lambda-ready** operations.

#### **🛠 Project Components**

* **Interface-Driven Design**:
* **`Turnable`**: Defines methods for directional control (`turnLeft`, `turnRight`, `headTowards`).
* **`Refuelable`**: Manages fuel levels and refueling logic for motorized units.


* **Functional Programming**: Includes `VehicleOperation`, a `@FunctionalInterface` designed to apply specific logic to a `Vehicle` instance via the `apply()` method.
* **Implementation (`Bicycle.java`)**: A concrete class that implements `Turnable` and `Comparable`, featuring bitwise-style modulus logic (`% 360`) to manage a 360-degree compass for direction tracking.

---

### **Project README: OOP Design Patterns, Interfaces, and Comparative Logic**

This documentation covers Java projects focused on advanced **Object-Oriented Programming (OOP)** structures, including complex interface hierarchies, the `Comparable` interface for sorting, and modular vehicle simulations.

#### **🛠 Project Components**

1. **Advanced Interface Hierarchies**
* **Interface Inheritance**: The project demonstrates multiple inheritance. `IAll` extends both `MyInterface` and `OurInterface`, creating a unified contract requiring implementation of `print()`, `sayBye()`, and `sayHello()`.
* **Concrete Implementation**: Class `A` implements the `IAll` interface, providing the actual logic for the inherited methods.


2. **Comparative Logic & Sorting (`Person.java`)**
* **Comparable Interface**: `Person` implements `Comparable<Person>` to define a "natural ordering."
* **Logic**: The `compareTo` method is overridden to compare individuals based on `birthYear`, allowing automatic sorting via `Collections.sort()`.


3. **Vehicle Simulation Framework**
* **Abstract Base (`Vehicle.java`)**: Defines essential attributes like make, model, and year, while mandating `start()`, `stop()`, and `getStatusDescription()`.
* **Behavioral Interfaces**: `Drivable` (movement/speed) and `Turnable` (directional logic).
* **Concrete Class (`Car.java`)**: Integrates all interfaces with complex fuel consumption and mileage tracking logic.



---

### **Project README: Advanced Java OOP Concepts**

This project contains modules demonstrating key OOP principles including **Interface Default Methods**, **Abstract Classes**, and **Method Overriding**.

#### **🛠 Project Components**

1. **Default Methods and Interface Conflict Resolution**
* **Conflict Resolution (`Amphibious.java`)**: Implements both `ICar` and `IBoat`. Resolves the "Diamond Problem" by overriding `move()` and using a state flag (`inWater`) to call the appropriate super-interface method.


2. **Abstract Classes for Domain Modeling**
* **Animal (Abstract)**: Defines a private name and an abstract `speak()` method.
* **Lion (Concrete)**: Provides the specific implementation of `speak()`.


3. **Geometric Shape Calculation**
* **AShape**: A high-level abstraction mandating `getArea()`.
* **Square & Rectangle**: Specialized implementations using specific area formulas.



---

### **Project README: Data Structures, Regex, and Algorithmic Logic**

Focuses on fundamental data structures (Stacks, Queues, Linked Lists) and advanced string processing using **Regular Expressions (Regex)**.

#### **🛠 Project Components**

1. **Data Structures: Linear Collections**
* **Singly Linked List (SLL)**: Implements core list operations via a `Node` building block.
* **Stacks (`MyStack.java`)**: Implements both Array-based and Linked List-based stacks with overflow/underflow protection.
* **Queues (`MyQueue.java`)**: A wrapper around `java.util.LinkedList` for enqueue/dequeue operations.


2. **Regular Expressions (Regex)**
* **Pattern & Matcher**: Demonstrates `matches()` vs `find()`.
* **Search & Replace**: Tools for locating indices (`B_Where`) and mass-replacing text (`C_Find_Replace`).
* **Data Extraction**: Complex patterns for extracting emails and URLs (`https?://\S+`).


3. **Computational Logic (`PPJANG.java`)**
* **Validation**: Static methods for Hexadecimal and Binary pattern checking.



---

### **🚀 How to Use**

* **Threading**: Run `MultiThread.main` to observe how the OS interweaves streams.
* **Data Structures**: Run `Main.java` in the `sll` package or `MyStack.main` to test collection behaviors.
* **Regex**: Execute `D_TakeElement.java` to test pattern extraction against custom strings.
* **Simulation**: Instantiate the `Amphibious` or `Car` classes to test state-based movements and fuel logic.

---

### **📂 File Manifest**

* **`Person.java`**: `Comparable` implementation.
* **`Vehicle.java` / `Car.java` / `Bicycle.java**`: Vehicle simulation logic.
* **`SLL.java` / `MyStack.java` / `MyQueue.java**`: Linear Data Structures.
* **`PPJANG.java`**: Regex validation utilities.
* **`AShape.java` / `Square.java` / `Rectangle.java**`: Geometric modeling.
