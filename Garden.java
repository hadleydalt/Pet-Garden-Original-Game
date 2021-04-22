package indy;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

// Creates the Garden.

public class Garden {
    private Rectangle _grass;
    private Rectangle _sky;
    private Ellipse _cloud1;
    private Ellipse _cloud2;
    private Ellipse _cloud3;
    private Ellipse _sun;
    private Ellipse _leaf1;
    private Ellipse _leaf2;
    private Ellipse _leaf3;
    private Rectangle _framer1;
    private Rectangle _framer2;
    private Rectangle _framer3;
    private Rectangle _frame;

    public Garden(Pane root){
        _grass = new Rectangle(550, 565);
        Stop[] stops = new Stop[] { new Stop(0, Color.YELLOWGREEN), new Stop(1, Color.GREEN)};
        LinearGradient lg1 = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);
        _grass.setFill(lg1);
        _sky = new Rectangle(550, 150);
        Stop[] stops1 = new Stop[] { new Stop(0, Color.MEDIUMTURQUOISE), new Stop(1, Color.ALICEBLUE)};
        LinearGradient lg2 = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops1);
        _sky.setFill(lg2);
        Stop[] stops4 = new Stop[] { new Stop(0, Color.WHITE), new Stop(1, Color.LIGHTCYAN)};
        LinearGradient lg5 = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops4);
        _cloud1 = new Ellipse(Constants.CLOUD_X, Constants.CLOUD_Y);
        _cloud1.setFill(lg5);
        _cloud2 = new Ellipse(Constants.CLOUD_X, Constants.CLOUD_Y);
        _cloud2.setFill(lg5);
        _cloud3 = new Ellipse(Constants.MED_CLOUD_X, Constants.MED_CLOUD_Y);
        _cloud3.setFill(lg5);
        _sun = new Ellipse(Constants.SUN_RAD, Constants.SUN_RAD);
        Stop[] stops2 = new Stop[] { new Stop(0, Color.YELLOW), new Stop(1, Color.GOLD)};
        LinearGradient lg3 = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops2);
        _sun.setFill(lg3);
        Stop[] stops3 = new Stop[] { new Stop(0, Color.GREEN), new Stop(1, Color.DARKSLATEGRAY)};
        LinearGradient lg4 = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops3);
        _leaf1 = new Ellipse(Constants.LEAF_X, Constants.LEAF_Y);
        _leaf1.setFill(lg4);
        _leaf1.setRotate(25);
        _leaf2 = new Ellipse(Constants.BIG_LEAF_X, Constants.BIG_LEAF_Y);
        _leaf2.setFill(lg4);
        _leaf2.setRotate(-25);
        _leaf3 = new Ellipse(Constants.LEAF_X, Constants.LEAF_Y);
        _leaf3.setFill(lg4);
        _leaf3.setRotate(35);
        _framer1 = new Rectangle(Constants.FRAMER_X, Constants.FRAMER_Y);
        _framer1.setFill(Color.ALICEBLUE);
        _framer2 = new Rectangle(Constants.FRAMER_X, Constants.FRAMER_Y);
        _framer2.setFill(Color.ALICEBLUE);
        _framer3 = new Rectangle(Constants.FRAMER_Y, Constants.FRAMER_X+20);
        _framer3.setFill(Color.ALICEBLUE);
        _frame = new Rectangle(Constants.FRAME_X, Constants.FRAME_Y);
        _frame.setFill(Color.TRANSPARENT);
        _frame.setStroke(Color.WHITE);

        root.getChildren().addAll(_sky, _cloud2, _cloud1, _cloud3, _sun, _grass, _leaf1, _leaf2, _leaf3, _framer1,
                _framer2, _framer3, _frame);
    }

    // sets Garden's location.

    public void setLoc(double x, double y){
        _grass.setX(x);
        _grass.setY(y);
        _sky.setX(x);
        _sky.setY(y-150);
        _cloud1.setCenterX(x+100);
        _cloud1.setCenterY(y-60);
        _cloud2.setCenterX(x+440);
        _cloud2.setCenterY(y-5);
        _sun.setCenterX(x+260);
        _sun.setCenterY(y-15);
        _cloud3.setCenterX(x+320);
        _cloud3.setCenterY(y-94);
        _leaf1.setCenterX(x+515);
        _leaf1.setCenterY(y+510);
        _leaf2.setCenterX(x+405);
        _leaf2.setCenterY(y+480);
        _leaf3.setCenterX(x);
        _leaf3.setCenterY(y+280);
        _framer1.setX(0);
        _framer1.setY(400);
        _framer2.setX(580);
        _framer2.setY(500);
        _framer3.setX(300);
        _framer3.setY(765);
        _frame.setX(35);
        _frame.setY(55);

    }

    // gets the sky so its color can be changed in the Game class if the user buys the Sunset.

    public Rectangle getSky(){
        return _sky;
    }
}
