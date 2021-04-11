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
    private int _intPercent;
    public int _counter;

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
        this.setupLoadingBarTimeline();
        _intPercent = _title.getPercent();
        _counter = 0;
        this.setupCounter();
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
        timeline.setCycleCount(2250);
        timeline.play();
    }

    private class Counter implements EventHandler<ActionEvent>{
        public void handle(ActionEvent event){
            _counter ++;
            if (_counter == 2250){
                _title.getLoadingBar().setOpacity(0);
                _title.getLoadingBG().setOpacity(0);
                _title.getPercentLabel().setOpacity(0);
                _title.getPressSpace().setOpacity(1);
            }
        }
    }

    private class TitleMover implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            _title.getNode().setWidth(_title.getNode().getWidth() - 120);
            _title.setXLoc(_title.getXLoc()+120);
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
            if (_titleNotCompressed) {
                if (event.getCode() == KeyCode.SPACE) {
                    this.setupTitleBGTimeline();
                    _title.getPressSpace().setOpacity(0);
                    _titleNotCompressed = false;
                }
            }
        }
    }

}
