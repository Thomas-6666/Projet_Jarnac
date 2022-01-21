import Controlleur.Controller;
import Modele.Partie;
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
            Controlleur.Controller ctrl = new Controller();
            Scene scene = new FXMLLoader(getClass().getResource("Interface.fxml")).load();
            ctrl.initialize();
            primaryStage.setTitle("Jarnac");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void main(String[] args) {
        //Ca va faire une erreur si vous retirez les commentaires ici, faut que je fixe ça la prochaine fois
        launch(args);

        Partie p = new Partie();
    }
}
