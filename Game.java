package indy;

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

    public Game(){
        this.setupGame();
        cat = new Cat(petPane);
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
        walrus.setLoc(210, 520);
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
    }

    private class TitleMover implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            _title.getNode().setWidth(_title.getNode().getWidth() - 120);
            _title.setXLoc(_title.getXLoc()+120);
        }
    }

    private class TitleMoverOnKey implements EventHandler<KeyEvent> {
        public void setupTimeline() {
            KeyFrame kf = new KeyFrame(Duration.millis(25), new TitleMover());
            Timeline timeline = new Timeline(kf);
            timeline.setCycleCount(10);
            timeline.play();
        }
        public void handle (KeyEvent event){
            if (_titleNotCompressed) {
                if (event.getCode() == KeyCode.SPACE) {
                    this.setupTimeline();
                    _titleNotCompressed = false;
                }
            }
        }
    }

}
