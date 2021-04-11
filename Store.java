package indy;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Store {
    private Rectangle _storebg;
    private Rectangle _whitebg;
    private Rectangle _whitebg2;

    public Store(Pane root){
        _storebg = new Rectangle(Constants.STORE_BG_X, Constants.STORE_BG_Y);
        _storebg.setFill(Color.POWDERBLUE);
        _whitebg = new Rectangle((Constants.STORE_BG_X-60), (Constants.STORE_BG_Y-60));
        _whitebg.setFill(Color.WHITE);
        _whitebg2 = new Rectangle((Constants.STORE_BG_X-70), (Constants.STORE_BG_Y-70));
        _whitebg2.setFill(Color.WHITE);
        _whitebg2.setStroke(Color.POWDERBLUE);

        root.getChildren().addAll(_storebg, _whitebg, _whitebg2);
    }

    public void setLoc(double x, double y){
        _storebg.setX(x);
        _storebg.setY(y);
        _whitebg.setX(x+30);
        _whitebg.setY(y+30);
        _whitebg2.setX(x+35);
        _whitebg2.setY(y+35);
    }
}
