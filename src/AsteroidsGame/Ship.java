package AsteroidsGame;

import comp127graphics.*;
import java.awt.*;

public class Ship extends Ellipse {
    private final double X;
    private final double Y;
    private int health;
    static final double WIDTH = 70;
    static final double HEIGHT = 50;
    private AsteroidsManager asteroidsManager;
    private Beam beam;
    CanvasWindow canvas;


    public Ship(double X, double Y, AsteroidsManager asteroidsManager, int health, Beam beam, CanvasWindow canvas) {
        super(X, Y, 70, 50);
        this.X = X;
        this.Y = Y;
        this.setFillColor(Color.white);
        this.health = health;
        this.asteroidsManager = asteroidsManager;
        setCenter(X, Y);
        this.beam = beam;
        this.canvas = canvas;
    }

    private void updateHealthHit (double width) {
        //health += asteroidsManager.testHitHealth(beam.getX2(), beam.getY2());
        if (width == 150){
            health -= 20;
            this.setFillColor(Color.RED);
            canvas.onMouseDown(event -> {
                this.setFillColor(Color.white);
            });
        }
        if(width == 75){
            health -= 10;
            this.setFillColor(Color.RED);
            canvas.onMouseDown(event -> {
                this.setFillColor(Color.white);
            });
        }
        if(width == 37.5){
            health -= 5;
            this.setFillColor(Color.RED);
            canvas.onMouseDown(event -> {
                this.setFillColor(Color.white);
            });
        }


    }

    int getHealth() {
        return health;
    }

    boolean shipDestruction() {
        double left = asteroidsManager.testShipHit(X - WIDTH - 1, Y);
        if (left > 0) {
            //tests left side
            updateHealthHit(left);
            return true;
        }
        double right = asteroidsManager.testShipHit(X + WIDTH + 1, Y);
        if (right > 0) {
            //tests right side
            updateHealthHit(right);
            return true;
        }
        double top = asteroidsManager.testShipHit(X, Y - HEIGHT - 1);
        if (top > 0) {
            //tests top side
            updateHealthHit(top);
            return true;
        }
        double bottom = asteroidsManager.testShipHit(X, Y + HEIGHT + 1);
        if (bottom > 0) {
            //tests bottom side
            updateHealthHit(bottom);
            return true;
        }
        double topLeft = asteroidsManager.testShipHit(this.getX(), this.getY());
        if (topLeft > 0) {
            //tests top left corner
            updateHealthHit(topLeft);
            return true;
        }
        double topRight = asteroidsManager.testShipHit(this.getX() + WIDTH, this.getY());
        if (topRight > 0) {
            //tests top right corner
            updateHealthHit(topRight);
            return true;
        }
        double bottomLeft = asteroidsManager.testShipHit(this.getX(), this.getY() + HEIGHT);
        if (bottomLeft > 0) {
            //tests bottom left corner
            updateHealthHit(bottomLeft);
            return true;
        }
        double bottomRight = asteroidsManager.testShipHit(this.getX() + WIDTH, this.getY() + HEIGHT);
        if (bottomRight > 0) {
            //tests bottom right corner
            updateHealthHit(bottomRight);
            return true;
        }
        return false;
    }
}