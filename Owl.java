package indy;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Owl extends Pet{
    private Ellipse _eye1;
    private Ellipse _eye2;
    private Ellipse _pupil1;
    private Ellipse _pupil2;
    private Ellipse _wing1;
    private Ellipse _wing2;
    private Rectangle _beak;
    private Ellipse _bigeye1;
    private Ellipse _bigeye2;
    private Ellipse _ear11;
    private Ellipse _ear12;
    private Label _fluff1;
    private Label _fluff2;
    private Label _fluff3;
    private Label _fluff4;
    private Label _fluff5;
    private Label _fluff6;
    private Label _fluff7;
    private Pet[][] _pets;
    private Ellipse _coverNode;
    private Pane _root;
    private double _originalYLoc;

    public Owl(Pane root, Pet[][] pets, String petName, String personality, String birthMonth, String favFood){
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
        _wing1 = new Ellipse(Constants.WING_X, Constants.WING_Y);
        _wing1.setFill(Color.rgb(148, 95, 43));
        _wing1.setRotate(-13);
        _wing2 = new Ellipse(Constants.WING_X, Constants.WING_Y);
        _wing2.setFill(Color.rgb(148, 95, 43));
        _wing2.setRotate(13);
        _beak = new Rectangle(Constants.OWL_BEAK, Constants.OWL_BEAK);
        _beak.setRotate(45);
        _beak.setFill(Color.PINK);
        _bigeye1 = new Ellipse(Constants.BIG_EYE_RAD, Constants.BIG_EYE_RAD);
        _bigeye2 = new Ellipse(Constants.BIG_EYE_RAD, Constants.BIG_EYE_RAD);
        _bigeye1.setFill(Color.WHITE);
        _bigeye2.setFill(Color.WHITE);
        _ear11 = new Ellipse(Constants.OWL_EAR_1_X, Constants.OWL_EAR_1_Y);
        _ear11.setFill(Color.PERU);
        _ear11.setRotate(-50);
        _ear12 = new Ellipse(Constants.OWL_EAR_1_X, Constants.OWL_EAR_1_Y);
        _ear12.setFill(Color.PERU);
        _ear12.setRotate(50);
        _fluff1 = new Label(")");
        _fluff1.setRotate(90);
        _fluff1.setTextFill(Color.WHEAT);
        Font font = new Font(14);
        _fluff1.setFont(font);
        _fluff2 = new Label(")");
        _fluff2.setRotate(90);
        _fluff2.setTextFill(Color.WHEAT);
        _fluff2.setFont(font);
        _fluff3 = new Label(")");
        _fluff3.setRotate(90);
        _fluff3.setTextFill(Color.WHEAT);
        _fluff3.setFont(font);
        _fluff4 = new Label(")");
        _fluff4.setRotate(90);
        _fluff4.setTextFill(Color.WHEAT);
        _fluff4.setFont(font);
        _fluff5 = new Label(")");
        _fluff5.setRotate(90);
        _fluff5.setTextFill(Color.WHEAT);
        _fluff5.setFont(font);
        _fluff6 = new Label(")");
        _fluff6.setRotate(90);
        _fluff6.setTextFill(Color.WHEAT);
        _fluff6.setFont(font);
        _fluff7 = new Label(")");
        _fluff7.setRotate(90);
        _fluff7.setTextFill(Color.WHEAT);
        _fluff7.setFont(font);
        _coverNode = new Ellipse(Constants.ANIMAL_BODY_X, Constants.ANIMAL_BODY_Y);
        _coverNode.setFill(Color.TRANSPARENT);

        root.getChildren().addAll(_bigeye1, _bigeye2, _eye1, _eye2, _pupil1, _pupil2, _wing1, _wing2, _beak, _ear11, _ear12,
                _fluff1, _fluff2, _fluff3, _fluff4, _fluff5, _fluff6, _fluff7, _coverNode);
    }

    @Override
    public void removeFromPane(){
        _root.getChildren().removeAll(this.getBody(), _bigeye1, _bigeye2, _eye1, _eye2, _pupil1, _pupil2, _wing1, _wing2, _beak, _ear11, _ear12,
                _fluff1, _fluff2, _fluff3, _fluff4, _fluff5, _fluff6, _fluff7, _coverNode);
    }

    @Override
    public void addToPane(){
        _root.getChildren().addAll(this.getBody(), _bigeye1, _bigeye2, _eye1, _eye2, _pupil1, _pupil2, _wing1, _wing2, _beak, _ear11, _ear12,
                _fluff1, _fluff2, _fluff3, _fluff4, _fluff5, _fluff6, _fluff7, _coverNode);
    }

    @Override
    public Ellipse getNode(){
        return _coverNode;
    }

    @Override
    public void setOpacity(double x){
        this.getBody().setOpacity(x);
        _bigeye1.setOpacity(x);
        _bigeye2.setOpacity(x);
        _eye1.setOpacity(x);
        _eye2.setOpacity(x);
        _pupil1.setOpacity(x);
        _pupil2.setOpacity(x);
        _wing1.setOpacity(x);
        _wing2.setOpacity(x);
        _beak.setOpacity(x);
        _ear11.setOpacity(x);
        _ear12.setOpacity(x);
        _fluff1.setOpacity(x);
        _fluff2.setOpacity(x);
        _fluff3.setOpacity(x);
        _fluff4.setOpacity(x);
        _fluff5.setOpacity(x);
        _fluff6.setOpacity(x);
        _fluff7.setOpacity(x);
    }

    @Override
    public Color getPetColor(){
        return Color.PERU;
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
            _wing1.setCenterX(x-38);
            _wing1.setCenterY(y+5);
            _wing2.setCenterX(x+38);
            _wing2.setCenterY(y+5);
            _beak.setX(x-8);
            _beak.setY(y-14);
            _bigeye1.setCenterX(x-15);
            _bigeye1.setCenterY(y-20);
            _bigeye2.setCenterX(x+15);
            _bigeye2.setCenterY(y-20);
            _ear11.setCenterX(x-35);
            _ear11.setCenterY(y-60);
            _ear12.setCenterX(x+35);
            _ear12.setCenterY(y-60);
            _fluff1.relocate(x-8, y+7);
            _fluff2.relocate(x+8, y+8);
            _fluff3.relocate(x-18, y+20);
            _fluff4.relocate(x-2, y+20);
            _fluff5.relocate(x+14, y+20);
            _fluff6.relocate(x-8, y+32);
            _fluff7.relocate(x+8, y+32);
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
        _wing1.setCenterX(x-38);
        _wing1.setCenterY(y+5);
        _wing2.setCenterX(x+38);
        _wing2.setCenterY(y+5);
        _beak.setX(x-8);
        _beak.setY(y-14);
        _bigeye1.setCenterX(x-15);
        _bigeye1.setCenterY(y-20);
        _bigeye2.setCenterX(x+15);
        _bigeye2.setCenterY(y-20);
        _ear11.setCenterX(x-35);
        _ear11.setCenterY(y-60);
        _ear12.setCenterX(x+35);
        _ear12.setCenterY(y-60);
        _fluff1.relocate(x-8, y+7);
        _fluff2.relocate(x+8, y+8);
        _fluff3.relocate(x-18, y+20);
        _fluff4.relocate(x-2, y+20);
        _fluff5.relocate(x+14, y+20);
        _fluff6.relocate(x-8, y+32);
        _fluff7.relocate(x+8, y+32);
        _coverNode.setCenterX(x);
        _coverNode.setCenterY(y);
    }

    @Override
    public String getType(){
        return "Owl";
    }

    @Override
    public int getPrice() {
        return 30;
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
