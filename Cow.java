package indy;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;

public class Cow extends Pet{
    private Ellipse _eye1;
    private Ellipse _eye2;
    private Ellipse _pupil1;
    private Ellipse _pupil2;
    private Ellipse _mouth;
    private Label _muzzle1;
    private Label _muzzle2;
    private Ellipse _nostril1;
    private Ellipse _nostril2;
    private Ellipse _spot1;
    private Ellipse _spot2;
    private Ellipse _spot3;
    private Ellipse _ear1;
    private Ellipse _ear2;
    private Ellipse _ear1int;
    private Ellipse _ear2int;
    private Pet[][] _pets;
    private Ellipse _coverNode;
    private Pane _root;

    public Cow(Pane root, Pet[][] pets, String petName, String personality, String birthMonth, String favFood){
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
        _mouth.setFill(Color.PINK);
        _muzzle1 = new Label(")");
        _muzzle1.setRotate(80);
        _muzzle1.setTextFill(Color.BLACK);
        Font font = new Font(14);
        _muzzle1.setFont(font);
        _muzzle2 = new Label(")");
        _muzzle2.setRotate(100);
        _muzzle2.setTextFill(Color.BLACK);
        _muzzle2.setFont(font);
        _nostril1 = new Ellipse(Constants.NOSTRIL_X, Constants.NOSTRIL_Y);
        _nostril2 = new Ellipse(Constants.NOSTRIL_X, Constants.NOSTRIL_Y);
        _spot1 = new Ellipse(Constants.SPOT_1_X, Constants.SPOT_1_Y);
        _spot1.setRotate(-20);
        _spot2 = new Ellipse(Constants.SPOT_2_X, Constants.SPOT_2_Y);
        _spot2.setRotate(23);
        _spot3 = new Ellipse(Constants.SPOT_3_X, Constants.SPOT_3_Y);
        _spot3.setRotate(-74);
        _ear1 = new Ellipse(Constants.EAR_X, Constants.EAR_Y);
        _ear1.setRotate(-65);
        _ear2 = new Ellipse(Constants.EAR_X, Constants.EAR_Y);
        _ear2.setRotate(65);
        _ear1int = new Ellipse(Constants.EAR_INT_X, Constants.EAR_INT_Y);
        _ear1int.setFill(Color.PINK);
        _ear1int.setRotate(-70);
        _ear2int = new Ellipse(Constants.EAR_INT_X, Constants.EAR_INT_Y);
        _ear2int.setFill(Color.PINK);
        _ear2int.setRotate(70);
        _coverNode = new Ellipse(Constants.ANIMAL_BODY_X, Constants.ANIMAL_BODY_Y);
        _coverNode.setFill(Color.TRANSPARENT);

        root.getChildren().addAll(_eye1, _eye2, _pupil1, _pupil2, _mouth, _muzzle1, _muzzle2, _nostril1, _nostril2,
                _spot1, _spot2, _spot3, _ear1, _ear2, _ear1int, _ear2int, _coverNode);
    }

    @Override
    public void removeFromPane(){
        _root.getChildren().removeAll(this.getBody(), _eye1, _eye2, _pupil1, _pupil2, _mouth, _muzzle1, _muzzle2, _nostril1, _nostril2,
                _spot1, _spot2, _spot3, _ear1, _ear2, _ear1int, _ear2int, _coverNode);
    }

    @Override
    public void addToPane(){
        _root.getChildren().addAll(this.getBody(), _eye1, _eye2, _pupil1, _pupil2, _mouth, _muzzle1, _muzzle2, _nostril1, _nostril2,
                _spot1, _spot2, _spot3, _ear1, _ear2, _ear1int, _ear2int, _coverNode);
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
        _muzzle1.setOpacity(x);
        _muzzle2.setOpacity(x);
        _nostril1.setOpacity(x);
        _nostril2.setOpacity(x);
        _spot1.setOpacity(x);
        _spot2.setOpacity(x);
        _spot3.setOpacity(x);
        _ear1.setOpacity(x);
        _ear2.setOpacity(x);
        _ear1int.setOpacity(x);
        _ear2int.setOpacity(x);
    }

    @Override
    public Color getPetColor(){
        return Color.WHITE;
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
            _mouth.setCenterX(x);
            _mouth.setCenterY(y-4);
            _muzzle1.relocate(x-7, y-9);
            _muzzle2.relocate(x+5, y-8);
            _nostril1.setCenterX(x-7);
            _nostril1.setCenterY(y-6);
            _nostril2.setCenterX(x+7);
            _nostril2.setCenterY(y-6);
            _spot1.setCenterX(x-40);
            _spot1.setCenterY(y+14);
            _spot2.setCenterX(x+36);
            _spot2.setCenterY(y+18);
            _spot3.setCenterX(x+9);
            _spot3.setCenterY(y-43);
            _ear1.setCenterX(x-45);
            _ear1.setCenterY(y-55);
            _ear2.setCenterX(x+45);
            _ear2.setCenterY(y-55);
            _ear1int.setCenterX(x-43);
            _ear1int.setCenterY(y-52);
            _ear2int.setCenterX(x+43);
            _ear2int.setCenterY(y-52);
            _coverNode.setCenterX(x);
            _coverNode.setCenterY(y);
        }
        else {
            this.setLoc(this.petXLoc(), this.petYLoc());
        }
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
        _mouth.setCenterX(x);
        _mouth.setCenterY(y-4);
        _muzzle1.relocate(x-7, y-9);
        _muzzle2.relocate(x+5, y-8);
        _nostril1.setCenterX(x-7);
        _nostril1.setCenterY(y-6);
        _nostril2.setCenterX(x+7);
        _nostril2.setCenterY(y-6);
        _spot1.setCenterX(x-40);
        _spot1.setCenterY(y+14);
        _spot2.setCenterX(x+36);
        _spot2.setCenterY(y+18);
        _spot3.setCenterX(x+9);
        _spot3.setCenterY(y-43);
        _ear1.setCenterX(x-45);
        _ear1.setCenterY(y-55);
        _ear2.setCenterX(x+45);
        _ear2.setCenterY(y-55);
        _ear1int.setCenterX(x-43);
        _ear1int.setCenterY(y-52);
        _ear2int.setCenterX(x+43);
        _ear2int.setCenterY(y-52);
        _coverNode.setCenterX(x);
        _coverNode.setCenterY(y);
    }

    @Override
    public String getType(){
        return "cow";
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
