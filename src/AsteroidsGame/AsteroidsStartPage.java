package AsteroidsGame;

import comp127graphics.*;
import comp127graphics.Image;
import comp127graphics.ui.Button;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class AsteroidsStartPage implements MouseListener, MouseMotionListener {
    CanvasWindow startCanvas;
    private final int CANVAS_WIDTH = 600;
    private final int CANVAS_HEIGHT = 800;
    private GraphicsGroup group;

    private GraphicsText gameTitle;
    private GraphicsText description;
    private Button start;

    private Image asteroidImage;

    public AsteroidsStartPage() {
        startCanvas = new CanvasWindow("Asteroids!", CANVAS_WIDTH, CANVAS_HEIGHT);
        startCanvas.setBackground(Color.DARK_GRAY);

        group = new GraphicsGroup();
        startCanvas.add(group);

        start = new Button("START");
        start.setCenter(CANVAS_WIDTH * .5, CANVAS_HEIGHT * .5);
        start.onClick(() -> new AsteroidsGame());
        group.add(start);

      //  asteroidImage = new Image(CANVAS_WIDTH * .4, CANVAS_HEIGHT * .3, "Downloads/meteor.png");
        asteroidImage.setMaxWidth(CANVAS_WIDTH * .85);
        asteroidImage.setMaxHeight(CANVAS_HEIGHT * .85);
        group.add(asteroidImage);

        gameTitle = new GraphicsText();
        gameTitle.setFont(FontStyle.BOLD, CANVAS_WIDTH * 0.07);
        group.add(gameTitle);

        description = new GraphicsText();
        description.setFont(FontStyle.BOLD, CANVAS_WIDTH * 0.07);
        group.add(description);

        update();
    }

    public void update() {
        asteroidImage.setImagePath("Downloads/meteor.png");
        asteroidImage.setPosition(CANVAS_WIDTH * .08, CANVAS_HEIGHT * .23);
        gameTitle.setText("ASTEROIDS");
        gameTitle.setCenter(CANVAS_WIDTH * 0.48, CANVAS_HEIGHT * 0.1);
        description.setText("This game...");
        description.setCenter(CANVAS_WIDTH * 0.48, CANVAS_HEIGHT * 0.85);
        start.onClick(() -> new AsteroidsGame());

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}

