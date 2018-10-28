package backend;

import javafx.scene.paint.Color;

import java.util.Observable;
import java.util.Observer;


/**
 * @author Jose San Martin
 */
public class TurtleLeaf extends Observable implements Turtle {

    private double direction;
    private double size;
    private Color color;
    private double x;
    private double y;
    private boolean penDown;
    private boolean showing;
    private Integer id;
    private boolean isActive;

    public Integer getId() {
        return id;
    }

    public TurtleLeaf(Integer id) {
        this.id = id;
    }

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
                ", id=" + id +
                '}';
    }

    public void move(double distance) {
        if(!isActive)
            return;
        this.setX(x + distance * Math.cos(direction));
        this.setY(y + distance * Math.sin(direction));
    }

    public void setPosition(double x, double y) {
        if(!isActive)
            return;
        this.setX(x);
        this.setY(y);
    }

    public void turn(double angle) {
        if(!isActive)
            return;
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
        if(!isActive)
            return;
        this.penDown = false;
    }

    @Override
    public void penDown() {
        if(!isActive)
            return;
        this.penDown = true;
    }

    public void Changed() {
        setChanged();
    }

    public void clear() {
        clearChanged();
    }

    public void setHeading(double angle) {
        if(!isActive)
            return;
        direction = angle;
    }

    public double getDirection() {
        return direction;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        if(!isActive)
            return;
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        if(!isActive)
            return;
        this.y = y;
    }

    public boolean getIsPenDown() {
        return this.penDown;
    }

    public boolean getIsShowing() {
        return this.showing;
    }

    //Manually add observers
    public void addAnObserver(Observer o) {
        addObserver(o);
    }

    public void show() {
        if(!isActive)
            return;
        showing = true;
    }

    public void setDirection(double Direction) {
        direction = Direction;
    }


    public void hide() {
        if(!isActive)
            return;
        showing = false;
    }

    public Turtle getTurtleLeaf(Integer id){
        return this;
    }

    public void notifyAllObservers(Object o){
        return;
    }
    public void notifyAllObservers(){
        return;
    }
}
