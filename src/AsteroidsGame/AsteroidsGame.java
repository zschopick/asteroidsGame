package AsteroidsGame;

import comp127graphics.CanvasWindow;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class AsteroidsGame implements MouseListener, MouseMotionListener {
    CanvasWindow canvas;
    AsteroidsManager manager;
    Ship ship;
    HealthBar healthBar;
    private final int CANVAS_WIDTH = 600;
    private final int CANVAS_HEIGHT = 800;
    private Asteroids asteroid;
    private Beam beam;

    public AsteroidsGame(){
        canvas = new CanvasWindow("Asteroids!", CANVAS_WIDTH, CANVAS_HEIGHT);
        manager = new AsteroidsManager(canvas);
        healthBar = new HealthBar(ship);
        run();
        canvas.onMouseMove(event -> ship.setCurrentPosition(event));
        canvas.setBackground(Color.black);
        canvas.onClick(event -> {
            beam = new Beam(CANVAS_WIDTH/2, CANVAS_HEIGHT/2, MouseInfo.getPointerInfo().getLocation().getX(), MouseInfo.getPointerInfo().getLocation().getY());
            canvas.add(beam);
            //canvas.remove(beam);
        });
    }

    public void run(){
        manager.createAsteroid();
        createShip();
        canvas.add(ship);
        healthBar = new HealthBar(ship);
        canvas.animate(() -> {
            manager.moveAsteroids();
            ship.testForDestruction();
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

    @Override
    public void mouseClicked(MouseEvent e) {
        Beam beam = new Beam(CANVAS_WIDTH/2, CANVAS_HEIGHT/2, MouseInfo.getPointerInfo().getLocation().getX(), MouseInfo.getPointerInfo().getLocation().getY());
        canvas.add(beam);
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
