package indy;

public interface Buyable {
    public int getPrice();
    public String getType();
    public void setBounceLoc(double x, double y);
    public void setOpacity(double x);
    public void removeFromPane();
    public void addToPane();
}
