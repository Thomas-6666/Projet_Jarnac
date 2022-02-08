package Vue;

import Controlleur.Controller;
import Modele.Joueur;
import Modele.Partie;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Popup extends Stage {
    public Popup(Stage primaryStage, int j) {
        super();
        Controller c = Controller.getInstance();
        c.setStage(primaryStage);
        this.initModality(Modality.APPLICATION_MODAL);
        this.initOwner(primaryStage);
        VBox nom = new VBox(20);
        TextField input = new TextField();
        input.setId("inputj1");
        Label label = new Label("Insérer nom joueur " + j);
        Button valider = new Button("Valider");
        valider.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Controller ctrl = Controller.getInstance();
                if(ctrl.Recup(input.getText(), j)){
                    if (j == 1){
                        fermer();
                        new Popup(primaryStage, 2);
                    } else if (j == 2){
                        fermer();
                        Partie.getInstance().lancer();
                    }
                }
            }
        });
        nom.getChildren().addAll(label, input, valider);
        Scene dialogScene = new Scene(nom, 300, 125);
        this.setScene(dialogScene);
        this.show();
    }

    public void fermer(){
        this.close();
    }
}
