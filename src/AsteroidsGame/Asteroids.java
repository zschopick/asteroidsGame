package AsteroidsGame;


import comp127graphics.CanvasWindow;
import comp127graphics.Ellipse;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Asteroids extends Ellipse{
    private double dX;
    private double dY;

    /**
     * Creates an ellipse whose upper left is at (x,y), and which has the specified width and height.
     * It has a 1 pixel black stroke outline by default.
     *
     * @param x      position
     * @param y      position
     */
    public Asteroids(double x, double y, double width) {
        super(x, y,width, width);
        setStrokeColor(Color.GRAY);
        setStrokeWidth(3);
        setdX((Math.random()*2-1)*1.5);   //picks random double between -1 and 1
        setdY((Math.random()*2-1)*1.5);

    }

    void updatePosition(CanvasWindow canvas){
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

        double xPos = getX() + getdX();
        double yPos = getY() + getdY();
        setPosition(xPos, yPos);
    }

    private double getdX() {
        return dX;
    }


    private void setdX(double dX) {
        this.dX = dX;
    }

    private void setdY(double dY){
        this.dY = dY;
    }

    private double getdY() {
        return dY;
    }

    @Override
    public double getWidth() {
        return super.getWidth();
    }
}


