package indy;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

// Creates a Giraffe. Its methods are explained in the Pet superclass.

public class Giraffe extends Pet{
    private Ellipse _eye1;
    private Ellipse _eye2;
    private Ellipse _pupil1;
    private Ellipse _pupil2;
    private Ellipse _mouth;
    private Ellipse _nostril1;
    private Ellipse _nostril2;
    private Label _muzzle1;
    private Label _muzzle2;
    private Ellipse _spot1;
    private Ellipse _spot2;
    private Ellipse _spot3;
    private Ellipse _spot4;
    private Ellipse _spot5;
    private Ellipse _spot6;
    private Ellipse _ear11;
    private Ellipse _ear12;
    private Rectangle _thing1;
    private Rectangle _thing2;
    private Ellipse _thing11;
    private Ellipse _thing22;
    private Buyable[][] _pets;
    private Ellipse _coverNode;
    private Pane _root;
    private double _originalYLoc;

    public Giraffe(Pane root, Buyable[][] pets, String petName, String personality, String birthMonth, String favFood){
        super(root, pets, petName, personality, birthMonth, favFood);
        _root = root;
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
        _mouth.setFill(Color.rgb(245, 234, 120));
        _nostril1 = new Ellipse(Constants.NOSTRIL_X, Constants.NOSTRIL_Y);
        _nostril1.setFill(Color.ORANGE);
        _nostril2 = new Ellipse(Constants.NOSTRIL_X, Constants.NOSTRIL_Y);
        _nostril2.setFill(Color.ORANGE);
        _muzzle1 = new Label(")");
        _muzzle1.setRotate(80);
        Font font = new Font(14);
        _muzzle1.setFont(font);
        _muzzle2 = new Label(")");
        _muzzle2.setRotate(100);
        _muzzle2.setFont(font);
        _spot1 = new Ellipse(Constants.SPOT_S_RAD, Constants.SPOT_S_RAD);
        _spot1.setFill(Color.ORANGE);
        _spot2 = new Ellipse(Constants.SPOT_L_RAD, Constants.SPOT_L_RAD);
        _spot2.setFill(Color.ORANGE);
        _spot3 = new Ellipse(Constants.SPOT_M_RAD, Constants.SPOT_M_RAD);
        _spot3.setFill(Color.ORANGE);
        _spot4 = new Ellipse(Constants.SPOT_M_RAD, Constants.SPOT_M_RAD);
        _spot4.setFill(Color.ORANGE);
        _spot5 = new Ellipse(Constants.SPOT_S_RAD, Constants.SPOT_S_RAD);
        _spot5.setFill(Color.ORANGE);
        _spot6 = new Ellipse(Constants.SPOT_L_RAD, Constants.SPOT_L_RAD);
        _spot6.setFill(Color.ORANGE);
        _ear11 = new Ellipse(Constants.EAR_1_X, Constants.EAR_1_Y);
        _ear11.setFill(Color.GOLD);
        _ear11.setRotate(-50);
        _ear12 = new Ellipse(Constants.EAR_1_X, Constants.EAR_1_Y);
        _ear12.setFill(Color.GOLD);
        _ear12.setRotate(50);
        _thing1 = new Rectangle(Constants.THING_X, Constants.THING_Y);
        _thing1.setFill(Color.PERU);
        _thing1.setRotate(-20);
        _thing2 = new Rectangle(Constants.THING_X, Constants.THING_Y);
        _thing2.setFill(Color.PERU);
        _thing2.setRotate(20);
        _thing11 = new Ellipse(Constants.THING_1_X, Constants.THING_1_Y);
        _thing11.setFill(Color.PERU);
        _thing11.setRotate(-20);
        _thing22 = new Ellipse(Constants.THING_1_X, Constants.THING_1_Y);
        _thing22.setFill(Color.PERU);
        _thing22.setRotate(20);
        _coverNode = new Ellipse(Constants.ANIMAL_BODY_X, Constants.ANIMAL_BODY_Y);
        _coverNode.setFill(Color.TRANSPARENT);


        root.getChildren().addAll(_eye1, _eye2, _pupil1, _pupil2, _mouth, _nostril1, _nostril2, _muzzle1, _muzzle2,
                _spot1, _spot2, _spot3, _spot4, _spot5, _spot6, _ear11, _ear12, _thing1, _thing2, _thing11, _thing22, _coverNode);
    }

    @Override
    public void removeFromPane(){
        _root.getChildren().removeAll(this.getBody(), _eye1, _eye2, _pupil1, _pupil2, _mouth, _nostril1, _nostril2, _muzzle1, _muzzle2,
                _spot1, _spot2, _spot3, _spot4, _spot5, _spot6, _ear11, _ear12, _thing1, _thing2, _thing11, _thing22, _coverNode);
    }

    @Override
    public void addToPane(){
        _root.getChildren().addAll(this.getBody(), _eye1, _eye2, _pupil1, _pupil2, _mouth, _nostril1, _nostril2, _muzzle1, _muzzle2,
                _spot1, _spot2, _spot3, _spot4, _spot5, _spot6, _ear11, _ear12, _thing1, _thing2, _thing11, _thing22, _coverNode);
    }

    @Override
    public Ellipse getNode(){
        return _coverNode;
    }

