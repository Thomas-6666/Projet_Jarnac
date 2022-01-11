package Modele;

import java.util.ArrayList;
import java.util.List;

public class Plateau {

    public List<String> mot;
    public Joueur joueur;
    private BaseDeDonnee BDD;

    public Plateau(BaseDeDonnee DB){
       mot = new ArrayList<>();
       BDD = DB;

    }

    public boolean ajouterMot(String m){
        if (BDD.verification(m)){
            mot.add(m);
            return true;
        } else {
            return false;
        }

    }


    public void jarnac(){
        //joueur.crierJarnac();
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public List<String> getMot() {
        return mot;
    }
}
