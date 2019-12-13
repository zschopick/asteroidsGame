package AsteroidsGame;
/**
 * A ship that is drawn to the canvas to shoot the asteroids
 */

import comp127graphics.*;
import java.awt.*;

public class Ship extends Ellipse {
    private final double X;
    private final double Y;
    private int health;
    static final double WIDTH = 70;
    static final double HEIGHT = 50;
    private AsteroidsManager asteroidsManager;
    private Beam beam;
    CanvasWindow canvas;

    /**
     * Creates a ship with the Ellipse class in the comp127graphics package and its upper left is at (x,y).
     * @param X
     * @param Y
     * @param asteroidsManager
     * @param health
     * @param beam
     * @param canvas
     */
    public Ship(double X, double Y, AsteroidsManager asteroidsManager,
                int health, Beam beam, CanvasWindow canvas) {
        super(X, Y, 70, 50);
        this.X = X;
        this.Y = Y;
        this.setFillColor(Color.white);
        this.health = health;
        this.asteroidsManager = asteroidsManager;
        setCenter(X, Y);
        this.beam = beam;
        this.canvas = canvas;
    }

    /**
     * Updates the ships health after it is hit by an asteroid of a certain width that is passed in.
     * @param width
     */
    private void updateHealthHit (double width) {
        if (width == 150){
            health -= 20;
            this.setFillColor(Color.RED);
            canvas.onMouseDown(event -> {
                this.setFillColor(Color.white);
            });
        }
        if(width == 75){
            health -= 10;
            this.setFillColor(Color.RED);
            canvas.onMouseDown(event -> {
                this.setFillColor(Color.white);
            });
        }
        if(width == 37.5){
            health -= 5;
            this.setFillColor(Color.RED);
            canvas.onMouseDown(event -> {
                this.setFillColor(Color.white);
            });
        }
    }

    /**
     * Returns the current health of the ship
     * @return health
     */
    int getHealth() {
        return health;
    }

    /**
     * Tests 8 locations on the outside of the ship and tests the locations to see if they are being hit by an asteroid
     * if the testShipHit method returns a double greater than zero than the updateHealthHit method is called for the
     * width of the asteroid and returns true.
     */
    void shipDestruction() {
        double left = asteroidsManager.testShipHit(X - WIDTH - 1, Y);
        if (left > 0) {
            //tests left side
            updateHealthHit(left);
            return;
        }
        double right = asteroidsManager.testShipHit(X + WIDTH + 1, Y);
        if (right > 0) {
            //tests right side
            updateHealthHit(right);
            return;
        }
        double top = asteroidsManager.testShipHit(X, Y - HEIGHT - 1);
        if (top > 0) {
            //tests top side
            updateHealthHit(top);
            return;
        }
        double bottom = asteroidsManager.testShipHit(X, Y + HEIGHT + 1);
        if (bottom > 0) {
            //tests bottom side
            updateHealthHit(bottom);
            return;
        }
        double topLeft = asteroidsManager.testShipHit(this.getX(), this.getY());
        if (topLeft > 0) {
            //tests top left corner
            updateHealthHit(topLeft);
            return;
        }
        double topRight = asteroidsManager.testShipHit(this.getX() + WIDTH, this.getY());
        if (topRight > 0) {
            //tests top right corner
            updateHealthHit(topRight);
            return;
        }
        double bottomLeft = asteroidsManager.testShipHit(this.getX(), this.getY() + HEIGHT);
        if (bottomLeft > 0) {
            //tests bottom left corner
            updateHealthHit(bottomLeft);
            return;
        }
        double bottomRight = asteroidsManager.testShipHit(this.getX() + WIDTH, this.getY() + HEIGHT);
        if (bottomRight > 0) {
            //tests bottom right corner
            updateHealthHit(bottomRight);
        }
    }
}