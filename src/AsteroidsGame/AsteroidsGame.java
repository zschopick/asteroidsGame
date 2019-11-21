package AsteroidsGame;

import comp127graphics.CanvasWindow;

import java.awt.*;

public class AsteroidsGame {
    CanvasWindow canvas;
    AsteroidsManager manager;
    private final int CANVAS_WIDTH = 600;
    private final int CANVAS_HEIGHT = 800;

    public AsteroidsGame(){
        canvas = new CanvasWindow("Asteroids!", CANVAS_WIDTH, CANVAS_HEIGHT);
        manager = new AsteroidsManager(canvas);
        run();
        canvas.setBackground(Color.black);
    }

    public void run(){
        manager.createAsteroid();

       //TODO: Finish this.
    }


    public static void main(String[] args){
        new AsteroidsGame();
    }



}
