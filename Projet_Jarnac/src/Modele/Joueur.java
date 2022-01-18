package Modele;

import java.util.ArrayList;
import java.util.Locale;

public class Joueur {
    private String nom;
    private int score = 0;
    private Reserve reserve;
    private Partie partie;
    private Plateau plateau;

    public Joueur(String n, Partie p, BaseDeDonnee DB) {
        nom = n;
        partie = p;
        reserve = new Reserve(this);
        plateau = new Plateau(DB, this);
    }

    public void setScore(int s) {
        score = s;
    }

    public void echangerLettre(String l) {
        reserve.remove(l);
        partie.getReserve().ajouterLettre(l);
        reserve.ajouterLettre(partie.getReserve().piocher());
    }

    public void piocher(int i) {
        if(partie.getReserve().size() > 0) {
            for (int j = 0; j < i; j++) {
                reserve.ajouterLettre(partie.getReserve().piocher());
            }
        }
        else {
            System.out.println("Vous ne pouvez pas piocher");
        }
    }

    public boolean jouer(String mot) {
        ArrayList<String> listelettres = new ArrayList<>();
        listelettres.addAll(reserve.getLettres());
        for (int i = 0; i < mot.length(); i++) {
            String curChar = String.valueOf(mot.charAt(i));
            //System.out.println(curChar);
            //System.out.println(listelettres);
            if (curChar.equalsIgnoreCase("/") || curChar == "/") {
                return false;
            } else {
                if (listelettres.contains(curChar.toUpperCase())) {
                    listelettres.remove(curChar);
                } else {
                    return false;
                }
            }
        }
        reserve.setLettre(listelettres);
        if (plateau.ajouterMot(mot)) {
            return true;
        } else {
            return false;
        }
    }

    public void crierJarnac(){
        String choix = null;
        if (choix.equalsIgnoreCase("/jarnac")) {
            System.out.printf("JARNAC !!!");
            String mot = null;
            plateau.ajouterMot(mot);
            reserve.ajouterLettre(partie.getReserve().piocher());
        }
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                '}';
    }

    public Reserve getReserve() {
        return reserve;
    }

    public String getNom() {
        return nom;
    }

    public int getScore() {
        return score;
    }

    public Partie getPartie() {
        return partie;
    }

}