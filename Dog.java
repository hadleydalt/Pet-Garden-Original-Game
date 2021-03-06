package indy;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;

// Creates a Dog. Its methods are explained in the Pet superclass.

public class Dog extends Pet{
    private Ellipse _eye1;
    private Ellipse _eye2;
    private Ellipse _pupil1;
    private Ellipse _pupil2;
    private Ellipse _spot1;
    private Ellipse _spot2;
    private Ellipse _nose;
    private Label _muzzle1;
    private Label _muzzle2;
    private Ellipse _ear11;
    private Ellipse _ear21;
    private Ellipse _ear12;
    private Ellipse _ear22;
    private Buyable[][] _pets;
    private Ellipse _coverNode;
    private Pane _root;
    private double _originalYLoc;

    public Dog(Pane root, Buyable[][] pets, String petName, String personality, String birthMonth, String favFood){
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
        _spot1 = new Ellipse(Constants.BIG_SPOT_X, Constants.BIG_SPOT_Y);
        _spot1.setFill(Color.PERU);
        _spot1.setRotate(35);
        _spot2 = new Ellipse(Constants.SMALL_SPOT_X, Constants.SMALL_SPOT_Y);
        _spot2.setFill(Color.PERU);
        _spot2.setRotate(35);
        _nose = new Ellipse(Constants.NOSE_X, Constants.NOSE_Y);
        _nose.setFill(Color.rgb(54, 24, 0));
        _muzzle1 = new Label(")");
        _muzzle1.setRotate(80);
        _muzzle1.setTextFill(Color.rgb(54, 24, 0));
        Font font = new Font(14);
        _muzzle1.setFont(font);
        _muzzle2 = new Label(")");
        _muzzle2.setRotate(100);
        _muzzle2.setTextFill(Color.rgb(54, 24, 0));
        _muzzle2.setFont(font);
        _ear11 = new Ellipse(Constants.EAR_1_X, Constants.EAR_1_Y);
        _ear11.setFill(Color.WHEAT);
        _ear11.setRotate(-50);
        _ear12 = new Ellipse(Constants.EAR_1_X, Constants.EAR_1_Y);
        _ear12.setFill(Color.WHEAT);
        _ear12.setRotate(50);
        _ear21 = new Ellipse(Constants.EAR_1_X, Constants.EAR_1_Y);
        _ear21.setFill(Color.WHEAT);
        _ear21.setRotate(50);
        _ear22 = new Ellipse(Constants.EAR_1_X, Constants.EAR_1_Y);
        _ear22.setFill(Color.WHEAT);
        _ear22.setRotate(-50);
        _coverNode = new Ellipse(Constants.ANIMAL_BODY_X, Constants.ANIMAL_BODY_Y);
        _coverNode.setFill(Color.TRANSPARENT);

        root.getChildren().addAll(_spot1, _spot2, _eye1, _eye2, _pupil1, _pupil2, _nose, _muzzle1, _muzzle2, _ear11, _ear12,
                _ear21, _ear22, _coverNode);
    }

    @Override
    public void removeFromPane(){
        _root.getChildren().removeAll(this.getBody(), _spot1, _spot2, _eye1, _eye2, _pupil1, _pupil2, _nose, _muzzle1, _muzzle2, _ear11, _ear12,
                _ear21, _ear22, _coverNode);
    }

    @Override
    public void addToPane(){
        _root.getChildren().addAll(this.getBody(), _spot1, _spot2, _eye1, _eye2, _pupil1, _pupil2, _nose, _muzzle1, _muzzle2, _ear11, _ear12,
                _ear21, _ear22, _coverNode);
    }

    @Override
    public Ellipse getNode(){
        return _coverNode;
    }

    @Override
    public void setOpacity(double x){
        this.getBody().setOpacity(x);
        _spot1.setOpacity(x);
        _spot2.setOpacity(x);
        _eye1.setOpacity(x);
        _eye2.setOpacity(x);
        _pupil1.setOpacity(x);
        _pupil2.setOpacity(x);
        _nose.setOpacity(x);
        _muzzle1.setOpacity(x);
        _muzzle2.setOpacity(x);
        _ear11.setOpacity(x);
        _ear12.setOpacity(x);
        _ear21.setOpacity(x);
        _ear22.setOpacity(x);
    }

    @Override
    public Color getPetColor(){
        return Color.WHEAT;
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
            _pupil1.setCenterX(x-13);
            _pupil1.setCenterY(y-21);
            _pupil2.setCenterX(x+17);
            _pupil2.setCenterY(y-21);
            _spot1.setCenterX(x-17);
            _spot1.setCenterY(y-10);
            _spot2.setCenterX(x+35);
            _spot2.setCenterY(y+22);
            _nose.setCenterX(x);
            _nose.setCenterY(y-7);
            _muzzle1.relocate(x-7, y-9);
            _muzzle2.relocate(x+5, y-8);
            _ear11.setCenterX(x-35);
            _ear11.setCenterY(y-63);
            _ear12.setCenterX(x+35);
            _ear12.setCenterY(y-63);
            _ear21.setCenterX(x-50);
            _ear21.setCenterY(y-63);
            _ear22.setCenterX(x+50);
            _ear22.setCenterY(y-63);
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
        _pupil1.setCenterX(x-13);
        _pupil1.setCenterY(y-21);
        _pupil2.setCenterX(x+17);
        _pupil2.setCenterY(y-21);
        _spot1.setCenterX(x-17);
        _spot1.setCenterY(y-10);
        _spot2.setCenterX(x+35);
        _spot2.setCenterY(y+22);
        _nose.setCenterX(x);
        _nose.setCenterY(y-7);
        _muzzle1.relocate(x-7, y-9);
        _muzzle2.relocate(x+5, y-8);
        _ear11.setCenterX(x-35);
        _ear11.setCenterY(y-63);
        _ear12.setCenterX(x+35);
        _ear12.setCenterY(y-63);
        _ear21.setCenterX(x-50);
        _ear21.setCenterY(y-63);
        _ear22.setCenterX(x+50);
        _ear22.setCenterY(y-63);
        _coverNode.setCenterX(x);
        _coverNode.setCenterY(y);
    }

    @Override
    public String getType(){
        return "Dog";
    }

    @Override
    public int getPrice() {
        return 80;
    }
}
