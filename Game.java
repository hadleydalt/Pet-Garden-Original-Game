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
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.util.Duration;

// The Game class contains most of the game's central logic, including all EventHandlers.

public class Game {
    private Pane gardenPane;
    private Pane buttonPane;
    private Garden _garden;
    private Pane storePane;
    private Store _store;
    private StoreInterface _si;
    private Pane interactPane;
    private Title _title;
    private boolean _titleNotCompressed = true;
    private int _intPercent;
    private int _counter;
    private int _titleXLoc;
    private int _titleYLoc;
    private Buyable[][] _pets;
    private Pet[] _pet;
    private Button _verChanger;
    private Button _quitter;
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
    private PetMoverHelper pmh;
    private Handlers h;

    private Sorts sorts;

    private Boolean _onPage1 = true;
    private Boolean _onPage2 = false;
    private Boolean _onPage3 = false;
    private Boolean _isSorted = false;

    public Game(){
        this.setupGame();
        this.setupInitialPets();
        this.setupSorts();
    }

    public void setupGame(){

        // IMPORTANT ELEMENTS
        _shop = new Buyable[3][2];
        sh = new SpecsHelper();
        pmh = new PetMoverHelper();
        h = new Handlers();

        // PANES AND LOCATIONS
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

        // KEY EVENTS HANDLER AND INITIAL SCREEN ANIMATION
        interactPane.addEventHandler(KeyEvent.KEY_PRESSED, new AllKeyEventsHandler());
        interactPane.setFocusTraversable(true);
        this.setupLoadingBarTimeline();
        _intPercent = _title.getPercent();
        _counter = 0;
        _titleXLoc = 318;
        _titleYLoc = 270;
        this.setupCounter();

        // BUTTONS
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
        interactPane.getChildren().add(buttonPane);

        // INITIALIZING INTEGERS AND STRINGS
        newName = "";
        newNewName = "";
        searchQuery = "";
        numHours = "";
        newNumHours = "";
        intNumHours = 0;
        intLabel = 0;

        // SETTING UP MOUSE EVENT HANDLERS
        _si.getSearchMyPetsCN().addEventHandler(MouseEvent.MOUSE_CLICKED, new SearchGetter());
        _si.getXCN().addEventHandler(MouseEvent.MOUSE_CLICKED, new SearchDisappear());
        _si.getEnterHoursCN().addEventHandler(MouseEvent.MOUSE_CLICKED, new EnterGetter());
        _si.getXCN2().addEventHandler(MouseEvent.MOUSE_CLICKED, new EnterDisappear());
        _si.getSortByPriceCN().addEventHandler(MouseEvent.MOUSE_CLICKED, new PriceSorter());
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

    // PANE GETTER METHODS
    public Pane getGardenPane(){
        return gardenPane;
    }
    public Pane getStorePane(){
        return storePane;
    }
    public Pane getInteractPane(){
        return interactPane;
    }

    // SETS UP THE 2D ARRAY IN THE GARDEN AND A 1D ARRAY OF THE INITIAL PETS, WHICH ARE ADDED TO THE 2D ARRAY
    public void setupInitialPets(){
        _pets = new Buyable[4][4];
        _pet = new Pet[4];
        for (int i = 0; i < 4; i++){
            _pet[i] = this.generatePet();
            _pet[i].setOpacity(0);
            _pet[i].setLoc(sh.petXLoc(), sh.petYLoc());
            _pets[(int) ((_pet[i].getXLoc()-110)/130)][(int) ((_pet[i].getYLoc()-290)/130)] = _pet[i];
            pmh.setupPetMover(_pet[i]);
            h.setupHandlers(_pet[i]);
        }
    }

    // MAKES A LIST OF ALL BUYABLES SORTED BY PRICE USING THE MERGESORT METHOD DEFINED IN "SORTS" CLASS
    public void setupSorts(){
        sorts = new Sorts(_si.getItems());
        sorts.makeList();
    }


// BUTTONS

    // BUTTON THAT CHANGES WHETHER PETS ARE MOVING OR FROZEN
    private class VersionChanger implements EventHandler<ActionEvent> {
        boolean isAnimated = true;
        public void handle(ActionEvent event) {
            if (isAnimated) {
                for (int i = 0; i < 4; i++){
                    for (int j =0; j < 4; j++){
                        if (_pets[i][j] != null && ((_pets[i][j].getType().equals("Cat")) || (_pets[i][j].getType().equals("Chicken")) ||
                                (_pets[i][j].getType().equals("Cow")) || (_pets[i][j].getType().equals("Dog")) ||
                                (_pets[i][j].getType().equals("Fox")) || (_pets[i][j].getType().equals("Giraffe")) ||
                                (_pets[i][j].getType().equals("Owl")) || (_pets[i][j].getType().equals("Penguin")) ||
                                (_pets[i][j].getType().equals("Pig")) || (_pets[i][j].getType().equals("Reindeer")) ||
                                (_pets[i][j].getType().equals("Sheep")) || (_pets[i][j].getType().equals("Tiger")) ||
                                (_pets[i][j].getType().equals("Walrus")))) {
                            _pets[i][j].getTimeline().stop();
                            _pets[i][j].setBounceLoc(_pets[i][j].getXLoc(), _pets[i][j].getOYL());
                        }
                    }
                }
                isAnimated = false;
                _verChanger.setText("Animated Version");
            }
            else {
                for (int i = 0; i < 4; i++){
                    for (int j =0; j < 4; j++){
                        if (_pets[i][j] != null && ((_pets[i][j].getType().equals("Cat")) || (_pets[i][j].getType().equals("Chicken")) ||
                                (_pets[i][j].getType().equals("Cow")) || (_pets[i][j].getType().equals("Dog")) ||
                                (_pets[i][j].getType().equals("Fox")) || (_pets[i][j].getType().equals("Giraffe")) ||
                                (_pets[i][j].getType().equals("Owl")) || (_pets[i][j].getType().equals("Penguin")) ||
                                (_pets[i][j].getType().equals("Pig")) || (_pets[i][j].getType().equals("Reindeer")) ||
                                (_pets[i][j].getType().equals("Sheep")) || (_pets[i][j].getType().equals("Tiger")) ||
                                (_pets[i][j].getType().equals("Walrus")))) {
                            _pets[i][j].getTimeline().play();
                        }
                    }
                }
                _verChanger.setText("Static Version");
                isAnimated = true;
            }
        }
    }

    // QUIT BUTTON
    private class ProgramQuitter implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            System.exit(0);
        }
    }

