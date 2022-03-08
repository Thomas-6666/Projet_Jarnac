package Modele;

import java.util.ArrayList;
import java.util.List;

public class Plateau {

    public List<String> mot;
    public Joueur joueur;
    private BaseDeDonnee BDD;

    public Plateau(Joueur j) {
        mot = new ArrayList<>();
        BDD = BaseDeDonnee.getInstance();
        joueur = j;

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

    public int compterScore(){
        int score = 0;
        for (String curmot : mot){
            score += curmot.length() * curmot.length();
        }
        return score;
    }


    public void jarnac() {
        joueur.crierJarnac();
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public List<String> getMot() {
        return mot;
    }

    public List<String> getMotEspace(){
        List<String> mots = new ArrayList<>();
        for(String curmot : mot){
            StringBuilder motespace = new StringBuilder();
            for(char lettre : curmot.toCharArray()){
                motespace.append(lettre);
                motespace.append("\t");
            }
            motespace.substring(0,motespace.length()-3);
            mots.add(motespace.toString());
        }
        if (mots.size() < 8){
            for (int i = 0; i < 8 - mot.size(); i++){
                mots.add("");
            }
        }
        return mots;
    }

    public void setMot(List<String> mot) {
        this.mot = mot;
    }

    public String retirerLast(){
        String res = mot.get(mot.size()-1);
        mot.remove(mot.size()-1);
        return res;
    }
}
