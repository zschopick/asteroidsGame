package AsteroidsGame;

import comp127graphics.Path;
import comp127graphics.Point;

import java.awt.*;

public class Ship extends Path {
    private double x0;
    private double y0;
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public Ship(double x0, double y0, double x1, double y1, double x2, double y2) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
//        Ship shipShape = Path.makeTriangle(300, 350, 275, 450, 325, 450);
        this.setFillColor(Color.white);
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


}