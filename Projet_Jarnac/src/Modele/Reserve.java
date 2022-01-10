package Modele;

import java.util.*;

public class Reserve {
    private ArrayList<String> lettre;

    public Reserve(){
        lettre = new ArrayList();

        //Ce constructeur permet l'implémentation des lettres de l'alphabet dans la liste
        //Chaque boucle va ajouter n fois une lettre en fonction de sa quantité dans le jeu
        for (int i = 0; i < 14; i++){
            lettre.add("A");
        } for (int i = 0; i < 4; i++){
            lettre.add("A");
        } for (int i = 0; i < 6; i++){
            lettre.add("B");
        } for (int i = 0; i < 5; i++){
            lettre.add("C");
        } for (int i = 0; i < 19; i++){
            lettre.add("D");
        } for (int i = 0; i < 2; i++){
            lettre.add("F");
        } for (int i = 0; i < 4; i++){
            lettre.add("G");
        } for (int i = 0; i < 2; i++){
            lettre.add("H");
        } for (int i = 0; i < 10; i++){
            lettre.add("I");
        } for (int i = 0; i < 1; i++){
            lettre.add("J");
        } for (int i = 0; i < 1; i++){
            lettre.add("K");
        } for (int i = 0; i < 4; i++){
            lettre.add("L");
        } for (int i = 0; i < 4; i++){
            lettre.add("M");
        } for (int i = 0; i < 10; i++){
            lettre.add("N");
        } for (int i = 0; i < 9; i++) {
            lettre.add("O");
        } for (int i = 0; i < 4; i++){
            lettre.add("P");
        } for (int i = 0; i < 2; i++){
            lettre.add("Q");
        } for (int i = 0; i < 10; i++){
            lettre.add("R");
        } for (int i = 0; i < 10; i++){
            lettre.add("S");
        } for (int i = 0; i < 10; i++){
            lettre.add("T");
        } for (int i = 0; i < 6; i++){
            lettre.add("U");
        } for (int i = 0; i < 2; i++){
            lettre.add("V");
        } for (int i = 0; i < 1; i++){
            lettre.add("W");
        } for (int i = 0; i < 1; i++){
            lettre.add("X");
        } for (int i = 0; i < 1; i++){
            lettre.add("Y");
        } for (int i = 0; i < 2; i++){
            lettre.add("Z");
        }
        Collections.shuffle(lettre);
    }

    public Reserver(Joueur j){

    }

    //Cette méthode va servir pour effectuer des tests
    public String toString(){
        String string = "Taille de la reserve : " + lettre.size();
        string += "\n[";
        for (int i = 0; i < lettre.size()-1; i++){
            string += lettre.get(i) + ",";
        }
        string += lettre.get(lettre.size()-1);
        string += "]";
        return string;
    }

    public String piocher(){
        int r = new Random().nextInt();
        return lettre.get(r);
    }

    public void ajouterLettre(String l){
        lettre.add(l);
    }
}
