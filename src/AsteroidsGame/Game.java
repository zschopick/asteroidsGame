package AsteroidsGame;
import comp127graphics.CanvasWindow;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


/**
 * Class is responsible for creating the canvas that the game runs on, adds everything to
 * the canvas and animates it
 */
public class Game implements MouseListener, MouseMotionListener {
        private CanvasWindow canvas;
        private AsteroidsManager manager;
        private Ship ship;
        private HealthBar healthBar;
        private ScoreBar scoreBar;
        private final int CANVAS_WIDTH = 1000;
        private final int CANVAS_HEIGHT = 800;
        private Beam beam;

    /**
     * Creates a new canvas, a new asteroid manager, and a new score bar.
     * Sets the canvas to black and calls the run method.
     */
        Game(){
            canvas = new CanvasWindow("Asteroids!", CANVAS_WIDTH, CANVAS_HEIGHT);
            manager = new AsteroidsManager(canvas, 0, AsteroidsGame.getLevel());
            scoreBar = new ScoreBar(manager,CANVAS_WIDTH, CANVAS_HEIGHT);
            canvas.setBackground(Color.black);
            run();

        }

    /**
     * Creates asteroids and ship and adds them to the canvas. Checks the health of the ship
     * and animates the elements if the health is greater than 0. Creates a beam on a mouse down
     * click and removes it on a mouse release
     */
    private void run(){
            manager.createAsteroid();

            createShip();
            canvas.add(ship);
            healthBar = new HealthBar(ship, CANVAS_WIDTH,CANVAS_HEIGHT);
            canvas.animate(() -> {
                if(ship.getHealth()>0){
                    manager.moveAsteroids();
                    ship.shipDestruction();
                    healthBar.update();
                    scoreBar.update();}
                else{
                    System.out.println("You have died.");
                    System.out.println("Your End Score: " + manager.getScore());
                    canvas.closeWindow();
                }
            });

            canvas.onMouseDown(event -> {
                beam = new Beam(CANVAS_WIDTH*.5, CANVAS_HEIGHT*.5,
                        MouseInfo.getPointerInfo().getLocation().getX(),
                        MouseInfo.getPointerInfo().getLocation().getY());
                canvas.add(beam);
                manager.testHit(beam.getX2(), beam.getY2());


            });
            canvas.onMouseUp(event -> {
                canvas.remove(beam);
            });

            canvas.add(healthBar.getGraphics());
            canvas.add(scoreBar.getGraphics());
        }

        /**
         * Creates a ship at the center of the canvas.
         */
        private void createShip(){
            ship = new Ship(CANVAS_WIDTH*.5, CANVAS_HEIGHT*.5,  manager, 100, canvas);

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            Beam beam = new Beam(CANVAS_WIDTH* .5, CANVAS_HEIGHT* .5, MouseInfo.getPointerInfo().getLocation().getX(), MouseInfo.getPointerInfo().getLocation().getY());
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

