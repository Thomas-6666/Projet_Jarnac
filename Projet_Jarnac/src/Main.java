import Controlleur.Controller;
import Modele.Partie;
import Vue.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            Scene scene = new FXMLLoader(getClass().getResource("Interface.fxml")).load();
            primaryStage.setTitle("Jarnac");
            primaryStage.setScene(scene);
            primaryStage.show();

            new Vue.Popup(primaryStage, 1);

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void main(String[] args) {
        Controlleur.Controller ctrl = Controller.getInstance();
        ctrl.initialize();
        ctrl.AppelRegles(new View());
        launch(args);

        Partie p = new Partie();
    }
}
