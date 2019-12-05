package AsteroidsGame;

import comp127graphics.CanvasWindow;

import java.awt.*;

public class AsteroidsGame {
    CanvasWindow canvas;
    AsteroidsManager manager;
    Ship ship;
    HealthBar healthBar;
    private final int CANVAS_WIDTH = 600;
    private final int CANVAS_HEIGHT = 800;
    private Asteroids asteroid;

    public AsteroidsGame(){
        canvas = new CanvasWindow("Asteroids!", CANVAS_WIDTH, CANVAS_HEIGHT);
        manager = new AsteroidsManager(canvas);
        healthBar = new HealthBar(ship);
        run();
        canvas.onMouseMove(event -> ship.setCurrentPosition(event));
        canvas.setBackground(Color.black);
    }

    public void run(){
        manager.createAsteroid();
        createShip();
        canvas.add(ship);
        healthBar = new HealthBar(ship);
        canvas.animate(() -> {
            manager.moveAsteroids();
            ship.updateHealth();
            healthBar.update(); });
        canvas.add(healthBar.getGraphics());
             //Having trouble adding to the canva, this method gives an error
       //TODO: Finish this.
    }


    public static void main(String[] args){
        new AsteroidsGame();
    }

    /**
     * Creates a ship at the center of the canvas.
     */
    public void createShip(){
        ship = new Ship(CANVAS_WIDTH / 2, CANVAS_HEIGHT / 2,  manager, 100);

    }

}
