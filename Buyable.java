package indy;

import javafx.animation.Timeline;
import javafx.scene.shape.Ellipse;

// The Buyable interface is implemented by the Pet superclass and by all of the 5 other Buyable classes (Gnome, Hat, House, Plant, and Sunset).
// Any methods that are part of the Pet class also must be included in Buyable, even if they do not extend to the other Buyable classes.
// These methods are explained in the classes where they are defined.

public interface Buyable {
    public int getPrice();
    public String getType();
    public void setLoc(double x, double y);
    public void setBounceLoc(double x, double y);
    public void setOpacity(double x);
    public void removeFromPane();
    public void addToPane();
    public Timeline getTimeline();
    public double getXLoc();
    public double getYLoc();
    public double getOYL();
    public String getPetName();
    public String getPetBirthMonth();
    public String getPetPersonality();
    public String getPetFavFood();
    public Ellipse getNode();
    public void addHat(double x, double y);
}
