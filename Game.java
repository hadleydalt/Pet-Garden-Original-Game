package indy;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.LinkedList;

public class Game {
    private Pane gardenPane;
    private Pane buttonPane;
    private Garden _garden;
    private Pane storePane;
    private Store _store;
    private Pane titleAndPetPane;
    private Title _title;
    private boolean _titleNotCompressed;
    private int _intPercent;
    private int _counter;
    private int _titleXLoc;
    private int _titleYLoc;
    private int _titlePaneXLoc;
    private Pet[][] _pets;
    private Pet[] _pet;
    private double _pet1XLoc;
    private double _pet2XLoc;
    private double _pet3XLoc;
    private double _pet4XLoc;
    private double _pet1YLoc;
    private double _pet2YLoc;
    private double _pet3YLoc;
    private double _pet4YLoc;
    private Button _verChanger;
    private Timeline _timeline;
    private LinkedList<Pet> _myPets;

    public Game(){
        this.setupGame();
        this.setupInitialPets();
    }

    public Pane getGardenPane(){
        return gardenPane;
    }

    public Pane getStorePane(){
        return storePane;
    }

    public Pane getTitleAndPetPane(){
        return titleAndPetPane;
    }

    public Pane getButtonPane() {return buttonPane;}

    public void setupGame(){
        gardenPane = new Pane();
        storePane = new Pane();
        titleAndPetPane = new Pane();
        _garden = new Garden(gardenPane);
        _garden.setLoc(30, 200);
        _store = new Store(storePane);
        _store.setLoc(620, 50);
        _title = new Title(titleAndPetPane);
        _title.setLoc(0, 0);
        _titleNotCompressed = true;
        titleAndPetPane.addEventHandler(KeyEvent.KEY_PRESSED, new TitleMoverOnKey());
        // if that doesn't work, just make the pets part of titlePane
        // use addEventHandlers for each pet separately? can do _pet[i].getBody().addEventHandler?
        // would be good for later when it needs to happen for all pets in array
        titleAndPetPane.setFocusTraversable(true);
        this.setupLoadingBarTimeline();
        _intPercent = _title.getPercent();
        _counter = 0;
        _titleXLoc = 318;
        _titleYLoc = 270;
        _titlePaneXLoc = 0;
        this.setupCounter();
        buttonPane = new Pane();
        buttonPane.relocate(30, 15);
        _verChanger = new Button("Static Version");
        _verChanger.setOnAction(new VersionChanger());
        _verChanger.setOpacity(0);
        buttonPane.getChildren().add(_verChanger);
        _myPets = new LinkedList<Pet>();
    }

    private class VersionChanger implements EventHandler<ActionEvent> {
        boolean isAnimated = true;
        public void handle(ActionEvent event) {
            if (isAnimated) {
                _timeline.stop();
                _pet[0].setBounceLoc(_pet1XLoc, _pet1YLoc);
                _pet[1].setBounceLoc(_pet2XLoc, _pet2YLoc);
                _pet[2].setBounceLoc(_pet3XLoc, _pet3YLoc);
                _pet[3].setBounceLoc(_pet4XLoc, _pet4YLoc);
                _verChanger.setText("Animated Version");
                isAnimated = false;
            }
            else {
                _timeline.play();
                _verChanger.setText("Static Version");
                isAnimated = true;
            }
        }
    }

    public Pet generatePet(){
        Pet pet = null;
        int rand_int = (int) (Math.random() * 13);
        switch (rand_int) {
            case 0:
                pet = new Cat(titleAndPetPane, _pets, "Unnamed", this.getAge(), this.getBirthMonth(), this.getFavFood());
                break;
            case 1:
                pet = new Chicken(titleAndPetPane, _pets, "Unnamed", this.getAge(), this.getBirthMonth(), this.getFavFood());
                break;
            case 2:
                pet = new Cow(titleAndPetPane, _pets, "Unnamed", this.getAge(), this.getBirthMonth(), this.getFavFood());
                break;
            case 3:
                pet = new Dog(titleAndPetPane, _pets, "Unnamed", this.getAge(), this.getBirthMonth(), this.getFavFood());
                break;
            case 4:
                pet = new Fox(titleAndPetPane, _pets, "Unnamed", this.getAge(), this.getBirthMonth(), this.getFavFood());
                break;
            case 5:
                pet = new Giraffe(titleAndPetPane, _pets, "Unnamed", this.getAge(), this.getBirthMonth(), this.getFavFood());
                break;
            case 6:
                pet = new Owl(titleAndPetPane, _pets, "Unnamed", this.getAge(), this.getBirthMonth(), this.getFavFood());
                break;
            case 7:
                pet = new Penguin(titleAndPetPane, _pets, "Unnamed", this.getAge(), this.getBirthMonth(), this.getFavFood());
                break;
            case 8:
                pet = new Pig(titleAndPetPane, _pets, "Unnamed", this.getAge(), this.getBirthMonth(), this.getFavFood());
                break;
            case 9:
                pet = new Reindeer(titleAndPetPane, _pets, "Unnamed", this.getAge(), this.getBirthMonth(), this.getFavFood());
                break;
            case 10:
                pet = new Sheep(titleAndPetPane, _pets, "Unnamed", this.getAge(), this.getBirthMonth(), this.getFavFood());
                break;
            case 11:
                pet = new Tiger(titleAndPetPane, _pets, "Unnamed", this.getAge(), this.getBirthMonth(), this.getFavFood());
                break;
            default:
                pet = new Walrus(titleAndPetPane, _pets, "Unnamed", this.getAge(), this.getBirthMonth(), this.getFavFood());
                break;
        }
        return pet;
    }

