package AsteroidsGame;

import comp127graphics.Ellipse;

import java.awt.*;

public class BeamBlast extends Ellipse {
    private Ship shipShape;
    private double x;
    private double y;
    public double radius;
    /**
     * Creates an ellipse whose upper left is at (x,y), and which has the specified width and height.
     * @param x      position
     * @param y      position
     */
    public BeamBlast(double x, double y, double radius, Ship shipShape) {
        super(x, y, radius*2, radius*2);
        this.x = x;
        this.y = y;
        this.setFillColor(Color.green);

    }

    private void setStart(){
        this.setPosition(shipShape.getShipFront());
    }

    private double calculateAngle(){
        double x0 = shipShape.x0;
        double y0 = shipShape.y0;
        double x3 = shipShape.getShipBottomX();
        double y3 = shipShape.getShipBottomY();

        return (x3-x0)/(y3-y0);
    }

    void updatePosition() {
        //shipShape.x0;
    }
}
