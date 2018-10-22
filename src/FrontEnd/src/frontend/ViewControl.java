package frontend;

import javafx.scene.paint.Color;

/** This class serves as a mediator between the Command class and the View class.
 *  It provides an API for the Command to modify the front end without exposing front end implementation
 *  or giving a reference of the frontend to the backend.
 * @author bpx
 * */
public class ViewControl {
    private DisplayView myView;
    public ViewControl(DisplayView dview){
        myView = dview;
    }

    public void setPenColor(Color color){
        myView.changePenColor(color);
    }

    public void setPenSize(double size){
        myView.changePenSize(size);
    }

    public void penUp(){
        myView.setPenDown(false);
    }

    public void penDown(){
        myView.setPenDown(true);
    }

    public void setBackgroundColor(Color color){
        myView.changeBgColor(color);
    }

    public void setTurtleShape(){
        // ????
    }

    public void showTurtle(){
        myView.showTurtle();
    }

    public void hideTurtle(){
        myView.hideTurtle();
    }

    public void setTurtleSize(double size){
        myView.changeTurtleSize(size);
    }

    public void clearView(){
        myView.clearBg();
    }
}