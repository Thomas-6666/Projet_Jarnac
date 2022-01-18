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
    private List<String> voyelles = Arrays.asList("A","E","I","O","U");

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
        //Permet plus tard une vérification
        boolean flag = false;
        //Permet de savoir si le tour est pair ou impair (J1 ou j2)
        int i = 0;

        //Premier tour, les joueurs piochent 6 lettres
        j1.piocher(6);
        //On vérifie qu'il a au moins une voyelle
        while (!j1.getReserve().contains(voyelles)){
            j1.getReserve().clear();
            j1.piocher(6);
        }
        System.out.println("C'est au tour de " + j1.getNom());
        System.out.println("Voici vos lettres:");
        System.out.println(j1.getReserve());
        System.out.println("Lettres restante dans la réserve globale : " + reserve.size());
        System.out.println("Ecrire /jouer pour jouer un mot");
        System.out.println("Ecrire /arreter pour arreter la partie");
        System.out.println("Ecrire /passer pour passer votre tour");
        Scanner in = new Scanner(System.in);
        String choix = in.next();

        //On vérifie ce que le jouer a écrit
        i = verifchoix(choix, i, in);

        //Si la partie n'est pas finie
        if (!fini) {
            System.out.println("J2, veuillez choisir ce que vous allez faire :");
            System.out.println("Pour crier JARNAC : /jarnac");
            System.out.println("Pour jouer : /jouer");
            choix = in.next();

            //Vérification du choix

            while(!choix.equalsIgnoreCase("/jarnac") && (!choix.equalsIgnoreCase("/jouer"))){
                System.out.println("Pour crier JARNAC : /jarnac");
                System.out.println("Pour jouer : /jouer");
                choix = in.next();

                }
            if (choix.equalsIgnoreCase("/jarnac")){
                System.out.println("JARNAC !!!");
            }

            j2.piocher(6);
            //On vérifie qu'il a au moins une voyelle
            while (!j2.getReserve().contains(voyelles)){
                j2.getReserve().clear();
                j2.piocher(6);
            }
            System.out.println("C'est au tour de " + j2.getNom());
            System.out.println("Voici vos lettres:");
            System.out.println(j2.getReserve());
            System.out.println("Lettres restante dans la réserve globale : " + reserve.size());
            System.out.println("Ecrire /jouer pour jouer un mot");
            System.out.println("Ecrire /arreter pour arreter la partie");
            System.out.println("Ecrire /passer pour passer votre tour");
            choix = in.next();

            //On vérfie le choix du joueur
            i = verifchoix(choix, i, in);
        }

        //Boucle pour les autres tours fonctionnant tant que la partie n'est pas finie
        while (!fini) {
            //On regarde si c'est le j1
            if (i % 2 == 0) {
                j1.piocher(1);
                System.out.println("C'est au tour de " + j1.getNom());
                System.out.println("Voici vos lettres:");
                System.out.println(j1.getReserve());
                System.out.println("Lettres restante dans la réserve globale : " + reserve.size());
                System.out.println("Ecrire /jouer pour jouer un mot");
                System.out.println("Ecrire /arreter pour arreter la partie");
                System.out.println("Ecrire /passer pour passer votre tour");
                choix = in.next();

                //On récupère le choix du j1
                i = verifchoix(choix, i, in);
            }

            //On fait jouer le j2
            else {
                j2.piocher(1);
                System.out.println("C'est au tour de " + j2.getNom());
                choix = in.next();
                System.out.println("Voici vos lettres:");
                System.out.println(j2.getReserve());
                System.out.println("Lettres restante dans la réserve globale : " + reserve.size());
                System.out.println("Ecrire /jouer pour jouer un mot");
                System.out.println("Ecrire /arreter pour arreter la partie");
                System.out.println("Ecrire /passer pour passer votre tour");

                //On vérifie le choix du j2
                i = verifchoix(choix, i, in);
            }
        }
    }


    //Fonction qui réalise le choix du joueur
    private int play(Joueur j, Scanner in, String choix, int i) {
        if (choix.equalsIgnoreCase("/jouer")) {
            System.out.println("Pour arrêter la partie, saisir : /arreter");
            System.out.println("Pour passer votre tour, saisir : /passer");
            System.out.println("Saisir le mot à jouer:");
            String mot = in.next();

            //Tant que le mot n'est pas valide
            while (!j.jouer(mot)) {

                //On vérifie s'il souhaite passer ou arreter
                if (mot.equalsIgnoreCase("/arreter")) {
                    System.out.println("Partie arrêtée");
                    arreter(i);
                    return i;
                } else if (mot.equalsIgnoreCase("/passer")) {
                    System.out.println("Vous passez votre tour");
                    i+=1;
                    return i;
                }

                System.out.println("Mot non valable");
                System.out.println("Voici vos lettres:");
                System.out.println(j.getReserve());
                System.out.println("Saisir le mot à jouer:");
                mot = in.next();
            }
        }
        return i;
    }

    public void arreter(int i) {
        System.out.println("La partie est arrêtée");
        if (i % 2 == 0) {
            System.out.println(j2 + " a gagné par forfait");
        }
        else {
            System.out.println(j1 + " a gagné par forfait");
        }

        this.fini = true;
    }

    public Reserve getReserve() {
        return reserve;
    }

    //Cette fonction (on peut changer le nom) permet juste d'alléger le code en l'appelant plutôt qu'en réecrivant son contenu.
    //Elle empêche le joueur d'écrire autre chose que /passer || /jouer || /arreter
    public int verifcase(int i) {
        boolean flag = false;
        while (!flag) {
            System.out.println("Ecrire /jouer pour jouer un mot");
            System.out.println("Ecrire /arreter pour arreter la partie");
            System.out.println("Ecrire /passer pour passer votre tour");
            Scanner in = new Scanner(System.in);
            String choix = in.next();
            if (choix.equalsIgnoreCase("/jouer")) {
                flag = true;
                i = play(j1, in, choix, i);
            } else if (choix.equalsIgnoreCase("/arreter")) {
                flag = true;
                arreter(i);
            } else if (choix.equalsIgnoreCase("/passer")) {
                flag = true;
                System.out.println("Vous passez votre tour");
                i +=1;

            }

        }
        return i;
    }

    //Cette fonction (on peut changer le nom) permet juste d'alléger le code en l'appelant plutôt qu'en réecrivant son contenu.
    //Elle permet de connaître le choix du joueur
    public int verifchoix(String choix, int i, Scanner in) {
        if (choix.equalsIgnoreCase("/jouer")) {
            i = play(j1, in, choix, i);
            i += 1;
        } else if (choix.equalsIgnoreCase("/arreter")) {
            arreter(i);
        } else if (choix.equalsIgnoreCase("/passer")) {
            i += 1;
            System.out.println("Vous passez votre tour");
        }

        //Si le joueur n'a pas écrit /jouer || /passer || /arreter , alors on lui demande de recommencer.
        else {
            i = verifcase(i);
        }
        return i;
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


