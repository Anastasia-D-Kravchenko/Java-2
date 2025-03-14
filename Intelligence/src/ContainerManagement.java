import java.io.*;
import java.util.*;

abstract class Container {
    private int id;
    private double mass;
    private String cargo;
    public Container(int id, double mass, String cargo) {
        this.id = id;
        this.mass = mass;
        this.cargo = cargo;
    }
    public int getId() {
        return id;
    }
    public double getMass() {
        return mass;
    }
    public String getCargo() {
        return cargo;
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Mass: " + mass + " kg, Cargo: " + cargo;
    }
}
class RefrigeratedContainer extends Container {
    public RefrigeratedContainer(int id, double mass, String cargo) {
        super(id, mass, cargo);
    }
}
class BulkContainer extends Container {
    public BulkContainer(int id, double mass, String cargo) {
        super(id, mass, cargo);
    }
}
class GeneralPurposeContainer extends Container {
    public GeneralPurposeContainer(int id, double mass, String cargo) {
        super(id, mass, cargo);
    }
}
class TankContainer extends Container {
    public TankContainer(int id, double mass, String cargo) {
        super(id, mass, cargo);
    }
}
class ContainerShip {
    private int rows;
    private int columns;
    private Container[][] deck;
    public ContainerShip(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.deck = new Container[rows][columns];
    }
    public boolean loadContainer(Container container, int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < columns && deck[row][col] == null) {
            deck[row][col] = container;
            return true;
        }
        return false;
    }
    public void saveManifest(String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++) {
                    if (deck[row][col] != null) {
                        Container container = deck[row][col];
                        writer.println(container.getId() + "\t" + row + "," + col + "\t" + container.getMass() + "\t" + container.getCargo());
                    }
                }
            }
        }
    }
}
public class ContainerManagement {
    public static void main(String[] args) {
        int numContainers = 15000;
        String containerFile = "containers.txt";
        String manifestFile = "manifest.txt";
        List<Container> containers = generateContainers(numContainers);
        saveContainersToFile(containers, containerFile);
        List<Container> loadedContainers = loadContainersFromFile(containerFile);
        ContainerShip ship = new ContainerShip(100, 150);
        int row = 0, col = 0;
        for (Container container : loadedContainers) {
            if (ship.loadContainer(container, row, col)) {
                col++;
                if (col >= 150) {
                    col = 0;
                    row++;
                }
            }
            if(row >= 100){
                break;
            }
        }
        try {
            ship.saveManifest(manifestFile);
            System.out.println("Manifest saved to " + manifestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static List<Container> generateContainers(int numContainers) {
        List<Container> containers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numContainers; i++) {
            int type = random.nextInt(4);
            double mass = 1000 + random.nextDouble() * 20000;
            String cargo = "Cargo " + random.nextInt(100);
            switch (type) {
                case 0:
                    containers.add(new RefrigeratedContainer(i + 1, mass, cargo));
                    break;
                case 1:
                    containers.add(new BulkContainer(i + 1, mass, cargo));
                    break;
                case 2:
                    containers.add(new GeneralPurposeContainer(i + 1, mass, cargo));
                    break;
                case 3:
                    containers.add(new TankContainer(i + 1, mass, cargo));
                    break;
            }
        }
        return containers;
    }
    private static void saveContainersToFile(List<Container> containers, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Container container : containers) {
                writer.println(container.getClass().getSimpleName() + "\t" + container.getId() + "\t" + container.getMass() + "\t" + container.getCargo());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static List<Container> loadContainersFromFile(String filename) {
        List<Container> containers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                String type = parts[0];
                int id = Integer.parseInt(parts[1]);
                double mass = Double.parseDouble(parts[2]);
                String cargo = parts[3];
                switch (type) {
                    case "RefrigeratedContainer":
                        containers.add(new RefrigeratedContainer(id, mass, cargo));
                        break;
                    case "BulkContainer":
                        containers.add(new BulkContainer(id, mass, cargo));
                        break;
                    case "GeneralPurposeContainer":
                        containers.add(new GeneralPurposeContainer(id, mass, cargo));
                        break;
                    case "TankContainer":
                        containers.add(new TankContainer(id, mass, cargo));
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return containers;
    }
}