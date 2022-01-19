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

            for (int j = 0; j < i-1; j++) {
                reserve.ajouterLettre(partie.getReserve().piocher());
            }


            //La dernière lettre sera une voyelle ou une consonne selon les besoin

            //La joueur possède des voyelles et consonne donc il pioche au hasard
            if (reserve.containsVoyelle() && reserve.containsConsonne()){
                reserve.ajouterLettre(partie.getReserve().piocher());

            //Le joueur ne possède pas de consonne, Si la réserve commune possède des consonnes alors le joueur aura une consonne. Sinon il aura une lettre au hasard
            }if (reserve.containsVoyelle() && !reserve.containsConsonne()){
                if (partie.getReserve().containsConsonne()){
                    reserve.ajouterLettre(partie.getReserve().piocherConsonne());
                } else {
                    reserve.ajouterLettre(partie.getReserve().piocher());
                }
            //Même chose que précédemment mais pour les voyelles.
            } if (!reserve.containsVoyelle() && reserve.containsConsonne()){
                if (partie.getReserve().containsVoyelle()){
                    reserve.ajouterLettre(partie.getReserve().piocherVoyelle());
                } else {
                    reserve.ajouterLettre(partie.getReserve().piocher());
                }
            }

        }
        else {
            System.out.println("Vous ne pouvez pas piocher");
        }
    }

    public boolean jouer(String mot) {
        mot = mot.toUpperCase();
        ArrayList<String> reserveTemp = new ArrayList<>(reserve.getLettres());
        for (int i = 0; i < mot.length(); i++){
            String lettre = String.valueOf(mot.charAt(i));
            if (reserveTemp.contains(lettre)){
                reserveTemp.remove(lettre);
            } else {
                if (mot.startsWith("/")){
                    System.out.println("Impossible d'éxécuter cette commande");
                } else {
                    System.out.println("Vous n'avez pas les lettres");
                }
                return false;
            }
        }
        if (plateau.ajouterMot(mot)){
            reserve.setLettre(reserveTemp);
            return true;
        } else {
            System.out.println("Le mot n'existe pas");
            return false;
        }
        
    }

    public void crierJarnac(){
        System.out.printf("JARNAC !!!");
        //Joueur choisi une ligne du plateau
        //Si ligne avec un mot, complete le mot et deplace sur son plateau
        //Si ligne vide, place mot sur son plateau
        //pioche dans reserve
        String mot = null;
        plateau.ajouterMot(mot);
        reserve.ajouterLettre(partie.getReserve().piocher());
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

    public Plateau getPlateau() {
        return plateau;
    }
}