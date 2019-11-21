package AsteroidsGame;


import comp127graphics.Ellipse;

import java.awt.*;

public class Asteroids extends Ellipse{
    private final double asteroidRadius = 100;

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



}
