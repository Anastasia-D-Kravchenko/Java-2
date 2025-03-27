package start_GUI3;

public class A implements /*OurInterface, MyInterface*/ IAll{

    @Override
    public void print() {
        System.out.println("Info");
    }

    @Override
    public void sayBye() {
        System.out.println("Bye");
    }

    @Override
    public void sayHello() {
        System.out.println("Hello");
    }
}
