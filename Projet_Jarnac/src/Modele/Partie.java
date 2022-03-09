package Modele;

import Controlleur.Controller;

import java.util.List;

public class Partie {
    private Joueur j1;
    private Joueur j2;
    private Reserve reserve;
    private boolean fini;
    private static Partie instance;
    private Joueur currentPlayer;
    private boolean firstRound = true;
    private boolean jarnacEnCours = false;

    private Partie() {
        fini = false;
        reserve = new Reserve();

    }

    public static Partie getInstance() {
        if (instance == null) {
            instance = new Partie();
        }
        return instance;
    }

    //constructeur pour test
    public Partie(int i) {
        reserve = new Reserve();
        j1 = new Joueur("j1");
        j2 = new Joueur("j2");
    }

    public boolean isFirstRound() {
        return firstRound;
    }

    public void setFirstRound(boolean firstRound) {
        this.firstRound = firstRound;
    }

    public void setJarnac(boolean bool) {
        jarnacEnCours = bool;
    }

    public boolean isJarnacEnCours() {
        return jarnacEnCours;
    }

    public void lancer() {

        //Premier tour, les joueurs piochent 6 lettres
        j1.piocher(6);
        j2.piocher(6);
        currentPlayer = j1;

        Controller ctrl = Controller.getInstance();
        ctrl.updateReserve(instance);
        ctrl.updatePoints(instance);
        ctrl.updatePlateau();
        ctrl.disable1erTour(true);
        setFirstRound(true);
        j1.setFirstChoice(false);
        j2.setFirstChoice(false);
        fini = false;

        ctrl.disableChampMot(1);
        ctrl.indicateur(1);

        if (currentPlayer instanceof Ia) {
            Ia iaplayer = (Ia) currentPlayer;
            iaplayer.jouerRandom();
        }

    }

    public Joueur getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Joueur currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Reserve getReserve() {
        return reserve;
    }

    public void annoncerGagnant() {
        fini = true;
        if (j1.getScore() == j2.getScore()) {
            System.out.println("Match nul !");
            Controller.getInstance().annonceWinner(j1, j2);
        } else if (j1.getScore() > j2.getScore()) {
            System.out.println(j1.getNom() + "à gagner avec: " + j1.getScore() + "points !");
            Controller.getInstance().annonceWinner(j1, j2);
        } else {
            System.out.println(j2.getNom() + "à gagner avec: " + j2.getScore() + "points !");
            Controller.getInstance().annonceWinner(j2, j1);
        }
    }

    public boolean getFini() {
        return fini;
    }

    public void setJoueur(Joueur j, int nb) {
        if (nb == 1) {
            j1 = j;
        } else if (nb == 2) {
            j2 = j;
        } else {
            System.out.println("Impossible de changer ce joueur");
        }
    }

    public List<Joueur> getJoueurs() {
        return List.of(j1, j2);
    }

    public void setFini(boolean f) {
        this.fini = f;
    }

    public void resetReserve() {
        reserve = new Reserve();
    }
}


