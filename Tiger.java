package indy;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Tiger extends Pet{
    private Ellipse _eye1;
    private Ellipse _eye2;
    private Ellipse _pupil1;
    private Ellipse _pupil2;
    private Rectangle _leftSideStripe1;
    private Rectangle _leftSideStripe2;
    private Rectangle _rightSideStripe1;
    private Rectangle _rightSideStripe2;
    private Rectangle _leftSideStripe3;
    private Rectangle _rightSideStripe3;
    private Rectangle _topStripe1;
    private Rectangle _topStripe2;
    private Rectangle _topStripe3;
    private Ellipse _mouth;
    private Ellipse _nose;
    private Label _muzzle1;
    private Label _muzzle2;
    private Ellipse _ear11;
    private Ellipse _ear12;
    private Ellipse _tail;
    private Ellipse _stomach;
    private Pet[][] _pets;
    private Ellipse _coverNode;
    private Pane _root;

    public Tiger(Pane root, Pet[][] pets, String petName, String personality, String birthMonth, String favFood){
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
        _leftSideStripe1 = new Rectangle(Constants.STRIPE_Y, Constants.STRIPE_X);
        _leftSideStripe2 = new Rectangle(Constants.STRIPE_Y, Constants.STRIPE_X);
        _rightSideStripe1 = new Rectangle(Constants.STRIPE_Y, Constants.STRIPE_X);
        _rightSideStripe2 = new Rectangle(Constants.STRIPE_Y, Constants.STRIPE_X);
        _leftSideStripe3 = new Rectangle(Constants.STRIPE_Y, Constants.STRIPE_X);
        _rightSideStripe3 = new Rectangle(Constants.STRIPE_Y, Constants.STRIPE_X);
        _topStripe1 = new Rectangle(Constants.STRIPE_X, Constants.STRIPE_Y);
        _topStripe2 = new Rectangle(Constants.STRIPE_X, Constants.STRIPE_Y);
        _topStripe3 = new Rectangle(Constants.STRIPE_X, Constants.STRIPE_Y);
        _mouth = new Ellipse(Constants.MOUTH_X, Constants.MOUTH_Y);
        _mouth.setFill(Color.rgb(255, 203, 107));
        _nose = new Ellipse(Constants.NOSE_X, Constants.NOSE_Y);
        _muzzle1 = new Label(")");
        _muzzle1.setRotate(80);
        Font font = new Font(14);
        _muzzle1.setFont(font);
        _muzzle2 = new Label(")");
        _muzzle2.setRotate(100);
        _muzzle2.setFont(font);
        _ear11 = new Ellipse(Constants.EAR_2_X, Constants.EAR_2_Y);
        _ear11.setFill(Color.ORANGE);
        _ear11.setRotate(-50);
        _ear12 = new Ellipse(Constants.EAR_2_X, Constants.EAR_2_Y);
        _ear12.setFill(Color.ORANGE);
        _ear12.setRotate(50);
        _tail = new Ellipse(Constants.TAIL_X, Constants.TAIL_Y);
        _tail.setFill(Color.ORANGE);
        _tail.setRotate(75);
        _stomach = new Ellipse(Constants.REINDEER_STOMACH_X, Constants.REINDEER_STOMACH_Y);
        _stomach.setFill(Color.rgb(255, 203, 107));
        _coverNode = new Ellipse(Constants.ANIMAL_BODY_X, Constants.ANIMAL_BODY_Y);
        _coverNode.setFill(Color.TRANSPARENT);

        root.getChildren().addAll(_eye1, _eye2, _pupil1, _pupil2, _leftSideStripe1, _leftSideStripe2, _rightSideStripe1, _rightSideStripe2,
                _leftSideStripe3, _rightSideStripe3, _topStripe1, _topStripe2, _topStripe3, _mouth, _nose, _muzzle1, _muzzle2,
                _ear11, _ear12, _tail, _stomach, _coverNode);
    }

    @Override
    public void removeFromPane(){
        _root.getChildren().removeAll(this.getBody(), _eye1, _eye2, _pupil1, _pupil2, _leftSideStripe1, _leftSideStripe2, _rightSideStripe1, _rightSideStripe2,
                _leftSideStripe3, _rightSideStripe3, _topStripe1, _topStripe2, _topStripe3, _mouth, _nose, _muzzle1, _muzzle2,
                _ear11, _ear12, _tail, _stomach, _coverNode);
    }

    @Override
    public void addToPane(){
        _root.getChildren().addAll(this.getBody(), _eye1, _eye2, _pupil1, _pupil2, _leftSideStripe1, _leftSideStripe2, _rightSideStripe1, _rightSideStripe2,
                _leftSideStripe3, _rightSideStripe3, _topStripe1, _topStripe2, _topStripe3, _mouth, _nose, _muzzle1, _muzzle2,
                _ear11, _ear12, _tail, _stomach, _coverNode);
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
        _leftSideStripe1.setOpacity(x);
        _leftSideStripe2.setOpacity(x);
        _rightSideStripe1.setOpacity(x);
        _rightSideStripe2.setOpacity(x);
        _leftSideStripe3.setOpacity(x);
        _rightSideStripe3.setOpacity(x);
        _topStripe1.setOpacity(x);
        _topStripe2.setOpacity(x);
        _topStripe3.setOpacity(x);
        _mouth.setOpacity(x);
        _nose.setOpacity(x);
        _muzzle1.setOpacity(x);
        _muzzle2.setOpacity(x);
        _ear11.setOpacity(x);
        _ear12.setOpacity(x);
        _tail.setOpacity(x);
        _stomach.setOpacity(x);
    }

    @Override
    public Color getPetColor(){
        return Color.ORANGE;
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
            _leftSideStripe1.setX(x-59);
            _leftSideStripe1.setY(y-13);
            _leftSideStripe2.setX(x-60);
            _leftSideStripe2.setY(y-3);
            _rightSideStripe1.setX(x+44);
            _rightSideStripe1.setY(y-13);
            _rightSideStripe2.setX(x+45);
            _rightSideStripe2.setY(y-3);

            _leftSideStripe3.setX(x-59); //241
            _leftSideStripe3.setY(y+7); //287
            _rightSideStripe3.setX(x+44); //344
            _rightSideStripe3.setY(y+7); //287

            _topStripe1.setX(x-10);
            _topStripe1.setY(y-58);
            _topStripe2.setX(x);
            _topStripe2.setY(y-60);
            _topStripe3.setX(x+10);
            _topStripe3.setY(y-58);

            _mouth.setCenterX(x);
            _mouth.setCenterY(y-4);
            _nose.setCenterX(x);
            _nose.setCenterY(y-7);

            _muzzle1.relocate(x-7, y-9);
            _muzzle2.relocate(x+5, y-8);

            _ear11.setCenterX(x-35);
            _ear11.setCenterY(y-43);
            _ear12.setCenterX(x+35);
            _ear12.setCenterY(y-43);

            _tail.setCenterX(x+47);
            _tail.setCenterY(y+48);

            _stomach.setCenterX(x);
            _stomach.setCenterY(y+35);

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
        _leftSideStripe1.setX(x-59);
        _leftSideStripe1.setY(y-13);
        _leftSideStripe2.setX(x-60);
        _leftSideStripe2.setY(y-3);
        _rightSideStripe1.setX(x+44);
        _rightSideStripe1.setY(y-13);
        _rightSideStripe2.setX(x+45);
        _rightSideStripe2.setY(y-3);

        _leftSideStripe3.setX(x-59); //241
        _leftSideStripe3.setY(y+7); //287
        _rightSideStripe3.setX(x+44); //344
        _rightSideStripe3.setY(y+7); //287

        _topStripe1.setX(x-10);
        _topStripe1.setY(y-58);
        _topStripe2.setX(x);
        _topStripe2.setY(y-60);
        _topStripe3.setX(x+10);
        _topStripe3.setY(y-58);

        _mouth.setCenterX(x);
        _mouth.setCenterY(y-4);
        _nose.setCenterX(x);
        _nose.setCenterY(y-7);

        _muzzle1.relocate(x-7, y-9);
        _muzzle2.relocate(x+5, y-8);

        _ear11.setCenterX(x-35);
        _ear11.setCenterY(y-43);
        _ear12.setCenterX(x+35);
        _ear12.setCenterY(y-43);

        _tail.setCenterX(x+47);
        _tail.setCenterY(y+48);

        _stomach.setCenterX(x);
        _stomach.setCenterY(y+35);

        _coverNode.setCenterX(x);
        _coverNode.setCenterY(y);
    }

    @Override
    public String getType(){
        return "Tiger";
    }

    @Override
    public int getPrice() {
        return 150;
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
