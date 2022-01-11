package Modele;

import java.util.ArrayList;
import java.util.List;

public class Plateau {

    public List<String> mot;
    public Joueur joueur;

    public Plateau(){
       mot = new ArrayList<>();
    }

    public boolean ajouterMot(String m){
        //verifier dans la BDD si mot valable avant ajouter
        mot.add(m);
        return true;
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
