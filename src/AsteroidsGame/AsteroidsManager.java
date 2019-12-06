package AsteroidsGame;

import comp127graphics.CanvasWindow;
import comp127graphics.GraphicsObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class AsteroidsManager {
    private CanvasWindow canvas;
    private List<Asteroids> AsteroidList;
    private int AsteroidMax= 15;
    private Asteroids asteroid;
    private Random rand;
    private List<Double> sizeList = new ArrayList<>();
    private int score;

    AsteroidsManager(CanvasWindow canvas, int score){
        this.canvas = canvas;
        this.score = score;
        AsteroidList = new ArrayList<>();
        rand = new Random();
        sizeList.add(25.0);
        sizeList.add(50.0);
        sizeList.add(100.0);

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

    private void updateScore(double width) {
        if (width == 100){
            score += 100;
        }
        if(width == 50){
            score += 500;
        }
        if(width == 25){
            score = 1000;
        }

    }
}
