package backend;

/**
 * @author Jose San Martin
 * An interface for our turtles
 *  Implements the Composite design pattern
 */
public interface Turtle{

    public void move(double distance);

    void turn(double angle);

    void penUp();

    void penDown();

    void show();

    void hide();

    void setPosition(double x, double y);

    void Changed();

    void clear();

    void setHeading(double angle);

   //double getDirection();

   //double getX();

   //void setX(double x);

   //double getY();

   //void setY(double y);

   //boolean getIsPenDown();

   //boolean getIsShowing();

    void liftPenUp();

    void putPenDown();

}
