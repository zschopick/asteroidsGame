package AsteroidsGame;

import comp127graphics.*;
import java.awt.*;

public class Ship extends Ellipse {
    private final double X;
    private final double Y;
    public int health;
    static final double WIDTH = 70;
    static final double HEIGHT = 50;
    private AsteroidsManager asteroidsManager;
    private Beam beam;

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
        if (width == 150){
            health -= 20;
        }
        if(width == 75){
            health -= 10;
        }
        if(width == 37.5){
            health -= 5;
        }
//        if(asteroidsManager.testHitHealth(beam.getX1(), beam.getY1())){
//            health += 10;
//            asteroidsManager.destroyHealthObj();
//        }



    }

    int getHealth() {
        return health;
    }

    boolean shipDestruction() {
        double left = asteroidsManager.testShipHit(X - WIDTH - 1, Y);
        if (left > 0) {
            //tests left side
            updateHealth(left);
            return true;
        }
        double right = asteroidsManager.testShipHit(X + WIDTH + 1, Y);
        if (right > 0) {
            //tests right side
            updateHealth(right);
            return true;
        }
        double top = asteroidsManager.testShipHit(X, Y - HEIGHT - 1);
        if (top > 0) {
            //tests top side
            updateHealth(top);
            return true;
        }
        double bottom = asteroidsManager.testShipHit(X, Y + HEIGHT + 1);
        if (bottom > 0) {
            //tests bottom side
            updateHealth(bottom);
            return true;
        }
        double topLeft = asteroidsManager.testShipHit(this.getX(), this.getY());
        if (topLeft > 0) {
            //tests top left corner
            updateHealth(topLeft);
            return true;
        }
        double topRight = asteroidsManager.testShipHit(this.getX() + WIDTH, this.getY());
        if (topRight > 0) {
            //tests top right corner
            updateHealth(topRight);
            return true;
        }
        double bottomLeft = asteroidsManager.testShipHit(this.getX(), this.getY() + HEIGHT);
        if (bottomLeft > 0) {
            //tests bottom left corner
            updateHealth(bottomLeft);
            return true;
        }
        double bottomRight = asteroidsManager.testShipHit(this.getX() + WIDTH, this.getY() + HEIGHT);
        if (bottomRight > 0) {
            //tests bottom right corner
            updateHealth(bottomRight);
            return true;
        }
        return false;
    }
}