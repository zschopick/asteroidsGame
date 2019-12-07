package AsteroidsGame;

import comp127graphics.Rectangle;

import java.awt.*;

public class Health extends Rectangle {
    private double x;
    private double y;
    private double width;
    private double height;

    public Health(double x, double y, double width, double height) {
        super(x, y, width, height);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.setFillColor(Color.RED);
        this.setFilled(true);
    }
}
