package AsteroidsGame;

import comp127graphics.CanvasWindow;
import comp127graphics.GraphicsObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AsteroidsManager {
    private CanvasWindow canvas;
    private List<Asteroids> AsteroidList;
    private int asteroidMax;
    private Asteroids asteroid;
    private Random rand;
    private List<Double> sizeList = new ArrayList<>();
    private List<Double> locationXList = new ArrayList<>();
    private List<Double> locationYList = new ArrayList<>();
    private int score;
    private Ship ship;


    public AsteroidsManager(CanvasWindow canvas, int score, int asteroidMax){
        this.canvas = canvas;
        this.score = score;
        this.asteroidMax = asteroidMax;
        AsteroidList = new ArrayList<>();
        rand = new Random();
        sizeList.add(37.5);
        sizeList.add(75.0);
        sizeList.add(150.0);
        for(int i=0; i<20; i++){
            locationXList.add((double) rand.nextInt(450));
            locationXList.add((double) (rand.nextInt(450) + 550));
            locationYList.add((double) (rand.nextInt(450) + 550));
            locationYList.add((double) (rand.nextInt(350) + 450));
        }
    }

    /**
     * First, checks to see if the list of asteroids has reached the capacity of the amount of asteroids
     * if the size of the asteroids list is smaller than the max amount it creates asteroids until the two are equal.
     */
    void createAsteroid(){
        if (AsteroidList.size() < asteroidMax){
            while(AsteroidList.size() < asteroidMax){
                double asteroidX = locationXList.get(rand.nextInt(40));
                double asteroidY = locationYList.get(rand.nextInt(40));
                double width = sizeList.get(rand.nextInt(3));
                asteroid = new Asteroids(asteroidX, asteroidY,width); //same random location is used for all asteroids?
                canvas.add(asteroid);
                AsteroidList.add(asteroid);
            }
        }
    }

    /**
     *
     */
    public void createSplitAsteroid(double width, double x, double y){
                asteroid = new Asteroids(x, y, width/2);

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

    public void testHit(double x, double y) {
        GraphicsObject location = canvas.getElementAt(x, y);
        if (location instanceof Asteroids) {
            if (((Asteroids) location).getWidth() == 150){
                split(((Asteroids) location).getWidth(), ((Asteroids) location).getX(), ((Asteroids) location).getY());
                split(((Asteroids) location).getWidth(), ((Asteroids) location).getX(), ((Asteroids) location).getY());

            }else if (((Asteroids) location).getWidth() == 75){
                split(((Asteroids) location).getWidth(), ((Asteroids) location).getX(), ((Asteroids) location).getY());
                split(((Asteroids) location).getWidth(), ((Asteroids) location).getX(), ((Asteroids) location).getY());

            }
            destroyAsteroid((Asteroids) location);
            score += 200;
    }}

    public double testShipHit(double x, double y) {
        GraphicsObject location = canvas.getElementAt(x, y);
        if (location instanceof Asteroids) {
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
            score += 50;
            createSplitAsteroid(width, x, y);
        }else if(width == 75){
            score += 100;
            createSplitAsteroid(width, x, y);
        }
    }



}



