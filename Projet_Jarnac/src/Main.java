import Controlleur.Controller;
import Modele.Partie;
import Vue.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.text.*;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            Scene scene = new FXMLLoader(getClass().getResource("Interface.fxml")).load();
            primaryStage.setTitle("Jarnac");
            primaryStage.setScene(scene);
            primaryStage.show();

            final Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(primaryStage);
            VBox dialogVbox = new VBox(20);
            dialogVbox.getChildren().add(new Text("Insérer nom du Joueur 1"));
            Scene dialogScene = new Scene(dialogVbox, 300, 200);
            dialog.setScene(dialogScene);
            dialog.show();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void main(String[] args) {
        Controlleur.Controller ctrl = new Controller();
        ctrl.initialize();
        ctrl.AppelRegles(new View());
        launch(args);

        Partie p = new Partie();
    }
}
