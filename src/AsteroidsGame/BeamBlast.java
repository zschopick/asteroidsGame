package AsteroidsGame;

import comp127graphics.CanvasWindow;
import comp127graphics.Ellipse;
import comp127graphics.events.MouseButtonEvent;

import java.awt.*;

public class BeamBlast extends Ellipse {
    CanvasWindow canvas;
    private Ship shipShape;
    private double x;
    private double y;
    public double radius;
    public static final double centerX = 300;
    public static final double centerY = 400;
    /**
     * Creates an ellipse whose upper left is at (x,y), and which has the specified width and height.
     * @param x      position
     * @param y      position
     */
    public BeamBlast(double x, double y, double radius, Ship shipShape, CanvasWindow canvas) {
        super(x, y, radius*2, radius*2);
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.setFillColor(Color.green);
        this.shipShape = shipShape;
        this.canvas = canvas;
        this.setPosition(centerX,centerY);
    }

//    private double calculateSlope(){
//        double x3 = shipShape.getShipBottomX();
//        double y3 = shipShape.getShipBottomY();
//
//        return (x3-centerX)/(y3-centerY);
//    }
//
//    private boolean xDirectionPositive(){
//        double x3 = shipShape.getShipBottomX();
//        return x3-centerX > 0;
   // }

//    void updateBeamPosition() {
//        double slope = calculateSlope();
//        if (xDirectionPositive()){
//            x++;
//        }
//        else {
//            x--;
//        }
//        y = slope * x + shipShape.getY();
//        this.setPosition(x,y);
//    }

    private void removeBeam(){
        canvas.remove(this);
    }

//    private void blast(MouseButtonEvent evt){
//        double posX = evt.getPosition().getX();
//        double posY = evt.getPosition().getY();
//        double slope = (posX-centerX)/(posY-centerY);
//        if (xDirectionPositive()){
//            x++;
//        }
//        else {
//            x--;
//        }
//        y = slope * x + centerY;
//        this.setPosition(x,y);
//
//
//    }


}