    public void getOriginalLocs(){
        _pet1XLoc = _pet[0].getXLoc();
        _pet2XLoc = _pet[1].getXLoc();
        _pet3XLoc = _pet[2].getXLoc();
        _pet4XLoc = _pet[3].getXLoc();
        _pet1YLoc = _pet[0].getYLoc();
        _pet2YLoc = _pet[1].getYLoc();
        _pet3YLoc = _pet[2].getYLoc();
        _pet4YLoc = _pet[3].getYLoc();
    }

    public void setupInitialPets(){
        _pets = new Pet[4][4];
        _pet = new Pet[4];
        for (int i = 0; i < 4; i++){
            _pet[i] = this.generatePet();
            _pet[i].setOpacity(0);
            _pet[i].setLoc(this.petXLoc(), this.petYLoc());
            _myPets.add(i, _pet[i]);
            _pets[(int) ((_pet[i].getXLoc()-110)/130)][(int) ((_pet[i].getYLoc()-290)/130)] = _pet[i];
            for (int j = 0; j < 4; j++){
                if (_pets[i][j] != null) {
                    _pets[i][j].getBody().addEventHandler(MouseEvent.MOUSE_ENTERED, new SpecsGetter());
                }
            }
        }
        this.getOriginalLocs();
        this.setupPetMover();
    }

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

    public void setupLoadingBarTimeline() {
        KeyFrame kf = new KeyFrame(Duration.millis(90), new LoadingBarFiller());
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(25);
        timeline.play();
    }

    public void setupCounter() {
        KeyFrame kf2 = new KeyFrame(Duration.millis(1), new Counter());
        Timeline timeline = new Timeline(kf2);
        timeline.setCycleCount(2500);
        timeline.play();
    }

    public void setupPetMover(){
        KeyFrame kf3 = new KeyFrame(Duration.millis(45), new PetMover());
        Timeline timeline = new Timeline(kf3);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        _timeline = timeline;
    }

    private class Counter implements EventHandler<ActionEvent>{
        public void handle(ActionEvent event){
            _counter ++;
            if (_counter == 2500){
                _title.getLoadingBar().setOpacity(0);
                _title.getLoadingBG().setOpacity(0);
                _title.getPercentLabel().setOpacity(0);
                _title.getPressSpace().setOpacity(1);
            }
        }
    }

    private class PetMover implements EventHandler<ActionEvent>{
        boolean _direction = true;

        public void handle(ActionEvent event){
            for (int i = 0; i < 4; i++){
                    if (_direction) {
                        _pet[i].setBounceLoc(_pet[i].getXLoc(), _pet[i].getYLoc() + 2);
                    } else {
                        _pet[i].setBounceLoc(_pet[i].getXLoc(), _pet[i].getYLoc() - 2);
                    }
            }
            if ((_pet[0].getYLoc() < (_pet1YLoc - 2)) && (_pet[1].getYLoc() < (_pet2YLoc - 4)) && (_pet[2].getYLoc() < (_pet3YLoc - 6))
            && (_pet[3].getYLoc() < (_pet4YLoc - 8))){
                _direction = !_direction;
            }

            if ((_pet[0].getYLoc() > (_pet1YLoc + 2)) && (_pet[1].getYLoc() > (_pet2YLoc + 3)) && (_pet[2].getYLoc() > (_pet3YLoc + 4))
                    && (_pet[3].getYLoc() > (_pet4YLoc + 5))){
                _direction = !_direction;
            }
        }
    }

