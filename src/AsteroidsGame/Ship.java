package AsteroidsGame;

import comp127graphics.CanvasWindow;
import comp127graphics.GraphicsObject;
import comp127graphics.Path;
import comp127graphics.Point;
import comp127graphics.events.MouseMotionEvent;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Ship extends Path {
    private double x0;
    private double y0;
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private int health = 100;
    private double mX;
    private double mY;
    private List<Point> points = new ArrayList<>();
    private Point point1;
    private Point point2;
    private Point point3;
    private AsteroidsManager asteroidsManager;



    public Ship(double x0, double y0, double x1, double y1, double x2, double y2, AsteroidsManager asteroidsManager) {
      //  makeTriangle(x0, y0, x1, y1, x2, y2);
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.asteroidsManager = asteroidsManager;
        this.setFillColor(Color.white);
        point1 = new Point(x0, y0);
        points.add(point1);
        point2 = new Point(x1, y1);
        points.add(point2);
        point3 = new Point(x2, y2);
        points.add(point3);
        setPosition(x0, y0);
        setVertices(points);

    }


    Point getShipFront() {
        return new Point(x0, y0);
    }

    double getShipBottomX() {
        return (x1 + x2) / 2;
    }

    double getShipBottomY() {
        return (y1 + y2) / 2;
    }

    double getX0() {
        return x0;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    double getY0() {
        return y0;
    }

    public void setY0(double y0) {
        this.y0 = y0;
    }

public void updateHealth(){

}

//needs work

void testForDestruction(){
    asteroidsManager.testHit(195, 345);
    asteroidsManager.testHit(195, 455);
    asteroidsManager.testHit(405, 345);
    asteroidsManager.testHit(140, 455);
}

//public void setCurrentPosition(comp127graphics.Point position){
//
//        this.setPosition(position.getX(),y);
//}
public void setCurrentPosition(MouseMotionEvent evt){
    mX =evt.getPosition().getX();//mouse X
    mY =evt.getPosition().getY();//mouse Y
    double Xdist =mX-this.x0; //Get x distance from mouse to ship
    double Ydist =mY-this.y0; //Get y distance from mouse to ship
    double radAngle = Math.atan(Ydist/Xdist); //Use atan to calculate the angle
//    if(mX >= this.x0){
//        littleY = Math.sin(radAngle)*15;
//        littleX = Math.cos(radAngle)*15;
//    }else{
//        littleY = Math.sin(radAngle)*-15;
//        littleX = Math.cos(radAngle)*-15;
//    }
//    this.setPosition();
}

}