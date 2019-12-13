package AsteroidsGame;
/**
 * A GraphicsText object that shows the health of the ship.
 */

import comp127graphics.FontStyle;
import comp127graphics.GraphicsGroup;
import comp127graphics.GraphicsObject;
import comp127graphics.GraphicsText;

import java.awt.*;


public class HealthBar {

    private GraphicsGroup group;
    private GraphicsText label;
    private Ship ship;
    private double width;
    private double height;

    /**
     * Creates a healthbar object.
     * @param ship
     * @param width
     * @param height
     */
    HealthBar(Ship ship, double width, double height) {
        this.ship = ship;
        this.width = width;
        this.height = height;
        group = new GraphicsGroup();
        label = new GraphicsText();
        label.setFont(FontStyle.BOLD, 30);
        label.setFillColor(Color.white);
        group.add(label);
        updateLayout();
    }

    void update() {
        label.setText("Health: " + ship.getHealth());
    }

    private void updateLayout() {
        label.setCenter(width*.075, height*.05);
    }

    GraphicsObject getGraphics() {
        return group;
    }
}