// MOUSE EVENTS

    // PRICE SORTER
    /*If this button is clicked, the Shop will reset to Page 1 and the items will appear in the order that they fall on
    * the itemsList, which is filled in the setupSorts method using a MergeSort to order the items from lowest to highest price.
    *
    * If the button is clicked again, the items revert to their original order. */

    private class PriceSorter implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            if (!_isSorted){
                _onPage1 = true;
                _onPage2 = false;
                _onPage3 = false;

                    _si.fillShop(sorts.getItemsList().get(0), sorts.getItemsList().get(1), sorts.getItemsList().get(2),
                            sorts.getItemsList().get(3), sorts.getItemsList().get(4), sorts.getItemsList().get(5));
                _isSorted = true;
                _si.getSortByPrice().setText("UNDO SORT");
                _si.getSortByPrice().relocate(717, 586);
            }
            else {
                _onPage1 = true;
                _onPage2 = false;
                _onPage3 = false;
                _si.fillShop(_si.getCat(), _si.getChicken(), _si.getCow(), _si.getDog(), _si.getFox(), _si.getGiraffe());
                _isSorted = false;
                _si.getSortByPrice().setText("SORT BY PRICE");
                _si.getSortByPrice().relocate(702, 586);
            }
        }
    }

    // BUY SHOP HANDLERS
    /*These Handlers are called when the user clicks the Label below an item in the shop. There are 6 handlers for the 6
    * items on each page. The Handlers will buy different Buyables depending on what page the user is on, because the items
    * displayed vary from page to page. The Handlers will also buy different Buyables depending on whether the shop is
    * Sorted or not, because the Buyables on display will be in a different order.*/

    private class BuyShop1 implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            if (_onPage1) {
                    if (!sh.isFull()) {
                        if (!_isSorted) {
                            sh.addCat();
                        } else {
                            sh.addChicken();
                        }
                    }
            }

            if (_onPage2) {
                    if (!sh.isFull()) {
                        if (!_isSorted) {
                            sh.addOwl();
                        } else {
                            sh.addCat();
                        }
                    }
            }

            if (_onPage3) {
                    if (!sh.isFull()) {
                        if (!_isSorted) {
                            sh.addWalrus();
                        } else {
                            sh.addCow();
                        }
                    }
            }
        }
    }

    private class BuyShop2 implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            if (_onPage1) {
                    if (!sh.isFull()) {
                        if (!_isSorted) {
                            sh.addChicken();
                        } else {
                            sh.add_Hat();
                        }
                    }
            }

            if (_onPage2) {
                    if (!sh.isFull()) {
                            sh.addPenguin();
                    }
                }

            if (_onPage3) {
                    if (!sh.isFull()) {
                        if (!_isSorted) {
                            sh.addGnome();
                        } else {
                            sh.addFox();
                        }
                    }
            }
        }
    }

    private class BuyShop3 implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            if (_onPage1) {
                    if (!sh.isFull()) {
                        if (!_isSorted) {
                            sh.addCow();
                        } else {
                            sh.addOwl();
                        }
                    }
            }

            if (_onPage2) {
                    if (!sh.isFull()) {
                            sh.addPig();
                    }
            }

            if (_onPage3) {
                    if (!sh.isFull()) {
                        if (!_isSorted) {
                            sh.addPlant();
                        } else {
                            sh.addSunsetBG();
                        }
                    }
            }
        }
    }

    private class BuyShop4 implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            if (_onPage1) {
                    if (!sh.isFull()) {
                        if (!_isSorted) {
                            sh.addDog();
                        } else {
                            sh.addWalrus();
                        }
                    }
            }

            if (_onPage2) {
                    if (!sh.isFull()) {
                        if (!_isSorted) {
                            sh.addReindeer();
                        } else {
                            sh.addHouse();
                        }
                    }
            }

            if (_onPage3) {
                    if (!sh.isFull()) {
                        if (!_isSorted) {
                            sh.addHouse();
                        } else {
                            sh.addReindeer();
                        }
                    }
            }
        }
    }

    private class BuyShop5 implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            if (_onPage1) {
                    if (!sh.isFull()) {
                        if (!_isSorted) {
                            sh.addFox();
                        } else {
                            sh.addSheep();
                        }
                    }
            }
            if (_onPage2) {
                    if (!sh.isFull()) {
                        if (!_isSorted) {
                            sh.addSheep();
                        } else {
                            sh.addDog();
                        }
                    }
            }

            if (_onPage3) {
                    if (!sh.isFull()) {
                        if (!_isSorted) {
                            sh.add_Hat();
                        } else {
                            sh.addTiger();
                        }
                    }
            }
        }
    }

    private class BuyShop6 implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            if (_onPage1) {
                    if (!sh.isFull()) {
                        if (!_isSorted) {
                            sh.addGiraffe();
                        } else {
                            sh.addGnome();
                        }
                    }
            }
            if (_onPage2) {
                    if (!sh.isFull()) {
                        if (!_isSorted) {
                            sh.addTiger();
                        } else {
                            sh.addPlant();
                        }
                    }
            }

            if (_onPage3) {
                    if (!sh.isFull()) {
                        if (!_isSorted) {
                            sh.addSunsetBG();
                        } else {
                            sh.addGiraffe();
                        }
                    }
            }
        }
    }

    // PAGE HANDLERS: FILL THE SHOP WITH DIFFERENT BUYABLES DEPENDING ON WHICH PAGE THE USER IS ON.

    private class FirstPage implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            _onPage1 = true;
            _onPage2 = false;
            _onPage3 = false;

            if (!_isSorted) {
                _si.fillShop(_si.getCat(), _si.getChicken(), _si.getCow(), _si.getDog(), _si.getFox(), _si.getGiraffe());
            }
            if (_isSorted){
                _si.fillShop(sorts.getItemsList().get(0), sorts.getItemsList().get(1), sorts.getItemsList().get(2),
                        sorts.getItemsList().get(3), sorts.getItemsList().get(4), sorts.getItemsList().get(5));
            }
        }
    }

    private class SecondPage implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            _onPage1 = false;
            _onPage2 = true;
            _onPage3 = false;

            if (!_isSorted) {
                _si.fillShop(_si.getOwl(), _si.getPenguin(), _si.getPig(), _si.getReindeer(), _si.getSheep(), _si.getTiger());
            }
            if (_isSorted){
                _si.fillShop(sorts.getItemsList().get(6), sorts.getItemsList().get(7), sorts.getItemsList().get(8),
                        sorts.getItemsList().get(9), sorts.getItemsList().get(10), sorts.getItemsList().get(11));
            }
        }
    }

    private class ThirdPage implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            _onPage1 = false;
            _onPage2 = false;
            _onPage3 = true;

            if (!_isSorted) {
                _si.fillShop(_si.getWalrus(), _si.getGnome(), _si.getPlant(), _si.getHouse(), _si.getHat(), _si.getSunsetBG());
            }
            if (_isSorted){
                _si.fillShop(sorts.getItemsList().get(12), sorts.getItemsList().get(13), sorts.getItemsList().get(14),
                        sorts.getItemsList().get(15), sorts.getItemsList().get(16), sorts.getItemsList().get(17));
            }
        }
    }

    // SEARCH GETTER: MAKES THE SEARCH BAR VISIBLE AND RESETS ALL PET PROFILE PICTURES TO INVISIBLE.

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

    // ENTER GETTER: MAKES THE ENTER HOURS BAR VISIBLE AND SETS THE STRING OF ENTERED TEXT BLANK IN CASE ANY HOURS WERE ENTERED PREVIOUSLY

    private class EnterGetter implements EventHandler<MouseEvent>{
        public void handle (MouseEvent event){
            _si.setEnterOpacity(1);
            _si.getTypeHours().setText("Enter hours of productivity");
            numHours = "";
        }
    }

    // MAKES THE SEARCH BAR INVISIBLE IF THE USER CLICKS OUT

    private class SearchDisappear implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            _si.setSearchOpacity(0);
            _searchClicked = false;
        }
    }

    // MAKES THE ENTER HOURS BAR INVISIBLE IF THE USER CLICKS OUT

    private class EnterDisappear implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            _si.setEnterOpacity(0);
        }
    }

    // HOURS ENTERER
    /*Takes the amount of hours entered in the search bar and stores it in a new variable, reverting the current one to blank.
    * The new variable is then converted to an integer and the user's current balance increments by this integer.
    * The balance label is then updated to reflect this. */

    private class HoursEnterer implements EventHandler<MouseEvent>{
        public void handle(MouseEvent event){
            newNumHours = numHours;
            numHours = "";
            intNumHours = (Integer.parseInt(newNumHours.trim()) * 10);
            intLabel = intLabel + intNumHours;
            _si.getBalance().setText(Integer.toString(intLabel));
        }
    }

    // SPECS GETTER:
    /*Makes the info card visible and changes its information based on the pet that is passed in as a parameter. Also,
    * if any changes have been made to the newName variable (i.e., if the user has typed in info) the pet's name variable is
    * set to this variable. Depending on the type of pet that is being hovered over, a different profile picture will appear in
    * the info card. */

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

    // SPECS DISAPPEAR: MAKES THE INFO CARD INVISIBLE AND SETS ANY VISIBLE PROFILE PICTURE'S OPACITY TO 0.

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

    // SPECS CLOSE:
    /*If the user has searched for a pet and the pet's info card has popped up, there is a close button that pops up with it
    * whose actions are controlled by this Handler. */

    private class SpecsClose implements EventHandler<MouseEvent>{
        private Buyable _pet;
        private SpecsClose(Buyable pet){
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

// HANDLER AND TIMELINE SETUP METHODS

    public class Handlers {
        public void setupHandlers(Pet pet) {
            SpecsGetter sg = new SpecsGetter(pet);
            pet.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, sg);
            pet.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, sg);
            pet.getNode().addEventHandler(MouseEvent.MOUSE_EXITED, new SpecsDisappear());
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
        timeline.setCycleCount(2500);
        timeline.play();
    }

    public class PetMoverHelper {
        public void setupPetMover(Pet pet) {
            KeyFrame kf3 = new KeyFrame(Duration.millis(45), new PetMover(pet));
            Timeline timeline = new Timeline(kf3);
            pet.setTimeline(timeline);
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        }
    }

// ACTION EVENTS

    // COUNTER: Increments every millisecond to assist with the timing of the loading bar animation and directive text.

    private class Counter implements EventHandler<ActionEvent>{
        public void handle(ActionEvent event){
            _counter ++;
            if (_counter == 2500){
                _title.getLoadingBar().setOpacity(0);
                _title.getLoadingBG().setOpacity(0);
                _title.getPercentLabel().setOpacity(0);

                if (_counter == 2500) {
                    _title.getPressSpace().setOpacity(1);
                }
            }
        }
    }

    // BALINS: Sets the Balance Insufficient label back to invisible after 1 second.

    private class BalIns implements EventHandler<ActionEvent>{
        public void handle(ActionEvent event){
            _si.getBalIns().setOpacity(0);
        }
    }

    // PETMOVER: Enables Pet bouncing by switching the direction of their movement if a certain Y location is reached. These Y locations
    /* are determined by a getter method called getOYL which sounds for get Original Y Loc. This location is stored as a variable when
    * each pet is instantiated. */

    private class PetMover implements EventHandler<ActionEvent>{
        private Pet thisPet;
        private PetMover(Pet pet){
            thisPet = pet;
        }
        boolean _direction = true;

        public void handle(ActionEvent event){
            if (_direction) {
                thisPet.setBounceLoc(thisPet.getXLoc(), thisPet.getYLoc() + 2);
            } else {
                thisPet.setBounceLoc(thisPet.getXLoc(), thisPet.getYLoc() - 2);
            }

            if (thisPet.getYLoc() < thisPet.getOYL() - 4) {
                _direction = !_direction;
            }

            if (thisPet.getYLoc() > thisPet.getOYL() + 4) {
                _direction = !_direction;
            }
        }
    }

    // TITLEMOVER: Controls the shrinking of the blue background of the Title screen and rotation of title text.

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

    // LOADING BAR FILLER: Animation of Loading Bar and incrementation of Percentage Loaded.

    private class LoadingBarFiller implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            _title.getLoadingBar().setWidth(_title.getLoadingBar().getWidth()+12);
            _intPercent +=4;
            _title.getPercentLabel().setText(_intPercent + "%");
        }
    }

