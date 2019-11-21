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
     * @param width  of the bounding rectangle
     * @param height of the bounding rectangle
     */
    public Asteroids(double x, double y, double width, double height) {
        super(x, y, width, height);
        setStrokeColor(Color.white);
    }


}
