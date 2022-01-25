package Vue;

import Modele.*;

public class View {
    public void afficherPartie(Joueur j1, Joueur j2, Reserve r, Partie p, Plateau pl1, Plateau pl2){
        System.out.print(
                "Partie :\n" +
                j1.toString() + "\n" +
                "Score : "+ pl1.compterScore() + "\n"
        );
        p.afficherPlateau(j1);
        System.out.print(
                j2.toString() + "\n" +
                pl2.compterScore() + "\n"
        );
        p.afficherPlateau(j2);
        System.out.print("\n" + r.toString());
    }

    public void afficherRegles(){
        System.out.print(
                "Règles du Jarnac :\n" +
                "Premier tour\n" +
                "Le premier joueur reçoit 6 lettres. Il cherche alors à composer un mot d'au moins 3 lettres qu'il\n" +
                "place sur la première ligne de son tapis. S'il réussit, il peut tirer une lettre supplémentaire et,\n" +
                "au choix, compléter son premier mot ou ouvrir la deuxième ligne. Il continue ainsi jusqu'à ne plus\n" +
                "pouvoir modifier son tapis. Il donne alors le sac opaque à son adversaire qui y pioche à son tour 6\n" +
                "lettres et agit de même.\n" +
                "\n" +
                "Au moment où le joueur passe son tour, l'adversaire peut déclarer Jarnac ! s'il a trouvé un mot oublié\n" +
                "par celui qui passe son tour. Dans ce cas, il prend le mot qu'il a trouvé et le place sur sa grille.\n" +
                "Il peut éventuellement prendre ainsi plusieurs mots. Puis il joue normalement. Cette règle est\n" +
                "l'explication du nom du jeu, et sa principale particularité, celle qui fait son intérêt.\n" +
                "\n" +
                "Tours suivants\n" +
                "L'alternance de jeu se poursuit mais le joueur qui reçoit le sac opaque a le choix entre deux actions :\n" +
                "tirer une nouvelle lettre ou échanger trois lettres non utilisées de son tapis.\n" +
                "\n" +
                "Fin de partie\n" +
                "Le jeu s'arrête quand l'un des joueurs a atteint la huitième ligne de son tapis, ne trouve plus à\n" +
                "compléter ses mots, et que son adversaire ne déclare pas Jarnac !.\n" +
                "\n" +
                "On établit alors le score de chacun en attribuant à chaque mot une valeur égale au carré de son nombre\n" +
                "de lettres, donc au maximum 81 points pour un mot de 9 lettres ; et 567 points (7 fois 81 points) plus\n" +
                "les points du dernier mot posé de score maximal pour une grille pleine .\n" +
                "\n" +
                "Coup de Jarnac\n" +
                "L'intérêt du jeu et la source de nombreux rebondissements est la possibilité offerte à l'adversaire de\n" +
                "s'emparer d'un mot que le joueur n'a pas vu quand il passe la main.\n"
        );
    }

    public void afficherResultat(Partie p){
        p.annoncerGagnant();
    }
}
