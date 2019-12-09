package AsteroidsGame;

import comp127graphics.CanvasWindow;
import comp127graphics.GraphicsObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class AsteroidsManager {
    private CanvasWindow canvas;
    private List<Asteroids> AsteroidList;
    private int AsteroidMax = 15;
    private Asteroids asteroid;
    private Random rand;
    private List<Double> sizeList = new ArrayList<>();
    private int score;

    AsteroidsManager(CanvasWindow canvas, int score){
        this.canvas = canvas;
        this.score = score;
        AsteroidList = new ArrayList<>();
        rand = new Random();
        sizeList.add(50.0);
        sizeList.add(100.0);
        sizeList.add(150.0);

    }

    /**
     * First, checks to see if the list of asteroids has reached the capacity of the amount of asteroids
     * if the size of the asteroids list is smaller than the max amount it creates asteroids until the two are equal.
     */
    void createAsteroid(){
        if (AsteroidList.size() < AsteroidMax){
            while(AsteroidList.size() < AsteroidMax){
                double asteroidX = rand.nextInt(canvas.getWidth());
                double asteroidY = rand.nextInt(canvas.getHeight());
                double width = sizeList.get(rand.nextInt(3));
                asteroid = new Asteroids(asteroidX, asteroidY,width);
                canvas.add(asteroid);
                AsteroidList.add(asteroid);
            }
        }
//        testHit(asteroid.getX(), asteroid.getY());
    }

    /**
     *
     */
    public void createSplitAsteroid(double width, double x, double y){
                asteroid = new Asteroids(x, y, width-50);

                canvas.add(asteroid);
                AsteroidList.add(asteroid);
    }


    /**
     * Removes the asteroid from the canvas and the list and then calls to create a new asteroid.
     */
    private void destroyAsteroid(Asteroids astr){
        canvas.remove(astr);
        AsteroidList.remove(astr);
        createAsteroid();
    }

    void moveAsteroids(){
        for (Asteroids a: AsteroidList){
            a.updatePosition(canvas);
        }
    }

    double testHit(double x, double y) {
        GraphicsObject location = canvas.getElementAt(x, y);
        if (location instanceof Asteroids) {
            if (((Asteroids) location).getWidth() == 150){
                split(((Asteroids) location).getWidth(), ((Asteroids) location).getX(), ((Asteroids) location).getY());
                split(((Asteroids) location).getWidth(), ((Asteroids) location).getX(), ((Asteroids) location).getY());

            }else if (((Asteroids) location).getWidth() == 100){
                split(((Asteroids) location).getWidth(), ((Asteroids) location).getX(), ((Asteroids) location).getY());
                split(((Asteroids) location).getWidth(), ((Asteroids) location).getX(), ((Asteroids) location).getY());

            }
            destroyAsteroid((Asteroids) location);
            return ((Asteroids) location).getWidth();
        }
        else{
            return -1;
        }
    }

    public double getScore(){
        return score;
    }

    public void split(double width, double x, double y){
        if (width == 150) {
            createSplitAsteroid(width, x, y);
        }else if(width == 100){
            createSplitAsteroid(width, x, y);
        }
    }
}
