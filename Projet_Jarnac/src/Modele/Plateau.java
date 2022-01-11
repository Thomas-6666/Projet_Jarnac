package Modele;

import java.util.ArrayList;
import java.util.List;

public class Plateau {

    public List<String> mot;
    public Joueur joueur;

    public Plateau(){
       List<String> M = new ArrayList<>();
    }

    public void ajouterMot(String m){
        mot.add(m);
    }


    public void jarnac(){
        joueur.crierJarnac();
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public List<String> getMot() {
        return mot;
    }
}
