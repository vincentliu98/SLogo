package backend;

import javafx.beans.InvalidationListener;
import javafx.scene.paint.Color;

import java.util.Observable;
import java.util.Observer;


/**
 * @author Jose San Martin
 */
public class TurtleLeaf extends Observable implements Turtle{

    private double direction;
    private double size;
    private Color color;
    private double x;
    private double y;
    private boolean penDown;
    private boolean showing;

    @Override
    public String toString() {
        return "TurtleLeaf{" +
                "direction=" + direction +
                ", size=" + size +
                ", color=" + color +
                ", x=" + x +
                ", y=" + y +
                ", penDown=" + penDown +
                ", showing=" + showing +
                '}';
    }

    public void move(double distance) {
        this.setX(x + distance * Math.cos(direction));
        this.setY(y + distance * Math.sin(direction));
    }

    public void setPosition(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    public void turn(double angle) {
        direction += angle / 360 * 2 * Math.PI;
        if (direction >= 2 * Math.PI) {
            direction -= 2 * Math.PI;
        }
        if (direction <= 0) {
            direction += 2 * Math.PI;
        }
    }

    @Override
    public void penUp() {

    }

    @Override
    public void penDown() {

    }

    public void Changed() {
        setChanged();
    }

    public void clear() {
        clearChanged();
    }

    public void setHeading(double angle) {
        direction = angle;
    }

    public double getDirection() {
        return direction;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean getIsPenDown() {
        return this.penDown;
    }

    public boolean getIsShowing() {
        return this.showing;
    }

    public void liftPenUp() {

    }

    public void putPenDown() {

    }

    //Manually add observers
    public void addAnObserver(Observer o) {
        addObserver(o);
    }


    public void show() {

    }
    public void setDirection(double Direction){
        direction = Direction;
    }


    public void hide() {

    }
}
