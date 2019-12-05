package AsteroidsGame;

import comp127graphics.CanvasWindow;
import comp127graphics.Line;
import comp127graphics.events.MouseButtonEvent;
import java.awt.MouseInfo;

import java.awt.*;

public class Beam extends Line {
    CanvasWindow canvas;
    private double x1;
    private double x2;
    private double y1;
    private double y2;
    private Ship shipShape;

    /**
     * Creates a line starting at position (x1,y1) and ending at (x2,y2).
     * The line has a 1 pixel black stroke outline by default.
     *
     * @param x1 x position of starting point
     * @param y1 y position of starting point
     * @param x2 x position of ending point
     * @param y2 y position of ending point
     */
    public Beam(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.setStrokeWidth(5);
        this.setStroked(true);
        this.setStrokeColor(Color.GREEN);

    }
}



//    public double getEndX(){
//        canvas.onClick(event -> event.getPosition().getX());
//    }
//
//    public double getEndY(){
//        canvas.onClick(event -> event.getPosition().getY());
//    }

//    public void shootBeam(CanvasWindow canvas){
//       canvas.onClick(() -> this.draw((shipShape.getX(), shipShape.getY(), MouseInfo.getPointerInfo().getLocation().getX(), MouseInfo.getPointerInfo().getLocation().getY()));
//
//
//    }
//
//    public void createBeam(){
//
//    }
//}
