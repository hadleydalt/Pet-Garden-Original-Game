package indy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * It's time for Indy! This is the main class to get things started.
 *
 * Class comments here...
 *
 */

public class App extends Application {

    @Override
    public void start(Stage stage) {
        PaneOrganizer organizer = new PaneOrganizer();
        stage.setTitle("Pet Garden");
        stage.show();
        Scene scene = new Scene(organizer.getRoot(), 1440, 800);
        stage.setScene(scene);
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args); // launch is a method inherited from Application
    }
}
