package start_GUI3.def;

public class Amphibious implements ICar, IBoat {
    private boolean inWater = true;

    public boolean isInWater() {
        return inWater;
    }

    public void setInWater(boolean inWater) {
        this.inWater = inWater;
    }

    @Override
    public void move() {
        if (inWater)
            IBoat.super.move();
        else
            ICar.super.move();
    }
}
