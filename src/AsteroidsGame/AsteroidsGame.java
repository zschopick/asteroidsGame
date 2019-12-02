package AsteroidsGame;

import comp127graphics.CanvasWindow;

import java.awt.*;

public class AsteroidsGame {
    CanvasWindow canvas;
    AsteroidsManager manager;
    Ship ship;
    private final int CANVAS_WIDTH = 600;
    private final int CANVAS_HEIGHT = 800;
    private Asteroids asteroid;

    public AsteroidsGame(){
        canvas = new CanvasWindow("Asteroids!", CANVAS_WIDTH, CANVAS_HEIGHT);
        manager = new AsteroidsManager(canvas);
        run();
        canvas.onMouseMove(event -> ship.setCurrentPosition(event));
        canvas.setBackground(Color.black);
    }

    public void run(){
        manager.createAsteroid();
        createShip();
        canvas.add(ship);
//        manager.testHit(300,400);

        canvas.animate(() ->
                manager.moveAsteroids());
       //TODO: Finish this.
    }


    public static void main(String[] args){
        new AsteroidsGame();
    }

    /**
     * Creates a ship at the center of the canvas.
     */
    public void createShip(){
        ship = new Ship(300, 350, 275, 450, 325, 450, manager);
    }

}