// KEY EVENTS HANDLER

    private class AllKeyEventsHandler implements EventHandler<KeyEvent> {

        // SETUPTITLEBGTIMELINE: called when the Space bar is pressed, sets the Title Background and Title into motion

        public void setupTitleBGTimeline() {
            KeyFrame kf1 = new KeyFrame(Duration.millis(45), new TitleMover());
            Timeline timeline = new Timeline(kf1);
            timeline.setCycleCount(10);
            timeline.play();
        }

        public void handle (KeyEvent event){
            if (event.getCode() == KeyCode.SPACE) {

                // SPACE: sets the title and title background into motion and the opacity of the buttons, initial pets, and Buyables to 1.

                _title.getPressSpace().setOpacity(0);
                if ((_titleNotCompressed) && (_counter == 2500)) {
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

            // LETTERS:
            /* If the user has clicked the Search option and types in letters, the String typed will be stored in the variable
            * searchQuery. If searchQuery is equal to the name of any pet in the array in the garden, the pet's info card
            * and profile picture will become visible. */

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

                                        // Stops the returned info card from disappearing if the user hovers off a pet. Also
                                        // turns on the close button quick allows the user to close the info card.

                                        _pets[i][j].getNode().removeEventHandler(MouseEvent.MOUSE_EXITED, new SpecsDisappear());
                                        _si.setCloseOpacity(1);
                                        _si.getXCN1().addEventHandler(MouseEvent.MOUSE_CLICKED, new SpecsClose(_pets[i][j]));
                                    }
                                }
                            }
                        }
                    }
                }

                // If the user has not clicked the search bar, which would indicate that they are typing in a pet's name,
                // the label for the pet's name is set to the text typed in.

                if (!_searchClicked && !_cannotChangeName) {

                    newName = newName + event.getText();
                    _store.getMyName().setText(newName);
                }
            }

            // NUMBERS: If the user has typed in numbers this would suggest they are entering hours. The label in the Hours Entering Bar is
            // set to the entered text.

            if ((event.getCode() == KeyCode.DIGIT1) || (event.getCode() == KeyCode.DIGIT2) || (event.getCode() == KeyCode.DIGIT3) ||
                    (event.getCode() == KeyCode.DIGIT4) || (event.getCode() == KeyCode.DIGIT5) || (event.getCode() == KeyCode.DIGIT6) ||
                    (event.getCode() == KeyCode.DIGIT7) || (event.getCode() == KeyCode.DIGIT8) || (event.getCode() == KeyCode.DIGIT9) ||
                    (event.getCode() == KeyCode.DIGIT0)) {

                numHours = numHours + event.getText();
                _si.getTypeHours().setText(numHours);
            }
        }
    }

