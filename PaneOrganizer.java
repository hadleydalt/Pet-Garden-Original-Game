package indy;

import javafx.scene.layout.BorderPane;

public class PaneOrganizer {
    private BorderPane _root;

    public PaneOrganizer(){
        _root = new BorderPane();
        Game game = new Game();
        _root.setStyle("-fx-background-color: aliceblue;");
        _root.getChildren().addAll(game.getGardenPane(), game.getStorePane(), game.getPetPane(),
                game.getTitlePane(), game.getButtonPane());
    }

    public BorderPane getRoot(){
        return _root;
    }
}
