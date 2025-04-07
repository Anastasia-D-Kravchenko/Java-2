package GUI5_Person_Animal_Car;

import java.util.ArrayList;
import java.util.List;


abstract class AAnimal {
    private String name;
    private Group group;

    enum Group {
        MAMMAL, BIRD, AMPHIBIAN, INSECT
    }

    public AAnimal(String name, Group group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public Group getGroup() {
        return group;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Group: " + group;
    }
}

abstract class ACarnivore extends AAnimal {
    public ACarnivore(String name, Group group) {
        super(name, group);
    }

    public abstract boolean isScavenger(); // eats dead
}

abstract class AHerbivore extends AAnimal {
    public AHerbivore(String name, Group group) {
        super(name, group);
    }
}

class Enclosure<T extends AAnimal> {
    private List<T> animals;

    public Enclosure() {
        this.animals = new ArrayList<>();
    }

    public void addAnimalToEnclosure(T animal) {
        this.animals.add(animal);
    }

    public List<T> getEnclosure() {
        return this.animals;
    }

    public void showAnimals() {
        System.out.println("Animals in this enclosure:");
        for (T animal : animals) {
            System.out.println("- " + animal);
        }
    }
}

class Worker {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void cleanAnimal(AAnimal animal) {
        System.out.println("Worker " + name + " is cleaning " + animal.getName());
    }

    public void feedAnimal(AAnimal animal) {
        System.out.println("Worker " + name + " is feeding " + animal.getName());
    }

    @Override
    public String toString() {
        return "Worker: " + name;
    }
}

class Zoo {
    private List<Enclosure<? extends AAnimal>> enclosureList = new ArrayList<>(); // AAnimal itself or any class that extends AAnimal
    private List<Worker> workerList = new ArrayList<>();

    public List<Enclosure<? extends AAnimal>> getEnclosureList() {
        return enclosureList;
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public void addEnclosure(Enclosure<? extends AAnimal> enclosure) {
        this.enclosureList.add(enclosure);
    }

    public void addWorker(Worker worker) {
        this.workerList.add(worker);
    }

    public void showAllAnimals() {
        System.out.println("--- All Animals in the Zoo ---");
        for (Enclosure<? extends AAnimal> enclosure : enclosureList) {
            enclosure.showAnimals();
        }
        System.out.println("----------------------------");
    }

    public void showAllWorkers() {
        System.out.println("--- All Workers in the Zoo ---");
        for (Worker worker : workerList) {
            System.out.println("- " + worker);
        }
        System.out.println("----------------------------");
    }
}

class Lion extends ACarnivore {
    public Lion(String name) {
        super(name, Group.MAMMAL);
    }

    @Override
    public boolean isScavenger() {
        return false;
    }
}

class Eagle extends ACarnivore {
    public Eagle(String name) {
        super(name, Group.BIRD);
    }

    @Override
    public boolean isScavenger() {
        return true;
    }
}

class Elephant extends AHerbivore {
    public Elephant(String name) {
        super(name, Group.MAMMAL);
    }
}

class Frog extends AAnimal {
    public Frog(String name) {
        super(name, Group.AMPHIBIAN);
    }
}

class Butterfly extends AAnimal {
    public Butterfly(String name) {
        super(name, Group.INSECT);
    }
}

class Bird extends AAnimal {
    public Bird(String name) {
        super(name, Group.BIRD);
    }
}

public class Center {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        Enclosure<Lion> lionEnclosure = new Enclosure<>();
        Enclosure<Elephant> elephantEnclosure = new Enclosure<>();
        Enclosure<Bird> birdEnclosure = new Enclosure<>();

        zoo.addEnclosure(lionEnclosure);
        zoo.addEnclosure(elephantEnclosure);
        zoo.addEnclosure(birdEnclosure);

        Lion simba = new Lion("Simba");
        Elephant dumbo = new Elephant("Dumbo");
        Eagle rocky = new Eagle("Rocky");
        Frog freddy = new Frog("Freddy");
        Butterfly bella = new Butterfly("Bella");
        Bird bird = new Bird("Bubba");

        lionEnclosure.addAnimalToEnclosure(simba);
        elephantEnclosure.addAnimalToEnclosure(dumbo);
        birdEnclosure.addAnimalToEnclosure(bird);

        Enclosure enclosure = new Enclosure();
        enclosure.addAnimalToEnclosure(simba);
        enclosure.addAnimalToEnclosure(dumbo);
        enclosure.addAnimalToEnclosure(rocky);
        enclosure.addAnimalToEnclosure(freddy);
        enclosure.addAnimalToEnclosure(bella);
        enclosure.addAnimalToEnclosure(bird);
        zoo.addEnclosure(enclosure);

        Worker john = new Worker("John");
        Worker jane = new Worker("Jane");

        zoo.addWorker(john);
        zoo.addWorker(jane);

        john.cleanAnimal(simba);
        jane.feedAnimal(dumbo);
        john.feedAnimal(rocky);

        zoo.showAllAnimals();
        zoo.showAllWorkers();
    }
}