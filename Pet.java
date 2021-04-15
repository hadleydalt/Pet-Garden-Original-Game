package indy;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Pet{
    private Ellipse _body;
    private Pet[][] _pets;
    private String _petName;
    private int _age;
    private String _birthMonth;
    private String _favFood;

    public Pet(Pane root, Pet[][] pets, String petName, int age, String birthMonth, String favFood){
        _pets = pets;
        _body = new Ellipse(Constants.ANIMAL_BODY_X, Constants.ANIMAL_BODY_Y);
        _body.setFill(this.getPetColor());
        _petName = petName;
        _age = age;
        _birthMonth = birthMonth;
        _favFood = favFood;
        root.getChildren().addAll(_body);
    }

    public String getPetName(){
        return _petName;
    }

    public int getAge(){
        return _age;
    }

    public String getBirthMonth(){
        return _birthMonth;
    }

    public String getFavFood(){
        return _favFood;
    }

    public void setLoc(double x, double y){
    }

    public void setBounceLoc(double x, double y){
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
}
