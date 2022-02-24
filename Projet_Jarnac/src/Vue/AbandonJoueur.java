package Vue;

import Controlleur.Controller;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AbandonJoueur extends Stage {
    public AbandonJoueur(Stage primaryStage, String current, String other) {
        super();
        Controller c = Controller.getInstance();
        c.setStage(primaryStage);
        this.initModality(Modality.APPLICATION_MODAL);
        this.initOwner(primaryStage);
        VBox nom = new VBox(20);
        Label label = new Label(current + " a perdu par abandon.");
        Label label2 = new Label(other + " a gagné !");
        Button valider = new Button("OK");
        valider.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                fermer();
            }
        });
        nom.getChildren().addAll(label, label2, valider);
        Scene dialogScene = new Scene(nom);
        this.setScene(dialogScene);
        this.show();
    }

    public void fermer(){
        this.close();
    }
}