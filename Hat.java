package indy;

import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

// creates a Hat.

public class Hat implements Buyable{
    private Ellipse _base;
    private Rectangle _top;
    private Color _color;
    private Rectangle _band;
    private Ellipse _feather;
    private Pane _root;
    private Buyable[][] _pets;

    public Hat(Pane root, Buyable[][] pets){
        _pets = pets;
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

    // enables the hat's color to be randomly switched every time a new hat is instantiated.

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

    // the following methods are explained in the Pet superclass which also implements them.

    public int getPrice(){
        return 20;
    }

    public String getType(){
        return "Hat";
    }

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

    public void setOpacity(double x){
        _top.setOpacity(x);
        _top.setOpacity(x);
        _base.setOpacity(x);
        _base.setOpacity(x);
        _band.setOpacity(x);
        _band.setOpacity(x);
        _feather.setOpacity(x);
        _feather.setOpacity(x);
    }

    public void removeFromPane(){
        _root.getChildren().removeAll(_feather, _base, _top, _band);
    }

    public void addToPane(){
        _root.getChildren().addAll(_feather, _base, _top, _band);
    }

    public int petXLoc(){
        int loc = 0;
        int rand_int = (int) (Math.random() * 4);
        switch (rand_int){
            case 0:
                loc = 110;
                break;
            case 1:
                loc = 240;
                break;
            case 2:
                loc = 370;
                break;
            default:
                loc = 500;
                break;
        }
        return loc;
    }

    public int petYLoc(){
        int loc = 0;
        int rand_int = (int) (Math.random() * 4);
        switch (rand_int){
            case 0:
                loc = 290;
                break;
            case 1:
                loc = 420;
                break;
            case 2:
                loc = 550;
                break;
            default:
                loc = 680;
                break;
        }
        return loc;
    }

    // these methods don't need to be known by the Gnome class but the Gnome class must implement them.
    public void addHat(double x, double y){}
    public Timeline getTimeline(){
        return null;
    }
    public double getXLoc(){
        return 0;
    }
    public double getYLoc(){
        return 0;
    }
    public double getOYL(){
        return 0;
    }
    public String getPetName(){
        return null;
    }
    public String getPetBirthMonth(){
        return null;
    }
    public String getPetPersonality(){
        return null;
    }
    public String getPetFavFood(){
        return null;
    }
    public Ellipse getNode(){
        return null;
    }
    public void setLoc(double x, double y){
    }
}
