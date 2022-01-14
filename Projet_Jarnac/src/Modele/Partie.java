package Modele;

import java.util.Scanner;

public class Partie {
    private Joueur j1;
    private Joueur j2;
    private Reserve reserve;
    private boolean fini;

    public Partie(){
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

    public void lancer(){
        int i = 0; //permet de savoir si le tour est pair ou impaire (J1 ou j2)

        //premier tour, les joueurs piochent 6 lettres
        j1.piocher(6);
        System.out.println("C'est au tour de "+j1.getNom());
        System.out.println("Voici vos lettres:");
        System.out.println(j1.getReserve());
        System.out.println("Ecrire /jouer pour jouer un mot");
        System.out.println("Ecrire /arreter pour arreter la partie");
        System.out.println("Ecrire /passer pour passer votre tour");
        Scanner in = new Scanner(System.in);
        String choix = in.next();
        if (choix.equalsIgnoreCase("/jouer")){
            play(j1, in, choix);
            i +=1;
        }
        else if (choix.equalsIgnoreCase("/arreter")){
            arreter();
            return;
        }

        else if (choix.equalsIgnoreCase("/passer")){
            i = i+1;
            System.out.println("Vous passez votre tour");
        }
        else {
            while (!choix.equalsIgnoreCase("/jouer") || !choix.equalsIgnoreCase("/passer") || !choix.equalsIgnoreCase("/arreter")) {
                System.out.println(choix);
                System.out.println("Ecrire /jouer pour jouer un mot");
                System.out.println("Ecrire /arreter pour arreter la partie");
                System.out.println("Ecrire /passer pour passer votre tour");
                choix = in.next();
            }
            if (choix.equalsIgnoreCase("/jouer")) {
                play(j1, in, choix);
                i += 1;
            } else if (choix.equalsIgnoreCase("/arreter")) {
                arreter();
                return;
            } else if (choix.equalsIgnoreCase("/passer")) {
                i = i + 1;
                System.out.println("Vous passez votre tour");

            }
        }

        if (!fini){
            j2.piocher(6);
            System.out.println("C'est au tour de "+j2.getNom());
            System.out.println("Voici vos lettres:");
            System.out.println(j2.getReserve());
            System.out.println("Ecrire /jouer pour jouer un mot");
            System.out.println("Ecrire /arreter pour arreter la partie");
            System.out.println("Ecrire /passer pour passer votre tour");
            choix = in.next();
            if (choix.equalsIgnoreCase("/jouer")){
                play(j2, in, choix);
                i +=1;
            }
            else if (choix.equalsIgnoreCase("/arreter")){
                arreter();
            }
            else if (choix.equalsIgnoreCase("/passer")){
                i = i+1;
                System.out.println("Vous passez votre tour");
            }
        }

        //boucle pour les autres tours
        while(!fini){
            if (i %2 ==0){
                j1.piocher(1);
                System.out.println("C'est au tour de "+j1.getNom());
                System.out.println("Voici vos lettres:");
                System.out.println(j1.getReserve());
                System.out.println("Ecrire /jouer pour jouer un mot");
                System.out.println("Ecrire /arreter pour arreter la partie");
                System.out.println("Ecrire /passer pour passer votre tour");
                choix = in.next();
                if (choix.equalsIgnoreCase("/jouer")){
                    play(j1,in,choix);
                    i +=1;
                }
                else if (choix.equalsIgnoreCase("/arreter")){
                    arreter();
                }
                else if (choix.equalsIgnoreCase("/passer")){
                    i = i+1;
                    System.out.println("Vous passez votre tour");
                }

            }
            else {
                j2.piocher(1);
                System.out.println("C'est au tour de "+j2.getNom());
                choix = in.next();
                System.out.println("Voici vos lettres:");
                System.out.println(j2.getReserve());
                System.out.println("Ecrire /jouer pour jouer un mot");
                System.out.println("Ecrire /arreter pour arreter la partie");
                System.out.println("Ecrire /passer pour passer votre tour");
                if (choix.equalsIgnoreCase("/jouer")){
                    play(j2,in,choix);
                    i +=1;
                }
                else if (choix.equalsIgnoreCase("/arreter")){
                    arreter();
                }
                else if (choix.equalsIgnoreCase("/passer")){
                    i = i+1;
                    System.out.println("Vous passez votre tour");
                }
            }

        }

    }


    //fonction qui réalise le choix du joueur
    private void play(Joueur j, Scanner in, String choix){
        if (choix.equalsIgnoreCase("/jouer")) {
            System.out.println("Pour arrêter la partie, saisir : /arreter");
            System.out.println("Pour passer votre tour, saisir : /passer");
            System.out.println("Saisir le mot à jouer:");
            String mot = in.next();
            while (!j.jouer(mot)) {

                if (mot.equalsIgnoreCase("/arreter")) {
                    System.out.println("Partie arrêtée");
                    arreter();
                    return;
                }

                else if (mot.equalsIgnoreCase("/passer")){
                    System.out.println("Vous passez votre tour");
                    return;
                }

                System.out.println("Mot non valable");
                System.out.println("Voici vos lettres:");
                System.out.println(j.getReserve());
                System.out.println("Saisir le mot à jouer:");
                mot = in.next();
            }
        }
    }

    public void arreter(){
        this.fini = true;
    }

    public Reserve getReserve() {
        return reserve;
    }
}
