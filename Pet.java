package indy;

import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;

public class Pet implements Buyable {
    private Ellipse _body;
    private Buyable[][] _pets;
    private String _petName;
    private String _personality;
    private String _birthMonth;
    private String _favFood;
    private Boolean isNamed;
    private Label _gardenName;
    private Timeline _timeline;

    public Pet(Pane root, Buyable[][] pets, String petName, String personality, String birthMonth, String favFood){
        _pets = pets;
        _body = new Ellipse(Constants.ANIMAL_BODY_X, Constants.ANIMAL_BODY_Y);
        _body.setFill(this.getPetColor());
        _petName = petName;
        _personality = personality;
        _birthMonth = birthMonth;
        _favFood = favFood;
        isNamed = false;
        _gardenName = new Label();
        Font font = new Font("Gill Sans", 14);
        _gardenName.setFont(font);
        _gardenName.setTextFill(Color.WHITE);
        root.getChildren().addAll(_body, _gardenName);
    }

    public String getPetName(){
        return _petName;
    }

    public void setIsNamed(){
        isNamed = true;
        _gardenName.setText(_petName);
    }

    public void setPetName(String x){
        _petName = null;
        _petName = x;
    }

    public void setTimeline(Timeline x){
        _timeline = x;
    }

    public Timeline getTimeline(){
        return _timeline;
    }

    public String getPetPersonality(){
        return _personality;
    }

    public String getPetBirthMonth(){
        return _birthMonth;
    }

    public String getPetFavFood(){
        return _favFood;
    }

    public void setLoc(double x, double y){
    }

    public void setBounceLoc(double x, double y){
        _gardenName.relocate(x+50, y-50);
    }

    public double getXLoc(){
        return _body.getCenterX();
    }

    public double getYLoc(){
        return _body.getCenterY();
    }

    public Color getPetColor(){
        return null;
    }

    public Ellipse getBody(){
        return _body;
    }

    public String getType(){
        return null;
    }

    public void setOpacity(double x){}

    public Ellipse getNode(){
        return null;
    }

    public int getPrice(){
        return 0;
    }

    public void removeFromPane(){}

    public void addToPane(){}

    public double getOYL(){
        return 0;
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
