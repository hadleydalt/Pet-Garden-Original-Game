package indy;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Chicken extends Pet{
    private Ellipse _eye1;
    private Ellipse _eye2;
    private Ellipse _pupil1;
    private Ellipse _pupil2;
    private Ellipse _beak;
    private Ellipse _wing1;
    private Ellipse _wing2;
    private Ellipse _waddle;
    private Ellipse _top1;
    private Ellipse _top2;
    private Ellipse _top3;
    private Pet[][] _pets;

    public Chicken(Pane root, Pet[][] pets){
        super(root, pets);
        _pets = pets;
        _eye1 = new Ellipse(Constants.EYE_RAD, Constants.EYE_RAD);
        _eye2 = new Ellipse(Constants.EYE_RAD, Constants.EYE_RAD);
        _eye1.setFill(Color.BLACK);
        _eye2.setFill(Color.BLACK);
        _pupil1 = new Ellipse(Constants.PUPIL_RAD, Constants.PUPIL_RAD);
        _pupil2 = new Ellipse(Constants.PUPIL_RAD, Constants.PUPIL_RAD);
        _pupil1.setFill(Color.WHITE);
        _pupil2.setFill(Color.WHITE);
        _beak = new Ellipse(Constants.BEAK_X, Constants.BEAK_Y);
        _beak.setFill(Color.ORANGE);
        _wing1 = new Ellipse(Constants.WING_X, Constants.WING_Y);
        _wing1.setFill(Color.GOLD);
        _wing1.setRotate(-13);
        _wing2 = new Ellipse(Constants.WING_X, Constants.WING_Y);
        _wing2.setFill(Color.GOLD);
        _wing2.setRotate(13);
        _waddle = new Ellipse(Constants.WADDLE_RAD, Constants.WADDLE_RAD);
        _waddle.setFill(Color.TOMATO);
        _top1 = new Ellipse(Constants.SMALL_TOP_X, Constants.SMALL_TOP_Y);
        _top1.setFill(Color.TOMATO);
        _top1.setRotate(-30);
        _top2 = new Ellipse(Constants.BIG_TOP_X, Constants.BIG_TOP_Y);
        _top2.setFill(Color.TOMATO);
        _top3 = new Ellipse(Constants.SMALL_TOP_X, Constants.SMALL_TOP_Y);
        _top3.setFill(Color.TOMATO);
        _top3.setRotate(30);

        root.getChildren().addAll(_eye1, _eye2, _pupil1, _pupil2, _waddle, _beak, _wing1, _wing2, _top1, _top2, _top3);
    }

    @Override
    public Color getPetColor(){
        return Color.rgb(245, 234, 120);
    }

    @Override
    public void setLoc(double x, double y){
        if (_pets[(int) ((x-110)/130)][(int) ((y-290)/130)] == null) {
            this.getBody().setCenterX(x);
            this.getBody().setCenterY(y);
            _eye1.setCenterX(x-15);
            _eye1.setCenterY(y-20);
            _eye2.setCenterX(x+15);
            _eye2.setCenterY(y-20);
            _pupil1.setCenterX(x-13);
            _pupil1.setCenterY(y-21);
            _pupil2.setCenterX(x+17);
            _pupil2.setCenterY(y-21);
            _beak.setCenterX(x);
            _beak.setCenterY(y-3);
            _wing1.setCenterX(x-38);
            _wing1.setCenterY(y+5);
            _wing2.setCenterX(x+38);
            _wing2.setCenterY(y+5);
            _waddle.setCenterX(x);
            _waddle.setCenterY(y+10);
            _top1.setCenterX(x-10);
            _top1.setCenterY(y-55);
            _top2.setCenterX(x);
            _top2.setCenterY(y-62);
            _top3.setCenterX(x+10);
            _top3.setCenterY(y-55);
        }
        else {
            this.setLoc(this.petXLoc(), this.petYLoc());
        }
    }

    @Override
    public void setBounceLoc(double x, double y){
        this.getBody().setCenterX(x);
        this.getBody().setCenterY(y);
        _eye1.setCenterX(x-15);
        _eye1.setCenterY(y-20);
        _eye2.setCenterX(x+15);
        _eye2.setCenterY(y-20);
        _pupil1.setCenterX(x-13);
        _pupil1.setCenterY(y-21);
        _pupil2.setCenterX(x+17);
        _pupil2.setCenterY(y-21);
        _beak.setCenterX(x);
        _beak.setCenterY(y-3);
        _wing1.setCenterX(x-38);
        _wing1.setCenterY(y+5);
        _wing2.setCenterX(x+38);
        _wing2.setCenterY(y+5);
        _waddle.setCenterX(x);
        _waddle.setCenterY(y+10);
        _top1.setCenterX(x-10);
        _top1.setCenterY(y-55);
        _top2.setCenterX(x);
        _top2.setCenterY(y-62);
        _top3.setCenterX(x+10);
        _top3.setCenterY(y-55);
    }

    @Override
    public String getType(){
        return "chicken";
    }

    public int petXLoc(){
        int loc = 0;
        int rand_int = (int) (Math.random() * 3);
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
        int rand_int = (int) (Math.random() * 3);
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
}
