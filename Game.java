package indy;

import javafx.scene.layout.Pane;

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

    public Game(){
        petPane = new Pane();
        gardenPane = new Pane();
        storePane = new Pane();
        titlePane = new Pane();
        _garden = new Garden(gardenPane);
        _garden.setLoc(30, 200);
        _store = new Store(storePane);
        _store.setLoc(620, 50);
        _title = new Title(titlePane);
        _title.setLoc(1205, 0);

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
}
