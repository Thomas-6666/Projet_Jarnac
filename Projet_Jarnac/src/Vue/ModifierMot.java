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

import java.util.List;

public class ModifierMot extends Stage {

    public ModifierMot(Stage primaryStage, int ligne){
        super();
        Controller c = Controller.getInstance();
        c.setStage(primaryStage);
        this.initModality(Modality.APPLICATION_MODAL);
        this.initOwner(primaryStage);
        VBox modifier = new VBox(20);
        TextField input = new TextField();
        input.setId("ligneModif");
        Label label = new Label("Saisir le nouveau mot: ");
        Button valider = new Button("Valider");
        valider.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String mot = input.getText();
                if (c.modifierMot(ligne, mot)){
                    c.updatePoints(Partie.getInstance());
                    Joueur j = Partie.getInstance().getCurrentPlayer();
                    List<Joueur> joueurs = Partie.getInstance().getJoueurs();
                    int i;
                    if (j == joueurs.get(0)){
                        i = 1;
                    } else {
                        i = 2;
                    }
                    c.updatePlateau(i);
                    c.updateReserve(Partie.getInstance());
                    fermer();
                }
            }
        });
        modifier.getChildren().addAll(label, input, valider);
        Scene dialogScene = new Scene(modifier, 300, 125);
        this.setScene(dialogScene);
        this.show();
    }

    public void fermer(){
        this.close();
    }
}
