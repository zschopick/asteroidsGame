package AsteroidsGame;

import comp127graphics.CanvasWindow;
import comp127graphics.GraphicsObject;
import comp127graphics.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AsteroidsManager {
    private CanvasWindow canvas;
    private List<Asteroids> AsteroidList;
    private int AsteroidMax= 15;
    private Asteroids asteroid;
    private Random rand;


    public AsteroidsManager(CanvasWindow canvas){
        this.canvas = canvas;
        AsteroidList = new ArrayList<>();
        rand = new Random();

    }

    /**
     * First, checks to see if the list of asteroids has reached the capacity of the amount of asteroids
     * if the size of the asteroids list is smaller than the max amount it creates asteroids until the two are equal.
     */
    public void createAsteroid(){
        if (AsteroidList.size() < AsteroidMax){
            while(AsteroidList.size() < AsteroidMax){
                double asteroidX = rand.nextInt(canvas.getWidth());
                double asteroidY = rand.nextInt(canvas.getHeight());
                asteroid = new Asteroids(asteroidX, asteroidY);
                canvas.add(asteroid);
                AsteroidList.add(asteroid);
            }
        }
    }


    /**
     * Removes the asteroid from the canvas and the list and then calls to create a new asteroid.
     */
    public void destroyAsteroid(Asteroids astr){
        canvas.remove(astr);
        AsteroidList.remove(astr);
        createAsteroid();
    }


//No longer needed because we specify which Asteroid is at location of ship.
//    public void asteroidAtPosition(GraphicsObject object){
//        for (Asteroids a: AsteroidList){
//            if (a == object){
//                destroyAsteroid(a);
//            }
//        }
//    }

    public void moveAsteroids(){
        for (Asteroids a: AsteroidList){
            a.updatePosition(canvas);
            if(a.getCenter().equals(new Point(300, 400))){
                destroyAsteroid(a);
            }
        }
    }


    
//    public boolean testHit(double x, double y) {
//        GraphicsObject location = canvas.getElementAt(x, y);
//        if (location instanceof Asteroids) {
//            destroyAsteroid((Asteroids) location);
//            return true;
//        }
//        return false;
//    }
}
