package AsteroidsGame;

import comp127graphics.Rectangle;

import java.awt.*;

public class HealthObjs extends Rectangle {

    private final double WIDTH = 20;
    private final double HEIGHT = 20;


    public HealthObjs(double x, double y) {
        super(x, y, 20, 20);
        setFillColor(Color.RED);
        setFilled(true);
    }
}
