package AsteroidsGame;

import comp127graphics.CanvasWindow;
import comp127graphics.GraphicsObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class is responsible for creating all the asteroids on the screen as well managing when they are hit and split
 * as well as keeping a certain amount of asteroids on the screen, which is passed to it by the level that the user chooses.
 */

class AsteroidsManager {
    private CanvasWindow canvas;
    private List<Asteroids> AsteroidList;
    private int asteroidMax;
    private Asteroids asteroid;
    private Random rand;
    private List<Double> sizeList = new ArrayList<>();
    private List<Double> locationXList = new ArrayList<>();
    private List<Double> locationYList = new ArrayList<>();
    private int score;

    /**
     * Creates the asteroid manager object with instance variables canvas, score asteroidMax, and creates a new list of Asteroids,
     * and creates a new list of random doubles that the asteroids are allowed to spawn at, the locations are made so that the
     * asteroids don't spawn on the ship.
     * @param canvas
     * @param score
     * @param asteroidMax
     */
    AsteroidsManager(CanvasWindow canvas, int score, int asteroidMax) {
        this.canvas = canvas;
        this.score = score;
        this.asteroidMax = asteroidMax;
        AsteroidList = new ArrayList<>();
        rand = new Random();
        sizeList.add(37.5);
        sizeList.add(75.0);
        sizeList.add(150.0);
        for (int i = 0; i < 20; i++) {
            locationXList.add((double) rand.nextInt((canvas.getWidth()/2)-50));
            locationXList.add((double) (rand.nextInt((canvas.getWidth()/2)-50) + (canvas.getWidth()/2)+50));
            locationYList.add((double) rand.nextInt((canvas.getHeight()/2)-50));
            locationYList.add((double) (rand.nextInt((canvas.getHeight()/2)-50) + (canvas.getHeight()/2)+50));
        }
    }

    /**
     * First, checks to see if the list of asteroids has reached the capacity of the amount of asteroids
     * if the size of the asteroids list is smaller than the max amount it creates asteroids until the two are equal.
     */
    void createAsteroid() {
        while (AsteroidList.size() < asteroidMax) {
            double asteroidX = locationXList.get(rand.nextInt(40));
            double asteroidY = locationYList.get(rand.nextInt(40));
            double width = sizeList.get(rand.nextInt(3));
            asteroid = new Asteroids(asteroidX, asteroidY, width);
            canvas.add(asteroid);
            AsteroidList.add(asteroid);
        }
    }

    /**
     *Creates an asteroid of half the size of the original asteroid shot at the x and y position of the original asteroid.
     */
    private void createSplitAsteroid(double width, double x, double y) {
        asteroid = new Asteroids(x, y, width / 2);

        canvas.add(asteroid);
        AsteroidList.add(asteroid);
    }


    /**
     * Removes the asteroid from the canvas and the list and then calls to create a new asteroid.
     */
    private void destroyAsteroid(Asteroids astr) {
        canvas.remove(astr);
        AsteroidList.remove(astr);
        createAsteroid();
    }

    /**
     * Loops through the list of the asteroids and calls the update position method to move the asteroids.
     */
    void moveAsteroids() {
        for (Asteroids a : AsteroidList) {
            a.updatePosition(canvas);
        }
    }

    /**
     * Takes in an x and y and uses those coordinates to get the element at that point on the canvas.
     * Then checks to see if that object is an instance of an Asteroid. Then, checks if that asteroid hit
     * has a certain width if it is one of the two larger sizes then calls the split method twice.
     * @param x
     * @param y
     */
    void testHit(double x, double y) {
        GraphicsObject location = canvas.getElementAt(x, y);
        if (location instanceof Asteroids) {
            if (((Asteroids) location).getWidth() == 150) {
                split(((Asteroids) location).getWidth(), ((Asteroids) location).getX(), ((Asteroids) location).getY());
                split(((Asteroids) location).getWidth(), ((Asteroids) location).getX(), ((Asteroids) location).getY());

            } else if (((Asteroids) location).getWidth() == 75) {
                split(((Asteroids) location).getWidth(), ((Asteroids) location).getX(), ((Asteroids) location).getY());
                split(((Asteroids) location).getWidth(), ((Asteroids) location).getX(), ((Asteroids) location).getY());

            }
            destroyAsteroid((Asteroids) location);
            score += 200;
        }
    }

    /**
     *  Takes in an x and a y tests to see if that is an asteroid, then destoys the asteroid if it hits the ship.
     * @param x
     * @param y
     * @return Asteroid width.
     */
    double testShipHit(double x, double y) {
        GraphicsObject location = canvas.getElementAt(x, y);
        if (location instanceof Asteroids) {
            destroyAsteroid((Asteroids) location);
            return ((Asteroids) location).getWidth();
        } else {
            return -1;
        }
    }

    /**
     * Returns the score of the player
     * @return Score
     */
    double getScore() {
        return score;
    }

    /**
     * Checks the width of the asteroid then creates a split asteroid at the same x, y position and updates the score.
     * @param width
     * @param x
     * @param y
     */
    private void split(double width, double x, double y) {
        if (width == 150) {
            score += 50;
            createSplitAsteroid(width, x, y);
        } else if (width == 75) {
            score += 100;
            createSplitAsteroid(width, x, y);
        }
    }


}



