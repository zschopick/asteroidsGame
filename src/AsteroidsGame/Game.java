package AsteroidsGame;
import comp127graphics.CanvasWindow;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Game implements MouseListener, MouseMotionListener {
        CanvasWindow canvas;
        AsteroidsManager manager;
        Ship ship;
        HealthBar healthBar;
        ScoreBar scoreBar;
        AsteroidsGame startPage;
        private final int CANVAS_WIDTH = 1000;
        private final int CANVAS_HEIGHT = 800;
        private Asteroids asteroid;
        private Beam beam;

        public Game(){
            //startPage = new AsteroidsStartPage();

            canvas = new CanvasWindow("Asteroids!", CANVAS_WIDTH, CANVAS_HEIGHT);
            manager = new AsteroidsManager(canvas, 0, 15);
            scoreBar = new ScoreBar(manager,CANVAS_WIDTH, CANVAS_HEIGHT);
            run();
            canvas.setBackground(Color.black);

        }

        public void run(){
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
                    canvas.closeWindow();
                }
            });

            canvas.onMouseDown(event -> {
                beam = new Beam(CANVAS_WIDTH/2, CANVAS_HEIGHT/2, MouseInfo.getPointerInfo().getLocation().getX(), MouseInfo.getPointerInfo().getLocation().getY());
                canvas.add(beam);
                manager.testHit(beam.getX2(), beam.getY2());
//            manager.createAsteroid();

            });
            canvas.onMouseUp(event -> {
                canvas.remove(beam);
            });


            canvas.add(healthBar.getGraphics());
            canvas.add(scoreBar.getGraphics());
            //TODO: Finish this.
        }


//        public static void main(String[] args){
//            new AsteroidsGame();
//        }

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

        public double getWidth(){
            return CANVAS_WIDTH;
        }
        public double getHeight(){
            return CANVAS_HEIGHT;
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