    @Override
    public void setOpacity(double x){
        this.getBody().setOpacity(x);
        _eye1.setOpacity(x);
        _eye2.setOpacity(x);
        _pupil1.setOpacity(x);
        _pupil2.setOpacity(x);
        _mouth.setOpacity(x);
        _nostril1.setOpacity(x);
        _nostril2.setOpacity(x);
        _muzzle1.setOpacity(x);
        _muzzle2.setOpacity(x);
        _spot1.setOpacity(x);
        _spot2.setOpacity(x);
        _spot3.setOpacity(x);
        _spot4.setOpacity(x);
        _spot5.setOpacity(x);
        _spot6.setOpacity(x);
        _ear11.setOpacity(x);
        _ear12.setOpacity(x);
        _thing1.setOpacity(x);
        _thing2.setOpacity(x);
        _thing11.setOpacity(x);
        _thing22.setOpacity(x);
    }

    @Override
    public Color getPetColor(){
        return Color.GOLD;
    }

    @Override
    public void setLoc(double x, double y){
        if (_pets[(int) ((x-110)/130)][(int) ((y-290)/130)] == null) {
            super.setLoc(x, y);
            this.getBody().setCenterX(x);
            this.getBody().setCenterY(y);
            _eye1.setCenterX(x-15);
            _eye1.setCenterY(y-20);
            _eye2.setCenterX(x+15);
            _eye2.setCenterY(y-20);
            _mouth.setCenterX(x);
            _mouth.setCenterY(y-4);
            _pupil1.setCenterX(x-13);
            _pupil1.setCenterY(y-21);
            _pupil2.setCenterX(x+17);
            _pupil2.setCenterY(y-21);
            _nostril1.setCenterX(x-7);
            _nostril1.setCenterY(y-6);
            _nostril2.setCenterX(x+7);
            _nostril2.setCenterY(y-6);
            _muzzle1.relocate(x-7, y-9);
            _muzzle2.relocate(x+5, y-8);
            _spot1.setCenterX(x-30);
            _spot1.setCenterY(y-35);
            _spot2.setCenterX(x-38);
            _spot2.setCenterY(y+3);
            _spot3.setCenterX(x-28);
            _spot3.setCenterY(y+35);
            _spot4.setCenterX(x+30);
            _spot4.setCenterY(y-35);
            _spot5.setCenterX(x+38);
            _spot5.setCenterY(y+3);
            _spot6.setCenterX(x+28);
            _spot6.setCenterY(y+25);
            _ear11.setCenterX(x-35);
            _ear11.setCenterY(y-63);
            _ear12.setCenterX(x+35);
            _ear12.setCenterY(y-63);
            _thing1.setX(x-15);
            _thing1.setY(y-75);
            _thing2.setX(x+13);
            _thing2.setY(y-75);
            _thing11.setCenterX(x-15);
            _thing11.setCenterY(y-75);
            _thing22.setCenterX(x+20);
            _thing22.setCenterY(y-75);
            _coverNode.setCenterX(x);
            _coverNode.setCenterY(y);
            _originalYLoc = y;
        }
        else {
            this.setLoc(this.petXLoc(), this.petYLoc());
        }
    }

    @Override
    public double getOYL(){
        return _originalYLoc;
    }

    @Override
    public void setBounceLoc(double x, double y){
        super.setBounceLoc(x, y);
        this.getBody().setCenterX(x);
        this.getBody().setCenterY(y);
        _eye1.setCenterX(x-15);
        _eye1.setCenterY(y-20);
        _eye2.setCenterX(x+15);
        _eye2.setCenterY(y-20);
        _mouth.setCenterX(x);
        _mouth.setCenterY(y-4);
        _pupil1.setCenterX(x-13);
        _pupil1.setCenterY(y-21);
        _pupil2.setCenterX(x+17);
        _pupil2.setCenterY(y-21);
        _nostril1.setCenterX(x-7);
        _nostril1.setCenterY(y-6);
        _nostril2.setCenterX(x+7);
        _nostril2.setCenterY(y-6);
        _muzzle1.relocate(x-7, y-9);
        _muzzle2.relocate(x+5, y-8);
        _spot1.setCenterX(x-30);
        _spot1.setCenterY(y-35);
        _spot2.setCenterX(x-38);
        _spot2.setCenterY(y+3);
        _spot3.setCenterX(x-28);
        _spot3.setCenterY(y+35);
        _spot4.setCenterX(x+30);
        _spot4.setCenterY(y-35);
        _spot5.setCenterX(x+38);
        _spot5.setCenterY(y+3);
        _spot6.setCenterX(x+28);
        _spot6.setCenterY(y+25);
        _ear11.setCenterX(x-35);
        _ear11.setCenterY(y-63);
        _ear12.setCenterX(x+35);
        _ear12.setCenterY(y-63);
        _thing1.setX(x-15);
        _thing1.setY(y-75);
        _thing2.setX(x+13);
        _thing2.setY(y-75);
        _thing11.setCenterX(x-15);
        _thing11.setCenterY(y-75);
        _thing22.setCenterX(x+20);
        _thing22.setCenterY(y-75);
        _coverNode.setCenterX(x);
        _coverNode.setCenterY(y);
    }

    @Override
    public String getType(){
        return "Giraffe";
    }

    @Override
    public int getPrice() {
        return 200;
    }
}
