package start_GUI2.abs;

public class Square extends AShape{

    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return Math.pow(this.side, 2);
    }
}
