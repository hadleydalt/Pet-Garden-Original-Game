package indy;

//CLICKABLE LABELS FOR SHOP ITEMS SHOULD BE IN INTERACTPANE

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
    private StoreInterface _si;
    private Pane interactPane;
    private Title _title;
    private boolean _titleNotCompressed;
    private int _intPercent;
    private int _counter;
    private int _titleXLoc;
    private int _titleYLoc;
    private Pet[][] _pets;
    private Pet[] _pet;
    private Button _verChanger;
    private Button _quitter;
    private Timeline _timeline;
    private LinkedList<Pet> _myPets;
    private String newName;
    private String newNewName;
    private String searchQuery;
    private Boolean _searchClicked = false;
    private String numHours;
    private String newNumHours;
    private Boolean _cannotChangeName = false;
    private Buyable[][] _shop;
    private int intNumHours;
    private int intLabel;
    private SpecsHelper sh;

    private Boolean _onPage1;
    private Boolean _onPage2;
    private Boolean _onPage3;

    public Game(){
        _shop = new Buyable[3][2];
        this.setupGame();
        this.setupInitialPets();
    }

    public Pane getGardenPane(){
        return gardenPane;
    }

    public Pane getStorePane(){
        return storePane;
    }

    public Pane getInteractPane(){
        return interactPane;
    }

    public Pane getButtonPane() {return buttonPane;}

    public void setupGame(){
        _onPage1 = true;
        _onPage2 = false;
        _onPage3 = false;

        sh = new SpecsHelper();
        gardenPane = new Pane();
        storePane = new Pane();
        interactPane = new Pane();
        _garden = new Garden(gardenPane);
        _garden.setLoc(30, 200);
        _store = new Store(storePane);
        _store.setLoc(620, 50);
        _title = new Title(interactPane);
        _title.setLoc(0, 0);
        _si = new StoreInterface(interactPane, _store.getShopPane());
        _si.setLoc(620,50);
        _titleNotCompressed = true;
        interactPane.addEventHandler(KeyEvent.KEY_PRESSED, new AllKeyEventsHandler());
        interactPane.setFocusTraversable(true);
        this.setupLoadingBarTimeline();
        _intPercent = _title.getPercent();
        _counter = 0;
        _titleXLoc = 318;
        _titleYLoc = 270;
        this.setupCounter();
        buttonPane = new Pane();
        buttonPane.relocate(30, 15);
        _verChanger = new Button("Static Version");
        _verChanger.setOnAction(new VersionChanger());
        _verChanger.setOpacity(0);
        _quitter = new Button("Quit");
        _quitter.setOnAction(new ProgramQuitter());
        _quitter.setOpacity(0);
        _quitter.relocate(505, 0);
        buttonPane.getChildren().addAll(_verChanger, _quitter);
        _myPets = new LinkedList<Pet>();
        newName = "";
        newNewName = "";
        searchQuery = "";
        numHours = "";
        newNumHours = "";
        intNumHours = 0;
        intLabel = 0;
        _si.getSearchMyPetsCN().addEventHandler(MouseEvent.MOUSE_CLICKED, new SearchGetter());
        _si.getXCN().addEventHandler(MouseEvent.MOUSE_CLICKED, new SearchDisappear());
        _si.getEnterHoursCN().addEventHandler(MouseEvent.MOUSE_CLICKED, new EnterGetter());
        _si.getXCN2().addEventHandler(MouseEvent.MOUSE_CLICKED, new EnterDisappear());
        _si.getFirstCN().addEventHandler(MouseEvent.MOUSE_CLICKED, new FirstPage());
        _si.getSecondCN().addEventHandler(MouseEvent.MOUSE_CLICKED, new SecondPage());
        _si.getThirdCN().addEventHandler(MouseEvent.MOUSE_CLICKED, new ThirdPage());
        _si.getConfirmCN().addEventHandler(MouseEvent.MOUSE_CLICKED, new HoursEnterer());
        _si.getShop1().addEventHandler(MouseEvent.MOUSE_CLICKED, new BuyShop1());
        _si.getShop2().addEventHandler(MouseEvent.MOUSE_CLICKED, new BuyShop2());
        _si.getShop3().addEventHandler(MouseEvent.MOUSE_CLICKED, new BuyShop3());
        _si.getShop4().addEventHandler(MouseEvent.MOUSE_CLICKED, new BuyShop4());
        _si.getShop5().addEventHandler(MouseEvent.MOUSE_CLICKED, new BuyShop5());
        _si.getShop6().addEventHandler(MouseEvent.MOUSE_CLICKED, new BuyShop6());
    }

    private class BuyShop1 implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            Cat newCat = new Cat(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
            newCat.setLoc(sh.petXLoc(), sh.petYLoc());
            _pets[(int) ((newCat.getXLoc()-110)/130)][(int) ((newCat.getYLoc()-290)/130)] = newCat;
        }
    }

    private class BuyShop2 implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            Chicken newChicken = new Chicken(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
            newChicken.setLoc(sh.petXLoc(), sh.petYLoc());
            _pets[(int) ((newChicken.getXLoc()-110)/130)][(int) ((newChicken.getYLoc()-290)/130)] = newChicken;
        }
    }

    private class BuyShop3 implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            Cow newCow = new Cow(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
            newCow.setLoc(sh.petXLoc(), sh.petYLoc());
            _pets[(int) ((newCow.getXLoc()-110)/130)][(int) ((newCow.getYLoc()-290)/130)] = newCow;
        }
    }

    private class BuyShop4 implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            Dog newDog = new Dog(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
            newDog.setLoc(sh.petXLoc(), sh.petYLoc());
            _pets[(int) ((newDog.getXLoc()-110)/130)][(int) ((newDog.getYLoc()-290)/130)] = newDog;
        }
    }

    private class BuyShop5 implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            Fox newFox = new Fox(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
            newFox.setLoc(sh.petXLoc(), sh.petYLoc());
            _pets[(int) ((newFox.getXLoc()-110)/130)][(int) ((newFox.getYLoc()-290)/130)] = newFox;
        }
    }

    private class BuyShop6 implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            Giraffe newGiraffe = new Giraffe(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
            newGiraffe.setLoc(sh.petXLoc(), sh.petYLoc());
            _pets[(int) ((newGiraffe.getXLoc()-110)/130)][(int) ((newGiraffe.getYLoc()-290)/130)] = newGiraffe;
        }
    }

    private class FirstPage implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            _onPage1 = true;
            _onPage2 = false;
            _onPage3 = false;
                _si.fillShop(_si.getCat(), _si.getChicken(), _si.getCow(), _si.getDog(), _si.getFox(), _si.getGiraffe());
        }
    }

    private class SecondPage implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            _onPage1 = false;
            _onPage2 = true;
            _onPage3 = false;
            _si.fillShop(_si.getOwl(), _si.getPenguin(), _si.getPig(), _si.getReindeer(), _si.getSheep(), _si.getTiger());
        }
    }

    private class ThirdPage implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            _onPage1 = false;
            _onPage2 = false;
            _onPage3 = true;
            _si.fillShop(_si.getWalrus(), _si.getGnome(), _si.getPlant(), _si.getHouse(), _si.getHat(), _si.getSunsetBG());
        }
    }

    private class VersionChanger implements EventHandler<ActionEvent> {
        boolean isAnimated = true;
        public void handle(ActionEvent event) {
            if (isAnimated) {
                _timeline.stop();
                _pet[0].setBounceLoc(_pet[0].getXLoc(), _pet[0].getOYL());
                _pet[1].setBounceLoc(_pet[1].getXLoc(), _pet[1].getOYL());
                _pet[2].setBounceLoc(_pet[2].getXLoc(), _pet[2].getOYL());
                _pet[3].setBounceLoc(_pet[3].getXLoc(), _pet[3].getOYL());
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

    private class ProgramQuitter implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            System.exit(0);
            }
    }

    public Pet generatePet(){
        Pet pet = null;
        int rand_int = (int) (Math.random() * 13);
        switch (rand_int) {
            case 0:
                pet = new Cat(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                break;
            case 1:
                pet = new Chicken(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                break;
            case 2:
                pet = new Cow(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                break;
            case 3:
                pet = new Dog(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                break;
            case 4:
                pet = new Fox(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                break;
            case 5:
                pet = new Giraffe(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                break;
            case 6:
                pet = new Owl(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                break;
            case 7:
                pet = new Penguin(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                break;
            case 8:
                pet = new Pig(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                break;
            case 9:
                pet = new Reindeer(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                break;
            case 10:
                pet = new Sheep(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                break;
            case 11:
                pet = new Tiger(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                break;
            default:
                pet = new Walrus(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                break;
        }
        return pet;
    }



    public void setupInitialPets(){
        _pets = new Pet[4][4];
        _pet = new Pet[4];
        for (int i = 0; i < 4; i++){
            _pet[i] = this.generatePet();
            _pet[i].setOpacity(0);
            _pet[i].setLoc(sh.petXLoc(), sh.petYLoc());
            _myPets.add(i, _pet[i]);
            _pets[(int) ((_pet[i].getXLoc()-110)/130)][(int) ((_pet[i].getYLoc()-290)/130)] = _pet[i];
        }
        this.setupPetMover();
        this.setupHandlers();
    }

    public void setupHandlers(){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                if (_pets[i][j] != null) {
                    SpecsGetter sg = new SpecsGetter(_pets[i][j]);
                    _pets[i][j].getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, sg);
                    _pets[i][j].getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, sg);
                    _pets[i][j].getNode().addEventHandler(MouseEvent.MOUSE_EXITED, new SpecsDisappear());
                }
            }
        }
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
        timeline.setCycleCount(Animation.INDEFINITE);
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
            if (_counter >= 2500){
                _title.getLoadingBar().setOpacity(0);
                _title.getLoadingBG().setOpacity(0);
                _title.getPercentLabel().setOpacity(0);

                if (_counter == 2500) {
                    _title.getPressSpace().setOpacity(1);
                }
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

            if ((_pet[0].getYLoc() < (_pet[0].getOYL() - 2)) && (_pet[1].getYLoc() < (_pet[1].getOYL() - 4)) && (_pet[2].getYLoc() < (_pet[2].getOYL() - 6))
                    && (_pet[3].getYLoc() < (_pet[3].getOYL() - 8))){
                _direction = !_direction;
            }

            if ((_pet[0].getYLoc() > (_pet[0].getOYL() + 2)) && (_pet[1].getYLoc() > (_pet[1].getOYL() + 3)) && (_pet[2].getYLoc() > (_pet[2].getOYL() + 4))
                    && (_pet[3].getYLoc() > (_pet[3].getOYL() + 5))){
                _direction = !_direction;
            }
        }
    }

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

    private class SearchGetter implements EventHandler<MouseEvent>{
        public void handle (MouseEvent event){
            _si.setSearchOpacity(1);
            _store.getCat().setOpacity(0);
            _store.getChicken().setOpacity(0);
            _store.getCow().setOpacity(0);
            _store.getDog().setOpacity(0);
            _store.getFox().setOpacity(0);
            _store.getGiraffe().setOpacity(0);
            _store.getOwl().setOpacity(0);
            _store.getPenguin().setOpacity(0);
            _store.getPig().setOpacity(0);
            _store.getReindeer().setOpacity(0);
            _store.getSheep().setOpacity(0);
            _store.getTiger().setOpacity(0);
            _store.getWalrus().setOpacity(0);
            _store.getPetNamed().setOpacity(0);
            _si.getTypeToSearch().setText("Type a pet's name to search");
            searchQuery = "";
            _searchClicked = true;
        }
    }

    private class EnterGetter implements EventHandler<MouseEvent>{
        public void handle (MouseEvent event){
            _si.setEnterOpacity(1);
            _si.getTypeHours().setText("Enter hours of productivity");
            numHours = "";
        }
    }

    private class SearchDisappear implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            _si.setSearchOpacity(0);
            _searchClicked = false;
        }
    }

    private class EnterDisappear implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            _si.setEnterOpacity(0);
        }
    }

    private class HoursEnterer implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            newNumHours = numHours;
            numHours = "";
            intNumHours = (Integer.parseInt(newNumHours.trim())*10);
            intLabel = intLabel + intNumHours;
            _si.getBalance().setText(Integer.toString(intLabel));
        }
    }


    private class SpecsGetter implements EventHandler<MouseEvent> {
        private Pet _pet;
        private SpecsGetter(Pet pet) {
            _pet = pet;
        }
            public void handle (MouseEvent event){
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (_pets[i][j] != null) {
                            _store.getSpecsPane().setOpacity(1);
                            _store.getMyName().setText(_pet.getPetName());
                            _store.getMyPersonality().setText(_pet.getPetPersonality());
                            _store.getMyBirthMonth().setText(_pet.getPetBirthMonth());
                            _store.getMyFavFood().setText(_pet.getPetFavFood());
                            AllKeyEventsHandler akeh = new AllKeyEventsHandler();
                            _pet.getNode().addEventHandler(KeyEvent.KEY_TYPED, akeh);

                            if (newName.length() > 1) {
                                newNewName = newName;
                                newName = "";
                                _pet.setPetName(newNewName);
                                _store.getPetNamed().setOpacity(1);
                                _pet.setIsNamed();
                            }

                            if (_pet.getType().equals("Cat")){
                                _store.getCat().setOpacity(1);
                            }
                            if (_pet.getType().equals("Chicken")){
                                _store.getChicken().setOpacity(1);
                            }
                            if (_pet.getType().equals("Cow")){
                                _store.getCow().setOpacity(1);
                            }
                            if (_pet.getType().equals("Dog")){
                                _store.getDog().setOpacity(1);
                            }
                            if (_pet.getType().equals("Fox")){
                                _store.getFox().setOpacity(1);
                            }
                            if (_pet.getType().equals("Giraffe")){
                                _store.getGiraffe().setOpacity(1);
                            }
                            if (_pet.getType().equals("Owl")){
                                _store.getOwl().setOpacity(1);
                            }
                            if (_pet.getType().equals("Penguin")){
                                _store.getPenguin().setOpacity(1);
                            }
                            if (_pet.getType().equals("Pig")){
                                _store.getPig().setOpacity(1);
                            }
                            if (_pet.getType().equals("Reindeer")){
                                _store.getReindeer().setOpacity(1);
                            }
                            if (_pet.getType().equals("Sheep")){
                                _store.getSheep().setOpacity(1);
                            }
                            if (_pet.getType().equals("Tiger")){
                                _store.getTiger().setOpacity(1);
                            }
                            if (_pet.getType().equals("Walrus")){
                                _store.getWalrus().setOpacity(1);
                            }
                        }
                    }
                }
            }
    }

    private class SpecsDisappear implements EventHandler<MouseEvent> {
        public void handle(MouseEvent event) {
            _store.getSpecsPane().setOpacity(0);
            _store.getCat().setOpacity(0);
            _store.getChicken().setOpacity(0);
            _store.getCow().setOpacity(0);
            _store.getDog().setOpacity(0);
            _store.getFox().setOpacity(0);
            _store.getGiraffe().setOpacity(0);
            _store.getOwl().setOpacity(0);
            _store.getPenguin().setOpacity(0);
            _store.getPig().setOpacity(0);
            _store.getReindeer().setOpacity(0);
            _store.getSheep().setOpacity(0);
            _store.getTiger().setOpacity(0);
            _store.getWalrus().setOpacity(0);
            _store.getPetNamed().setOpacity(0);
        }
    }

    private class SpecsClose implements EventHandler<MouseEvent>{
        private Pet _pet;
        private SpecsClose(Pet pet){
            _pet = pet;
        }
        public void handle(MouseEvent event){
            _store.getSpecsPane().setOpacity(0);
            _store.getCat().setOpacity(0);
            _store.getChicken().setOpacity(0);
            _store.getCow().setOpacity(0);
            _store.getDog().setOpacity(0);
            _store.getFox().setOpacity(0);
            _store.getGiraffe().setOpacity(0);
            _store.getOwl().setOpacity(0);
            _store.getPenguin().setOpacity(0);
            _store.getPig().setOpacity(0);
            _store.getReindeer().setOpacity(0);
            _store.getSheep().setOpacity(0);
            _store.getTiger().setOpacity(0);
            _store.getWalrus().setOpacity(0);
            _store.getPetNamed().setOpacity(0);
                _si.setCloseOpacity(0);
                _cannotChangeName = false;
                _pet.getNode().addEventHandler(MouseEvent.MOUSE_EXITED, new SpecsDisappear());
        }
    }

    private class AllKeyEventsHandler implements EventHandler<KeyEvent> {
        public void setupTitleBGTimeline() {
            KeyFrame kf1 = new KeyFrame(Duration.millis(45), new TitleMover());
            Timeline timeline = new Timeline(kf1);
            timeline.setCycleCount(10);
            timeline.play();
        }

        public void handle (KeyEvent event){
                if (event.getCode() == KeyCode.SPACE) {
                    _title.getPressSpace().setOpacity(0);
                    if ((_titleNotCompressed) && (_counter >= 2500)) {
                    this.setupTitleBGTimeline();
                    _titleNotCompressed = false;
                    _verChanger.setOpacity(1);
                    _quitter.setOpacity(1);
                    for (int i = 0; i < 4; i++){
                        _pet[i].setOpacity(1);
                    }
                    for (int i = 0; i < 3; i++){
                        for (int j = 0; j < 2; j++){
                            _si.getShop()[i][j].setOpacity(1);
                        }
                    }
                    _si.setOpacity(1);
                }
            }

            if ((event.getCode() == KeyCode.A) || (event.getCode() == KeyCode.B) || (event.getCode() == KeyCode.C)
                    || (event.getCode() == KeyCode.D) || (event.getCode() == KeyCode.E) || (event.getCode() == KeyCode.F)
                    || (event.getCode() == KeyCode.G) || (event.getCode() == KeyCode.H) || (event.getCode() == KeyCode.I)
                    || (event.getCode() == KeyCode.J) || (event.getCode() == KeyCode.K) || (event.getCode() == KeyCode.L)
                    || (event.getCode() == KeyCode.M) || (event.getCode() == KeyCode.N) || (event.getCode() == KeyCode.O)
                    || (event.getCode() == KeyCode.P) || (event.getCode() == KeyCode.Q || (event.getCode() == KeyCode.R)
                    || (event.getCode() == KeyCode.S) || (event.getCode() == KeyCode.T) || (event.getCode() == KeyCode.U)
                    || (event.getCode() == KeyCode.V) || (event.getCode() == KeyCode.W) || (event.getCode() == KeyCode.X)
                    || (event.getCode() == KeyCode.Y) || (event.getCode() == KeyCode.Z))) {

                if (_searchClicked) {
                    searchQuery = searchQuery + event.getText();
                    _si.getTypeToSearch().setText(searchQuery);

                    if (searchQuery != null && searchQuery.length() > 1 && !searchQuery.equals("Type+CLICK to name")) {
                        for (int i = 0; i < 4; i++) {
                            for (int j = 0; j < 4; j++) {
                                if (_pets[i][j] != null) {
                                    if (searchQuery.equals(_pets[i][j].getPetName())) {
                                        _cannotChangeName = true;
                                        _si.setSearchOpacity(0);
                                        _searchClicked = false;
                                        _store.getSpecsPane().setOpacity(1);
                                        _store.getMyName().setText(_pets[i][j].getPetName());
                                        _store.getMyPersonality().setText(_pets[i][j].getPetPersonality());
                                        _store.getMyBirthMonth().setText(_pets[i][j].getPetBirthMonth());
                                        _store.getMyFavFood().setText(_pets[i][j].getPetFavFood());

                                        if (_pets[i][j].getType().equals("Cat")){
                                            _store.getCat().setOpacity(1);
                                        }
                                        if (_pets[i][j].getType().equals("Chicken")){
                                            _store.getChicken().setOpacity(1);
                                        }
                                        if (_pets[i][j].getType().equals("Cow")){
                                            _store.getCow().setOpacity(1);
                                        }
                                        if (_pets[i][j].getType().equals("Dog")){
                                            _store.getDog().setOpacity(1);
                                        }
                                        if (_pets[i][j].getType().equals("Fox")){
                                            _store.getFox().setOpacity(1);
                                        }
                                        if (_pets[i][j].getType().equals("Giraffe")){
                                            _store.getGiraffe().setOpacity(1);
                                        }
                                        if (_pets[i][j].getType().equals("Owl")){
                                            _store.getOwl().setOpacity(1);
                                        }
                                        if (_pets[i][j].getType().equals("Penguin")){
                                            _store.getPenguin().setOpacity(1);
                                        }
                                        if (_pets[i][j].getType().equals("Pig")){
                                            _store.getPig().setOpacity(1);
                                        }
                                        if (_pets[i][j].getType().equals("Reindeer")){
                                            _store.getReindeer().setOpacity(1);
                                        }
                                        if (_pets[i][j].getType().equals("Sheep")){
                                            _store.getSheep().setOpacity(1);
                                        }
                                        if (_pets[i][j].getType().equals("Tiger")){
                                            _store.getTiger().setOpacity(1);
                                        }
                                        if (_pets[i][j].getType().equals("Walrus")){
                                            _store.getWalrus().setOpacity(1);
                                        }

                                        _pets[i][j].getNode().removeEventHandler(MouseEvent.MOUSE_EXITED, new SpecsDisappear());
                                        _si.setCloseOpacity(1);
                                            _si.getXCN1().addEventHandler(MouseEvent.MOUSE_CLICKED, new SpecsClose(_pets[i][j]));
                                    }
                                }
                            }
                        }
                    }
                }

                if (!_searchClicked && !_cannotChangeName) {

                    newName = newName + event.getText();
                    _store.getMyName().setText(newName);
                }
            }

            if ((event.getCode() == KeyCode.DIGIT1) || (event.getCode() == KeyCode.DIGIT2) || (event.getCode() == KeyCode.DIGIT3) ||
                    (event.getCode() == KeyCode.DIGIT4) || (event.getCode() == KeyCode.DIGIT5) || (event.getCode() == KeyCode.DIGIT6) ||
                    (event.getCode() == KeyCode.DIGIT7) || (event.getCode() == KeyCode.DIGIT8) || (event.getCode() == KeyCode.DIGIT9) ||
                    (event.getCode() == KeyCode.DIGIT0)) {

                numHours = numHours + event.getText();
                _si.getTypeHours().setText(numHours);
            }
        }
    }

    public class SpecsHelper {

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

        public String getPersonality() {
            String p = null;
            int rand_int = (int) (Math.random() * 13);
            switch (rand_int) {
                case 0:
                    p = "Quiet and reserved";
                    break;
                case 1:
                    p = "Egotistical";
                    break;
                case 2:
                    p = "Grumpy and jaded";
                    break;
                case 3:
                    p = "Bubbly and excitable";
                    break;
                case 4:
                    p = "Rational and balanced";
                    break;
                case 5:
                    p = "Smart and curious";
                    break;
                case 6:
                    p = "Sweet and kind";
                    break;
                case 7:
                    p = "Loud and sociable";
                    break;
                case 8:
                    p = "Artistic and quirky";
                    break;
                case 9:
                    p = "Educated and pedantic";
                    break;
                case 10:
                    p = "Rash and mercuric";
                    break;
                case 11:
                    p = "Impulsive + mischievous";
                    break;
                default:
                    p = "Brave and assertive";
                    break;
            }
            return p;
        }

        public String getBirthMonth() {
            String month = null;
            int rand_int = (int) (Math.random() * 12);
            switch (rand_int) {
                case 0:
                    month = "January (Capricorn)";
                    break;
                case 1:
                    month = "February (Aquarius)";
                    break;
                case 2:
                    month = "March (Pisces)";
                    break;
                case 3:
                    month = "April (Aries)";
                    break;
                case 4:
                    month = "May (Taurus)";
                    break;
                case 5:
                    month = "June (Gemini)";
                    break;
                case 6:
                    month = "July (Cancer)";
                    break;
                case 7:
                    month = "August (Leo)";
                    break;
                case 8:
                    month = "September (Virgo)";
                    break;
                case 9:
                    month = "October (Libra)";
                    break;
                case 10:
                    month = "November (Scorpio)";
                    break;
                default:
                    month = "December (Sagittarius)";
                    break;
            }
            return month;
        }

        public String getFavFood() {
            String food = null;
            int rand_int = (int) (Math.random() * 12);
            switch (rand_int) {
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

}
