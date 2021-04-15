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
    private Label _age;
    private Label _birthMonth;
    private Label _favFood;
    private Label _whoAmI;
    private Label _myName;
    private Label _myAge;
    private Label _myBirthMonth;
    private Label _myFavFood;

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
        _specs = new Pane();
        _petPopup = new Rectangle(Constants.PET_POPUP_X, Constants.PET_POPUP_Y);
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
        _age = new Label("AGE");
        _age.setFont(font2);
        _age.setTextFill(Color.POWDERBLUE);
        _age.relocate(200, 105);
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

        _myName = new Label("Name");
        _myName.setFont(font2);
        _myName.setTextFill(Color.rgb(163, 163, 163));
        _myName.relocate(200, 80);
        _myAge = new Label("Age");
        _myAge.setFont(font2);
        _myAge.setTextFill(Color.rgb(163, 163, 163));
        _myAge.relocate(200, 125);
        _myBirthMonth = new Label("Birth month");
        _myBirthMonth.setFont(font2);
        _myBirthMonth.setTextFill(Color.rgb(163, 163, 163));
        _myBirthMonth.relocate(200, 170);
        _myFavFood = new Label("Favorite food");
        _myFavFood.setFont(font2);
        _myFavFood.setTextFill(Color.rgb(163, 163, 163));
        _myFavFood.relocate(200, 215);
        _specs.getChildren().addAll(_petPopup, _petTitle, _name, _age, _birthMonth, _favFood, _whoAmI, _myName, _myAge,
                _myBirthMonth, _myFavFood);

        root.getChildren().addAll(_storebg, _whitebg, _whitebg2, _topbg, _topbgint, _accent1, _accent2, _shop, _shop2,
                _specs);
    }

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
        _specs.relocate(x+100, y+150);
    }

    public Label getMyName(){
        return _myName;
    }
}