// PET GENERATOR: used to generate the user's first 4 pets randomly.

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

// SPECSHELPER CLASS
    /* The SpecsHelper class contains all the methods that are called in private classes (i.e., EventHandlers). In private classes,
    * "this" cannot be used to call methods which are not defined in the private class and so this helper class must be
    * instantiated as part of the Game constructor so that its methods can be called on an instance of itself within private classes. */

    public class SpecsHelper {

    // ADD BUYABLE METHODS
      /* These methods are called when the user purchases a Buyable. If the user's current balance, stored in intLabel, is greater
      * than or equal to the price of the Buyable, a new version of the Buyable is instantiated, given a random location, and
      * added to the Buyable array in the garden. If the Buyable is a Pet, its bouncing timeline (PetMover) and card info Mouse Handlers
      * (Handlers) are also set up. The user's balance decrements by the Buyable's price. */

        public void addCat(){
            if (intLabel >= _si.getCat().getPrice()) {
                Cat newCat = new Cat(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                newCat.setLoc(sh.petXLoc(), sh.petYLoc());
                _pets[(int) ((newCat.getXLoc() - 110) / 130)][(int) ((newCat.getYLoc() - 290) / 130)] = newCat;
                pmh.setupPetMover(newCat);
                h.setupHandlers(newCat);
                intLabel -= _si.getCat().getPrice();
                _si.getBalance().setText(Integer.toString(intLabel));
            }
            else {
                _si.getBalIns().setOpacity(1);
                sh.setupBalIns();
            }
        }

        public void addChicken(){
            if (intLabel >= _si.getChicken().getPrice()) {
                Chicken newChicken = new Chicken(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                newChicken.setLoc(sh.petXLoc(), sh.petYLoc());
                _pets[(int) ((newChicken.getXLoc() - 110) / 130)][(int) ((newChicken.getYLoc() - 290) / 130)] = newChicken;
                pmh.setupPetMover(newChicken);
                h.setupHandlers(newChicken);
                intLabel -= _si.getChicken().getPrice();
                _si.getBalance().setText(Integer.toString(intLabel));
            }
            else {
                _si.getBalIns().setOpacity(1);
                sh.setupBalIns();
            }
        }
        public void addCow(){
            if (intLabel >= _si.getCow().getPrice()) {
                Cow newCow = new Cow(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                newCow.setLoc(sh.petXLoc(), sh.petYLoc());
                _pets[(int) ((newCow.getXLoc() - 110) / 130)][(int) ((newCow.getYLoc() - 290) / 130)] = newCow;
                pmh.setupPetMover(newCow);
                h.setupHandlers(newCow);
                intLabel -= _si.getCow().getPrice();
                _si.getBalance().setText(Integer.toString(intLabel));
            }
            else {
                _si.getBalIns().setOpacity(1);
                sh.setupBalIns();
            }
        }
        public void addDog(){
            if (intLabel >= _si.getDog().getPrice()) {
                Dog newDog = new Dog(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                newDog.setLoc(sh.petXLoc(), sh.petYLoc());
                _pets[(int) ((newDog.getXLoc() - 110) / 130)][(int) ((newDog.getYLoc() - 290) / 130)] = newDog;
                pmh.setupPetMover(newDog);
                h.setupHandlers(newDog);
                intLabel -= _si.getDog().getPrice();
                _si.getBalance().setText(Integer.toString(intLabel));
            }
            else {
                _si.getBalIns().setOpacity(1);
                sh.setupBalIns();
            }
        }
        public void addFox(){
            if (intLabel >= _si.getFox().getPrice()) {
                Fox newFox = new Fox(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                newFox.setLoc(sh.petXLoc(), sh.petYLoc());
                _pets[(int) ((newFox.getXLoc() - 110) / 130)][(int) ((newFox.getYLoc() - 290) / 130)] = newFox;
                pmh.setupPetMover(newFox);
                h.setupHandlers(newFox);
                intLabel -= _si.getFox().getPrice();
                _si.getBalance().setText(Integer.toString(intLabel));
            }
            else {
                _si.getBalIns().setOpacity(1);
                sh.setupBalIns();
            }
        }
        public void addGiraffe(){
            if (intLabel >= _si.getGiraffe().getPrice()) {
                Giraffe newGiraffe = new Giraffe(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                newGiraffe.setLoc(sh.petXLoc(), sh.petYLoc());
                _pets[(int) ((newGiraffe.getXLoc() - 110) / 130)][(int) ((newGiraffe.getYLoc() - 290) / 130)] = newGiraffe;
                pmh.setupPetMover(newGiraffe);
                h.setupHandlers(newGiraffe);
                intLabel -= _si.getGiraffe().getPrice();
                _si.getBalance().setText(Integer.toString(intLabel));
            }
            else {
                _si.getBalIns().setOpacity(1);
                sh.setupBalIns();
            }
        }
        public void addGnome(){
            if (intLabel >= _si.getGnome().getPrice()) {
                Gnome newGnome = new Gnome(interactPane, _pets);
                newGnome.addToPane();
                newGnome.setLoc(sh.petXLoc(), sh.petYLoc());
                _pets[(int) ((newGnome.getXLoc() - 110) / 130)][(int) ((newGnome.getYLoc() - 290) / 130)] = newGnome;
                intLabel -= _si.getGnome().getPrice();
                _si.getBalance().setText(Integer.toString(intLabel));
            }
            else {
                _si.getBalIns().setOpacity(1);
                sh.setupBalIns();
            }
        }
        public void add_Hat(){
            if (intLabel >= _si.getHat().getPrice()) {
                sh.addHat(sh.generateInt(), sh.generateInt());
                intLabel -= _si.getHat().getPrice();
                _si.getBalance().setText(Integer.toString(intLabel));
            }
            else {
                _si.getBalIns().setOpacity(1);
                sh.setupBalIns();
            }
        }
        public void addHouse(){
            if (intLabel >= _si.getHouse().getPrice()) {
                House newHouse = new House(interactPane, _pets);
                newHouse.addToPane();
                newHouse.setLoc(sh.petXLoc(), sh.petYLoc());
                _pets[(int) ((newHouse.getXLoc() - 110) / 130)][(int) ((newHouse.getYLoc() - 290) / 130)] = newHouse;
                intLabel -= _si.getHouse().getPrice();
                _si.getBalance().setText(Integer.toString(intLabel));
            }
            else {
                _si.getBalIns().setOpacity(1);
                sh.setupBalIns();
            }
        }
        public void addOwl(){
            if (intLabel >= _si.getOwl().getPrice()) {
                Owl newOwl = new Owl(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                newOwl.setLoc(sh.petXLoc(), sh.petYLoc());
                _pets[(int) ((newOwl.getXLoc() - 110) / 130)][(int) ((newOwl.getYLoc() - 290) / 130)] = newOwl;
                pmh.setupPetMover(newOwl);
                h.setupHandlers(newOwl);
                intLabel -= _si.getOwl().getPrice();
                _si.getBalance().setText(Integer.toString(intLabel));
            }
            else {
                _si.getBalIns().setOpacity(1);
                sh.setupBalIns();
            }
        }
        public void addPenguin(){
            if (intLabel >= _si.getPenguin().getPrice()) {
                Penguin newPenguin = new Penguin(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                newPenguin.setLoc(sh.petXLoc(), sh.petYLoc());
                _pets[(int) ((newPenguin.getXLoc() - 110) / 130)][(int) ((newPenguin.getYLoc() - 290) / 130)] = newPenguin;
                pmh.setupPetMover(newPenguin);
                h.setupHandlers(newPenguin);
                intLabel -= _si.getPenguin().getPrice();
                _si.getBalance().setText(Integer.toString(intLabel));
            }
            else {
                _si.getBalIns().setOpacity(1);
                sh.setupBalIns();
            }
        }
        public void addPig(){
            if (intLabel >= _si.getPig().getPrice()) {
                Pig newPig = new Pig(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                newPig.setLoc(sh.petXLoc(), sh.petYLoc());
                _pets[(int) ((newPig.getXLoc() - 110) / 130)][(int) ((newPig.getYLoc() - 290) / 130)] = newPig;
                pmh.setupPetMover(newPig);
                h.setupHandlers(newPig);
                intLabel -= _si.getPig().getPrice();
                _si.getBalance().setText(Integer.toString(intLabel));
            }
            else {
                _si.getBalIns().setOpacity(1);
                sh.setupBalIns();
            }
        }
        public void addPlant(){
            if (intLabel >= _si.getPlant().getPrice()) {
                Plant newPlant = new Plant(interactPane, _pets);
                newPlant.addToPane();
                newPlant.setLoc(sh.petXLoc(), sh.petYLoc());
                _pets[(int) ((newPlant.getXLoc() - 110) / 130)][(int) ((newPlant.getYLoc() - 290) / 130)] = newPlant;
                intLabel -= _si.getPlant().getPrice();
                _si.getBalance().setText(Integer.toString(intLabel));
            }
            else {
                _si.getBalIns().setOpacity(1);
                sh.setupBalIns();
            }
        }
        public void addReindeer(){
            if (intLabel >= _si.getReindeer().getPrice()) {
                Reindeer newReindeer = new Reindeer(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                newReindeer.setLoc(sh.petXLoc(), sh.petYLoc());
                _pets[(int) ((newReindeer.getXLoc() - 110) / 130)][(int) ((newReindeer.getYLoc() - 290) / 130)] = newReindeer;
                pmh.setupPetMover(newReindeer);
                h.setupHandlers(newReindeer);
                intLabel -= _si.getReindeer().getPrice();
                _si.getBalance().setText(Integer.toString(intLabel));
            }
            else {
                _si.getBalIns().setOpacity(1);
                sh.setupBalIns();
            }
        }
        public void addSheep(){
            if (intLabel >= _si.getSheep().getPrice()) {
                Sheep newSheep = new Sheep(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                newSheep.setLoc(sh.petXLoc(), sh.petYLoc());
                _pets[(int) ((newSheep.getXLoc() - 110) / 130)][(int) ((newSheep.getYLoc() - 290) / 130)] = newSheep;
                pmh.setupPetMover(newSheep);
                h.setupHandlers(newSheep);
                intLabel -= _si.getSheep().getPrice();
                _si.getBalance().setText(Integer.toString(intLabel));
            }
            else {
                _si.getBalIns().setOpacity(1);
                sh.setupBalIns();
            }
        }
        public void addSunsetBG(){
            if (intLabel >= _si.getSunsetBG().getPrice()) {
                Stop[] stops = new Stop[]{new Stop(0, Color.DEEPSKYBLUE), new Stop(1, Color.PINK)};
                LinearGradient lg1 = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);

                _garden.getSky().setFill(lg1);
                intLabel -= _si.getSunsetBG().getPrice();
                _si.getBalance().setText(Integer.toString(intLabel));
            }
            else {
                _si.getBalIns().setOpacity(1);
                sh.setupBalIns();
            }
        }
        public void addTiger(){
            if (intLabel >= _si.getTiger().getPrice()) {
                Tiger newTiger = new Tiger(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                newTiger.setLoc(sh.petXLoc(), sh.petYLoc());
                _pets[(int) ((newTiger.getXLoc() - 110) / 130)][(int) ((newTiger.getYLoc() - 290) / 130)] = newTiger;
                pmh.setupPetMover(newTiger);
                h.setupHandlers(newTiger);
                intLabel -= _si.getTiger().getPrice();
                _si.getBalance().setText(Integer.toString(intLabel));
            }
            else {
                _si.getBalIns().setOpacity(1);
                sh.setupBalIns();
            }
        }
        public void addWalrus(){
            if (intLabel >= _si.getWalrus().getPrice()) {
                Walrus newWalrus = new Walrus(interactPane, _pets, "Type+CLICK to name", sh.getPersonality(), sh.getBirthMonth(), sh.getFavFood());
                newWalrus.setLoc(sh.petXLoc(), sh.petYLoc());
                _pets[(int) ((newWalrus.getXLoc() - 110) / 130)][(int) ((newWalrus.getYLoc() - 290) / 130)] = newWalrus;
                pmh.setupPetMover(newWalrus);
                h.setupHandlers(newWalrus);
                intLabel -= _si.getWalrus().getPrice();
                _si.getBalance().setText(Integer.toString(intLabel));
            }
            else {
                _si.getBalIns().setOpacity(1);
                sh.setupBalIns();
            }
        }

        // LOC GENERATORS:
        /* These methods are called to generate a semi-random location for any pet that is added to the Buyable array.
        * The location must be semi-randomly so that the pets can line up nicely. */

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

        // PET INFO RANDOM GENERATORS

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

        // METHOD USED TO GENERATE A RANDOM ARRAY LOCATION ON WHICH TO ADD THE HAT IF IT IS PURCHASED.

        public int generateInt(){
            int i = 0;
            int rand_int = (int) (Math.random() * 4);
            switch (rand_int){
                case 0:
                    i = 0;
                    break;
                case 1:
                    i = 1;
                    break;
                case 2:
                    i = 2;
                    break;
                default:
                    i = 3;
                    break;
            }
            return i;
        }

        // HAT ADDER
        /* This method takes a randomly generated array location in which to add the Hat if it is purchased. If the location is
        * null or filled with a Buyable that is not a Pet, the method will recurse until a valid array location is found. */

        public void addHat(int i, int j) {
                if (_pets[i][j] != null && ((_pets[i][j].getType().equals("Cat")) || (_pets[i][j].getType().equals("Chicken")) ||
                        (_pets[i][j].getType().equals("Cow")) || (_pets[i][j].getType().equals("Dog")) ||
                        (_pets[i][j].getType().equals("Fox")) || (_pets[i][j].getType().equals("Giraffe")) ||
                        (_pets[i][j].getType().equals("Owl")) || (_pets[i][j].getType().equals("Penguin")) ||
                        (_pets[i][j].getType().equals("Reindeer")) || (_pets[i][j].getType().equals("Sheep")) ||
                        (_pets[i][j].getType().equals("Tiger")) || (_pets[i][j].getType().equals("Walrus")))) {
                    _pets[i][j].addHat(_pets[i][j].getXLoc(), _pets[i][j].getYLoc());
                } else {
                    this.addHat(this.generateInt(), this.generateInt());
                }
        }

        // SETS UP THE "BALANCE INSUFFICIENT" LABEL TIMELINE WHICH REMOVES THE LABEL AFTER 1 SECOND.

        public void setupBalIns(){
            KeyFrame kf100 = new KeyFrame(Duration.seconds(1), new BalIns());
            Timeline timeline = new Timeline(kf100);
            timeline.setCycleCount(1);
            timeline.play();
        }

        // RETURNS TRUE IF THE BUYABLE ARRAY IN THE GARDEN IS FULL.

        public boolean isFull(){
            return (_pets[0][0] != null) && (_pets[0][1] != null) && (_pets[0][2] != null) && (_pets[0][3] != null) && (_pets[1][0] != null) &&
                    (_pets[1][1] != null) && (_pets[1][2] != null) && (_pets[1][3] != null) && (_pets[2][0] != null) && (_pets[2][1] != null) &&
                    (_pets[2][2] != null) && (_pets[2][3] != null) && (_pets[3][0] != null) && (_pets[3][1] != null) && (_pets[3][2] != null) &&
                    (_pets[3][3] != null);
        }
    }
}
