package indy;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class Walrus extends Pet{
    private Ellipse _eye1;
    private Ellipse _eye2;
    private Ellipse _pupil1;
    private Ellipse _pupil2;
    private Ellipse _mouth;
    private Ellipse _nose;
    private Rectangle _nosedivide;
    private Ellipse _spot1;
    private Ellipse _spot2;
    private Ellipse _spot3;
    private Ellipse _spot4;
    private Ellipse _spot5;
    private Ellipse _spot6;
    private Rectangle _tusk1;
    private Rectangle _tusk2;
    private Ellipse _flipper1;
    private Ellipse _flipper2;
    private Ellipse _tail1;
    private Ellipse _tail2;
    private Pet[][] _pets;

    public Walrus(Pane root, Pet[][] pets, String petName, int age, String birthMonth, String favFood){
        super(root, pets, petName, age, birthMonth, favFood);
        _pets = pets;
        _eye1 = new Ellipse(Constants.EYE_RAD, Constants.EYE_RAD);
        _eye2 = new Ellipse(Constants.EYE_RAD, Constants.EYE_RAD);
        _eye1.setFill(Color.BLACK);
        _eye2.setFill(Color.BLACK);
        _pupil1 = new Ellipse(Constants.PUPIL_RAD, Constants.PUPIL_RAD);
        _pupil2 = new Ellipse(Constants.PUPIL_RAD, Constants.PUPIL_RAD);
        _pupil1.setFill(Color.WHITE);
        _pupil2.setFill(Color.WHITE);
        _mouth = new Ellipse(Constants.MOUTH_X, Constants.MOUTH_Y);
        _mouth.setFill(Color.rgb(181, 227, 255));
        _nose = new Ellipse(Constants.NOSE_X, Constants.NOSE_Y);
        _nosedivide = new Rectangle(Constants.NOSE_DIVIDE_X, Constants.NOSE_DIVIDE_Y);
        _spot1 = new Ellipse(Constants.SPOT_RAD, Constants.SPOT_RAD);
        _spot1.setFill(Color.LIGHTSKYBLUE);
        _spot2 = new Ellipse(Constants.SPOT_RAD, Constants.SPOT_RAD);
        _spot2.setFill(Color.LIGHTSKYBLUE);
        _spot3 = new Ellipse(Constants.SPOT_RAD, Constants.SPOT_RAD);
        _spot3.setFill(Color.LIGHTSKYBLUE);
        _spot4 = new Ellipse(Constants.SPOT_RAD, Constants.SPOT_RAD);
        _spot4.setFill(Color.LIGHTSKYBLUE);
        _spot5 = new Ellipse(Constants.SPOT_RAD, Constants.SPOT_RAD);
        _spot5.setFill(Color.LIGHTSKYBLUE);
        _spot6 = new Ellipse(Constants.SPOT_RAD, Constants.SPOT_RAD);
        _spot6.setFill(Color.LIGHTSKYBLUE);
        _tusk1 = new Rectangle(Constants.TUSK_X, Constants.TUSK_Y);
        _tusk1.setFill(Color.WHITE);
        _tusk2 = new Rectangle(Constants.TUSK_X, Constants.TUSK_Y);
        _tusk2.setFill(Color.WHITE);
        _flipper1 = new Ellipse(Constants.FLIPPER_X, Constants.FLIPPER_Y);
        _flipper1.setRotate(60);
        _flipper1.setFill(Color.rgb(102, 182, 232));
        _flipper2 = new Ellipse(Constants.FLIPPER_X, Constants.FLIPPER_Y);
        _flipper2.setRotate(-60);
        _flipper2.setFill(Color.rgb(102, 182, 232));
        _tail1 = new Ellipse(Constants.TAIL_X, Constants.TAIL_Y);
        _tail1.setFill(Color.LIGHTSKYBLUE);
        _tail1.setRotate(75);
        _tail2 = new Ellipse(Constants.TAIL_X, Constants.TAIL_Y);
        _tail2.setFill(Color.LIGHTSKYBLUE);
        _tail2.setRotate(80);

        root.getChildren().addAll(_tusk1, _tusk2, _eye1, _eye2, _pupil1, _pupil2, _mouth, _nose, _nosedivide, _spot1, _spot2, _spot3,
                _spot4, _spot5, _spot6, _flipper1, _flipper2, _tail1, _tail2);
    }

    @Override
    public void setOpacity(double x){
        this.getBody().setOpacity(x);
        _tusk1.setOpacity(x);
        _tusk2.setOpacity(x);
        _eye1.setOpacity(x);
        _eye2.setOpacity(x);
        _pupil1.setOpacity(x);
        _pupil2.setOpacity(x);
        _mouth.setOpacity(x);
        _nose.setOpacity(x);
        _nosedivide.setOpacity(x);
        _spot1.setOpacity(x);
        _spot2.setOpacity(x);
        _spot3.setOpacity(x);
        _spot4.setOpacity(x);
        _spot5.setOpacity(x);
        _spot6.setOpacity(x);
        _flipper1.setOpacity(x);
        _flipper2.setOpacity(x);
        _tail1.setOpacity(x);
        _tail2.setOpacity(x);
    }

    @Override
    public Color getPetColor(){
        return Color.LIGHTSKYBLUE;
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
            _mouth.setCenterX(x);
            _mouth.setCenterY(y-4);
            _nose.setCenterX(x);
            _nose.setCenterY(y-17);
            _nosedivide.setX(x);
            _nosedivide.setY(y-13);
            _spot1.setCenterX(x-12);
            _spot1.setCenterY(y-7);
            _spot2.setCenterX(x-6);
            _spot2.setCenterY(y-4);
            _spot3.setCenterX(x-9);
            _spot3.setCenterY(y+1);

            _spot4.setCenterX(x+12);
            _spot4.setCenterY(y-7);
            _spot5.setCenterX(x+6);
            _spot5.setCenterY(y-4);
            _spot6.setCenterX(x+9);
            _spot6.setCenterY(y+1);

            _tusk1.setX(x-11);
            _tusk1.setY(y+5);
            _tusk2.setX(x+9);
            _tusk2.setY(y+5);

            _flipper1.setCenterX(x-40);
            _flipper1.setCenterY(y+15);
            _flipper2.setCenterX(x+40);
            _flipper2.setCenterY(y+15);

            _tail1.setCenterX(x+47);
            _tail1.setCenterY(y+38);
            _tail2.setCenterX(x+47);
            _tail2.setCenterY(y+48);
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
        _mouth.setCenterX(x);
        _mouth.setCenterY(y-4);
        _nose.setCenterX(x);
        _nose.setCenterY(y-17);
        _nosedivide.setX(x);
        _nosedivide.setY(y-13);
        _spot1.setCenterX(x-12);
        _spot1.setCenterY(y-7);
        _spot2.setCenterX(x-6);
        _spot2.setCenterY(y-4);
        _spot3.setCenterX(x-9);
        _spot3.setCenterY(y+1);

        _spot4.setCenterX(x+12);
        _spot4.setCenterY(y-7);
        _spot5.setCenterX(x+6);
        _spot5.setCenterY(y-4);
        _spot6.setCenterX(x+9);
        _spot6.setCenterY(y+1);

        _tusk1.setX(x-11);
        _tusk1.setY(y+5);
        _tusk2.setX(x+9);
        _tusk2.setY(y+5);

        _flipper1.setCenterX(x-40);
        _flipper1.setCenterY(y+15);
        _flipper2.setCenterX(x+40);
        _flipper2.setCenterY(y+15);

        _tail1.setCenterX(x+47);
        _tail1.setCenterY(y+38);
        _tail2.setCenterX(x+47);
        _tail2.setCenterY(y+48);
    }

    @Override
    public String getType(){
        return "walrus";
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
}