    // MOVING TITLE PANE
    /*private class TitleMover implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            _title.getBG().setWidth(_title.getBG().getWidth() +11);
            _title.setBGXLoc(_title.getBGXLoc()-11);
            _title.getTitle().setRotate(_title.getTitle().getRotate()+9);
            titlePane.setPrefWidth(titlePane.getPrefWidth()-120);
            _titlePaneXLoc+=120;
            titlePane.relocate(_titlePaneXLoc+120, 0);
            _titleXLoc -=70;
            _titleYLoc += 3;
            _title.setTitleLoc(_titleXLoc - 70, _titleYLoc + 3);
        }
    } */

    private class TitleMover implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            _title.getBG().setWidth(_title.getBG().getWidth() - 120);
            _title.setBGXLoc(_title.getBGXLoc() + 120);
            _title.getTitle().setRotate(_title.getTitle().getRotate()+9);
            _titleXLoc +=49.5;
            _titleYLoc +=3;
            _title.setTitleLoc(_titleXLoc + 49.5, _titleYLoc + 3);
        }
    }

    private class LoadingBarFiller implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            _title.getLoadingBar().setWidth(_title.getLoadingBar().getWidth()+12);
            _intPercent +=4;
            _title.getPercentLabel().setText(_intPercent + "%");
        }
    }

    private class SpecsGetter implements EventHandler<MouseEvent> {
        public void handle(MouseEvent event) {
            _store.getMyName().setText("Hi");
        }
    }

    private class SpecsDisappear implements EventHandler<MouseEvent> {
        public void handle(MouseEvent event) {
            _store.getMyName().setText("Hi");
        }
    }

    private class TitleMoverOnKey implements EventHandler<KeyEvent> {
        public void setupTitleBGTimeline() {
            KeyFrame kf1 = new KeyFrame(Duration.millis(25), new TitleMover());
            Timeline timeline = new Timeline(kf1);
            timeline.setCycleCount(10);
            timeline.play();
        }

        public void handle (KeyEvent event){
            if ((_titleNotCompressed) && (_counter == 2500)) {
                if (event.getCode() == KeyCode.SPACE) {
                    this.setupTitleBGTimeline();
                    _title.getPressSpace().setOpacity(0);
                    _titleNotCompressed = false;
                    _verChanger.setOpacity(1);
                    for (int i = 0; i < 4; i++){
                        _pet[i].setOpacity(1);
                    }
                }
            }
        }
    }

    public int getAge(){
        int age = 0;
        int rand_int = (int) (Math.random() * 13);
        switch (rand_int){
            case 0:
                age = 1;
                break;
            case 1:
                age = 2;
                break;
            case 2:
                age = 3;
                break;
            case 3:
                age = 4;
                break;
            case 4:
                age = 5;
                break;
            case 5:
                age = 6;
                break;
            case 6:
                age = 7;
                break;
            case 7:
                age = 8;
                break;
            case 8:
                age = 9;
                break;
            case 9:
                age = 10;
                break;
            case 10:
                age = 11;
                break;
            case 11:
                age = 12;
                break;
            default:
                age = 13;
                break;
        }
        return age;
    }

    public String getBirthMonth(){
        String month = null;
        int rand_int = (int) (Math.random() * 12);
        switch (rand_int){
            case 0:
                month = "January";
                break;
            case 1:
                month = "February";
                break;
            case 2:
                month = "March";
                break;
            case 3:
                month = "April";
                break;
            case 4:
                month = "May";
                break;
            case 5:
                month = "June";
                break;
            case 6:
                month = "July";
                break;
            case 7:
                month = "August";
                break;
            case 8:
                month = "September";
                break;
            case 9:
                month = "October";
                break;
            case 10:
                month = "November";
                break;
            default:
                month = "December";
                break;
        }
        return month;
    }

    public String getFavFood(){
        String food = null;
        int rand_int = (int) (Math.random() * 12);
        switch (rand_int){
            case 0:
                food = "Pasta";
                break;
            case 1:
                food = "Acai Bowl";
                break;
            case 2:
                food = "Dumplings";
                break;
            case 3:
                food = "Ramen";
                break;
            case 4:
                food = "Vegan Ice Cream";
                break;
            case 5:
                food = "Tofu";
                break;
            case 6:
                food = "Tomato Soup";
                break;
            case 7:
                food = "Veggie Burger";
                break;
            case 8:
                food = "Sushi";
                break;
            case 9:
                food = "Mashed Potatoes";
                break;
            case 10:
                food = "Fruit Salad";
                break;
            default:
                food = "Channa Masala";
                break;
        }
        return food;
    }

}
