package Vue;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Regles extends Stage{
    private String regle;

    public Regles(Stage primaryStage){
        super();
        regle = "Règles du Jarnac :\n\n" +
                "Premier tour\n" +
                "Le premier joueur reçoit 6 lettres. Il cherche alors à composer un mot d'au moins 3 lettres qui sera\n" +
                "placé sur la première ligne de son tapis. S'il réussit, il obtients une lettre supplémentaire et,\n" +
                "au choix, compléter son premier mot ou ouvrir la deuxième ligne. Il continue ainsi jusqu'à ne plus\n" +
                "pouvoir modifier son plateau. Le tour passe à son adversaire qui obtient à son tour 6\n" +
                "lettres et agit de même.\n" +
                "\n" +
                "Au moment où le joueur passe son tour, l'adversaire peut déclarer Jarnac ! s'il a trouvé un mot oublié\n" +
                "par celui qui passe son tour. Dans ce cas, il prend le mot qu'il a trouvé et le place sur son plateau.\n" +
                "Il peut éventuellement prendre ainsi plusieurs mots. Puis il joue normalement. Cette règle est\n" +
                "l'explication du nom du jeu, et sa principale particularité, celle qui fait son intérêt.\n" +
                "\n" +
                "Tours suivants\n" +
                "L'alternance de jeu se poursuit mais le joueur ne pouvant pas jouer a un choix entre deux actions :\n" +
                "tirer une nouvelle lettre ou échanger trois lettres non utilisées de son plateau.\n" +
                "\n" +
                "Fin de partie\n" +
                "Le jeu s'arrête quand l'un des joueurs a atteint la huitième ligne de son plateau, ne trouve plus à\n" +
                "compléter ses mots, et que son adversaire ne déclare pas Jarnac !.\n" +
                "\n" +
                "On établit alors le score de chacun en attribuant à chaque mot une valeur égale au carré de son nombre\n" +
                "de lettres, donc au maximum 81 points pour un mot de 9 lettres ; et 567 points (7 fois 81 points) plus\n" +
                "les points du dernier mot posé de score maximal pour un plateau plein.\n" +
                "\n" +
                "Coup de Jarnac\n" +
                "L'intérêt du jeu et la source de nombreux rebondissements est la possibilité offerte à l'adversaire de\n" +
                "s'emparer d'un mot que le joueur n'a pas vu quand il passe la main.\n";

        this.initModality(Modality.APPLICATION_MODAL);
        this.initOwner(primaryStage);
        VBox rules = new VBox(20);
        Label label = new Label(regle);
        rules.getChildren().addAll(label);
        Scene dialogScene = new Scene(rules);
        this.setScene(dialogScene);
        this.show();
    }
}
