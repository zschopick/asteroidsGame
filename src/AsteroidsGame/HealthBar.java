package AsteroidsGame;

import comp127graphics.FontStyle;
import comp127graphics.GraphicsGroup;
import comp127graphics.GraphicsObject;
import comp127graphics.GraphicsText;

public class HealthBar {

    private GraphicsGroup group;
    private GraphicsText label;
    private Ship ship;

    HealthBar(Ship ship) {
        this.ship = ship;
        group = new GraphicsGroup();
        label = new GraphicsText();
        label.setFont(FontStyle.BOLD, 100);
        group.add(label);
        updateLayout();
    }

    void update() {
        label.setText("Health: " + ship.getHealth());
    }

    private void updateLayout() {
        label.setCenter(20, 20);
    }

    GraphicsObject getGraphics() {
        return group;
    }
}