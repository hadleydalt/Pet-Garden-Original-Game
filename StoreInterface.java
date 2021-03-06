package indy;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.util.ArrayList;

// creates the StoreInterface, or all of the elements in the Store that the user can click on and interact with.

public class StoreInterface {
    private Rectangle _sortByPriceBG;
    private Rectangle _searchMyPetsBG;
    private Rectangle _enterHoursBG;
    private Rectangle _divider1;
    private Rectangle _divider2;
    private Circle _coin;
    private Circle _coinBorder;
    private Label _sortByPrice;
    private Label _searchMyPets;
    private Label _enterHours;
    private Label _currentBalance;
    private Label _dollar;
    private Rectangle _coverNode1;
    private Rectangle _coverNode2;
    private Rectangle _coverNode3;
    private Buyable[][] x;

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

    private Label _shop1;
    private Label _shop2;
    private Label _shop3;
    private Label _shop4;
    private Label _shop5;
    private Label _shop6;

    private Label balIns;

    private ArrayList<Buyable> _items;

    public StoreInterface(Pane root, Pane shopPane){
        _shopPane = shopPane;
        _sortByPriceBG = new Rectangle(Constants.INTERFACE_BUTTON_X, Constants.INTERFACE_BUTTON_Y);
        _sortByPriceBG.setFill(Color.POWDERBLUE);
        _sortByPriceBG.setOpacity(0);
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
        _sortByPrice = new Label("SORT BY PRICE");
        _sortByPrice.setFont(font2);
        _sortByPrice.setTextFill(Color.WHITE);
        _sortByPrice.setOpacity(0);
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
        _closeOut1.setCenterX(1065);
        _closeOut1.setCenterY(25);
        _closeOut1.setOpacity(0);
        _x1 = new Label("X");
        _x1.relocate(1060, 17);
        _x1.setFont(font5);
        _x1.setTextFill(Color.POWDERBLUE);
        _x1.setOpacity(0);
        _XCoverNode1 = new Circle(20);
        _XCoverNode1.setCenterX(1065);
        _XCoverNode1.setCenterY(25);
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

        _gnome = new Gnome(_shopPane, x);
        _plant = new Plant(_shopPane, x);
        _house = new House(_shopPane, x);
        _hat = new Hat(_shopPane, x);
        _sunsetBG = new SunsetBG(_shopPane);

        _balance = new Label("0");
        Font font6 = new Font("Gill Sans", 50);
        _balance.setTextFill(Color.POWDERBLUE);
        _balance.setFont(font6);
        _balance.setOpacity(0);

        Font font7 = new Font("Gill Sans", 13);

        _shop1 = new Label("Buy " + _cat.getType() + " - $" + String.valueOf(_cat.getPrice()));
        _shop1.setFont(font7);
        _shop1.setTextFill(Color.DARKGRAY);
        _shop1.relocate(730, 300);
        _shop2 = new Label("Buy " + _chicken.getType() + " - $" + String.valueOf(_chicken.getPrice()));
        _shop2.setFont(font7);
        _shop2.setTextFill(Color.DARKGRAY);
        _shop2.relocate(860, 300);
        _shop3 = new Label("Buy " + _cow.getType() + " - $" + String.valueOf(_cow.getPrice()));
        _shop3.setFont(font7);
        _shop3.setTextFill(Color.DARKGRAY);
        _shop3.relocate(990, 300);
        _shop4 = new Label("Buy " + _dog.getType() + " - $" + String.valueOf(_dog.getPrice()));
        _shop4.setFont(font7);
        _shop4.setTextFill(Color.DARKGRAY);
        _shop4.relocate(730, 472);
        _shop5 = new Label("Buy " + _fox.getType() + " - $" + String.valueOf(_fox.getPrice()));
        _shop5.setFont(font7);
        _shop5.setTextFill(Color.DARKGRAY);
        _shop5.relocate(860, 472);
        _shop6 = new Label("Buy " + _giraffe.getType() + " - $" + String.valueOf(_giraffe.getPrice()));
        _shop6.setFont(font7);
        _shop6.setTextFill(Color.DARKGRAY);
        _shop6.relocate(990, 472);
        this.setShopLabelO(0);

        balIns = new Label("Balance Insufficient!");
        Font font = new Font("Gill Sans", 26);
        balIns.setFont(font);
        balIns.setTextFill(Color.POWDERBLUE);
        balIns.relocate(800, 9);
        balIns.setOpacity(0);

        __shop = new Buyable[3][2];
        this.fillShopInitial(_cat, _chicken, _cow, _dog, _fox, _giraffe);

        root.getChildren().addAll(_sortByPriceBG, _searchMyPetsBG, _enterHoursBG, _secondBG, _second, _secondCN, _firstBG, _first,
                _firstCN, _thirdBG, _third, _thirdCN, _divider1, _divider2, _coin, _coinBorder, _sortByPrice, _searchMyPets, _enterHours, _currentBalance,
                _dollar, _coverNode1, _coverNode2, _coverNode3, _specs, _enter, _closeOut1, _x1, _XCoverNode1, _balance,
                _shop1, _shop2,_shop3, _shop4, _shop5, _shop6, balIns);

        _items = new ArrayList<Buyable>();
        this.fillArrayList();
    }

