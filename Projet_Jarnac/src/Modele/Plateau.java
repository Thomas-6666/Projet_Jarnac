package Modele;

import java.util.ArrayList;
import java.util.List;

public class Plateau {

    public List<BaseDeDonnee> mot;
    public Joueur joueur;

    public Plateau(){
       List<BaseDeDonnee> M = new ArrayList<>();
    }

    public void ajouterMot(){
        joueur.jouer(mot);
    }


    public void jarnac(){

    }


}
