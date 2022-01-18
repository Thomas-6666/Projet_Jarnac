package Modele;

import java.util.*;

public class Reserve {
    private ArrayList<String> lettre;
    private List<String> voyelles = Arrays.asList("A","E","I","O","U", "Y");
    private List<String> consonnes = Arrays.asList("B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "V", "W", "X", "Z");

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

    public String piocherVoyelle() {
        String l = ".";
        while (!remove(l)){
            int r = new Random().nextInt(voyelles.size());
            l = voyelles.get(r);
        }
        return l;
    }

    public String piocherConsonne() {
        String l = ".";
        while (!remove(l)){
            int r = new Random().nextInt(consonnes.size());
            l = consonnes.get(r);
        }
        return l;
    }

    public boolean remove(String l) {
        if (lettre.contains(l)){
            lettre.remove(l);
            return true;
        } else {
            return false;
        }
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

    public boolean containsVoyelle(){
        for (String voyelle : voyelles){
            if (lettre.contains(voyelle)){
                return true;
            }
        }
        return false;
    }

    public boolean containsConsonne(){
        for (String consonne : consonnes){
            if (lettre.contains(consonne)){
                return true;
            }
        }
        return false;
    }
}
