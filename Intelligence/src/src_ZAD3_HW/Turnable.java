package src_ZAD3_HW;

public interface Turnable {
//Should return direction in degrees it towards to
    int getDirection();
//Should turn -90 degrees
    void turnLeft();
//Should turn -degrees number
    void turnLeft(int degrees);
//Should turn +90 degrees
    void turnRight();
//Should turn +degrees number
    void turnRight(int degrees);
//     After providing one of direction as parameter (North / East / South / West) should override direction it towards to.
//     (0 / 90 / 180 / 270)
//     @throws IllegalArgumentException when direction provided as parameter is different from allowed list
    void headTowards(String direction) throws IllegalArgumentException;
}
