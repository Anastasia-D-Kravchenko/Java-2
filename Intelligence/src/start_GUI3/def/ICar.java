package start_GUI3.def;

public interface ICar {

    default void move(){
        System.out.println("I drive");
    }
}
