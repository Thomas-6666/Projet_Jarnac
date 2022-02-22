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

public class Echange extends Stage {
    public Echange(Stage primaryStage, Joueur j) {
        super();
        Controller c = Controller.getInstance();
        c.setStage(primaryStage);
        this.initModality(Modality.APPLICATION_MODAL);
        this.initOwner(primaryStage);
        VBox echanger = new VBox(20);
        TextField input = new TextField();
        input.setId("LettreEchange");
        Label label = new Label("Saisir les 3 lettres à échanger: ");
        Button valider = new Button("Valider");
        valider.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (j.echangerLettre(input.getText())){
                    Partie.getInstance().getCurrentPlayer().setFirstChoice(false);
                    fermer();
                }
            }
        });
        echanger.getChildren().addAll(label, input, valider);
        Scene dialogScene = new Scene(echanger, 300, 125);
        this.setScene(dialogScene);
        this.show();
    }

    public void fermer(){
        this.close();
    }
}
