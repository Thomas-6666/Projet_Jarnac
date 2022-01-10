package Modele;

import java.util.Scanner;

public class Partie {
    private Joueur j1;
    private Joueur j2;
    private Reserve reserve;
    private boolean fini;

    public Partie(){
        fini = false;
        System.out.println("Nom joueur 1:");
        Scanner in = new Scanner(System.in);

        String j1name = in.next();
        j1 = new Joueur(j1name, this);

        System.out.println("Nom joueur 2:");

        String j2name = in.next();
        j2 = new Joueur(j2name, this);

        reserve = new Reserve();


        lancer();

    }

    public void lancer(){
        int i = 0;
        j1.getReserve().piocher(6);
        System.out.println("C'est au tour de "+j1.getNom());
        Scanner in = new Scanner(System.in);
        String choix = in.next();
        if (choix.equalsIgnoreCase("jouer")){
            System.out.println("Saisir le mot à jouer:");
            String mot = in.next();
            j1.jouer(mot);
        }

        while(!fini){

        }
    }

    public void arreter(){
        //TODO
    }

    public Reserve getReserve() {
        return reserve;
    }
}
