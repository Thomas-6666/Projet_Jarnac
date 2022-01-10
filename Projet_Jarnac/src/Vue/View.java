package Vue;

public class View {
    public void afficherPartie(){

    }

    public void afficherRegles(){
        System.out.print("Premier tour\n" +
                "Le premier joueur reçoit 6 lettres. Il cherche alors à composer un mot d'au moins 3 lettres qu'il" +
                "place sur la première ligne de son tapis. S'il réussit, il peut tirer une lettre supplémentaire et," +
                "au choix, compléter son premier mot ou ouvrir la deuxième ligne. Il continue ainsi jusqu'à ne plus" +
                "pouvoir modifier son tapis. Il donne alors le sac opaque à son adversaire qui y pioche à son tour 6" +
                "lettres et agit de même.\n" +
                "\n" +
                "Au moment où le joueur passe son tour, l'adversaire peut déclarer Jarnac ! s'il a trouvé un mot oublié" +
                "par celui qui passe son tour. Dans ce cas, il prend le mot qu'il a trouvé et le place sur sa grille." +
                "Il peut éventuellement prendre ainsi plusieurs mots. Puis il joue normalement. Cette règle est" +
                "l'explication du nom du jeu, et sa principale particularité, celle qui fait son intérêt.\n" +
                "\n" +
                "Tours suivants\n" +
                "L'alternance de jeu se poursuit mais le joueur qui reçoit le sac opaque a le choix entre deux actions :" +
                "tirer une nouvelle lettre ou échanger trois lettres non utilisées de son tapis.\n" +
                "\n" +
                "Fin de partie\n" +
                "Le jeu s'arrête quand l'un des joueurs a atteint la huitième ligne de son tapis, ne trouve plus à" +
                "compléter ses mots, et que son adversaire ne déclare pas Jarnac !.\n" +
                "\n" +
                "On établit alors le score de chacun en attribuant à chaque mot une valeur égale au carré de son nombre" +
                "de lettres, donc au maximum 81 points pour un mot de 9 lettres ; et 567 points (7 fois 81 points) plus" +
                "les points du dernier mot posé de score maximal pour une grille pleine .\n" +
                "\n" +
                "Coup de Jarnac\n" +
                "L'intérêt du jeu et la source de nombreux rebondissements est la possibilité offerte à l'adversaire de" +
                "s'emparer d'un mot que le joueur n'a pas vu quand il passe la main.");
    }

    public void afficherResultat(){

    }
}
