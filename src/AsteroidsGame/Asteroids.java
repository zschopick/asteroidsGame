package AsteroidsGame;


import comp127graphics.CanvasWindow;
import comp127graphics.Ellipse;

import java.awt.*;

public class Asteroids extends Ellipse{
    private final double asteroidRadius = 100;
    private double dX = .1;
    private double dY = .1;
    private double xPos;
    private double yPos;

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

        xPos = getX() + dX;
        yPos = getY() + dY;
        setPosition(xPos, yPos);
    }



}
