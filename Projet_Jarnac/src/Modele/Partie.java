package Modele;

import java.util.Scanner;

public class Partie {
    private Joueur j1;
    private Joueur j2;
    private Reserve reserve;

    public Partie(){
        System.out.println("Nom joueur 1: \n");
        Scanner in = new Scanner(System.in);

        String j1name = in.next();
        j1 = new Joueur(j1name, this);

        System.out.println("Nom joueur 2: \n");

        String j2name = in.next();
        j2 = new Joueur(j2name, this);

    }

    public void lancer(){
        //TODO
    }

    public void arreter(){
        //TODO
    }
}
