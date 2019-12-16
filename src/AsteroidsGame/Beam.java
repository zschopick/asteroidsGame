package AsteroidsGame;

import comp127graphics.CanvasWindow;
import comp127graphics.Line;
import comp127graphics.events.MouseButtonEvent;
import java.awt.MouseInfo;

import java.awt.*;

class Beam extends Line {

    /**
     * Creates a line starting at position (x1,y1) and ending at (x2,y2).
     * The line has a 1 pixel black stroke outline by default.
     *
     * @param x1 x position of starting point
     * @param y1 y position of starting point
     * @param x2 x position of ending point
     * @param y2 y position of ending point
     */
    Beam(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
        this.setStrokeWidth(3);
        this.setStroked(true);
        this.setStrokeColor(Color.GREEN);

    }
}
