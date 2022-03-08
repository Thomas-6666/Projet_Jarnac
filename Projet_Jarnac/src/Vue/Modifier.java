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

public class Modifier extends Stage {

    private Joueur j;

    public Modifier(Stage primaryStage, Joueur joueur){
        super();
        j = joueur;
        Controller c = Controller.getInstance();
        c.setStage(primaryStage);
        this.initModality(Modality.APPLICATION_MODAL);
        this.initOwner(primaryStage);
        VBox modifier = new VBox(20);
        TextField input = new TextField();
        input.setId("ligneModif");
        Label label = new Label("Saisir le numéro de la ligne à modifier: ");
        Button valider = new Button("Valider");
        valider.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String num = input.getText().replaceAll("[^0-9]", "");
                if (!num.equals("")) {
                    int ligne = Integer.parseInt(num);
                    if ((ligne > 0 && ligne < 9) && ligne <= j.getPlateau().getMot().size()) {
                        new ModifierMot(primaryStage, ligne, j);
                        fermer();
                    }
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
