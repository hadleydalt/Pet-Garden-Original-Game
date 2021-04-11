package indy;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Title {
    private Rectangle _bg;
    private Label _title;

    public Title(Pane root){
        _bg = new Rectangle(Constants.TITLE_BG_X, Constants.TITLE_BG_Y);
        Stop[] stops = new Stop[] { new Stop(0, Color.MEDIUMTURQUOISE), new Stop(1, Color.POWDERBLUE)};
        LinearGradient lg1 = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);
        _bg.setFill(lg1);
        Font font = new Font("Gill Sans", 170);
        _title = new Label("Pet Garden");
        _title.setTextFill(Color.ALICEBLUE);
        _title.setRotate(90);
        _title.setFont(font);

        root.getChildren().addAll(_bg, _title);
    }

    public void setLoc(double x, double y){
        _bg.setX(x);
        _bg.setY(y);
        _title.relocate(867, 300);
    }
}
