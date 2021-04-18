package indy;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;

public class Pet implements Buyable {
    private Ellipse _body;
    private Pet[][] _pets;
    private String _petName;
    private String _personality;
    private String _birthMonth;
    private String _favFood;
    private Boolean isNamed;
    private Label _gardenName;

    public Pet(Pane root, Pet[][] pets, String petName, String personality, String birthMonth, String favFood){
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

    @Override
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

    @Override
    public void setOpacity(double x){}

    public Ellipse getNode(){
        return null;
    }

    @Override
    public void getPrice(){}

    @Override
    public void removeFromPane(){}

    @Override
    public void addToPane(){}
}
