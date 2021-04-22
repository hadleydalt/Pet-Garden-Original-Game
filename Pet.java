package indy;

import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;

// a superclass for all Pets.

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
    private Pane _root;

    public Pet(Pane root, Buyable[][] pets, String petName, String personality, String birthMonth, String favFood){
        _pets = pets;
        _root = root;
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

    // gets the pet's name so that it can be changed.

    public String getPetName(){
        return _petName;
    }

    // if the pet is named, the pet's name label in the garden is set to its name variable.

    public void setIsNamed(){
        isNamed = true;
        _gardenName.setText(_petName);
    }

    // sets the Pet's current name to null and replaces it with the new name passed in.

    public void setPetName(String x){
        _petName = null;
        _petName = x;
    }

    // sets and gets the Pet's Animation (bouncing) Timeline so that each pet has its own Timeline which can be controlled individually
    // (i.e., by the Version Changer button)

    public void setTimeline(Timeline x){
        _timeline = x;
    }

    public Timeline getTimeline(){
        return _timeline;
    }

    // returns the pet's Info variables so they can be changed.

    public String getPetPersonality(){
        return _personality;
    }

    public String getPetBirthMonth(){
        return _birthMonth;
    }

    public String getPetFavFood(){
        return _favFood;
    }

    // sets the location of all the pet's Nodes while first checking if the location on the garden array that corresponds to this
    // pet location is null. The method uses recursion to do this.

    public void setLoc(double x, double y){
    }

    // sets the location of all the pet's Nodes WITHOUT first checking if the location on the garden array that corresponds to this
    // pet location is null.

    public void setBounceLoc(double x, double y){
        _gardenName.relocate(x+50, y-50);
    }

    // gets the pet's locations so they can be changed.

    public double getXLoc(){
        return _body.getCenterX();
    }

    public double getYLoc(){
        return _body.getCenterY();
    }

    // the getPetColor needs to be implemented by every pet type but NOT the Pet superclass. Rather, this method is implemented by every
    // pet type to TELL the Pet superclass what color the pet is.

    public Color getPetColor(){
        return null;
    }

    // the pet's body needs to be gotten by every Pet subclass to include in its design, but it is a common factor that is shared by all pets.

    public Ellipse getBody(){
        return _body;
    }

    // getType returns the type of pet in String version, which has many uses throughout the game. For the Pet superclass, it returns null.

    public String getType(){
        return null;
    }

    // enables control of the pet's opacity.

    public void setOpacity(double x){}

    // each Pet subclass contains a transparent "Cover Node" which covers it to ease with Mouse Events. For the superclass, it returns null.

    public Ellipse getNode(){
        return null;
    }

    // gets the price of every pet. In the superclass it returns 0.

    public int getPrice(){
        return 0;
    }

    // enables the pet to be removed from the pane when setting up the Shop. If the user clicks on a new page of the shop, all of the
    // pets currently displayed are removed from the Pane.

    public void removeFromPane(){}

    // enables the pet to be added from the pane when setting up the Shop. If the user clicks on a new page of the shop, all of the
    // pets currently displayed are removed from the Pane and the new page's pets are added.

    public void addToPane(){}

    // gets the original location of every pet when it is instantiated to be used for animation purposes. The superclass returns 0.

    public double getOYL(){
        return 0;
    }

    // allows for the Pet's locations to be semi-randomly generated. This method is known by the Game class but also needs to be known
    // by the Pet class.

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

    // adds the hat to a certain location in its array spot so that it seems like it's sitting on the pet's head.

    public void addHat(double x, double y){
        Hat hat = new Hat(_root, _pets);
        hat.setBounceLoc(x-12, y-80);
        hat.addToPane();
    }

}
