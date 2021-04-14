package indy;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Cat extends Pet{
    private Ellipse _eye1;
    private Ellipse _eye2;
    private Ellipse _mouth;
    private Ellipse _pupil1;
    private Ellipse _pupil2;
    private Ellipse _nose;
    private Rectangle _ear1;
    private Rectangle _ear2;
    private Rectangle _leftSideStripe1;
    private Rectangle _leftSideStripe2;
    private Rectangle _rightSideStripe1;
    private Rectangle _rightSideStripe2;
    private Ellipse _tail;
    private Label _muzzle1;
    private Label _muzzle2;
    private Ellipse _stomach;
    private Pet[][] _pets;

    public Cat(Pane root, Pet[][] pets){
        super(root, pets);
        _pets = pets;
        _eye1 = new Ellipse(Constants.EYE_RAD, Constants.EYE_RAD);
        _eye2 = new Ellipse(Constants.EYE_RAD, Constants.EYE_RAD);
        _eye1.setFill(Color.BLACK);
        _eye2.setFill(Color.BLACK);
        _mouth = new Ellipse(Constants.MOUTH_X, Constants.MOUTH_Y);
        _mouth.setFill(Color.rgb(240, 240, 240));
        _pupil1 = new Ellipse(Constants.PUPIL_RAD, Constants.PUPIL_RAD);
        _pupil2 = new Ellipse(Constants.PUPIL_RAD, Constants.PUPIL_RAD);
        _pupil1.setFill(Color.WHITE);
        _pupil2.setFill(Color.WHITE);
        _nose = new Ellipse(Constants.NOSE_X, Constants.NOSE_Y);
        _nose.setFill(Color.PINK);
        _ear1 = new Rectangle(Constants.EAR_LENGTH, Constants.EAR_LENGTH);
        _ear1.setFill(Color.LIGHTGRAY);
        _ear1.setRotate(15);
        _ear2 = new Rectangle(Constants.EAR_LENGTH, Constants.EAR_LENGTH);
        _ear2.setFill(Color.LIGHTGRAY);
        _ear2.setRotate(77);
        _leftSideStripe1 = new Rectangle(Constants.STRIPE_Y, Constants.STRIPE_X);
        _leftSideStripe1.setFill(Color.GRAY);
        _leftSideStripe2 = new Rectangle(Constants.STRIPE_Y, Constants.STRIPE_X);
        _leftSideStripe2.setFill(Color.GRAY);
        _rightSideStripe1 = new Rectangle(Constants.STRIPE_Y, Constants.STRIPE_X);
        _rightSideStripe1.setFill(Color.GRAY);
        _rightSideStripe2 = new Rectangle(Constants.STRIPE_Y, Constants.STRIPE_X);
        _rightSideStripe2.setFill(Color.GRAY);
        _tail = new Ellipse(Constants.TAIL_X, Constants.TAIL_Y);
        _tail.setFill(Color.LIGHTGRAY);
        _tail.setRotate(75);
        _muzzle1 = new Label(")");
        _muzzle1.setRotate(80);
        _muzzle1.setTextFill(Color.GRAY);
        Font font = new Font(14);
        _muzzle1.setFont(font);
        _muzzle2 = new Label(")");
        _muzzle2.setRotate(100);
        _muzzle2.setTextFill(Color.GRAY);
        _muzzle2.setFont(font);
        _stomach = new Ellipse(Constants.REINDEER_STOMACH_X, Constants.REINDEER_STOMACH_Y);
        _stomach.setFill(Color.rgb(240, 240, 240));

        root.getChildren().addAll(_eye1, _eye2, _mouth, _pupil1, _pupil2, _nose, _ear1, _ear2,
                 _leftSideStripe1, _leftSideStripe2, _rightSideStripe1,
                _rightSideStripe2, _tail, _muzzle1, _muzzle2, _stomach);
    }

    @Override
    public Color getPetColor(){
        return Color.LIGHTGRAY;
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
            _mouth.setCenterX(x);
            _mouth.setCenterY(y-4);
            _pupil1.setCenterX(x-13);
            _pupil1.setCenterY(y-21);
            _pupil2.setCenterX(x+17);
            _pupil2.setCenterY(y-21);
            _nose.setCenterX(x);
            _nose.setCenterY(y-7);
            _ear1.setX(x-40);
            _ear1.setY(y-63);
            _ear2.setX(x+20);
            _ear2.setY(y-60);
            _leftSideStripe1.setX(x-59); //241
            _leftSideStripe1.setY(y-13); //287
            _leftSideStripe2.setX(x-60); //240
            _leftSideStripe2.setY(y-3); //297
            _rightSideStripe1.setX(x+44); //344
            _rightSideStripe1.setY(y-13); //287
            _rightSideStripe2.setX(x+45); //345
            _rightSideStripe2.setY(y-3); //297
            _tail.setCenterX(x+47); //375
            _tail.setCenterY(y+48); //331
            _muzzle1.relocate(x-7, y-9);
            _muzzle2.relocate(x+5, y-8);
            _stomach.setCenterX(x);
            _stomach.setCenterY(y+35);
        }
            else{
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
        _mouth.setCenterX(x);
        _mouth.setCenterY(y-4);
        _pupil1.setCenterX(x-13);
        _pupil1.setCenterY(y-21);
        _pupil2.setCenterX(x+17);
        _pupil2.setCenterY(y-21);
        _nose.setCenterX(x);
        _nose.setCenterY(y-7);
        _ear1.setX(x-40);
        _ear1.setY(y-63);
        _ear2.setX(x+20);
        _ear2.setY(y-60);
        _leftSideStripe1.setX(x-59); //241
        _leftSideStripe1.setY(y-13); //287
        _leftSideStripe2.setX(x-60); //240
        _leftSideStripe2.setY(y-3); //297
        _rightSideStripe1.setX(x+44); //344
        _rightSideStripe1.setY(y-13); //287
        _rightSideStripe2.setX(x+45); //345
        _rightSideStripe2.setY(y-3); //297
        _tail.setCenterX(x+47); //375
        _tail.setCenterY(y+48); //331
        _muzzle1.relocate(x-7, y-9);
        _muzzle2.relocate(x+5, y-8);
        _stomach.setCenterX(x);
        _stomach.setCenterY(y+35);
    }

    @Override
    public String getType(){
        return "cat";
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
