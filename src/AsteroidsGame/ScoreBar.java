package AsteroidsGame;

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

    void update() {
        label.setText("Score: " + manager.getScore());
    }

    private void updateLayout() {
        label.setCenter(width*.75, height*.05);
    }

    GraphicsObject getGraphics() {
        return group;
    }
}
