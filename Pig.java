package indy;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class Pig extends Pet{
    private Ellipse _eye1;
    private Ellipse _eye2;
    private Ellipse _pupil1;
    private Ellipse _pupil2;
    private Ellipse _mouth;
    private Ellipse _nostril1;
    private Ellipse _nostril2;
    private Rectangle _ear1;
    private Rectangle _ear2;
    private Pet[][] _pets;
    private Ellipse _coverNode;
    private Pane _root;
    private double _originalYLoc;

    public Pig(Pane root, Pet[][] pets, String petName, String personality, String birthMonth, String favFood){
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
        _mouth.setFill(Color.rgb(255, 156, 173));
        _nostril1 = new Ellipse(Constants.NOSTRIL_X, Constants.NOSTRIL_Y);
        _nostril2 = new Ellipse(Constants.NOSTRIL_X, Constants.NOSTRIL_Y);
        _ear1 = new Rectangle(Constants.EAR_LENGTH, Constants.EAR_LENGTH);
        _ear1.setFill(Color.PINK);
        _ear1.setRotate(15);
        _ear2 = new Rectangle(Constants.EAR_LENGTH, Constants.EAR_LENGTH);
        _ear2.setFill(Color.PINK);
        _ear2.setRotate(77);
        _coverNode = new Ellipse(Constants.ANIMAL_BODY_X, Constants.ANIMAL_BODY_Y);
        _coverNode.setFill(Color.TRANSPARENT);


        root.getChildren().addAll(_eye1, _eye2, _pupil1, _pupil2, _mouth, _nostril1, _nostril2, _ear1, _ear2, _coverNode);
    }

    @Override
    public void removeFromPane(){
        _root.getChildren().removeAll(this.getBody(), _eye1, _eye2, _pupil1, _pupil2, _mouth, _nostril1, _nostril2, _ear1, _ear2, _coverNode);
    }

    @Override
    public void addToPane(){
        _root.getChildren().addAll(this.getBody(), _eye1, _eye2, _pupil1, _pupil2, _mouth, _nostril1, _nostril2, _ear1, _ear2, _coverNode);
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
        _ear1.setOpacity(x);
        _ear2.setOpacity(x);
    }

    @Override
    public Color getPetColor(){
        return Color.PINK;
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
            _nostril1.setCenterX(x-7);
            _nostril1.setCenterY(y-6);
            _nostril2.setCenterX(x+7);
            _nostril2.setCenterY(y-6);
            _ear1.setX(x-40);
            _ear1.setY(y-63);
            _ear2.setX(x+20);
            _ear2.setY(y-60);
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
        _mouth.setCenterX(x);
        _mouth.setCenterY(y-4);
        _nostril1.setCenterX(x-7);
        _nostril1.setCenterY(y-6);
        _nostril2.setCenterX(x+7);
        _nostril2.setCenterY(y-6);
        _ear1.setX(x-40);
        _ear1.setY(y-63);
        _ear2.setX(x+20);
        _ear2.setY(y-60);
        _coverNode.setCenterX(x);
        _coverNode.setCenterY(y);
    }

    @Override
    public String getType(){
        return "Pig";
    }

    @Override
    public int getPrice() {
        return 70;
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
