package indy;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Store {
    private Rectangle _storebg;
    private Rectangle _whitebg;
    private Rectangle _whitebg2;
    private Ellipse _topbg;
    private Ellipse _topbgint;
    private Rectangle _accent1;
    private Rectangle _accent2;
    private Label _shop;
    private Label _shop2;
    private Pane _specs;
    private Rectangle _petPopup;
    private Rectangle _petTitle;
    private Label _name;
    private Label _personality;
    private Label _birthMonth;
    private Label _favFood;
    private Label _whoAmI;
    private Label _myName;
    private Label _myPersonality;
    private Label _myBirthMonth;
    private Label _myFavFood;
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
    private Pet[][] x;
    private Rectangle _petFrame;
    private Label _petNamed;
    private Pane shopPane;

    public Store(Pane root){
        _storebg = new Rectangle(Constants.STORE_BG_X, Constants.STORE_BG_Y);
        _storebg.setFill(Color.POWDERBLUE);
        _whitebg = new Rectangle((Constants.STORE_BG_X-60), (Constants.STORE_BG_Y-60));
        _whitebg.setFill(Color.ALICEBLUE);
        _whitebg2 = new Rectangle((Constants.STORE_BG_X-70), (Constants.STORE_BG_Y-70));
        _whitebg2.setFill(Color.ALICEBLUE);
        _whitebg2.setStroke(Color.POWDERBLUE);
        _topbg = new Ellipse(Constants.TOPBG_X, Constants.TOPBG_Y);
        _topbg.setFill(Color.WHITE);
        _topbg.setStroke(Color.POWDERBLUE);
        _topbgint = new Ellipse(Constants.TOPBG_X-6, Constants.TOPBG_Y-5);
        _topbgint.setFill(Color.TRANSPARENT);
        _topbgint.setStroke(Color.rgb(215, 246, 250));
        Stop[] stops = new Stop[] { new Stop(0, Color.ALICEBLUE), new Stop(1, Color.POWDERBLUE)};
        LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
        Stop[] stops1 = new Stop[] { new Stop(0, Color.POWDERBLUE), new Stop(1, Color.ALICEBLUE)};
        LinearGradient lg2 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops1);
        _accent1 = new Rectangle(Constants.ACCENT_X, Constants.ACCENT_Y);
        _accent1.setFill(lg1);
        _accent2 = new Rectangle(Constants.ACCENT_X, Constants.ACCENT_Y);
        _accent2.setFill(lg2);
        _shop = new Label("S H O P");
        _shop.setTextFill(Color.POWDERBLUE);
        Font font = new Font("Gill Sans", 40);
        _shop.setFont(font);
        _shop2 = new Label("S H O P");
        _shop2.setTextFill(Color.rgb(215, 246, 250));
        _shop2.setFont(font);

        shopPane = new Pane();

        _specs = new Pane();
        _petPopup = new Rectangle(Constants.PET_POPUP_X, Constants.PET_POPUP_Y-33);
        _petPopup.setFill(Color.WHITE);
        _petPopup.setStroke(Color.POWDERBLUE);
        _petTitle = new Rectangle(Constants.PET_TITLE_X, Constants.PET_TITLE_Y);
        _petTitle.setFill(Color.POWDERBLUE);
        _petTitle.setX(10);
        _petTitle.setY(10);
        Font font2 = new Font("Gill Sans", 16);
        Font font3 = new Font("Gill Sans", 28);
        _name = new Label("NAME");
        _name.setFont(font2);
        _name.setTextFill(Color.POWDERBLUE);
        _name.relocate(200, 60);
        _personality = new Label("PERSONALITY");
        _personality.setFont(font2);
        _personality.setTextFill(Color.POWDERBLUE);
        _personality.relocate(200, 105);
        _birthMonth = new Label("BIRTH MONTH");
        _birthMonth.setFont(font2);
        _birthMonth.setTextFill(Color.POWDERBLUE);
        _birthMonth.relocate(200, 150);
        _favFood = new Label("FAVORITE FOOD");
        _favFood.setFont(font2);
        _favFood.setTextFill(Color.POWDERBLUE);
        _favFood.relocate(200, 195);
        _whoAmI = new Label("WHO AM I?");
        _whoAmI.setFont(font3);
        _whoAmI.setTextFill(Color.WHITE);
        _whoAmI.relocate(105, 14);
        _petFrame = new Rectangle(Constants.PET_FRAME_X, Constants.PET_FRAME_Y);
        _petFrame.setFill(Color.rgb(223, 243, 245));

        _myName = new Label("Unnamed");
        _myName.setFont(font2);
        _myName.setTextFill(Color.rgb(163, 163, 163));
        _myName.relocate(200, 80);
        _myPersonality = new Label("Personality");
        _myPersonality.setFont(font2);
        _myPersonality.setTextFill(Color.rgb(163, 163, 163));
        _myPersonality.relocate(200, 125);
        _myBirthMonth = new Label("Birth month");
        _myBirthMonth.setFont(font2);
        _myBirthMonth.setTextFill(Color.rgb(163, 163, 163));
        _myBirthMonth.relocate(200, 170);
        _myFavFood = new Label("Favorite food");
        _myFavFood.setFont(font2);
        _myFavFood.setTextFill(Color.rgb(163, 163, 163));
        _myFavFood.relocate(200, 215);
        _petNamed = new Label("PET NAMED!");
        Font font4 = new Font("Gill Sans", 12);
        _petNamed.setFont(font4);
        _petNamed.relocate(290, 85);
        _petNamed.setTextFill(Color.POWDERBLUE);
        _petNamed.setOpacity(0);

        _specs.getChildren().addAll(_petPopup, _petTitle, _name, _personality, _birthMonth, _favFood, _whoAmI, _myName, _myPersonality,
                _myBirthMonth, _myFavFood, _petFrame, _petNamed);

        _specs.setOpacity(0);
        _cat = new Cat(_specs, x, "x", "x", "x", "x");
        _cat.setOpacity(0);
        _chicken = new Chicken(_specs, x, "x", "x", "x", "x");
        _chicken.setOpacity(0);
        _cow = new Cow(_specs, x, "x", "x", "x", "x");
        _cow.setOpacity(0);
        _dog = new Dog(_specs, x, "x", "x", "x", "x");
        _dog.setOpacity(0);
        _fox = new Fox(_specs, x, "x", "x", "x", "x");
        _fox.setOpacity(0);
        _giraffe = new Giraffe(_specs, x, "x", "x", "x", "x");
        _giraffe.setOpacity(0);
        _owl = new Owl(_specs, x, "x", "x", "x", "x");
        _owl.setOpacity(0);
        _penguin = new Penguin(_specs, x, "x", "x", "x", "x");
        _penguin.setOpacity(0);
        _pig = new Pig(_specs, x, "x", "x", "x", "x");
        _pig.setOpacity(0);
        _reindeer = new Reindeer(_specs, x, "x", "x", "x", "x");
        _reindeer.setOpacity(0);
        _sheep = new Sheep(_specs, x, "x", "x", "x", "x");
        _sheep.setOpacity(0);
        _tiger = new Tiger(_specs, x, "x", "x", "x", "x");
        _tiger.setOpacity(0);
        _walrus = new Walrus(_specs, x, "x", "x", "x", "x");
        _walrus.setOpacity(0);

        root.getChildren().addAll(_storebg, _whitebg, _whitebg2, _topbg, _topbgint, _accent1, _accent2, _shop, _shop2,
                shopPane, _specs);
    }

    /*public void fillShop(Pet pet1, Pet pet2, Pet pet3, Pet pet4, Pet pet5, Pet pet6) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                __shop[i][j] = new Walrus(shopPane, x, "x", "x", "x", "x");
                __shop[i][j].setBounceLoc(((i * 130) + 730), ((j * 190) + 240));
                __shop[i][j].setOpacity(0);
            }
        }
    } */

    public void setLoc(double x, double y){
        _storebg.setX(x);
        _storebg.setY(y);
        _whitebg.setX(x+30);
        _whitebg.setY(y+30);
        _whitebg2.setX(x+35);
        _whitebg2.setY(y+35);
        _topbg.setCenterX(x+267);
        _topbg.setCenterY(y+50);
        _topbgint.setCenterX(x+267);
        _topbgint.setCenterY(y+50);
        _accent1.setX(x+47);
        _accent1.setY(y+45);
        _accent2.setX(x+397);
        _accent2.setY(y+45);
        _shop.relocate(x+201, y+27);
        _shop2.relocate(x+203.5, y+25.5);
        _specs.relocate(x+80, y-30);
        _petFrame.setX(10);
        _petFrame.setY(60);

        _cat.setBounceLoc(95, 153);
        _chicken.setBounceLoc(95, 153);
        _cow.setBounceLoc(95, 153);
        _dog.setBounceLoc(95, 153);
        _fox.setBounceLoc(95, 153);
        _giraffe.setBounceLoc(95, 153);
        _owl.setBounceLoc(95, 153);
        _penguin.setBounceLoc(95, 153);
        _pig.setBounceLoc(95, 153);
        _reindeer.setBounceLoc(95, 153);
        _sheep.setBounceLoc(95, 153);
        _tiger.setBounceLoc(95, 153);
        _walrus.setBounceLoc(95, 153);

    }

    public Label getMyName(){
        return _myName;
    }

    public Pane getSpecsPane(){
        return _specs;
    }

    public Label getMyPersonality(){
        return _myPersonality;
    }

    public Label getMyBirthMonth(){
        return _myBirthMonth;
    }

    public Label getMyFavFood(){
        return _myFavFood;
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

    public Label getPetNamed(){
        return _petNamed;
    }

    public Pane getShopPane(){
        return shopPane;
    }
}
