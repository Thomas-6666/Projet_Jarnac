package Modele;

import Controlleur.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Partie {
    private Joueur j1;
    private Joueur j2;
    private Reserve reserve;
    private boolean fini;
    private static Partie instance;

    private Partie() {
        fini = false;
        reserve = new Reserve();
        /*
        System.out.println("Nom joueur 1:");
        Scanner in = new Scanner(System.in);

        String j1name = in.next();
        if (j1name.equalsIgnoreCase("ia")){
            j1 = new Ia("IA1");
        } else {
            j1 = new Joueur(j1name);
        }

        System.out.println("Nom joueur 2:");

        String j2name = in.next();
        if (j2name.equalsIgnoreCase("ia")){
            j2 = new Ia("IA2");
        }else {
            j2 = new Joueur(j2name);
        }



        lancer();*/

    }

    public static Partie getInstance(){
        if (instance == null){
            instance = new Partie();
        }
        return instance;
    }

    //constructeur pour test
    public Partie(int i){
        reserve = new Reserve();
        j1 = new Joueur("j1");
        j2 = new Joueur("j2");
    }

    public void lancer() {

        //Permet de savoir si le tour est pair ou impair (J1 ou j2)
        int i = 0;

        //Premier tour, les joueurs piochent 6 lettres
        j1.piocher(10);
        j2.piocher(10);
        Joueur currentPlayer;
        Joueur otherPlayer;

        Controller ctrl = Controller.getInstance();
        ctrl.updateReserve(instance);
        ctrl.updatePoints(instance);

        System.out.println("La partie commence");

        /*while (!fini) {

            if (i % 2 == 0) {
                currentPlayer = j1;
                otherPlayer = j2;
            } else {
                currentPlayer = j2;
                otherPlayer = j1;
            }

            System.out.println("C'est au tour de " + currentPlayer.getNom());
            System.out.println("Lettres : " + currentPlayer.getReserve());
            ctrl.updateReserve(this);
            afficherPlateau(currentPlayer);
            afficherPlateau(otherPlayer);
            if (currentPlayer instanceof  Ia) {
                //jouerIA
                String motJouer = ((Ia) currentPlayer).generateWord();
                if  (!motJouer.equalsIgnoreCase("/passer")){
                    currentPlayer.jouer(motJouer);
                }
                currentPlayer.piocher(1);
                i +=1 ;
            }else{
                play(currentPlayer);
                currentPlayer.piocher(1);
                i += 1;
            }

        }*/

    }

    //Fonction qui réalise le choix du joueur
    public void play(Joueur j) {
        Controller ctrl = Controller.getInstance();
        boolean echange = false;
        boolean flag = false;
        Scanner in = new Scanner(System.in);

        while (!flag) {

            System.out.println("Ecrire /jouer pour créer un mot");
            System.out.println("Ecrire /arreter pour arreter la partie");
            System.out.println("Ecrire /passer pour passer votre tour");
            System.out.println("Ecrire /modif pour modifier un mot");
            if (!echange)
            System.out.println("Ecrire /echange pour echanger 3 lettres");
            System.out.println("Ecrire /jarnac pour voler un mot");
            String choix = in.next();

            if (choix.equalsIgnoreCase("/jouer")) {
                String mot = "";

                jouerLoop:
                while (!j.jouer(mot)) {
                    flag = false;
                    System.out.println("Pour retourner en arrière: /retour");
                    System.out.println("Saisir le mot à jouer:");
                    mot = in.next();

                    if (mot.equalsIgnoreCase("/retour")) {
                        System.out.println("retour");
                        break jouerLoop;
                    }
                    flag = true;

                }

            } else if (choix.equalsIgnoreCase("/arreter")) {
                flag = true;
                arreter(j);
            } else if (choix.equalsIgnoreCase("/passer")) {
                flag = true;
                break;
            } else if (choix.equalsIgnoreCase("/modif")){
                if(modifier(in, j) != -1){
                    flag = true;
                    break;
                }
                flag = false;
            } else if (choix.equalsIgnoreCase("/jarnac")){
                flag = j.crierJarnac();
            } else if (choix.equalsIgnoreCase("/echange") && !echange){
                System.out.println("Quelles sont les lettre à échanger ?");
                System.out.println("/retour");
                String lettres = in.next();
                 if (!lettres.equalsIgnoreCase("/retour")){
                     echange = j.echangerLettre(lettres);
                     System.out.println("echange terminé "+echange);
                 }

            }

        }
        ctrl.updatePoints(instance);
    }


    public void arreter(Joueur j) {
        fini = true;
        if (j == j1){
            System.out.println(j2.getNom()+" à gagner par forfait !");
        } else {
            System.out.println(j1.getNom()+" à gagner par forfait !");
        }
    }

    public Reserve getReserve() {
        return reserve;
    }


    public void annoncerGagnant(){
        fini = true;
        if (j1.getScore() == j2.getScore()){
            System.out.println("Match nul !");
        } else if (j1.getScore() > j2.getScore()){
            System.out.println(j1.getNom() + "à gagner avec: "+j1.getScore() + "points !");
        } else {
            System.out.println(j2.getNom() + "à gagner avec: "+j2.getScore() + "points !");
        }
    }

    public void afficherPlateau(Joueur j){
        Plateau p  = j.getPlateau();
        System.out.println("Plateau de "+j.getNom());
        System.out.println("\t\t\t9\t16\t25\t36\t49\t64\t81");
        for (int i = 0; i < 8; i++){
            StringBuilder line = new StringBuilder("L" + (i + 1) + "\t");
            if (p.getMot().size() > i){
                String mot = p.getMot().get(i);
                for (char lettre : mot.toCharArray()){
                    line.append(lettre).append("\t");
                }
            }
            System.out.println(line);
        }
    }

    public int modifier(Scanner in, Joueur j){
        while (true){
            System.out.println("Donner le numéro de la ligne à modifier");
            System.out.println("Ecrire /retour pour annuler l'action");
            String ligne = in.next();

            if (ligne.equalsIgnoreCase("/retour")){
                return -1;
            }
            try{
                int ligneNb = Integer.parseInt(ligne) - 1;
                String lignePlateau = j.getPlateau().getMot().get(ligneNb);
                for (char lettre : lignePlateau.toCharArray()){
                    j.getReserve().ajouterLettre(String.valueOf(lettre));
                }
                j.getPlateau().getMot().remove(ligneNb);
                String nouveauMot = ".";
                while (!j.jouer(nouveauMot)){
                    System.out.println("Ecrire le nouveau mot");
                    nouveauMot = in.next();
                    if (ligne.equalsIgnoreCase("/retour")){
                        return -1;
                    }
                }
                return ligneNb;
            } catch (Exception e){
                System.out.println("Impossible de modifier cette ligne");
            }
        }

    }

    public boolean getFini(){
        return fini;
    }

    public void setJoueur(Joueur j, int nb){
        if (nb == 1){
            j1 = j;
        } else if (nb == 2){
            j2 = j;
        } else {
            System.out.println("Impossible de changer ce joueur");
        }
    }

    public List<Joueur> getJoueurs(){
        return List.of(j1, j2);
    }
}


