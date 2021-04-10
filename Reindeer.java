package indy;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Reindeer extends Pet{
    private Ellipse _eye1;
    private Ellipse _eye2;
    private Ellipse _pupil1;
    private Ellipse _pupil2;
    private Ellipse _mouth;
    private Ellipse _nose;
    private Label _muzzle1;
    private Label _muzzle2;
    private Ellipse _ear11;
    private Ellipse _ear12;
    private Rectangle _thing1;
    private Rectangle _thing2;
    private Rectangle _thing3;
    private Rectangle _thing4;

    public Reindeer(Pane root){
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
        _mouth.setFill(Color.WHEAT);
        _nose = new Ellipse(Constants.NOSE_X, Constants.NOSE_Y);
        _nose.setFill(Color.rgb(135, 115, 89));
        _muzzle1 = new Label(")");
        _muzzle1.setRotate(80);
        _muzzle1.setTextFill(Color.rgb(135, 115, 89));
        Font font = new Font(14);
        _muzzle1.setFont(font);
        _muzzle2 = new Label(")");
        _muzzle2.setRotate(100);
        _muzzle2.setTextFill(Color.rgb(135, 115, 89));
        _muzzle2.setFont(font);
        _ear11 = new Ellipse(Constants.EAR_1_X, Constants.EAR_1_Y);
        _ear11.setFill(Color.TAN);
        _ear11.setRotate(-50);
        _ear12 = new Ellipse(Constants.EAR_1_X, Constants.EAR_1_Y);
        _ear12.setFill(Color.TAN);
        _ear12.setRotate(50);
        _thing1 = new Rectangle(Constants.THING_X, Constants.THING_Y);
        _thing1.setFill(Color.rgb(135, 115, 89));
        _thing1.setRotate(-40);
        _thing2 = new Rectangle(Constants.THING_X, Constants.THING_Y);
        _thing2.setFill(Color.rgb(135, 115, 89));
        _thing2.setRotate(40);
        _thing3 = new Rectangle(Constants.THING_X, Constants.THING_Y);
        _thing3.setFill(Color.rgb(135, 115, 89));
        _thing3.setRotate(40);
        _thing4 = new Rectangle(Constants.THING_X, Constants.THING_Y);
        _thing4.setFill(Color.rgb(135, 115, 89));
        _thing4.setRotate(-40);

        root.getChildren().addAll(_eye1, _eye2, _pupil1, _pupil2, _mouth, _nose, _muzzle1, _muzzle2, _ear11, _ear12,
                _thing1, _thing2, _thing3, _thing4);
    }

    @Override
    public Color getPetColor(){
        return Color.TAN;
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
        _nose.setCenterX(x);
        _nose.setCenterY(y-9);
        _muzzle1.relocate(x-7, y-11);
        _muzzle2.relocate(x+5, y-10);
        _ear11.setCenterX(x-35);
        _ear11.setCenterY(y-53);
        _ear12.setCenterX(x+35);
        _ear12.setCenterY(y-53);
        _thing1.setX(x-19);
        _thing1.setY(y-73);
        _thing2.setX(x+17);
        _thing2.setY(y-73);
        _thing3.setX(x-14);
        _thing3.setY(y-78);
        _thing4.setX(x+12);
        _thing4.setY(y-78);

    }
}
