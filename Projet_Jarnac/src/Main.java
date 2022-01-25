import Controlleur.Controller;
import Modele.Partie;
import Vue.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            Scene scene = new FXMLLoader(getClass().getResource("Interface.fxml")).load();
            primaryStage.setTitle("Jarnac");
            primaryStage.setScene(scene);
            primaryStage.show();
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
