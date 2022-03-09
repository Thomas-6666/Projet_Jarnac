package Modele;

import Controlleur.Controller;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private String nom;
    private int score = 0;
    private Reserve reserve;
    private Partie partie;
    private Plateau plateau;
    private boolean firstChoice = false;

    public Joueur(String n) {
        nom = n;
        partie = Partie.getInstance();
        reserve = new Reserve(this);
        plateau = new Plateau(this);
    }

    public void setScore(int s) {
        score = s;
    }

    public boolean echangerLettre(String l) {
        List<String> lettres = new ArrayList<>();
        l = l.toUpperCase();
        if (l.length() == 3) {
            for (char c : l.toCharArray()) {
                String lettre = String.valueOf(c);
                if (reserve.remove(lettre)) {
                    lettres.add(lettre);
                } else {
                    for (String lettresave : lettres) {
                        System.out.println("erreur ajouts des lettres");
                        reserve.ajouterLettre(lettresave);
                    }
                    return false;
                }
            }
            for (String lettre : lettres) {
                partie.getReserve().ajouterLettre(lettre);
            }
            piocher(3);
            return true;
        }
        return false;
    }

    public void setFirstChoice(boolean firstChoice) {
        this.firstChoice = firstChoice;
    }

    public boolean getFirstChoice() {
        return firstChoice;
    }

    public void piocher(int i) {
        if (partie.getReserve().size() > 0) {

            for (int j = 0; j < i - 1; j++) {
                reserve.ajouterLettre(partie.getReserve().piocher());
            }


            //La dernière lettre sera une voyelle ou une consonne selon les besoin

            //La joueur possède des voyelles et consonne donc il pioche au hasard
            if (reserve.containsVoyelle() && reserve.containsConsonne()) {
                reserve.ajouterLettre(partie.getReserve().piocher());

                //Le joueur ne possède pas de consonne, Si la réserve commune possède des consonnes alors le joueur aura une consonne. Sinon il aura une lettre au hasard
            } else if (reserve.containsVoyelle() && !reserve.containsConsonne()) {
                if (partie.getReserve().containsConsonne()) {
                    reserve.ajouterLettre(partie.getReserve().piocherConsonne());
                } else {
                    reserve.ajouterLettre(partie.getReserve().piocher());
                }
                //Même chose que précédemment mais pour les voyelles.
            } else if (!reserve.containsVoyelle() && reserve.containsConsonne()) {
                if (partie.getReserve().containsVoyelle()) {
                    reserve.ajouterLettre(partie.getReserve().piocherVoyelle());
                } else {
                    reserve.ajouterLettre(partie.getReserve().piocher());
                }
            } else {
                if (partie.getReserve().containsVoyelle()) {
                    reserve.ajouterLettre(partie.getReserve().piocherVoyelle());
                } else {
                    reserve.ajouterLettre(partie.getReserve().piocher());
                }
            }
            Controller.getInstance().updateReserve(partie);

        } else {
            System.out.println("Vous ne pouvez pas piocher");
        }
    }

    public boolean jouer(String mot) {
        mot = mot.toUpperCase();
        ArrayList<String> reserveTemp = new ArrayList<>(reserve.getLettres());
        for (int i = 0; i < mot.length(); i++) {
            String lettre = String.valueOf(mot.charAt(i));
            if (reserveTemp.contains(lettre)) {
                reserveTemp.remove(lettre);
            } else {
                if (mot.startsWith("/")) {
                    System.out.println("Impossible d'éxécuter cette commande");
                }
                return false;
            }
        }
        if (plateau.ajouterMot(mot)) {
            reserve.setLettre(reserveTemp);
            Controller.getInstance().updateReserve(partie);
            Controller.getInstance().updatePlateau();
            Controller.getInstance().updatePoints(partie);
            return true;
        } else {
            System.out.println("Le mot n'existe pas");
            return false;
        }

    }

    public boolean modifier(int l, String m) {
        ArrayList<String> saveMots = new ArrayList<>(getPlateau().getMot());
        ArrayList<String> saveReserve = new ArrayList<>(getReserve().getLettres());
        int ligneNb = l - 1;
        String lignePlateau;
        try {
            lignePlateau = getPlateau().getMot().get(ligneNb);
        } catch (Exception e) {
            lignePlateau = "";
        }
        if (m.length() <= lignePlateau.length()) {
            return false;
        }
        ArrayList<String> lettreLP = stringToArray(lignePlateau);
        ArrayList<String> lettreM = stringToArray(m);
        for (String lettre : lettreLP) {
            if (lettreM.contains(lettre)) {
                lettreM.remove(lettre);
            } else {
                return false;
            }
        }
        for (char lettre : lignePlateau.toCharArray()) {
            getReserve().ajouterLettre(String.valueOf(lettre));
        }
        if (!lignePlateau.equals(""))
            getPlateau().getMot().remove(ligneNb);
        if (jouer(m)) {
            return true;
        } else {
            getPlateau().setMot(saveMots);
            getReserve().setLettre(saveReserve);
            return false;
        }
    }

    private ArrayList<String> stringToArray(String s) {
        ArrayList<String> res = new ArrayList<>();
        for (char c : s.toCharArray()) {
            res.add(String.valueOf(c));
        }
        return res;
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