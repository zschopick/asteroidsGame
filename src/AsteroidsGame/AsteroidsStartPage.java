package AsteroidsGame;

import comp127graphics.*;

public class AsteroidsStartPage {

    //I think we should add some buttons to choose easy/medium/hard then we can use that input for the asteroid manager.

    CanvasWindow startCanvas;
    private final int CANVAS_WIDTH = 600;
    private final int CANVAS_HEIGHT = 800;
    private GraphicsGroup group;

    private GraphicsText gameTitle;
    private GraphicsText description;
    private Image asteroidImage;

    public AsteroidsStartPage(){
        group = new GraphicsGroup();

        asteroidImage = new Image(CANVAS_WIDTH*.4,CANVAS_HEIGHT*.3, "condition-icons/sunny.png");
        asteroidImage.setMaxWidth(CANVAS_WIDTH*.85);
        asteroidImage.setMaxHeight(CANVAS_HEIGHT*.85);
        group.add(asteroidImage);


        gameTitle = new GraphicsText();
        gameTitle.setFont(FontStyle.BOLD, CANVAS_WIDTH * 0.07);
        group.add(gameTitle);

        description = new GraphicsText();
        description.setFont(FontStyle.BOLD, CANVAS_WIDTH* 0.07);
        group.add(description);

        updateLayout();
    }

//    public void update(WeatherData data) {
//        asteroidImage.setImagePath("condition-icons/sunny.png");
//        String sunrise = FormattingHelpers.TIME_OF_DAY.format(data.getCurrentConditions().getSunriseTime());
//        String sunset = FormattingHelpers.TIME_OF_DAY.format(data.getCurrentConditions().getSunsetTime());
//        gameTitle.setText("ASTEROIDS");
//        description.setText("This game...");
//
//        updateLayout();
//    }

    private void updateLayout() {
        gameTitle.setCenter(CANVAS_WIDTH * 0.48, CANVAS_HEIGHT * 0.1);
        description.setCenter(CANVAS_WIDTH * 0.48,  CANVAS_HEIGHT * 0.85);
        asteroidImage.setPosition(CANVAS_WIDTH*.08, CANVAS_HEIGHT*.23);
    }

}

