package AsteroidsGame;

import comp127graphics.CanvasWindow;

public class AsteroidsGame {
    CanvasWindow canvas;
    AsteroidsManager manager;
    private final int CANVAS_WIDTH = 600;
    private final int CANVAS_HEIGHT = 800;

    public AsteroidsGame(){
        canvas = new CanvasWindow("Asteroids!", CANVAS_WIDTH, CANVAS_HEIGHT);
        manager = new AsteroidsManager();
        run();
    }

    public void run(){
       //TODO: Finish this.
    }




}
