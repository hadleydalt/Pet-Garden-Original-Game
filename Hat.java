package indy;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class Hat implements Buyable{
    private Ellipse _base;
    private Rectangle _top;
    private Color _color;
    private Rectangle _band;
    private Ellipse _feather;
    private Pane _root;

    public Hat(Pane root){
        _root = root;
        _color = this.switchCol();
        _base = new Ellipse(55, 10);
        _base.setFill(_color);
        _top = new Rectangle(60, 25);
        _top.setFill(_color);
        _band = new Rectangle(60, 4);
        _band.setFill(Color.WHITE);
        _feather = new Ellipse(5, 18);
        _feather.setFill(Color.GOLD);
        _feather.setRotate(36);
    }
    public void getPrice(){}
    public void setBounceLoc(double x, double y){
        _top.setX(x-15);
        _top.setY(y);
        _base.setCenterX(x+14);
        _base.setCenterY(y+30);
        _band.setX(x-15);
        _band.setY(y+18);
        _feather.setCenterX(x+55);
        _feather.setCenterY(y+7);
    }

    public Color switchCol() {
        Color col = null;
        int rand_int = (int) (Math.random() * 15);
        switch (rand_int) {
            case 0:
                col = Color.DEEPSKYBLUE;
                break;
            case 1:
                col = Color.PINK;
                break;
            case 2:
                col = Color.TURQUOISE;
                break;
            case 3:
                col = Color.VIOLET;
                break;
            case 4:
                col = Color.ORANGE;
                break;
            case 5:
                col = Color.LIGHTSALMON;
                break;
            case 6:
                col = Color.LIGHTGREEN;
                break;
            case 7:
                col = Color.LIGHTCORAL;
                break;
            case 8:
                col = Color.PALETURQUOISE;
                break;
            case 9:
                col = Color.SPRINGGREEN;
                break;
            case 10:
                col = Color.MEDIUMORCHID;
                break;
            case 11:
                col = Color.MEDIUMPURPLE;
                break;
            case 12:
                col = Color.FUCHSIA;
                break;
            case 13:
                col = Color.AQUAMARINE;
                break;
            case 14:
                col = Color.DEEPPINK;
                break;
            default:
                col = Color.CYAN;
                break;
        }
        return col;
    }

    public void setOpacity(double x){}

    public void removeFromPane(){
        _root.getChildren().removeAll(_feather, _base, _top, _band);
    }

    public void addToPane(){
        _root.getChildren().addAll(_feather, _base, _top, _band);
    }
}
