package Modele;

import java.util.ArrayList;
import java.util.List;

public class Plateau {

    public List<String> mot;
    public Joueur joueur;
    private BaseDeDonnee BDD;

    public Plateau(BaseDeDonnee DB) {
        mot = new ArrayList<>();
        BDD = DB;

    }

    public boolean ajouterMot(String m) {
        if (BDD.verification(m)) {
            mot.add(m);
            joueur.setScore(compterScore());
            if (mot.size() == 8){
                joueur.getPartie().annoncerGagnant();
            }
            return true;
        } else {
            return false;
        }

    }

    private int compterScore(){
        int score = 0;
        for (String curmot : mot){
            score += curmot.length() * curmot.length();
        }
        return score;
    }


    public void jarnac() {
        //joueur.crierJarnac();
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public List<String> getMot() {
        return mot;
    }
}
