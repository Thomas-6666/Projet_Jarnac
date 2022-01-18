package Modele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Partie {
    private Joueur j1;
    private Joueur j2;
    private Reserve reserve;
    private boolean fini;

    public Partie() {
        fini = false;
        BaseDeDonnee DB = new BaseDeDonnee();
        System.out.println("Nom joueur 1:");
        Scanner in = new Scanner(System.in);

        String j1name = in.next();
        j1 = new Joueur(j1name, this, DB);

        System.out.println("Nom joueur 2:");

        String j2name = in.next();
        j2 = new Joueur(j2name, this, DB);

        reserve = new Reserve();


        lancer();

    }

    public void lancer() {

        //Permet de savoir si le tour est pair ou impair (J1 ou j2)
        int i = 0;

        //Premier tour, les joueurs piochent 6 lettres
        j1.piocher(6);
        j2.piocher(6);
        Joueur currentPlayer;

        System.out.println("La partie commence");

        while (!fini) {

            if (i % 2 == 0) {
                currentPlayer = j1;
            } else {
                currentPlayer = j2;
            }

            System.out.println("C'est au tour de " + currentPlayer.getNom());
            System.out.println("Lettres : " + currentPlayer.getReserve());
            play(currentPlayer);
            currentPlayer.piocher(1);
            i+=1;

        }

    }

    //Fonction qui réalise le choix du joueur
    private void play(Joueur j) {
        boolean flag = false;
        Scanner in = new Scanner(System.in);

        while (!flag) {

            System.out.println("Ecrire /jouer pour jouer un mot");
            System.out.println("Ecrire /arreter pour arreter la partie");
            System.out.println("Ecrire /passer pour passer votre tour");
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
            }

        }
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

}


