package AsteroidsGame;

import comp127graphics.CanvasWindow;
import comp127graphics.GraphicsObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HealthObjsManager {
    private CanvasWindow canvas;
    private HealthObjs healthObj;
    private Random rand;
    private List<HealthObjs> healthList = new ArrayList<>();
    private Ship ship;

    public HealthObjsManager(CanvasWindow canvas, Ship ship ){
        this.canvas = canvas;
        this.ship = ship;
        healthList = new ArrayList<>();
        rand = new Random();


    }
    public void createHealthObj() {
        for(int i = 0; i<5; i++) {
            double heathX = rand.nextInt(canvas.getWidth());
            double healthY = rand.nextInt(canvas.getHeight());
            healthObj = new HealthObjs(heathX, healthY);
            canvas.add(healthObj);
            healthList.add(healthObj);
        }
    }

    void destroyHealthObj(HealthObjs obj){
        canvas.remove(obj);
        healthList.remove(obj);

    }

    public void testHitHealth(double x, double y){
        GraphicsObject location = canvas.getElementAt(x, y);
        if(location instanceof HealthObjs){

        }

    }




}
