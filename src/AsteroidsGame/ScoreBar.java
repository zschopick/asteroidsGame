package AsteroidsGame;
/**
 * Graphics text that displays to the canvas the current score of the player.
 */

import comp127graphics.FontStyle;
import comp127graphics.GraphicsGroup;
import comp127graphics.GraphicsObject;
import comp127graphics.GraphicsText;

import java.awt.*;

public class ScoreBar {
    private GraphicsGroup group;
    private GraphicsText label;
    private AsteroidsManager manager;
   private double width;
   private double height;

    /**
     * Creates the scorebar using GraphicsGroup and GraphicsText.
     * @param manager
     * @param width
     * @param height
     */
    public ScoreBar(AsteroidsManager manager, double width, double height){
        this.manager = manager;
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
     * Changes the scorebar to the current score of the player.
     */
    void update() {
        label.setText("Score: " + manager.getScore());
    }

    /**
     * Sets the position of the GraphicsText Object.
     */
    private void updateLayout() {
        label.setCenter(width*.75, height*.05);
    }

    /**
     * Returns the graphics object that is inside the GraphicsGroup object created.
     * @return group
     */
    GraphicsObject getGraphics() {
        return group;
    }
}
