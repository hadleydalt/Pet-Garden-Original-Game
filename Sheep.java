package indy;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;

public class Sheep extends Pet{
    private Ellipse _eye1;
    private Ellipse _eye2;
    private Ellipse _pupil1;
    private Ellipse _pupil2;
    private Ellipse _fluff1;
    private Ellipse _fluff2;
    private Ellipse _fluff3;
    private Ellipse _fluff4;
    private Ellipse _fluff5;
    private Ellipse _fluff6;
    private Ellipse _fluff7;
    private Ellipse _fluff8;
    private Ellipse _fluff9;
    private Ellipse _fluff10;
    private Ellipse _mouth;
    private Ellipse _nose;
    private Label _muzzle1;
    private Label _muzzle2;
    private Ellipse _face;

    public Sheep(Pane root){
        super(root);
        _eye1 = new Ellipse(Constants.EYE_RAD, Constants.EYE_RAD);
        _eye2 = new Ellipse(Constants.EYE_RAD, Constants.EYE_RAD);
        _eye1.setFill(Color.BLACK);
        _eye2.setFill(Color.BLACK);
        _pupil1 = new Ellipse(Constants.PUPIL_RAD, Constants.PUPIL_RAD);
        _pupil2 = new Ellipse(Constants.PUPIL_RAD, Constants.PUPIL_RAD);
        _pupil1.setFill(Color.WHITE);
        _pupil2.setFill(Color.WHITE);
        _fluff1 = new Ellipse(Constants.FLUFF_RAD, Constants.FLUFF_RAD);
        _fluff1.setFill(Color.rgb(240, 229, 216));
        _fluff2 = new Ellipse(Constants.FLUFF_RAD, Constants.FLUFF_RAD);
        _fluff2.setFill(Color.rgb(240, 229, 216));
        _fluff3 = new Ellipse(Constants.FLUFF_RAD, Constants.FLUFF_RAD);
        _fluff3.setFill(Color.rgb(240, 229, 216));
        _fluff4 = new Ellipse(Constants.FLUFF_RAD, Constants.FLUFF_RAD);
        _fluff4.setFill(Color.rgb(240, 229, 216));
        _fluff5 = new Ellipse(Constants.FLUFF_RAD, Constants.FLUFF_RAD);
        _fluff5.setFill(Color.rgb(240, 229, 216));
        _fluff6 = new Ellipse(Constants.FLUFF_RAD, Constants.FLUFF_RAD);
        _fluff6.setFill(Color.rgb(240, 229, 216));
        _fluff7 = new Ellipse(Constants.FLUFF_RAD, Constants.FLUFF_RAD);
        _fluff7.setFill(Color.rgb(240, 229, 216));
        _fluff8 = new Ellipse(Constants.FLUFF_RAD, Constants.FLUFF_RAD);
        _fluff8.setFill(Color.rgb(240, 229, 216));
        _fluff9 = new Ellipse(Constants.FLUFF_RAD, Constants.FLUFF_RAD);
        _fluff9.setFill(Color.rgb(240, 229, 216));
        _fluff10 = new Ellipse(Constants.FLUFF_RAD, Constants.FLUFF_RAD);
        _fluff10.setFill(Color.rgb(240, 229, 216));
        _mouth = new Ellipse(Constants.MOUTH_X, Constants.MOUTH_Y);
        _mouth.setFill(Color.rgb(245, 234, 220));
        _nose = new Ellipse(Constants.NOSE_X, Constants.NOSE_Y);
        _nose.setFill(Color.PINK);
        _muzzle1 = new Label(")");
        _muzzle1.setRotate(80);
        _muzzle1.setTextFill(Color.rgb(54, 24, 0));
        Font font = new Font(14);
        _muzzle1.setFont(font);
        _muzzle2 = new Label(")");
        _muzzle2.setRotate(100);
        _muzzle2.setTextFill(Color.rgb(54, 24, 0));
        _muzzle2.setFont(font);
        _face = new Ellipse(Constants.FACE_X, Constants.FACE_Y);
        _face.setFill(Color.rgb(227, 213, 197));

        root.getChildren().addAll(_face, _eye1, _eye2, _pupil1, _pupil2, _fluff1, _fluff2, _fluff3, _fluff4, _fluff5, _fluff6,
                _fluff7, _fluff8, _fluff9, _fluff10, _mouth, _nose, _muzzle1, _muzzle2);
    }

    @Override
    public Color getPetColor(){
        return Color.rgb(240, 229, 216);
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
        _fluff1.setCenterX(x-30);
        _fluff1.setCenterY(y-60);
        _fluff2.setCenterX(x-7);
        _fluff2.setCenterY(y-60);
        _fluff3.setCenterX(x-43);
        _fluff3.setCenterY(y-40);

        _fluff4.setCenterX(x+60);
        _fluff4.setCenterY(y-20);
        _fluff5.setCenterX(x+60);
        _fluff5.setCenterY(y);
        _fluff6.setCenterX(x+43);
        _fluff6.setCenterY(y-35);

        _fluff7.setCenterX(x-60);
        _fluff7.setCenterY(y);
        _fluff8.setCenterX(x-45);
        _fluff8.setCenterY(y+35);
        _fluff9.setCenterX(x-53);
        _fluff9.setCenterY(y+20);

        _fluff10.setCenterX(x+45);
        _fluff10.setCenterY(y+40);

        _mouth.setCenterX(x);
        _mouth.setCenterY(y-4);

        _nose.setCenterX(x);
        _nose.setCenterY(y-7);
        _muzzle1.relocate(x-7, y-9);
        _muzzle2.relocate(x+5, y-8);

        _face.setCenterX(x);
        _face.setCenterY(y-15);
    }
}
