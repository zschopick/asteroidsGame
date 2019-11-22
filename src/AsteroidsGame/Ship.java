package AsteroidsGame;

import comp127graphics.Path;
import comp127graphics.Point;

// 600 w 800 h
public class Ship {
    double x0;
    double y0;
    double x1;
    double y1;
    double x2;
    double y2;
    Path shipShape;
    int health;

    public Ship(double x0, double y0, double x1, double y1, double x2, double y2){
        shipShape = Path.makeTriangle(300,350,275,450,325,450);
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    Point getShipFront(){
        return new Point(this.x0, this.y0);
    }

    double getShipBottomX(){
        return (this.x1 + this.x2)/2;
    }
    double getShipBottomY(){
        return (this.y1 + this.y2)/2;
    }


    private void shoot(){

    }

    private int updateHealth(){
        return health;
    }


}
