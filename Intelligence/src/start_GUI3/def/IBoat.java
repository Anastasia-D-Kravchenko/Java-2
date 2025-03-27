package start_GUI3.def;

public interface IBoat {

    default void move(){
        System.out.println("I swim");
    }
}
