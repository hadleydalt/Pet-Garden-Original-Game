package indy;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

public class SunsetBG implements Buyable{
    private Rectangle _sunset;
    private Pane _root;

    public SunsetBG(Pane root){
        _root = root;
        _sunset = new Rectangle(90, 90);
        Stop[] stops = new Stop[] { new Stop(0, Color.DEEPSKYBLUE), new Stop(1, Color.PINK)};
        LinearGradient lg1 = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);
        _sunset.setFill(lg1);
    }

    public int getPrice(){
        return 100;
    }

    public String getType(){
        return "Sunset Background";
    }

    public void setBounceLoc(double x, double y){
        _sunset.setX(x-30);
        _sunset.setY(y-30);
    }
    public void setOpacity(double x){}

    public void removeFromPane(){
        _root.getChildren().removeAll(_sunset);
    }
    public void addToPane(){
        _root.getChildren().addAll(_sunset);
    }
}

