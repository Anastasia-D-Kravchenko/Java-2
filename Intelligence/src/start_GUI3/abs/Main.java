package start_GUI3.abs;

public class Main {
    public static void main(String[] args) {

        Lion lion = new Lion("Henry");

        lion.speak();

        //Animal animal = new Animal("Test"); // error

        Animal cat = new Animal("Tom") {
            @Override
            public void speak() {
                System.out.println("Nia");
            }
        };

        cat.speak();

    }
}
