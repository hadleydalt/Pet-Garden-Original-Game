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
    private Rectangle _loadingbg;
    private Rectangle _loading;
    private Label _percent;
    private int _intPercent;
    private Label _pressSpace;

    public Title(Pane root){
        _bg = new Rectangle(Constants.TITLE_BG_X, Constants.TITLE_BG_Y);
        Stop[] stops = new Stop[] { new Stop(0, Color.MEDIUMTURQUOISE), new Stop(1, Color.POWDERBLUE)};
        LinearGradient lg1 = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);
        _bg.setFill(lg1);
        Font font = new Font("Gill Sans", 170);
        _title = new Label("Pet Garden");
        _title.setTextFill(Color.ALICEBLUE);
        _title.setFont(font);
        _loadingbg = new Rectangle(Constants.LOADINGBG_X, Constants.LOADINGBG_Y);
        _loadingbg.setFill(Color.WHITE);
        _loadingbg.setOpacity(.5);
        _loading = new Rectangle(0, Constants.LOADINGBG_Y);
        _loading.setFill(Color.ALICEBLUE);
        _intPercent = 0;
        _percent = new Label(_intPercent + "%");
        _percent.setTextFill(Color.ALICEBLUE);
        Font font2 = new Font("Gill Sans", 15);
        _percent.setFont(font2);
        _pressSpace = new Label("press the spacebar to begin!");
        _pressSpace.setTextFill(Color.ALICEBLUE);
        Font font3 = new Font("Gill Sans", 30);
        _pressSpace.setFont(font3);
        _pressSpace.setOpacity(0);

        root.getChildren().addAll(_bg, _title, _loadingbg, _loading, _percent, _pressSpace);
    }

    public void setLoc(double x, double y){
        _bg.setX(x);
        _bg.setY(y);
        _title.relocate(318, 270); //862, 300
        _loadingbg.setX(x+550);
        _loadingbg.setY(y+480);
        _loading.setX(x+550);
        _loading.setY(y+480);
        _percent.relocate(820, 520);
        _pressSpace.relocate(540, 480);
    }

    public void setBGXLoc(double x){
        _bg.setX(x);
    }

    public double getBGXLoc(){
        return _bg.getX();
    }

    public void setTitleLoc(double x, double y){
        _title.relocate(x, y);
    }

    public Rectangle getBG(){
        return _bg;
    }

    public Rectangle getLoadingBar(){
        return _loading;
    }

    public Rectangle getLoadingBG(){
        return _loadingbg;
    }

    public Label getPercentLabel(){
        return _percent;
    }

    public int getPercent(){
        return _intPercent;
    }

    public Label getPressSpace(){
        return _pressSpace;
    }

    public Label getTitle(){
        return _title;
    }
}
