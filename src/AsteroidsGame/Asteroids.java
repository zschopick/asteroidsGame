package AsteroidsGame;

import comp127graphics.CanvasWindow;
import comp127graphics.Ellipse;
import java.awt.*;

public class Asteroids extends Ellipse{
    private double dX;
    private double dY;

    /**
     * Creates an ellipse whose upper left is at (x,y), and which has the specified width and height.
     * It has a 1 pixel black stroke outline by default.
     */
    public Asteroids(double x, double y, double width) {
        super(x, y,width, width);
        setStrokeColor(Color.GRAY);
        setStrokeWidth(3);
        setdX((Math.random()*2-1)*1.5);   //picks random double between -1 and 1
        setdY((Math.random()*2-1)*1.5);

    }

    /**
     * If the asteroid is flying out of the side or top of the canvas, method sets its position to appear on the other side of the canvas.
     * Also is responsible for changing the x position and y position of the asteroid.
     * @param canvas
     */
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

    /**
     * Gives the current x speed of the asteroid
     * @return dX
     */
    private double getdX() {
        return dX;
    }

    /**
     * Sets the x speed of the asteroid
     * @param dX
     */
    private void setdX(double dX) {
        this.dX = dX;
    }
    /**
     * Sets the y speed of the asteroid
     * @param dY
     */
    private void setdY(double dY){
        this.dY = dY;
    }
    /**
     * Gives the current y speed of the asteroid
     * @return dX=Y
     */
    private double getdY() {
        return dY;
    }

    @Override
    public double getWidth() {
        return super.getWidth();
    }
}


