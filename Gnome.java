package indy;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class Gnome implements Buyable{
    private Circle _head;
    private Rectangle _hat;
    private Rectangle _shirt;
    private Ellipse _beard;
    private Ellipse _mouth;
    private Rectangle _pants;
    private Rectangle _belt;
    private Ellipse _foot1;
    private Ellipse _foot2;
    private Circle _eye1;
    private Circle _eye2;
    private Circle _pupil1;
    private Circle _pupil2;
    private Pane _root;

    public Gnome(Pane root){
        _root = root;
        _head = new Circle(Constants.SPOT_3_Y);
        _head.setFill(Color.LAVENDER);
        _hat = new Rectangle(25, 25);
        _hat.setFill(Color.TOMATO);
        _hat.setRotate(45);
        _shirt = new Rectangle(52, 35);
        _shirt.setFill(Color.GOLD);
        _beard = new Ellipse(13, 15);
        _beard.setFill(Color.WHITE);
        _mouth = new Ellipse(5, 3);
        _mouth.setFill(Color.MAROON);
        _pants = new Rectangle(42, 27);
        _pants.setFill(Color.ROYALBLUE);
        _belt = new Rectangle(42, 7);
        _foot1 = new Ellipse(9, 6);
        _foot1.setFill(Color.TOMATO);
        _foot2 = new Ellipse(9, 6);
        _foot2.setFill(Color.TOMATO);
        _eye1 = new Circle(3);
        _eye1.setFill(Color.SLATEGRAY);
        _eye2 = new Circle(3);
        _eye2.setFill(Color.SLATEGRAY);
        _pupil1 = new Circle(1, Color.WHITE);
        _pupil2 = new Circle(1, Color.WHITE);
    }

    public void removeFromPane(){
        _root.getChildren().removeAll(_hat, _shirt, _head, _beard, _mouth, _pants, _belt, _foot1, _foot2, _eye1, _eye2, _pupil1, _pupil2);
    }

    public void addToPane(){
        _root.getChildren().addAll(_hat, _shirt, _head, _beard, _mouth, _pants, _belt, _foot1, _foot2, _eye1, _eye2, _pupil1, _pupil2);
    }

    public void getPrice(){}

    public void setBounceLoc(double x, double y){
        _hat.setX(x);
        _hat.setY(y-50);
        _head.setCenterX(x+12.5);
        _head.setCenterY(y-27);
        _shirt.setX(x-12);
        _shirt.setY(y-13);
        _beard.setCenterX(x+12);
        _beard.setCenterY(y-10);
        _mouth.setCenterX(x+12);
        _mouth.setCenterY(y-18);
        _pants.setX(x-7);
        _pants.setY(y+22);
        _belt.setX(x-7);
        _belt.setY(y+22);
        _foot1.setCenterX(x-2);
        _foot1.setCenterY(y+50);
        _foot2.setCenterX(x+31);
        _foot2.setCenterY(y+50);
        _eye1.setCenterX(x+5.5);
        _eye1.setCenterY(y-30);
        _eye2.setCenterX(x+18.5);
        _eye2.setCenterY(y-30);
        _pupil1.setCenterX(x+6);
        _pupil1.setCenterY(y-31);
        _pupil2.setCenterX(x+19);
        _pupil2.setCenterY(y-31);
    }
    public void setOpacity(double x){}
}
