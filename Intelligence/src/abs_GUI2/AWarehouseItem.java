package abs_GUI2;
import java.util.regex.Pattern;

abstract class AWarehouseItem {
    private String itemName;
    private double itemWeight;
    private final String idenCode;

    public AWarehouseItem(String itemName, double itemWeight, String idenCode) throws IllegalArgumentException {
        if (!Pattern.matches("[A-E]\\d{3}", idenCode)) {
            throw new IllegalArgumentException("Invalid identification code format.");
        }
        this.itemName = itemName;
        this.itemWeight = itemWeight;
        this.idenCode = idenCode;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemWeight() {
        return itemWeight;
    }

    public String getidenCode() {
        return idenCode;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemWeight(double itemWeight) {
        this.itemWeight = itemWeight;
    }

    @Override
    public String toString() {
        return "Item: " + itemName + ",\n Weight: " + itemWeight + " kg,\n Code: " + idenCode;
    }

    public abstract double cost(int days);

    public abstract boolean isFragile();
}

class Furniture extends AWarehouseItem {
    private final String material;
    private final int num;

    public Furniture(String itemName, double itemWeight, String idenCode, String material, int num) {
        super(itemName, itemWeight, idenCode);
        this.material = material;
        this.num = num;
    }

    @Override
    public String toString() {
        return super.toString() + ",\n Material: " + material + ",\n Packages: " + num;
    }

    @Override
    public double cost(int days) {
        double cost = getItemWeight() * days;
        if (num > 1) {
            cost *= (1 + (num - 1) * 0.2);
            // 1 - itself and num - 1 all additional
        }
        return cost;
    }

    @Override
    public boolean isFragile() {
        return Pattern.matches("[A-Z]+", material);
    }
}

class Electronics extends AWarehouseItem {
    private final int warranty;
    private final String energyClass;

    public Electronics(String itemName, double itemWeight, String idenCode, int warranty, String energyClass) throws IllegalArgumentException {
        super(itemName, itemWeight, idenCode);
        if (!Pattern.matches("[A-F]", energyClass)) {
            throw new IllegalArgumentException("Invalid energy class");
        }
        this.warranty = warranty;
        this.energyClass = energyClass;
    }

    @Override
    public String toString() {
        return super.toString() + ",\n Warranty: " + warranty + " months,\n Energy: " + energyClass;
    }

    @Override
    public double cost(int days) {
        double cost = getItemWeight() * days;
        if (warranty > 0) {
            cost *= (1 - warranty * 0.001);
            // 1 - full warranty and each month is decreasing by warranty * 0.001
        }
        return cost;
    }

    @Override
    public boolean isFragile() {
        return warranty < 12 && (energyClass.equals("A") || energyClass.equals("B"));
    }
}

class main1{
    public static void main(String[] args) {
        try {
            String[] chairArt = {
                    "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@",
                    "@@@@@@@@@@@@@@@@@@@#GB#&&@@@@@@@&#B#@@@@",
                    "@@@@@@@@@@@@@@@@@@@P?JJJJJJJJJJJ??P&@@@@",
                    "@@@@@@@@@&&&#######5JJJJJ?7777???5G@@@@@",
                    "@@@@@@@#GB###BG&@@@PYYJJ??7JYYYYG#&@@@@@",
                    "@@@@@@@Y#@@@@@BG&@@PYYJ??7Y5???5#@@@@@@@",
                    "@@@@@@@PB&&@@@@#G&@5YJ?7?PP77?JG&@@@@@@@",
                    "@@@@@@&5YJJYY5PP5G#YJ???JBJ7??5#@@@@@@@@",
                    "@@@@@@BG##BGP5YYYY5555GG5G5YJJB#@@@@@@@@",
                    "@@@@@&G#@@@@@@@@&GB##BBG5GGBGB#B@@@@@@@@",
                    "@@@@@BG@@@@@@@@@@#G@@@@&5B@@@@#B#@@@@@@@",
                    "@@@@&G#@@@@@@@@@@&G#@@@@PB@@@@@BG&@@@@@@",
                    "@@@@BB@@@@@@@@@@@@BB@@@@PB@@@@@@BB@@@@@@",
                    "@@@&G&@@@@@@@@@@@@&G&@@@PB@@@@@@@G#@@@@@",
                    "@@@BB@@@@@@@@@@@@@@&@@@@PB@@@@@@@&G#@@@@",
                    "@@@#&@@&&&@@&&&&&&&&&@@@G#@@@@@@@@&&@@@@",
                    "@@@@@@@@@@@@@@@@@&&&&&&@G#@@@@@@@@@@@@@@",
                    "@@@@@@@@@@@@@@@@@@@@@@@@&&@@@@@@@@@@@@@@",
                    "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"
            };

            for (String line : chairArt) {
                System.out.println(line);
            }
            Furniture furniture = new Furniture("Chair", 20.0, "A123", "WOOD", 3);
            Electronics electronics = new Electronics("Telephone", 2.5, "B456", 24, "C");
            Electronics electronics2 = new Electronics("TV", 50, "C789", 6, "A");

            System.out.println(furniture);
            System.out.println("Storage cost for 10 days: " + furniture.cost(10));
            System.out.println("Is fragile: " + furniture.isFragile());

            System.out.println("\n" + electronics);
            System.out.println("Storage cost for 10 days: " + electronics.cost(10));
            System.out.println("Is fragile: " + electronics.isFragile());

            System.out.println("\n" + electronics2);
            System.out.println("Storage cost for 10 days: " + electronics2.cost(10));
            System.out.println("Is fragile: " + electronics2.isFragile());
            System.out.println();


            Furniture myFurniture = new Furniture("Desk", 30.0, "C555", "Metal", 1);
            System.out.println("Furniture Name: " + myFurniture.getItemName());
            myFurniture.setItemName("Office Desk");
            System.out.println("New Furniture Name: " + myFurniture.getItemName());
            System.out.println("Furniture Weight: " + myFurniture.getItemWeight());
            System.out.println(myFurniture);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}