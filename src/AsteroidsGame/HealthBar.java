package AsteroidsGame;

import comp127graphics.FontStyle;
import comp127graphics.GraphicsGroup;
import comp127graphics.GraphicsObject;
import comp127graphics.GraphicsText;

import java.awt.*;

/**
 * A GraphicsText object that shows the health of the ship.
 */
class HealthBar {

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

    /**
     * Sets the text of the label with the ships current health.
     */
    void update() {
        label.setText("Health: " + ship.getHealth());
    }

    /**
     * Sets the position of the label.
     */
    private void updateLayout() {
        label.setCenter(width*.075, height*.05);
    }

    /**
     * Gets the Graphics group object that includes the health Object.
     * @return group
     */
    GraphicsObject getGraphics() {
        return group;
    }
}