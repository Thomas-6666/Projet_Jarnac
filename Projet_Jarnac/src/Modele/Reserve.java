package Modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Reserve {
    private ArrayList<String> lettre;

    public Reserve() { //Ce constructeur permet l'implémentation des lettres de l'alphabet dans la liste
        lettre = new ArrayList();

        //Chaque boucle va ajouter n fois une lettre en fonction de sa quantité dans le jeu
        for (int i = 0; i < 14; i++) {
            ajouterLettre("A");
        }
        for (int i = 0; i < 4; i++) {
            ajouterLettre("B");
        }
        for (int i = 0; i < 6; i++) {
            ajouterLettre("C");
        }
        for (int i = 0; i < 5; i++) {
            ajouterLettre("D");
        }
        for (int i = 0; i < 19; i++) {
            ajouterLettre("E");
        }
        for (int i = 0; i < 2; i++) {
            ajouterLettre("F");
        }
        for (int i = 0; i < 4; i++) {
            ajouterLettre("G");
        }
        for (int i = 0; i < 2; i++) {
            ajouterLettre("H");
        }
        for (int i = 0; i < 10; i++) {
            ajouterLettre("I");
        }
        for (int i = 0; i < 1; i++) {
            ajouterLettre("J");
        }
        for (int i = 0; i < 1; i++) {
            ajouterLettre("K");
        }
        for (int i = 0; i < 4; i++) {
            ajouterLettre("L");
        }
        for (int i = 0; i < 4; i++) {
            ajouterLettre("M");
        }
        for (int i = 0; i < 10; i++) {
            ajouterLettre("N");
        }
        for (int i = 0; i < 9; i++) {
            ajouterLettre("O");
        }
        for (int i = 0; i < 4; i++) {
            ajouterLettre("P");
        }
        for (int i = 0; i < 2; i++) {
            ajouterLettre("Q");
        }
        for (int i = 0; i < 10; i++) {
            ajouterLettre("R");
        }
        for (int i = 0; i < 10; i++) {
            ajouterLettre("S");
        }
        for (int i = 0; i < 10; i++) {
            ajouterLettre("T");
        }
        for (int i = 0; i < 6; i++) {
            ajouterLettre("U");
        }
        for (int i = 0; i < 2; i++) {
            ajouterLettre("V");
        }
        for (int i = 0; i < 1; i++) {
            ajouterLettre("W");
        }
        for (int i = 0; i < 1; i++) {
            ajouterLettre("X");
        }
        for (int i = 0; i < 1; i++) {
            ajouterLettre("Y");
        }
        for (int i = 0; i < 2; i++) {
            ajouterLettre("Z");
        }
        Collections.shuffle(lettre);
    }

    //constructeur réserve des joueurs (vide)
    public Reserve(Joueur j) {
        lettre = new ArrayList<>();

    }

    //Cette méthode permet d'afficher les lettres que le joueurs possède
    public String toString() {
        String string = "Taille de la reserve : " + lettre.size();
        string += "\n[";
        for (int i = 0; i < lettre.size() - 1; i++) {
            string += lettre.get(i) + ",";
        }
        string += lettre.get(lettre.size() - 1);
        string += "]";
        return string;
    }

    //pioche une lettre aléatoire dans la réserve
    public String piocher() {
        int r = new Random().nextInt(lettre.size());
        String l = lettre.get(r);
        remove(l);
        return l;
    }

    public void remove(String l) {
        lettre.remove(l);
    }

    public void ajouterLettre(String l) {
        lettre.add(l);
    }

    public int size() {
        return lettre.size();
    }

    public List<String> getLettres() {
        return lettre;
    }

    public void setLettre(ArrayList<String> l) {
        lettre = l;
    }

    public boolean contains(List<String> str) {
        for (int i = 0; i < str.size(); i++) {
            if (lettre.contains(str.get(i))) {
                return true;
            }
        }

        return false;
    }

    public void clear(){
        lettre.clear();
    }
}
