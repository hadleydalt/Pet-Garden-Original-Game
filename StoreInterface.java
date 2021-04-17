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
    private Rectangle _coverNode1;
    private Rectangle _coverNode2;
    private Rectangle _coverNode3;

    private Pane _specs;
    private Rectangle _petPopup;
    private Rectangle _petTitle;
    private Label _whoAmI;
    private Rectangle _searchLine;
    private Label _typeToSearch;
    private Circle _closeOut;
    private Label _x;
    private Circle _XCoverNode;

    private Circle _closeOut1;
    private Label _x1;
    private Circle _XCoverNode1;


    public StoreInterface(Pane root){
        _viewAllPetsBG = new Rectangle(Constants.INTERFACE_BUTTON_X, Constants.INTERFACE_BUTTON_Y);
        _viewAllPetsBG.setFill(Color.POWDERBLUE);
        _viewAllPetsBG.setOpacity(0);
        _coverNode1 = new Rectangle(Constants.INTERFACE_BUTTON_X, Constants.INTERFACE_BUTTON_Y);
        _coverNode1.setFill(Color.TRANSPARENT);
        _searchMyPetsBG = new Rectangle(Constants.INTERFACE_BUTTON_X, Constants.INTERFACE_BUTTON_Y);
        _searchMyPetsBG.setFill(Color.POWDERBLUE);
        _searchMyPetsBG.setOpacity(0);
        _coverNode2 = new Rectangle(Constants.INTERFACE_BUTTON_X, Constants.INTERFACE_BUTTON_Y);
        _coverNode2.setFill(Color.TRANSPARENT);
        _enterHoursBG = new Rectangle(Constants.INTERFACE_BUTTON_X, Constants.INTERFACE_BUTTON_Y);
        _enterHoursBG.setFill(Color.POWDERBLUE);
        _enterHoursBG.setOpacity(0);
        _coverNode3 = new Rectangle(Constants.INTERFACE_BUTTON_X, Constants.INTERFACE_BUTTON_Y);
        _coverNode3.setFill(Color.TRANSPARENT);
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

        _specs = new Pane();
        _petPopup = new Rectangle(Constants.PET_POPUP_X, Constants.PET_POPUP_Y);
        _petPopup.setFill(Color.WHITE);
        _petPopup.setStroke(Color.POWDERBLUE);
        _petTitle = new Rectangle(Constants.PET_TITLE_X, Constants.PET_TITLE_Y);
        _petTitle.setFill(Color.POWDERBLUE);
        _petTitle.setX(10);
        _petTitle.setY(10);
        _whoAmI = new Label("SEARCH MY PETS");
        Font font4 = new Font("Gill Sans", 28);
        _whoAmI.setFont(font4);
        _whoAmI.setTextFill(Color.WHITE);
        _whoAmI.relocate(85, 14);
        _searchLine = new Rectangle(Constants.PET_TITLE_X, 1);
        _searchLine.setX(10);
        _searchLine.setY(100);
        _searchLine.setFill(Color.POWDERBLUE);
        _typeToSearch = new Label();
        _typeToSearch.setTextFill(Color.LIGHTGRAY);
        Font font5 = new Font("Gill Sans", 16);
        _typeToSearch.relocate(10, 70);
        _typeToSearch.setFont(font5);
        _closeOut = new Circle(20);
        _closeOut.setFill(Color.WHITE);
        _closeOut.setStroke(Color.POWDERBLUE);
        _closeOut.setCenterX(365);
        _closeOut.setCenterY(5);
        _x = new Label("X");
        _x.relocate(360, -3);
        _x.setFont(font5);
        _x.setTextFill(Color.POWDERBLUE);
        _XCoverNode = new Circle(20);
        _XCoverNode.setCenterX(365);
        _XCoverNode.setCenterY(5);
        _XCoverNode.setFill(Color.TRANSPARENT);

        _closeOut1 = new Circle(20);
        _closeOut1.setFill(Color.WHITE);
        _closeOut1.setStroke(Color.POWDERBLUE);
        _closeOut1.setCenterX(1085);
        _closeOut1.setCenterY(205);
        _closeOut1.setOpacity(0);
        _x1 = new Label("X");
        _x1.relocate(1080, 197);
        _x1.setFont(font5);
        _x1.setTextFill(Color.POWDERBLUE);
        _x1.setOpacity(0);
        _XCoverNode1 = new Circle(20);
        _XCoverNode1.setCenterX(1085);
        _XCoverNode1.setCenterY(205);
        _XCoverNode1.setFill(Color.TRANSPARENT);

        _specs.getChildren().addAll(_petPopup, _petTitle, _whoAmI, _searchLine, _typeToSearch, _closeOut, _x, _XCoverNode);
        _specs.setOpacity(0);

        root.getChildren().addAll(_viewAllPetsBG, _searchMyPetsBG, _enterHoursBG, _divider1, _divider2, _coin, _coinBorder,
                _viewAllPets, _searchMyPets, _enterHours, _currentBalance, _dollar, _coverNode1, _coverNode2, _coverNode3,
                _specs, _closeOut1, _x1, _XCoverNode1);
    }

    public void setLoc(double x, double y){
        _viewAllPetsBG.setX(x+50);
        _viewAllPetsBG.setY(y+533);
        _searchMyPetsBG.setX(x+50);
        _searchMyPetsBG.setY(y+583);
        _enterHoursBG.setX(x+50);
        _enterHoursBG.setY(y+633);
        _coverNode1.setX(x+50);
        _coverNode1.setY(y+533);
        _coverNode2.setX(x+50);
        _coverNode2.setY(y+583);
        _coverNode3.setX(x+50);
        _coverNode3.setY(y+633);
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
        _specs.relocate(x+100, y+150);
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

    public void setCloseOpacity(int x){
        _closeOut1.setOpacity(x);
        _x1.setOpacity(x);
        _XCoverNode1.setOpacity(x);
    }

    public Circle getXCN1(){
        return _XCoverNode1;
    }

    public void setSearchOpacity(double x){
        _specs.setOpacity(x);
    }

    public Label getTypeToSearch(){
        return _typeToSearch;
    }

    public Circle getXCN(){
        return _XCoverNode;
    }

    public Rectangle getViewAllPetsCN(){
        return _coverNode1;
    }

    public Rectangle getSearchMyPetsCN(){
        return _coverNode2;
    }

    public Rectangle getEnterHoursCN(){
        return _coverNode3;
    }
}
