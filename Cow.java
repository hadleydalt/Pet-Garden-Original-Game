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

    public Cow(Pane root){
        super(root);
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

        root.getChildren().addAll(_eye1, _eye2, _pupil1, _pupil2, _mouth, _muzzle1, _muzzle2, _nostril1, _nostril2,
                _spot1, _spot2, _spot3, _ear1, _ear2, _ear1int, _ear2int);
    }

    @Override
    public Color getPetColor(){
        return Color.WHITE;
    }

    @Override
    public void setLoc(double x, double y){
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
    }

    @Override
    public String getType(){
        return "cow";
    }
}
