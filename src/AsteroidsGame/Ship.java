package AsteroidsGame;


import comp127graphics.Fillable;
import comp127graphics.Line;

import java.awt.*;


public class Ship implements Fillable {

    Line line1;
    Line line2;
    Line line3;
    private Paint fillColor;
    private boolean isFilled;


    public Ship(int x1, int y1, int x2, int y2, int x3, int y3){
        line1 = new Line(x1,y1,x2,y2);
        line2 = new Line(x2, y2, x3, y3);
        line3 = new Line(x3, y3, x1, y1);
        fillColor = Color.RED;
        isFilled = true;

    }





    @Override
    public Paint getFillColor() {
        return null;
    }

    @Override
    public void setFillColor(Paint fillColor) {

    }

    @Override
    public boolean isFilled() {
        return false;
    }

    @Override
    public void setFilled(boolean filled) {

    }
}
