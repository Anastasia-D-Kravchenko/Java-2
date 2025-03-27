package src_ZAD3_HW;

public abstract class Vehicle {
    private String make;
    private String model;
    private int productionYear;

    public Vehicle(String make, String model, int productionYear) {
        this.make = make;
        this.model = model;
        this.productionYear = productionYear;
    }

    public abstract void start();
    public abstract void stop();
    public abstract String getStatusDescription();

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void flex() {
        if(this.make.equals("Rolls-Royce")) {
            System.out.println("This is " + this.getMake() + " " + this.getModel() + " from " + this.getProductionYear());
        }
    }
}