    // returns labels for items in shop.

    public Label getShop1(){
        return _shop1;
    }

    public Label getShop2(){
        return _shop2;
    }

    public Label getShop3(){
        return _shop3;
    }

    public Label getShop4(){
        return _shop4;
    }

    public Label getShop5(){
        return _shop5;
    }

    public Label getShop6(){
        return _shop6;
    }

    // sets the location of most things that are part of the Store Interface.

    public void setLoc(double x, double y){
        _sortByPriceBG.setX(x+50);
        _sortByPriceBG.setY(y+533);
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
        _sortByPrice.relocate(x+82, y+536);
        _searchMyPets.relocate(x+76, y+586);
        _enterHours.relocate(x+83, y+636);
        _currentBalance.relocate(x+285, y+640);
        _dollar.relocate(x+312.5, y+540);
        _specs.relocate(x+80, y+20);
        _enter.relocate(x+80, y+90);
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

    // Fills the shop with the initial items displayed on the first page by adding them to the Shop array, adding them graphically
    // to the Pane, and setting their location.

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

    // fills the shop according to the respective page every time a new page is clicked on by setting each item's text label
    // to its name and price, removing the current items from the pane and from the shop array and by adding the new items
    // to the Pane and setting their location.

    public void fillShop(Buyable b1, Buyable b2, Buyable b3, Buyable b4, Buyable b5, Buyable b6) {

        _shop1.setText("Buy " + b1.getType() + " - $" + String.valueOf(b1.getPrice()));
        _shop2.setText("Buy " + b2.getType() + " - $" + String.valueOf(b2.getPrice()));
        _shop3.setText("Buy " + b3.getType() + " - $" + String.valueOf(b3.getPrice()));
        _shop4.setText("Buy " + b4.getType() + " - $" + String.valueOf(b4.getPrice()));
        _shop5.setText("Buy " + b5.getType() + " - $" + String.valueOf(b5.getPrice()));
        _shop6.setText("Buy " + b6.getType() + " - $" + String.valueOf(b6.getPrice()));

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

    // returns the shop array so it can be used in other classes (e.g., Game class)

    public Buyable[][] getShop(){
      return __shop;
    }

    // allows for the opacity of items in the Shop Interface to be controlled depending on when they need to appear.

    public void setOpacity(double x){
        _sortByPriceBG.setOpacity(x);
        _searchMyPetsBG.setOpacity(x);
        _enterHoursBG.setOpacity(x);
        _divider1.setOpacity(x);
        _divider2.setOpacity(x);
        _coin.setOpacity(x);
        _coinBorder.setOpacity(x);
        _sortByPrice.setOpacity(x);
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
        this.setShopLabelO(1);
    }

    public void setCloseOpacity(int x){
        _closeOut1.setOpacity(x);
        _x1.setOpacity(x);
    }

    public void setShopLabelO(double x){
        _shop1.setOpacity(x);
        _shop2.setOpacity(x);
        _shop3.setOpacity(x);
        _shop4.setOpacity(x);
        _shop5.setOpacity(x);
        _shop6.setOpacity(x);
    }

    // returns a series of nodes and labels so they can be used as part of the EventHandlers in the Game class.

    public Label getBalIns(){
        return balIns;
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

    public Circle getXCN(){
        return _XCoverNode;
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

    public Rectangle getSortByPriceCN(){
        return _coverNode1;
    }

    public Rectangle getSearchMyPetsCN(){
        return _coverNode2;
    }

    public Rectangle getEnterHoursCN(){
        return _coverNode3;
    }

    public Rectangle getConfirmCN(){
        return _confirmCN;
    }

    public Label getBalance(){
        return _balance;
    }

    public Label getSortByPrice(){
        return _sortByPrice;
    }

    // returns instances of each Buyable so they can be used as display pictures in the shop.

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

    // fills an ArrayList of Buyables so it can be Sorted using the methods in the Sorts class.

    public void fillArrayList(){
        _items.add(_cat);
        _items.add(_chicken);
        _items.add(_cow);
        _items.add(_dog);
        _items.add(_fox);
        _items.add(_giraffe);
        _items.add(_owl);
        _items.add(_penguin);
        _items.add(_pig);
        _items.add(_reindeer);
        _items.add(_sheep);
        _items.add(_tiger);
        _items.add(_walrus);
        _items.add(_gnome);
        _items.add(_hat);
        _items.add(_house);
        _items.add(_plant);
        _items.add(_sunsetBG);
    }

    // returns this ArrayList so it can be sorted in the Game class.

    public ArrayList<Buyable> getItems(){
        return _items;
    }
}
