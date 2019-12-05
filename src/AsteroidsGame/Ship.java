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

    public void updateHealth() {
        if (testForDestruction()) {
            health -= 20;
            System.out.println("remainging health: " + health);
        }
    }

    int getHealth() {
        return health;
    }

    //update test points
    boolean testForDestruction() {
        if (asteroidsManager.testHit(X - WIDTH - 1, Y)) {
            //tests left side
            return true;
        }
        if (asteroidsManager.testHit(X + WIDTH + 1, Y)) {
            //tests right side
            return true;
        }
        if (asteroidsManager.testHit(X, Y - HEIGHT - 1)) {
            //tests top side
            return true;
        }
        if (asteroidsManager.testHit(X, Y + HEIGHT + 1)) {
            //tests bottom side
            return true;
        }
        if (asteroidsManager.testHit(this.getX(), this.getY())) {
            //tests top left corner
            return true;
        }
        if (asteroidsManager.testHit(this.getX() + WIDTH, this.getY())) {
            //tests top right corner
            return true;
        }
        if (asteroidsManager.testHit(this.getX(), this.getY() + HEIGHT)) {
            //tests bottom left corner
            return true;
        }
        //tests bottom right corner
        return asteroidsManager.testHit(this.getX() + WIDTH, this.getY() + HEIGHT);
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