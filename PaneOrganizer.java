package indy;

import javafx.scene.layout.BorderPane;

// establishes the Root, a BorderPane, sets the background, and adds the main Panes.

public class PaneOrganizer {
    private BorderPane _root;

    public PaneOrganizer(){
        _root = new BorderPane();
        Game game = new Game();
        _root.setStyle("-fx-background-color: aliceblue;");
        _root.getChildren().addAll(game.getGardenPane(), game.getStorePane(),
                game.getInteractPane());
    }

    public BorderPane getRoot(){
        return _root;
    }
}
