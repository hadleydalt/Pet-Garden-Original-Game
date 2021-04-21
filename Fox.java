package indy;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Fox extends Pet{
    private Ellipse _eye1;
    private Ellipse _eye2;
    private Ellipse _pupil1;
    private Ellipse _pupil2;
    private Ellipse _stomach;
    private Ellipse _eyeback1;
    private Ellipse _eyeback2;
    private Ellipse _nose;
    private Label _muzzle1;
    private Label _muzzle2;
    private Rectangle _ear1;
    private Rectangle _ear2;
    private Ellipse _tail;
    private Buyable[][] _pets;
    private Ellipse _coverNode;
    private Pane _root;
    private double _originalYLoc;

    public Fox(Pane root, Buyable[][] pets, String petName, String personality, String birthMonth, String favFood){
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
        _stomach = new Ellipse(Constants.STOMACH_X, Constants.STOMACH_Y);
        _stomach.setFill(Color.WHEAT);
        _eyeback1 = new Ellipse(Constants.EYE_BACK_X, Constants.EYE_BACK_Y);
        _eyeback1.setFill(Color.WHEAT);
        _eyeback1.setRotate(-20);
        _eyeback2 = new Ellipse(Constants.EYE_BACK_X, Constants.EYE_BACK_Y);
        _eyeback2.setFill(Color.WHEAT);
        _eyeback2.setRotate(20);
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
        _ear1 = new Rectangle(Constants.EAR_LENGTH, Constants.EAR_LENGTH);
        _ear1.setFill(Color.CORAL);
        _ear1.setRotate(15);
        _ear2 = new Rectangle(Constants.EAR_LENGTH, Constants.EAR_LENGTH);
        _ear2.setFill(Color.CORAL);
        _ear2.setRotate(77);
        _tail = new Ellipse(Constants.TAIL_X, Constants.TAIL_Y);
        _tail.setFill(Color.CORAL);
        _tail.setRotate(75);
        _coverNode = new Ellipse(Constants.ANIMAL_BODY_X, Constants.ANIMAL_BODY_Y);
        _coverNode.setFill(Color.TRANSPARENT);

        root.getChildren().addAll(_ear1, _ear2, _eyeback1, _eyeback2, _eye1, _eye2, _pupil1, _pupil2, _stomach, _nose, _muzzle1, _muzzle2,
                _tail, _coverNode);
    }

    @Override
    public void removeFromPane(){
        _root.getChildren().removeAll(this.getBody(), _ear1, _ear2, _eyeback1, _eyeback2, _eye1, _eye2, _pupil1, _pupil2,
                _stomach, _nose, _muzzle1, _muzzle2, _tail, _coverNode);
    }

    @Override
    public void addToPane(){
        _root.getChildren().addAll(this.getBody(), _ear1, _ear2, _eyeback1, _eyeback2, _eye1, _eye2, _pupil1, _pupil2,
                _stomach, _nose, _muzzle1, _muzzle2, _tail, _coverNode);
    }

    @Override
    public Ellipse getNode(){
        return _coverNode;
    }

    @Override
    public void setOpacity(double x){
        this.getBody().setOpacity(x);
        _ear1.setOpacity(x);
        _ear2.setOpacity(x);
        _eyeback1.setOpacity(x);
        _eyeback2.setOpacity(x);
        _eye1.setOpacity(x);
        _eye2.setOpacity(x);
        _pupil1.setOpacity(x);
        _pupil2.setOpacity(x);
        _stomach.setOpacity(x);
        _nose.setOpacity(x);
        _muzzle1.setOpacity(x);
        _muzzle2.setOpacity(x);
        _tail.setOpacity(x);
    }

    @Override
    public Color getPetColor(){
        return Color.CORAL;
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
            _stomach.setCenterX(x);
            _stomach.setCenterY(y+22);
            _eyeback1.setCenterX(x-20);
            _eyeback1.setCenterY(y-15);
            _eyeback2.setCenterX(x+20);
            _eyeback2.setCenterY(y-15);
            _nose.setCenterX(x);
            _nose.setCenterY(y-9);
            _muzzle1.relocate(x-7, y-11);
            _muzzle2.relocate(x+5, y-10);
            _ear1.setX(x-40);
            _ear1.setY(y-63);
            _ear2.setX(x+20);
            _ear2.setY(y-60);
            _tail.setCenterX(x+47);
            _tail.setCenterY(y+48);
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
        _stomach.setCenterX(x);
        _stomach.setCenterY(y+22);
        _eyeback1.setCenterX(x-20);
        _eyeback1.setCenterY(y-15);
        _eyeback2.setCenterX(x+20);
        _eyeback2.setCenterY(y-15);
        _nose.setCenterX(x);
        _nose.setCenterY(y-9);
        _muzzle1.relocate(x-7, y-11);
        _muzzle2.relocate(x+5, y-10);
        _ear1.setX(x-40);
        _ear1.setY(y-63);
        _ear2.setX(x+20);
        _ear2.setY(y-60);
        _tail.setCenterX(x+47);
        _tail.setCenterY(y+48);
        _coverNode.setCenterX(x);
        _coverNode.setCenterY(y);
    }

    @Override
    public String getType(){
        return "Fox";
    }

    @Override
    public int getPrice() {
        return 100;
    }
}
