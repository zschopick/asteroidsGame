package AsteroidsGame;


import comp127graphics.CanvasWindow;
import comp127graphics.Ellipse;

import java.awt.*;
import java.util.Random;

public class Asteroids extends Ellipse{
    private final double asteroidRadius = 100;
    private double dX;
    private double dY;
    private double xPos;
    private double yPos;
    private Random rand;

    /**
     * Creates an ellipse whose upper left is at (x,y), and which has the specified width and height.
     * It has a 1 pixel black stroke outline by default.
     *
     * @param x      position
     * @param y      position
     */
    public Asteroids(double x, double y) {
        super(x, y, 100, 100);
        setStrokeColor(Color.white);
        rand = new Random();
        setdX(rand.nextDouble());
        setdY(rand.nextDouble());

    }

    public void updatePosition(CanvasWindow canvas){
        if (getY() > canvas.getHeight()){
            setPosition(getX(), 0);
        }
        if (getY() < 0 ){
            setPosition(getX(), canvas.getHeight());
        }
        if (getX()> canvas.getWidth()){
            setPosition(0, getY());
        }
        if (getX() < 0){
            setPosition(canvas.getWidth(), getY());
        }

        xPos = getX() + getdX();
        yPos = getY() + getdY();
        setPosition(xPos, yPos);
    }

    private double getdX() {
        return dX;
    }


    public void setdX(double dX) {
        this.dX = dX;
    }

    public void setdY(double dY){
        this.dY = dY;
    }

    public double getdY() {
        return dY;
    }
}


