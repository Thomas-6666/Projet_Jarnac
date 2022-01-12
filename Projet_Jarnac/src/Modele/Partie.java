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
        int i = 0;
        j1.piocher(6);
        System.out.println("C'est au tour de "+j1.getNom());
        System.out.println("Voici vos lettres:");
        System.out.println(j1.getReserve());
        System.out.println("Ecrire jouer pour jouer un mot ou bien arreter pour stopper la partie ");
        Scanner in = new Scanner(System.in);
        String choix = in.next();
        if (choix.equalsIgnoreCase("jouer")){
            play(j1, in, choix);
            i +=1;
        }
        else if (choix.equalsIgnoreCase("arreter")){
            arreter();
            return;
        }
        j2.piocher(6);
        System.out.println("C'est au tour de "+j2.getNom());
        System.out.println("Voici vos lettres:");
        System.out.println(j2.getReserve());
        System.out.println("Ecrire jouer pour jouer un mot ou bien arreter pour stopper la partie ");
        choix = in.next();
        if (choix.equalsIgnoreCase("jouer")){
            play(j2, in, choix);
            i +=1;
        }
        else if (choix.equalsIgnoreCase("arreter")){
            arreter();
        }
        
        while(!fini){
            if (i %2 ==0){
                j1.piocher(1);
                System.out.println("C'est au tour de "+j1.getNom());
                System.out.println("Voici vos lettres:");
                System.out.println(j1.getReserve());
                System.out.println("Ecrire jouer pour jouer un mot ou bien arreter pour stopper la partie");
                choix = in.next();
                if (choix.equalsIgnoreCase("jouer")){
                    play(j1,in,choix);
                    i +=1;
                }
                else if (choix.equalsIgnoreCase("arreter")){
                    arreter();
                }

            }
            else {
                j2.piocher(1);
                System.out.println("C'est au tour de "+j2.getNom());
                choix = in.next();
                System.out.println("Voici vos lettres:");
                System.out.println(j2.getReserve());
                System.out.println("Ecrire jouer pour jouer un mot ou bien arreter pour stopper la partie");
                if (choix.equalsIgnoreCase("jouer")){
                    play(j2,in,choix);
                    i +=1;
                }
                else if (choix.equalsIgnoreCase("arreter")){
                    arreter();
                }
            }

        }

    }

    private void play(Joueur j, Scanner in, String choix){
        if (choix.equalsIgnoreCase("jouer")) {
            System.out.println("Saisir le mot à jouer:");
            String mot = in.next();
            while (!j.jouer(mot)) {
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
