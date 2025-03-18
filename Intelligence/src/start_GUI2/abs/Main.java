package start_GUI2.abs;

public class Main {
    public static void main(String[] args) {

        //AShape shape = new AShape(); //error

        Square squareOBJ = new Square(5);
        Rectangle rectangleOBJ = new Rectangle(2,3);

        AShape[] shapes = {squareOBJ, rectangleOBJ};

        for(AShape shape : shapes){
            System.out.println(shape.getArea());
        }

    }
}
