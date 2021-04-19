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
    private Pet[][] x;

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
    private Buyable[][] __shop;
    private Pane _shopPane;
    private Rectangle _secondBG;
    private Label _second;
    private Rectangle _secondCN;
    private Rectangle _firstBG;
    private Label _first;
    private Rectangle _firstCN;
    private Rectangle _thirdBG;
    private Label _third;
    private Rectangle _thirdCN;

    private Cat _cat;
    private Chicken _chicken;
    private Cow _cow;
    private Dog _dog;
    private Fox _fox;
    private Giraffe _giraffe;
    private Owl _owl;
    private Penguin _penguin;
    private Pig _pig;
    private Reindeer _reindeer;
    private Sheep _sheep;
    private Tiger _tiger;
    private Walrus _walrus;

    private Gnome _gnome;
    private Plant _plant;
    private Hat _hat;
    private House _house;
    private SunsetBG _sunsetBG;

    private Pane _enter;
    private Rectangle _petPopup1;
    private Rectangle _petTitle1;
    private Label _whoAmI1;
    private Rectangle _hourLine;
    private Label _typeHours;
    private Circle _closeOut2;
    private Label _x2;
    private Circle _XCoverNode2;

    private Rectangle _enterBG;
    private Label _confirm;
    private Rectangle _confirmCN;

    private Label _balance;

    public StoreInterface(Pane root, Pane shopPane){
        _shopPane = shopPane;
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
        _petPopup = new Rectangle(Constants.PET_POPUP_X, Constants.PET_POPUP_Y-160);
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

        _secondBG = new Rectangle(Constants.INTERFACE_BUTTON_X-120, Constants.INTERFACE_BUTTON_Y);
        _secondBG.setFill(Color.POWDERBLUE);
        _secondBG.setOpacity(0);
        _second = new Label("PAGE 2");
        _second.setFont(font2);
        _second.setTextFill(Color.WHITE);
        _second.setOpacity(0);
        _secondCN = new Rectangle(Constants.INTERFACE_BUTTON_X-120, Constants.INTERFACE_BUTTON_Y);
        _secondCN.setFill(Color.TRANSPARENT);

        _firstBG = new Rectangle(Constants.INTERFACE_BUTTON_X-120, Constants.INTERFACE_BUTTON_Y);
        _firstBG.setFill(Color.POWDERBLUE);
        _firstBG.setOpacity(0);
        _first = new Label("PAGE 1");
        _first.setFont(font2);
        _first.setTextFill(Color.WHITE);
        _first.setOpacity(0);
        _firstCN = new Rectangle(Constants.INTERFACE_BUTTON_X-120, Constants.INTERFACE_BUTTON_Y);
        _firstCN.setFill(Color.TRANSPARENT);

        _thirdBG = new Rectangle(Constants.INTERFACE_BUTTON_X-120, Constants.INTERFACE_BUTTON_Y);
        _thirdBG.setFill(Color.POWDERBLUE);
        _thirdBG.setOpacity(0);
        _third = new Label("PAGE 3");
        _third.setFont(font2);
        _third.setTextFill(Color.WHITE);
        _third.setOpacity(0);
        _thirdCN = new Rectangle(Constants.INTERFACE_BUTTON_X-120, Constants.INTERFACE_BUTTON_Y);
        _thirdCN.setFill(Color.TRANSPARENT);

        _specs.getChildren().addAll(_petPopup, _petTitle, _whoAmI, _searchLine, _typeToSearch, _closeOut, _x, _XCoverNode);
        _specs.setOpacity(0);

        _enter = new Pane();
        _petPopup1 = new Rectangle(Constants.PET_POPUP_X, Constants.PET_POPUP_Y-130);
        _petPopup1.setFill(Color.WHITE);
        _petPopup1.setStroke(Color.POWDERBLUE);
        _petTitle1 = new Rectangle(Constants.PET_TITLE_X, Constants.PET_TITLE_Y);
        _petTitle1.setFill(Color.POWDERBLUE);
        _petTitle1.setX(10);
        _petTitle1.setY(10);
        _whoAmI1 = new Label("ENTER HOURS");
        _whoAmI1.setFont(font4);
        _whoAmI1.setTextFill(Color.WHITE);
        _whoAmI1.relocate(85, 14);
        _hourLine = new Rectangle(Constants.PET_TITLE_X, 1);
        _hourLine.setX(10);
        _hourLine.setY(100);
        _hourLine.setFill(Color.POWDERBLUE);
        _typeHours = new Label();
        _typeHours.setTextFill(Color.LIGHTGRAY);
        _typeHours.relocate(10, 70);
        _typeHours.setFont(font5);
        _closeOut2 = new Circle(20);
        _closeOut2.setFill(Color.WHITE);
        _closeOut2.setStroke(Color.POWDERBLUE);
        _closeOut2.setCenterX(365);
        _closeOut2.setCenterY(5);
        _x2 = new Label("X");
        _x2.relocate(360, -3);
        _x2.setFont(font5);
        _x2.setTextFill(Color.POWDERBLUE);
        _XCoverNode2 = new Circle(20);
        _XCoverNode2.setCenterX(365);
        _XCoverNode2.setCenterY(5);
        _XCoverNode2.setFill(Color.TRANSPARENT);

        _enterBG = new Rectangle(Constants.INTERFACE_BUTTON_X-120, Constants.INTERFACE_BUTTON_Y);
        _enterBG.setFill(Color.POWDERBLUE);
        _confirm = new Label("ENTER");
        _confirm.setFont(font2);
        _confirm.setTextFill(Color.WHITE);
        _confirmCN = new Rectangle(Constants.INTERFACE_BUTTON_X-120, Constants.INTERFACE_BUTTON_Y);
        _confirmCN.setFill(Color.TRANSPARENT);
        _enterBG.setX(280);
        _enterBG.setY(110);
        _confirm.relocate(290.5, 113);
        _confirmCN.setX(280);
        _confirmCN.setY(110);

        _enter.getChildren().addAll(_petPopup1, _petTitle1, _whoAmI1, _hourLine, _typeHours, _closeOut2, _x2, _XCoverNode2,
                _enterBG, _confirm, _confirmCN);
        _enter.setOpacity(0);

        _cat = new Cat(_shopPane, x, "x", "x", "x", "x");
        _cat.removeFromPane();
        _chicken = new Chicken(_shopPane, x, "x", "x", "x", "x");
        _chicken.removeFromPane();
        _cow = new Cow(_shopPane, x, "x", "x", "x", "x");
        _cow.removeFromPane();
        _dog = new Dog(_shopPane, x, "x", "x", "x", "x");
        _dog.removeFromPane();
        _fox = new Fox(_shopPane, x, "x", "x", "x", "x");
        _fox.removeFromPane();
        _giraffe = new Giraffe(_shopPane, x, "x", "x", "x", "x");
        _giraffe.removeFromPane();
        _owl = new Owl(_shopPane, x, "x", "x", "x", "x");
        _owl.removeFromPane();
        _penguin = new Penguin(_shopPane, x, "x", "x", "x", "x");
        _penguin.removeFromPane();
        _pig = new Pig(_shopPane, x, "x", "x", "x", "x");
        _pig.removeFromPane();
        _reindeer = new Reindeer(_shopPane, x, "x", "x", "x", "x");
        _reindeer.removeFromPane();
        _sheep = new Sheep(_shopPane, x, "x", "x", "x", "x");
        _sheep.removeFromPane();
        _tiger = new Tiger(_shopPane, x, "x", "x", "x", "x");
        _tiger.removeFromPane();
        _walrus = new Walrus(_shopPane, x, "x", "x", "x", "x");
        _walrus.removeFromPane();

        _gnome = new Gnome(_shopPane);
        _plant = new Plant(_shopPane);
        _house = new House(_shopPane);
        _hat = new Hat(_shopPane);
        _sunsetBG = new SunsetBG(_shopPane);

        _balance = new Label("0");
        Font font6 = new Font("Gill Sans", 50);
        _balance.setTextFill(Color.POWDERBLUE);
        _balance.setFont(font6);
        _balance.setOpacity(0);

        __shop = new Buyable[3][2];
        this.fillShopInitial(_cat, _chicken, _cow, _dog, _fox, _giraffe);

        root.getChildren().addAll(_viewAllPetsBG, _searchMyPetsBG, _enterHoursBG, _secondBG, _second, _secondCN, _firstBG, _first,
                _firstCN, _thirdBG, _third, _thirdCN, _divider1, _divider2, _coin, _coinBorder, _viewAllPets, _searchMyPets, _enterHours, _currentBalance,
                _dollar, _coverNode1, _coverNode2, _coverNode3, _specs, _enter, _closeOut1, _x1, _XCoverNode1, _balance);
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
        _enter.relocate(x+100, y+185);
        _secondBG.setX(x+230);
        _secondBG.setY(y+470);
        _secondCN.setX(x+230);
        _secondCN.setY(y+470);
        _second.relocate(x+237, y+474);

        _firstBG.setX(x+120);
        _firstBG.setY(y+470);
        _firstCN.setX(x+120);
        _firstCN.setY(y+470);
        _first.relocate(x+127, y+474);

        _thirdBG.setX(x+340);
        _thirdBG.setY(y+470);
        _thirdCN.setX(x+340);
        _thirdCN.setY(y+470);
        _third.relocate(x+347, y+474);

        _balance.relocate(1010, 600);

    }

    public void fillShopInitial(Pet pet1, Pet pet2, Pet pet3, Pet pet4, Pet pet5, Pet pet6) {
        __shop[0][0] = pet1;
        __shop[1][0] = pet2;
        __shop[2][0] = pet3;
        __shop[0][1] = pet4;
        __shop[1][1] = pet5;
        __shop[2][1] = pet6;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                __shop[i][j].addToPane();
                __shop[i][j].setBounceLoc(((i * 130) + 760), ((j * 160) + 240));
                __shop[i][j].setOpacity(0);
            }
        }
    }

    public void fillShop(Buyable b1, Buyable b2, Buyable b3, Buyable b4, Buyable b5, Buyable b6) {

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 2; j++){
                if (__shop[i][j] != null) {
                    __shop[i][j].removeFromPane();
                    __shop[i][j] = null;
                }
            }
        }
        __shop[0][0] = b1;
        __shop[1][0] = b2;
        __shop[2][0] = b3;
        __shop[0][1] = b4;
        __shop[1][1] = b5;
        __shop[2][1] = b6;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                __shop[i][j].setBounceLoc(((i * 130) + 760), ((j * 160) + 240));
                __shop[i][j].removeFromPane();
                __shop[i][j].addToPane();
            }
        }
    }

    public Buyable[][] getShop(){
      return __shop;
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
        _firstBG.setOpacity(x);
        _first.setOpacity(x);
        _secondBG.setOpacity(x);
        _second.setOpacity(x);
        _thirdBG.setOpacity(x);
        _third.setOpacity(x);
        _balance.setOpacity(x);
    }

    public Rectangle getSecondCN(){
        return _secondCN;
    }

    public Rectangle getFirstCN(){
        return _firstCN;
    }

    public Rectangle getThirdCN(){
        return _thirdCN;
    }

    public void setCloseOpacity(int x){
        _closeOut1.setOpacity(x);
        _x1.setOpacity(x);
        _XCoverNode1.setOpacity(x);
    }

    public Circle getXCN1(){
        return _XCoverNode1;
    }

    public Circle getXCN2() {
        return _XCoverNode2;
    }

    public void setSearchOpacity(double x){
        _specs.setOpacity(x);
    }

    public void setEnterOpacity(double x){
        _enter.setOpacity(x);
    }

    public Label getTypeToSearch(){
        return _typeToSearch;
    }

    public Label getTypeHours(){
        return _typeHours;
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

    public Cat getCat(){
        return _cat;
    }

    public Chicken getChicken(){
        return _chicken;
    }

    public Cow getCow(){
        return _cow;
    }

    public Dog getDog(){
        return _dog;
    }

    public Fox getFox(){
        return _fox;
    }

    public Giraffe getGiraffe(){
        return _giraffe;
    }

    public Owl getOwl(){
        return _owl;
    }

    public Penguin getPenguin(){
        return _penguin;
    }

    public Pig getPig(){
        return _pig;
    }

    public Reindeer getReindeer(){
        return _reindeer;
    }

    public Sheep getSheep(){
        return _sheep;
    }

    public Tiger getTiger(){
        return _tiger;
    }

    public Walrus getWalrus(){
        return _walrus;
    }

    public Gnome getGnome(){
        return _gnome;
    }

    public Plant getPlant(){
        return _plant;
    }

    public House getHouse(){
        return _house;
    }

    public Hat getHat(){
        return _hat;
    }

    public SunsetBG getSunsetBG(){
        return _sunsetBG;
    }

    public Rectangle getConfirmCN(){
        return _confirmCN;
    }

    public Label getBalance(){
        return _balance;
    }
}
