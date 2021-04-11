package indy;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Store {
    private Rectangle _storebg;
    private Rectangle _whitebg;
    private Rectangle _whitebg2;
    private Ellipse _topbg;
    private Ellipse _topbgint;
    private Rectangle _accent1;
    private Rectangle _accent2;
    private Label _shop;
    private Label _shop2;

    public Store(Pane root){
        _storebg = new Rectangle(Constants.STORE_BG_X, Constants.STORE_BG_Y);
        _storebg.setFill(Color.POWDERBLUE);
        _whitebg = new Rectangle((Constants.STORE_BG_X-60), (Constants.STORE_BG_Y-60));
        _whitebg.setFill(Color.WHITE);
        _whitebg2 = new Rectangle((Constants.STORE_BG_X-70), (Constants.STORE_BG_Y-70));
        _whitebg2.setFill(Color.WHITE);
        _whitebg2.setStroke(Color.POWDERBLUE);
        _topbg = new Ellipse(Constants.TOPBG_X, Constants.TOPBG_Y);
        _topbg.setFill(Color.WHITE);
        _topbg.setStroke(Color.POWDERBLUE);
        _topbgint = new Ellipse(Constants.TOPBG_X-6, Constants.TOPBG_Y-5);
        _topbgint.setFill(Color.TRANSPARENT);
        _topbgint.setStroke(Color.rgb(215, 246, 250));
        Stop[] stops = new Stop[] { new Stop(0, Color.WHITE), new Stop(1, Color.POWDERBLUE)};
        LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
        Stop[] stops1 = new Stop[] { new Stop(0, Color.POWDERBLUE), new Stop(1, Color.WHITE)};
        LinearGradient lg2 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops1);
        _accent1 = new Rectangle(Constants.ACCENT_X, Constants.ACCENT_Y);
        _accent1.setFill(lg1);
        _accent2 = new Rectangle(Constants.ACCENT_X, Constants.ACCENT_Y);
        _accent2.setFill(lg2);
        _shop = new Label("S H O P");
        _shop.setTextFill(Color.POWDERBLUE);
        Font font = new Font("Gill Sans", 40);
        _shop.setFont(font);
        _shop2 = new Label("S H O P");
        _shop2.setTextFill(Color.rgb(215, 246, 250));
        _shop2.setFont(font);


        root.getChildren().addAll(_storebg, _whitebg, _whitebg2, _topbg, _topbgint, _accent1, _accent2, _shop, _shop2);
    }

    public void setLoc(double x, double y){
        _storebg.setX(x);
        _storebg.setY(y);
        _whitebg.setX(x+30);
        _whitebg.setY(y+30);
        _whitebg2.setX(x+35);
        _whitebg2.setY(y+35);
        _topbg.setCenterX(x+267);
        _topbg.setCenterY(y+50);
        _topbgint.setCenterX(x+267);
        _topbgint.setCenterY(y+50);
        _accent1.setX(x+47);
        _accent1.setY(y+45);
        _accent2.setX(x+397);
        _accent2.setY(y+45);
        _shop.relocate(x+201, y+27);
        _shop2.relocate(x+203.5, y+25.5);
    }
}
