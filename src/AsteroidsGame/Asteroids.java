package AsteroidsGame;


import comp127graphics.CanvasWindow;
import comp127graphics.Ellipse;

import java.awt.*;

public class Asteroids extends Ellipse{
    private final double asteroidRadius = 100;
    private double dX = 1.6;
    private double dY = 1.6;
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
            setCenter(getX(), canvas.getHeight() - canvas.getHeight());
        }
        if (getY() < 0 ){
            setCenter(getX(), canvas.getHeight());
        }
        if (getX()> canvas.getWidth()){
            setCenter(0, getY());
        }
        if (getX() < 0){
            setCenter(canvas.getWidth(), getY());
        }

        xPos = getX() +dX;
        yPos = getY() + dY;
        setCenter(xPos, yPos);
    }



}
