package src_ZAD3_HW;

public interface Drivable {
    int MAX_SPEED = 180; //always public static final
    void driveForward();
    void driveForward(int withSpeed) throws IllegalArgumentException;
    void driveBackward();
    void driveBackward(int withSpeed);
    static int getMaxSpeed() {
        return MAX_SPEED;
    }
    default void assignDriver() {
        System.out.println("Driver assigned");
    }
}
