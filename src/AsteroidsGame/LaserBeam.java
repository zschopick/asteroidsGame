package AsteroidsGame;

import comp127graphics.Line;

import java.awt.*;

public class LaserBeam extends Line {
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
    public LaserBeam(double x1, double y1, double x2, double y2, Ship shipShape) {
        super(x1, y1, x2, y2);
        super.setStrokeColor(Color.green);
        super.setStrokeWidth(3);
        this.setStartPosition(shipShape.getShipFront());
    }


}
