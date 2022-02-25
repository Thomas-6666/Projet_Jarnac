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

public class Victoire extends Stage {
    public Victoire(Stage primaryStage, String current, String other) {
        super();
        Controller c = Controller.getInstance();
        c.setStage(primaryStage);
        this.initModality(Modality.APPLICATION_MODAL);
        this.initOwner(primaryStage);
        VBox nom = new VBox(20);
        Label label = new Label("Fin de la partie !");
        Label label1 = new Label(current + " a perdu.");
        Label label2 = new Label(other + " a gagné !");
        Button restart = new Button("Recommencer");
        Button findujeu = new Button("Fermer le jeu");
        restart.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                c.restart();
            }
        });
        findujeu.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                primaryStage.close();
            }
        });
        nom.getChildren().addAll(label, label1, label2, restart, findujeu);
        Scene dialogScene = new Scene(nom);
        this.setScene(dialogScene);
        this.show();
    }
}