import Controlleur.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    public static void main(String[] args) {
        Controlleur.Controller ctrl = Controller.getInstance();
        ctrl.initialize();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface.fxml"));
            loader.setController(Controller.getInstance());
            Scene scene = loader.load();
            primaryStage.setTitle("Jarnac");
            primaryStage.setScene(scene);
            primaryStage.setScene(scene);
            primaryStage.show();
            Controller.getInstance().initplateau();

            new Vue.Popup(primaryStage, 1);
            Controller.getInstance().startMusic();

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

}
