package indy;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class StoreInterface {
    private Rectangle _viewAllPetsBG;
    private Rectangle _searchMyPetsBG;
    private Rectangle _enterHoursBG;
    private Rectangle _divider1;
    private Rectangle _divider2;
    private Circle _coin;
    private Circle _coinBorder;
    private Label _viewAllPets;
    private Label _searchMyPets;
    private Label _enterHours;
    private Label _currentBalance;
    private Label _dollar;


    public StoreInterface(Pane root){
        _viewAllPetsBG = new Rectangle(Constants.INTERFACE_BUTTON_X, Constants.INTERFACE_BUTTON_Y);
        _viewAllPetsBG.setFill(Color.POWDERBLUE);
        _viewAllPetsBG.setOpacity(0);
        _searchMyPetsBG = new Rectangle(Constants.INTERFACE_BUTTON_X, Constants.INTERFACE_BUTTON_Y);
        _searchMyPetsBG.setFill(Color.POWDERBLUE);
        _searchMyPetsBG.setOpacity(0);
        _enterHoursBG = new Rectangle(Constants.INTERFACE_BUTTON_X, Constants.INTERFACE_BUTTON_Y);
        _enterHoursBG.setFill(Color.POWDERBLUE);
        _enterHoursBG.setOpacity(0);
        _divider1 = new Rectangle(Constants.DIVIDER_1_X, Constants.DIVIDER_1_Y);
        _divider1.setFill(Color.POWDERBLUE);
        _divider1.setOpacity(0);
        _divider2 = new Rectangle(Constants.DIVIDER_2_X, Constants.DIVIDER_2_Y);
        _divider2.setFill(Color.POWDERBLUE);
        _divider2.setOpacity(0);
        _coin = new Circle(Constants.COIN_RAD);
        _coin.setFill(Color.GOLD);
        _coin.setOpacity(0);
        _coinBorder = new Circle(Constants.COIN_BORDER_RAD);
        _coinBorder.setFill(Color.TRANSPARENT);
        _coinBorder.setStroke(Color.POWDERBLUE);
        _coinBorder.setOpacity(0);
        Font font2 = new Font("Gill Sans", 20);
        _viewAllPets = new Label("VIEW ALL PETS");
        _viewAllPets.setFont(font2);
        _viewAllPets.setTextFill(Color.WHITE);
        _viewAllPets.setOpacity(0);
        _searchMyPets = new Label("SEARCH MY PETS");
        _searchMyPets.setFont(font2);
        _searchMyPets.setTextFill(Color.WHITE);
        _searchMyPets.setOpacity(0);
        _enterHours = new Label("ENTER HOURS");
        _enterHours.setFont(font2);
        _enterHours.setTextFill(Color.WHITE);
        _enterHours.setOpacity(0);
        _currentBalance = new Label("CURRENT BALANCE");
        _currentBalance.setFont(font2);
        _currentBalance.setTextFill(Color.POWDERBLUE);
        _currentBalance.setOpacity(0);
        Font font3 = new Font("Gill Sans", 67);
        _dollar = new Label("$");
        _dollar.setFont(font3);
        _dollar.setTextFill(Color.rgb(219, 186, 0));
        _dollar.setOpacity(0);

        root.getChildren().addAll(_viewAllPetsBG, _searchMyPetsBG, _enterHoursBG, _divider1, _divider2, _coin, _coinBorder,
                _viewAllPets, _searchMyPets, _enterHours, _currentBalance, _dollar);
    }

    public void setLoc(double x, double y){
        _viewAllPetsBG.setX(x+50);
        _viewAllPetsBG.setY(y+533);
        _searchMyPetsBG.setX(x+50);
        _searchMyPetsBG.setY(y+583);
        _enterHoursBG.setX(x+50);
        _enterHoursBG.setY(y+633);
        _divider1.setX(x+50);
        _divider1.setY(y+510);
        _divider2.setX(x+270);
        _divider2.setY(y+530);
        _coin.setCenterX(x+330);
        _coin.setCenterY(y+580);
        _coinBorder.setCenterX(x+330);
        _coinBorder.setCenterY(y+580);
        _viewAllPets.relocate(x+82, y+536);
        _searchMyPets.relocate(x+76, y+586);
        _enterHours.relocate(x+83, y+636);
        _currentBalance.relocate(x+285, y+640);
        _dollar.relocate(x+312.5, y+540);
    }

    public void setOpacity(double x){
        _viewAllPetsBG.setOpacity(x);
        _searchMyPetsBG.setOpacity(x);
        _enterHoursBG.setOpacity(x);
        _divider1.setOpacity(x);
        _divider2.setOpacity(x);
        _coin.setOpacity(x);
        _coinBorder.setOpacity(x);
        _viewAllPets.setOpacity(x);
        _searchMyPets.setOpacity(x);
        _enterHours.setOpacity(x);
        _currentBalance.setOpacity(x);
        _dollar.setOpacity(x);
    }
}
