package AsteroidsGame;

import comp127graphics.*;
import comp127graphics.Point;
import comp127graphics.events.MouseMotionEvent;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Ship extends Ellipse {
    private final double X;
    private final double Y;
    private int health;
    private double mX;
    private double mY;
    static final double WIDTH = 70;
    static final double HEIGHT = 50;
    private AsteroidsManager asteroidsManager;

    public Ship(double X, double Y, AsteroidsManager asteroidsManager, int health) {
        super(X, Y, 70, 50);
        this.X = X;
        this.Y = Y;
        this.setFillColor(Color.white);
        this.health = health;
        this.asteroidsManager = asteroidsManager;
        setCenter(X, Y);
    }

    private void updateHealth(double width) {
        if (width == 100){
        health -= 20;
        }
        if(width == 50){
            health -= 10;
        }
        if(width == 25){
            health -= 5;
        }

    }

    int getHealth() {
        return health;
    }

    boolean shipDestruction() {
        double left = asteroidsManager.testHit(X - WIDTH - 1, Y);
        if (left > 0) {
            //tests left side
            updateHealth(left);
            return true;
        }
        double right = asteroidsManager.testHit(X + WIDTH + 1, Y);
        if (right > 0) {
            //tests right side
            updateHealth(right);
            return true;
        }
        double top = asteroidsManager.testHit(X, Y - HEIGHT - 1);
        if (top > 0) {
            //tests top side
            updateHealth(top);
            return true;
        }
        double bottom = asteroidsManager.testHit(X, Y + HEIGHT + 1);
        if (bottom > 0) {
            //tests bottom side
            updateHealth(bottom);
            return true;
        }
        double topLeft = asteroidsManager.testHit(this.getX(), this.getY());
        if (topLeft > 0) {
            //tests top left corner
            updateHealth(topLeft);
            return true;
        }
        double topRight = asteroidsManager.testHit(this.getX() + WIDTH, this.getY());
        if (topRight > 0) {
            //tests top right corner
            updateHealth(topRight);
            return true;
        }
        double bottomLeft = asteroidsManager.testHit(this.getX(), this.getY() + HEIGHT);
        if (bottomLeft > 0) {
            //tests bottom left corner
            updateHealth(bottomLeft);
            return true;
        }
        double bottomRight = asteroidsManager.testHit(this.getX() + WIDTH, this.getY() + HEIGHT);
        if (bottomRight > 0) {
            //tests bottom right corner
            updateHealth(bottomRight);
            return true;
        }
        return false;
    }

//public void setCurrentPosition(comp127graphics.Point position){
//
//        this.setPosition(position.getX(),y);
//}
public void setCurrentPosition(MouseMotionEvent evt){
    mX =evt.getPosition().getX();//mouse X
    mY =evt.getPosition().getY();//mouse Y
//    double Xdist =mX-this.x0; //Get x distance from mouse to ship
//    double Ydist =mY-this.y0; //Get y distance from mouse to ship
//    double radAngle = Math.atan(Ydist/Xdist); //Use atan to calculate the angle
//    setPosition(mX, mY);


}
}