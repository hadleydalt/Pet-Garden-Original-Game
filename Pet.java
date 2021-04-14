package indy;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Pet {
    private Ellipse _body;
    private Pet[][] _pets;
    public Pet(Pane root, Pet[][] pets){
        _pets = pets;
        _body = new Ellipse(Constants.ANIMAL_BODY_X, Constants.ANIMAL_BODY_Y);
        _body.setFill(this.getPetColor());
        root.getChildren().addAll(_body);
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
