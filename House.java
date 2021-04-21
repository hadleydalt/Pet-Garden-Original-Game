package indy;

import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
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
    private Buyable[][] _pets;

    public House(Pane root, Buyable[][] pets){
        _pets = pets;
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
    public int getPrice(){
        return 70;
    }

    public String getType(){
        return "House";
    }

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

    public void setLoc(double x, double y){
        if (_pets[(int) ((x-110)/130)][(int) ((y-290)/130)] == null) {
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
        else{
            this.setLoc(this.petXLoc(), this.petYLoc());
        }
    }

    public void setOpacity(double x){}

    public void removeFromPane(){
        _root.getChildren().removeAll(_rooftop, _roof, _front, _doorFrame, _door, _window1, _window2, _window1int, _window2int);
    }

    public void addToPane(){
        _root.getChildren().addAll(_rooftop, _roof, _front, _doorFrame, _door, _window1, _window2, _window1int, _window2int);
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

    public Timeline getTimeline(){
        return null;
    }

    public double getXLoc(){
        return _roof.getX()+30;
    }

    public double getYLoc(){
        return _roof.getY()+60;
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
}
