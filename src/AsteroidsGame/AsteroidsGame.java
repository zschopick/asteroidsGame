package AsteroidsGame;

import comp127graphics.*;
import comp127graphics.Image;
import comp127graphics.ui.Button;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class AsteroidsGame extends GraphicsGroup implements MouseListener, MouseMotionListener {
    private static int level = 5;
    private CanvasWindow startCanvas;
    private final int CANVAS_WIDTH = 600;
    private final int CANVAS_HEIGHT = 800;
    private Button easy;
    private Button medium;
    private Button hard;
    private GraphicsGroup group;

    private GraphicsText gameTitle;
    private GraphicsText description;
    private Button start;

    private Image asteroidImage;

    public AsteroidsGame() {
        startCanvas = new CanvasWindow("Asteroids!", CANVAS_WIDTH, CANVAS_HEIGHT);
        Color color = new Color (44, 50, 120);
        startCanvas.setBackground(color);

        group = new GraphicsGroup();
        startCanvas.add(group);

        start = new Button("START");
        start.setCenter(CANVAS_WIDTH * .5, CANVAS_HEIGHT * .5);
        start.onClick(() -> new Game());
        group.add(start);

        easy = new Button("EASY");
        easy.setCenter(CANVAS_WIDTH * .8, CANVAS_HEIGHT * .45);
        easy.onClick(() -> level = 5);
        group.add(easy);

        medium = new Button("MEDIUM");
        medium.setCenter(CANVAS_WIDTH * .8, CANVAS_HEIGHT * .5);
        medium.onClick(() -> level = 10);
        group.add(medium);

        hard = new Button("HARD");
        hard.setCenter(CANVAS_WIDTH * .8, CANVAS_HEIGHT * .55);
        hard.onClick(() -> level = 15);
        group.add(hard);

        asteroidImage = new Image(CANVAS_WIDTH * .4, CANVAS_HEIGHT * .3, "res/meteor.png");
        asteroidImage.setMaxWidth(CANVAS_WIDTH * .85);
        asteroidImage.setMaxHeight(CANVAS_HEIGHT * .85);
        group.add(asteroidImage);

        gameTitle = new GraphicsText();
        group.add(gameTitle);
        gameTitle.setFont(FontStyle.BOLD, CANVAS_WIDTH * 0.1);
        gameTitle.setFillColor(Color.white);

        description = new GraphicsText();
        group.add(description);
        description.setFont(FontStyle.BOLD, CANVAS_WIDTH * 0.07);
        description.setFillColor(Color.white);

        update();
    }

    public void update() {
       // asteroidImage.setImagePath("res/meteor.png");
        asteroidImage.setPosition(CANVAS_WIDTH * .1, CANVAS_HEIGHT * .3);
        gameTitle.setText("ASTEROIDS");
        gameTitle.setCenter(CANVAS_WIDTH * 0.48, CANVAS_HEIGHT * 0.1);
        description.setText("This game...");
        description.setCenter(CANVAS_WIDTH * 0.48, CANVAS_HEIGHT * 0.85);
    }

    public static void main(String[] args){
        new AsteroidsGame();
    }

    static int getLevel(){
        return level;
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

