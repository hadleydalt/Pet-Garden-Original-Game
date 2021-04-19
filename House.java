package indy;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class House implements Buyable{
    private Rectangle _roof;
    private Rectangle _rooftop;
    private Rectangle _front;
    private Rectangle _door;
    private Rectangle _doorFrame;
    private Rectangle _window1;
    private Rectangle _window2;
    private Rectangle _window1int;
    private Rectangle _window2int;
    private Pane _root;

    public House(Pane root){
        _root = root;
        _roof = new Rectangle(70, 70);
        _roof.setFill(Color.SLATEGRAY);
        _roof.setRotate(45);
        _rooftop = new Rectangle(70, 70);
        _rooftop.setFill(Color.WHITE);
        _rooftop.setRotate(45);
        _front = new Rectangle(100, 90);
        _front.setFill(Color.LIGHTCORAL);
        _door = new Rectangle(30, 45);
        _door.setFill(Color.GOLD);
        _doorFrame = new Rectangle(35, 47.5);
        _doorFrame.setFill(Color.WHITE);
        _window1 = new Rectangle(15, 20);
        _window1.setFill(Color.WHITE);
        _window2 = new Rectangle(15, 20);
        _window2.setFill(Color.WHITE);
        _window1int = new Rectangle(10, 15);
        _window1int.setFill(Color.GOLD);
        _window2int = new Rectangle(10, 15);
        _window2int.setFill(Color.GOLD);
    }
    public void getPrice(){}
    public void setBounceLoc(double x, double y){
        _roof.setX(x-30);
        _roof.setY(y-60);
        _rooftop.setX(x-30);
        _rooftop.setY(y-65);
        _front.setX(x-45);
        _front.setY(y-25);
        _door.setX(x-10);
        _door.setY(y+20);
        _doorFrame.setX(x-12.5);
        _doorFrame.setY(y+17.5);
        _window1.setX(x-27.5);
        _window1.setY(y-15);
        _window2.setX(x+22.5);
        _window2.setY(y-15);
        _window1int.setX(x-25);
        _window1int.setY(y-12.5);
        _window2int.setX(x+25);
        _window2int.setY(y-12.5);
    }

    public void setOpacity(double x){}

    public void removeFromPane(){
        _root.getChildren().removeAll(_rooftop, _roof, _front, _doorFrame, _door, _window1, _window2, _window1int, _window2int);
    }

    public void addToPane(){
        _root.getChildren().addAll(_rooftop, _roof, _front, _doorFrame, _door, _window1, _window2, _window1int, _window2int);
    }
}
