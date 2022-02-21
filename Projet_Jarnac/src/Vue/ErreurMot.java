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

public class ErreurMot extends Stage {
    public ErreurMot(Stage primaryStage) {
        super();
        Controller c = Controller.getInstance();
        c.setStage(primaryStage);
        this.initModality(Modality.APPLICATION_MODAL);
        this.initOwner(primaryStage);
        VBox nom = new VBox(20);
        Label label = new Label("Erreur : Mot invalide ou inexistant");
        Button valider = new Button("OK");
        valider.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                fermer();
            }
        });
        nom.getChildren().addAll(label, valider);
        Scene dialogScene = new Scene(nom);
        this.setScene(dialogScene);
        this.show();
    }

    public void fermer(){
        this.close();
    }
}
