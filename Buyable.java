package indy;

import javafx.animation.Timeline;
import javafx.scene.shape.Ellipse;

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
