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


    public ScoreBar(AsteroidsManager manager){
        this.manager = manager;
        group = new GraphicsGroup();
        label = new GraphicsText();
        label.setFont(FontStyle.BOLD, 30);
        label.setFillColor(Color.white);
        group.add(label);
        updateLayout();
    }

    void update() {
        //label.setText("Score: " + manager.getScore());
    }

    private void updateLayout() {
        label.setCenter(300, 50);
    }

    GraphicsObject getGraphics() {
        return group;
    }
}
