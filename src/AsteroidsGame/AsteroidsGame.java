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
    private final int CANVAS_WIDTH = 1000;
    private final int CANVAS_HEIGHT = 800;
    private Button easy;
    private Button medium;
    private Button hard;
    private GraphicsGroup group;

    private GraphicsText gameTitle;
    private GraphicsText des1;
    private GraphicsText des2;
    private GraphicsText des3;
    private Button start;

    private Image asteroidImage;

    public AsteroidsGame() {
        createStartPage();
    }

    public static void main(String[] args){
        new AsteroidsGame();
    }

    public void update() {
       // asteroidImage.setImagePath("res/meteor.png");
        asteroidImage.setPosition(CANVAS_WIDTH * .1, CANVAS_HEIGHT * .3);
        gameTitle.setText("ASTEROIDS");
        gameTitle.setCenter(CANVAS_WIDTH * 0.48, CANVAS_HEIGHT * 0.2);
        des1.setText("In the game Asteroids, shoot down as many asteroids as possible to gain points--");
        des1.setCenter(CANVAS_WIDTH * 0.5, CANVAS_HEIGHT * 0.7);
        des2.setText("be careful not to get hit by any or you will lose health.");
        des2.setCenter(CANVAS_WIDTH * 0.5, CANVAS_HEIGHT * 0.73);
        des3.setText("Score as many points as possible and enjoy!");
        des3.setCenter(CANVAS_WIDTH * 0.5, CANVAS_HEIGHT * 0.76);
    }

    void createStartPage(){
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
        easy.onClick(() -> level = 10);
        group.add(easy);

        medium = new Button("MEDIUM");
        medium.setCenter(CANVAS_WIDTH * .8, CANVAS_HEIGHT * .5);
        medium.onClick(() -> level = 15);
        group.add(medium);

        hard = new Button("HARD");
        hard.setCenter(CANVAS_WIDTH * .8, CANVAS_HEIGHT * .55);
        hard.onClick(() -> level = 20);
        group.add(hard);

        asteroidImage = new Image(CANVAS_WIDTH * .4, CANVAS_HEIGHT * .3, "res/meteor.png");
        asteroidImage.setMaxWidth(CANVAS_WIDTH * .85);
        asteroidImage.setMaxHeight(CANVAS_HEIGHT * .85);
        group.add(asteroidImage);

        gameTitle = new GraphicsText();
        group.add(gameTitle);
        gameTitle.setFont(FontStyle.BOLD, CANVAS_WIDTH * 0.1);
        gameTitle.setFillColor(Color.white);

        des1 = new GraphicsText();
        group.add(des1);
        des1.setFont(FontStyle.BOLD, CANVAS_WIDTH * 0.015);
        des1.setFillColor(Color.white);

        des2 = new GraphicsText();
        group.add(des2);
        des2.setFont(FontStyle.BOLD, CANVAS_WIDTH * 0.015);
        des2.setFillColor(Color.white);

        des3 = new GraphicsText();
        group.add(des3);
        des3.setFont(FontStyle.BOLD, CANVAS_WIDTH * 0.015);
        des3.setFillColor(Color.white);

        update();
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

