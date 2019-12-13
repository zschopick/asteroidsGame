package AsteroidsGame;
import comp127graphics.CanvasWindow;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Game implements MouseListener, MouseMotionListener {
        private CanvasWindow canvas;
        private AsteroidsManager manager;
        private HealthObjsManager hManager;
        private Ship ship;
        private HealthBar healthBar;
        private ScoreBar scoreBar;
        private final int CANVAS_WIDTH = 1000;
        private final int CANVAS_HEIGHT = 800;
        private Beam beam;

        Game(){
            canvas = new CanvasWindow("Asteroids!", CANVAS_WIDTH, CANVAS_HEIGHT);
            manager = new AsteroidsManager(canvas, 0, AsteroidsGame.getLevel());
            scoreBar = new ScoreBar(manager,CANVAS_WIDTH, CANVAS_HEIGHT);
            hManager = new HealthObjsManager(canvas, ship);
            canvas.setBackground(Color.black);
            run();

        }

        private void run(){
            manager.createAsteroid();
            hManager.createHealthObj();
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
                    canvas.closeWindow();
                }
            });

            canvas.onMouseDown(event -> {
                beam = new Beam(CANVAS_WIDTH*.5, CANVAS_HEIGHT*.5, MouseInfo.getPointerInfo().getLocation().getX(), MouseInfo.getPointerInfo().getLocation().getY());
                canvas.add(beam);
                manager.testHit(beam.getX2(), beam.getY2());
                hManager.testHitHealth(beam.getX2(), beam.getY2());
//            manager.createAsteroid();

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
            ship = new Ship(CANVAS_WIDTH*.5, CANVAS_HEIGHT*.5,  manager, 100, beam, canvas);

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

