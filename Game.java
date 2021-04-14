package indy;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Game {
    private Pane petPane;
    private Cat cat;
    private Chicken chicken;
    private Cow cow;
    private Dog dog;
    private Fox fox;
    private Giraffe giraffe;
    private Owl owl;
    private Penguin penguin;
    private Pig pig;
    private Reindeer reindeer;
    private Sheep sheep;
    private Tiger tiger;
    private Walrus walrus;
    private Pane gardenPane;
    private Garden _garden;
    private Pane storePane;
    private Store _store;
    private Pane titlePane;
    private Title _title;
    private boolean _titleNotCompressed;
    private int _intPercent;
    private int _counter;
    private int _titleXLoc;
    private int _titleYLoc;
    private Pet[][] _pets;
    private Pet[] _pet;
    private double _pet1loc;
    private double _pet2loc;
    private double _pet3loc;
    private double _pet4loc;

    public Game(){
        this.setupGame();
        this.setupInitialPets();
        /*cat = new Cat(petPane);
        cat.setLoc(340, 390);
        chicken = new Chicken(petPane);
        chicken.setLoc(80, 390);
        cow = new Cow(petPane);
        cow.setLoc(80, 130);
        dog = new Dog(petPane);
        dog.setLoc(210, 130);
        fox = new Fox(petPane);
        fox.setLoc(340, 130);
        giraffe = new Giraffe(petPane);
        giraffe.setLoc(470, 130);
        owl = new Owl(petPane);
        owl.setLoc(210, 390);
        penguin = new Penguin(petPane);
        penguin.setLoc(80, 260);
        pig = new Pig(petPane);
        pig.setLoc(210, 260);
        reindeer = new Reindeer(petPane);
        reindeer.setLoc(340, 260);
        sheep = new Sheep(petPane);
        sheep.setLoc(470, 260);
        tiger = new Tiger(petPane);
        tiger.setLoc(80, 520);
        walrus = new Walrus(petPane);
        walrus.setLoc(210, 520); */
    }

    public Pane getPetPane(){
        return petPane;
    }

    public Pane getGardenPane(){
        return gardenPane;
    }

    public Pane getStorePane(){
        return storePane;
    }

    public Pane getTitlePane(){
        return titlePane;
    }

    public void setupGame(){
        petPane = new Pane();
        gardenPane = new Pane();
        storePane = new Pane();
        titlePane = new Pane();
        _garden = new Garden(gardenPane);
        _garden.setLoc(30, 200);
        _store = new Store(storePane);
        _store.setLoc(620, 50);
        _title = new Title(titlePane);
        _title.setLoc(0, 0);
        _titleNotCompressed = true;
        titlePane.addEventHandler(KeyEvent.KEY_PRESSED, new TitleMoverOnKey());
        titlePane.setFocusTraversable(true);
        this.setupLoadingBarTimeline();
        _intPercent = _title.getPercent();
        _counter = 0;
        _titleXLoc = 318;
        _titleYLoc = 270;
        this.setupCounter();
    }

    public Pet generatePet(){
        Pet pet = null;
        int rand_int = (int) (Math.random() * 12);
        switch (rand_int) {
            case 0:
                pet = new Cat(petPane, _pets);
                break;
            case 1:
                pet = new Chicken(petPane, _pets);
                break;
            case 2:
                pet = new Cow(petPane, _pets);
                break;
            case 3:
                pet = new Dog(petPane, _pets);
                break;
            case 4:
                pet = new Fox(petPane, _pets);
                break;
            case 5:
                pet = new Giraffe(petPane, _pets);
                break;
            case 6:
                pet = new Owl(petPane, _pets);
                break;
            case 7:
                pet = new Penguin(petPane, _pets);
                break;
            case 8:
                pet = new Pig(petPane, _pets);
                break;
            case 9:
                pet = new Reindeer(petPane, _pets);
                break;
            case 10:
                pet = new Sheep(petPane, _pets);
                break;
            case 11:
                pet = new Tiger(petPane, _pets);
                break;
            default:
                pet = new Walrus(petPane, _pets);
                break;
        }
        return pet;
    }

    public void getOriginalLocs(){
        _pet1loc = _pet[0].getYLoc();
        _pet2loc = _pet[1].getYLoc();
        _pet3loc = _pet[2].getYLoc();
        _pet4loc = _pet[3].getYLoc();
    }

    public void setupInitialPets(){
        _pets = new Pet[4][4];
        _pet = new Pet[4];
        for (int i = 0; i < 4; i++){
            _pet[i] = this.generatePet();
            _pet[i].setLoc(this.petXLoc(), this.petYLoc());
            _pets[(int) ((_pet[i].getXLoc()-110)/130)][(int) ((_pet[i].getYLoc()-290)/130)] = _pet[i];
        }
        this.getOriginalLocs();
        this.setupPetMover();
    }

    public int petXLoc(){
        int loc = 0;
        int rand_int = (int) (Math.random() * 3);
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
        int rand_int = (int) (Math.random() * 3);
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
            if ((_pet[0].getYLoc() < (_pet1loc - 2)) && (_pet[1].getYLoc() < (_pet2loc - 4)) && (_pet[2].getYLoc() < (_pet3loc - 6))
            && (_pet[3].getYLoc() < (_pet4loc - 8))){
                _direction = !_direction;
            }

            if ((_pet[0].getYLoc() > (_pet1loc + 2)) && (_pet[1].getYLoc() > (_pet2loc + 3)) && (_pet[2].getYLoc() > (_pet3loc + 4))
                    && (_pet[3].getYLoc() > (_pet4loc + 5))){
                _direction = !_direction;
            }
        }
    }

    private class TitleMover implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            _title.getBG().setWidth(_title.getBG().getWidth() - 120);
            _title.setBGXLoc(_title.getBGXLoc()+120);
            _title.getTitle().setRotate(_title.getTitle().getRotate()+9);
            _titleXLoc += 49.5;
            _titleYLoc += 3;
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
                }
            }
        }
    }

}
